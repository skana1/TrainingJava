public interface IPersonReader {

    public void attach(Subcriber subcriber);
    public void detach(Subcriber subcriber);
    public void notifyUpdate(Person person, String s);
    public boolean nextResult() throws  PersonReaderException;
    public Person getPerson() throws PersonReaderException;
}
