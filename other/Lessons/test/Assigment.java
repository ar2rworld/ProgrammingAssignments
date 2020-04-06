import java.util.Scanner;
import java.util.Random;
public class Assigment {
    public static void main(String args[]) {
        String[][] a = {
            {"Alberta", "Edmonton"},
            {"British Columbia","Victoria"},
            {"Manitoba","Winnipeg"},
            {"New Brunswick","Fredericton"},
            {"Newfoundland and Labrador","St. John's"},
            {"Nova Scotia","Halifax"},
            {"Ontario","Toronto"},
            {"Prince Edward Island","Charlottetown"},
            {"Quebec","Quebec City"},
            {"Saskatchewan","Regina"},
        };
        int i = 0;
        Scanner in = new Scanner(System.in);
        while(i<=10){
            i++;
            int p = (int)(Math.random()*10);
            System.out.print("What is capital of " + a[p][0] + "? ");
            String c = in.nextLine();
            if(c.equals(a[p][1])){
                System.out.println("CORRECT!");
            }else{
                System.out.println("WRONG");
            }
        }

      //System.out.println("Sum of x+y = " + z);
    }
}