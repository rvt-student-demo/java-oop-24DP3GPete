package rvt;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isValidName(String name) {
        return Pattern.matches("^[A-ZĀČĒĢĪĶĻŅŠŪŽ][a-zāčēģīķļņšūž]{2,}$", name);
    }

    public static boolean isValidEmail(String email) {
        return Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email);
    }

    public static boolean isValidPersKods(String pk) {
        return Pattern.matches("^\\d{6}-\\d{5}$", pk);
    }
}