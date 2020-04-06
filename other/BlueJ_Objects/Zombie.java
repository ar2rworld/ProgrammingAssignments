
/**
 * Write a description of class Zombie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zombie
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int health;
    private boolean alive;
    private static int heroX = -1;
    private static int heroY = -1;
    
    
    public Zombie(){
        x = (int)(Math.random() *100);
        y = (int)(Math.random() *100);
        health = 100;
        alive = true;
    }
    
    public String toString(){
        return "Zombie is at " + x + ", " + y;
    }
    
    public boolean findHero(Hero h){
        if(Math.abs(h.getX() - x) < 10 && Math.abs(h.getY() - x) < 10){
            heroX = h.getX();
            heroY = h.getY();
            return true;
            
        }
        return false;
    }
    public int getHeroX(){
        return heroX;
    }
    public int getHeroY(){
        return heroY;
    }
    
}
