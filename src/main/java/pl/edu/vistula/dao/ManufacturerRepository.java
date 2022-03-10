package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.vistula.models.Manufacturer;

import java.util.Optional;

import static pl.edu.vistula.controllers.ControllerConstants.Manufacturer.Controller;

@RepositoryRestResource(path = Controller)
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Integer> {
//    @Query("SELECT m FROM Manufacturer m WHERE m.name = ?1")
    Optional<Manufacturer> findByName(String name);
}
