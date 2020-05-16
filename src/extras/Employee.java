package extras;

import employeeTypes.EmployeeType;

public class Employee extends Person implements CalculationSalary {
   private SalaryInformation salaryInformation;
    private long employeeNumber;
    private EmployeeType employeeType;
    private String certificate;
    private int workExperience;

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
        }else if (employeeType.equals(EmployeeType.DBExpert.toString())) {
            this.employeeType = EmployeeType.DBExpert;
        }else if (employeeType.equals(EmployeeType.FrontEnd.toString())) {
            this.employeeType = EmployeeType.FrontEnd;
        }else if (employeeType.equals(EmployeeType.FullStack.toString())) {
            this.employeeType = EmployeeType.FullStack;
        }else if (employeeType.equals(EmployeeType.NetworkSecurityExpert.toString())) {
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
    public double calculateSalaryForHolidayWorks(int days) {
        return 0;
    }

    @Override
    public double calculateSalaryForOverTimeWork(double hours) {
        return 0;
    }

    @Override
    public double calculateSalaryForNightWork(int days) {
        return 0;
    }

    @Override
    public double calculateSalaryForMorningWork(int days) {
        return 0;
    }

    @Override
    public double calculateSalaryForAfternoonWork(int days) {
        return 0;
    }

    @Override
    public double calculateSalaryForFullTimeWork(int days) {
        return 0;
    }

    @Override
    public double calculateSalaryForVacationHour(double hours) {
        return 0;
    }

    @Override
    public double calculateSalaryForTax(double salary) {
        return 0;
    }
}
