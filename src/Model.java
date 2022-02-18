/**
 * @author Yusuke K
 */

public class Model {
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;

    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    /**
     * @Model default constructor
     */
    public Model() {
    }

    /**
     * @param firstName
     * @param lastName
     * @param heightInches
     * @param weightPounds
     * @param traveler
     * @param smoker
     */
    public Model(String firstName, String lastName, int heightInches, double weightPounds, boolean traveler, boolean smoker) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(heightInches);
        setWeight((weightPounds));
        setCanTravel(traveler);
        setSmokes(smoker);
    }

    /**
     * @param firstName
     * @param lastName
     * @param heightInches
     * @param weightPounds
     */
    public Model(String firstName, String lastName, int heightInches, double weightPounds) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(heightInches);
        setWeight((weightPounds));
        setCanTravel(true);
        setSmokes(false);
    }

    /**
     * @return payrate hourly which model can be paid by
     */
    private int calculatePayDollarsPerHour() {
        int payDollarsPerHour = Model.BASE_RATE_DOLLARS_PER_HOUR;

        if (this.getHeight() > Model.TALL_INCHES && this.getWeight() < Model.THIN_POUNDS) {
            payDollarsPerHour += Model.TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (this.getTravel()) {
            payDollarsPerHour += Model.TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        if (this.getSmokes()) {
            payDollarsPerHour -= Model.SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }

        return payDollarsPerHour;
    }

    /**
     * show model profile in detail
     */
    public void displayModelDetails() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Height: " + this.getHeight() + " inches");
        System.out.println("Weight: " + Math.round(this.getWeight()) + " pounds");

        if (this.getTravel()) {
            System.out.println("Travels: yep");
        } else {
            System.out.println("Travels: nope");
        }
        if (this.getSmokes()) {
            System.out.println("Smokes:  yep");
        } else {
            System.out.println("Smokes:  nope");
        }

        System.out.println("Hourly rate: $" + this.calculatePayDollarsPerHour());
    }


    public void printDetails() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Height: " + this.getHeight() + " inches");
        System.out.println("Weight: " + Math.round(this.getWeight()) + " pounds");

        if (this.getTravel()) {
            System.out.println("Does travel ");
        } else {
            System.out.println("Does not travel ");
        }
        if (this.getSmokes()) {
            System.out.println("Does smoke ");
        } else {
            System.out.println("Does not smoke ");
        }
    }

//  helper method

    /**
     * if a variable is within 3 to 20 characters, true otherwise return false
     *
     * @param name
     * @return boolean
     */
    private boolean isValidName(String name) {
        int nameLen = name.length();
        return 3 <= nameLen && nameLen <= 20;
    }

    /**
     * if a variable is not within 24 to 84 inches, It must not be stored
     *
     * @param height
     * @return boolean
     */

    private boolean isValidHeight(int height) {
        return 24 <= height && height <= 84;
    }

    /**
     * if a variable is not within 80 to 280 pounds. It must not be stored
     *
     * @param weight
     * @return boolean
     */

    private boolean isValidWeight(double weight) {
        return 80 <= weight && weight <= 280;
    }


//  setter

    /**
     * @param kilograms
     */
    public void setWeight(long kilograms) {
        double weightInPounds = Model.POUNDS_PER_KG * kilograms;

        if (this.isValidWeight(weightInPounds)) this.weight = weightInPounds;
    }

    /**
     * @param pounds
     */
    public void setWeight(double pounds) {
        if (this.isValidWeight(pounds)) this.weight = pounds;
    }

    /**
     * @param feet
     * @param inches
     */
    public void setHeight(int feet, int inches) {
        int totalInches = feet * Model.INCHES_PER_FOOT + inches;
        if (this.isValidHeight(totalInches)) this.height = totalInches;
    }

    /**
     * @param inches
     */
    public void setHeight(int inches) {
        if (this.isValidHeight(inches)) this.height = inches;
    }

    /**
     * @param canTravel
     */
    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    /**
     * if a variable is not within 3 to 20 characters, It must not be stored
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (isValidName(firstName)) this.firstName = firstName;
        else this.firstName ="";
    }

    /**
     * @param smokes
     */
    public void setSmokes(boolean smokes) {
        this.smokes = smokes;
    }

    /**
     * if a variable is not within 3 to 20 characters, It must not be stored
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (isValidName(lastName)) this.lastName = lastName;
        else this.lastName = "";
    }

//  getter

    /**
     * return result for calculating height in feet and inches as string
     *
     * @return string typed height in feet and inches
     */
    public String getHeightInFeetAndInches() {
        int feet = (int) this.height / Model.INCHES_PER_FOOT;
        int inches = (int) this.height % Model.INCHES_PER_FOOT;

        String result = feet + " feet";

        if (inches > 1) {
            result += " " + inches + " " + "inches";
        } else if (inches == 1) {
            result += " " + inches + " " + "inch";
        }

        return result;
    }

    /**
     * @return long type weight in kg
     */

    public long getWeightKg() {
        return Math.round(this.weight / Model.POUNDS_PER_KG);
    }


    /**
     * @return weight in pounds
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @return height in inches
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @returni lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return boolean whether model is a traveler or not
     */

    public boolean getTravel() {
        return this.canTravel;
    }

    /**
     * @return boolean whether model smokes or not
     */
    public boolean getSmokes() {
        return this.smokes;
    }
}



