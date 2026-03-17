#include <iostream>
#include <string>
using namespace std;

class Person
{
protected:
    string name;
    int age;

public:
    Person(string n, int a) : name(n), age(a) {}

    virtual void display()
    {
        cout << "\nName: " << name << endl;
        cout << "Age: " << age << endl;
    }

    virtual void work() = 0; // Pure virtual function (abstract)
};

class Student : public Person
{
private:
    float marks;

public:
    Student(string n, int a, float m) : Person(n, a), marks(m) {}

    void study()
    {
        cout << name << " is studying." << endl;
    }

    void display() override
    {
        Person::display();
        cout << "Marks: " << marks << endl;
    }

    void work() override
    {
        cout << name << " is doing homework and attending classes." << endl;
    }
};

class Teacher : public Person
{
private:
    float salary;

public:
    Teacher(string n, int a, float s) : Person(n, a), salary(s) {}

    void teach()
    {
        cout << name << " is teaching students." << endl;
    }

    void display() override
    {
        Person::display();
        cout << "Salary: " << salary << endl;
    }

    void work() override
    {
        cout << name << " is preparing lessons and teaching classes." << endl;
    }
};

int main()
{
    Person* p1 = new Student("Alice", 20, 88.5);
    Person* p2 = new Teacher("Mr. Bob", 40, 50000);

    p1->display();
    p1->work();
    static_cast<Student*>(p1)->study();

    p2->display();
    p2->work();
    static_cast<Teacher*>(p2)->teach();

    delete p1;
    delete p2;

    return 0;
}