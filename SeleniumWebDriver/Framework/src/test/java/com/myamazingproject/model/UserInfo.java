package com.myamazingproject.model;

import lombok.Getter;
import lombok.Setter;

import static com.google.common.base.Preconditions.checkNotNull;

@Getter
@Setter
public class UserInfo {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String postcode;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;

    private UserInfo(String firstName, String lastName, String patronymic, String postcode, String city, String address,
                     String phoneNumber, String email) {

        checkNotNull(firstName);
        checkNotNull(lastName);
        checkNotNull(patronymic);
        checkNotNull(postcode);
        checkNotNull(city);
        checkNotNull(address);
        checkNotNull(phoneNumber);
        checkNotNull(email);

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.postcode = postcode;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static UserInfo of(String firstName, String lastName, String patronymic, String postcode, String city, String address,
                              String phoneNumber, String email){

        return new UserInfo(firstName, lastName, patronymic, postcode, city, address, phoneNumber, email);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

