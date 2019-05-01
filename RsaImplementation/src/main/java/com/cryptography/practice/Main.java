/**
 *
 * This small application is written by Kadir Burak Mavzer
 * to demonstrate RSA algorithm for Cryptography course in TalTech.
 *
 * It accepts a string as input and effectively encrypts and
 * decrypts the given string using RSA algorithm.
 *
 *
 * The size of the input is restricted to 245 bytes.
 *
 */



package com.cryptography.practice;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IllegalBlockSizeException,
            InvalidKeyException,
            BadPaddingException,
            NoSuchAlgorithmException,
            NoSuchPaddingException {

        // Creating an instance of the class
        RSAImplementation rsa = new RSAImplementation();
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to encrypt?");
        String user_input = sc.nextLine();

        byte[] encrypted = rsa.encrypt(user_input);
        String s = new String(encrypted);

        System.out.println("Encrypted: ");
        System.out.println(s);
        System.out.println("Decrypted: ");
        System.out.println(rsa.decrypt(encrypted));

    }

}
