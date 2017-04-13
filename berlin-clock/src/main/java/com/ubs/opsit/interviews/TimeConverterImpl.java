package com.ubs.opsit.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Artur Memekh on 4/11/2017.
 */
public class TimeConverterImpl implements TimeConverter {

    private TimeValidator timeValidator;

    private String lineSeparator = System.lineSeparator();
    private static final int ROW_COUNT = 5;
    private static final int SECOND_ROW_MAX = 4;
    private static final int FIRST_ROW_MAX = 1;
    private static final int FOURTH_ROW_MAX = 11;
    private static final String LAMP_R = "R";
    private static final String LAMP_O = "O";
    private static final String LAMP_Y = "Y";
    private static final Map<Integer, Integer> rowToMaxLampMap = new HashMap<Integer, Integer>();
    private static final Map<Integer, String> rowToLampTypeMap = new HashMap<Integer, String>();

    static {
        rowToMaxLampMap.put(1, FIRST_ROW_MAX);
        rowToMaxLampMap.put(2, SECOND_ROW_MAX);
        rowToMaxLampMap.put(3, SECOND_ROW_MAX);
        rowToMaxLampMap.put(4, FOURTH_ROW_MAX);
        rowToMaxLampMap.put(5, SECOND_ROW_MAX);

        rowToLampTypeMap.put(1, LAMP_Y);
        rowToLampTypeMap.put(2, LAMP_R);
        rowToLampTypeMap.put(3, LAMP_R);
        rowToLampTypeMap.put(4, LAMP_Y);
        rowToLampTypeMap.put(5, LAMP_Y);
    }

    public TimeConverterImpl(TimeValidator timeValidator) {
        this.timeValidator = timeValidator;
    }

    @Override
    public String convertTime(String aTime) {

        if (!timeValidator.isTimeValid(aTime)) {
            return "";
        }

        StringBuffer result = new StringBuffer();
        String[] timeSlots = aTime.split(":");

        Map<Integer, Integer> rowToLampCountMap = new HashMap();
        // to count how many lamps should be ON in each row
        rowToLampCountMap.put(1, (Integer.parseInt(timeSlots[2])+1) % 2);
        rowToLampCountMap.put(2, Integer.parseInt(timeSlots[0]) / 5);
        rowToLampCountMap.put(3, Integer.parseInt(timeSlots[0]) % 5);
        rowToLampCountMap.put(4, Integer.parseInt(timeSlots[1]) / 5);
        rowToLampCountMap.put(5, Integer.parseInt(timeSlots[1]) % 5);

        for (int i = 1; i <= ROW_COUNT; i++) {
            int lampsCount = rowToLampCountMap.get(i);
            int maxLamps = rowToMaxLampMap.get(i);
            String lampON = rowToLampTypeMap.get(i);

            result.append(drawRow(lampsCount, maxLamps, lampON));
        }

        return result.substring(0, result.lastIndexOf(lineSeparator));
    }

    private String drawRow(int lampsCount, int max, String lampOn) {

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < max; i++) {
            if (FOURTH_ROW_MAX == max && i < lampsCount && (i+1) % 3 == 0) {
                result.append(LAMP_R);
            } else if (i < lampsCount) {
                result.append(lampOn);
            } else {
                result.append(LAMP_O);
            }
        }
        result.append(lineSeparator);
        return result.toString();
    }
}