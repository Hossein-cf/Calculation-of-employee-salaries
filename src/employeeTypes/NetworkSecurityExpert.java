package employeeTypes;

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
