package extras;

import java.util.Date;

public class Receipt extends SalaryInformation{
    private double finalSalary;
    private double baseSalary;
    private Date salaryDate;
    private double tax ;
    private double overTimeSalary;
    private double holidayTimeSalary;
    private double nightTimeSalary;
    private double afternoonTimeSalary;
    private double morningTimeSalary;
    private double fullTimeSalary;
    private double rightToHousing;
    private double Insurance;


    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getOverTimeSalary() {
        return overTimeSalary;
    }

    public void setOverTimeSalary(double overTimeSalary) {
        this.overTimeSalary = overTimeSalary;
    }

    public double getHolidayTimeSalary() {
        return holidayTimeSalary;
    }

    public void setHolidayTimeSalary(double holidayTimeSalary) {
        this.holidayTimeSalary = holidayTimeSalary;
    }

    public double getNightTimeSalary() {
        return nightTimeSalary;
    }

    public void setNightTimeSalary(double nightTimeSalary) {
        this.nightTimeSalary = nightTimeSalary;
    }

    public double getAfternoonTimeSalary() {
        return afternoonTimeSalary;
    }

    public void setAfternoonTimeSalary(double afternoonTimeSalary) {
        this.afternoonTimeSalary = afternoonTimeSalary;
    }

    public double getMorningTimeSalary() {
        return morningTimeSalary;
    }

    public void setMorningTimeSalary(double morningTimeSalary) {
        this.morningTimeSalary = morningTimeSalary;
    }

    public double getFullTimeSalary() {
        return fullTimeSalary;
    }

    public void setFullTimeSalary(double fullTimeSalary) {
        this.fullTimeSalary = fullTimeSalary;
    }

    public double getRightToHousing() {
        return rightToHousing;
    }

    public void setRightToHousing(double rightToHousing) {
        this.rightToHousing = rightToHousing;
    }

    public double getInsurance() {
        return Insurance;
    }

    public void setInsurance(double insurance) {
        Insurance = insurance;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Date getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Date salaryDate) {
        this.salaryDate = salaryDate;
    }

}