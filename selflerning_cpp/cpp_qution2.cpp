#include<iostream>
using namespace std;
inline int factorial (int n)
{
    int fact = 1;
    for(int i = 1; i<= n;i++)
    {
        fact *= i;
    }
    return fact;
}
inline int power(int base , int exp)
{
    int result = 1;
    for(int i = 0; i < exp; i++)
    {
        result *= base;
    }
    return result;
}
int main()
{
    int num = 5;
    int base = 2,exponent = 3;
    cout<<"factorial of "<<num<<"="<<factorial(num)<<endl;
    cout<<"Power (" << base << "^" << exponent << ") = " 
        << power(base , exponent)<<endl;
        return 0;
    
}    