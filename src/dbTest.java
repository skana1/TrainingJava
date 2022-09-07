import java.sql.*;
import java.util.HashSet;

public class dbTest {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Register Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Get Connection
        Connection _connection = DriverManager.getConnection
                ("jdbc:mysql://195.179.236.1:3306/u323045651_citta", "u323045651_java", "P3MYEx!,Q!d!");

        Statement _stm = _connection.createStatement();
        ResultSet _resultSet = _stm.executeQuery("select * from u323045651_citta.citta");

        HashSet<String> _name = new HashSet<String>();

        HashSet<String> _city = new HashSet<String>();

        while (_resultSet.next()) {
            _name.add(_resultSet.getString(2));
            _city.add(_resultSet.getString(5));

        }

        System.out.println("Number of unique names is: " + _name.size());
        System.out.println("Number of unique cities is: " + _city.size());

        //close db
        _connection.close();
    }
}
