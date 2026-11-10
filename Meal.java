/**
 * Represents a meal sold at the campus cafe.
 * The price depends on combo selection and extra sides.
 *
 * @author Matt Torres
 * @version 1.0
 */
public class Meal extends MenuItem {

    private boolean combo;
    private int extraSides;

    /**
     * Creates a meal with default values.
     */
    public Meal() {
        super();
        combo = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with the specified details.
     *
     * @param name the name of the meal
     * @param basePrice the original price of the meal
     * @param itemCode the unique code of the meal
     * @param combo indicates whether the meal is a combo
     * @param extraSides the number of additional sides
     */
    public Meal(String name, double basePrice, String itemCode,
                boolean combo, int extraSides) {
        super(name, basePrice, itemCode);
        this.combo = combo;
        setExtraSides(extraSides);
    }

    /**
     * Checks whether the meal is a combo.
     *
     * @return true if the meal is a combo, otherwise false
     */
    public boolean isCombo() {
        return combo;
    }

    /**
     * Sets whether the meal is a combo.
     *
     * @param combo true if the meal is a combo
     */
    public void setCombo(boolean combo) {
        this.combo = combo;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the number of extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides if valid.
     *
     * @param extraSides the number of additional sides
     */
    public void setExtraSides(int extraSides) {

        // Check if the number of extra sides is not negative.
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        }

        // Display an error if the number of extra sides is negative.
        else {
            System.out.println("Extra sides cannot be negative!");
        }
    }

    /**
     * Computes the final meal price including combo and extra sides.
     *
     * @return the final price of the meal in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        // Add 30 pesos if the meal is selected as a combo.
        if (combo) {
            price += 30;
        }

        // Add 15 pesos for every extra side.
        price += extraSides * 15;

        return price;
    }

    /**
     * Gets the meal description including its combo status.
     *
     * @return the meal description
     */
    @Override
    public String getDescription() {
        return name + (combo ? " (Combo)" : "");
    }
}
