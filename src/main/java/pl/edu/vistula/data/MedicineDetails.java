package pl.edu.vistula.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class MedicineDetails{
    private Integer id;
    private String name;
    private String description;
    private String size;
    private Integer count;
    private String weight;
    private String image;
    private BigDecimal price;
    private String barcode;
    private Date created;
    private Date expires;
    private String subCategory;
    private String manufacturer;

}
