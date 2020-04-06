public class Pikachu
{
    private int x;
    private int y;
    private double attackPower;
    private int hitPoints;
    private String name;
    
    
    public Pikachu(){
        
        x = (int)(Math.random()*100);
        y = (int)(Math.random()*100);
        name = "Pikachu";
        hitPoints = (int)(Math.random()*1000 ) + 500;
        attackPower = Math.random()*300;
        
        
    }
    
    public Pikachu(String name){
        
        x = (int)(Math.random()*100);
        y = (int)(Math.random()*100);
        this.name = name;
        hitPoints = (int)(Math.random()*1000 ) + 500;
        attackPower = Math.random()*300;
        
        
    }
    
    public int getHitPoints(){ //accessor or getter
        return hitPoints;
    }
    
    public String toString(){
        return name + " is at " + x + ", " + y + " , attackPower = " + attackPower ;
    }
    
    
}
