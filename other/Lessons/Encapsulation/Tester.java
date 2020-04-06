
public class Tester
{
    public static void main(String[] args){
        Professor ken = new Professor("Ken");
        System.out.println(ken);
        
        Professor sarah = new Professor("Sarah is the 3rd best");
        
        
        Course cosc111 = new Course("COSC 111");
        Course cosc118 = new Course("COSC 118");
        
        cosc111.addProf(ken);
        
        cosc111.addStudent("Belek");
        cosc111.addStudent("Artur");
        cosc111.addStudent("David");
        cosc111.addStudent("Nate");
        cosc111.addStudent("Mattias");
        cosc111.addStudent("Red headed step child or Jake");
        cosc111.addStudent("Vence");
        cosc111.addStudent("Hannah");
        
        System.out.println(cosc111);
        
        cosc118.addProf(sarah);
        cosc118.addStudent("Jenny");
        //cocs118.addStudent("Jenny");
        System.out.println(cosc118);
    }
}
