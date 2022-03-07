package pl.edu.vistula.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.vistula.data.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name="medicine_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Client client;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Medicine> medicine = new HashSet<>();
    private String trackingNumber = UUID.randomUUID().toString();
    private OrderStatus orderStatus = OrderStatus.PENDING;
}