import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TasksTableModel extends AbstractTableModel {
    private final String[] taskColumnNames = {"Task name", "Task Status", "Created",
            "Deadline", "Assigned to"};

    public TasksTableModel() {
    }

    @Override
    public String getColumnName(int columnIndex) {
        return taskColumnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return Task.getTasksCount();
    }

    @Override
    public int getColumnCount() {
        return taskColumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = Task.getAllTasks().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return task.getTaskName();
            case 1:
                return task.getTaskStatus();
            case 2:
                return task.getTaskCreationDateTime().format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH.mm"));
            case 3:
                return task.getTaskProjectedFinishDateTime().format(DateTimeFormatter.ofPattern("dd.MM.uuuu HH.mm"));
            case 4:
                return task.getTaskAssignedEmployee();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Task.TaskStatus.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
        }
        return null;
    }
}