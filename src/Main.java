import java.io.IOException;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {

        try {
            CSVReader readerCSV = new CSVReader();
            DbReader readerDB = new DbReader();

            DoPersonCalculations calculatorCSV = new DoPersonCalculations(readerCSV);

            DoPersonCalculations calculatorDb = new DoPersonCalculations(readerDB);


            System.out.println("(csv) The number of unique names is: " + calculatorCSV._Names.size());
            System.out.println("(csv) The number of unique cities is: " + calculatorCSV._Cities.size());

            System.out.println("(db) The number of unique names is: " + calculatorDb._Names.size());
            System.out.println("(db) The number of unique cities is: " + calculatorDb._Cities.size());

            
        } catch (PersonReaderException exc) {
            System.out.println(exc);
        }

    }

}
