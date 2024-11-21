

public class Rectangle{
    // attributes of a rectangle; declared private as to not be directly accessible from other classes
    private double width;
    private double height;


    // default constructor; sets object's width and height to 1.0
    public Rectangle(){
        width = 1.0;
        height = 1.0;
    }

    // overloaded constructor; sets object's width and height to values input by the user
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    // get methods allow other classes to access the private attributes of Rectangle objects

    // public method that returns the object's width
    public double getWidth(){
        return width;
    }

    // public method that returns the object's height
    public double getHeight(){
        return height;
    }

    // public method that returns the object's area using the formula A = h * w
    public double getArea(){
        return height * width;
    }

    // public method that returns the object's perimeter using the formula P = h + w + h + w = 2h + 2w
    public double getPerimeter(){
        return 2*height + 2*width;
    }

    // prints the height and width of a rectangle object with name objectName
    public String printRectangle(String objectName){
        return "Rectangle " + objectName + " is " + width + " units wide and " + height + " units high.";
    }
}