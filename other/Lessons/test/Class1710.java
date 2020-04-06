import java.util.Random;
import java.util.Arrays;
public class Class1710 {
    public static void main(String args[]) {
        int[] numbers = new int[1600000000];//{50, 20, 3, 44, 97 , 42, 69, 4, 19, 77, 32, 99};
        //Arrays.sort(numbers);
        for(int i=0; i<numbers.length; i++){
            //System.out.print(numbers[i] + " ");
            numbers[i] = (int)Math.random()*101;
        }
        //int xn = 77;
        int  index = Arrays.binarySearch(numbers, 44);
        System.out.println();
        System.out.println(numbers[index] + " i = " + index);
    }
}