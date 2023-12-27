package exeption;

public class DBConnException extends Exception {
    private static final long serialVersionUID = 1319490395704298845L;

    public DBConnException(String message, Throwable cause) {
        super(message, cause);
    }
}
