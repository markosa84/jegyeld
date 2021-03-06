package hu.ak_akademia.jegyeld.dto;

public enum Status {

    ACTIVE("A", "Aktív"), DELETED("D", "Törölt");

    private final String code;
    private final String name;

    private Status(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Status getByCode(String code) {
        for (Status status : values()) {
            if (status.getCode()
                    .equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Érvénytelen státuszkód: " + code);
    }

}