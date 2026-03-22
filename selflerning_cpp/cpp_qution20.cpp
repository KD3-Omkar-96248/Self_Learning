#include <iostream>
#include <memory>
using namespace std;

class Demo
{
public:
    Demo() { cout << "Constructor called\n"; }
    ~Demo() { cout << "Destructor called\n"; }

    void show()
    {
        cout << "Inside Demo class\n";
    }
};

int main()
{

    unique_ptr<Demo> p1 = make_unique<Demo>();
    p1->show();

    unique_ptr<Demo> p2 = move(p1); 

    if (!p1)
        cout << "p1 is now null after transfer\n";

    p2->show();

    cout << "----------------------\n";

    
    shared_ptr<Demo> sp1 = make_shared<Demo>();
    cout << "sp1 use_count: " << sp1.use_count() << endl;

    shared_ptr<Demo> sp2 = sp1;
    cout << "sp1 use_count after sharing: " << sp1.use_count() << endl;

    sp2->show();

    cout << "----------------------\n";


    weak_ptr<Demo> wp = sp1;

    cout << "Accessing weak_ptr:\n";
    if (auto temp = wp.lock()) 
    {
        temp->show();
        cout << "use_count: " << temp.use_count() << endl;
    }
    else
    {
        cout << "Object no longer exists\n";
    }

    return 0;
}