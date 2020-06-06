package extras.employeeTypes;

import extras.CalculationSalary;

public class FullStack implements CalculationSalary {
    private boolean HTML ;
    
    public boolean CSS ;
    public boolean JC ;
    public boolean reactJs ;
    public boolean jQuery ;
    public boolean mobilePrograming ;
    public boolean python ;
    public boolean ruby ;
    public boolean nodeJs ;
    public boolean PHP7 ;
    public boolean ASPNET ;
    public boolean webServer ;
    public boolean  SQLServer ;
    public boolean oracleDatabase ;
    public boolean xamarin ;
    public boolean security ;
    public boolean docker ;
    private final int FINAL_SCORE=60;

    public int getFINAL_SCORE() {
        return FINAL_SCORE;
    }

    public boolean isHTML() {
        return HTML;
    }

    public void setHTML(boolean HTML) {
        this.HTML = HTML;
    }

    public boolean isCSS() {
        return CSS;
    }

    public void setCSS(boolean CSS) {
        this.CSS = CSS;
    }

    public boolean isJC() {
        return JC;
    }

    public void setJC(boolean JC) {
        this.JC = JC;
    }

    public boolean isReactJs() {
        return reactJs;
    }

    public void setReactJs(boolean reactJs) {
        this.reactJs = reactJs;
    }

    public boolean isjQuery() {
        return jQuery;
    }

    public void setjQuery(boolean jQuery) {
        this.jQuery = jQuery;
    }

    public boolean isMobilePrograming() {
        return mobilePrograming;
    }

    public void setMobilePrograming(boolean mobilePrograming) {
        this.mobilePrograming = mobilePrograming;
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

    public boolean isNodeJs() {
        return nodeJs;
    }

    public void setNodeJs(boolean nodeJs) {
        this.nodeJs = nodeJs;
    }

    public boolean isPHP7() {
        return PHP7;
    }

    public void setPHP7(boolean PHP7) {
        this.PHP7 = PHP7;
    }

    public boolean isASPNET() {
        return ASPNET;
    }

    public void setASPNET(boolean ASPNET) {
        this.ASPNET = ASPNET;
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
        return oracleDatabase;
    }

    public void setOracleDatabase(boolean oracleDatabase) {
        this.oracleDatabase = oracleDatabase;
    }

    public boolean isXamarin() {
        return xamarin;
    }

    public void setXamarin(boolean xamarin) {
        this.xamarin = xamarin;
    }

    public boolean isSecurity() {
        return security;
    }

    public void setSecurity(boolean security) {
        this.security = security;
    }

    public boolean isDocker() {
        return docker;
    }

    public void setDocker(boolean docker) {
        this.docker = docker;
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
        if (level.equals("Junior")&& score > 60) {

            baseSalary = 4000000;
            if(score>70) baseSalary  = 4700000;

            if (workTime.equals("full time")) baseSalary = 5200000;

        }

        else if (level.equals("Mid-level")&& score > 60) {

            baseSalary = 5500000;
            if(score>70) baseSalary  = 6000000;

            if (workTime.equals("full time")) baseSalary = 6500000;

        }

        else if (level.equals("Senior")&& score > 60) {

            baseSalary = 7000000;
            if(score>70) baseSalary  = 7500000;

            if (workTime.equals("full time")) baseSalary = 8500000;

        }

        return baseSalary;
    }


}
