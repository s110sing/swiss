package com.swiss.example;


import java.io.IOException;
import java.util.List;

class Main {
    public static void main(String[] args) {
        CsvEmployeeConverter csvEmployeeConverter = new CsvEmployeeConverter();

        String filePath = "emp-details.csv";
        try {
            List<Employee> employees = csvEmployeeConverter.readEmployeesFromCsv(filePath);
            OrganizationalStructureAnalysis result = new OrganizationalStructureAnalysis(employees);
            result.calculateReportingLine();
            result.reportManagerSalaryDeviations();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




