package exceptions;

public class FileNotFoundException extends Exception {
    public FileNotFoundException() {
        super("Specified sector not found in input directory");
    }
}
