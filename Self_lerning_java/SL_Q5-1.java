import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        TextAnalyzer analyzer = new TextAnalyzer();

        System.out.println("--- Java Text Analyzer ---");
        System.out.println("Enter the text you want to analyze:");
        
        String input = scanner.nextLine();

        if (input.isEmpty()) 
        {
            System.out.println("Error: Input text cannot be empty.");
        } 
        else 
        {
            analyzer.analyze(input);
            analyzer.displayStats();
        }

        scanner.close();
    }
}