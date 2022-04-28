package CRUD.ControllerProfesor.dto;

import CRUD.ControllerProfesor.Profesor.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputProfesorDTO {
    private String idProfesor;
    private String personId;
    private String materia;

    public InputProfesorDTO (Profesor profesor){
        setIdProfesor(profesor.getIdProfesor());
        setPersonId(profesor.getPersona().getPersonId());
        setMateria(profesor.getMateria());
    }
}