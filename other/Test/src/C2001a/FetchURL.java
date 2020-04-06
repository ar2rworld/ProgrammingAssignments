package C2001a;
import java.util.Scanner;
import java.net.*;

public class FetchURL {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"https://money.cnn.com/data/markets/");
			int count = 0;
			Scanner input = new Scanner(url.openStream());
			boolean start = false;
			while (input.hasNext()) {
				String line = input.nextLine();
				count += line.length();
				if(line.contains("<span")) {
					System.out.println(line);
				}
				/*
				if(line.contains("</thead>"))
					start = true;
				else if (line.contains("/table"))
					start = false;
				if(start){
					if(line.contains("<tr>"))
						System.out.println();
					else if(!line.contains("<"))
						System.out.print(line.replaceAll("\\s+","") + "\t");
				}*/
					//System.out.println(line);
			}
			input.close();
			System.out.println("The file size is " + count + " bytes");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
