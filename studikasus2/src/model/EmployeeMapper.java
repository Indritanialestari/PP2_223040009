package model;

import java.util.List;

public interface EmployeeMapper {
    void insertEmployee(Employee employee);
    List<Employee> getAllEmployees();
    void deleteEmployee(int id);
    void updateEmployee(Employee employee);
    Employee getEmployeeById(int id);
}
