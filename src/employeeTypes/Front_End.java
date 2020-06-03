package employeeTypes;

public enum Front_End {
    html((byte) 1),
    HTTP((byte) 1),
    XHTR((byte) 1),
    HTMLDOM((byte) 1),
    JAVAScript((byte) 1),
    ReactJs((byte) 1),
    Angular((byte) 1),
    VueJs((byte) 1),
    jQuery((byte) 1),
    TypeScript((byte) 1),
    ES6((byte) 1),
    yarn((byte) 1);

    private final byte value;
    Front_End(byte b) {
        this.value = b;
    }
    public byte getValue() {
        return value;
    }
}
