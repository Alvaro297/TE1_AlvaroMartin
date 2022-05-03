package CRUD.ControllerSubject.dto;

import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerSubject.Subject.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class InputSubjectDTO {
    private String idSubject;
    private List<Student> students;
    private String subjectName;
    private String coments;
    private Date initialDate;
    private Date finishDate;

    public InputSubjectDTO(Subject subject){
        setIdSubject(subject.getIdSubject());
        setStudents(subject.getStudents());
        setSubjectName(subject.getSubjectName());
        setComents(subject.getComentarios());
        setInitialDate(subject.getInitialDate());
        setFinishDate(subject.getFinishDate());
    }
}
