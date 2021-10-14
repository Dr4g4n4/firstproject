package com.firstexample.demo.datavalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

    public boolean isIdValid(Long id){
        String number = Long.toString(id);
        String nameRegex = "^[0-9]{1,6}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(number);
        if(matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isValidMileage(Double a){
        String number = Double.toString(a);
        String nameRegex = "[0-9]*\\\\.[0-9]+|[0-9]+";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(number);
        if(matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isValidSomeName(String name){
        String nameRegex = "^[a-zA-Z0-9 ]{4,29}$";
        Pattern p = Pattern.compile(nameRegex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        if(m.matches()){
            System.out.println("VALIDNO");
        }else{
            System.out.println("NIJE VALIDNO");
        }
        return m.matches();
    }

}
