package extras.employeeTypes;

public enum Front_End {
    html((byte) 10),
    HTTP((byte) 5),
    XHTR((byte) 5),
    HTMLDOM((byte) 5),
    JAVAScript((byte) 10),
    ReactJs((byte) 10),
    Angular((byte) 10),
    VueJs((byte) 10),
    jQuery((byte) 10),
    TypeScript((byte) 7),
    ES6((byte) 5),
    yarn((byte) 5),
    npm((byte) 5),
    CSSResponsive((byte) 3),
    json((byte) 3),
    ajax((byte) 3),
    materialDesign((byte) 3),
    bootStrap((byte) 5),
    W3Css((byte) 5);

    private final byte value;

    Front_End(byte b) {
        this.value = b;
    }

    public byte getValue() {
        return value;
    }


}
