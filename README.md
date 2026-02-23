The purpose of this repository is to get a better grasp on using Streams by practicing questions

Given class:


    public class Employee
    {
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

Answer the following questions:
1.	Convert list of strings into a single comma-separated string.
2.	Create a Map of employeeId → employeeName.
3.	Group employees by department.
4.	Count employees per department.
5.	Group employees by department and get average salary.
6.	Partition numbers into even and odd. Do it in a single stream operation.
7.	Partition employees into salary > 50k and <= 50k.
8.	Find highest salary employee per department.
9.	Find names of employees per department.
10.	Create a Map of department → List of employee names.
11.	Given List<List<Integer>>, flatten into single list.
12.	Given list of sentences, return list of all words from the sentences.
13.	Given employees with list of skills, get unique skills.
14.	Given list of orders with list of items, get total items count.
15.	Given nested list of integers, find sum of all elements.
16.	Find product of all numbers using reduce.
17.	Find the longest string from a list of strings using reduce.
18.	Concatenate list of strings using reduce.
19.	Find maximum salary from a list of salaries using reduce.
20.	Merge multiple maps using reduce.