package CRUD.ControllerSubject;

import CRUD.ControllerSubject.Service.SubjectService;
import CRUD.ControllerSubject.Subject.Subject;
import CRUD.ControllerSubject.dto.InputSubjectDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("subject")
public class SubjectControler {

    private SubjectService subjectService;
    private SubjectRepository subjectRepository;

    @PostMapping("/addSubject")
    public String addSubject(@RequestBody InputSubjectDTO subject) throws Exception{
        subjectService.addSubject(subject);
        return "Asignatura creado correctamente";
    }
    @GetMapping("/subject/{id}")
    public Optional<Subject> getSubject(@PathVariable String id) throws Exception{
        return subjectRepository.findById(id);
    }


    @GetMapping("/getAllSubjects")
    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        subjectService.deletedById(id);
        return "El estudiante con id: "+id+" ha sido eliminado";

    }


}
