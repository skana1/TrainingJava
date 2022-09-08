import java.io.IOException;
import java.sql.SQLException;

public interface IPersonReader {

    public boolean nextResult()throws IOException, SQLException;
    public Person getPerson()throws IOException,SQLException;
}
