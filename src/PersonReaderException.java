public class PersonReaderException extends Exception {

    public  PersonReaderException( int _personReadSoFar) {
       super(String.valueOf(_personReadSoFar));
    }
}

