package extras.employeeTypes;

import ManagerDashbord.DashboardControllers.ManagerEmploymentController;
import extras.CalculationSalary;

public class BackEnd implements CalculationSalary {

    private boolean python;
    private boolean ruby;
    private boolean node_JS;
    private boolean PHP7;
    private boolean ASP_NET;
    private boolean webServer;
    private boolean SQLServer;
    private boolean OracleDatabase;
    private boolean RestfulAPIs;
    private boolean Security;
    private boolean Docker;
    private final int FINAL_SCORE = 50;

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

    ManagerEmploymentController employ = new ManagerEmploymentController();

    @Override
    public double calculateMoneyForHolidayWorks( double hours , double baseSalary) {


        return baseSalary/(192*1.4*hours) ;
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
    public double calculatePrimarySalary( double overTimeWork, double nightWork, double vacationHour, double yearsSalary , int years , double baseSalary ) {
        yearsSalary = calculateYears(years , baseSalary );
        return  calculateMoneyForNightWork(nightWork , yearsSalary) + calculateMoneyForOverTimeWork(overTimeWork, yearsSalary) + calculateMoneyForVacationHour(vacationHour , yearsSalary) + yearsSalary;
    }




    @Override
    public double calculateFinalSalary(double overTimeWork, double nightWork, double vacationHour, double yearsSalary , int years , double baseSalary , double primarySalary ) {
        primarySalary = calculatePrimarySalary(overTimeWork , nightWork , vacationHour , yearsSalary , years , baseSalary);

        return primarySalary + calculateMoneyForTax(primarySalary) + calculateInsurance(primarySalary)  ;
    }

    @Override
    public  double calculateBaseSalary(int score, String level, String workTime) {
        double baseSalary = 0;
        //"Junior", "Mid-level", "Senior"
        //"full time", "Morning Work", "afternoon Work", "night work"
        if (level.equals("Junior")&& score > 50) {
            baseSalary = 2700000;
                if(score>60) baseSalary = 3200000;
                if(workTime.equals("full time")) baseSalary = 3700000;

        } else if (level.equals("Mid-level")&& score > 50) {

                baseSalary = 4000000;

                if(score>60) {
                    baseSalary = 4700000;
                }
            if(workTime.equals("full time")){

                baseSalary = 5200000;
            }
        } else if (level.equals("Senior")&& score > 50) {
                baseSalary = 7000000;

                if(score>60) {
                    baseSalary = 7900000;
                }
            if(workTime.equals("full time")){

                baseSalary = 8500000;
            }

        }


        return baseSalary;
    }
}
