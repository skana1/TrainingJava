import com.mysql.cj.protocol.Message;

import java.io.*;
import java.util.Observer;

public class CSVReader extends ReaderSubject implements IPersonReader{

    final static int NAME_COLUMN_NUMBER = 0;
    final static int SURNAME_COLUMN_NUMBER = 1;
    final static int ADDRESS_COLUMN_NUMBER = 2;
    final static int CITY_COLUMN_NUMBER = 3;

    BufferedReader _reader = null;
    String line = null;

    int _numOfRows = 0;


    public CSVReader(String file) throws PersonReaderException {

        try {
            String path = getClass().getResource(file).getPath() ;

            _reader = new BufferedReader(new FileReader(path));
        }catch (FileNotFoundException exc){
            System.out.println(exc);
            throw new PersonReaderException(_numOfRows);
        }

    }

    @Override
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

    @Override
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