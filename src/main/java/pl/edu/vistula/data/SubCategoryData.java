package pl.edu.vistula.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * This will store data related to sub category data, since it is not
 * advisable to expose models
 */
@Data
@AllArgsConstructor
public class SubCategoryData {
    private Integer id;
    private String name;
    /**unlike the category we are going to expose all the products*/
    private List<MedicineData> medicines;
    private String image;
    /**provide the count of subcategory to minimize operations*/
    public Integer getCount(){return medicines.size();}
}
