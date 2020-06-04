package employeeTypes;

public class NetworkSecurityExpert {
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
}
