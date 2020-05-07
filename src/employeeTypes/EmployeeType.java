package employeeTypes;

public enum EmployeeType {
    FullStack((byte) 0), FrontEnd((byte) 1), BackEnd((byte) 2), NetworkSecurityExpert((byte) 3), DBExpert((byte) 4);
     private final byte value;

    EmployeeType(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}
