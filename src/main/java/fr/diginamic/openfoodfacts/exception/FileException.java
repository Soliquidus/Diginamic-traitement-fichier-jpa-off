package fr.diginamic.openfoodfacts.exception;

/**
 * Error for file exception management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13 /11/2021
 */
public class FileException extends RuntimeException {

    /**
     * The constant serial.
     */
    private static final long serialVersionUID = 968465165498741246L;

    /**
     * Instantiates a new File exception.
     *
     * @param errorMessage the error message
     */
    public FileException(String errorMessage){
        super(errorMessage);
    }
}