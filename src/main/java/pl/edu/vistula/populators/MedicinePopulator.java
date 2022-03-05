package pl.edu.vistula.populators;

import pl.edu.vistula.data.MedicineData;
import pl.edu.vistula.models.Medicine;

public class MedicinePopulator implements Populator<Medicine, MedicineData> {
    @Override
    public MedicineData populate(Medicine medicine) {
        return new MedicineData(
                medicine.getId(),
                medicine.getName(),
                medicine.getDescription(),
                medicine.getImage(),
                medicine.getCount(),
                medicine.getPrice(),
                medicine.getManufacturer().getName()
        );
    }
}
