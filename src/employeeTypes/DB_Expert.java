package employeeTypes;

public enum DB_Expert {
    DataBaseImplementationAndDesign((byte)10),
    Bottleneck((byte)7),
    BackupAndRecovery((byte)7),
    SQL((byte)10),
    Replication((byte)5),
    dataBaseAdministration((byte)10),
    backUpAndRecovery((byte)5),
    clustering((byte)5);
    public final byte value;

    DB_Expert(byte b) {
        this.value = b;
    }

    public byte getValue() {
        return value;
    }
}
