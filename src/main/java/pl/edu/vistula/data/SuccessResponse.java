package pl.edu.vistula.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class SuccessResponse {
    private HttpStatus status = HttpStatus.OK;
    @NonNull
    private String message;
    private Date timestamp = new Date();
}
