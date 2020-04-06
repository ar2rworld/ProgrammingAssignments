import java.util.Scanner;
public class MyClass {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input x or o ");
        String l = in.nextLine();
        System.out.println("Input size");
        int s = in.nextInt();
        int i=0,j=0,k=s;//counters
        String a[][] = new String [s][s];
        for(i=0; i<s;i++){
            for(j=0; j<s;j++){
                a[i][j] = " ";}
            
        }
        if(l.equals("x")){
            for(i = 0; i<s; i++){
                a[i][i] = "*";
            }
            for(i = 0; i<s; i++){
                
                a[i][k-1] = "*";
                k--;
            }
            
        }else{
            for(i =0; i<s;i++){
                a[0][i]="*";
                a[s-1][i]="*";
                a[i][0] = "*";
                a[i][s-1] ="*";
            }
        }
        for(i=0; i<s;i++){
            for(j=0; j<s;j++){
            System.out.print(a[i][j]);
            }
            System.out.println();
        }
        
    }
}
