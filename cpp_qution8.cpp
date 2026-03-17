#include <iostream>
#include <string>
using namespace std;

namespace college
{
    class Student
    {
    private:
        int rollNo;
        string name;
        float marks;

    public:
        Student() : rollNo(0), name(""), marks(0.0) {}
        Student(int r, string n, float m) : rollNo(r), name(n), marks(m) {}

        void setRollNo(int r) { rollNo = r; }
        void setName(string n) { name = n; }
        void setMarks(float m) { marks = m; }

        int getRollNo() { return rollNo; }
        string getName() { return name; }
        float getMarks() { return marks; }

        void display()
        {
            cout << "\nStudent Details:\n";
            cout << "Roll No: " << rollNo << endl;
            cout << "Name: " << name << endl;
            cout << "Marks: " << marks << endl;
        }
    };

    class Teacher
    {
    private:
        int empId;
        string name;
        string subject;

    public:
        Teacher() : empId(0), name(""), subject("") {}
        Teacher(int e, string n, string s) : empId(e), name(n), subject(s) {}

        void setEmpId(int e) { empId = e; }
        void setName(string n) { name = n; }
        void setSubject(string s) { subject = s; }

        int getEmpId() { return empId; }
        string getName() { return name; }
        string getSubject() { return subject; }

        void display()
        {
            cout << "\nTeacher Details:\n";
            cout << "Employee ID: " << empId << endl;
            cout << "Name: " << name << endl;
            cout << "Subject: " << subject << endl;
        }
    };
}

int main()
{
    college::Student s1(101, "Alice", 88.5);
    college::Teacher t1(201, "Mr. Bob", "Mathematics");

    s1.display();
    t1.display();

    s1.setMarks(92.0);
    t1.setSubject("Physics");

    cout << "\nAfter updates:\n";
    s1.display();
    t1.display();

    return 0;
}