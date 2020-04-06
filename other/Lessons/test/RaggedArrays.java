//21 pilots
//Raggerd arrays - non semetric arrays
public class RaggedArrays{//but about sudoku

    public static void main(String[] args){
        /*System.out.println("Hello");
        int[][] triangle = {
        {1,2,3,4,5},
        {1,2,3,4},
        {1,2,3},
        {1,2},
        {1}
        };
        for(int row = 0; row <triangle.length; row++){
        for(int col = 0; col < triangle[row].length; col++){
        System.out.print(triangle[row][col] + " ");
        }
        System.out.println();
        }*/

        //board
        int[][] b = {
                {5,3,0,0,7,0,0,0,2},
                {6,0,0,1,9,5,0,4,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,9,0,6,0,4,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,0,0},
                {0,0,0,4,1,9,0,0,5},
                {3,0,0,0,8,0,0,7,9}
            };
        int[][] bb = {
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
            };
        int[][][] p = new int[9][9][9]; //possibilities
        int[] e = {1,2,3,4,5,6,7,8,9};
        System.out.println();
        //out(b);
        //check(b);
        //check(bb); //incorrect code
        //solution
        //array of elements

        //filling an matrix with given numbers 
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                for(int k=0;k<9;k++){
                    p[i][j][k] = b[j][k];

                }

            }
        }
        out3(p,0);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                for(int k=0; k<9; k++){//for the exactly one cell 
                    if(p[i][j][k] != 0){
                        for(int l=0; l<9;l++){

                            if(p[i][j][k] > e[l]){
                                //check on the elements left
                                p[i][j][l] = e[k];//array is out of bounds 

                            }    
                        }

                    }
                }
            }
        }
        check3(p);

    }

    public static void check3(int[][][] a){
        boolean t = false;
        int[][] sum = new int[9][9];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                for(int k=0; k<a.length; k++){
                    sum[i][j] += a[i][j][k];
                }
            }   
        }
        int index = 0;
        for(int i=0; i<a.length; i++){
            for(int j=0;j<a.length;j++){

                if(sum[i][j] == 45){
                    t = true;
                    index = i;
                    break;
                }else{
                    t = false;
                }
            }
        }
        if(t == true){
            System.out.println("almost done");
        }else{
            System.out.println("Correct! index = " + index);
        }
    }

    public static void out(int[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                System.out.print(a[i][j] + " ");
            }   
            System.out.println();
        }
    }

    public static void out3(int[][][] a, int i){
        System.out.println("OUT3.index=" + i);
        for(int k=0; k<9; k++){
            for(int j=0; j<9; j++){
                System.out.print(a[i][k][j] + " " );
            }
            System.out.println();
        }   
    }

    public static void check(int[][] a){
        //incorrect code
        boolean t = false;
        int[] sum = new int[9];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                sum[i] += a[i][j];
            }   
        }

        for(int i=0; i<a.length; i++){

            if(sum[i] != 45){
                t = false;
                break;
            }else{
                t = true;
            }

        }
        if(t == true){
            System.out.println("NO .check meth");
        }else{
            System.out.println("Correct! .check meth");
        }
    }

}
