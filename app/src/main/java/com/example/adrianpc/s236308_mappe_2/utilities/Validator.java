package com.example.adrianpc.s236308_mappe_2.utilities;

import com.example.adrianpc.s236308_mappe_2.database.Contact;

import java.util.Calendar;

/**
 * Created by bruker on 16-Oct-16.
 */

public class Validator {

    public static final String nameReg = "^[a-zA-ZæøåÆØÅ]{2,20}";
    public static final String phoneReg = "[0-9]{8}";

    public static boolean check(String toBeChecked, String regex) {
        return toBeChecked.matches(regex);
    }

    public static boolean validateBirthdate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        int cyear = c.get(Calendar.YEAR);
        int cmonth = c.get(Calendar.MONTH);
        int cdate = c.get(Calendar.DATE);
        return (year > cyear || year == cyear && month > cmonth || year == cyear && month == cmonth && day > cdate);
    }

    public static boolean validateContact(Contact contact) {
        return contact.getName().matches(nameReg) &&
                String.valueOf(contact.getPhonenumber()).matches(phoneReg);
    }
}
