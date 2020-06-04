package employeeTypes;

public enum Network_Security {
    UTM((byte) 10),
    ISMS((byte) 5),
    PLC((byte) 5),
    CEH((byte) 10),
    CISSP((byte) 10),
    CCNA((byte) 10),
    QOD((byte) 5),
    HAIPE_IP((byte) 5),
    MPLS((byte) 5);
    public final byte value;

    Network_Security(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
