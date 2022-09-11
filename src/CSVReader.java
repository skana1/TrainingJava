import java.io.*;

public class CSVReader implements IPersonReader {

    final static int NAME_COLUMN_NUMBER = 0;
    final static int SURNAME_COLUMN_NUMBER = 1;
    final static int ADDRESS_COLUMN_NUMBER = 2;
    final static int CITY_COLUMN_NUMBER = 3;

    BufferedReader _reader = null;
    String line = null;

    int _numOfRows = 0;


    public CSVReader() throws PersonReaderException {

        try {
            String file = "C://Users//User//Desktop//java_training//list_data.csv123";

            _reader = new BufferedReader(new FileReader(file));
        }catch (FileNotFoundException exc){

            throw new PersonReaderException(_numOfRows);
        }

    }

    public boolean nextResult() throws PersonReaderException {

        try {
            if((line = _reader.readLine()) != null) {

                _numOfRows ++;
                return true;
            }else{
                _reader.close();

                return false;
            }
        } catch (Exception exc){
             throw new PersonReaderException(_numOfRows);
        }

    }

    public Person getPerson() throws PersonReaderException {

        try {
            String[] elements = line.split(",");

            String name = elements[NAME_COLUMN_NUMBER];
            String surname = elements[SURNAME_COLUMN_NUMBER];
            String address = elements[ADDRESS_COLUMN_NUMBER];
            String city = elements[CITY_COLUMN_NUMBER];

            return new Person(name, surname, address, city);
        }catch (Exception exc){
            throw new PersonReaderException(_numOfRows);
        }

    }
}