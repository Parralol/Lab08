package co.edu.escuelaing.cvds.lab7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public void save(List<Employee> employee) {
        employeeRepository.saveAll(employee);
    }

    public Employee getEmployee(String employee_id) {
        if(employeeRepository.findByEmployeeid(employee_id).size() != 0){
            return employeeRepository.findByEmployeeid(employee_id).get(0);
        }else{
            return null;
        }
           
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.findByEmployeeid(employee.getEmployeeid()).size() == 0) {
            return employeeRepository.save(employee);
        }

        return null;
    }

    public void deleteEmployee(String employee_id) {
        employeeRepository.deleteById(employee_id);
    }
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

}