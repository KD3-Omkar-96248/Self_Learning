package com.sunbeam;

import java.util.Scanner;

public class ArrayofNumber 
{
    public static <T extends Number> T findMinimum(T[] array)
    {
        if (array == null || array.length == 0) {
            return null;
        }
        T min = array[0];
        for (T num : array) 
        {
            if (num.doubleValue() < min.doubleValue()) 
            {
                min = num;
            }
        }
        return min;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Read Integer array
        System.out.print("Enter number of integers: ");
        int intSize = scanner.nextInt();
        Integer[] intArray = new Integer[intSize];
        System.out.println("Enter " + intSize + " integers:");
        for (int i = 0; i < intSize; i++) 
        {
            intArray[i] = scanner.nextInt();
        }

        // Read Double array
        System.out.print("Enter number of doubles: ");
        int doubleSize = scanner.nextInt();
        Double[] doubleArray = new Double[doubleSize];
        System.out.println("Enter " + doubleSize + " doubles:");
        for (int i = 0; i < doubleSize; i++) 
        {
            doubleArray[i] = scanner.nextDouble();
        }

        // Find and display minimums
        System.out.println("Minimum Integer: " + findMinimum(intArray));
        System.out.println("Minimum Double: " + findMinimum(doubleArray));

        scanner.close(); // Close scanner
    }
}