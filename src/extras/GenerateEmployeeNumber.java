package extras;

import java.util.Random;

public class  GenerateEmployeeNumber {
    public static String  generateNumber(){
        String number ;
        Random  random = new Random();
        number = "9819"+random.nextInt(99999);
        System.out.println(number);

        return number;
    }




}
