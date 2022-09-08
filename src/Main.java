import java.io.IOException;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {

        try {
            CSVReader _readerCSV = new CSVReader();
            DbReader _readerDB = new DbReader();

            DoPersonCalculations _calculatorCSV = new DoPersonCalculations(_readerCSV);

            DoPersonCalculations _calculatorDb = new DoPersonCalculations(_readerDB);


            System.out.println("(csv) The number of unique names is: " + _calculatorCSV._Names.size());
            System.out.println("(csv) The number of unique cities is: " + _calculatorCSV._Cities.size());

            System.out.println("(db) The number of unique names is: " + _calculatorDb._Names.size());
            System.out.println("(db) The number of unique cities is: " + _calculatorDb._Cities.size());

            
        } catch (IOException e) {
            System.out.printf("There was an error with reading the file");
        } catch (SQLException e) {
            System.out.printf("There was an error with reading the database");
        } catch (Exception e) {
            System.out.printf("There was an error with reading the data");
        }

    }

}
