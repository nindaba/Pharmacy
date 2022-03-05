package pl.edu.vistula.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(unique = true)
    private String name;
    @NonNull
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @NonNull
    private Category category;
    @OneToMany(mappedBy = "subCategory" ,cascade = CascadeType.ALL)
    private List<Medicine> medicines;
    public SubCategory(){}
}