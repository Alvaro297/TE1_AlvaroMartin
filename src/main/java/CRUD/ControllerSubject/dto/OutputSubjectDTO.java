package CRUD.ControllerSubject.dto;

import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerSubject.Subject.Subject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class OutputSubjectDTO {

    private String id_subject;
    private List<Student> students;
    private String subject_name;
    private String coments;
    private Date initial_date;
    private Date finish_date;

    public OutputSubjectDTO(Subject subject){
        setId_subject(subject.getIdSubject());
        setStudents(subject.getStudents());
        setSubject_name(subject.getSubjectName());
        setComents(subject.getComentarios());
        setInitial_date(subject.getInitialDate());
        setFinish_date(subject.getFinishDate());
    }
}
