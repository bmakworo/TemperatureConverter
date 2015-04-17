package com.phibe.temperatureconverter;

public class TemperatureConverter {

    public static final double ABSOLUTE_ZERO_C = -273.15d;
    public static final double ABSOLUTE_ZERO_F = -459.67d;
    private static final String ERROR_MESSAGE_BELOW_ZERO_FMT = "Invalid temperature: %.2f%c below absolute zero";

    public static double fahrenheitToCelsius(double f) {
	if (f < ABSOLUTE_ZERO_F) {
	    throw new InvalidTemperatureException(String.format(ERROR_MESSAGE_BELOW_ZERO_FMT, f, 'F'));
	}
	return ((f - 32) / 1.8d);
    }
}
