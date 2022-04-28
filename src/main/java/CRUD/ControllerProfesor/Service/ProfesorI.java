package CRUD.ControllerProfesor.Service;

import CRUD.ControllerProfesor.dto.InputProfesorDTO;
import org.springframework.http.ResponseEntity;

public interface ProfesorI {
    ResponseEntity<?> addProfesor(InputProfesorDTO profesorDto) throws Exception;

    String deletedById(String id) throws Exception;
}
