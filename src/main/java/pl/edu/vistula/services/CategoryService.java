package pl.edu.vistula.services;

import lombok.AllArgsConstructor;
import pl.edu.vistula.Exception.RecordNotFound;
import pl.edu.vistula.dao.CategoryRepository;
import pl.edu.vistula.data.CategoryData;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.models.Category;
import pl.edu.vistula.populators.Populator;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    private Populator<Category,CategoryData> populator;
    /**
     *
     * @return List of populated Categories found in the database
     */
    public List<CategoryData> getCategories(){
        return categoryRepository
                .findAll()
                .stream()
                .map(populator::populate)
                .collect(Collectors.toList());
    }
    /**
     * @return Populated Category found in the database by the provided Id
     * @throws RecordNotFound if the Id provided is not found
     */
    public CategoryData getCategory(Integer categoryId){
        return categoryRepository.findById(categoryId)
                .map(populator::populate)
                .orElseThrow(()-> new RecordNotFound("No Category Found matching the provided Id : "+categoryId));
    }

    public SuccessResponse deleteCategories(String ids) {
        if(ids.equals("")) {
            categoryRepository.deleteAll();
            return new SuccessResponse("All Category Deleted Successfully");
        }

        categoryRepository.deleteAllById(Stream.of(ids.split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toSet())
        );
        return new SuccessResponse("Category Deleted Successfully");
    }

    public URI addCategory(CategoryData category) {
        var categoryModel = new Category(
                category.getName(),
                category.getImage(),
                category.getDescription()
        );
        return URI.create(categoryRepository
                .save(categoryModel)
                .getId()
                .toString());
    }

    /**
     * this will update category name and the image
     * @param id
     * @param categoryData
     * @return OK
     * TODO check if the indexing is working and throwing errors
     */
    public SuccessResponse editCategory(Integer id,CategoryData categoryData) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(categoryData.getName());
                    category.setImage(categoryData.getImage());
                    category.setDescription(categoryData.getDescription());
                    return categoryRepository.save(category);
                })
                .map(category -> new SuccessResponse("Category edited Successfully"))
                .orElseThrow(()-> new RecordNotFound("No Category Found matching the provided Id :"+id)); //not found and duplicated
    }
}
