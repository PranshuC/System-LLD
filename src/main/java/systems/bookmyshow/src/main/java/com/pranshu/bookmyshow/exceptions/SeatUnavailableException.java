package com.pranshu.bookmyshow.exceptions;

public class SeatUnavailableException extends RuntimeException {
    public SeatUnavailableException(Long id) {
        super(String.valueOf(id));
    }
}
