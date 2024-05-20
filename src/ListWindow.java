import javax.swing.*;

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

    }
}
