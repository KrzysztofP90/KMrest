package appExceptions;

public class IdNotExistException extends Exception{

    public IdNotExistException() {
        super("Check if You pass id of existing object to JSON!");
    }
}
