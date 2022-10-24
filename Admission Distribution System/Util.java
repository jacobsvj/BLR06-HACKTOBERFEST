import java.util.Scanner;

public class Util {

    public static int takePositiveIntegerInput(Scanner s){
        String data = s.nextLine();
        try{
            return Integer.parseInt(data);
        }
        catch(NumberFormatException e){
            System.out.println("Enter Valid Input. Integer value greater than 0 allowed");
        }
        return -1;
    }

    public static boolean verifyName(String name) {
        String regx = "^[\\p{L} .'-]+$";
        return name.matches( regx) && name.length()>=4;
    }

    public static boolean verifyPhone(String phone) {
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        return phone.matches(pattern);
    }
    
}
