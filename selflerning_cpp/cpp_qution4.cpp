/*4. Create a class named Laptop with the following specifications:
Class Requirements:
Private data members:
brandId
price
A parameterless constructor that:
Initializes brandId to 1
Initializes price to 50000
Displays the message:
"Laptop Constructor Called"
A destructor that displays the message:
"Laptop Destructor Called"
A member function display() that prints the laptop details.

*/
#include <iostream>
using namespace std;

class Laptop
{
    private:
    int id;
    double price;\
    
    private:
    Laptop(void):id(0) , price(0)
    { }
    Laptop(int id,double price):id(id),price(price)
    {  }
       
}
