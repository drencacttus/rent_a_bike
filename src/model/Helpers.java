package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Helpers {
    
    public static String getPasswordHash(String text) {
    
        try {
            
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(text.getBytes());
            byte[] hashBytes = messageDigest.digest();
            
            return String.format("%064x", new java.math.BigInteger(1, hashBytes));
        } 
        catch (NoSuchAlgorithmException ex) {

            return "";
        }
    }
}
