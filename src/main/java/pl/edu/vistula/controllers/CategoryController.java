package pl.edu.vistula.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.data.CategoryData;
import pl.edu.vistula.data.SubCategoryData;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.services.CategoryService;
import pl.edu.vistula.services.SubCategoryService;

import java.util.List;

import static pl.edu.vistula.controllers.ControllerConstants.Category.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = Controller)
public class CategoryController implements PharmacyController<CategoryData>{
    private CategoryService categoryService;
    private SubCategoryService subCategoryService;



    @GetMapping
    @Override
    public ResponseEntity<List<CategoryData>> get(){
        return ResponseEntity.ok(categoryService.getCategories());
    }
    @GetMapping(value = "/{"+CategoryId+"}")


    @Override
    public ResponseEntity<CategoryData> get(
            @PathVariable(name= CategoryId,required = false) Integer categoryId)  {
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }


    @GetMapping(value = "/{"+CategoryId+"}"+SubCategory)
    public ResponseEntity<List<SubCategoryData>> getSubCategory(
            @PathVariable(name= CategoryId,required = false) Integer categoryId)  {
        return ResponseEntity.ok(categoryService.getSubCategories(categoryId));
    }



    /**
     * This will Iterate through all the Ids provided deleting every category associated with it;
     * @param categoryIds separated by comma ","
     * @return it will return a response of ok
     */
    @DeleteMapping({"", "/{"+CategoryId+"}"}) //TODO replace "" to "/"
    @Override
    public ResponseEntity<SuccessResponse> delete(
            @PathVariable(name= CategoryId,required = false) String categoryIds)  {
        return ResponseEntity.ok(
                categoryService.deleteCategories(categoryIds != null ? categoryIds : "")
        );
    }


    @PostMapping
    @Override
    public ResponseEntity add(@RequestBody CategoryData category){
        return ResponseEntity
                .created(categoryService.addCategory(category))
                .build();
    }


    @PutMapping("/{"+CategoryId+"}")
    @Override
    public ResponseEntity put(
            @PathVariable(name = CategoryId) Integer id,
            @RequestBody CategoryData categoryData){
        return ResponseEntity.ok(
                categoryService.editCategory(id,categoryData)
        );
    }
}

