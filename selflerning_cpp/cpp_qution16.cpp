#include <iostream>
using namespace std;

class Student
{
public:
    void display()
    {
        cout << "Student Display" << endl;
    }
};


class SmartPointer
{
private:
    Student* ptr;

public:
    
    SmartPointer(Student* ptr)
    {
        this->ptr = ptr;
    }

    
    ~SmartPointer()
    {
        delete ptr;
        cout << "Memory freed automatically" << endl;
    }

    
    Student* operator->()
    {
        return ptr;
    }
};

int main()
{
    try
    {
        SmartPointer s(new Student());

        
        s->display();
    }
    catch(...)
    {
        cout << "Invalid input" << endl;
    }

    return 0;
}