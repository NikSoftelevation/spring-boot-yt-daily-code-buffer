package com.dialy.code.buffer.springboot.exception;

public class StudentAlreadyExistsException extends RuntimeException {

    public StudentAlreadyExistsException(String message) {
        super(message);
    }
}
