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
        this.projectedFinishDateTime = LocalDateTime.now().plusDays(7);
        allTasks.add(this);
    }

    public Task(String name, TaskStatus taskStatus, LocalDateTime projectedFinishDateTime) {
        this.name = name;
        this.taskStatus = taskStatus;
        this.creationDateTime = LocalDateTime.now();
        this.projectedFinishDateTime = projectedFinishDateTime;
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

    public static int getTasksCount() {
        return allTasks.size();
    }

    public String getTaskName() {
        return name;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public LocalDateTime getTaskCreationDateTime() {
        return creationDateTime;
    }

    public void setProjectedFinishDateTime(LocalDateTime dueDate) {
        this.projectedFinishDateTime = dueDate;
    }

    public LocalDateTime getTaskProjectedFinishDateTime() {
        return projectedFinishDateTime;
    }

    public String getTaskAssignedEmployee() {
        if (assignedEmployee != null) {
            return assignedEmployee.getEmployeeName() + " " + assignedEmployee.getSurname();
        }
        return "No Employee Assigned";
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
