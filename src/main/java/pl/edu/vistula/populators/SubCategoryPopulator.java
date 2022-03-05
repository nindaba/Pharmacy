package pl.edu.vistula.populators;

import pl.edu.vistula.data.SubCategoryData;
import pl.edu.vistula.models.SubCategory;

import java.util.stream.Collectors;

public class SubCategoryPopulator implements Populator<SubCategory, SubCategoryData> {
    @Override
    public SubCategoryData populate(SubCategory subCategory) {
        var medicinePopulator = new MedicinePopulator();
        return new SubCategoryData(
                subCategory.getId(),
                subCategory.getName(),
                subCategory.getMedicines()
                        .stream()
                        .map(medicinePopulator::populate)
                        .collect(Collectors.toList()),
                subCategory.getImage()
        );
    }
}
