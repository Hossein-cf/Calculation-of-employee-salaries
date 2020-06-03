package employeeTypes;

public class DBExpert {
    public boolean SQL ;
    public boolean replication ;
    public boolean dataBaseAdministration ;
    public boolean backUpAndRecovery ;
    public boolean clustering ;

    public boolean isSQL() {
        return SQL;
    }

    public void setSQL(boolean SQL) {
        this.SQL = SQL;
    }

    public boolean isReplication() {
        return replication;
    }

    public void setReplication(boolean replication) {
        this.replication = replication;
    }

    public boolean isDataBaseAdministration() {
        return dataBaseAdministration;
    }

    public void setDataBaseAdministration(boolean dataBaseAdministration) {
        this.dataBaseAdministration = dataBaseAdministration;
    }

    public boolean isBackUpAndRecovery() {
        return backUpAndRecovery;
    }

    public void setBackUpAndRecovery(boolean backUpAndRecovery) {
        this.backUpAndRecovery = backUpAndRecovery;
    }

    public boolean isClustering() {
        return clustering;
    }

    public void setClustering(boolean clustering) {
        this.clustering = clustering;
    }
}
