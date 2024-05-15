import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {

    private String name;
    private String surname;
    private String position;
    private int assignedTasksCount;
    private String[] columnNames = { "Name", "Surname", "Position",
            "Assigned Tasks"};

    public EmployeeTableModel(Employee e){
        this.name = e.name;
        this.surname = e.surname;
        this.position = e.position;
        this.assignedTasksCount = e.getAssignedTasksCount();
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return name;
            case 1:
                return surname;
            case 2:
                return position;
            case 3:
                return assignedTasksCount;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
        }
        return null;
    }
}