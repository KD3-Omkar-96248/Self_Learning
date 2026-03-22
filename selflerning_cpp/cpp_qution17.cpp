#include <iostream>
#include <fstream>
using namespace std;

class Student
{
private:
    int rollNo;
    char name[50];
    double marks;

public:
    void accept()
    {
        cout << "Enter Roll No: ";
        cin >> rollNo;
        cout << "Enter Name: ";
        cin >> name;
        cout << "Enter Marks: ";
        cin >> marks;
    }

    void display()
    {
        cout << "\nRoll No: " << rollNo << endl;
        cout << "Name: " << name << endl;
        cout << "Marks: " << marks << endl;
    }

    // Save object to file
    void saveToFile()
    {
        ofstream fout("student.dat", ios::binary);
        fout.write((char*)this, sizeof(*this));
        fout.close();
    }

    // Load object from file
    void loadFromFile()
    {
        ifstream fin("student.dat", ios::binary);
        fin.read((char*)this, sizeof(*this));
        fin.close();
    }
};

int main()
{
    Student s1, s2;

    // Accept and save
    s1.accept();
    s1.saveToFile();

    // Load into another object
    s2.loadFromFile();

    cout << "\nLoaded Data from File:";
    s2.display();

    return 0;
}