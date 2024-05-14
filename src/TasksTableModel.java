import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TasksTableModel extends AbstractTableModel {

    String name;
    Task.TaskStatus taskStatus;
    LocalDateTime creationDateTime;
    LocalDateTime projectedFinishDateTime;
    Employee assignedEmployee;
    private String[] columnNames = { "Task Name", "Status", "Creation Time",
            "Deadline", "Assigned Employee" };

    public TasksTableModel(Task t){
        this.name = t.name;
        this.taskStatus = t.taskStatus;
        this.creationDateTime = t.creationDateTime;
        this.assignedEmployee = t.assignedEmployee;
    }


    @Override
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return name;
            case 1:
                return taskStatus;
            case 2:
                return creationDateTime;
            case 3:
                return projectedFinishDateTime;
            case 4:
                return assignedEmployee;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return Task.TaskStatus.class;
            case 2:
                return LocalDateTime.class;
            case 3:
                return LocalDateTime.class;
            case 4:
                return Employee.class;
        }
        return null;
    }
}