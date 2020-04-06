import java.util.Scanner;
 
public class CTest {
    public static void main(String [] args) {
        Scanner stdin = new Scanner(System.in);
        
        int age = 21;
        String choice = null;
        

 /*System.out.println("S: hangar steak, red potatoes, asparagus");
1       System.out.println("T: whole trout, long rice, brussel sprouts");
12      System.out.println("B: cheddar cheeseburger, steak fries, cole slaw");*/
        choice = stdin.next();
        System.out.println(choice);
        if(choice == "S" || choice == "T" || choice == "B")
        {       System.out.println("main cond");
            if(age <= 21){
            
                if(choice == "S"){
                System.out.println("vegetable juice");
            }else if(choice == "T"){
                System.out.println("cranberry juice");
            }else if(choice == "B"){
                System.out.println("soda");
            }
                
            }else{
            
                if(choice == "S"){
                    System.out.println("cabernet");
                    //System.out.println("21>");
                }
                 if(choice == "T"){
                            System.out.println("chardonny");
                    }
                 if( choice == "B"){
                            System.out.println("IPA");
                    }
                
            }
            
                 
        }else{System.out.println("INVALID");}

 
        
    }
}
