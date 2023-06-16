package com.employee.EmployeeRestJPA.utility;

public class ProjectUtility {
    public static boolean isDate(String date){
        return date.matches("\\d{2}-\\d{2}-\\d{4}");
    }
}
