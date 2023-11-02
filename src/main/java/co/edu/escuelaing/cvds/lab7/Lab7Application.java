package co.edu.escuelaing.cvds.lab7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
//Lab081324
@SpringBootApplication
public class Lab7Application {
	@Autowired
	EmployeeService employeeService;


	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return(args) -> {
			//ObjectMapper mapper = new ObjectMapper();
			//TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>(){};
			//InputStream inputStream = TypeReference.class.getResourceAsStream("/json/employees.json");
			//try {
			//GRANT ALL PRIVILEGES ON *.* TO "root1"@"%" IDENTIFIED BY "Lab081324";	
			//GRANT ALL PRIVILEGES ON *.* TO 'root1'@'%' IDENTIFIED BY 'Lab081324' WITH GRANT OPTION;
			//	List<Employee> users = mapper.readValue(inputStream,typeReference);
			//	employeeService.save(users);
			//	System.out.println("Users Saved!");
			//} catch (IOException e){
			//	System.out.println("Unable to save users: " + e.getMessage());
			//}
		};

	}
}
