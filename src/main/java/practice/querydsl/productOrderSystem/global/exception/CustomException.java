package practice.querydsl.productOrderSystem.global.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public CustomException(HttpStatus httpStatus) {
        super(httpStatus.getReasonPhrase());
        this.httpStatus = httpStatus;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
