#include <iostream>
#include <string>

class Product {
protected:
    std::string title;
    float price;

public:
    virtual void accept() {
        std::cout << "Enter title: ";
        std::cin >> title;
        std::cout << "Enter price: ";
        std::cin >> price;
    }

    virtual void display() = 0;

    virtual ~Product() {}
};

class Book : public Product {
private:
    int pages;

public:
    void accept() override {
        Product::accept();
        std::cout << "Enter pages: ";
        std::cin >> pages;
    }

    void display() override {
        std::cout << "Pages: " << pages << std::endl;
    }
};

class Tape : public Product {
private:
    float playtime;

public:
    void accept() override {
        Product::accept();
        std::cout << "Enter playtime (mins): ";
        std::cin >> playtime;
    }

    void display() override {
        std::cout << "Playtime: " << playtime << std::endl;
    }
};

int main() {
    Product** arr = new Product*[5];
    int choice;

    for (int i = 0; i < 5; i++) {
        std::cout << "\nItem " << i + 1 << " - 1. Book, 2. Tape. Enter choice: ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                arr[i] = new Book();
                arr[i]->accept();
                break;
            case 2:
                arr[i] = new Tape();
                arr[i]->accept();
                break;
            default:
                std::cout << "Invalid choice, defaulting to Book.\n";
                arr[i] = new Book();
                arr[i]->accept();
                break;
        }
    }

    std::cout << "\n--- Displaying Pages/Playtime ---\n";
    for (int i = 0; i < 5; i++) {
        arr[i]->display();
    }

    for (int i = 0; i < 5; i++) {
        delete arr[i];
    }
    delete[] arr;

    return 0;
}