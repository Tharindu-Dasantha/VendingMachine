import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class test {

    private Scanner getInput = new Scanner("");

    // Test for displaying an empty list of products
    @Test
    public void testDisplayProductsEmpty() {
        VendingMachine machine = new VendingMachine();
        machine.displayProducts();
        assertEquals("No products available.", getInput.nextLine());
    }

    // Test for adding a product
    @Test
    public void testAddProduct() {
        VendingMachine machine = new VendingMachine();
        machine.addProducts();
        assertTrue(machine.products[0] != null);
    }

    // Test for purchasing a product with sufficient payment
    @Test
    public void testPurchaseProductSuccess() {
        VendingMachine machine = new VendingMachine();
        machine.products[0] = new Product("Chocolate Bar", "Candy", 1.50);
        machine.purchaseProducts();
        assertTrue(machine.income == 1.50);
    }

    // Test for handling insufficient payment
    @Test
    public void testPurchaseProductInsufficientPayment() {
        VendingMachine machine = new VendingMachine();
        machine.products[0] = new Product("Chips", "Snack", 2.00);
        machine.purchaseProducts();
        assertTrue(machine.income == 0.0);
        assertEquals("Insufficient payment. Please try again.", getInput.nextLine());
    }

    // Test for displaying income
    @Test
    public void testDisplayIncome() {
        VendingMachine machine = new VendingMachine();
        machine.income = 50.0;
        machine.displayIncome();
        assertEquals("Income: 50.0", getInput.nextLine());
    }

    // Test for handling invalid menu choices
    @Test
    public void testInvalidMenuChoice() {
        VendingMachine machine = new VendingMachine();
        getInput = new Scanner("6\n"); // Simulate invalid choice
        machine.main(null);
        assertEquals("Invalid choice. Please try again.", getInput.nextLine());
    }
}
