package hu.ak_akademia.jegyeld.dao;

public class JegyeldRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public JegyeldRuntimeException() {
    }

    public JegyeldRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public JegyeldRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public JegyeldRuntimeException(String message) {
        super(message);
    }

    public JegyeldRuntimeException(Throwable cause) {
        super(cause);
    }

}
