package com.ust.student.Util;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Util1 {


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
}
