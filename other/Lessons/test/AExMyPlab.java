    import java.lang.StringBuilder;
import java.util.Scanner;
public class AExMyPlab{
    public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            String n = in.nextLine();
            
            int a[][];
            int x=0, y=0;
            StringBuilder xs = new StringBuilder("");//https://javarush.ru/groups/posts/1898-string--string-ili-stringbuilderappendstring
            StringBuilder ys = new StringBuilder("");
            
            System.out.println("i __ char");
                
                for(int i= 0; i<n.length(); i++){
                    System.out.println(i+ "    "+ n.charAt(i));
                    if(n.charAt(i) != ' '){
                        xs.append(n.charAt(i));
                    }
 /*
0    1
1    0
2    1
3     
4    1
*/
                }
                System.out.println("x = "+xs);
            }
    }