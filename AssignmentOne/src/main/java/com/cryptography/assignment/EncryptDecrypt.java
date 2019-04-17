package com.cryptography.assignment;

import javax.crypto.*;
import java.security.Key;

public class EncryptDecrypt {


    private ProtocolUtils protocolUtils = new ProtocolUtils();


    /**
     *
     * Encrypt
     *
     * @param key Secret key to encrypt
     * @param content The image file byte array
     * @return
     */

    public byte[] encryptImage(Key key, byte[] content) {

        Cipher cipher;
        byte[] encrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypted = cipher.doFinal(content);
            protocolUtils.saveFile(encrypted, "src/main/resources/encrypted");
            String hex = protocolUtils.bytesToHex(encrypted);

            protocolUtils.writeToFile(hex);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;

    }


    public byte[] decryptImage(Key key, byte[] encryptedText) {

        Cipher cipher;
        byte[] decrypted = null;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            decrypted = cipher.doFinal(encryptedText);
            protocolUtils.saveFile(decrypted, "src/main/resources/decrypted/output.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decrypted;

    }


}

