package pl.edu.vistula.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.models.Category;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
