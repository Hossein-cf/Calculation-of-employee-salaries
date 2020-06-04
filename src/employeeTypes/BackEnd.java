package employeeTypes;

import extras.CalculationSalary;
import extras.Employee;

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
