package exception;

public class EmptyStructureException extends Exception {
    public EmptyStructureException() {
        super("Data structure is empty");
    }
}
