import java.sql.*;

public class DbReader implements  IPersonReader {
    private Connection _connection = null;
    public Statement _stm = null;
    private ResultSet _resultSet = null;

    int _nrOfRows = 0;

    public DbReader() throws PersonReaderException {

        try {
            //Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Get Connection
            _connection = DriverManager.getConnection
                    ("jdbc:mysql://195.179.236.1:3306/u323045651_citta", "u323045651_java", "P3MYEx!,Q!d!");

            _stm = _connection.createStatement();

            _resultSet = _stm.executeQuery("select * from u323045651_citta.citta");
        }catch (SQLException | ClassNotFoundException exc){
            throw new PersonReaderException(_nrOfRows);
        }

    }

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
