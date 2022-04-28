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
    private String id_subject;
    private List<Student> students;
    private String subject_name;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public InputSubjectDTO(Subject subject){
        setId_subject(subject.getId_subject());
        setStudents(subject.getStudents());
        setSubject_name(subject.getSubject_name());
        setComents(subject.getComentarios());
        setInitial_date(subject.getInitial_date());
        setFinish_date(subject.getFinish_date());
    }
}
