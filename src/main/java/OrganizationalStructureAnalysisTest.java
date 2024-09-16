import com.swiss.example.Employee;
import com.swiss.example.OrganizationalStructureAnalysis;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OrganizationalStructureAnalysisTest {

    @Test
    public void testReportManagerSalaryDeviations() {
        Employee emp1 = new Employee(1, "CEO", null, 400000);
        Employee emp2 = new Employee(2, "Manager1", 1, 240000);
        Employee emp3 = new Employee(3, "Employee1", 2, 140000);

        List<Employee> employees = Arrays.asList(emp1, emp2, emp3);
        OrganizationalStructureAnalysis analysis = new OrganizationalStructureAnalysis(employees);
        analysis.reportManagerSalaryDeviations();
    }

    @Test
    public void testAnalyzeReportingLines() {
        Employee emp1 = new Employee(1, "CEO", null, 400000);
        Employee emp2 = new Employee(2, "Manager1", 1, 240000);
        Employee emp3 = new Employee(3, "Employee1", 2, 140000);

        List<Employee> employees = Arrays.asList(emp1, emp2, emp3);
        OrganizationalStructureAnalysis analysis = new OrganizationalStructureAnalysis(employees);
        analysis.reportManagerSalaryDeviations();
    }
}
