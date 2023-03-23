package Task_3.task_3_CRUD.controller;

import Task_3.task_3_CRUD.exception.ResourceNotFoundException;
import Task_3.task_3_CRUD.model.Employee;
import Task_3.task_3_CRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")

public class EmployeeController {

    @Autowired
   private EmployeeRepository employeeRepository;
 @GetMapping
    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }

    //build create employees REST API
@PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    //build get employees by id REST API

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with this Id :"+ id) );
        return ResponseEntity.ok(employee);

    }

    //build update Employee REST API

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
    {
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with this Id :"+ id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName((employeeDetails.getLastName()));
        updateEmployee.setEmailID((employeeDetails.getEmailID()));

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build Delete employee REST API
@DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id)
    {
        Employee deleteemployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with this Id :"+ id));

        employeeRepository.delete(deleteemployee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
