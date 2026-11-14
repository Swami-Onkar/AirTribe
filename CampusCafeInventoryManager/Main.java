package AirTribeAssignments.CampusCafeInventoryManager;


// Main.java

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }

            switch (choice) {

                // OPTION 1: ADD PRODUCT
                case 1:

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    if (count == 10) {
                        System.out.println("Inventory is full.");
                    }
                    else if (price <= 0 || quantity < 0) {
                        System.out.println("Invalid price or quantity.");
                    }
                    else {
                        products[count] = new Product(name, price, quantity);
                        count++;

                        System.out.println("Product added successfully.");
                    }

                    break;


                // OPTION 2: DISPLAY PRODUCTS
                case 2:

                    if (count == 0) {
                        System.out.println("No products in inventory.");
                    }
                    else {
                        for (int i = 0; i < count; i++) {

                            System.out.print((i + 1) + ". ");
                            products[i].display();

                        }
                    }

                    break;


                // OPTION 3: TOTAL STOCK VALUE
                case 3:

                    if (count == 0) {
                        System.out.println("No products in inventory.");
                    }
                    else {

                        double totalValue = 0;

                        for (int i = 0; i < count; i++) {
                            totalValue += products[i].stockValue();
                        }

                        System.out.println("Total stock value: Rs " + totalValue);
                    }

                    break;


                // OPTION 4: AVERAGE PRICE
                case 4:

                    if (count == 0) {
                        System.out.println("No products in inventory.");
                    }
                    else {

                        double totalPrice = 0;

                        for (int i = 0; i < count; i++) {
                            totalPrice += products[i].price;
                        }

                        double average = totalPrice / count;

                        System.out.println("Average price: " + average);

                        System.out.println("Rounded down: " + (int) average);
                    }

                    break;


                // OPTION 5: RESTOCK PRODUCT
                case 5:

                    System.out.print("Product number: ");
                    int num = sc.nextInt();

                    System.out.print("Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();

                    if (num < 1 || num > count || extra <= 0) {
                        System.out.println("Invalid product number or quantity.");
                    }
                    else {

                        products[num - 1].quantity += extra;

                        System.out.println("Product restocked successfully.");
                    }

                    break;


                // OPTION 6: DUPLICATE PRODUCT
                case 6:

                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    if (n < 1 || n > count) {
                        System.out.println("Invalid product number.");
                    }
                    else if (count == 10) {
                        System.out.println("Inventory is full.");
                    }
                    else {

                        Product copy = new Product(products[n - 1]);

                        copy.name = copy.name + " (copy)";

                        products[count] = copy;

                        count++;

                        System.out.println("Product duplicated successfully.");
                    }

                    break;


                // OPTION 0: EXIT
                case 0:

                    System.out.println("Goodbye!");

                    break;
            }

        } while (choice != 0);

        System.out.println("Products created in total: " + Product.totalProducts);

        sc.close();
    }
}