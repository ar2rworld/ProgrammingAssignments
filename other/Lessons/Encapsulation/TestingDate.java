import java.util.Date;
import java.text.SimpleDateFormat;
public class TestingDate
{
    public TestingDate()
    {

    }

    public static void main(String[] args){
        Date today = new Date();
        System.out.println(today);
        System.out.println(new SimpleDateFormat("dd/MMM/YYYY").format(today));
        System.out.println("Milliseconds since epoch " + today.getTime());

        long startTime = System.nanoTime();
        for(int j = 0; j<1000;j++){
            for(int i=0; i<1000000; i++){
                double fun = Math.sqrt(Math.random() *(i+j));
            }
        }
        long endTime = System.nanoTime();

        double seconds = (double)(endTime - startTime)/1000000000.0;
        System.out.println("That took " + seconds + " seconds");
    }
}