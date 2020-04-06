import java.lang.Math;
public class EnemyShakal
{
    private int x;
    private int y;
    private int xT;
    private int yT;
    public double rnd(){
        return Math.random();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public EnemyShakal()
    {
        x = (int) rnd() * 19;
        y = (int) rnd() * 19;
        if(x>y){
            y=0;
        }else{
            x=0;
        }
    }

    
    public void searchTarget()
    {
        double ch1 = Math.sqrt(Math.pow((x-5),2) +(Math.pow((y-5),2) ));
        double ch2 = Math.sqrt(Math.pow((x-5),2) +(Math.pow((y-13),2) ));
        double ch3 = Math.sqrt(Math.pow((x-13),2) +(Math.pow((y-13),2) ));
        double ch4 = Math.sqrt(Math.pow((x-13),2) +(Math.pow((y-5),2) ));
        double[] chs = {ch1,ch2,ch3,ch4};
        double max = chs[0];
        int indexM=0;
        for(int i=0; i<4; i++){
         if(max < chs[i]){
             max = chs[i];
             indexM = i;
            }
        }
        switch(indexM){
            case(0):
                xT = 5-x;
                yT = 5-y;
            break;
            case(1):
                xT = 5-x;
                yT = 13-y;
            break;
            case(2):
                xT = 13-x;
                yT = 13-y;
            break;
            case(3):
                xT = 13-x;
                yT = 5-y;
            break;
        }
    }
    public void moveShakal(){
        searchTarget();
        if(xT > yT){
            if(xT>x){
             x++;   
            }else{
             x--;   
            }
        }else{
            if(yT>x){
             y++;   
            }else{
             y--;   
            }
        }
    }
}
