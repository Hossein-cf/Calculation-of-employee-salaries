package employeeTypes;

public enum Back_End {

    python ((byte)0),
    ruby ((byte) 1),
    node_JS((byte) 1),
    PHP7((byte) 1),
    ASP_NET((byte) 1) ,
    webServer((byte) 1),
    SQLServer((byte) 1),
    OracleDatabase((byte) 1) ,
    RestfulAPIs((byte) 1) ,
    Security((byte) 1) ,
    Docker((byte) 1) ,
    ;
    private final byte value;
    Back_End(byte b) {
        this.value = b;
    }
    public byte getValue() {
        return value;
    }
}
