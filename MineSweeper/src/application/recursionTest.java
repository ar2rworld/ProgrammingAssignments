package application;

public class recursionTest {
	static char[][] a;
	static char[][] board0;
	static int c=0;
	public static void main(String[] args) {
		a = new char[15][20];
		board0 = new char[15][20];
		for(int i=0; i < a.length; i++) {
			for(int j=0; j < a[i].length; j++) {
				a[i][j] = ' ';
				board0[i][j] = ' ';
				if(i == 2 || i == 12 || j == 2 || j == 17) {
					a[i][j] = 'm';
					board0[i][j] = 'm';
				}
				//System.out.print(a[i][j] + " ");
			}
			//System.out.println();
		}
		
		//recursion(a, 9,11);
		revealZeros(board0,9,9);
			
		for(int i=0; i < a.length; i++) {
			for(int j=0; j < a[i].length; j++) {
			System.out.print(board0[i][j] + " ");
		}
			System.out.println();
		}
		System.out.println(c);
}
		
	public static void recursion(char[][] ar, int y, int x) {
		if (x >= 0 && x < ar[0].length && y >= 0 && y < ar.length)
		if(getNofObjsAround(y,x, ar,'m') == 0) {
			System.out.println(y + " " + x);
			ar[y][x] = 'c';
			ar[y][x-1] = 'c';
			ar[y][x+1] = 'c';
			ar[y-1][x] = 'c';
			ar[y-1][x-1] = 'c';
			ar[y-1][x+1] = 'c';
			ar[y+1][x] = 'c';
			ar[y+1][x-1] = 'c';
			ar[y+1][x+1] = 'c';
			
			//recursion( ar, y+1, x+1);
			recursion( ar, y+1, x);
			//recursion( ar, y+1, x-1);
			//recursion( ar, y-1, x+1);
			recursion( ar, y-1, x);
			//recursion( ar, y-1, x-1);
			recursion( ar, y, x+1);
			recursion( ar, y, x-1);
		}else {
			return;
		}
	}
	private static void revealZeros(char[][] board, int x, int y) {
		c ++;
        if (x < 0 || x > board[0].length || y < 0 || y > board.length) return; // check for bounds
        System.out.println(getNofObjsAround(y,x, board,'m'));
 	   System.out.println(board[y][x] !='c');
           if ( getNofObjsAround(y,x, board,'m') == 0 && board[y][x] !='c' ) {
        	   
               board[y][x] = 'c';
               revealZeros(board, x+1, y );
               revealZeros(board, x-1, y );
               revealZeros(board, x, y-1 );
               revealZeros(board, x, y+1 );
           } else {
               return;
           }
        }
	public static int getNofObjsAround(int y, int x,char[][] ar,char c) {//counts n of chars on the board 
		int sum=0;
		if(x >= 1 && x < ar[0].length-1) {
			if(y>=1 && y< ar.length-1) {
				for(int i = y-1; i<y+2;i++) {
					for(int j = x-1; j<x+2;j++) {
						if(ar[i][j]==c) 
							sum +=1;
					}
				}
				return sum;
			}
		}
		if(y==0) {
			if(x>0 && x<ar[0].length-1) {
				if(ar[y][x-1]==c)
					sum++;
				if(ar[y+1][x-1] == c)
					sum++;
				if(ar[y+1][x] == c)
					sum++;
				if(ar[y][x+1] == c)
					sum++;
				if(ar[y+1][x+1] == c)
					sum++;
				return sum;
			}
			if(x==0) {
				if(ar[0][1] == c)
					sum ++;
				if(ar[1][0] == c)
					sum ++;
				if(ar[1][1] == c)
					sum ++;
				return sum;
			}else if(x == ar[0].length - 1) {
				if(ar[0][ar[0].length-2] == c)
					sum++;
				if(ar[1][ar[0].length-2] == c)
					sum++;
				if(ar[1][ar[0].length-1] == c)
					sum++;
				return sum;
			}
		}else if(y == ar.length -1) {
			if(x>0 && x<ar[0].length-1) {
				if(ar[y][x-1]==c)
					sum++;
				if(ar[y-1][x-1] == c)
					sum++;
				if(ar[y-1][x] == c)
					sum++;
				if(ar[y][x+1] == c)
					sum++;
				if(ar[y-1][x+1] == c)
					sum++;
				return sum;
			}
			if(x==0) {///
				if(ar[ar.length-2][0] == c)
					sum ++;
				if(ar[ar.length-2][1] == c)
					sum ++;
				if(ar[ar.length-1][1] == c)
					sum ++;
				return sum;
			}else if(x == ar[0].length - 1) {
				if(ar[ar.length-2][ar[0].length-1] == c)
					sum++;
				if(ar[ar.length-2][ar[0].length-2] == c)
					sum++;
				if(ar[ar.length-1][ar[0].length-2] == c)
					sum++;
				return sum;
			}
		}
		if(x == 0) {
			if(y>0 && y<ar.length-1) {
				if(ar[y-1][x] == c)
					sum++;
				if(ar[y-1][x+1] == c)
					sum++;
				if(ar[y][x+1] == c)
					sum++;
				if(ar[y+1][x+1] == c)
					sum++;
				if(ar[y+1][x] == c)
					sum++;
				return sum;
			}
		}else if(x == ar[0].length-1) {
			if(y>0 && y<ar.length-1) {
				if(ar[y-1][x] == c)
					sum++;
				if(ar[y-1][x-1] == c)
					sum++;
				if(ar[y][x-1] == c)
					sum++;
				if(ar[y+1][x-1] == c)
					sum++;
				if(ar[y+1][x] == c)
					sum++;
				return sum;
			}
		}
		return sum;
	}
	
}
