import java.util.regex.Pattern;

public class OwnExceptions {
    public static void nick(String s){
        if (s.length() < 6){
            throw new IllegalArgumentException("the Nick must contain at last 6 characters");
        } else if (!s.isEmpty() && !Character.isUpperCase(s.charAt(0))) {
            throw new IllegalArgumentException("the first leather must be uppercase");
        } else if (!Pattern.matches("\\w*\\d+\\w*", s)) {
        throw new IllegalArgumentException("the Nick must contain at last 1 digit");
        }
    }


    public static void nameorsurname(String s){
         if (!s.isEmpty() && !Character.isUpperCase(s.charAt(0))) {
            throw new IllegalArgumentException("the first leather must be uppercase");
        }
        else {
            if (Pattern.matches("[a-zA-Z]+", s)) {
            } else {
                throw new IllegalArgumentException("The name/surnane must consist of letters only");
            }
        }
    }

    public static void mail(String s){
        int intIndex = s.indexOf("@gra.pl");
        if (intIndex == -1)
        {
            throw new IllegalArgumentException("please use @gra.pl");
        }
    }



}
