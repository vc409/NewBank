package newbank.server.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NewBankTest {

    private NewBank bank = new NewBank();

    private String testUserId = "testUser";
    private String existingUser = "bhagy";
    private String customerType = "customer";
    private String bankerType = "banker";
    private String invalidType = "invalid";
    private String failedMessage = "Failed to create user - user with user id " + existingUser + " already exists";

    @Test
    public void testSuccessfulCreateNewUserCustomer() {
        bank.createNewUser(testUserId, customerType);

        assertTrue(bank.getBankUsers().userExists(testUserId));
        assertEquals(bank.getBankUsers().getUser(testUserId).getUserType(), customerType);
    }
    @Test
    public void testSuccessfulCreateNewUserBanker() {
        bank.createNewUser(testUserId, bankerType);

        assertTrue(bank.getBankUsers().userExists(testUserId));
        assertEquals(bank.getBankUsers().getUser(testUserId).getUserType(), bankerType);
    }

    @Test
    public void testFailedCreateNewUserInvalidUserId() {
        assertEquals(bank.createNewUser(existingUser, bankerType), failedMessage);
    }

    @Test
    public void testFailedCreateNewUserInvalidUserType() {
        bank.createNewUser(testUserId, invalidType);

        assertFalse(bank.getBankUsers().userExists(testUserId));
    }

}