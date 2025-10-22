import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidationTest {

    @Test
    void testValidateEmail_ValidEmail() {
        List<String> emails = new ArrayList<>();
        emails.add("USER@MAIL.COM");
        emails.add("ramy.gomaa_21@mail.co");
        emails.add("user@mail.company.com");
        emails.add("user@example.com ");



      for (String email : emails) {
            boolean result = UserValidation.validateEmail(email.toLowerCase());

            assertTrue(result, "Expected true for valid email: " + email.toLowerCase());


        }
    }

    @Test
    public void testInvalidEmails() {
        List<String> emails = new ArrayList<>();
        emails.add("None");
        emails.add("``");
        emails.add("user name@mail.com");
        emails.add("user@mail.c ");
        emails.add( "user@");
        emails.add( "userexample.com");

        for (String email : emails) {
            boolean result = UserValidation.validateEmail(email);
            assertFalse(result, "Expected false for invalid email: " + email);
        }
    }

    @Test
    void testValidateUsername_Valid() {
        List<String> Users = new ArrayList<>();
        Users.add("ramy123");
        Users.add("ramy_gomaa");
        for (String user : Users) {
            boolean result = UserValidation.validateUsername(user);
            assertTrue(result, "Expected true for valid User Name : " + user);
        }
    }




    @Test
    void testValidateUsername_InvalidsUsername() {
        List<String> Users = new ArrayList<>();
        Users.add("ab");
        Users.add("amygomaaisaverylongusernam\n" +
                " e ");
        Users.add("``");
        Users.add(null);
        Users.add("ramy gomaa ");
        Users.add("ramy@123");
        for (String user : Users) {
            boolean result = UserValidation.validateUsername(user);
            assertFalse(result, "Expected false for Invalid User Name : " + user);
        }


    }
    @Test
    void testValidatePhoneNumber_ValidLocal() {
     List<String>phone = new ArrayList<>();
     phone.add("201234567890");
        phone.add("201012345678");
        phone.add("01555555555");
        phone.add("01198765432");
        phone.add("01234567890");
        phone.add("01012345678");

        for (String ph : phone) {
            boolean result = UserValidation.validatePhoneNumber(ph);

            assertTrue(result, "Expected true for valid phone number: " + ph);
        }

    }




    @Test
    void testValidatePhoneNumber_InvalidPrefix() {
      List<String> phone = new ArrayList<>();
        phone.add("01012abc678");
        phone.add("010123456789");
        phone.add("0101234567");
        phone.add("01812345678");
        phone.add("''");
        phone.add(null);
        for (String ph : phone) {
            boolean result = UserValidation.validatePhoneNumber(ph);

            assertFalse(result, "Expected false for invalid phone number: " + ph);
        }

    }

    @Test
    void testValidateNationalId_Valid() {

        String nationalId = "29812251234567";


        boolean result = UserValidation.validateNationalId(nationalId);


        assertTrue(result);
    }

    @Test
    void testValidateNationalId_InvalidLength() {
List<String> nationalId = new ArrayList<>();
nationalId.add("29812380034567  ");
nationalId.add("29812323234567 ");
        nationalId.add("29813251234567  ");

        nationalId.add("19812251234567  ");

        nationalId.add("2981225AB34567 ");

        nationalId.add("298122512345678 ");

        nationalId.add("2981225123456");

        nationalId.add("");

        nationalId.add(null);

        for (String id : nationalId) {
            boolean result = UserValidation.validateNationalId(id);
            assertFalse(result, "Expected false for invalid length national ID: " + id);
        }

    }

    @Test
    void testValidateNationalId_InvalidDate() {

        String nationalId = "29913350102345"; // Month 13 is invalid


        boolean result = UserValidation.validateNationalId(nationalId);


        assertFalse(result);
    }
}
