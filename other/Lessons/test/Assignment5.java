/*
Artur Linnik
300305901
 */
import java.util.Scanner;
import java.lang.Character;
public class Assignment5 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String p = ""; //password
        int n = 0;//number of chars in word.
        int wrongChar = 0;
        boolean l=false, only = false, only1=false, only2=false, only3=false, upper=false, lower=false, d=false, w=true; //letter or digit only, upper, lower, digit, the "password" word.
        while(true){
            System.out.print("Password: ");
            p = in.nextLine();
            n = p.length();
            if(p.equals("endofinput")){
                break;
            }
            if(p.length()>=8){
                l = true;
            }
            if(l == false){
                System.out.println("Your password must be at least 8 characters.");
            }

            for(int i=0; i<p.length(); i++){
                if(Character.isDigit(p.charAt(i))){
                    d = true;             //changes bool var to true, if this parameter is valid
                }
                if(Character.isUpperCase(p.charAt(i))){
                    upper = true;
                }
                if(Character.isLowerCase(p.charAt(i))){
                    lower = true;
                }

                if(p.charAt(i) < 48 || p.charAt(i) > 122){
                    wrongChar++;
                }
                if(p.charAt(i) >= 58 && p.charAt(i) <= 64 )
                {
                    wrongChar++;
                }   
                if(p.charAt(i) >=91 && p.charAt(i) <= 96){
                    wrongChar++;
                }

            }
            
                for(int i=0;i<n;i++){
                    if(p.charAt(i) == 80 || p.charAt(i) == 112){
                        if((p.charAt(i+1) == 65 || p.charAt(i+1)==97)&&(p.charAt(i+2) == 83 || 
                            p.charAt(i+2)==115)&&(p.charAt(i+3) == 83 || p.charAt(i+3)==115)&&(p.charAt(i+4) == 87 || p.charAt(i+4)==119)&&
                        (p.charAt(i+5) == 79 || p.charAt(i+5)==111)&&(p.charAt(i+6) == 82 || p.charAt(i+6)==114)&&(p.charAt(i+7) == 68 ||
                            p.charAt(i+7)==100)){
                            w = false;
                        }else{
                            w = true;
                        }
                        break;

                    }
                }
            
            
            if(upper==false){
                System.out.println("Your password must contain at least one uppercase letter.");
            }
            if(wrongChar>0){
                System.out.println("Your password must contain alpha numeric characters.");
            }
            if(lower==false){
                System.out.println("Your password must contain at least one lowercase letter.");
            }
            if(d==false){
                System.out.println("Your password must contain at number.");
            }
            if(w==false){
                System.out.println("Your password cannot contain the word 'password'.");
            }

            if(l==true && wrongChar==0 && upper==true && lower==true && w == true && d ==true ){
                System.out.println("Your password is valid");
            }
            l = false;wrongChar = 0; upper = false; w = true; d = false; lower = false;     //updating for the next password       
        }

    }
}