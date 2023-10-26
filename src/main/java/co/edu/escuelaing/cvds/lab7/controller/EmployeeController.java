package co.edu.escuelaing.cvds.lab7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    @GetMapping("/getEmployee")
    public String greeting(Model model) {
        List<Employee> empoyee = employeeService.getAll();
        model.addAttribute("employees", empoyee);
        return "/getEmployee";
    }

     @RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
    public String add(Model model, String first, String last) {
        Employee employ = new Employee(first, last);
        employeeService.addEmployee(employ);
        return "employee";
    }

}
