public class testNestedloop{
    public static void main(String[] args){
        a : for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                
                 System.out.println(i + " " + j);
                if(i == 5){
                 System.out.println("i = 5");
                 //break a;
                }
            }
        }
        
                 System.out.println("end");
        
    }
}