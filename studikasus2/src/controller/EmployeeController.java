package controller;

import model.Employee;
import model.EmployeeMapper;
import view.EmployeeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeeController {
    private final EmployeeView view;
    private final EmployeeMapper mapper;

    public EmployeeController(EmployeeView view, EmployeeMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        // Register listeners
        this.view.addAddEmployeeListener(new AddEmployeeListener());
        this.view.addRefreshListener(new RefreshListener());
    }

    // Listener untuk menambahkan karyawan
    class AddEmployeeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String position = view.getPositionInput();
            String department = view.getDepartmentInput();
            String salaryText = view.getSalaryInput();

            if (!name.isEmpty() && !position.isEmpty() && !department.isEmpty() && !salaryText.isEmpty()) {
                try {
                    double salary = Double.parseDouble(salaryText);
                    Employee employee = new Employee(0, name, position, department, salary);
                    mapper.insertEmployee(employee);
                    JOptionPane.showMessageDialog(view, "Employee added successfully!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Invalid salary value. Please enter a valid number.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    // Listener untuk menyegarkan daftar karyawan
    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Employee> employees = mapper.getAllEmployees();
            String[] employeeArray = employees.stream()
                .map(emp -> emp.getName() + " (" + emp.getPosition() + " - " + emp.getDepartment() + ")")
                .toArray(String[]::new);
            view.setEmployeeList(employeeArray);
        }
    }
}
