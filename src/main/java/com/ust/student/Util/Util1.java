package com.ust.student.Util;
import com.ust.student.Exception.InvalidEmail;
import com.ust.student.Exception.InvalidPassword;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The type Util 1.
 */
public class Util1 {


    /**
     * Get sha byte [ ].
     *
     * @param password the password
     * @return the byte [ ]
     */
    public static byte[] getSHA(String password) {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(password.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * To hex string string.
     *
     * @param sha the sha
     * @return the string
     */
    public static String toHexString(byte[] sha) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, sha);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();

    }

    /**
     * Validate email int.
     *
     * @param email the email
     * @return the int
     */
    public static int validateEmail(String email) {
        String regex = "^([A-Za-z0-9+_.-]+)@([A-Za-z0-9]+)\\.([a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches() == true) {
            return 0;
        } else {
            throw new InvalidEmail();
        }
    }

    /**
     * Validate password int.
     *
     * @param password the password
     * @return the int
     */
    public static int validatePassword(String password){
            String regexPassword =  "^(?=(?:.*\\d){3,})(?=\\S+$)(?=.*[@#$%^&+=])(?=(?:.*[A-Za-z]){3,})(?=.*[A-Z]).{8,}$";
            Pattern pattern = Pattern.compile(regexPassword);
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches() == true) {
                return 0;
            } else {
                throw new InvalidPassword();
            }
        }


    }

