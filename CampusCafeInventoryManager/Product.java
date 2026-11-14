package AirTribeAssignments.CampusCafeInventoryManager;


// Product.java

public class Product {

    static int totalProducts = 0;

    String name;
    double price;
    int quantity;

    // 1. No-argument constructor
    Product() {
        name = "Unknown";
        price = 0;
        quantity = 0;
        totalProducts++;
    }

    // 2. Parameterized constructor
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }

    // 3. Copy constructor
    Product(Product other) {
        this.name = other.name;
        this.price = other.price;
        this.quantity = other.quantity;
        totalProducts++;
    }

    // Calculate stock value
    double stockValue() {
        return price * quantity;
    }

    // Display product details
    void display() {
        System.out.println(name + " | Rs " + price + " | qty " + quantity);
    }
}

