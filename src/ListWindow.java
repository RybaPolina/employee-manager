import javax.swing.*;
import java.awt.*;

public class ListWindow {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JPanel membersPanel;
    private JPanel tasksPanel;
    private JTable workersTable;
    private JTable tasksTable;

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListWindow");
        frame.setContentPane(new ListWindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Task task1 = new Task("Napisać klasę pracownik", Task.TaskStatus.IN_PROGRESS);
        Task task2 = new Task("Dodać wielu pracowników", Task.TaskStatus.TODO);

        Employee employee1 = new Employee("James", "Adams", "Programmer");
        Employee employee2 = new Employee("Jame", "Adam", "Programmer");

    }

    private void createUIComponents() {
        JPanel membersPanel = new JPanel();
        workersTable = new JTable();
        membersPanel.add(workersTable);
        workersTable.setModel(new EmployeeTableModel(Employee.allEmployees));

        //JPanel tasksPanel = new JPanel();
        //tasksPanel.setBackground(Color.yellow);

        /*tasksTable = new JTable();
        tasksPanel.add(tasksTable);
        //tasksTable.setModel(new TasksTableModel( new Task("Cos zrob", Task.TaskStatus.IN_PROGRESS)));
        tasksTable.setModel(new EmployeeTableModel( new Employee("Janek", "Planek", "Programmer")));

        JTabbedPane tabbedPane1 = new JTabbedPane();
        tabbedPane1.add("Workers ",membersPanel);
        tabbedPane1.add("Tasks",tasksPanel);
        */
        /*for (Employee employee:Employee.getAllEmployees()){
        workersTable.setModel(new EmployeeTableModel(employee));
        }*/

    }
}
