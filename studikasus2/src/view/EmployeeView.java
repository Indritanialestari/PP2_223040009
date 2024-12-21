package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame {
    private JTextField txtName = new JTextField(20);
    private JTextField txtPosition = new JTextField(20);
    private JTextField txtDepartment = new JTextField(20);
    private JTextField txtSalary = new JTextField(20);
    private JButton btnAdd = new JButton("Add Employee");
    private JButton btnRefresh = new JButton("Refresh");
    private JList<String> employeeList = new JList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    public EmployeeView() {
        setTitle("Employee Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel untuk form input
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Position:"));
        panel.add(txtPosition);
        panel.add(new JLabel("Department:"));
        panel.add(txtDepartment);
        panel.add(new JLabel("Salary:"));
        panel.add(txtSalary);

        // Panel untuk tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh);

        // Menambahkan panel tombol ke panel utama
        panel.add(buttonPanel);

        // Menambahkan list model ke JList
        employeeList.setModel(listModel);

        // Menambahkan komponen ke frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(employeeList), BorderLayout.CENTER);
    }

    // Mengambil input nama
    public String getNameInput() {
        return txtName.getText();
    }

    // Mengambil input posisi
    public String getPositionInput() {
        return txtPosition.getText();
    }

    // Mengambil input departemen
    public String getDepartmentInput() {
        return txtDepartment.getText();
    }

    // Mengambil input gaji
    public String getSalaryInput() {
        return txtSalary.getText();
    }

    // Menampilkan daftar karyawan di JList
    public void setEmployeeList(String[] employees) {
        listModel.clear();
        for (String employee : employees) {
            listModel.addElement(employee);
        }
    }

    // Menambahkan listener untuk tombol Add Employee
    public void addAddEmployeeListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    // Menambahkan listener untuk tombol Refresh
    public void addRefreshListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }
}
