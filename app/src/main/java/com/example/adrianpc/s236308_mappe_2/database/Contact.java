package com.example.adrianpc.s236308_mappe_2.database;

import java.io.Serializable;

/**
 * Created by Adrian PC on 14/10/2016.
 */

public class Contact implements Serializable{

    private String name, birthdate;
    private byte[] userImageResource;
    private int phonenumber;

    public Contact(String name, String birthdate, byte[] userImageResource, int phonenumber) {
        this.name = name;
        this.birthdate = birthdate;
        this.userImageResource = userImageResource;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public byte[] getUserImageResource() {
        return userImageResource;
    }

    public void setUserImageResource(byte[] userImageResource) {
        this.userImageResource = userImageResource;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return name + " " + birthdate + " " + phonenumber;
    }
}
