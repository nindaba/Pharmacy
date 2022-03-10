package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.vistula.models.Order;

import java.util.Optional;

import static pl.edu.vistula.controllers.ControllerConstants.Order.Controller;
import static pl.edu.vistula.controllers.ControllerConstants.Order.TrackOrder;

@RepositoryRestResource(path = Controller)
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @GetMapping(TrackOrder)
    Optional<Order> findByTrackingNumber(@PathVariable String tracker);
}
