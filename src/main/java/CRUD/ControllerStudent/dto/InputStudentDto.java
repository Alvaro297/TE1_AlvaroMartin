package CRUD.ControllerStudent.dto;

import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerSubject.Subject.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class InputStudentDto {

    private String materia;
    private String comentarios;
    private String id_student;
    private List<Subject> subjects;
    private String person;
    private String profesorId;
    private Integer num_hours_week;

    public InputStudentDto(Student student) {
        setId_student(student.getId_student());
        setMateria(student.getMateria());
        setComentarios(student.getComentarios());
        setPerson(student.getPersona().getPersonId());
        setProfesorId(student.getProfesor().getIdProfesor());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
    }

}