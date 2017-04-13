package com.ubs.opsit.interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Artur_Memekh on 4/13/2017.
 */
public class TimeValidatorImplTest {

    private TimeValidator timeValidator;

    @Before
    public void setup() {
        timeValidator = new TimeValidatorImpl();
    }

    @Test
    public void testTimeIsValid() {

        String aTime = "01:39:55";

        boolean result = timeValidator.isTimeValid(aTime);

        assertTrue(result);
    }

    @Test
    public void testTimeLengthInvalid() {

        String aTime = "11:22:33:44";

        boolean result = timeValidator.isTimeValid(aTime);

        assertFalse(result);
    }

    @Test
    public void testTimeHoursInvalid() {

        String aTime = "41:22:33";

        boolean result = timeValidator.isTimeValid(aTime);

        assertFalse(result);
    }

    @Test
    public void testTimeMinutesInvalid() {

        String aTime = "11:67:33";

        boolean result = timeValidator.isTimeValid(aTime);

        assertFalse(result);
    }

    @Test
    public void testTimeSecondsInvalid() {

        String aTime = "11:22:78";

        boolean result = timeValidator.isTimeValid(aTime);

        assertFalse(result);
    }

    @Test
    public void testTimeContainsNotDigitsOnly() {

        String aTime = "1r:2.:/3";

        boolean result = timeValidator.isTimeValid(aTime);

        assertFalse(result);
    }

    @Test
    public void testTimeMidnight() {

        String aTime = "24:00:00";

        boolean result = timeValidator.isTimeValid(aTime);

        assertTrue(result);
    }

    @Test
    public void testTimeSeparatorInvalid() {

        String aTime = "11-22-33";

        boolean result = timeValidator.isTimeValid(aTime);

        assertFalse(result);
    }
}
