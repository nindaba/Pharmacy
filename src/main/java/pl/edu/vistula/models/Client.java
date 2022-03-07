package pl.edu.vistula.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    private List<Order> orders;
}