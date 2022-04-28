package CRUD.ControllerProfesor.dto;

import CRUD.Controller.Person.Persona;
import CRUD.ControllerProfesor.Profesor.Profesor;
import CRUD.ControllerStudent.Student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OutputProfesorDTO {

    private String idProfesor;
    private Persona persona;
    private List<Student> students;
    private String materia;

    public OutputProfesorDTO(Profesor profesor) {
        setIdProfesor(profesor.getIdProfesor());
        setPersona(profesor.getPersona());
        setStudents(profesor.getStudents());
        setMateria(profesor.getMateria());
    }
}