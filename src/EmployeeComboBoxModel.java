import javax.swing.*;

public class EmployeeComboBoxModel extends DefaultComboBoxModel<String> {

    @Override
    public int getSize() {
        return Employee.getEmployeesCount();
    }

    @Override
    public String getElementAt(int index) {
        return Employee.getAllEmployees().get(index).getEmployeeName() + " " + Employee.getAllEmployees().get(index).getSurname();
    }
}
