package pl.edu.vistula.populators;

import pl.edu.vistula.data.MedicineDetails;
import pl.edu.vistula.models.Medicine;

public class MedicineDetailsPopulator implements Populator<Medicine, MedicineDetails >{
    @Override
    public MedicineDetails populate(Medicine medicine) {
        return new MedicineDetails(
                medicine.getId(),
                medicine.getName(),
                medicine.getDescription(),
                medicine.getSize(),
                medicine.getCount(),
                medicine.getWeight(),
                medicine.getImage(),
                medicine.getPrice(),
                medicine.getBarcode(),
                medicine.getCreated(),
                medicine.getExpires(),
                medicine.getSubCategory().getName(),
                medicine.getManufacturer().getName()
        );
    }
}
