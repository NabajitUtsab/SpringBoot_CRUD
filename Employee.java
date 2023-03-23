package Task_3.task_3_CRUD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LasttName")
    private String lastName;
    @Column(name = "Email-Id")
    private String emailID;
}
