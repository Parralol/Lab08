package co.edu.escuelaing.cvds.lab7.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String cargarDatos() {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new ClassPathResource("json/employees.json").getFile();
            List<Employee> employees = objectMapper.readValue(file, new TypeReference<List<Employee>>() {});
            employeeRepository.saveAll(employees);
            return "index";
        }catch(Exception e){
            return "error";
        }
    }
     @RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
    public String add(Model model, String first, String last) {
        Employee employ = new Employee(first, last);
        employeeService.addEmployee(employ);
        return "employee";
    }

}
