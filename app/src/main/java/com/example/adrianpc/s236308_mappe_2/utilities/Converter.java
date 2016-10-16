package com.example.adrianpc.s236308_mappe_2.utilities;

/**
 * Created by bruker on 16-Oct-16.
 */

public class Converter {

    public static final String splitter = "/|-";

    public static int[] convertDateString(String date) {
        String[] s = date.split(splitter);
        int[] returnValue = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            returnValue[i] = Integer.parseInt(s[i]);
        }
        return returnValue;
    }

    public static String convertToDateString(int day, int month, int year) {
        return new StringBuilder().append(day).append("/").append(month).append("-").append(year).toString();
    }
}
