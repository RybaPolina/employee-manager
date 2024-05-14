import java.util.ArrayList;
import java.util.List;

//Utworzenie klasy Employee
public class Employee {
    String name;
    String surname;
    String position;
    List<Task> assignedTasks;

    //Konstruktor objektu Employee
    public Employee(String name, String surname, String position) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.assignedTasks = new ArrayList<>();
    }

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

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}