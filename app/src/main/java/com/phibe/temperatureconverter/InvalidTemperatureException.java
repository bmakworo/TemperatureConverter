package com.phibe.temperatureconverter;


public class InvalidTemperatureException extends RuntimeException {

    public InvalidTemperatureException() {
	
    }

    public InvalidTemperatureException(String detailMessage) {
	super(detailMessage);
	
    }
}
