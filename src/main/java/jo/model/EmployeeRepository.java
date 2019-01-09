package jo.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jo.model.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
    List<Employee> findByJobId(String jobId);
    List<Employee> findByJobIdOrderByLastName(String jobId);
}