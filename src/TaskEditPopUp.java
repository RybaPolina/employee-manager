import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskEditPopUp extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField taskNamePUTextField;
    private JRadioButton toDoPURadioButton;
    private JRadioButton inProgressPURadioButton;
    private JRadioButton donePURadioButton;
    private JComboBox taskEmployeePUComboBox;
    private JComboBox taskDueDatePUDayCombo;
    private JComboBox taskDueDatePUMonthCombo;
    private JComboBox taskDueDatePUYearCombo;
    private JComboBox taskDueDatePUHourCombo;
    private Task toBeEdited;

    private Task.TaskStatus getRadioPUTaskStatus (){
        if (toDoPURadioButton.isSelected()){
            return Task.TaskStatus.TODO;
        } else if (inProgressPURadioButton.isSelected()) {
            return  Task.TaskStatus.IN_PROGRESS;
        } else if (donePURadioButton.isSelected()) {
            return Task.TaskStatus.FINISHED;
        }
        return null;
    }

    public TaskEditPopUp(Task task) {
        toBeEdited = task;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        toBeEdited.setTaskName(taskNamePUTextField.getText());
        toBeEdited.setTaskStatus(getRadioPUTaskStatus());
        String taskDueDatePUTextField = taskDueDatePUDayCombo.getSelectedItem() + "." + taskDueDatePUMonthCombo.getSelectedItem() + "." + taskDueDatePUYearCombo.getSelectedItem() + " " + taskDueDatePUHourCombo.getSelectedItem();
        toBeEdited.setProjectedFinishDateTime(LocalDateTime.parse(taskDueDatePUTextField, DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm")));
        toBeEdited.unassignEmployee();
        toBeEdited.assignEmployee(Employee.getAllEmployees().get(taskEmployeePUComboBox.getSelectedIndex()));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        EmployeeComboBoxModel mode = new EmployeeComboBoxModel();
        taskEmployeePUComboBox = new JComboBox(mode);
        taskEmployeePUComboBox.setSelectedItem(toBeEdited.getTaskAssignedEmployee());

        taskDueDatePUMonthCombo = new JComboBox(Calendar.getMonth());
        taskDueDatePUHourCombo = new JComboBox(Calendar.getHours());
        taskDueDatePUYearCombo = new JComboBox(Calendar.getYear());
        taskDueDatePUDayCombo = new JComboBox(Calendar.getDay());
    }
}
