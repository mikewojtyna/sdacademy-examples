package pl.sdacademy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class SaveUserInput {
	public static void main(String[] args) {
		String outputPath = "files" + File.separator + "destFile.txt";
		String userText = getStringFromUser();

		RandomAccessFile outputFile = null;
		try {
			outputFile = new RandomAccessFile(outputPath, "rw");
			outputFile.setLength(0); //oppositely to FileWriter (classic stream), writes in new IO does
			// not clear the contents of the file. Need to set its length to 0 to be overwritten by
			// following actions
			//outputFile.seek(outputFile.length()); //works like append mode in classic io - set pointer to
                    // the end of file
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		FileChannel outChannel = outputFile.getChannel(); //create a channel from output file
		ByteBuffer outBufor = ByteBuffer.allocate(48); //create buffer for output file

		try {
			char[] charArr = userText.toCharArray(); //convert String to char array - we will add one
			// char at a time to the buffer
			int buffIdx = 0;
			for (int i = 0; i < charArr.length; i++) { //this loop is for iterating each character in an
				// array
				if (buffIdx < 48) { //we need to check if we do not overflow the buffer, can put new
					// elements when buffIdx is lower than its size (48)
					outBufor.put((byte) charArr[i]);
					buffIdx++;
				}
				else { //...otherwise, we need to flush the buffer to the file
					outBufor.flip(); //first we reset its internal pointer to the beginning of
					// the buffer
					outChannel.write(outBufor); //next, we write buffer contents to filechannel
					outBufor.clear(); //then, we can safely delete out buffer contents
					buffIdx = 0;
				}
			}
			if(outBufor.hasRemaining()) { //last buffer can be not fulfilled to the edge (it can contain
				// less data than its size, then we won't execute "else" from previous if-else
				// statement in the for loop), then we need to do one additional write to the file
				outBufor.flip();
				outChannel.write(outBufor);
				outBufor.clear();
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				outputFile.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getStringFromUser() { //this private method "hermetizates" instructions for getting
		// String from a user
		Scanner scanner = new Scanner(System.in);
		StringBuilder fullText = new StringBuilder();

		System.out.println("Podaj tekst do zapisu, exit konczy zapis");

		String napis = scanner.nextLine();
		while (!napis.equals("exit")) {
			fullText.append(napis);
			fullText.append(System.lineSeparator());
			napis = scanner.nextLine();
		}

		return fullText.toString();
	}
}
