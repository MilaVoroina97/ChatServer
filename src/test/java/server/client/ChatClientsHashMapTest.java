package server.client;

import junit.framework.Assert;
import org.junit.Test;

public class ChatClientsHashMapTest {

    @Test
    //after cleaning the collection, its size should be 0
    public void testClear_AddOneClear_SizeZeroReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex","",0));

        chatClients.clear();

        Assert.assertEquals(chatClients.countUsers(), 0);
    }

    @Test
    public void testRemoveUser_AddOneRemoveOne_SizeZeroReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex", "", 0));

        chatClients.removeUser("Alex");

        Assert.assertEquals(chatClients.countUsers(), 0);
    }

    @Test
    public void testAddUser_One_SizeOneReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex","",0));

        Assert.assertEquals(chatClients.countUsers(), 1);
    }

    @Test
    public void testContainsUser_Alex_TrueReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex", "", 0));

        Boolean result = chatClients.containsUser("Alex");

        Assert.assertTrue(result);
    }

    @Test
    public void testContainsUser_abc_TrueReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex", "", 0));

        Assert.assertFalse(chatClients.containsUser("abc"));
    }

    @Test
    public void testGetUser_Alex_TrueReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex", "", 0));

        ChatClient chatClient = chatClients.getUser("Alex");

        Assert.assertNotNull(chatClient);
    }

    @Test
    public void testGetUser_abc_TrueReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();
        chatClients.addUser(new ChatClient("Alex", "", 0));

        ChatClient chatClient = chatClients.getUser("abc");

        Assert.assertNull(chatClient);
    }

    @Test
    public void testGetCountUser_Default_SizeZeroReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();

        Assert.assertEquals(chatClients.countUsers(), 0);
    }

    @Test
    // the size of the object itself and the returned collection must be the same
    public void testGetUsers_EqualSizes_TrueReturned() throws Exception {
        ChatInterface chatClients = new ChatClientsHashMap();

        Assert.assertEquals(chatClients.countUsers(), chatClients.getAllUsers().size());
    }
}
