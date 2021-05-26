package shulz.lab4.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String reason) {
        super(reason);
    }
}
