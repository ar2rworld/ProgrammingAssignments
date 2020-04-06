/**
Artur Linnik
300305901
Assignment9
 */
public class Assignment9
{
    //ships
    public static void main(String[] args){
        //makeGuess();
    }

    public static String makeGuess(char[][] g){
        //prob grid
        int[][] ng = new int[10][10]; //numeric values of guesses
        int max = 0;
        /*System.out.println("guesses");
        for(int i = 0; i < g.length; i++){
        for(int j = 0; j < g.length; j++){
        System.out.print(g[i][j] + " ");
        }
        System.out.println();
        }*/
        System.out.println();
        //for 2 horizontal ->
        for(int i=0; i<10; i++){
            for(int j=0; j<9; j++){
                if(g[i][j] == '.' && g[i][j+1] == '.'){
                    ng[i][j] += 1; ng[i][j+1] += 1;
                }
            }
        }
        //for 2 vertical 
        for(int i=0; i<9; i++){
            for(int j=0; j<10; j++){

                if(g[i][j] == '.' && g[i+1][j] == '.'){
                    ng[i][j] += 1; ng[i+1][j] += 1;
                }

            }
        }
        //for 3 horizontal
        for(int i=0; i<10; i++){
            for(int j=0; j<8; j++){

                if(g[i][j] == '.' && g[i][j+1] == '.' && g[i][j+2] == '.'){
                    ng[i][j] += 1; ng[i][j+1] += 1;ng[i][j+2] += 1;
                }

            }
        }
        //for 3 vertical
        for(int i=0; i<8; i++){
            for(int j=0; j<10; j++){

                if(g[i][j] == '.' && g[i+1][j] == '.' && g[i+2][j] == '.'){
                    ng[i][j] += 1; ng[i+1][j] += 1;ng[i+2][j] += 1;
                }

            }
        }
        //for 4 horizontal
        for(int i=0; i<10; i++){
            for(int j=0; j<7; j++){

                if(g[i][j] == '.' && g[i][j+1] == '.' && g[i][j+2] == '.' && g[i][j+3] == '.'){
                    ng[i][j] += 1; ng[i][j+1] += 1;ng[i][j+2] += 1;ng[i][j+3] += 1;
                }

            }
        }
        //for 4 vertical
        for(int i=0; i<7; i++){
            for(int j=0; j<10; j++){

                if(g[i][j] == '.' && g[i+1][j] == '.' && g[i+2][j] == '.' && g[i+3][j] == '.'){
                    ng[i][j] += 1; ng[i+1][j] += 1;ng[i+2][j] += 1;ng[i+3][j] += 1;
                }

            }
        }
        //for 5 horizontal
        for(int i=0; i<10; i++){
            for(int j=0; j<6; j++){

                if(g[i][j] == '.' && g[i][j+1] == '.' && g[i][j+2] == '.'&& g[i][j+3] == '.' && g[i][j+4] == '.'){
                    ng[i][j] += 1; ng[i][j+1] += 1;ng[i][j+2] += 1;ng[i][j+3] += 1;ng[i][j+4] += 1;
                }

            }
        }
        //for 5 vertical
        for(int i=0; i<6; i++){
            for(int j=0; j<10; j++){

                if(g[i][j] == '.' && g[i+1][j] == '.' && g[i+2][j] == '.'&& g[i+3][j] == '.' && g[i+4][j] == '.'){
                    ng[i][j] += 1; ng[i+1][j] += 1;ng[i+2][j] += 1;ng[i+3][j] += 1;ng[i+4][j] += 1;
                }

            }
        }
        //and , let's make <, <-, <--, <---, <---- directions.

        //for 2 horizontal ->
        for(int i=0; i<10; i++){
            for(int j=1; j<9; j++){

                if(g[i][j-1] == '.' && g[i][j] == '.'){
                    ng[i][j-1] += 1; ng[i][j] += 1;
                }

            }
        }
        //for 2 vertical 
        for(int i=1; i<10; i++){
            for(int j=0; j<10; j++){

                if(g[i-1][j] == '.' && g[i][j] == '.'){
                    ng[i-1][j] += 1; ng[i][j] += 1;
                }

            }
        }
        //for 3 horizontal
        for(int i=0; i<10; i++){
            for(int j=2; j<10; j++){

                if(g[i][j-2] == '.' && g[i][j-1] == '.' && g[i][j] == '.'){
                    ng[i][j-2] += 1; ng[i][j-1] += 1;ng[i][j] += 1;
                }

            }
        }
        //for 3 vertical
        for(int i=2; i<10; i++){
            for(int j=0; j<10; j++){

                if(g[i-2][j] == '.' && g[i-1][j] == '.' && g[i][j] == '.'){
                    ng[i-2][j] += 1; ng[i-1][j] += 1;ng[i][j] += 1;
                }

            }
        }
        //for 4 horizontal
        for(int i=0; i<10; i++){
            for(int j=3; j<10; j++){
                if(g[i][j-3] == '.' && g[i][j-2] == '.' && g[i][j-1] == '.' && g[i][j] == '.'){
                    ng[i][j-3] += 1; ng[i][j-2] += 1;ng[i][j-1] += 1;ng[i][j] += 1;
                }

            }
        }
        //for 4 vertical
        for(int i=3; i<10; i++){
            for(int j=0; j<10; j++){

                if(g[i-3][j] == '.' && g[i-2][j] == '.' && g[i-1][j] == '.' && g[i][j] == '.'){
                    ng[i-3][j] += 1; ng[i-2][j] += 1;ng[i-1][j] += 1;ng[i][j] += 1;
                }

            }
        }
        //for 5 horizontal
        for(int i=0; i<10; i++){
            for(int j=4; j<10; j++){

                if(g[i][j-4] == '.' && g[i][j-3] == '.' && g[i][j-2] == '.'&& g[i][j-1] == '.' && g[i][j] == '.'){
                    ng[i][j-4] += 1; ng[i][j-3] += 1;ng[i][j-2] += 1;ng[i][j-1] += 1;ng[i][j] += 1;
                }

            }
        }
        //for 5 vertical
        for(int i=4; i<10; i++){
            for(int j=0; j<10; j++){

                if(g[i-4][j] == '.' && g[i-3][j] == '.' && g[i-2][j] == '.'&& g[i-1][j] == '.' && g[i][j] == '.'){
                    ng[i-4][j] += 1; ng[i-3][j] += 1;ng[i-2][j] += 1;ng[i-1][j] += 1;ng[i][j] += 1;
                }

            }
        }
        
        //checking for biggest weight
        int a = 0;  //first coordinate letter
        int b = 0;  //second coordinate digit
        String aa = ""; //for x coord
        String bb = ""; //for y coord
        max = 0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(max < ng[i][j] && g[i][j] == '.'){
                    max = ng[i][j];
                    a = i;
                    b = j;

                }
            }
        }
        System.out.println("I found max value in ng["+ a + "]["+ b+ "] , that is equals to " + max);
        /*for(int i = 0; i < ng.length; i++){
            for(int j = 0; j < ng.length; j++){
                System.out.print(ng[i][j] + " ");
            }
            System.out.println();
        }*/
//        System.out.println(" ng[" + a + "][" + b + "] = " + ng[a][b] );
//        System.out.println(" gg[" + a + "][" + b + "] = " + g[a][b] );

        
        switch(a){
            case 0: aa =  "a";break;
            case 1: aa =  "b";break;
            case 2: aa =  "c";break;
            case 3: aa =  "d";break;
            case 4: aa =  "e";break;
            case 5: aa =  "f";break;
            case 6: aa =  "g";break;
            case 7: aa =  "h";break;
            case 8: aa =  "j";break;
            case 9: aa =  "g";break;
        }
        switch(b){
            case 0: bb =  "0";break;
            case 1: bb =  "1";break;
            case 2: bb =  "2";break;
            case 3: bb =  "3";break;
            case 4: bb =  "4";break;
            case 5: bb =  "5";break;
            case 6: bb =  "6";break;
            case 7: bb =  "7";break;
            case 8: bb =  "8";break;
            case 9: bb =  "9";break;
        }
        // and then u need to hunting for a each ship by the numbers.
        a = 0;
        b = 0;

        System.out.println();
        System.out.println(aa + bb);
        System.out.println(max);
        max=0;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                ng[i][j] = 0;
            }
        }
        return aa + bb; // guess 
    }
}
