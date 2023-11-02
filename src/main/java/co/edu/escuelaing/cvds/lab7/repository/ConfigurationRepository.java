package co.edu.escuelaing.cvds.lab7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.escuelaing.cvds.lab7.model.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, String> {
    public List<Configuration> findByPropiedad(String employee_id);

}