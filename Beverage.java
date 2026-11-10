/**
 * Represents a beverage sold at the campus cafe.
 * The price depends on the selected beverage size.
 *
 * @author Matt Torres
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String size;

    /**
     * Creates a beverage with the default small size.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Creates a beverage with the specified details and size.
     *
     * @param name the name of the beverage
     * @param basePrice the original price of the beverage
     * @param itemCode the unique code of the beverage
     * @param size the selected beverage size
     */
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Computes the final beverage price based on its size.
     *
     * @return the final price of the beverage in pesos
     */
    @Override
    public double computePrice() {

        // Check if the selected size is Large.
        if (size.equals("L")) {
            return basePrice + 25;
        }

        // Check if the selected size is Medium.
        else if (size.equals("M")) {
            return basePrice + 15;
        }

        // Small size uses the original base price.
        else {
            return basePrice;
        }
    }

    /**
     * Gets the beverage description including its size.
     *
     * @return the complete beverage description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /**
     * Gets the selected beverage size.
     *
     * @return the beverage size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the beverage size if the value is valid.
     *
     * @param size the beverage size (S, M, or L)
     */
    public void setSize(String size) {

        // Accept only Small, Medium, or Large.
        if (size != null &&
                (size.equals("S") ||
                        size.equals("M") ||
                        size.equals("L"))) {

            this.size = size;
        }

        // Display an error message for an invalid size.
        else {
            System.out.println("Invalid beverage size!");
        }
    }
}
