package com.swiss.example;

import java.util.*;
import java.util.stream.Collectors;

public class OrganizationalStructureAnalysis {
    private Map<Integer, Employee> empMap = new HashMap<>();
    private Map<Integer, List<Employee>> managerMap = new HashMap<>();

    public OrganizationalStructureAnalysis(List<Employee> employeeList){
        employeeList.stream().forEach((e)->{
            empMap.put(e.getId(), e);
            if(e.getManagerId() != null)
                managerMap.computeIfAbsent(e.getManagerId(), k->new ArrayList<>()).add(e);
        });
    }

    //- which managers earn less than they should, and by how much
    // which managers earn more than they should, and by how much
    /*
        Board wants to make sure that every manager earns
at least 20% more than the average salary of its direct subordinates, but no more than 50% more
than that average
     */

    public void reportManagerSalaryDeviations(){
        for(Integer managerIds: managerMap.keySet()){
            List<Employee> employeeList = managerMap.get(managerIds);
            double averageSalary = employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary));
            double TwentyPercentMoreThanAverage = averageSalary + ((averageSalary*20)/100);
            double FiftyPercentLessThanAverage = averageSalary - ((averageSalary*50)/100);
            double managerSalary =  empMap.get(managerIds).getSalary();
            System.out.println(" Manager less than 20 percent average");
            employeeList.stream().filter((e)->{
                //System.out.println("manager Salary - " + managerSalary + "   TwentyPercentMoreThanAverage - " + TwentyPercentMoreThanAverage);
                if(managerSalary < TwentyPercentMoreThanAverage){
                    return true;
                }
                return false;
            }).forEach((p)-> System.out.println(p.getId()));


            System.out.println(" Manager more than 50 percent average");

            employeeList.stream().filter((e)->{
                //System.out.println("manager Salary - " + managerSalary + "   FiftyPercentLessThanAverage - " + FiftyPercentLessThanAverage);
                if(managerSalary > FiftyPercentLessThanAverage){
                    return true;
                }
                return false;
            }).forEach((p)-> System.out.println(p.getId()));
        }
    }

    // - which employees have a reporting line which is too long, and by how much
    public void  calculateReportingLine(){
        for(Employee employee : empMap.values()){
            int level = getLevelTillCeo(employee);
            if(level > 4){
                System.out.println(" Level is too long");
            }

        }
    }

    private int getLevelTillCeo(Employee emp) {
        int level = 0;
        while (emp.getManagerId() != null) {
            emp = empMap.get(emp.getManagerId());
            level++;
        }
        return level;
    }

}
