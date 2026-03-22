#include <iostream>
#include <cstring>
#include <string>

class Payment {
public:
    virtual void makePayment(double amount) = 0;
    virtual ~Payment() {}
};

class CreditCard : public Payment {
public:
    void makePayment(double amount) override {
        std::cout << "Processing Credit Card payment of $" << amount 
                  << " via Secure Gateway...\n";
    }
};

class UPI : public Payment {
public:
    void makePayment(double amount) override {
        std::cout << "Processing UPI payment of $" << amount 
                  << " via Virtual Private Address...\n";
    }
};

class Cash : public Payment {
public:
    void makePayment(double amount) override {
        std::cout << "Collecting Cash payment of $" << amount 
                  << " at the counter.\n";
    }
};

class PaymentFactory {
public:
    static Payment* create(const char* mode) {
        if (std::strcmp(mode, "Credit") == 0) {
            return new CreditCard();
        } else if (std::strcmp(mode, "UPI") == 0) {
            return new UPI();
        } else if (std::strcmp(mode, "Cash") == 0) {
            return new Cash();
        }
        return nullptr;
    }
};

int main() {
    char mode[20];
    double amount;

    std::cout << "Enter payment mode (Credit/UPI/Cash): ";
    std::cin >> mode;
    std::cout << "Enter amount: ";
    std::cin >> amount;

    Payment* myPayment = PaymentFactory::create(mode);

    if (myPayment != nullptr) {
        myPayment->makePayment(amount);
        delete myPayment;
    } else {
        std::cout << "Invalid payment mode selected.\n";
    }

    return 0;
}