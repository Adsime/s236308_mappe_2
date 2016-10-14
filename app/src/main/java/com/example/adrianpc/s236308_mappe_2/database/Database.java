package com.example.adrianpc.s236308_mappe_2.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian PC on 14/10/2016.
 */

public class Database {

    public static List<Contact> getContacts() {
        List<Contact> returnVal = new ArrayList<>();
        returnVal.add(new Contact("Adrian", "Melsom", "13/07-1993", null, 12345678));
        returnVal.add(new Contact("Duy", "Nguyen", "13/07-1993", null, 12345678));
        returnVal.add(new Contact("Håkon", "Smørvik", "13/07-1993", null, 12345678));
        returnVal.add(new Contact("Anmer", "Seif", "13/07-1993", null, 12345678));
        returnVal.add(new Contact("Kim", "Vu", "13/07-1993", null, 12345678));
        returnVal.add(new Contact("Huy", "Tran", "13/07-1993", null, 12345678));
        returnVal.add(new Contact("Sina", "Hassani", "13/07-1993", null, 12345678));

        return returnVal;
    }
}
