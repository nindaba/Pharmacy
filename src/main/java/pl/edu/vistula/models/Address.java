package pl.edu.vistula.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String code;
    private String street;
    private String city;
}