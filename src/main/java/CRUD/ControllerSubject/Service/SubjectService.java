package CRUD.ControllerSubject.Service;

import CRUD.ControllerStudent.StudentRepository;
import CRUD.ControllerSubject.Subject.Subject;
import CRUD.ControllerSubject.SubjectRepository;
import CRUD.ControllerSubject.dto.InputSubjectDTO;
import CRUD.ControllerSubject.dto.OutputSubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectService implements SubjectI{
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public OutputSubjectDTO addSubject(InputSubjectDTO subjectDto) throws Exception {

        if (subjectDto.getSubjectName().isBlank()) {
            throw new Exception("Debe tener un nombre la asignatura");
        } else {
            Subject subject = new Subject(subjectDto);
            subjectRepository.save(subject);

            OutputSubjectDTO outputDTO = new OutputSubjectDTO(subject);
            return outputDTO;

        }
    }
    @Override
    public String deletedById(String id) throws Exception {
        subjectRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado la asignatura cuyo id es: " + id));
        subjectRepository.deleteById(id);
        return "La asignatura ha sido borrada id: " + id;
    }


}
