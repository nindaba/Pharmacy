package pl.edu.vistula.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.data.SubCategoryData;
import pl.edu.vistula.services.SubCategoryService;

import java.util.List;

import static pl.edu.vistula.controllers.ControllerConstants.Category.CategoryId;
import static pl.edu.vistula.controllers.ControllerConstants.SubCategory.SubCategoryId;
import static pl.edu.vistula.controllers.ControllerConstants.SubCategory.Controller;

@RestController
@RequestMapping(value = Controller)
@AllArgsConstructor
public class SubCategoryController implements PharmacyController<SubCategoryData>{
    private SubCategoryService subCategoryService;
    @GetMapping
    @Override
    public ResponseEntity<List<SubCategoryData>> get(){
        return ResponseEntity.ok(subCategoryService.getSubCategories());
    }
    @GetMapping(value = "/{"+ SubCategoryId +"}")
    @Override
    public ResponseEntity<SubCategoryData> get(
            @PathVariable(name= SubCategoryId,required = false) Integer categoryId)  {
        return ResponseEntity.ok(subCategoryService.getCategory(categoryId));
    }
//    @GetMapping
//    public ResponseEntity<SubCategoryData> get(
//            @RequestParam String name)  {
//        return ResponseEntity.ok(subCategoryService.getCategory(name));
//    }

    /**
     * This will Iterate through all the Ids provided deleting every category associated with it;
     * @param categoryIds separated by comma ","
     * @return it will return a response of ok
     */
    @DeleteMapping({"/", "/{"+ SubCategoryId +"}"})
    @Override
    public ResponseEntity delete(
            @PathVariable(name= SubCategoryId,required = false) String categoryIds)  {
        return ResponseEntity.ok(
                subCategoryService.deleteCategories(categoryIds != null ? categoryIds : "")
        );
    }

    @PostMapping("/{"+ CategoryId +"}")
    public ResponseEntity add(@PathVariable(name = CategoryId) Integer categoryId, @RequestBody SubCategoryData category){
        return ResponseEntity
                .created(subCategoryService.addCategory(categoryId,category))
                .build();
    }

    @PutMapping("/{"+ SubCategoryId +"}")
    @Override
    public ResponseEntity put(
            @PathVariable(name = SubCategoryId) Integer id,
            @RequestBody SubCategoryData categoryData){
        return ResponseEntity.ok(
                subCategoryService.editCategory(id,categoryData)
        );
    }

    @Deprecated
    @Override
    public ResponseEntity add(SubCategoryData subCategoryData) {
        return null;
    }
}
