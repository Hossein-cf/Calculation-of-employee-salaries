package extras;

public interface CalculationSalary {
    double calculateMoneyForHolidayWorks(int days);
    double calculateMoneyForOverTimeWork(double hours);
    double calculateMoneyForNightWork(int days);
    double calculateMoneyForMorningWork(int days);
    double calculateMoneyForAfternoonWork(int days);
    double calculateMoneyForFullTimeWork(int days);
    double calculateMoneyForVacationHour(double hours);
    double calculateMoneyForTax(double salary);
    double calculateInsurance(double insurance);
    double calculateRightToHousing(double baseSalary);
    double calculateFinalSalary();

}
