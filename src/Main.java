import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class Main {

    final static int ID_COLUMN_NUMBER = 1;
    final static int NAME_COLUMN_NUMBER = 2;
    final static int SURNAME_COLUMN_NUMBER = 3;
    final static int ADDRESS_COLUMN_NUMBER = 4;
    final static int CITY_COLUMN_NUMBER = 5;


    public static void main(String[] args) {

        try{
            DbReader reader = new DbReader();
            HashSet<String> _names = new HashSet<String>();
            HashSet<String> _cities = new HashSet<String>();

            while (reader.nextResult()) {
                _names.add(reader.GetCellValue(NAME_COLUMN_NUMBER));
                _cities.add(reader.GetCellValue(CITY_COLUMN_NUMBER));
            }

            System.out.println("The number of unique names is: " + _names.size());
            System.out.println("The number of unique cities is: " + _cities.size());
        }
        catch (SQLException e) {
            System.out.printf("There was an error with reading the database");
        }
        catch (Exception e){
            System.out.printf("There was an error with reading the data");
        }

    }

}
