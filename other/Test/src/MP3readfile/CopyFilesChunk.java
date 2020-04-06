package MP3readfile;

import java.io.*;

/**
 * Copy one file to another using low level byte streams, one byte at a time.
 * @author www.codejava.net
 */
public class CopyFilesChunk {
    private static final int BUFFER_SIZE = 4096; // 4KB
 
    public static void main(String[] args) {
        String inputFile = "1.mp3";
        String outputFile = "2.mp3";
        long s = System.currentTimeMillis();
        try (
            InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(outputFile);
        ) {
 
            byte[] buffer = new byte[BUFFER_SIZE];
 
            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
            }
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        long f = System.currentTimeMillis();
        System.out.println("END time in milleseconds : " + (f-s));
    }
}