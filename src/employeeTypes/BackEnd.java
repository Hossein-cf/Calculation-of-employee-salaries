package employeeTypes;

import extras.Employee;

public class BackEnd extends Employee {

    public boolean python ;
    public boolean ruby ;
    public boolean node_JS;
    public boolean PHP7;
    public boolean ASP_NET ;
    public boolean webServer;
    public boolean SQLServer;
    public boolean OracleDatabase ;
    public boolean RestfulAPIs ;
    public boolean Security ;
    public boolean Docker ;

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
}
