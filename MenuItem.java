/**
 * Represents an abstract menu item sold at the campus cafe.
 * It contains the common details and methods shared by all menu items.
 *
 * @author Matt Torres
 * @version 1.0
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Creates a menu item with default values.
     */
    public MenuItem() {
        name = "Unknown Item";
        basePrice = 0;
        itemCode = "N/A";
    }

    /**
     * Creates a menu item with the specified details.
     *
     * @param name the name of the menu item
     * @param basePrice the original price of the item
     * @param itemCode the unique code of the item
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Computes the final price of the menu item.
     *
     * @return the computed price in pesos
     */
    public abstract double computePrice();

    /**
     * Gets the description of the menu item.
     *
     * @return the name of the menu item
     */
    public String getDescription() {
        return name;
    }

    /**
     * Gets the name of the menu item.
     *
     * @return the menu item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the menu item if valid.
     *
     * @param name the new name of the menu item
     */
    public void setName(String name) {

        // Check if the name is not null or empty.
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }

        // Display an error if the name is invalid.
        else {
            System.out.println("Invalid item name!");
        }
    }

    /**
     * Gets the base price of the menu item.
     *
     * @return the original price of the item
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price if it is not negative.
     *
     * @param basePrice the new base price of the item
     */
    public void setBasePrice(double basePrice) {

        // Check if the price is zero or positive.
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        }

        // Display an error if the price is negative.
        else {
            System.out.println("Price cannot be negative!");
        }
    }

    /**
     * Gets the item code.
     *
     * @return the unique item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code if the value is valid.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {

        // Check if the item code is not null or empty.
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        }

        // Display an error if the item code is invalid.
        else {
            System.out.println("Invalid item code!");
        }
    }
}



