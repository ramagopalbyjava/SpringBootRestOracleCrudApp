package in.nareshit.ram.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.ram.entity.Employee;
import in.nareshit.ram.exception.EmployeeNotFoundException;
import in.nareshit.ram.repo.IEmployeeRepository;
import in.nareshit.ram.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeRepository repo;

	
	public Integer saveEmployee(Employee e) {
		
		return repo.save(e).getEmpId();
	}

	
	public Employee findOneEmployee(Integer id) {
	
		return repo.findById(id).orElseThrow(()-> new EmployeeNotFoundException(id +" Not found"));
	}

	
	public List<Employee> findAllEmployee() {
		
		return repo.findAll();
	}

	
	public void deleteEmployee(Integer id) {
		
		repo.delete(findOneEmployee(id));
		
	}

	
	public void updateEmployee(Employee e) {
		
		if(null==e.getEmpId() || repo.existsById(e.getEmpId())) {
			
			throw new EmployeeNotFoundException(e.getEmpId()+ "- Not Found");
			
		}
		else {
			repo.save(e);
		}
	}

	

	

	
	
	

}
