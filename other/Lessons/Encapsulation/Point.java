public class Point
{
    private double X;
    private double Y;
    public Point(double x, double y){
        this.X = x;
        this.Y = y;
    }
    public double getX(){
        return X;
    }
    public double getY(){
        return Y;
    }
    public String toString(){
        return "(" + X +", " + Y + ")" ;
    }
    public double dotProduct(Point a){
        return (double)(X*a.getX() + Y*a.getY());   
    }
    public boolean equals(Point a){
        return a.X==X && a.Y== Y;
    }
    public Point add(Point a){
        Point sum = new Point(a.X , a.Y);
        return sum;
    }
}
