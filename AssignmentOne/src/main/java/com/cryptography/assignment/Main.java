package com.cryptography.assignment;

/**
 *
 * Image encryption-decryption program written for
 * Tallinn University of Technology Cryptography class by Kadir Burak Mavzer
 *
 */


import javax.crypto.*;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException,
            NoSuchAlgorithmException {

        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();
        ImageProcessor imageProcessor = new ImageProcessor();

        // Key generation for encryption and decryption
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the path of the image to be encrypted: ");
        String path = reader.nextLine();

        // Image is converted into byte array
        byte[] converted = imageProcessor.convertImage(path);

        System.out.println("Encrypting...");

        // Also converts the byte array into hex string
        // saves the string to cipher.txt in src/main/resources
        byte[] encrypted = encryptDecrypt.encryptImage(key, converted);

        // Checking if encryption was successful, should evaluate to false
        System.out.println(converted == encrypted);

        System.out.println("Image encrypted. Resulting hex string is saved to cipher.txt.");
        System.out.println();
        System.out.println("Decrypting...");

        // Decryption
        byte[] decrypted = encryptDecrypt.decryptImage(key, encrypted);
        System.out.println("Cipher.txt decrypted. Image is saved to output.jpg.");


    }

}
