import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.sql.SQLException;
import java.util.HashSet;

public class CSVReader {

    final static int NAME_COLUMN_NUMBER = 0;
    final static int SURNAME_COLUMN_NUMBER = 1;
    final static int ADDRESS_COLUMN_NUMBER = 2;
    final static int CITY_COLUMN_NUMBER = 3;

    BufferedReader _reader = null;
    String line = null;

    public CSVReader() throws IOException {
        String file = "C://Users//User//Desktop//java_training//list_data.csv";

        _reader = new BufferedReader(new FileReader(file));
    }

    public boolean nextResult() throws IOException {
        if((line = _reader.readLine()) != null) {
            return true;
        }else{
            _reader.close();

            return false;
        }
    }

    public Person getPerson() throws IOException {
        String[] elements = line.split(",");

        String name = elements[NAME_COLUMN_NUMBER];
        String surname = elements[SURNAME_COLUMN_NUMBER];
        String address = elements[ADDRESS_COLUMN_NUMBER];
        String city = elements[CITY_COLUMN_NUMBER];

        return new Person(name, surname, address, city);
    }
}