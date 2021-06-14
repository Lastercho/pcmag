package org.isbg.pcmag.exception;

public class UseNotFoundException extends RuntimeException{
    public UseNotFoundException(String message) {
        super(message);
    }
}
