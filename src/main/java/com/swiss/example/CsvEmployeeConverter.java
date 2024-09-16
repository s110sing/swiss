package com.swiss.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvEmployeeConverter{
    public List<Employee> readEmployeesFromCsv(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new RuntimeException("File not found: " + filePath);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if(count== 0){
                    count++;
                    continue;
                }
                String[] values = line.split(",");
                int empId = Integer.parseInt(values[0]);
                String empName = values[1] + values[2];
                Integer managerId = null;
                if (values.length == 5 && !values[4].trim().isEmpty()) {
                    managerId = Integer.parseInt(values[4].trim());
                }
                double empSalary = Double.parseDouble(values[3]);
                employees.add(new Employee(empId, empName, managerId, empSalary));
            }
        }
        return employees;
    }
}
