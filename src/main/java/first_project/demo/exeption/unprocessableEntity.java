package first_project.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class unprocessableEntity extends RuntimeException {
    public unprocessableEntity(String message) {

    }
}
