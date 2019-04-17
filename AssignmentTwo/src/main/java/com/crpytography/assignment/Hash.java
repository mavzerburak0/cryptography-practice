package com.crpytography.assignment;

import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class Hash {

    // Salt that will be added to the beginning of string to be hashed
    private String salt = "th1s1s4s4lt";

    // For execution time measurement
    long startTime, endTime, timeElapsed;


    public String md5Hashing(String pass) throws NoSuchAlgorithmException {
        startTime = System.nanoTime();

        MessageDigest digest = MessageDigest.getInstance("md5");

        String salted = salt+pass;

        digest.update(salted.getBytes(), 0, salted.length());

        String hash = new BigInteger(1, digest.digest()).toString(16);

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Execution time for md5 in nanoseconds: " + timeElapsed);

        return hash;
    }

    public String sha1Hashing(String pass) throws NoSuchAlgorithmException {

        startTime = System.nanoTime();

        MessageDigest digest = MessageDigest.getInstance("sha1");

        String salted = salt+pass;

        digest.update(salted.getBytes(), 0, salted.length());

        String hash = new BigInteger(1, digest.digest()).toString(16);


        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Execution time for sha1 in nanoseconds: " + timeElapsed);


        return hash;
    }

    public String sha256Hashing(String pass) throws NoSuchAlgorithmException {

        startTime = System.nanoTime();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        String salted = salt+pass;

        digest.update(salted.getBytes(), 0, salted.length());

        String hash = new BigInteger(1, digest.digest()).toString(16);

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;

        System.out.println("Execution time for sha-256 in nanoseconds: " + timeElapsed);

        return hash;
    }

}
