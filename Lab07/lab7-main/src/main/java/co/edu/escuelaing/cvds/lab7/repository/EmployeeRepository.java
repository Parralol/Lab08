package co.edu.escuelaing.cvds.lab7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.cvds.lab7.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByPropiedad(String propiedad);

}