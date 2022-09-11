import java.io.IOException;
import java.sql.SQLException;



public interface IPersonReader {

    public boolean nextResult() throws  PersonReaderException;
    public Person getPerson() throws PersonReaderException;
}
