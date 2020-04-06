public class Student
{
    private String name;
    private int studentID;
    private static int count = 300000000;
    
    public Student(String name){
        this.name = name;
        studentID = count;
        count++;
    }
    
    public String toString(){
        return "Student " + name + " : " + studentID;
    }
}
