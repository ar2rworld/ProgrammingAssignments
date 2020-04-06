package C0304distance;

import java.io.IOException;

public class waitingBar {

	public static void main(String[] args) throws IOException {
		String[] a = {"\\","|", "/", "-"};
		int i=0;
		while(i < 200000) {
			System.out.print("\033[H\033[2J"); 
			System.out.flush();  
			System.out.println(a[i % 4]);
			i++;
		}
	}

}
