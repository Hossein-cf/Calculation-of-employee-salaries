package extras;

public interface CalculationSalary {
    double calculateSalaryForHolidayWorks(int days);
    double calculateSalaryForOverTimeWork(double hours);
    double calculateSalaryForNightWork(int days);
    double calculateSalaryForMorningWork(int days);
    double calculateSalaryForAfternoonWork(int days);
    double calculateSalaryForFullTimeWork(int days);
    double calculateSalaryForVacationHour(double hours);
    double calculateSalaryForTax(double salary);


}
