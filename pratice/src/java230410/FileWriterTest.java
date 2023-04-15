package java230410;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = "";
		FileWriter fw = null;
		int i = 0;
		try {
			fw = new FileWriter("c:\\Temp\\diary230410.txt");
			while (true) {
				str = scan.nextLine();
				if (str.equals("n")) {
					break;
				}
				str = str + "\n";
				fw.write(str);
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
