package pl.edu.vistula.converters;

import pl.edu.vistula.data.MedicineDetails;
import pl.edu.vistula.models.Medicine;

public class MedicineConverter implements Converter<MedicineDetails, Medicine> {
    @Override
    public Medicine convert(MedicineDetails medicineDetails) {
        return new Medicine(medicineDetails);
    }
}
