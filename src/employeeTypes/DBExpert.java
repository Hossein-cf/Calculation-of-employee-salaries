package employeeTypes;

import extras.CalculationSalary;

public class DBExpert implements CalculationSalary {
    public boolean SQL ;
    public boolean replication ;
    public boolean dataBaseAdministration ;
    public boolean backUpAndRecovery ;
    public boolean clustering ;

    public boolean isSQL() {
        return SQL;
    }

    public void setSQL(boolean SQL) {
        this.SQL = SQL;
    }

    public boolean isReplication() {
        return replication;
    }

    public void setReplication(boolean replication) {
        this.replication = replication;
    }

    public boolean isDataBaseAdministration() {
        return dataBaseAdministration;
    }

    public void setDataBaseAdministration(boolean dataBaseAdministration) {
        this.dataBaseAdministration = dataBaseAdministration;
    }

    public boolean isBackUpAndRecovery() {
        return backUpAndRecovery;
    }

    public void setBackUpAndRecovery(boolean backUpAndRecovery) {
        this.backUpAndRecovery = backUpAndRecovery;
    }

    public boolean isClustering() {
        return clustering;
    }

    public void setClustering(boolean clustering) {
        this.clustering = clustering;
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
