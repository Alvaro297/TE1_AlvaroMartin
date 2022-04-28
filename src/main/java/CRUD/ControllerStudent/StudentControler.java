package CRUD.ControllerStudent;

import CRUD.ControllerStudent.Service.StudentService;
import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerStudent.dto.InputStudentDto;
import CRUD.ControllerStudent.dto.OutputStudentDtoAll;
import CRUD.ControllerSubject.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentControler {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody InputStudentDto student) throws Exception{

        System.out.println("En el controlador addStudent");

        return studentService.addPersona(student);

    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity getStudent(@PathVariable String id, @RequestParam(defaultValue = "simple") String outputType) throws Exception{

        if(outputType.equals("simple")){
            Optional<Student> studentsimple = studentRepository.findById(id);
            return ResponseEntity.ok(studentsimple);
        } else {
            if(outputType.equals("full")){
                OutputStudentDtoAll studentfull = studentService.findFById(id);
                return ResponseEntity.ok(studentfull);
            }
            return ResponseEntity.ok("No se ha encontrado");
        }
    }



    @GetMapping(value = "/getStudentAllStudent")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(value = "/getStudent/{id}")
    public Optional<Student> getStudentById(@PathVariable String id) throws Exception{
        return studentRepository.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProfesorById(@PathVariable String id) throws Exception{
        studentService.deletedById(id);
        return "El estudiante con id "+id+" ha sido eliminado de la base de datos";

    }

    @PutMapping(value = "/addSubjectStudent/{idStudent}")
    public ResponseEntity addAsignatura(@PathVariable String idStudent, @RequestBody List<String> ids) throws Exception{

        return studentService.addAsignaturas(idStudent, ids);

    }

    @PutMapping(value = "/removeSubjectsStudent/{idStudent}")
    public ResponseEntity removeAsignatura(@PathVariable String idStudent, @RequestBody List <String> ids) throws Exception{

        return studentService.removeAsignaturas(idStudent, ids);

    }

}