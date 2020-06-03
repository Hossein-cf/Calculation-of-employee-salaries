package employeeTypes;

public enum Full_Stack {
    CSS((byte) 1),
    JC((byte) 1),
    reactJs((byte) 1),
    jQuery((byte) 1),
    mobilePrograming((byte) 1),
    python((byte) 1),
    ruby((byte) 1),
    nodeJs((byte) 1),
    PHP7((byte) 1),
    ASP_NET((byte) 1),
    webServer((byte) 1),
    SQLServer((byte) 1),
    oracleDatabase((byte) 1),
    xamarin((byte) 1),
    security((byte) 1),
    docker((byte) 1);
    private final byte value;
    Full_Stack(byte b) {
        this.value = b;
    }
    public byte getValue() {
        return value;
    }

}
