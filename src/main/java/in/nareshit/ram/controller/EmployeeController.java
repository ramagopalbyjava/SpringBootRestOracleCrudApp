package in.nareshit.ram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.ram.entity.Employee;
import in.nareshit.ram.exception.EmployeeNotFoundException;
import in.nareshit.ram.service.IEmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;


	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(
			@RequestBody Employee employee
			){
		ResponseEntity<String> resp=null;

		Integer id=service.saveEmployee(employee);

		resp=new ResponseEntity<String>("Employee '"+id+"' Created",HttpStatus.CREATED);

		return resp;

	}

	@GetMapping("all")
	public ResponseEntity<List<Employee>> findAllemployee(){

		ResponseEntity<List<Employee>> resp=null;

		List<Employee> list=service.findAllEmployee();
		resp=new ResponseEntity<List<Employee>>(list,HttpStatus.OK);

		return resp;

	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchOneEmployee(
			@PathVariable Integer id
			){
		ResponseEntity<?> resp=null;
		try {
			Employee e=service.findOneEmployee(id);
			resp=new ResponseEntity<Employee>(e,HttpStatus.OK);

		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			resp=new ResponseEntity<Employee>(
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}

		return resp;

	}
	@DeleteMapping("remove/{id}")
	public ResponseEntity<String> removeEmployee(
			@PathVariable Integer id
			){
		ResponseEntity<String> resp=null;
		try {
			service.deleteEmployee(id);
			resp=new ResponseEntity<String>(id +"- Deleted", HttpStatus.OK);
			
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return resp;
		
	}
	
	

}
