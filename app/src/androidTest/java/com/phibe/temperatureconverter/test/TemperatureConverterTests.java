package com.phibe.temperatureconverter.test;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.phibe.temperatureconverter.TemperatureConverter;

@RunWith(Parameterized.class)
public class TemperatureConverterTests extends TestCase {

    private double mExpected;
    private double mActual;

    public TemperatureConverterTests(double expected, double actual) {
        mExpected = expected;
        mActual = actual;
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

//    @After
//    protected void tearDown() throws Exception {
//	super.tearDown();
//    }

//    private static final Object[] getFarenheitTemperature() {
// 	return new Double[][] { {0.0, 32.0}, 
// 	                        {37.78,100.0} ,
// 	                        {100.0,212.0},
// 	                        {-1.0, 30.20},
// 	                        {-100.0, -148.0},
// 	                        {32.0, 89.60}, 
// 	                        {-40.0, -40.0},
// 	                        {-273.0, -459.40}};
//     }

    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{0.0, 32.0},
                {37.78, 100.0},
                {100.0, 212.0},
                {-1.0, 30.20},
                {-100.0, -148.0},
                {32.0, 89.60},
                {-40.0, -40.0},
                {-273.0, -459.40}});
    }

    @Test
    public final void testFahrenheitToCelsius() {
        assertEquals(mExpected, TemperatureConverter.fahrenheitToCelsius(mActual), 0.1);
//	assertTrue(true);
    }

}
