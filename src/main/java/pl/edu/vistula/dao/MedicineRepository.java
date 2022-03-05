package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.models.Medicine;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
    @Query(value = "SELECT m FROM Medicine m WHERE m.expires < current_date")
    List<Medicine> findByExpiredDate();
}
