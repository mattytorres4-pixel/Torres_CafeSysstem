/**
 * Main application class for the Campus Cafe Ordering System.
 * Demonstrates customer creation, menu items, order processing,
 * price computation, discounts, and receipt printing.
 *
 * @author Matt Torres
 * @version 1.0
 */
public class CafeApp {

    /**
     * Runs the Campus Cafe Ordering System.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Create customers.
        Customer customer1 = new Customer("Matt", true);
        Customer customer2 = new Customer("Malia");

        // Create beverages.
        Beverage beverage1 = new Beverage();
        beverage1.setName("Iced Coffee");
        beverage1.setBasePrice(80);
        beverage1.setItemCode("B001");
        beverage1.setSize("M");

        Beverage beverage2 = new Beverage(
                "Milk Tea", 90, "B002", "L"
        );

        // Create pastries.
        Pastry pastry1 = new Pastry();
        pastry1.setName("Chocolate Muffin");
        pastry1.setBasePrice(50);
        pastry1.setItemCode("P001");

        Pastry pastry2 = new Pastry(
                "Cheese Bread", 45, "P002", true
        );

        // Create meals.
        Meal meal1 = new Meal();
        meal1.setName("Chicken Rice");
        meal1.setBasePrice(120);
        meal1.setItemCode("M001");

        Meal meal2 = new Meal(
                "Burger Meal", 150, "M002", true, 2
        );

        // Test invalid inputs.
        System.out.println("Testing invalid inputs:");
        beverage2.setSize("XL");
        meal2.setExtraSides(-2);
        System.out.println();

        // Create the first order.
        Order order1 = new Order("ORD-001", customer1);

        order1.addItem(beverage1);
        order1.addItem(pastry1);
        order1.addItem(meal1);

        // Try adding a fourth item to test the order limit.
        System.out.println("\nAdding a fourth item:");
        order1.addItem(beverage2);

        // Create the second order.
        Order order2 = new Order("ORD-002", customer2);

        order2.addItem(beverage2);
        order2.addItem(pastry2);
        order2.addItem(meal2);

        // Display the receipts of both customers.
        order1.printReceipt();
        order2.printReceipt();

        // Apply a PHP 20 voucher to the second order.
        System.out.println("\nTotal with PHP 20 voucher: PHP "
                + order2.computeTotal(20));
    }
}


