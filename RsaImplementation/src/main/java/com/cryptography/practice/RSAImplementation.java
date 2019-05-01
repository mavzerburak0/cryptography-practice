package com.cryptography.practice;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSAImplementation {

    // A key pair is generated
    private KeyPair keys = KeyPairGenerator.getInstance("RSA").generateKeyPair();
    private Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");


    // Default constructor
    public RSAImplementation() throws NoSuchAlgorithmException, NoSuchPaddingException {
    }

    // This method encrypts the given string using the public key
    public byte[] encrypt(String data) throws
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, keys.getPublic());
        byte[] encrypted = cipher.doFinal(data.getBytes());
        return encrypted;
    }

    // This method decrypts the given string using the private key
    public String decrypt(byte[] encryptedData) throws
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, keys.getPrivate());
        String decrypted = new String(cipher.doFinal(encryptedData));
        return decrypted;
    }


}
