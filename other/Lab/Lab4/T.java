package Lab4;

import java.io.*;
import java.util.ArrayList;

public class T {
public static void main(String[] agrs) {
	ArrayList<Integer> scoreA = new ArrayList<Integer>();
	ArrayList<String> nameA = new ArrayList<String>();
	String nn = "Artur";  int score = 30;
	scoreA.add(90); nameA.add("A");
	scoreA.add(20); nameA.add("B");
	scoreA.add(40); nameA.add("C");
	//scoreA.add(29); nameA.add("D");
	//scoreA.add(31); nameA.add("E");
	writeArToFile(scoreA, nameA, nn, score);
	printArLtStr(nameA);
	printArLtInt(scoreA);
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
	scoreA.sort(null);
	nameA.add(nn);
	printArLtStr(nameA);
	printArLtInt(scoreA);
	System.out.println();
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
		if(scoreA.get(i) == score) {
			nameA.set(i, nn);
		}
	}
	if(scoreA.size() > 5) {
		for(int i = scoreA.size()-1; i > 4 ; i--) {
			scoreA.remove(i);
			nameA.remove(i);
		}
	}
	try {
		File f = new File("Lab4/dictionary.txt");
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
}
