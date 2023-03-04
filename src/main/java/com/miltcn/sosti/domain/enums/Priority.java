package com.miltcn.sosti.domain.enums;

public enum Priority {
    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

    private Integer code;
    private String description;

    Priority(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Integer codeEnum) {

        if(codeEnum == null) {
            return null;
        }

        for(Priority profile : Priority.values()) {
            if(codeEnum.equals(profile.getCode())) {
                return profile;
            }
        }
        throw new IllegalArgumentException("Prioridade inválido!");
    }
}
