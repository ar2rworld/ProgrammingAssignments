package MP3readfile;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MP3 {

	public static void main(String[] args) {
		String s = "";
		try {
		File f = new File("C:\\Users\\Artur\\Music\\AC DC\\187-ac_dc-back_in_black_(zvukoff.ru).mp3");
		Scanner inp = new Scanner(f);
		System.out.println("file exist? " + f.exists());
		while(inp.hasNext()) {
			String currentS = inp.next();
			System.out.println(currentS);
			s += currentS;
		}
		File fC = new File("1.mp3");
		PrintWriter out = new PrintWriter(fC);
		out.write(s);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
