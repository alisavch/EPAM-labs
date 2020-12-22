package com.myamazingproject.other;

import com.myamazingproject.model.UserInfo;

public class CreateUser {
    public static final String USER_FIRST_NAME = "test.data.user.firstname";
    public static final String USER_LASTNAME = "test.data.user.lastname";
    public static final String USER_PATRONYMIC = "test.data.user.patronymic";
    public static final String USER_POSTCODE = "test.data.user.postcode";
    public static final String USER_CITY = "test.data.user.city";
    public static final String USER_ADDRESS = "test.data.user.address";
    public static final String USER_PHONENUMBER = "test.data.user.phoneNumber";
    public static final String USER_EMAIL = "test.data.user.email";

    public static UserInfo withCredentialsFromProperty() {
        String firstName = TestDataReader.getTestData(USER_FIRST_NAME);
        String lastName = TestDataReader.getTestData(USER_LASTNAME);
        String patronymic = TestDataReader.getTestData(USER_PATRONYMIC);
        String postcode = TestDataReader.getTestData(USER_POSTCODE);
        String city = TestDataReader.getTestData(USER_CITY);
        String address = TestDataReader.getTestData(USER_ADDRESS);
        String phoneNumber = TestDataReader.getTestData(USER_PHONENUMBER);
        String email = TestDataReader.getTestData(USER_EMAIL);

        return UserInfo.of(firstName, lastName, patronymic, postcode, city, address, phoneNumber, email);
    }
}
