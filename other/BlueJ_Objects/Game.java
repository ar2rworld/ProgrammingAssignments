public class Game
{
    private int x;
    public static void main(String[] args){
        //Zombie Dan = new Zombie();
        Hero misty = new Hero("Misty");
        System.out.println(misty);
        Zombie[] zombies = new Zombie[30];
        
        for(int i=0; i<zombies.length; i++){
            zombies[i] = new Zombie();
            System.out.println(zombies[i]);
            
            if(zombies[i].findHero(misty)){
                System.out.println("found Misty");
            }
            
            if(zombies[i].getHeroX() > -1){
                System.out.println("Zombie " + i + " knows where Misty is");
            }
            
        }
    }
    
}
