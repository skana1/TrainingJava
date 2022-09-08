import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        try {
            CSVReader reader1 = new CSVReader();
            DbReader reader2 = new DbReader();
            HashSet<String> _fileNames = new HashSet<String>();
            HashSet<String> _fileCities = new HashSet<String>();

            HashSet<String> _dbNames = new HashSet<String>();
            HashSet<String> _dbCities = new HashSet<String>();

            while (reader1.nextResult()) {
                Person person = reader1.getPerson();

                _fileNames.add(person.get_name());
                _fileCities.add(person.get_city());
            }

            System.out.println("(csv) The number of unique names is: " + _fileNames.size());
            System.out.println("(csv) The number of unique cities is: " + _fileCities.size());

            while (reader2.nextResult()) {
                Person person = reader2.getPerson();

                _dbNames.add(person.get_name());
                _dbCities.add(person.get_city());
            }

            System.out.println("(db) The number of unique names is: " + _dbNames.size());
            System.out.println("(db) The number of unique cities is: " + _dbCities.size());
        } catch (IOException e) {
            System.out.printf("There was an error with reading the file");
        } catch (SQLException e) {
            System.out.printf("There was an error with reading the database");
        } catch (Exception e) {
            System.out.printf("There was an error with reading the data");
        }

    }

}
