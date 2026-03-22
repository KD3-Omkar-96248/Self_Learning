#include <iostream>
using namespace std;

// Custom Exception Class
class InvalidMarksException
{
private:
    string message;

public:
    InvalidMarksException(string message)
    {
        this->message = message;
    }

    string getMessage()
    {
        return this->message;
    }
};

class Student
{
private:
    int rollNo;
    string name;
    double marks;

public:
    Student(int rollNo, string name, double marks)
    {
        this->rollNo = rollNo;
        this->name = name;

        if (marks < 0)
            throw InvalidMarksException("Marks cannot be negative");

        this->marks = marks;
    }

    void setMarks(double marks)
    {
        if (marks < 0)
            throw InvalidMarksException("Marks cannot be negative");

        this->marks = marks;
    }

    void display()
    {
        cout << "Roll No: " << rollNo << endl;
        cout << "Name: " << name << endl;
        cout << "Marks: " << marks << endl;
    }
};

int main()
{
    try
    {
        Student s1(1, "Omkar", 85);
        s1.display();

        s1.setMarks(-10);   // will throw exception
    }
    catch (InvalidMarksException e)
    {
        cout << "Exception Caught: " << e.getMessage() << endl;
    }

    return 0;
}