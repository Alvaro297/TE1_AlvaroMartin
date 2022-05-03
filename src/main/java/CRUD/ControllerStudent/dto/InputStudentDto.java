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
    private String idStudent;
    private List<Subject> subjects;
    private String person;
    private String profesorId;
    private Integer numHoursWeek;

    public InputStudentDto(Student student) {
        setIdStudent(student.getIdStudent());
        setMateria(student.getMateria());
        setComentarios(student.getComentarios());
        setPerson(student.getPersona().getPersonId());
        setProfesorId(student.getProfesor().getIdProfesor());
        setNumHoursWeek(student.getNumHoursWeek());
        setSubjects(student.getSubjects());
    }

}