package pl.edu.vistula.services;

import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import lombok.AllArgsConstructor;
import pl.edu.vistula.Exception.RecordNotFound;
import pl.edu.vistula.converters.Converter;
import pl.edu.vistula.converters.MedicineConverter;
import pl.edu.vistula.dao.ManufacturerRepository;
import pl.edu.vistula.dao.MedicineRepository;
import pl.edu.vistula.dao.SubCategoryRepository;
import pl.edu.vistula.data.MedicineData;
import pl.edu.vistula.data.MedicineDetails;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.models.Manufacturer;
import pl.edu.vistula.models.Medicine;
import pl.edu.vistula.models.SubCategory;
import pl.edu.vistula.populators.Populator;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class MedicineService {
    private MedicineRepository medicineRepository;
    private SubCategoryRepository subCategoryRepository;
    private Converter<MedicineData,Medicine> converter;
    private Populator<Medicine,MedicineDetails> populator;
    private ManufacturerRepository manufacturerRepository;

    public URI addMedicine(MedicineDetails medicineDetails) {
        //Find the manufacturer, if not found I would like to throw an error
        var manufacturer = manufacturerRepository.findByName(medicineDetails.getManufacturer())
                .orElseThrow(() -> new RecordNotFound("No manufacturer Found named "+ medicineDetails.getManufacturer()));


        //Find SubCategory
        var subCategory = subCategoryRepository.findByName(medicineDetails.getSubCategory())
                .orElseThrow(() -> new RecordNotFound("No SubCategory Found matching the provided name : " + medicineDetails.getSubCategory()));

        //Create a model from the data we obtained from the db and client
        var medicine = new Medicine(medicineDetails);
        medicine.setSubCategory(subCategory);
        medicine.setManufacturer(manufacturer);

        //save the category and return the location of the medicine
        return URI.create(medicineRepository.save(medicine).getId().toString());
    }

    public SuccessResponse editMedicine(Integer id, Medicine medicine) {
        return medicineRepository.findById(id)
                .map(m -> {
                    medicine.setSubCategory(m.getSubCategory());
                    medicine.setManufacturer(m.getManufacturer());
                    medicine.setId(m.getId());
                    medicineRepository.save(medicine);
                    return new SuccessResponse("Medicine updated successfully");
                })
                .orElseThrow(()-> new RecordNotFound("No medicine matches the id provided"));
    }
    public List<MedicineDetails> getALlMedicine(){
        return medicineRepository.findAll()
                .stream()
                .map(populator::populate)
                .collect(Collectors.toList());
    }

    public SuccessResponse delete(String ids){
        if(ids==null) {
            medicineRepository.deleteAll();
            return new SuccessResponse("All Medicine deleted successfully");
        }
        medicineRepository.deleteAllById(Stream.of(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet())
        );
        return  new SuccessResponse("Medicament deleted successfully");
    }

    public MedicineDetails getMedicine(Integer id) {
        return medicineRepository.findById(id)
                .map(populator::populate)
                .orElseThrow(()-> new RecordNotFound("No medicine found matching the provided id : "+id));
    }

    public List<MedicineDetails> getExpiredMedicine() {
        return medicineRepository.findByExpiredDate()
                .stream().map(populator::populate)
                .collect(Collectors.toList());
    }
}
