package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.models.Order;

import static pl.edu.vistula.controllers.ControllerConstants.Order.Controller;

@RepositoryRestResource(path = Controller)
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
