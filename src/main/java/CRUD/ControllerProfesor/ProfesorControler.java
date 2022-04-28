package CRUD.ControllerProfesor;

import CRUD.ControllerProfesor.Profesor.Profesor;
import CRUD.ControllerProfesor.Service.ProfesorService;
import CRUD.ControllerProfesor.dto.InputProfesorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("profesor")
public class ProfesorControler {

    private ProfesorService profesorService;
    private ProfesorRepository profesorRepository;

    //Request para añadir una persona a la base de datos
    @PostMapping(value = "/addProfesor")
    public ResponseEntity<?> addStudent(@RequestBody InputProfesorDTO profesor) throws Exception{

        System.out.println("En el controlador addProfesor");

        return profesorService.addProfesor(profesor);

    }

    //Request para obtener los registros de la tabla
    @GetMapping(value = "/getProfesores")
    public List<Profesor> getProfesores(){
        System.out.println("En el controlador getProfesores");
        return profesorRepository.findAll();
    }

    //Request para obtener el profesor cuyo id se para por parámetro
    @GetMapping(value = "/getProfesor/{id}")
    public Optional<Profesor> getProfesorById(@PathVariable String id) throws Exception{
        return profesorRepository.findById(id);
    }

    //Request para eliminar la persona cuyo id se para por parámetro
    @DeleteMapping(value = "/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        profesorService.deletedById(id);
        return "El profesor con id "+id+" ha sido eliminada de la base de datos";
    }
}
