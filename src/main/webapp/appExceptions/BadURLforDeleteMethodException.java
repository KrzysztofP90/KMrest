package appExceptions;

public class BadURLforDeleteMethodException extends Exception {

    public BadURLforDeleteMethodException() {
        super("Add id of existing object to remove after slash (e.g. FireArms/2!");
    }
}
