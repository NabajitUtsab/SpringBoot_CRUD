package Task_3.task_3_CRUD.repository;

import Task_3.task_3_CRUD.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //all CRUD database methods




}
