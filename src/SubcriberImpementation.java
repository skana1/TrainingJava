import com.mysql.cj.protocol.Message;

public class SubcriberImpementation implements Subcriber {

    public void personData(Person person, String message){
        System.out.println(message + person.toString() );
    }
}
