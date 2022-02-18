public class Driver {
    public static void main(String[] args) {
//    public Model(String firstName, String lastName, int heightInches, double weightPounds, boolean traveler, boolean smoker) {

        /** test1
         *  height is not valid weight is not valid
         */

        System.out.println("test1 -----------------------------------------------------------------------------");
        Model test1 = new Model("1", "123456789012345678901",23, 23.2,true,true);

        System.out.println(test1.getHeight());
        System.out.println(test1.getWeight());
        test1.printDetails();
        test1.displayModelDetails();


        /** test2
         *  all variables are valid.
         */
        System.out.println("test2 -----------------------------------------------------------------------------");
        Model test2 = new Model("firstname", "lastname",24, 280,false,false);

        System.out.println(test2.getHeight());
        System.out.println(test2.getWeight());
        test2.printDetails();
        test2.displayModelDetails();

        /** test3
         *  test constructor3
         */
        System.out.println("test3 -----------------------------------------------------------------------------");
        Model test3 = new Model("firstname", "lastname",24, 280);

        System.out.println(test3.getHeight());
        System.out.println(test3.getWeight());
        test3.printDetails();
        test3.displayModelDetails();

        /** test4
         *  test conversion for height
         */
        System.out.println("test4 -----------------------------------------------------------------------------");
        Model test4 = new Model("firstname", "lastname",24, 280);

        System.out.println(test4.getHeightInFeetAndInches());

        test4.setHeight(25); //inch should be displayed at the end.
        System.out.println(test4.getHeightInFeetAndInches());

        test4.setHeight(26); //inches should be displayed at the end.
        System.out.println(test4.getHeightInFeetAndInches());

        test4.setHeight(2,0); //2 feet should be displayed
        System.out.println(test4.getHeightInFeetAndInches());

        /** test5
         *  test conversion for weight
         */
        System.out.println("test5 -----------------------------------------------------------------------------");
        Model test5 = new Model("firstname", "lastname",24, 280);

        System.out.println(test5.getWeightKg()); //280 pounds equal to 127 kg
    }
}
