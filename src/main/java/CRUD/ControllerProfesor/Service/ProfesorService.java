package CRUD.ControllerProfesor.Service;

import CRUD.Controller.Person.Persona;
import CRUD.Controller.PersonaRepository;
import CRUD.ControllerProfesor.Profesor.Profesor;
import CRUD.ControllerProfesor.ProfesorRepository;
import CRUD.ControllerProfesor.dto.InputProfesorDTO;
import CRUD.ControllerStudent.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ProfesorService implements  ProfesorI{

    private PersonaRepository personaRepository;
    private ProfesorRepository profesorRepository;
    private StudentRepository studentRepository;

    @Override
    public ResponseEntity<?> addProfesor(InputProfesorDTO profesorDto) throws Exception {

        Optional<Persona> person = personaRepository.findById(profesorDto.getPersonId());


        if (person.isPresent()) {
            Profesor profesor = new Profesor(profesorDto);
            profesor.setPersona(person.get());

            if (profesorRepository.findByPersonId(person.get().getPersonId()).isEmpty() && studentRepository.findByPersonId(person.get().getPersonId()).isEmpty()) {
                profesorRepository.save(profesor);
                return new ResponseEntity<>("Profesor guardado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error al insertar profesor, la persona ya esta asociada a un profesor", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public String deletedById(String id) throws Exception {
        profesorRepository.findById(id).orElseThrow(() -> new Exception("NO se ha encontrado al profesor cuyo id es: " + id));
        profesorRepository.deleteById(id);
        return "El profesor con el id: " + id + " ha sido borrado";
    }


}
