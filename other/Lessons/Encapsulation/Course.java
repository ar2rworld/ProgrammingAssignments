public class Course
{
    private String name;
    private Professor prof;
    private Student[] students = new Student[40];
    private int numStudents;
    
    public Course(String name){
        this.name = name;
        numStudents = 0;
        
    }
    
    public void addStudent(String studentName){
        students[numStudents] = new Student(studentName);
        numStudents ++;
        
    }
    public void addProf(Professor p){
        prof = p;
    }
    
    public String toString(){
        String temp = name + "\n" + prof + "\n";
        for(int i=0;i<numStudents; i++){
            temp += students[i] + "\n";
        }
        return temp;
    }
}
