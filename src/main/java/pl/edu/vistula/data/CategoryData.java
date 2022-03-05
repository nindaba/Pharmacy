package pl.edu.vistula.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

/**
 * This will store data related to category data, since it is not
 * advisable to expose models
 */
@Data
@AllArgsConstructor
public class CategoryData {
    private Integer id;
    private String name;
    /**we introduce names of the subcategories instead of the whole subcategory*/
    private Set<String> subCategories;
    private String image;
    private String description;
    /**provide the count of subcategory to minimize operations*/
    public Integer getCount(){return subCategories.size();}
}
