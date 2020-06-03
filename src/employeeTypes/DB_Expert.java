package employeeTypes;

public enum DB_Expert {
    DataBaseImplementationAndDesign((byte)0),
    Bottleneck((byte)0),
    BackupAndRecovery((byte)0),
    SQL((byte)0),
    Replication((byte)0),
    dataBaseAdministration((byte)0),
    backUpAndRecovery((byte)0),
    clustering((byte)0);
    public final byte value;

    DB_Expert(byte b) {
        this.value = b;
    }

    public byte getValue() {
        return value;
    }
}
