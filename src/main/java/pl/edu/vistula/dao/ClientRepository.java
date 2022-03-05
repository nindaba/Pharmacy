package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.vistula.models.Client;

import static pl.edu.vistula.controllers.ControllerConstants.Client.Controller;

@RepositoryRestResource(path = Controller)
public interface ClientRepository extends JpaRepository<Client,Integer> {
}
