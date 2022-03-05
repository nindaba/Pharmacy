package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.models.SubCategory;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
    @Query("SELECT s FROM SubCategory s WHERE s.name = ?1")
    Optional<SubCategory> findByName(String name);
}
