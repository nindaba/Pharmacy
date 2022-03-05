package pl.edu.vistula.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.edu.vistula.data.MedicineDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String size;
    private Integer count;
    private String weight;
    private BigDecimal price;
    private String image;
    private String barcode;
    private Date created;
    private Date expires;
    @ManyToOne(fetch = FetchType.LAZY)
    private SubCategory subCategory;
    @ManyToOne
    private Manufacturer manufacturer;

    public Medicine(MedicineDetails details){
        name = details.getName();
        description = details.getDescription();
        size = details.getSize();
        count = details.getCount();
        weight = details.getWeight();
        image = details.getImage();
        barcode = details.getBarcode();
        created = details.getCreated();
        expires = details.getExpires();
        price = details.getPrice();
    }
}