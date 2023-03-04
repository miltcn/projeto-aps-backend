package com.miltcn.sosti.domain.enums;

public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

    private Integer code;
    private String description;

    Status(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Status toEnum(Integer codeEnum) {

        if(codeEnum == null) {
            return null;
        }

        for(Status profile : Status.values()) {
            if(codeEnum.equals(profile.getCode())) {
                return profile;
            }
        }
        throw new IllegalArgumentException("Status inválido!");
    }
}
