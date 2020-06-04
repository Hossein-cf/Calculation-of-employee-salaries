package extras.employeeTypes;

public enum Back_End {

    python ((byte)7),
    ruby ((byte) 7),
    node_JS((byte) 10),
    PHP7((byte) 10),
    ASP_NET((byte) 10) ,
    webServer((byte) 5),
    SQLServer((byte) 10),
    OracleDatabase((byte) 5) ,
    RestfulAPIs((byte) 5) ,
    Security((byte) 3) ,
    Docker((byte) 5) ,
    ;
    private final byte value;
    Back_End(byte b) {
        this.value = b;
    }
    public byte getValue() {
        return value;
    }
}
