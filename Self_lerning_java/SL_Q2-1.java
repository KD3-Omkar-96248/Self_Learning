import java.util.Scanner;

public class ShapeSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a Shape:\n1. Circle\n2. Rectangle\n3. Sphere\n4. Cube");
        int choice = sc.nextInt();

        Shape selectedShape = null;

        switch (choice) 
        {
            case 1:
                System.out.print("Enter Radius: ");
                selectedShape = new Circle(sc.nextDouble());
                break;
            case 2:
                System.out.print("Enter Length & Width: ");
                selectedShape = new Rectangle(sc.nextDouble(), sc.nextDouble());
                break;
            case 3:
                System.out.print("Enter Radius: ");
                selectedShape = new Sphere(sc.nextDouble());
                break;
            case 4:
                System.out.print("Enter Side: ");
                selectedShape = new Cube(sc.nextDouble());
                break;
            default:
                System.out.println("Invalid choice!");
        }

        if (selectedShape != null)
        {
            System.out.println("\n--- Result ---");
            selectedShape.displayInfo();
        }
        sc.close();
    }
}