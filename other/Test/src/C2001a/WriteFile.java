package C2001a;
import java.io.*;
public class WriteFile {

	public static void main(String[] args) {
		try{
			//System.console().wr
			File file = new File("res/scores" + ".txt");
			if(file.exists()){
				//file.delete();
				System.out.println("File already exists");
				return;
			}
			PrintWriter output = new PrintWriter(file);
			output.println("COSC 121 Top Students");
			output.print("Patrick ");
			output.println("99");
			output.print("Han ");
			output.println("98");
			output.close();
			System.out.println("Wrote to file");
			
			
		}
		catch(Exception brett){
			System.out.println(brett);
		}

	}

}
