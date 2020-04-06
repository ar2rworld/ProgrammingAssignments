public class MidtermPrep{
    public static void main(String[] args){
        /*for(int row=1; row < 5; row++){
        for(int col=1; col< row+1; col++){
        System.out.print(col);

        }

        System.out.println();
        }*/
        int[] a = {3,3,3,4,4,4,3,2,1,5,3};
        System.out.println("\n " + a(a));
    }

    public static int a(int [] a){
        int[][] aa = new int[2][a.length];
        int c = 0;
        int max = a[0];
        int p = a[0];
        aa[0][0] = a[0];
        System.out.println(aa[0][0]);
        for(int i=0;i<a.length; i++){
            for(int j=0;j<a.length; j++){
                if(a[i] == a[j]){
                    //System.out.println( a[i] + " == " + a[j]);
                    c++;
                }
            }
            aa[0][i] = a[i];
            aa[1][i] = c;
            c=0;
        }

        for(int i=0; i<a.length; i++){
            System.out.print(aa[0][i]+ " " );
            if(max < aa[1][i]){
                max = aa[1][i];
                //aa[1][i] = aa[0][i];
                p = i;
            }
        }
        return aa[0][p];
    }
}