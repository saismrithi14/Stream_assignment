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
                47000,
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
                45000,
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

        System.out.println("\n=======================Question 4=====================================\n");
        System.out.println("Counting the number of employees per department\n");
        Map<String, Long> department_employee_count = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        //Iterating through the Hashmap to get the counts per department
        for(Map.Entry<String, Long> entry: department_employee_count.entrySet())
        {
            System.out.println("Department: " + entry.getKey() + " Count: " + entry.getValue());
        }

        System.out.println("\n=======================Question 5=====================================\n");
        System.out.println("Group by employees and get average salary\n");

        Map<String, Double> department_average_salary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        //Iterating over the hashmap to get the average salary per department
        for(Map.Entry<String, Double> entry: department_average_salary.entrySet())
        {
            System.out.println("Department: " + entry.getKey() + " average salary: " + entry.getValue());
        }

        System.out.println("\n=======================Question 6=====================================\n");
        System.out.println("Partition numbers into even and odd. Do it in a single stream operation.\n");

        List<Integer> number_list = List.of(3,6,54,27,9,89,100,45,2,22,55,26,39,78,97);
        System.out.println("Numbers list is: " + number_list);
        Map<Boolean, List<Integer>> result = number_list.stream().collect(Collectors.partitioningBy(n->n%2==0));
        System.out.println("Odd number list: " + result.get(false));
        System.out.println("Even number list: " + result.get(true));

        System.out.println();
        System.out.println("\n=======================Question 7=====================================\n");
        System.out.println("Partition employees into salary > 50k and <= 50k.");

        Map<Boolean, List<String>> employee_salary_group = employees.stream().collect(Collectors.partitioningBy(n->n.getSalary() > 50000, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Employees with salary less than 50000: " + employee_salary_group.get(false));
        System.out.println("Employees with salary greater than 50K: " + employee_salary_group.get(true));

        System.out.println("\n=======================Question 8=====================================\n");
        System.out.println("Find highest salary employee per department.");

        Map<String,String> employee_group = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), empOpt->empOpt.get().getName())));
        System.out.println("Highest earning employee per group: " + employee_group);

        System.out.println("\n=======================Question 9 and 10=====================================\n");
        System.out.println("Find the names of Employees per department.\n");


        Map<String, List<String>> employee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        for(Map.Entry<String,List<String>> entry: employee.entrySet())
        {
            System.out.println("Department: " + entry.getKey() + " Employees: " + entry.getValue());
        }
        System.out.println();
        System.out.println("\n=======================Question 11=====================================\n");
        System.out.println("Convert a List<List<Integer>> to List<Integer>\n");
        List<List<Integer>> nested_numbers = List.of(List.of(1,2), List.of(3,4), List.of(5,6));
        System.out.println("The list of lists are as follows: " + nested_numbers);
        List<Integer> merged_numbers = nested_numbers.stream().flatMap(List::stream).toList();
        System.out.println("The flattened list is now: " + merged_numbers);

        System.out.println("\n=======================Question 12=====================================\n");
        System.out.println("Given a list of sentences, return list of all words from those sentences\n");
        List<String> sentences = List.of("Java is fun", "Streams make life easier", "I love coding", "FlatMap flattens nested structures", "Practice makes perfect");
        System.out.println("Given are the list of sentences: "+ sentences);
        List<String> words = sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).toList();
        System.out.println("All the words extracted from the sentences are: " + words);
    }

}
