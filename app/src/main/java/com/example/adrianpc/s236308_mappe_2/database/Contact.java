package com.example.adrianpc.s236308_mappe_2.database;

/**
 * Created by Adrian PC on 14/10/2016.
 */

public class Contact {

    private String firstname, lastname, birthdate;
    private byte[] userImageResource;
    private int phonenumber;

    public Contact(String firstname, String lastname, String birthdate, byte[] userImageResource, int phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.userImageResource = userImageResource;
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
        return firstname + " " + lastname + " " + birthdate + " " + phonenumber;
    }
}
