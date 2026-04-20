package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;

public class GenericStaticMethod 
{
	public static <T> void selectionSort(T[] arr, Comparator<T> c) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(c.compare(arr[i], arr[j]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 8, 1, 9};
        String[] strArray = {"apple", "orange", "banana", "grape"};

        // Sorting integers in ascending order
        selectionSort(intArray, Integer::compareTo);
        System.out.println("Sorted integers: " + Arrays.toString(intArray));

        // Sorting strings in alphabetical order
        selectionSort(strArray, String::compareTo);
        System.out.println("Sorted strings: " + Arrays.toString(strArray));
    }
}