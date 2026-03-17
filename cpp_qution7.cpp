#include <iostream>
#include <string>
using namespace std;

class BankAccount
{
private:
    int accountNumber;
    string accountHolderName;
    double balance;

public:
    BankAccount(int accNo, string name, double initialBalance)
    {
        accountNumber = accNo;
        accountHolderName = name;
        balance = initialBalance;
    }

    void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            cout << "Amount deposited: " << amount << endl;
        }
        else
        {
            cout << "Invalid deposit amount!" << endl;
        }
    }

    void withdraw(double amount)
    {
        if(amount > 0 && amount <= balance)
        {
            balance -= amount;
            cout << "Amount withdrawn: " << amount << endl;
        }
        else
        {
            cout << "Insufficient balance or invalid amount!" << endl;
        }
    }

    void displayBalance()
    {
        cout << "\nAccount Number: " << accountNumber << endl;
        cout << "Account Holder: " << accountHolderName << endl;
        cout << "Balance: " << balance << endl;
    }
};

int main()
{
    BankAccount account1(101, "Alice", 5000);

    account1.displayBalance();
    account1.deposit(2000);
    account1.withdraw(1500);
    account1.displayBalance();

    return 0;
}