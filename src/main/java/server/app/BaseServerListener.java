package server.app;

import common.listener.BaseListener;
import common.listener.Listener;
import common.stream.StreamIO;
import common.transport.TransportConnection;
import common.transport.TransportFactory;
import server.handler.MessageQueue;

import java.io.IOException;

/**
 * Derived class representing a listener for a server application.
 * Implements the Listener interface and extends the BaseListener class.
 */
public class BaseServerListener extends BaseListener implements Listener {

    MessageQueue<TransportConnection> requestQueue;

    /**
     * Constructor for BaseServerListener.
     *
     * @param portIn The port number on which the listener will accept connections.
     * @param streamIO The StreamIO object for input/output operations.
     * @param transportFactory The TransportFactory for creating TransportConnections.
     * @param requestQueue The queue for storing incoming TransportConnections.
     */
    public BaseServerListener(int portIn, StreamIO streamIO, TransportFactory transportFactory,
                              MessageQueue<TransportConnection> requestQueue) {
        super(portIn, streamIO, transportFactory);
        this.requestQueue = requestQueue;
    }

    /**
     * Worker method for the listener.
     *
     * Accepts incoming connections and adds them to the request queue for processing.
     * @throws IOException if an I/O error occurs during connection acceptance.
     */
    @Override
    protected void worker() throws IOException {

        requestQueue.add(transportListener.accept());
    }
}
