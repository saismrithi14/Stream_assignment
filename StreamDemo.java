import java.util.*;
import java.util.stream.*;
public class StreamDemo {

    public static void main(String[] args) {
        {
            Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
            List<Integer> ll = stream.filter(n->n%2==0).toList();
            System.out.println(ll);

            // is this an anonymous class
            Runnable runnable = new Runnable() {
                @Override
                public void run()
                {
                    System.out.println("Inside an anonymous function");
                }
            };

            Runnable running =  ()-> System.out.println("Running anonymous method");
            
            //Find all even numbers from a list of integers
            List<Integer> l1 = List.of(99,100,45,891,2,1,6,5,7,8,0,3,19,20,21,22,50,51,54,65,78,34);
            System.out.println("Initial list is: " + l1);

            List<Integer> even_list = l1.stream().filter(n->n%2==0).toList();
            System.out.println("list with even integers is: " + even_list);

            //Find all numbers greater than 50
            List<Integer> more_50 = l1.stream().filter(n-> n > 50).toList();
             System.out.println("list with integers greater than 50 is: " + more_50);

            //Convert all strings in a list to uppercase
            List<String> names = List.of("alice", "bob", "charlie", "darla", "emma", "allison", "anna");
            List<String> upperCaseNames = names.stream().map(String::toUpperCase).toList();
            System.out.println("List with upper case names is: " + upperCaseNames);

            //Remove null elements from list
            ArrayList<String> words = new ArrayList<>();
            words.add(null);
            words.add("axe");
            words.add("train");
            words.add(null);
            words.add("shirt");
            words.add("month");
            words.add("students");
            words.add(null);
            words.add(null);
            words.add("house");
            System.out.println("Initial word list with null is: " + words);

            List<String> not_null_words = words.stream().filter(Objects::nonNull).toList();
            System.out.println("Filtered list where null is not there is: " + not_null_words);

            // get length of each element in the list
            System.out.println("Working with the not_null_words list");
            List<Integer> words_length = not_null_words.stream().map(n->n.length()).toList();
            System.out.println("For all the words in the not_null_list, each of their lengths are: " + words_length);

            //finding people whose names start with A
            List<String> name_with_A = upperCaseNames.stream().filter(n-> n.startsWith("A")).toList();
            System.out.println("People whose names start with A are as follows: " + name_with_A);

            //finding the squares of numbers
            List<Integer> square_numbers = l1.stream().map(n->n*n).toList();
            System.out.println("The square of the elements is: " + square_numbers);

            //Creating employees
            Employee e1 = new Employee(1, "Alice", 54000, "alice.f@gmail.com");
            Employee e2 = new Employee(2, "Bob", 49000, "bob.g@gmail.com");
            Employee e3 = new Employee(3, "Charlie", 51000, "charlie.h@gmail.com");
            Employee e4 = new Employee(4, "Dean", 43000, "bob.h@gmail.com");
            Employee e5 = new Employee(5, "Emma", 53000, "emma.j@gmail.com");

            List<Employee> employees = List.of(e1,e2,e3,e4,e5);
            List<String> employee_names = employees.stream().filter(e -> e.getSalary() > 50000).map(Employee::getName).toList();
            System.out.println("Employees with a salary higher than 50,000 are: " + employee_names);

            List<String> emails = employees.stream().map(e->e.getEmail()).toList();
            System.out.println("List of emails of employees are: " + emails);

            //Finding the number of elements that are divisible by 3
            long count = l1.stream().filter(n->n%3==0).count();
            System.out.println("Number of numbers in " + l1 + " which are divisible by 3 are: " + count);

        }
    }
 }
    

