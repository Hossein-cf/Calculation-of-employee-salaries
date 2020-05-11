package extras;

import employeeTypes.EmployeeType;

public class Employee extends Person implements CalculationSalary {
    private long employeeNumber;
    private EmployeeType employeeType;


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
