package com.Finance_Pay.validations;

import com.Finance_Pay.exception.EmailInvalidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    private static final String REGEX_EMAIL =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public void emailValidation(String email) throws EmailInvalidException {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches()){
            throw new EmailInvalidException("Email invalid!");
        }
    }
}
