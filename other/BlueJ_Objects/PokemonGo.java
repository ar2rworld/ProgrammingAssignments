public class PokemonGo{
    public static void main(String[] args){
        Pikachu andrew = new Pikachu();     //calling constructor
        //name has to be the same as a class
        // constructor is very specific method
        System.out.println(andrew.toString());
        System.out.println("HP = " + andrew.getHitPoints());
        Pikachu kristina = new Pikachu("Kristina");
        System.out.println(kristina);
        System.out.println("HP = " + kristina.getHitPoints());
        
        Pikachu[] manyPikachus = new Pikachu[100];
        
        for(int i=0; i<manyPikachus.length; i++){
            manyPikachus[i] = new Pikachu();
            System.out.println(manyPikachus[i]);
        }
        
    }
}