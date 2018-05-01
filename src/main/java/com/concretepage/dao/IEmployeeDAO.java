package com.concretepage.dao;
import java.util.List;
import com.concretepage.entity.Employee;
public interface IEmployeeDAO {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int employeeId);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
    boolean employeeExists(String empName, String empAddress);
}
 