package employeeTypes;

import extras.CalculationSalary;
import extras.Employee;

public class BackEnd  implements CalculationSalary {

    private boolean python ;
    private boolean ruby ;
    private boolean node_JS;
    private boolean PHP7;
    private boolean ASP_NET ;
    private boolean webServer;
    private boolean SQLServer;
    private boolean OracleDatabase ;
    private boolean RestfulAPIs ;
    private boolean Security ;
    private boolean Docker ;
    private final int FINAL_SCORE=50;




    public int getFINAL_SCORE() {
        return FINAL_SCORE;
    }

    public boolean isPython() {
        return python;
    }

    public void setPython(boolean python) {
        this.python = python;
    }

    public boolean isRuby() {
        return ruby;
    }

    public void setRuby(boolean ruby) {
        this.ruby = ruby;
    }

    public boolean isNode_JS() {
        return node_JS;
    }

    public void setNode_JS(boolean node_JS) {
        this.node_JS = node_JS;
    }

    public boolean isPHP7() {
        return PHP7;
    }

    public void setPHP7(boolean PHP7) {
        this.PHP7 = PHP7;
    }

    public boolean isASP_NET() {
        return ASP_NET;
    }

    public void setASP_NET(boolean ASP_NET) {
        this.ASP_NET = ASP_NET;
    }

    public boolean isWebServer() {
        return webServer;
    }

    public void setWebServer(boolean webServer) {
        this.webServer = webServer;
    }

    public boolean isSQLServer() {
        return SQLServer;
    }

    public void setSQLServer(boolean SQLServer) {
        this.SQLServer = SQLServer;
    }

    public boolean isOracleDatabase() {
        return OracleDatabase;
    }

    public void setOracleDatabase(boolean oracleDatabase) {
        OracleDatabase = oracleDatabase;
    }

    public boolean isRestfulAPIs() {
        return RestfulAPIs;
    }

    public void setRestfulAPIs(boolean restfulAPIs) {
        RestfulAPIs = restfulAPIs;
    }

    public boolean isSecurity() {
        return Security;
    }

    public void setSecurity(boolean security) {
        Security = security;
    }

    public boolean isDocker() {
        return Docker;
    }

    public void setDocker(boolean docker) {
        Docker = docker;
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
    public double calculateMoneyForTax(double finalSalary) {
        double tax = 0 ;
        if (finalSalary<=3300000){
            tax = 0;
        }
        if (finalSalary>3300000&&finalSalary<=8250000){
            tax = -(finalSalary*0.1);
        }
        if (finalSalary>8250000&&finalSalary<=11550000){
            tax = -(finalSalary*0.15);
        }
        if (finalSalary>11550000&&finalSalary<=16500000){
            tax = -(finalSalary*0.20);
        }
        if (finalSalary>16500000&&finalSalary<=23100000){
            tax = -(finalSalary*0.25);
        }
        if (finalSalary>23100000){
            tax = -(finalSalary*0.35);
        }
        return tax ;
    }

    @Override
    public double calculateInsurance(double finalSalary) {
        return -(finalSalary*0.07);
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
    public double calculateFinalSalary() {
        return 0;
    }




    @Override
    public double calculateBaseSalary(int score) {
        return 0;
    }
}
