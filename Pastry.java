/**
 * Represents a pastry sold at the campus cafe.
 * The price increases when the pastry is heated.
 *
 * @author Matt Torres
 * @version 1.0
 */
public class Pastry extends MenuItem {

    private boolean heated;

    /**
     * Creates a pastry with the default unheated status.
     */
    public Pastry() {
        super();
        heated = false;
    }

    /**
     * Creates a pastry with the specified details.
     *
     * @param name the name of the pastry
     * @param basePrice the original price of the pastry
     * @param itemCode the unique code of the pastry
     * @param heated indicates whether the pastry is heated
     */
    public Pastry(String name, double basePrice, String itemCode,
                  boolean heated) {
        super(name, basePrice, itemCode);
        this.heated = heated;
    }

    /**
     * Checks whether the pastry is heated.
     *
     * @return true if the pastry is heated, otherwise false
     */
    public boolean isHeated() {
        return heated;
    }

    /**
     * Sets the heating status of the pastry.
     *
     * @param heated true if the pastry should be heated
     */
    public void setHeated(boolean heated) {
        this.heated = heated;
    }

    /**
     * Computes the final pastry price based on its heating status.
     *
     * @return the final price of the pastry in pesos
     */
    @Override
    public double computePrice() {

        // Add 10 pesos if the pastry is heated.
        if (heated) {
            return basePrice + 10;
        }

        // Return the original price if the pastry is not heated.
        return basePrice;
    }

    /**
     * Gets the pastry description including its heating status.
     *
     * @return the pastry description
     */
    @Override
    public String getDescription() {

        // Add a label if the pastry is heated.
        if (heated) {
            return name + " (Heated)";
        }

        // Return only the name if the pastry is not heated.
        return name;
    }
}

