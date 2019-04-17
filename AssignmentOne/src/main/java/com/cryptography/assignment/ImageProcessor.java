package com.cryptography.assignment;

import java.io.*;

public class ImageProcessor {


    /**
     *
     * Converts an image to a byte array
     *
     * @param path Path to image
     * @return
     * @throws IOException
     */
    public byte[] convertImage (String path) throws IOException {


        File f = new File(path);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }

        // Create the byte array to store the image bytes

        byte[] content = null;
        try {
            content = new byte[is.available()];
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            is.read(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;

    }




}
