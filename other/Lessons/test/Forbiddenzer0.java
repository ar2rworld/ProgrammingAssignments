import java.lang.Math;

public class Forbiddenzer0{
    public static void main(String[] args){
        String n = "99";
        int k = Integer.valueOf(n);
        k++;
        int idn = 0;
        System.out.println();
        asdf : while(true){
            int[] arrayTemp = getR(k);
            System.out.println();
            for(int i=0; i<arrayTemp.length; i++){
                if(arrayTemp[i] == 0){
                    idn = i;
                }
            }
            for(int i = idn ; i<arrayTemp.length; i++){
                System.out.println("arrayTemp[" + i + "] ==  " + arrayTemp[i] + " ,k = " + k);
                if (arrayTemp[i] == 0){
                        k = getNumber(arrayTemp);
                        k++;
                        System.out.println("When arrayTemp[" + i + "] == 0  " + k);
                    }else{
                        for (int j = idn; j< arrayTemp.length; j++){
                            if (arrayTemp[j] != 0){
                                k = getNumber(arrayTemp);
                                System.out.println(k);
                                for(int y = 0 ; y< arrayTemp.length; y++){
                                    System.out.println("arrayTemp[" + y+ "] ==  " + arrayTemp[y]);
                                }

                                break asdf;
                            }else break;
                        }
                    }
                
            }

        }
        /*int[] e = { 1,2,0,3};
        System.out.println("getNumber meth " + getNumber(e));
        System.out.println("getR meth ");
        int[] te = getR(123012);
        for(int i =0; i< te.length; i++){
        System.out.print(" " + te[i]);
        }   */
        //k = getNumber(arrayTemp);
    }

    public static int getNumber(int[] a){
        int n = 0;
        for(int i =0; i< a.length; i++){

            n += a[i]*Math.pow(10,a.length-1-i);

        }
        return n;
    }

    public static int[] getR (int r){
        String n = Integer.toString(r);
        int[] a = new int [n.length()];
        for(int i = 0; i <n.length(); i++){
            int temp = Integer.valueOf(n.substring(i,i+1));
            a[i]= temp;
        }
        return a;
    }
}