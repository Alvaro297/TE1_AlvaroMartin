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

    @PostMapping("/addProfesor")
    public ResponseEntity<?> addStudent(@RequestBody InputProfesorDTO profesor) throws Exception{


        return profesorService.addProfesor(profesor);

    }

    @GetMapping("/getProfesores")
    public List<Profesor> getProfesores(){
        return profesorRepository.findAll();
    }

    @GetMapping("/getProfesor/{id}")
    public Optional<Profesor> getProfesorById(@PathVariable String id) throws Exception{
        return profesorRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        profesorService.deletedById(id);
        return "El profesor con id "+id+" ha sido eliminada de la base de datos";
    }
}
