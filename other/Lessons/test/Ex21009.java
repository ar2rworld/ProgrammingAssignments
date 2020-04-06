import java.util.Scanner;
public class Ex21009{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String str = "";
        int n =0, k=0;

        String a="", b="", c="";
        while(stdin.hasNext()){
            str = stdin.nextLine();
            if(str.equals("xxxxx")){
                break;
            }
            if(!str.equals(c)){
                n++;    
                if(k > 0){
                    n--;
                    k = 0;
                }
            }else{
                k++;
            }
            
            System.out.println("str = " + str + " c = " + c);
            c = str;
        }
        System.out.println(n);
    }
}