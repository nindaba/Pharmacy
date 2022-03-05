package pl.edu.vistula.services;

import lombok.AllArgsConstructor;
import pl.edu.vistula.Exception.RecordNotFound;
import pl.edu.vistula.dao.CategoryRepository;
import pl.edu.vistula.dao.SubCategoryRepository;
import pl.edu.vistula.data.SubCategoryData;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.models.SubCategory;
import pl.edu.vistula.populators.Populator;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class SubCategoryService {
    private SubCategoryRepository subCategoryRepository;
    private Populator<SubCategory,SubCategoryData> populator;
    private CategoryRepository categoryRepository;
    /**
     * Fetches all SubCategory from persistence and populates to subcategory data
     * @return List SubCategoryData  or empty list
     */
    public List<SubCategoryData> getSubCategories() {
        return subCategoryRepository.findAll()
                .stream()
                .map(populator::populate)
                .collect(Collectors.toList());
    }

    /**
     * This will find a subCategory based on its Id
     * @param categoryId
     * @return SubCategoryData
     * @throws RecordNotFound
     */
    public SubCategoryData getCategory(Integer categoryId) {
        return subCategoryRepository.findById(categoryId)
                .map(populator::populate)
                .orElseThrow(()-> new RecordNotFound("No SubCategory Found matching the provided Id :"+categoryId));
    }

    /**
     * This will loop through the ids and convert them to
     * @param ids separated by ","
     * @return String OK
     * @todo: this return type will be changed to success response
     *
     */
    public SuccessResponse deleteCategories(String ids) {
        if(ids.equals("")) {
            subCategoryRepository.deleteAll();
            return new SuccessResponse("All SubCategories deleted successfully");
        }
        subCategoryRepository.deleteAllById(Stream.of(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet())
        );
        return  new SuccessResponse("SubCategories deleted successfully");
    }
    public URI addCategory(Integer categoryId,SubCategoryData category) {
        return URI.create(subCategoryRepository.save(
                new SubCategory(
                        category.getName(),
                        category.getImage(),
                        categoryRepository.findById(categoryId).orElseThrow(()-> new RecordNotFound("No Category Found matching the provided Id : "+categoryId)) //Todo put the error message in properties
                ))
                .getId()
                .toString());
    }

    public SuccessResponse editCategory(Integer id, SubCategoryData categoryData) {
        return subCategoryRepository.findById(id)
                .map(subCategory -> {
                    subCategory.setName(categoryData.getName());
                    subCategory.setImage(categoryData.getImage());
                    subCategoryRepository.save(subCategory);
                    return  new SuccessResponse("SubCategory updated successfully");
                })
                .orElseThrow(()-> new RecordNotFound("No SubCategory Found matching the provided Id : "+id));
    }

    public SubCategoryData getCategory(String name) {
        return subCategoryRepository.findByName(name)
                .map(populator::populate)
                .orElseThrow(()-> new RecordNotFound("No SubCategory Found matching the provided name : "+name));
    }
}
