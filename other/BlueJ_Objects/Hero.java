
/**
 * Write a description of class Zombie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Hero
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int health;
    private boolean alive;
    private String name;
    //private static int heroX= -1;
    //private static int heroY= -1;
    
    
    public Hero(String name){
        x = (int)(Math.random() *100);
        y = (int)(Math.random() *100);
        health = 100;
        alive = true;
        this.name = name;
    }
    
    public String toString(){
        return "Zombie is at " + x + ", " + y;
    }
    public int getX(){
     return x;   
    }
    public int getY(){
     return y;   
    }
    
}
