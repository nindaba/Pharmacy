package pl.edu.vistula.populators;

import org.springframework.stereotype.Service;
import pl.edu.vistula.data.CategoryData;
import pl.edu.vistula.models.Category;
import pl.edu.vistula.models.SubCategory;

import java.util.stream.Collectors;

/**
 * This will serve a purpose of changing the category model to category data
 * This can bean can be overriden by any one to meet his purpose
 */
public class CategoryPopulator implements Populator<Category, CategoryData>{
    @Override
    public CategoryData populate(Category category) {
        return new CategoryData(
                category.getId(),
                category.getName(),
                category.getSubCategories()
                        .stream()
                        .map(SubCategory::getName)
                        .collect(Collectors.toSet()),
                category.getImage(),
                category.getDescription()
        );
    }
}
