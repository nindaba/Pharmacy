package pl.edu.vistula.Exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.edu.vistula.data.ErrorResponse;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class PharmacyExceptionHandler{
    /**
     * This exception will be thrown when unique rules for columns in models is not satisfied
     */
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> constraintViolation(SQLIntegrityConstraintViolationException exception){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                        HttpStatus.CONFLICT,
                        exception.getMessage()
                ));
    }

    @ExceptionHandler(value = RecordNotFound.class)
    public ResponseEntity<ErrorResponse> notfound(RecordNotFound exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND,exception.getMessage()));
    }
    /**
     * This exception will be thrown when it fails to find an entity
     */
    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> constraintViolation(EmptyResultDataAccessException exception){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(
                            HttpStatus.CONFLICT,
                            exception.getMessage()
                                    .replace("pl.edu.vistula.models","")
                ));
    }
}
