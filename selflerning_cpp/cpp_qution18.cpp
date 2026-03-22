#include <iostream>
using namespace std;

// Generic Array Class
template <class T>
class Array
{
private:
    T* arr;
    int size;

public:
    // Constructor
    Array(int size)
    {
        this->size = size;
        arr = new T[size];
    }

    // Destructor (prevents memory leak)
    ~Array()
    {
        delete[] arr;
        cout << "Memory freed" << endl;
    }

    // Overload [] operator
    T& operator[](int index)
    {
        if (index < 0 || index >= size)
            throw "Index out of bounds";
        return arr[index];
    }

    int getSize()
    {
        return size;
    }
};

// User-defined class
class Student
{
private:
    int rollNo;
    string name;

public:
    void accept()
    {
        cout << "Enter Roll No: ";
        cin >> rollNo;
        cout << "Enter Name: ";
        cin >> name;
    }

    void display()
    {
        cout << "Roll No: " << rollNo << ", Name: " << name << endl;
    }
};

int main()
{
    try
    {
        int n;
        cout << "Enter number of students: ";
        cin >> n;

        Array<Student> students(n);

        // Accept data
        for (int i = 0; i < students.getSize(); i++)
        {
            cout << "\nStudent " << i + 1 << endl;
            students[i].accept();
        }

        // Display data
        cout << "\nStudent Records:\n";
        for (int i = 0; i < students.getSize(); i++)
        {
            students[i].display();
        }
    }
    catch (const char* msg)
    {
        cout << "Exception: " << msg << endl;
    }

    return 0;
}