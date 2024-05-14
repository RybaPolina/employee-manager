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

    //Tutaj jest jakiś bład

    public void assignTask(Task t){
        if(!assignedTasks.contains(t)){
            t.assignEmployee(this);
            assignedTasks.add(t);
        }
    }

    public void unassignTask(Task t){
        t.unassignEmployee();
        assignedTasks.remove(t);
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }
    public static List<Employee> getAllEmployees(){
        return allEmployees;
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