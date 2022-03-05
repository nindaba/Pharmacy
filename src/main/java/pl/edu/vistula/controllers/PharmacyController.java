package pl.edu.vistula.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PharmacyController<T> {
    ResponseEntity<List<T>> get();
    ResponseEntity<T> get(Integer id);
    /**NULL ids will remove everything by default*/
    ResponseEntity delete(String ids);
    ResponseEntity add(T t);
    /**This will update your record but it will not change everything*/
    ResponseEntity put(Integer Id,T t);
}
