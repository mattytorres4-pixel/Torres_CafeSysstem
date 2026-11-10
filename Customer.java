/**
 * Represents a customer of the campus cafe.
 * Stores customer information, student status, and loyalty points.
 *
 * @author Matt Torres
 * @version 1.0
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Creates a customer with default values.
     */
    public Customer() {
        this.name = "Unknown Customer";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Creates a customer using the specified name.
     *
     * @param name the customer's name
     */
    public Customer(String name) {
        this.name = name;
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name the customer's name
     * @param student indicates whether the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly to the customer.
     *
     * @param points the number of points to add
     */
    public void addPoints(int points) {

        // Add points only if the value is positive.
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds loyalty points based on the amount spent.
     * One point is earned for every 50 pesos spent.
     *
     * @param amountSpent the total amount spent in pesos
     */
    public void addPoints(double amountSpent) {

        // Calculate points only if the amount spent is valid.
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        }
    }

    /**
     * Gets the customer's name.
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's name if valid.
     *
     * @param name the new customer name
     */
    public void setName(String name) {

        // Check if the name is not null or empty.
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }

        // Display an error if the name is invalid.
        else {
            System.out.println("Invalid customer name!");
        }
    }

    /**
     * Checks whether the customer is a student.
     *
     * @return true if the customer is a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the customer's student status.
     *
     * @param student true if the customer is a student
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the customer's loyalty points.
     *
     * @return the current loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the customer's loyalty points if valid.
     *
     * @param loyaltyPoints the new number of loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {

        // Check if the loyalty points are zero or positive.
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }

        // Display an error if the points are negative.
        else {
            System.out.println("Loyalty points cannot be negative!");
        }
    }
}

