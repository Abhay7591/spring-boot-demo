package com.concretepage.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.concretepage.entity.Employee;

public interface IEmployeeService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<Employee> getAllEmployee();
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     Employee getEmployeeById(int employeeId);
	 @Secured ({"ROLE_ADMIN"})
     boolean addEmployee(Employee employee);
	 @Secured ({"ROLE_ADMIN"})
     void updateEmployee(Employee employee);
	 @Secured ({"ROLE_ADMIN"})
     void deleteEmployee(int employeeId);
}
