package com.employeereg.emplyeeregapi.Controller;

public class EmployeeResponse {

    private String employeeName;
    private String message;

    public EmployeeResponse(String employeeName, String message) {
        this.employeeName = employeeName;
        this.message = message;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
