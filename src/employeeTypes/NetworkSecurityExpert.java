package employeeTypes;

import extras.CalculationSalary;

public class NetworkSecurityExpert implements CalculationSalary {
    public boolean UTM ;
    public boolean ISMS ;
    public boolean PLC ;

    public boolean isUTM() {
        return UTM;
    }

    public void setUTM(boolean UTM) {
        this.UTM = UTM;
    }

    public boolean isISMS() {
        return ISMS;
    }

    public void setISMS(boolean ISMS) {
        this.ISMS = ISMS;
    }

    public boolean isPLC() {
        return PLC;
    }

    public void setPLC(boolean PLC) {
        this.PLC = PLC;
    }

    @Override
    public double calculateMoneyForHolidayWorks(int days) {
        return 0;
    }

    @Override
    public double calculateMoneyForOverTimeWork(double hours) {
        return 0;
    }

    @Override
    public double calculateMoneyForNightWork(int days) {
        return 0;
    }

    @Override
    public double calculateMoneyForMorningWork(int days) {
        return 0;
    }

    @Override
    public double calculateMoneyForAfternoonWork(int days) {
        return 0;
    }

    @Override
    public double calculateMoneyForFullTimeWork(int days) {
        return 0;
    }

    @Override
    public double calculateMoneyForVacationHour(double hours) {
        return 0;
    }

    @Override
    public double calculateMoneyForTax(double salary) {
        return 0;
    }

    @Override
    public double calculateInsurance(double insurance) {
        return 0;
    }

    @Override
    public double calculateRightToHousing(double baseSalary) {
        return 0;
    }

    @Override
    public double calculateFinalSalary() {
        return 0;
    }
}
