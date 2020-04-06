import java.util.Scanner;
public class Assignment8{
    public static void main(String args[]) {
        String[][] a = { //user gueses
                {" ","1","2","3","4","5","6"},
                {"A","_","_","_","_","_","_"},
                {"B","_","_","_","_","_","_"},
                {"C","_","_","_","_","_","_"},
                {"D","_","_","_","_","_","_"},
                {"E","_","_","_","_","_","_"},
                {"F","_","_","_","_","_","_"}
            };
        int[][] s = { //ships
                {2,0,0,0,0,0},
                {2,0,0,0,3,0},
                {0,0,0,0,3,0},
                {0,0,0,0,3,0},
                {0,0,0,0,0,0},
                {0,0,4,4,4,4},
            };
        String message = "";
        int nofboat = 0;
        boolean done = false;
        boolean patrol = false, destroyer = false, battleship=false;
        boolean onceP = true, onceD=true, onceB = true;//to output "sunk" message once
        Scanner in = new Scanner(System.in);
        System.out.println("Enter point");
        while(in.hasNext()){
            System.out.println("Enter point");
            String p = in.nextLine();
            if(p.length() < 3 && Character.isLetter(p.charAt(0)) && Character.isDigit(p.charAt(1))){
                int x = Character.getNumericValue(p.charAt(1))- 1;
                int y = l(p) ;
                if(s[y][x] != 0){
                    nofboat = s[y][x];
                    a[y+1][x+1] = "x";

                }else{
                    a[y+1][x+1] = "o";
                }
                System.out.println( s[y][x] != 0?(p + " is a hit") : (p + " is not a hit") );
                s[y][x] = 0;

                //checking for the sunked ships
                a: for(int i=0; i<s.length; i++){
                    for(int j=0;j<s.length;j++){
                        //checking on the patrol boat
                        if(s[i][j] == 2 && patrol == false){
                            break a;
                        }else{
                            if(i == s.length-1 && j ==s.length-1){       
                                patrol = true;
                            }
                        }
                    }
                }
                b : for(int i=0; i<s.length; i++){
                    for(int j=0;j<s.length;j++){
                        //checking on the battleship boat
                        if(s[i][j] == 4 && battleship == false){
                            break b;
                        }else{
                            if(i == s.length-1 && j ==s.length-1){       
                                battleship = true;
                            }
                        }
                    }
                }
                c: for(int i=0; i<s.length; i++){
                    for(int j=0;j<s.length;j++){
                        //checking on the destroyer boat
                        if(s[i][j] == 3 && destroyer == false){
                            break c;
                        }else{
                            if(i == s.length-1 && j ==s.length-1){       
                                destroyer = true;
                            }
                        }
                    }
                }
                if(patrol == true && onceP == true){
                    System.out.println("You sunk Patrol boat");
                    onceP = false;
                }
                if(destroyer == true && onceD == true){
                    System.out.println("You sunk Destroyer boat");
                    onceD = false;
                }
                if(battleship == true && onceB == true){
                    System.out.println("You sunk Battleship");
                    onceB = false;
                }

                System.out.println("\t Enemy");
                for(int i=0; i<a.length; i++){
                    for(int j=0; j<a.length; j++){
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println();
                }

                outer: for(int i=0; i<s.length; i++){
                    for(int j=0; j<s.length; j++){
                        if(s[i][j] != 0){
                            done = false;
                            break outer;
                        }else{
                            done = true;
                        }
                    }
                    System.out.println();
                }
                if(done == true){
                    System.out.println("You win!!!");
                    break;
                }
            }else{
                System.out.println("WrongInput");
            }
        }

        //System.out.println("Sum of x+y = " + z);
    }

    public static String boat(int l){
        String a ="";
        switch (l){
            case 2: a = "Patrol Boat";break;
            case 3: a = "Destroyer";break;
            case 4: a =  "Battleship";break;
        }
        return a;
    }

    public static int l(String l){
        char a = l.charAt(0);
        int i = 0;
        switch(a){
            case 'a': i =  0;break;
            case 'A': i =  0;break;
            case 'b': i =  1;break;
            case 'B': i =  1;break;
            case 'c': i =  2;break;
            case 'C': i =  2;break;
            case 'd': i =  3;break;
            case 'D': i =  3;break;
            case 'e': i =  4;break;
            case 'E': i =  4;break;
            case 'f': i =  5;break;
            case 'F': i =  5;break;
        }
        return i;
    }
}