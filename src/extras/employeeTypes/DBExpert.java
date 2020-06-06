package extras.employeeTypes;

import extras.CalculationSalary;

public class DBExpert implements CalculationSalary {

    public boolean DataBaseImplementationAndDesign;
    public boolean Bottleneck;
    public boolean BackupAndRecovery;
    public boolean SQL;
    public boolean Replication;
    public boolean dataBaseAdministration;
    public boolean backUpAndRecovery;
    public boolean clustering;
    private final int FINAL_SCORE = 35;

    public int getFINAL_SCORE() {
        return FINAL_SCORE;
    }

    public boolean isDataBaseImplementationAndDesign() {
        return DataBaseImplementationAndDesign;
    }

    public void setDataBaseImplementationAndDesign(boolean dataBaseImplementationAndDesign) {
        DataBaseImplementationAndDesign = dataBaseImplementationAndDesign;
    }

    public boolean isBottleneck() {
        return Bottleneck;
    }

    public void setBottleneck(boolean bottleneck) {
        Bottleneck = bottleneck;
    }

    public boolean isBackupAndRecovery() {
        return BackupAndRecovery;
    }

    public void setBackupAndRecovery(boolean backupAndRecovery) {
        BackupAndRecovery = backupAndRecovery;
    }


    public boolean isSQL() {
        return SQL;
    }

    public void setSQL(boolean SQL) {
        this.SQL = SQL;
    }

    public boolean isReplication() {
        return Replication;
    }

    public void setReplication(boolean replication) {
        this.Replication = replication;
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
    public double calculateMoneyForHolidayWorks( double hours , double baseSalary) {


        return baseSalary/(192*1.4*hours);
    }

    @Override
    public double calculateMoneyForOverTimeWork(double hours , double baseSalary) {

        return baseSalary/(192*1.4*hours);
    }

    @Override
    public double calculateMoneyForNightWork(double hours , double baseSalary) {
        return baseSalary/(192*1.35*hours) ;
    }

    @Override
    public double calculateMoneyForVacationHour(double hours , double baseSalary) {
        return baseSalary/(192*1.4*hours);
    }

    @Override
    public double calculateMoneyForTax(double primarySalary) {
        double tax = 0 ;
        if (primarySalary<=3300000){
            tax = 0;
        }
        if (primarySalary>3300000&&primarySalary<=8250000){
            tax = -(primarySalary*0.1);
        }
        if (primarySalary>8250000&&primarySalary<=11550000){
            tax = -(primarySalary*0.15);
        }
        if (primarySalary>11550000&&primarySalary<=16500000){
            tax = -(primarySalary*0.20);
        }
        if (primarySalary>16500000&&primarySalary<=23100000){
            tax = -(primarySalary*0.25);
        }
        if (primarySalary>23100000){
            tax = -(primarySalary*0.35);
        }
        return tax ;
    }

    @Override
    public double calculateInsurance(double primarySalary) {
        return -(primarySalary*0.07);
    }

    @Override
    public double calculateYears(int years, double baseSalary) {
        double yearSalary =baseSalary ;
        for (int i = 0 ; i <years ; i++){
            yearSalary += yearSalary * 0.2 ;
        }
        return yearSalary;
    }

    @Override
    public double calculatePrimarySalary( double overTimeWork, double nightWork, double vacationHour , int years , double baseSalary , double holidayHour ) {
        double yearsSalary = calculateYears(years , baseSalary );
        return  calculateMoneyForNightWork(nightWork , yearsSalary) + calculateMoneyForOverTimeWork(overTimeWork, yearsSalary) + calculateMoneyForVacationHour(vacationHour , yearsSalary) + yearsSalary;
    }




    @Override
    public double calculateFinalSalary(double overTimeWork, double nightWork, double vacationHour , int years , double baseSalary , double holidayHour ) {
       double primarySalary = calculatePrimarySalary(overTimeWork , nightWork , vacationHour  , years , baseSalary , holidayHour);

        return primarySalary + calculateMoneyForTax(primarySalary) + calculateInsurance(primarySalary)  ;
    }

    @Override
    public double calculateBaseSalary(int score, String level, String workTime) {
        double baseSalary = 0;

        if (level.equals("Junior") && score > 35) {
            baseSalary = 3000000;

            if (score > 45) {

                baseSalary = 3500000;
            }
            if (workTime.equals("full time")) {
                baseSalary = 4000000;

            }
        } else if (level.equals("Mid-level") && score > 35) {
            baseSalary = 6000000;

            if (score > 45) {

                baseSalary = 6500000;
            }

            if (workTime.equals("full time")) {

                baseSalary = 7000000;
            }
        } else if (level.equals("Senior") && score > 35) {
            baseSalary = 8500000;

            if (score > 45) {

                baseSalary = 9000000;
            }

            if (workTime.equals("full time")) {
                baseSalary = 9500000 ;

            }
        }


        return baseSalary;
    }


}
