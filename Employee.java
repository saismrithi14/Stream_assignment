import java.util.*;
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private String email;
    private List<String> skills;

    public Employee(int id, String name, String department, double salary, String email, List<String> skills)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.skills = skills;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString()
    {
        return name;
    }

}

