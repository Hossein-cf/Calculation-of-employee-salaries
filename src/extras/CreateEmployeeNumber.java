package extras;

public class CreateEmployeeNumber {

    public static String createEmployeeCode(){
        double r = Math.random();
        long randomNumber = (long) (r * Long.parseLong("10000000000"));
        String EmployeeCode = randomNumber +"" ;


        return EmployeeCode ;

    }

    public static void main(String[] args) {
        System.out.println(createEmployeeCode());
    }
}
