import java.util.ArrayList;
import java.util.List;

public class Employee {
    public static final List<Employee> allEmployees = new ArrayList<>();
    String name;
    String surname;
    String position;
    List<Task> assignedTasks;

    public Employee(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.assignedTasks = new ArrayList<>();
        allEmployees.add(this);
    }

    public void assignTask(Task t) {
        if (!assignedTasks.contains(t)) {
            t.assignEmployee(this);
        }
    }

    public void unassignTask(Task t) {
        t.unassignEmployee();
        assignedTasks.remove(t);
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public String getEmployeeName() {
        return name;
    }

    public int getAssignedTasksCount() {
        return assignedTasks.size();
    }

    public static List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public static int getEmployeesCount() {
        return allEmployees.size();
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", assignedTasks=" + assignedTasks.size() +
                '}';
    }
}