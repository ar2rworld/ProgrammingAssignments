
package New;

/**
Artur Linnik
300305901
Assignment9
v1.3fixed
no s.o.p. statements
Avg is 46.292 in 2000 gs
Avg is 45.884 in 1000  gs
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
        //System.out.println();
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
        
        

        //target
        qwe : for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(g[i][j] == 'X'){

                    //checking on upper and lower cells
                    if(i+1!=10 && g[i+1][j] == 'X' || i-1>=0 && g[i-1][j] == 'X'){
                        //print("hello two Xes in vertical");
                        //print("if(i+1!=10 ){");
                        if(i+1!=10 ){
                          //  print("id0");
                            for(int k=i;k<9; k++){
                                if(g[k+1][j] == 'X'){
                                    continue;
                                }else{
                                    if(g[k+1][j] == '.'){
                                        a=k+1;
                                        b=j;
                          //              print("id1");
                                        break qwe;

                                    }else{
                                        break;
                                    }

                                }
                            }
                            for(int l=i;l>=1;l--){
                                if(g[l-1][j] == 'X'){
                                    continue;
                                }else{
                                    if( g[l-1][j] == '.'){
                                        a= l-1;
                                        b=j;
                          //              print("id2");
                                        break qwe;
                                    }
                                }
                            }
                           
                            //if(i<=1) //needs checking on i=0
                        }else{
                            //do checking on boundaries   
                            for(int q=i;q>=1;q--){
                                if(g[q-1][j] == 'X'){
                                    continue;
                                }else{
                                    if(g[q][j] =='.'){
                                        a= q;
                                        b=j;
                          //              print("id3");
                                        break qwe;
                                    }
                                }
                            }
                            
                            if(i==0 && g[i][j] == '.'){
                                a= i;
                                b=j;
                          //      print("id4");
                                break qwe;
                            }
                        }
                    }else if(j+1!=10 && g[i][j+1] == 'X' || j-1>=0 && g[i][j-1] == 'X'){
                        //print("hello two Xes in horizontal");
                        if(j+1 != 10 && g[i][j+1] == 'X' ){
                            continue;
                            //checkng on 'X' in the next point\
                        }else if(j+1 != 10 && g[i][j+1] =='.'){
                            a=i;
                            b= j+1;
                          //  print("id5");
                            break qwe;
                        }else{
                            for(int k=j;k>=1;k--){//problem here then 'x' on the left side, it quits loop
                                if(g[i][k-1] == 'X'){
                                    //print("ifoundXin " + (k-1));
                                    continue;
                                }else if(g[i][k-1] == '.'){
                                    a = i;
                                    b = k-1;
                          //          print("id6");
                                    break qwe;
                                }else{
                                    break;
                                }
                            }
                        }
                    }

                    
                    //print("Target mode");
                    if(j+1 != 10 && g[i][j+1] == 'X' ){
                        continue;
                        //checkng on 'X' in the next point\
                    }else if(j+1 != 10 && g[i][j+1] =='.'){
                        a=i;
                        b= j+1;
                        //print("id7");
                        break qwe;
                    }else{
                        for(int k=j;k>=1;k--){//problem here then 'x' on the left side, it quits loop
                            if(g[i][k-1] == 'X'){
                                //print("ifoundXin " + (k-1));
                                continue;
                            }else if(g[i][k-1] == '.'){
                                a = i;
                                b = k-1;
                        //        print("id8");
                                break qwe;
                            }else{
                                break;
                            }
                        }
                    }
                    //print("if(i+1!=10 ){");
                    if(i+1!=10 ){
                        //print("id9");
                        for(int k=i;k<9; k++){
                            if(g[k+1][j] == 'X'){
                                continue;
                            }else{
                                if(g[k+1][j] == '.'){
                                    a=k+1;
                                    b=j;
                      //              print("id10");
                                    break qwe;

                                }else{
                                    for(int l=i;l>=1;l--){
                                        if(g[l-1][j] == 'X'){
                                            continue;
                                        }else{
                                            if( g[l-1][j] == '.'){
                                                a= l-1;
                                                b=j;
                      //                          print("id11");
                                                break qwe;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        //do checking on boundaries   
                        for(int q=i;q>=1;q--){
                            if(g[q-1][j] == 'X'){
                                continue;
                            }else{
                                if(g[q][j] =='.'){
                                    a= q;
                                    b=j;
                      //              print("id12");
                                    break qwe;
                                }
                            }
                        }
                        if(i==0 && g[i][j] == '.'){
                            a= i;
                            b=j;
                      //      print("id13");
                            break qwe;
                        }
                    }
                }
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
        
        //looking for tie
        int c =0; // counter of now many same value 
        int l = 0; // counter of l++
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if( max == ng[i][j]){
                    c++;
                }
            }
        }
        int[][] tie = new  int[2][c];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if( max == ng[i][j]){
                    tie[0][l] = i;
                    tie[1][l] = j;
                }
            }
        }
        
        
        for(int i = 0; i < ng.length; i++){
        for(int j = 0; j < ng.length; j++){
        System.out.print(ng[i][j] + " ");
        }
        System.out.println();
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(g[i][j] + " ");

            }
            System.out.println();
        }
        char A = (char)((int)'A' + a);
        String guess = A + Integer.toString(b+1);
        //System.out.println(guess);
        return guess;  // guess 
    }

    public static void print(String s){
        //
        System.out.println(s);
    }
}
