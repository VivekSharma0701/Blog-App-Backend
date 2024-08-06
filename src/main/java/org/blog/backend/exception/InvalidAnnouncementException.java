package org.blog.backend.exception;

public class InvalidAnnouncementException extends RuntimeException {
    public InvalidAnnouncementException(String message) {
        super(message);
    }
}
