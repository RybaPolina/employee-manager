import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private JRadioButton toDoRadioButton;
    private JComboBox taskEmployeeComboBox;
    private JTextField taskDueDateTextField;
    private JRadioButton inProgressRadioButton;
    private JRadioButton doneRadioButton;

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

        for (String employee:Employee.getEmployeeArray()) {
            System.out.println(employee);
        }

    }

    private Task.TaskStatus getRadioTaskStatus (){
        if (toDoRadioButton.isSelected()){
            return Task.TaskStatus.TODO;
        } else if (inProgressRadioButton.isSelected()) {
            return  Task.TaskStatus.IN_PROGRESS;
        } else if (doneRadioButton.isSelected()) {
            return Task.TaskStatus.FINISHED;
        }
        return null;
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

        EmployeeComboBoxModel mode = new EmployeeComboBoxModel();
        taskEmployeeComboBox = new JComboBox(mode);


        TaskCreateButton = new JButton();
        TaskCreateButton.addActionListener(e -> {
           String name = taskNameTextField.getText();
           Task task = new Task(name, getRadioTaskStatus());
           task.assignEmployee(Employee.getAllEmployees().get(taskEmployeeComboBox.getSelectedIndex()));
           task.setProjectedFinishDateTime(LocalDateTime.parse(taskDueDateTextField.getText(), DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm")));
           taskNameTextField.setText("");
           panel1.repaint();
        });

    }
}
