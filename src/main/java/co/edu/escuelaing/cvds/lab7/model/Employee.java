package co.edu.escuelaing.cvds.lab7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "EMPLOYEEID")
    private String employeeid;
    @Column(name = "FIRST_NAME")
    private String first_name;
    @Column(name = "LAST_NAME")
    private String last_name;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "SALARY")
    private Double salary;
    @Column(name = "EMPRESA")
    private String empresa;
    @Column(name = "SEXO")
    private char sexo;

    public Employee(String first, String last) {

        setFirst_name(first);
        setLast_name(last);

    }

    /**
     * @param employeeid
     */
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * @param first_name
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @param last_name
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getRole() {
        return role;
    }

    public Double getSalary() {
        return salary;
    }

    public String getEmpresa() {
        return empresa;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeid == null) ? 0 : employeeid.hashCode());
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
        result = prime * result + sexo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (employeeid == null) {
            if (other.employeeid != null)
                return false;
        } else if (!employeeid.equals(other.employeeid))
            return false;
        if (first_name == null) {
            if (other.first_name != null)
                return false;
        } else if (!first_name.equals(other.first_name))
            return false;
        if (last_name == null) {
            if (other.last_name != null)
                return false;
        } else if (!last_name.equals(other.last_name))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (empresa == null) {
            if (other.empresa != null)
                return false;
        } else if (!empresa.equals(other.empresa))
            return false;
        if (sexo != other.sexo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", first_name=" + first_name + ", last_name=" + last_name
                + ", role=" + role + ", salary=" + salary + ", empresa=" + empresa + ", sexo=" + sexo + "]";
    }

}
