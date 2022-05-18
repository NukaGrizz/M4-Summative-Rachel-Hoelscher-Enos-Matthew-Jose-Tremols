package com.HoelscherGamz.M4SummativeRachelHoelscherEnosMatthewJoseTremols.exception;

public class NoTransactionException extends RuntimeException{

    public NoTransactionException(String errorMessage) {
        super(errorMessage);
    }
}
