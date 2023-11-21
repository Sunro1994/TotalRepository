package com.TravelMaker.component;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
public class HashComponent {

    public String getRandomSalt() {
        String salt = UUID.randomUUID().toString().substring(0, 8);
        return salt;
    }

    public String getHash(String source, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            md.update(source.getBytes());


            String hash = String.format("%0128X", new BigInteger(1, md.digest()));


            return hash;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
