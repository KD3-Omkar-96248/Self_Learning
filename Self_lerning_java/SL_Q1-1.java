import java.util.ArrayList;
import java.util.List;

public class StudentSystem {
    public static void main(String[] args) {
        // Initial setup
        List<String> initialCourses = new ArrayList<>();
        initialCourses.add("Java 101");
        
        Student original = new Student("Alice", 101, initialCourses);

        Student shallowCopy = new Student(original, true);
        Student deepCopy = new Student(original, false);

        System.out.println("--- Before Modification ---");
        System.out.println("Original: " + original);
        System.out.println("Shallow:  " + shallowCopy);
        System.out.println("Deep:     " + deepCopy);

        original.addCourse("Data Structures");

        System.out.println("\n--- After Adding 'Data Structures' to Original ---");
        System.out.println("Original: " + original);
        
        System.out.println("Shallow:  " + shallowCopy); 
        
        System.out.println("Deep:     " + deepCopy); 
    }
}
