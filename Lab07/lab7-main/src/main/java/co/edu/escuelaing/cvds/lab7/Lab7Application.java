package co.edu.escuelaing.cvds.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

@SpringBootApplication
public class Lab7Application {
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {
			Employee employee1 = new Employee();
			
		};
	}

}
