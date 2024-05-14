import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class FinalTableModel extends AbstractTableModel {

    private String string;
    private String[] columnNames = { "Recipe", "Order", "Instruction",
            "Est.time", "Timer", "Timer Label", "Has Subinstructions"};

    public FinalTableModel(String s){
        this.string = s;
    }

    @Override
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return string;
            case 1:
                return 1;
            case 2:
                return string;
            case 3:
                return 1.0;
            case 4:
                return 1.0;
            case 5:
                return string;
            case 6:
                return true;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            case 4:
                return Double.class;
            case 5:
                return String.class;
            case 6:
                return Boolean.class;
        }
        return null;
    }
}