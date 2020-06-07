package extras;

import java.util.Random;

public class  GenerateEmployeeNumber {
    public static String  generateNumber(){
        String number ;
        Random  random = new Random();
        number = "13982019"+random.nextInt(9999);


        return number;
    }




}
