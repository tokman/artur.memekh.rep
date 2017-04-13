package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Artur Memekh on 4/12/2017.
 */
public class TimeValidatorImpl implements TimeValidator {

    private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

    private String pattern = "^(?:(?:2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]|24:00:00)$";

    public boolean isTimeValid(String aTime) {
        if (!aTime.matches(pattern)) {
            LOG.error("Time is invalid or doesn't match the pattern (hh:mm:ss)");
            return false;
        }
        return true;
    }
}
