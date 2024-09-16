import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class OrganizationalStructureAnalysisTest {

    private List<Employee> employeeList;
    private OrganizationalStructureAnalysis analysis;

    @Before
    public void setUp() {
        employeeList = new ArrayList<>();
        // data initalization
        employeeList.add(new Employee(1, "Lemon Bro", null, 80000));
        employeeList.add(new Employee(2, "steve Smith", 1, 50000));
        employeeList.add(new Employee(3, "Raw khosla", 1, 60000));
        employeeList.add(new Employee(4, "Red dam", 2, 40000));
        employeeList.add(new Employee(5, "peter wihan", 2, 45000));
        employeeList.add(new Employee(6, "cobes micheal", 3, 55000));
        employeeList.add(new Employee(7, "jelly clamp", 3, 50000));

        analysis = new OrganizationalStructureAnalysis(employeeList);
    }

    @Test
    public void testReportManagerSalaryDeviations() {
        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        analysis.reportManagerSalaryDeviations();

        // Reset System.out
        System.setOut(originalOut);

        String output = outputStream.toString();

        // Check if the output contains expected results
        assertTrue(output.contains("Manager less than 20 percent average"));
        assertTrue(output.contains("Manager more than 50 percent average"));
    }

    @Test
    public void testCalculateReportingLine() {
        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        analysis.calculateReportingLine();

        // Reset System.out
        System.setOut(originalOut);

        String output = outputStream.toString();

        // Check if the output contains expected results
        assertTrue(output.contains("Level is too long")); // Based on your test data, you might need to adjust this.
    }
}
