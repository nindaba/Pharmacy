package pl.edu.vistula.data;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class ErrorResponse {
    @NonNull
    private HttpStatus status;
    @NonNull
    private String message;
    private Date timestamp = new Date();
}
