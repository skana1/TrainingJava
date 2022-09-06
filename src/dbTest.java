import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

            // The newInstance() call is a work around for some
            // broken Java implementations

            //Register Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Get Connection
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/u323045651_citta","u323045651_java","P3MYEx!,Q!d!");

            //Write sql
            String sql = "insert into citta(nome,cognome,indirizzo,citta) " +
                         "values('Oscar' , 'White' , 'Tirane' , 'Tirane')";

            //Create statemment
            Statement stm = connection.createStatement();

            //Execute sql
            stm.execute(sql);

            //close db
            connection.close();
            System.out.println("Added Succes");


    }
}
