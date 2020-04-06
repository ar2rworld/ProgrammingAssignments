package txtForNN;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.io.File;
import java.io.IOException;

public class TextFileForNN2 {
	private static DecimalFormat decf = new DecimalFormat("0.00000");
	public static void main(String[] args) {
		double[][] a = new double[100000][101];
		for(int i=0;i<a.length; i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j] = Double.parseDouble(decf.format(Math.random()));
			}
		}
		try {
		File f = new File("res/f2.txt");
		
		if(f.createNewFile()) {
			PrintWriter pw = new PrintWriter(f);
			for(int i=0;i<a.length; i++) {
				for(int j=0;j<a[i].length;j++) {
					if(j != a[i].length - 1) {
					pw.print(a[i][j] + " ");
					}else {
						pw.println(a[i][j]);
					}
				}
			}
		}
		}
		catch(IOException e) {
			System.out.println("IO"+ e.getMessage());
		}
		System.out.println("END");
	}
	//PrintWriter p = new PrintWriter(
}
/*

*/