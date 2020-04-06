public class Rectangle{
    private double width;
    private double length;
    private String name;
    public Rectangle(double width, double length){
        this.width = width;
        //width = w;
        this.length = length;
    }
    
    public double getArea(){
        return width*length;
    }
    public double getPerimeter(){
        return (width+length)*2;
    }
    public String toString(){
        return "Rectangle with width of " + width + " and length of "+ length;
    }
}