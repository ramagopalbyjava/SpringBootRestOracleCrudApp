package in.nareshit.ram.service;

import java.util.List;

import in.nareshit.ram.entity.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee e);
	public Employee findOneEmployee(Integer id);
	public List<Employee> findAllEmployee();
	public void deleteEmployee(Integer id);
	public void updateEmployee(Employee e);
	
	
}
