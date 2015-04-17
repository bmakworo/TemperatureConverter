package com.phibe.temperatureconverter.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

import com.phibe.temperatureconverter.EditNumber;
import com.phibe.temperatureconverter.TemperatureConverterActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.test.ViewAsserts.assertLeftAligned;
import static android.test.ViewAsserts.assertOnScreen;
import static android.test.ViewAsserts.assertRightAligned;

@RunWith(AndroidJUnit4.class)
public class TemperatureConverterActivityTests extends ActivityInstrumentationTestCase2<TemperatureConverterActivity> {

    private TemperatureConverterActivity mActivity;
    private EditNumber mCelsius;
    private EditNumber mFahrenheit;
    final int expected = LayoutParams.MATCH_PARENT;

    public TemperatureConverterActivityTests() {
        super(TemperatureConverterActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
        mCelsius = (EditNumber) mActivity.findViewById(com.phibe.temperatureconverter.R.id.celsius);
        mFahrenheit = (EditNumber) mActivity.findViewById(com.phibe.temperatureconverter.R.id.fahrenheit);

    }

    @Test
    public final void testPreconditions() {
        assertNotNull(mActivity);
        assertNotNull(mCelsius);
        assertNotNull(mFahrenheit);
    }

    @Test
    public final void testFieldsShouldStartEmpty() {
        assertEquals("", mCelsius.getText().toString());
        assertEquals("", mFahrenheit.getText().toString());
    }

    @Test
    public final void testFieldsOnScreen() {
        final Window window = mActivity.getWindow();
        final View origin = window.getDecorView();
        assertOnScreen(origin, mCelsius);
        assertOnScreen(origin, mFahrenheit);
    }

    @Test
    public final void testAlignment() {
        assertLeftAligned(mCelsius, mFahrenheit);
        assertRightAligned(mCelsius, mFahrenheit);
    }

    @Test
    public final void testCelciusInputFieldCoverEntireScreen() {
        final LayoutParams lp = mCelsius.getLayoutParams();
        assertEquals("mFahrenheit layout width is not MATCH_PARENT", expected, lp.width);
    }

    @Test
    public final void testFahrenheitInputFieldCoverEntireScreen() {
        final LayoutParams lp = mFahrenheit.getLayoutParams();
        assertEquals("mFahrenheit layout width is not MATCH_PARENT", expected, lp.width);
    }

    @Test
    public final void testVirtualKeyboardSpaceReserved() {
        final int expected = 280;
        final int actual = mFahrenheit.getBottom();
        assertTrue(actual <= expected);
    }

//    @UiThreadTest
//    public final void testFahrenheitToCelsiusConversion() {
//	mCelsius.clear();
//	mFahrenheit.clear();
//	final double f = 32.5;
//	mFahrenheit.requestFocus();
//	mFahrenheit.setNumber(f);
//	mCelsius.requestFocus();
//	final double expectedC = TemperatureConverter.fahrenheitToCelsius(f);
//	final double actualC = mCelsius.getNumber();
//	final double delta = Math.abs(expectedC - actualC);
//	final String msg = "" + f + "F -> " + expectedC + "C" + "but was " + actualC + "C (delta " + delta + ")";
//	assertTrue(msg, delta < 0.005);
//    }


    public void tearDown() throws Exception {
        super.tearDown();
    }
}
