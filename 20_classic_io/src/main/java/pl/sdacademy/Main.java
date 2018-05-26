package pl.sdacademy;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        String thisLine;
        BufferedReader br = null;
        BufferedWriter bw = null;

        String inputPath = "files" + File.separator + "sourceFile.txt";
        String outputPath = "files" + File.separator + "destFile.txt";

        try {
            br = new BufferedReader(new FileReader(inputPath));
            bw = new BufferedWriter(new FileWriter(outputPath, true));
            while ((thisLine = br.readLine()) != null) {
                System.out.println(thisLine);
                bw.append(thisLine + System.lineSeparator());
            }
        }
        catch (IOException e) {
            System.err.println("Error: " + e);
        }
        finally {
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.close();
            }
        }

    }
}
