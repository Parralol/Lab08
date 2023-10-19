package co.edu.escuelaing.cvds.lab7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository EmployeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository EmployeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }

    public Employee addEmployee(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    public Employee getEmployee(String propiedad) {
        return EmployeeRepository.findByPropiedad(propiedad).get(1);
    }

    public List<Employee> getAllEmployees() {
        return EmployeeRepository.findAll();
    }

    public Employee updateEmployee(Employee Employee) {
        if (EmployeeRepository.findByPropiedad(Employee.getEmployee_id()).size() == 0) {
            return EmployeeRepository.save(Employee);
        }

        return null;
    }

    public void deleteEmployee(Long propiedad) {
        EmployeeRepository.deleteById(propiedad);
    }
    public List<Employee> getAll(){
        return EmployeeRepository.findAll();
    }

}