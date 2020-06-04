package extras.employeeTypes;

import extras.CalculationSalary;

public class FrontEnd  implements CalculationSalary {

    private boolean html ;
    private boolean HTTP;
    private boolean XHTR;
    private boolean HTMLDOM;
    private boolean JAVAScript;
    private boolean ReactJs;
    private boolean Angular;
    private boolean VueJs ;
    private boolean jQuery ;
    private boolean TypeScript ;
    private boolean ES6 ;
    private boolean yarn ;


    public boolean npm ;
    public boolean CSSResponsive ;
    public boolean json;
    public boolean ajax ;
    public boolean materialDesign ;
    public boolean bootStrap ;
    public boolean W3Css;
    private final int FINAL_SCORE=60;

    public int getFINAL_SCORE() {
        return FINAL_SCORE;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public boolean isHTTP() {
        return HTTP;
    }

    public void setHTTP(boolean HTTP) {
        this.HTTP = HTTP;
    }

    public boolean isXHTR() {
        return XHTR;
    }

    public void setXHTR(boolean XHTR) {
        this.XHTR = XHTR;
    }

    public boolean isHTMLDOM() {
        return HTMLDOM;
    }

    public void setHTMLDOM(boolean HTMLDOM) {
        this.HTMLDOM = HTMLDOM;
    }

    public boolean isJAVAScript() {
        return JAVAScript;
    }

    public void setJAVAScript(boolean JAVAScript) {
        this.JAVAScript = JAVAScript;
    }

    public boolean isReactJs() {
        return ReactJs;
    }

    public void setReactJs(boolean reactJs) {
        ReactJs = reactJs;
    }

    public boolean isAngular() {
        return Angular;
    }

    public void setAngular(boolean angular) {
        Angular = angular;
    }

    public boolean isVueJs() {
        return VueJs;
    }

    public void setVueJs(boolean vueJs) {
        VueJs = vueJs;
    }

    public boolean isjQuery() {
        return jQuery;
    }

    public void setjQuery(boolean jQuery) {
        this.jQuery = jQuery;
    }

    public boolean isTypeScript() {
        return TypeScript;
    }

    public void setTypeScript(boolean typeScript) {
        TypeScript = typeScript;
    }

    public boolean isES6() {
        return ES6;
    }

    public void setES6(boolean ES6) {
        this.ES6 = ES6;
    }

    public boolean isYarn() {
        return yarn;
    }

    public void setYarn(boolean yarn) {
        this.yarn = yarn;
    }

    public boolean isNpm() {
        return npm;
    }

    public void setNpm(boolean npm) {
        this.npm = npm;
    }

    public boolean isCSSResponsive() {
        return CSSResponsive;
    }

    public void setCSSResponsive(boolean CSSResponsive) {
        this.CSSResponsive = CSSResponsive;
    }

    public boolean isJson() {
        return json;
    }

    public void setJson(boolean json) {
        this.json = json;
    }

    public boolean isAjax() {
        return ajax;
    }

    public void setAjax(boolean ajax) {
        this.ajax = ajax;
    }

    public boolean isMaterialDesign() {
        return materialDesign;
    }

    public void setMaterialDesign(boolean materialDesign) {
        this.materialDesign = materialDesign;
    }

    public boolean isBootStrap() {
        return bootStrap;
    }

    public void setBootStrap(boolean bootStrap) {
        this.bootStrap = bootStrap;
    }

    public boolean isW3Css() {
        return W3Css;
    }

    public void setW3Css(boolean w3Css) {
        W3Css = w3Css;
    }


    @Override
    public double calculateMoneyForHolidayWorks(double baseSalary) {
        return 0;
    }

    @Override
    public double calculateMoneyForOverTimeWork(double hours, double baseSalary) {
        return 0;
    }

    @Override
    public double calculateMoneyForNightWork(double hours, double baseSalary) {
        return 0;
    }

    @Override
    public double calculateMoneyForVacationHour(double hours, double baseSalary) {
        return 0;
    }

    @Override
    public double calculateMoneyForTax(double finalSalary) {
        return 0;
    }

    @Override
    public double calculateInsurance(double finalSalary) {
        return 0;
    }

    @Override
    public double calculateYears(int years, double baseSalary) {
        return 0;
    }

    @Override
    public double calculateFinalSalary() {
        return 0;
    }

    @Override
    public double calculateBaseSalary(int score, String level, String workTime) {
        double baseSalary = 0;
        if (level.equals("Junior")&& score > 60) {
            baseSalary = 2500000;
            if(score>70) baseSalary  = 2700000;

            if (workTime.equals("full time")) baseSalary = 3000000;

        }

        else if (level.equals("Mid-level")&& score > 60) {
            baseSalary = 3500000;

            if(score>70) baseSalary = 3800000;

            if (workTime.equals("full time")) baseSalary = 4200000;
        }

        else if (level.equals("Senior")&& score > 60) {
            baseSalary = 6000000;

            if(score>70) baseSalary = 6300000;

            if (workTime.equals("full time")) baseSalary = 6600000;
        }
        return baseSalary;
    }


}
