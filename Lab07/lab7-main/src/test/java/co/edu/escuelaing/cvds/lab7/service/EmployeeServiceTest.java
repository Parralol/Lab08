package co.edu.escuelaing.cvds.lab7.service;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    
    @Mock
    private EmployeeRepository mockedEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    public void setup(){
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = Employee.builder()
                .employeeid("1")
                .first_name("Ramesh")
                .last_name("Fadatare")
                .role("ramesh@gmail.com")
                .build();
    }
    /**
     * Dado que tengo 1 empleado registrado
     * Cuando lo consulto a nivel de servicio
     * Entonces la consulta será exitosa validando el campo id.
     */
    @Test
    void testName() {
        Employee mockedEmployee = new Employee("Santiago", "Parra");
        mockedEmployee.setEmployeeid(Integer.toString(1));
        List<Employee> mockedEmployees = new ArrayList<>();
        mockedEmployees.add(0, mockedEmployee);
        // given - precondition or setup
        given(mockedEmployeeRepository.findAll())
                .willReturn(mockedEmployees);
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
        assertThat(employees.get(0).getEmployeeid()).isEqualTo("1");

    }
    
    /**
     * Dado que no hay ningún empleado registrado
     * Cuándo lo consulto a nivel de servicio
     * Entonces la consulta no retornará ningún resultado.
     */
    @Test
    void testNone() {
        Employee mockedEmployee = new Employee("Santiago", "Parra");
        mockedEmployee.setEmployeeid(Integer.toString(1));
        List<Employee> mockedEmployees = new ArrayList<>();
        mockedEmployees.add(0, mockedEmployee);
        // given - precondition or setup
        given(mockedEmployeeRepository.findAll())
                .willReturn(mockedEmployees);
        List<Employee> employees = employeeService.getAllEmployees();
        System.out.println(employees);
        assertThat(employees.size()).isEqualTo(0);

    }
}
