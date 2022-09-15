import com.mysql.cj.protocol.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class DbReader extends ReaderSubject implements IPersonReader {
    private Connection _connection = null;
    public Statement _stm = null;
    private ResultSet _resultSet = null;

    int _nrOfRows = 0;

    private List<Subcriber> subcribers = new ArrayList<>();

    public DbReader(String url, String user, String password) throws PersonReaderException {

        try {
            //Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Get Connection
            _connection = DriverManager.getConnection
                    (url,user,password);

            _stm = _connection.createStatement();

            _resultSet = _stm.executeQuery("select * from u323045651_citta.citta");
        }catch (SQLException | ClassNotFoundException exc){
            throw new PersonReaderException(_nrOfRows);
        }

    }


  @Override
    public boolean nextResult() throws PersonReaderException {
        try{
            if(_resultSet.next()) {
                _nrOfRows ++;
                return true;
            }else{
                _connection.close();

                return false;
            }
        }catch (SQLException exc){

            throw new PersonReaderException(_nrOfRows);
        }

    }



    @Override
    public Person getPerson() throws PersonReaderException {

        try {
            String name = _resultSet.getString("nome");
            String surname = _resultSet.getString("cognome");
            String city = _resultSet.getString("citta");
            String address = _resultSet.getString("indirizzo");
            return new Person(name, surname, city, address);

        }catch (Exception exc){
            throw new PersonReaderException(_nrOfRows);
        }
       }
}
