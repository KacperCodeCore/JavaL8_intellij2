public class OwnExceptions {
    public static void nick(String s){
        if (s.length() < 6){
            throw new IllegalArgumentException("the Nick must contain at last 6 characters");
        } else if (!s.isEmpty() && !Character.isUpperCase(s.charAt(0))) {
            throw new IllegalArgumentException("the first leather must be uppercase");
        }

    }
}
