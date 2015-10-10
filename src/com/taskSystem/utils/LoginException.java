package com.taskSystem.utils;

/**
 * Created by yh on 2015/10/10.
 */

public class LoginException extends RuntimeException {

    public LoginException() {
        super();
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

}
