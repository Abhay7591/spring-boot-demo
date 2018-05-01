package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IEmployeeDAO;
import com.concretepage.entity.Employee;
@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDAO EmployeeDAO;
	@Override
	public Employee getEmployeeById(int EmployeeId) {
		Employee obj = EmployeeDAO.getEmployeeById(EmployeeId);
		return obj;
	}	
	@Override
	public List<Employee> getAllEmployee(){
		return EmployeeDAO.getAllEmployee();
	}
	@Override
	public synchronized boolean addEmployee(Employee Employee){
       if (EmployeeDAO.employeeExists(Employee.getEmployeeName(), Employee.getEmployeeAddress())) {
    	   return false;
       } else {
    	   EmployeeDAO.addEmployee(Employee);
    	   return true;
       }
	}
	@Override
	public void updateEmployee(Employee Employee) {
		EmployeeDAO.updateEmployee(Employee);
	}
	@Override
	public void deleteEmployee(int EmployeeId) {
		EmployeeDAO.deleteEmployee(EmployeeId);
	}
}
