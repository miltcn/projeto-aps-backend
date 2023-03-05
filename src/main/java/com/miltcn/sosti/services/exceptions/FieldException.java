package com.miltcn.sosti.services.exceptions;

import java.io.Serializable;

public class FieldException implements Serializable {
    private static final long serialVersionUID = 1l;

    private String fieldName;
    private String message;

    public FieldException() {
        super();
    }

    public FieldException(String fieldName, String message) {
        super();
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
