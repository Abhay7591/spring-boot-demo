package com.concretepage.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Employee;
@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public List<Employee> getAllEmployee() {
		String hql = "FROM Employee as emp ORDER BY emp.employeeId";
		return (List<Employee>) entityManager.createQuery(hql).getResultList();
	}
	@Override
	public Employee getEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		
	}
	@Override
	public void updateEmployee(Employee employee) {
		Employee emp = getEmployeeById(employee.getEmployeeId());
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setEmployeeAddress(employee.getEmployeeAddress());
		entityManager.flush();	}
	@Override
	public void deleteEmployee(int employeeId) {
		entityManager.remove(getEmployeeById(employeeId));
	}
	@Override
	public boolean employeeExists(String empName, String empAddress) {
		String hql = "FROM Employee as emp WHERE emp.employeeName = ? and emp.employeeAddress = ?";
		int count = entityManager.createQuery(hql).setParameter(1, empName)
		              .setParameter(2, empAddress).getResultList().size();
		return count > 0 ? true : false;
		
	}
}
