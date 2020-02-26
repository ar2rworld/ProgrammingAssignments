/*
 * Artur Linnik 300305901 13.02.2020
 * Sarah is best
 */
package Lab4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
public class Assignment4 {
	public static void main(String[] agrs) {
		String inOpt = "";
		Scanner in = new Scanner(System.in);
		int att = 7; //attemps
		int score = 0;
		String path =  "src\\dictionary.txt";
		boolean NEW = false;
		String word = getRandomWord(path);
		word = word.toUpperCase();
		String[] wordAT = word.split("");
		String[] wordA = word.split("");
		String[] wordAHid = wordA;
		ArrayList<String> wrongAns = new ArrayList<String>();
		int openIndexLetter = (int)(Math.random() * wordAHid.length);
		for(int i=0; i< wordAHid.length ; i++) {
			if(i == openIndexLetter) {
				continue;
			}else {
				if(wordAHid[i].equals(wordAHid[openIndexLetter])) {
					continue;
				}
				wordAHid[i] = "_";
			}
		}
		while(att != 0) {
			if(NEW) {
				System.out.println("\nNEW WORD!\n");
				word = getRandomWord(path);
				word = word.toUpperCase();
				wordAT = word.split("");
				wordA = word.split("");
				wordAHid = wordA;
				wrongAns.clear();
				openIndexLetter = (int)(Math.random() * wordAHid.length);
				for(int i=0; i< wordAHid.length ; i++) {
					if(i == openIndexLetter) {
						continue;
					}else {
						if(wordAHid[i].equals(wordAHid[openIndexLetter])) {
							continue;
						}
						wordAHid[i] = "_";
					}
				}
				NEW = false;
			}
			System.out.print("Hidden Word: "); printWord(wordAHid);
			System.out.print("Incorrect Guesses: ");
			for(int i = 0; i < wrongAns.size(); i++) {
				String t = ", ";
				if(i== wrongAns.size() - 1)
					t ="";
				System.out.print(wrongAns.get(i) + t);
			}
			System.out.println("\nGuesses Left: " + att);
			System.out.println("Score: " + score);
			System.out.print("Enter next guess: ");
			inOpt = inputCheck().toUpperCase();
			if(checkLetter(wordAT, inOpt)) {
				score+=setCorrectLetter(wordAHid, word, wordAT);
			}else {
				att --;
				wrongAns.add(inOpt);
				wrongAns.sort(null);
				System.out.println("Sorry, there is no " + inOpt+ "'s");
			}
			boolean te = false;
			for(int i=0; i<wordAT.length; i++) {
				if(wordAHid[i].equals("_")) {
					te = false;
					break;
				}else {
					te = true;
				}
			}
			if(te) {
				score+=100;
				score+=att*30;
				NEW=true;
			}
			System.out.println();
		}
		System.out.println("\tGAME OVER!\n\tYour score is: " + score);
		File f = new File("src\\top5.txt");
		ArrayList<Integer> scoreA = new ArrayList<Integer>();
		ArrayList<String> nameA = new ArrayList<String>();
			try {
				if(!f.createNewFile()) {
					Scanner inf = new Scanner(f);
					while(inf.hasNext()) {
						String line = inf.next();
						int sc = inf.nextInt();
						scoreA.add(sc);
						nameA.add(line);						
					}
					int min = 0;
					if(scoreA.size() > 0) {
						min = scoreA.get(0);
					}
					int cMin = 0;
					for(int j=0; j<scoreA.size(); j++) {
						 cMin = scoreA.get(j);
						if(cMin < min ) {
							min = cMin;
						}
					}
					if(score >= min) {
						System.out.println("WOW, we have new TOP 5 PLAYER!\nCONGRATULATIONS!!!\nEnter your name:");
						String nn = getInput();
						System.out.println("When I see u again!\nWhen I seee u again!\nWhen I seee u agaaaiiiiin!");
						writeArToFile(scoreA, nameA, nn, score);
					}
				}else{
					//Scanner 
					PrintWriter output = new PrintWriter(f);
					System.out.println("As you are the first player in the list write you name down:");
					String name = getInput();
					output.println(name + " " + score);
				}
				
				
			}
			catch(FileNotFoundException e){
				System.out.println("Probles with top5 scores file\n" + e);
			} catch (IOException e) {
				System.out.println("IOException\n" + e);;
			}
			finally {
				
			}
		

		System.out.println("  TOP 5 PLAYERS:");
		printTopPlayersFromFile("src\\top5.txt");
	}
	public static void printArLtStr(ArrayList<String> a) {
		for(int i =0; i< a.size() ; i++) {
			System.out.println("outStr: " + a.get(i));
		}
	}
	public static void printArLtInt(ArrayList<Integer> a) {
		for(int i =0; i < a.size(); i++) {
			System.out.println("outInt: " + a.get(i));
		}
	}
	public static void printTopPlayersFromFile(String a) {
		try {
			File f = new File("src\\top5.txt");
			Scanner out = new Scanner(f);
			int i = 1;
			while(out.hasNext()) {
				System.out.println(i + ") " + out.next() + " " + out.nextInt());
				i++;
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("not file : printTopPlayersFromFile method");
		}
	}
	public static void writeArToFile(ArrayList<Integer> scoreA, ArrayList<String> nameA, String nn,  int score) {
		int[] tS = new int[nameA.size() + 1];
		String[] tN = new String[nameA.size()+ 1];
		for(int i=0; i<nameA.size(); i++) {
			tS[i] = scoreA.get(i);
		}
		for(int i=0; i<nameA.size(); i++) { // && i< scoreA.size()
			tN[i] = nameA.get(i);
		}
		scoreA.add(score);
		 Collections.sort(scoreA, Collections.reverseOrder());
		nameA.add(nn);
		System.out.println();
		boolean tt = true;
		for(int i=0; i < scoreA.size(); i++) {
			if(scoreA.get(i) != tS[i]) {
				for(int j = 0; j < scoreA.size(); j++){
					if(scoreA.get(i) == tS[j]) {
						String t = nameA.get(i);
						nameA.set(i, tN[j]);
						//nameA.set(j, t);
					}
				}
			}
			
			if(scoreA.get(i) == score && tt) {
				nameA.set(i, nn);
				tt = false;
			}
		}
		if(scoreA.size() > 5) {
			for(int i = scoreA.size()-1; i > 4 ; i--) {
				scoreA.remove(i);
				nameA.remove(i);
			}
		}
		try {
			File f = new File("src\\top5.txt");
			PrintWriter output = new PrintWriter(f);
			for(int i=0; i<scoreA.size(); i++) {
				output.println(nameA.get(i) + " " + scoreA.get(i));
			}
			output.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		//u spent so much time, but could use dictionary
		//create an array, load scores , sort arraylist , compare array list's data with array created, 
	}
	public static String getInput() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
	public static String inputCheck() {
		String in = "";
		boolean tt = false;
		while(!tt) {
			in = getInput();
			if(in.length() != 1) {
				System.out.println("Invalid input, one letter please");
				tt = false;
				continue;
			}
			if(!Character.isLetter(in.charAt(0)) || in.charAt(0) == ' ') {
				System.out.println("Invalid input, letter needed");
				tt= false;
				continue;
			}
			break;
		}
		return in;
	}
	public static int setCorrectLetter(String[] wordAHid, String word, String[] wordAT) {
		int t= 0;
		for(int i = 0; i<wordAT.length; i++) {
			if(wordAT[i].equals("~")) {
				wordAT[i] = "!";
				wordAHid[i] = word.split("")[i];
				t+=10;
			}
		}
		return t;
	}
	public static boolean checkLetter(String[] wordAT, String a) {
		boolean out = false;
		for(int i=0; i<wordAT.length; i++) {
			if(wordAT[i].equals(a)) {
				out = true;
				wordAT[i] = "~";
			}
		}
		return out;
	}
	public static void printWord(String[] a) {
		for(int i =0; i< a.length; i++) {
			System.out.print(a[i] + " " );
		}
		System.out.println();
	}
	public static String getRandomWord(String a) {
		String out = "";
		try {
			File f = new File(a);
			Scanner input = new Scanner(f);
			int c = 0;
			int rndIndex = (int)(Math.random() * 127142);
			while (input.hasNext()) {
				String line = input.nextLine();
				if(c==rndIndex) {
					out = line;
					break;
				}
				c++;
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Working dir is " + System.getProperty("user.dir"));
			System.out.println(e);
		}
		return out;
	}
}
