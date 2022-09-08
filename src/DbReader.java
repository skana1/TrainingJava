import java.sql.*;

public class DbReader {
    private Connection _connection = null;
    public Statement _stm = null;
    private ResultSet _resultSet = null;

    public DbReader() throws ClassNotFoundException, SQLException {
        //Register Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Get Connection
        _connection = DriverManager.getConnection
                ("jdbc:mysql://195.179.236.1:3306/u323045651_citta", "u323045651_java", "P3MYEx!,Q!d!");

        _stm = _connection.createStatement();

        _resultSet = _stm.executeQuery("select * from u323045651_citta.citta");
    }

    public boolean nextResult() throws SQLException {
        if(_resultSet.next()) {
            return true;
        }else{
            _connection.close();

            return false;
        }
    }

    public Person getPerson() throws SQLException {
        String name = _resultSet.getString("nome");
        String surname = _resultSet.getString("cognome");
        String address = _resultSet.getString("indirizzo");
        String city = _resultSet.getString("citta");

        return new Person(name, surname, address, city);
    }
}
