package CRUD.ControllerStudent.dto;

import CRUD.Controller.Person.Persona;
import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerSubject.Subject.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class OutputStudentDtoAll {
    private String materia;
    private String comentarios;
    private String id_student;
    private List<Subject> subjects;
    private String person;
    private String profesorId;
    private Integer num_hours_week;
    private Persona persona;


    public OutputStudentDtoAll(Student student){
        setId_student(student.getId_student());
        setMateria(student.getMateria());
        setComentarios(student.getComentarios());
        setNum_hours_week(student.getNum_hours_week());
        setSubjects(student.getSubjects());
        setPersona(student.getPersona());
    }
}