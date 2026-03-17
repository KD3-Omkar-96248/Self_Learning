#include <iostream>
using namespace std;


class Student
{
public:
    int rollNo;
    float marks;
};

int main()
{
    int n;

    
    cout << "Enter number of students: ";
    cin >> n;

    
    Student *s = new Student[n];

    
    for(int i = 0; i < n; i++)
    {
        cout << "\nEnter details for student " << i + 1 << endl;
        cout << "Roll No: ";
        cin >> s[i].rollNo;
        cout << "Marks: ";
        cin >> s[i].marks;
    }


    cout << "\n--- Student Records ---" << endl;
    for(int i = 0; i < n; i++)
    {
        cout << "Student " << i + 1 << ": ";
        cout << "Roll No = " << s[i].rollNo 
             << ", Marks = " << s[i].marks << endl;
    }

 
    float maxMarks = s[0].marks;
    int topperRoll = s[0].rollNo;

    for(int i = 1; i < n; i++)
    {
        if(s[i].marks > maxMarks)
        {
            maxMarks = s[i].marks;
            topperRoll = s[i].rollNo;
        }
    }

    
    cout << "\nHighest Marks: " << maxMarks << endl;
    cout << "Topper Roll No: " << topperRoll << endl;

   
    delete[] s;

    return 0;
}