import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public static final List<Task> allTasks = new ArrayList<>();
    String name;
    TaskStatus taskStatus;
    LocalDateTime creationDateTime;
    LocalDateTime projectedFinishDateTime;
    Employee assignedEmployee;

    public Task(String name, TaskStatus taskStatus) {
        this.name = name;
        this.taskStatus = taskStatus;
        this.creationDateTime = LocalDateTime.now();
        allTasks.add(this);
    }

    public void assignEmployee(Employee e){
        this.assignedEmployee = e;
        e.assignedTasks.add(this);
    }

    public void unassignEmployee(){
        this.assignedEmployee = null;
    }


    public static List<Task> getAllTasks(){
        return allTasks;
    }


    enum TaskStatus {
        TODO,
        IN_PROGRESS,
        OVERDUE,
        FINISHED
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", taskStatus=" + taskStatus +
                ", creationDateTime=" + creationDateTime +
                ", projectedFinishDateTime=" + projectedFinishDateTime +
                ", assignedEmployee=" + assignedEmployee +
                '}';
    }
}
