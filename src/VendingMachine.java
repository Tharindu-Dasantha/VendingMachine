import java.util.Scanner;

public class VendingMachine {

    private static Product[] products = new Product[50];
    private static Scanner getInput = new Scanner(System.in);
    private static double income = 0.0;

    public static void main(String[] args) {
        while(true) {
            System.out.println("Welcome to the Vending Machine!");
            displayMenu();
            System.out.println("Enter your choice: ");
            int choice = getInput.nextInt();
            getInput.nextLine();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProducts();
                    break;
                case 3:
                    purchaseProducts();
                    break;
                case 4:
                    displayIncome();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

//    Create a GUI later using JavaFX
    public static void displayMenu() {
        System.out.println("1. Display Products");
        System.out.println("2. Add Products");
        System.out.println("3. Purchase Products");
        System.out.println("4. Display Income");
        System.out.println("5. Exit");
    }

    public static void displayProducts() {
        for (Product product: products) {
            if (product != null) {
                System.out.println("Name: " + product.getName());
                System.out.println("Type: " + product.getType());
                System.out.println("Price: " + product.getPrice());
                System.out.println();
            }
        }
    }

    public static void addProducts() {
        System.out.println("Enter product name: ");
        String name = getInput.nextLine();
        System.out.println("Enter product type: ");
        String type = getInput.nextLine();
        System.out.println("Enter product price: ");
        double price = getInput.nextDouble();
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = new Product(name, type, price);
                break;
            }
        }
    }

    public static void purchaseProducts() {
        System.out.println("Enter product name: ");
        String name = getInput.nextLine();
        for (Product product: products) {
            if (product != null && product.getName().equals(name)) {
                System.out.println("Product found!");
                System.out.println("Enter payment amount: ");
                double payment = getInput.nextDouble();
                if (payment >= product.getPrice()) {
                    income += product.getPrice();
                    System.out.println("Payment successful!");
                } else {
                    System.out.println("Insufficient payment. Please try again.");
                }
                break;
            }
        }
    }

    public static void displayIncome() {
        System.out.println("Income: " + income);
    }
}
