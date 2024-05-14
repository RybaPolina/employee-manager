import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Task task1 = new Task("Napisać klasę pracownik", Task.TaskStatus.IN_PROGRESS);
        Task task2 = new Task("Dodać wielu pracowników", Task.TaskStatus.TODO);

        Employee employee1 = new Employee("James", "Adams", "Programmer");
        Employee employee2 = new Employee("Polina", "Rybachuk", "Designer");

        task2.taskStatus = Task.TaskStatus.FINISHED;
        task2.assignEmployee(employee2);

        System.out.println(Task.allTasks);




    }
}