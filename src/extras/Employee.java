package extras;

import employeeTypes.EmployeeType;

public class Employee extends Person implements CalculationSalary {
    private JobInformation jobInformation;
    private long employeeNumber;
    private EmployeeType employeeType;
    private String certificate;
    private int workExperience;




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

    public JobInformation getJobInformation() {
        return jobInformation;
    }

    public void setJobInformation(JobInformation jobInformation) {
        this.jobInformation = jobInformation;
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
    public double calculate() {
        return 0;
    }

}
