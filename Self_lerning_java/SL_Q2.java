abstract class Shape 
{
    protected String name;
    public Shape(String name) 
    { this.name = name; }
    
    public abstract void displayInfo();
}

abstract class TwoDShape extends Shape 
{
    public TwoDShape(String name) 
    { super(name); }
    
    public abstract double calculateArea();
}

abstract class ThreeDShape extends Shape
{
    public ThreeDShape(String name)
    
    { super(name); }
    public abstract double calculateArea(); 
    public abstract double calculateVolume();
}

class Circle extends TwoDShape 
{
    private double radius;
    public Circle(double radius) 
    { super("Circle"); this.radius = radius; }
    
    public double calculateArea() 
    { return Math.PI * radius * radius; }
    
    public void displayInfo() 
    { System.out.printf("Shape: %s | Area: %.2f%n", name, calculateArea()); }
}

class Rectangle extends TwoDShape 
{
    private double l, w;
    public Rectangle(double l, double w) 
    { super("Rectangle"); this.l = l; this.w = w; }
    
    public double calculateArea() 
    { return l * w; }
    
    public void displayInfo() { System.out.printf("Shape: %s | Area: %.2f%n", name, calculateArea()); }
}

class Sphere extends ThreeDShape 
{
    private double radius;
    public Sphere(double radius) 
    { super("Sphere"); this.radius = radius; }
    
    public double calculateArea()
    { return 4 * Math.PI * radius * radius; }
    
    public double calculateVolume()
    { return (4.0/3.0) * Math.PI * Math.pow(radius, 3); }
    public void displayInfo() 
    { 
        System.out.printf("Shape: %s | Surface Area: %.2f | Volume: %.2f%n", name, calculateArea(), calculateVolume()); 
    }
}

class Cube extends ThreeDShape 
{
    private double side;
    public Cube(double side) 
    { super("Cube"); this.side = side; }
    
    public double calculateArea() 
    { return 6 * side * side; }
    
    public double calculateVolume() 
    { return Math.pow(side, 3); }
    public void displayInfo() 
    { 
        System.out.printf("Shape: %s | Surface Area: %.2f | Volume: %.2f%n", name, calculateArea(), calculateVolume()); 
    }
}