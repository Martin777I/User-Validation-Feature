import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserValidation {

    public static boolean validateEmail(String email) {


        if (email == null) return false;
        email = email.trim();
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,63}$";
        return email.matches(regex);
    }


    public static boolean validateUsername(String username) {
        if (username == null) return false;
        String regex = "^[A-Za-z0-9_]{3,20}$";
        return username.matches(regex);
    }

    public static boolean validatePhoneNumber(String phone) {
        if (phone == null) return false;
        String regex = "^(?:\\+?20)?0?(10|11|12|15)\\d{8}$";
        return phone.matches(regex);
    }

    public static boolean validateNationalId(String nationalId) {
        if (nationalId == null || !nationalId.matches("\\d{14}")) return false;

        try {
            String century = nationalId.substring(0, 1);
            String year = nationalId.substring(1, 3);
            String month = nationalId.substring(3, 5);
            String day = nationalId.substring(5, 7);

            int yearFull = (century.equals("2") ? 1900 : 2000) + Integer.parseInt(year);

            String dateStr = String.format("%04d-%02d-%02d", yearFull, Integer.parseInt(month), Integer.parseInt(day));
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            int governorate = Integer.parseInt(nationalId.substring(7, 9));
            if (governorate < 1 || governorate > 88) return false;

            return true;
        } catch (DateTimeParseException | NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
