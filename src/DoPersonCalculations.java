import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

public class DoPersonCalculations {

    final static int NAME_COLUMN_NUMBER = 0;
    final static int SURNAME_COLUMN_NUMBER = 1;
    final static int ADDRESS_COLUMN_NUMBER = 2;
    final static int CITY_COLUMN_NUMBER = 3;

    HashSet<String> _Names = new HashSet<String>();
    HashSet<String> _Cities = new HashSet<String>();

    IPersonReader reader = null;

    public DoPersonCalculations(IPersonReader reader) throws PersonReaderException {
        this.reader = reader;

        Subcriber subcriber1 = new SubcriberImpementation();
        Subcriber subcriber2 = new SubcriberImpementation();

        reader.attach(subcriber1);
        reader.attach(subcriber2);


        while (reader.nextResult()) {
            Person person = reader.getPerson();
            _Names.add(person.get_name());
            _Cities.add(person.get_city());
            reader.notifyUpdate(person, "This person was read: ");
        }
    }

    public int getNumberOfNames(){

        return _Names.size();
    }


    public int getNumberOfCities() {

        return _Cities.size();
    }
}
