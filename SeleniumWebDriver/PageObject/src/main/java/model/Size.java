package model;

public enum Size {
    US5("US 5 (RU 34,5)"),
    US55("US 5.5 (RU 35)"),
    US6("US 6 (RU 36,5)"),
    US65("US 6.5 (RU 36,5)"),
    US7("US 7 (RU 37)"),
    US75("US 7.5 (RU 37,5)"),
    US8("US 8 (RU 38)"),
    US85("US 8.5 (RU 38,5)"),
    US9("US 9 (RU 39,5)"),
    US95("US 9.5 (RU 40)"),
    US10("US 10 (RU 41)"),
    US105("US 10.5 (RU 41,5)"),
    US11("US 11 (RU 42)"),
    US115("US 11.5 (RU 43)"),
    US12("US 12 (RU 43,5)");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
