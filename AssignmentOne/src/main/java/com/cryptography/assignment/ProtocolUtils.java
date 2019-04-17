package com.cryptography.assignment;


import java.io.*;

public class ProtocolUtils {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private byte[] bytes;

    /**
     *
     * Converts a byte array to hex string.
     *
     * @param bytes
     * @return
     */

    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     *
     * Writes the converted hex string into a file named cipher.txt.
     *
     * @param str String to be written to file.
     * @throws IOException
     */

    public void writeToFile(String str) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/cipher.txt"));
        writer.write(str);
        writer.close();

    }

    public String readFromFile(String path) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String hex = reader.readLine();

        return hex;

    }

    /**
     *
     * Converts the decrypted hex string back to byte array.
     *
     * @param decrypted Decrypted hex string
     * @return
     */


    public byte[] hexToByteArray(String decrypted) {

        bytes = new byte[decrypted.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(decrypted.substring(index, index + 2), 16);
            bytes[i] = (byte) j;
        }

        return bytes;

    }


    public void saveFile(byte[] bytes, String path) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);
        fos.write(bytes);
        fos.close();

    }

}

