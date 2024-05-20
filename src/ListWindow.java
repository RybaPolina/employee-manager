import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListWindow {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel membersPanel;
    private JPanel tasksPanel;
    private JTable workersTable;
    private JTable tasksTable;
    private JTextField employeeNameTextField;
    private JTextField employeePositionTextField;
    private JTextField employeeSurnameTextField;
    private JButton EmployeeCreateButton;
    private JTextField taskNameTextField;
    private JButton TaskCreateButton;
    private JRadioButton taskStatusRadio;
    private JComboBox taskEmployeeComboBox;
    private JTextField taskDueDateTextField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListWindow");
        frame.setContentPane(new ListWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Task task1 = new Task("Napisać klasę pracownik", Task.TaskStatus.IN_PROGRESS);
        Task task2 = new Task("Dodać wielu pracowników", Task.TaskStatus.TODO);
        Task task3 = new Task("Grać cały dzień", Task.TaskStatus.TODO);

        Employee employee1 = new Employee("James", "Adams", "Programmer");
        Employee employee2 = new Employee("Jame", "Adam", "Programmer");
        Employee employee3 = new Employee("Konrad", "Cepryński", "Professional Leniuch");

        employee2.assignTask(task1);
        employee3.assignTask(task3);
        System.out.println(employee2.assignedTasks);
        for (Employee employee:Employee.getAllEmployees()) {
            System.out.println(employee.name + " " + employee.surname);
        }

    }

    private void createUIComponents() {
        workersTable = new JTable();
        workersTable.setModel(new EmployeeTableModel());

        tasksTable = new JTable();
        tasksTable.setModel(new TasksTableModel());

        EmployeeCreateButton = new JButton();
        EmployeeCreateButton.addActionListener(e -> {
            String name = employeeNameTextField.getText();
            String surname = employeeSurnameTextField.getText();
            String position = employeePositionTextField.getText();
            new Employee(name, surname, position);
            employeeNameTextField.setText("");
            employeeSurnameTextField.setText("");
            employeePositionTextField.setText("");
            panel1.repaint();
        });

        taskEmployeeComboBox = new JComboBox();
        //nie dziala nie wiadomo czemu :(
        for (Employee employee:Employee.getAllEmployees()) {
            taskEmployeeComboBox.addItem(employee.name + " " + employee.surname);
        }

        TaskCreateButton = new JButton();
        TaskCreateButton.addActionListener(e -> {
           String name = taskNameTextField.getText();
           new Task(name, Task.TaskStatus.IN_PROGRESS);
           taskNameTextField.setText("");
           panel1.repaint();
        });

    }
}
