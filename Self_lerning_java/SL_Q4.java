import java.util.Scanner;

public class EnumDemo 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Day Checker System ===");
        System.out.print("Enter a day of the week (e.g., Monday): ");
        String input = sc.nextLine().trim().toUpperCase();

        try 
        {
            Day selectedDay = Day.valueOf(input);

            System.out.println("\n--- Analysis ---");
            System.out.println("Day: " + selectedDay);
            System.out.println("Type: " + selectedDay.getDayType());
            
            if (selectedDay.isWeekend()) 
            {
                System.out.println("Action: Time to relax!");
            } 
            else 
            {
                System.out.println("Action: Time to work!");
            }

        } catch (IllegalArgumentException e) 
        {
            System.out.println("Error: '" + input + "' is not a valid day of the week.");
        }

        sc.close();
    }
}