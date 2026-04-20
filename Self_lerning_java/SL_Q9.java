import java.util.*;

public class SumUsingStream 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) 
        {
            numbers.add(sc.nextInt());
        }

        int sum = numbers.stream()
                         .mapToInt(Integer::intValue)
                         .sum();

        System.out.println("Sum of elements: " + sum);

        sc.close();
    }
}