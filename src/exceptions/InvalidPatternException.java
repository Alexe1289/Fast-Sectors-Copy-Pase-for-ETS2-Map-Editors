package exceptions;

public class InvalidPatternException extends Exception {
    public InvalidPatternException() {
        super("Invalid pattern. Use instead: ± 1234 ± 1234");
    }
}
