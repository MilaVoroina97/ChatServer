package common.json.bodymessage;

import common.json.serializer.JsonSerializer;
import common.json.serializer.MessageFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class BodyMessageJsonSerializerTest {

    private JsonSerializer<BodyMessage> jsonSerializer;
    private BodyMessage bodyMessage;

    @Before
    public void setUp() throws Exception {
        jsonSerializer = new BodyMessageJsonSerializer();
        bodyMessage = MessageFactory.createBodyMessage("MESSAGE", "alex", "hello", "127.0.0.1", 60000);
    }

    @Test
    public void testSerialize() throws Exception {
        String result = jsonSerializer.serialize(bodyMessage);
        Assert.assertEquals(result, "{\"command\":\"MESSAGE\",\"nickname\":\"alex\",\"text\":\"hello\",\"ip\":\"127.0.0.1\",\"port\":60000}");
    }

    @Test
    public void testDeserialize() throws Exception {
        String object = "{\"command\":\"MESSAGE\",\"nickname\":\"alex\",\"text\":\"hello\",\"ip\":\"127.0.0.1\",\"port\":60000}";

        BodyMessage bodyMessageNew = jsonSerializer.deserialize(object);

        Assert.assertEquals(bodyMessage.getCommand(), bodyMessageNew.getCommand());
        Assert.assertEquals(bodyMessage.getNickname(), bodyMessageNew.getNickname());
        Assert.assertEquals(bodyMessage.getIp(), bodyMessageNew.getIp());
        Assert.assertEquals(bodyMessage.getText(), bodyMessageNew.getText());
        Assert.assertEquals(bodyMessage.getPort(), bodyMessageNew.getPort());
    }
}
