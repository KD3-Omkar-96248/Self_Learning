import java.util.ArrayList;
import java.util.List;

class Student 
{
    private String name;
    private int id;
    private List<String> courses;

    public Student() 
    {
        this.name = "Unknown";
        this.id = 0;
        this.courses = new ArrayList<>();
    }

    public Student(String name, int id, List<String> courses) 
    {
        this.name = name;
        this.id = id;
        this.courses = courses;
    }

    public Student(Student other, boolean isShallow) 
    {
        this.name = other.name;
        this.id = other.id;
        if (isShallow)
        {
            this.courses = other.courses; 
        } else 
        {
            this.courses = new ArrayList<>(other.courses);
        }
    }

    public void addCourse(String course)
    { this.courses.add(course); }
    
    public List<String> getCourses() { return courses; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Courses: " + courses;
    }
}