package pl.edu.vistula.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.data.CategoryData;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.services.CategoryService;

import java.util.List;

import static pl.edu.vistula.controllers.ControllerConstants.Category.CategoryId;
import static pl.edu.vistula.controllers.ControllerConstants.Category.Controller;

@RestController
@RequestMapping(value = Controller)
@AllArgsConstructor
public class CategoryController implements PharmacyController<CategoryData>{
    private CategoryService categoryService;
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
