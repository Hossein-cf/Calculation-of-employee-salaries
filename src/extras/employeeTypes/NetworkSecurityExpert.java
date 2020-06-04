package extras.employeeTypes;

import extras.CalculationSalary;

public class NetworkSecurityExpert implements CalculationSalary {
    public boolean UTM ;
    public boolean ISMS ;
    public boolean PLC ;
    public boolean CEH ;
    public boolean CISSP;
    public boolean CCNA;
    public boolean QOD;
    public boolean HAIPE_IP;
    public boolean MPLS;
    private final int FINAL_SCORE=40;

    public int getFINAL_SCORE() {
        return FINAL_SCORE;
    }

    public boolean isCEH() {
        return CEH;
    }

    public void setCEH(boolean CEH) {
        this.CEH = CEH;
    }

    public boolean isCISSP() {
        return CISSP;
    }

    public void setCISSP(boolean CISSP) {
        this.CISSP = CISSP;
    }

    public boolean isCCNA() {
        return CCNA;
    }

    public void setCCNA(boolean CCNA) {
        this.CCNA = CCNA;
    }

    public boolean isQOD() {
        return QOD;
    }

    public void setQOD(boolean QOD) {
        this.QOD = QOD;
    }

    public boolean isHAIPE_IP() {
        return HAIPE_IP;
    }

    public void setHAIPE_IP(boolean HAIPE_IP) {
        this.HAIPE_IP = HAIPE_IP;
    }

    public boolean isMPLS() {
        return MPLS;
    }

    public void setMPLS(boolean MPLS) {
        this.MPLS = MPLS;
    }



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
    public double calculateMoneyForHolidayWorks( double baseSalary) {


        return baseSalary*2;
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
    public double calculatePrimarySalary( double overTimeWork, double nightWork, double vacationHour, double yearsSalary) {
        return  overTimeWork + nightWork + vacationHour + yearsSalary;
    }


    @Override
    public double calculateFinalSalary(double primarySalary , double tax , double insurance) {

        return primarySalary + tax + insurance;
    }

    @Override
    public double calculateBaseSalary(int score, String level, String workTime) {
        double baseSalary = 0;
        if (level.equals("Junior")&& score > 40) {

            baseSalary = 2500000;
            if(score>60) baseSalary = 3200000;
            if(workTime.equals("full time")) baseSalary = 3700000;

        }

        else if (level.equals("Mid-level")&& score > 40) {
            baseSalary = 4200000;
            if(score>50) baseSalary = 4600000;
            if(workTime.equals("full time")) baseSalary = 5100000;

        }

        else if (level.equals("Senior")&& score > 40) {
            baseSalary = 8000000;
            if(score>50) baseSalary = 8500000;
            if(workTime.equals("full time")) baseSalary = 9700000;

        }

        return  baseSalary;
    }


}
