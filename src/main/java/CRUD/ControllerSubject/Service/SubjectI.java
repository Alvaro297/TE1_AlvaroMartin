package CRUD.ControllerSubject.Service;

import CRUD.ControllerSubject.dto.InputSubjectDTO;
import CRUD.ControllerSubject.dto.OutputSubjectDTO;

public interface SubjectI {
    OutputSubjectDTO addSubject(InputSubjectDTO subjectDto) throws Exception;

    String deletedById(String id) throws Exception;
}
