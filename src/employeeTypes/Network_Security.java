package employeeTypes;

public enum Network_Security {
    UTM((byte) 0),
    ISMS((byte) 0),
    PLC((byte) 0),
    CEH((byte) 0),
    CISSP((byte) 0),
    CCNA((byte) 0),
    QOD((byte) 0),
    HAIPE_IP((byte) 0),
    MPLS((byte) 0);
    public final byte value;

    Network_Security(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
