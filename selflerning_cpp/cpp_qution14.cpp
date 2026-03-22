#include <iostream>
using namespace std;

class BankAccount
{
private:
    double balance;

public:
    // Constructor
    BankAccount(double balance = 0.0)
    {
        this->balance = balance;
    }

    // Deposit function
    void deposit(double amount)
    {
        if (amount < 0)
            throw amount;   // throw double

        balance += amount;
        cout << "Deposited: " << amount << endl;
    }

    // Withdraw function
    void withdraw(double amount)
    {
        if (amount < 0)
            throw amount;   // throw double

        if (amount > balance)
            throw string("Insufficient Balance");  // throw string

        balance -= amount;
        cout << "Withdrawn: " << amount << endl;
    }

    void display()
    {
        cout << "Current Balance: " << balance << endl;
    }
};

int main()
{
    BankAccount acc(1000);  // initial balance

    try
    {
        acc.deposit(500);
        acc.withdraw(200);
        
        acc.deposit(-50);     // will throw double
        acc.withdraw(2000);   // will throw string
    }
    catch (double amt)
    {
        cout << "Error: Negative amount not allowed -> " << amt << endl;
    }
    catch (string msg)
    {
        cout << "Error: " << msg << endl;
    }

    acc.display();

    return 0;
}