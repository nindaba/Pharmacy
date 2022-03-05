package pl.edu.vistula.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.data.MedicineDetails;
import pl.edu.vistula.data.SuccessResponse;
import pl.edu.vistula.models.Medicine;
import pl.edu.vistula.services.MedicineService;

import java.util.List;

import static pl.edu.vistula.controllers.ControllerConstants.Medicine.*;

@RestController
@AllArgsConstructor
@RequestMapping(Controller)
public class MedicineController implements PharmacyController<MedicineDetails>{
    private MedicineService medicineService;
    @GetMapping
    @Override
    public ResponseEntity<List<MedicineDetails>> get() {
        return ResponseEntity.ok(medicineService.getALlMedicine());
    }
    @GetMapping("/{"+MedicineId+"}")
    @Override
    public ResponseEntity<MedicineDetails> get(@PathVariable(MedicineId) Integer id) {
        return ResponseEntity.ok(medicineService.getMedicine(id));
    }
    @GetMapping(Expired)
    public ResponseEntity<List<MedicineDetails>> getExpired() {
        return ResponseEntity.ok(medicineService.getExpiredMedicine());
    }
    @DeleteMapping({"","/{"+MedicineId+"}"})
    @Override
    public ResponseEntity delete(@PathVariable(name = MedicineId,required = false) String ids) {
        return ResponseEntity.ok(medicineService.delete(ids));
    }
    @PostMapping
    @Override
    public ResponseEntity<SuccessResponse> add(@RequestBody MedicineDetails medicineDetails) {
        return ResponseEntity.created(
                medicineService.addMedicine(medicineDetails)
        ).build();
    }
    @PutMapping("/{"+MedicineId+"}")
    @Override
    public ResponseEntity<SuccessResponse> put(@PathVariable(MedicineId) Integer id,@RequestBody MedicineDetails medicineDetails) {
        return ResponseEntity.ok(medicineService.editMedicine(id,new Medicine(medicineDetails)));
    }
}
