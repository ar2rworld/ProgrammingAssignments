package C2001a;
import java.io.*;
import java.util.Scanner;
public class ReadFile {

	public static void main(String[] args) {
		try{
			readDataFile("res/NHLPointLeaders.txt");
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}

	}

	public static void readDataFile(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		System.out.println("file exists? " + file.exists());
		Scanner input = new Scanner(file);
		while(input.hasNext()){
			String first = input.next();
			String last = input.next();
			int points = input.nextInt();
			int games = input.nextInt();
			double ppg = (double)points/games;
			System.out.println(first + " " + last + "\t" + points + " points in " + games + " games ->" + ppg);
		}
		input.close();
		
	}
}
