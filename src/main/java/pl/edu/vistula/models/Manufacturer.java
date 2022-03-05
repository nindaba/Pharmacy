package pl.edu.vistula.models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.LAZY)
    private List<Medicine> medicines;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}