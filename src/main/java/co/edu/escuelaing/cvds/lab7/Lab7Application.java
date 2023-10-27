package co.edu.escuelaing.cvds.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
//Lab081324
@SpringBootApplication
public class Lab7Application {
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}
}
