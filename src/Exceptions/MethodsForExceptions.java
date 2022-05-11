package Exceptions;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MethodsForExceptions {
    public static void nick(String s) throws NickException{
        if (s.length() < 6){
            throw new NickException("the Nick must contain at last 6 characters");
        }
        else if (!s.isEmpty() && !Character.isUpperCase(s.charAt(0))) {
            throw new NickException("the first leather must be uppercase");
        }
        else if (!Pattern.matches("\\w*\\d+\\w*", s)) {
            throw new NickException("the Nick must contain at last 1 digit");
        }
    }
    public static void nameorsurname(String s) throws NameSurnameException{
        if (!s.isEmpty() && !Character.isUpperCase(s.charAt(0))) {
            throw new NameSurnameException("the first leather must be uppercase");
        }
        else if (!Pattern.matches("[a-zA-Z]+", s)) {
            throw new NameSurnameException("The name/surnane must consist of letters only");
        }
    }

    public static void mail(String s) throws MailException{
        Pattern pattern = Pattern.compile("@gra.pl$");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){}
        else
        {
            throw new MailException("the required domain is @gra.pl");
        }
    }
    public static void manRegex(String s) throws GenderManException {
        Pattern pattern = Pattern.compile("(ek$)|(usz$)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){}
        else
        {
            throw new GenderManException("the name ending must be -ek or -usz");
        }
    }
    public static void womanRegex(String s) throws GenderWomanException {
        Pattern pattern = Pattern.compile("(ta$)|(na$)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){}
        else
        {
            throw new GenderWomanException("the name ending must be -ta or -na");
        }
    }
    public static void nullGenderChose(String s) throws GenderNullException{
        throw new GenderNullException("You have to chose gender");
    }

}