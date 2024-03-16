package exceptions;

public class InvalidInputPathException  extends Exception {
    public InvalidInputPathException() {
        super("Please provide a valid input path.");
    }
}
