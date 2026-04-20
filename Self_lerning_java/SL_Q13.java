package com.sunbeam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student 
{
    private int roll;
    private String name;
    private String city;
    private double marks;
    
    public Student(int roll, String name, String city, double marks) 
    {
        this.roll = roll;
        this.name = name;
        this.city = city;
        this.marks = marks;
    }

    public int getRoll() 
    {
        return roll;
    }

    public String getName() 
    {
        return name;
    }

    public String getCity() 
    {
        return city;
    }

    public double getMarks() 
    {
        return marks;
    }

    @Override
    public String toString() 
    {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", marks=" + marks +
                '}';
    }
}

public class StudentUsingComparator
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter details for student " + (i + 1) + ":");
            
            System.out.print("Roll number: ");
            int roll = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("City: ");
            String city = scanner.nextLine();

            System.out.print("Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(roll, name, city, marks);
        }

        Arrays.sort(students, new Comparator<Student>() 
        {
            @Override
            public int compare(Student s1, Student s2) 
            {
                int cityCompare = s2.getCity().compareTo(s1.getCity());
                if (cityCompare != 0) 
                {
                    return cityCompare;
                }
             
                int marksCompare = Double.compare(s2.getMarks(), s1.getMarks());
                if (marksCompare != 0) 
                {
                    return marksCompare;
                }
          
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("\nSorted list of students:");
        for (Student s : students) 
        {
            System.out.println(s);
        }

        scanner.close();
    }
}