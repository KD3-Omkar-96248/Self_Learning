import java.util.Scanner;
import java.util.stream.IntStream;

public class FactorialUsingStream 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n < 0) 
        {
            System.out.println("Factorial is not defined for negative numbers.");
        } 
        else 
        {
            long factorial = IntStream.rangeClosed(1, n)
                                      .reduce(1, (a, b) -> a * b);

            System.out.println("Factorial of " + n + " is: " + factorial);
        }

        sc.close();
    }
}