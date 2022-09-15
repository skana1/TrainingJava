import java.util.ArrayList;
import java.util.List;

public abstract class ReaderSubject {

    private List<Subcriber> subcribers = new ArrayList<>();

    public void attach(Subcriber subcriber) {
        subcribers.add(subcriber);
    }

    public void detach(Subcriber subcriber) {
        subcribers.remove(subcriber);
    }


    public void notifyUpdate(Person person, String message) {

        for(Subcriber subcriber : subcribers){
            subcriber.personData(person,message);

        }
    }


    public boolean nextResult() throws PersonReaderException {
        return false;
    }


    public Person getPerson() throws PersonReaderException {
        return null;
    }
}
