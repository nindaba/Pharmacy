package pl.edu.vistula.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MedicineData {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private Integer count;
    private BigDecimal price;
    private String manufacture;
}
