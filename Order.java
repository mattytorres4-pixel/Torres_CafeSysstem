/**
 * Represents a customer order in the campus cafe.
 * Manages menu items, calculates prices and discounts,
 * and prints the order receipt.
 *
 * @author Matt Torres
 * @version 1.0
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates an order for a specific customer.
     *
     * @param orderId the unique order identification number
     * @param customer the customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    /**
     * Adds a menu item to the order.
     * An order can contain a maximum of three items.
     *
     * @param item the menu item to add
     */
    public void addItem(MenuItem item) {

        // Check if the menu item is null.
        if (item == null) {
            System.out.println("Invalid item!");
            return;
        }

        // Check if the order already contains three items.
        if (itemCount >= 3) {
            System.out.println("Order can only contain 3 items!");
            return;
        }

        // Place the item in the first slot if the order is empty.
        if (itemCount == 0) {
            item1 = item;
        }

        // Place the item in the second slot if one item exists.
        else if (itemCount == 1) {
            item2 = item;
        }

        // Place the item in the third slot otherwise.
        else {
            item3 = item;
        }

        itemCount++;
        System.out.println(item.getName() + " added to order.");
    }

    /**
     * Calculates the subtotal of all items in the order.
     *
     * @return the total price before discounts
     */
    public double computeSubtotal() {
        double subtotal = 0;

        // Add the first item's price if it exists.
        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        // Add the second item's price if it exists.
        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        // Add the third item's price if it exists.
        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Calculates the total price after applying
     * the student discount when applicable.
     *
     * @return the final order total in pesos
     */
    public double computeTotal() {
        double total = computeSubtotal();

        // Apply a 10% discount if the customer is a student.
        if (customer.isStudent()) {
            total -= total * 0.10;
        }

        return total;
    }

    /**
     * Calculates the total price after applying a voucher.
     * The final amount cannot be less than zero.
     *
     * @param voucher the voucher discount in pesos
     * @return the final total after the voucher deduction
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;

        // Prevent the final total from becoming negative.
        return Math.max(total, 0);
    }

    /**
     * Displays the order receipt including items,
     * subtotal, student discount, total, and loyalty points.
     */
    public void printReceipt() {
        System.out.println("\n================================");
        System.out.println("       CAMPUS CAFE RECEIPT");
        System.out.println("================================");

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());

        System.out.println("--------------------------------");

        // Display the first item if it exists.
        if (item1 != null) {
            System.out.printf("%-20s PHP %.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        // Display the second item if it exists.
        if (item2 != null) {
            System.out.printf("%-20s PHP %.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        // Display the third item if it exists.
        if (item3 != null) {
            System.out.printf("%-20s PHP %.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        double subtotal = computeSubtotal();

        // Calculate the student discount when applicable.
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;

        System.out.println("--------------------------------");
        System.out.printf("Subtotal: PHP %.2f%n", subtotal);
        System.out.printf("Student Discount: PHP %.2f%n", discount);
        System.out.printf("Total: PHP %.2f%n", computeTotal());

        // Award loyalty points based on the final amount spent.
        customer.addPoints(computeTotal());

        System.out.println("Loyalty Points: " + customer.getLoyaltyPoints());
        System.out.println("================================");
    }
}

