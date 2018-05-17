package pl.sdacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) {
        String inputPath = "files" + File.separator + "sourceFile.txt";
        String outputPath = "files" + File.separator + "destFile.txt";

        RandomAccessFile inputFile = null;
        RandomAccessFile outputFile = null;
        try {
            inputFile = new RandomAccessFile(inputPath, "r");
            outputFile = new RandomAccessFile(outputPath, "rw");
            outputFile.seek(outputFile.length()); //works like append mode in classic io - set pointer to the end of file
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileChannel inChannel = inputFile.getChannel();
        FileChannel outChannel = outputFile.getChannel();

        ByteBuffer inBufor = ByteBuffer.allocate(48);
        ByteBuffer outBufor = ByteBuffer.allocate(48);

        int bytesRead = 0;
        try {
            bytesRead = inChannel.read(inBufor);

            while (bytesRead != -1) {

                System.out.println("\n ##Przeczytałem " + bytesRead + " bajtów ## \n");
                inBufor.flip();


                while (inBufor.hasRemaining()) {
                    byte znak = inBufor.get();
                    System.out.print((char) znak);
                    outBufor.put(znak);
                }

                inBufor.clear();
                bytesRead = inChannel.read(inBufor);

                outBufor.flip();
                outChannel.write(outBufor);
                outBufor.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputFile.close();
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
