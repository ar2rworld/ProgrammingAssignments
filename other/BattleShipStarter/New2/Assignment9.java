package New2;

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
        //System.out.println("I found max value in ng["+ a + "]["+ b+ "] , that is equals to " + max);
        /*for(int i = 0; i < ng.length; i++){
        for(int j = 0; j < ng.length; j++){
        System.out.print(ng[i][j] + " ");
        }
        System.out.println();
        }*/
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(g[i][j] + " ");

            }
            System.out.println();
        }

        //target
        qwe : for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(g[i][j] == 'X'){
                    print("Target mode");

                    if(j+1 != 10 && g[i][j+1] == 'X' ){
                        continue;
                        //checkng on 'X' in the next point\

                    }else if(j+1 != 10 && g[i][j+1] =='.'){
                        a=i;
                        b= j+1;
                        break qwe;
                    }else{
                        for(int k=j;k>=1;k--){//problem here then 'x' on the left side, it quits loop
                            if(g[i][k-1] =='X' && k-1 >=0){
                                continue;
                            }else if(g[i][k-1] == '.'){
                                a = i;
                                b = k-1;
                                print("[i][k-1]");
                                break qwe;
                            }
                        }
                        if(j==0 && g[i][j+1] == '.'){
                            a=i;
                            b=j+1;
                            break qwe;
                        }
                    }
                    if(i+1!=10){
                        for(int o=i;o<9; o++){
                            if(g[o+1][j] == 'X'){
                                continue;
                            }else{
                                if(g[o+1][j] == '.'){
                                    a=o+1;
                                    b=j;
                                    print("[o+1][j]");
                                    break qwe;
                                }else{
                                    for(int l=i;l>=1;l--){
                                        if(g[l-1][j] == 'X'){
                                            continue;
                                        }else{
                                            if( g[l-1][j] == '.'){
                                                a= l-1;
                                                b=j;
                                                print("l-1][j");
                                                break qwe;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        //do checking on boundaries
                        if(j == 9){
                            if(g[i][j-1] == '.'){
                                a=i;
                                b=j-1;
                                break qwe;
                            }
                        }
                        if(j == 0){
                            if(g[i][j+1] == '.'){
                                a=i;
                                b=j+1;
                                break qwe;
                            }
                        }
                        if(i == 9){
                            if(g[i-1][j] == '.'){
                                a=i-1;
                                b=j;
                                break qwe;
                            }
                        }
                        if(i == 0){
                            if(g[i+1][j] == '.'){
                                a=i+1;
                                b=j;
                                break qwe;
                            }
                        }
                    }
                }

                /*if(j+1 != 10 && j-1>=0 && g[i][j+1] == 'O' && g[i][j-1] == 'O' ){
                for(int k=i;k<9; k++){
                if(g[k+1][j] == 'X'){
                continue;
                }else{
                if(g[k+1][j] == '.'){
                a=k+1;
                b=j;
                break qwe;
                }else{
                for(int l=i;l>1;l--){
                if(g[l-1][j] == 'X'){
                continue;
                }else{
                if( g[l-1][j] == '.'){
                a= l-1;
                b=j;
                break qwe;
                }
                }
                }
                }
                }
                }
                }else{
                //do checking on boundaries   

                }*/
            }
        }

        /*
        System.out.println(" ng[" + a + "][" + b + "] = " + ng[a][b] );
        System.out.println(" gg[" + a + "][" + b + "] = " + g[a][b] );

        // and then u need to hunting for a each ship by the numbers.

        //System.out.println();
        //System.out.println(aa + bb);
        System.out.println(max);
        max=0;*/

        char A = (char)((int)'A' + a);
        String guess = A + Integer.toString(b+1);
        System.out.println(guess);
        return guess;  // guess 
    }

    public static void print(String s){
        System.out.println(s);
    }
}
