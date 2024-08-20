public class Rectangle implements RectangleInterface, Comparable<Rectangle> { 
    
    private double length;
    private double width;
    
    public Rectangle(double l, double w){
        length = l;
        width = w;
    }  
    
    public double getLength(){
        return(length);
    }
    
    public double getWidth(){
        return(width);
    } 
    
    public int compareTo(Rectangle other){
        double perimeter1 = 2*(length + width);
        double perimeter2 = 2*(other.getWidth() + other.getLength());
        if (perimeter1<perimeter2)
            return -1;
        else if (perimeter1>perimeter2)
            return 1;
        return 0;
    }
    
}
