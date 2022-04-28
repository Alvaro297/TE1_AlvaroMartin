package CRUD.ControllerStudent.Service;

import CRUD.ControllerStudent.dto.InputStudentDto;
import CRUD.ControllerStudent.dto.OutputStudentDtoAll;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface StudentI {
    ResponseEntity addPersona(InputStudentDto inputStudentDto) throws Exception;
    String deletedById(String id) throws Exception;

    ResponseEntity addAsignaturas(String idStudent, List<String> ids);

    ResponseEntity removeAsignaturas(String idStudent, List<String> ids);

    OutputStudentDtoAll findFById(String id) throws Exception;
}
