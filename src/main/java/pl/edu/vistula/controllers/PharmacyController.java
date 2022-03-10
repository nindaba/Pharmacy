package pl.edu.vistula.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
public interface PharmacyController<T> {
    ResponseEntity<List<T>> get();
    ResponseEntity<T> get(Integer id);
    /**NULL ids will remove everything by default*/
    ResponseEntity delete(String ids);
    ResponseEntity add(T t);
    /**This will update your record but it will not change everything*/
    ResponseEntity put(Integer Id,T t);
}
