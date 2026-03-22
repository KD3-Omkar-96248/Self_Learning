#include <iostream>
#include <list>
#include <algorithm>
#include <cstdlib>
using namespace std;

int main()
{
    list<int> lst;

    for (int i = 0; i < 10; i++)
    {
        lst.push_back(rand() % 100);
    }

    cout << "Reverse Order:\n";
    list<int>::reverse_iterator rit;
    for (rit = lst.rbegin(); rit != lst.rend(); rit++)
    {
        cout << *rit << " ";
    }
    cout << endl;

    for (list<int>::iterator it = lst.begin(); it != lst.end(); it++)
    {
        *it = *it + 5;
    }

    cout << "\nUsing Const Iterator:\n";
    list<int>::const_iterator cit;
    for (cit = lst.begin(); cit != lst.end(); cit++)
    {
        cout << *cit << " ";
    }
    cout << endl;

    lst.sort();

    cout << "\nSorted List:\n";
    for (list<int>::iterator it = lst.begin(); it != lst.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;

    return 0;
}