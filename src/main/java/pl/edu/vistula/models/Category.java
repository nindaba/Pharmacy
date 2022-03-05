package pl.edu.vistula.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy ="category" , cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;
    @NonNull
    private String image;
    @NonNull
    private String description;
}