import java.util.Scanner;
public class Q5{
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in); 
        /*int i = 0; int sum = 0;
        int n = 0;
        while(input.hasNext()){
        n = input.nextInt();

        if(n == 0){
        break;
        }
        sum += n;
        i++;
        //System.out.println(sum);
        }
        System.out.println(sum/i);
        }*/
        double avg = 0;
        int count = 0;
        double total = 0;
        int number =  input.nextInt();
        while(number !=0){

            count ++;
            total += number;
            avg = total / count ;
            number =input.nextInt();
        }
        System.out.println(avg);
    }}