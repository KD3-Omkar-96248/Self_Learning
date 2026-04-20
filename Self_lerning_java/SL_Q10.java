package com.sunbeam;

import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InStream 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting value: ");
        int start = scanner.nextInt();

        System.out.print("Enter the ending value: ");
        int end = scanner.nextInt();

        // Generate IntStream based on user input
        IntStream stream = IntStream.rangeClosed(start, end);

        // Calculate sum
        int sum = stream.sum();
        System.out.println("Sum: " + sum);

        // For summary statistics, create a new stream
        IntStream stream2 = IntStream.rangeClosed(start, end);
        IntSummaryStatistics stats = stream2.summaryStatistics();

        System.out.println("\n Summary Statistics:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());

        scanner.close(); // Close scanner to avoid resource leak
    }
}