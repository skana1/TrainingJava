public class Main {
    public static void main(String[] args) {
        try {
            IPersonReader reader = Factory.getFactory().getReader();
            DoPersonCalculations calculator = new DoPersonCalculations(reader);

            System.out.println(" The number of unique names is: " + calculator._Names.size());
            System.out.println(" The number of unique cities is: " + calculator._Cities.size());
        } catch (PersonReaderException exc) {
            System.out.println(exc);
        }
    }
}
