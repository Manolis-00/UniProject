package com.project.util;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptionUtil { //TODO - Integration test.

    static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * To be used, before a password is stored to the database.
     *
     * @param password
     * @return
     */
    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * On the Authentication of a User, take the provided password, and the respective hashedPassword from the db and
     * check that the password is correct.
     *
     * @param rawPassword The password provided by the user upon login.
     * @param encodedPassword The hashedPassword that resides in the database.
     * @return
     */
    public static boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
