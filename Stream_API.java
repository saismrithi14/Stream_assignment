import java.util.*;
import java.util.stream.*;
public class Stream_API {
    public static void main(String[] args)
    {
        Employee emp1 = new Employee(
                1,
                "John Smith",
                "IT",
                75000,
                "john.smith@company.com",
                Arrays.asList("Java", "Spring", "SQL")
        );

        Employee emp2 = new Employee(
                2,
                "Sarah Johnson",
                "HR",
                60000,
                "sarah.johnson@company.com",
                Arrays.asList("Recruitment", "Communication", "Onboarding")
        );

        Employee emp3 = new Employee(
                3,
                "Michael Brown",
                "Finance",
                82000,
                "michael.brown@company.com",
                Arrays.asList("Accounting", "Excel", "Budgeting")
        );

        Employee emp4 = new Employee(
                4,
                "Emily Davis",
                "Finance",
                68000,
                "emily.davis@company.com",
                Arrays.asList("SEO", "Content Writing", "Social Media")
        );

        Employee emp5 = new Employee(
                5,
                "David Wilson",
                "Operations",
                72000,
                "david.wilson@company.com",
                Arrays.asList("Project Management", "Logistics", "Leadership")
        );

        Employee emp6 = new Employee(
                6,
                "Anna Taylor",
                "IT",
                90000,
                "anna.taylor@company.com",
                Arrays.asList("Microservices", "Docker", "Kubernetes")
        );

        //Question1: 1.	Convert list of strings into a single comma-separated string.
        //Taking employee 1s skills as the list of strings
        System.out.println("\n=======================Question 1=====================================\n");
        System.out.println("Employee 1's skills are as follows: " + emp1.getSkills());
        String skillset = emp1.getSkills().stream().collect(Collectors.joining(",")).toString();
        System.out.println("Converting the skills into comma separated values: " + skillset);

        //Question 2: Create a Map of Employee id and Employee name
        System.out.println("\n=======================Question 2=====================================\n");
        List<Employee> employees = List.of(emp1,emp2,emp3,emp4,emp5,emp6);
        Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("Mapped id to name values are: " + map);

        System.out.println("\n=======================Question 3=====================================\n");
        System.out.println("Grouping employees based on their department");
        Map<String, List<Employee>> department_map = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees divided based on their department are as follows: " + department_map);

    }

}
