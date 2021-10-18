package in.nareshit.ram.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.ram.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	
}
