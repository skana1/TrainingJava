import java.util.Random;

public class Factory {

    private static Factory factory;

    private Factory() {

    }
    public static Factory getFactory(){
        if(factory == null){
            factory = new Factory();
        }
        return factory;
    }
    public IPersonReader getReader() throws PersonReaderException {

        Random rand = new Random();
        if(rand.nextBoolean()){
            return new DbReader("jdbc:mysql://195.179.236.1:3306/u323045651_citta", "u323045651_java", "P3MYEx!,Q!d!");
        }

        return new CSVReader(".//resources//list_data.csv");
    }

}
