package com.ubs.opsit.interviews;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Artur Memekh on 4/11/2017.
 */
public class TimeConverterImplTest {

    private TimeConverterImpl timeConverter;
    private TimeValidatorImpl timeValidator;

    private String aTime;
    private String lineSeparator = System.lineSeparator(); // '\r\n'
    private String berlinClockPattern = "^[YO]" + lineSeparator
            + "[RO]{4}" + lineSeparator
            + "[RO]{4}" + lineSeparator
            + "[YRO]{11}" + lineSeparator
            + "[YO]{4}$";

    @Before
    public void setup() {
        timeValidator = mock(TimeValidatorImpl.class);
        timeConverter = new TimeConverterImpl(timeValidator);
    }

    @Test
    public void testTimeIsInvalid() {

        aTime = "4:444:abcdef";

        when(timeValidator.isTimeValid(anyString())).thenReturn(false);

        String result = timeConverter.convertTime(aTime);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testTimeIsValid() {

        aTime = "12:31:19";

        when(timeValidator.isTimeValid(anyString())).thenReturn(true);

        String result = timeConverter.convertTime(aTime);

        assertTrue(result.matches(berlinClockPattern));
    }
}
