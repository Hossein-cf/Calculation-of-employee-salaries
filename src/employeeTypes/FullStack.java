package employeeTypes;

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
    private final int FINAL_SCORE=0;

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
