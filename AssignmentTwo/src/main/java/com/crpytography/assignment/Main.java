package com.crpytography.assignment;

/**
 *
 * This small program is written by Kadir Burak Mavzer for Cryptography class
 * assignment at Taltech.
 * It is a demonstration of how to hash a string with three different algorithms
 * namely md5, sha1 and sha256 and also it also measures their execution time.
 *
 */


import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Hash hashing = new Hash();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string to hash with salt: ");
        String input = sc.nextLine();
        String hashed = hashing.md5Hashing(input);
        System.out.println("Hashed with md5: " + hashed);
        System.out.println();
        hashed = hashing.sha1Hashing(input);
        System.out.println("Hashed with sha1: " + hashed);
        System.out.println();
        hashed = hashing.sha256Hashing("Hashed with sha-256: " + input);
        System.out.println(hashed);
    }
}
