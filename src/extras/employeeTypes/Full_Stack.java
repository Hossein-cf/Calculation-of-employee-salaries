package extras.employeeTypes;

public enum Full_Stack {
    CSS((byte) 5),
    JC((byte) 5),
    reactJs((byte) 10),
    jQuery((byte) 7),
    mobilePrograming((byte) 5),
    python((byte) 10),
    ruby((byte) 10),
    nodeJs((byte) 10),
    PHP7((byte) 10),
    ASP_NET((byte) 10),
    webServer((byte) 5),
    SQLServer((byte) 10),
    oracleDatabase((byte) 5),
    xamarin((byte) 5),
    security((byte) 5),
    docker((byte) 5);
    private final byte value;
    Full_Stack(byte b) {
        this.value = b;
    }
    public byte getValue() {
        return value;
    }

}
