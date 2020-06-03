package extras;

import employeeTypes.EmployeeType;

public class Employee extends Person implements CalculationSalary {
    final double INSURANCE = 2000000;
    private SalaryInformation salaryInformation;
    private long employeeNumber;
    private EmployeeType employeeType;
    private String certificate;
    private int workExperience;
    private String employeeLevel;

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public double getINSURANCE() {
        return INSURANCE;
    }

    public SalaryInformation getSalaryInformation() {
        return salaryInformation;
    }

    public void setSalaryInformation(SalaryInformation salaryInformation) {
        this.salaryInformation = salaryInformation;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }


    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public void setEmployeeType(String employeeType) {
        if (employeeType.equals(EmployeeType.BackEnd.toString())) {
            this.employeeType = EmployeeType.BackEnd;
        } else if (employeeType.equals(EmployeeType.DBExpert.toString())) {
            this.employeeType = EmployeeType.DBExpert;
        } else if (employeeType.equals(EmployeeType.FrontEnd.toString())) {
            this.employeeType = EmployeeType.FrontEnd;
        } else if (employeeType.equals(EmployeeType.FullStack.toString())) {
            this.employeeType = EmployeeType.FullStack;
        } else if (employeeType.equals(EmployeeType.NetworkSecurityExpert.toString())) {
            this.employeeType = EmployeeType.NetworkSecurityExpert;
        }
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
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
