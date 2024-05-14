import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Task task1 = new Task("Napisać klasę pracownik", Task.TaskStatus.IN_PROGRESS);
        Task task2 = new Task("Dodać wielu pracowników", Task.TaskStatus.TODO);

        Employee employee1 = new Employee("James", "Adams", "Programmer");
        Employee employee2 = new Employee("Jame", "Adam", "Programmer");

        task1.assignEmployee(employee1);

        System.out.println(Task.getAllTasks());
        System.out.println(Employee.getAllEmployees());
    }
}