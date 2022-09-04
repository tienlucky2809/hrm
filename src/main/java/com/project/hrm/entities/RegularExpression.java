package com.project.hrm.entities;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class RegularExpression {

    public boolean regexIdentityNumber(String identityNumber){
        Pattern patternIdNum = Pattern.compile("[0-9]*");
        return patternIdNum.matcher(identityNumber).matches();
    }
    public  boolean regexPhoneNumber(String phoneNumber){
        Pattern patternPhoneNum = Pattern.compile("[0-9]*");
        return  patternPhoneNum.matcher(phoneNumber).matches();
    }
    public boolean regexEmail(String email){
        Pattern patternEmail = Pattern.compile("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        return  patternEmail.matcher(email).matches();
    }

    public boolean regexDate(String date){
        Pattern patternDate = Pattern.compile("\\d{1,2}[-]\\d{1,2}[-]\\d{4}");
        return patternDate.matcher(date).matches();
    }
    public boolean regexName(String name){
        Pattern patternName = Pattern.compile("[a-zA-Z]*");
        return  patternName.matcher(name).matches();
    }
}
