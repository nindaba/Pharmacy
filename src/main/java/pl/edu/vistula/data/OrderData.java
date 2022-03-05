package pl.edu.vistula.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class OrderData {
    private Integer clientId;
    private String trackingNumber;
    private Set<MedicineData> medicine;
}
