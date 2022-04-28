package CRUD.ControllerStudent.Service;

import CRUD.Controller.Person.Persona;
import CRUD.Controller.PersonaRepository;
import CRUD.ControllerProfesor.Profesor.Profesor;
import CRUD.ControllerProfesor.ProfesorRepository;
import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerStudent.StudentRepository;
import CRUD.ControllerStudent.dto.InputStudentDto;
import CRUD.ControllerStudent.dto.OutputStudentDtoAll;
import CRUD.ControllerSubject.Subject.Subject;
import CRUD.ControllerSubject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentI {
    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public ResponseEntity addPersona(InputStudentDto inputStudentDto) throws Exception {
        Optional<Persona> person = personaRepository.findById(inputStudentDto.getPerson());
        Optional<Profesor> profesor = profesorRepository.findById(inputStudentDto.getProfesorId());


        if (person.isPresent()) {
            Student student = new Student(inputStudentDto);
            student.setPersona(person.get());

            if (profesor.isPresent()) {
                student.setProfesor(profesor.get());
            } else {
                return new ResponseEntity<>("Profesor no existente", HttpStatus.NOT_FOUND);
            }

            if (studentRepository.findByPersonId(person.get().getPersonId()).isEmpty() && profesorRepository.findByPersonId(person.get().getPersonId()).isEmpty()) {
                studentRepository.save(student);
                return new ResponseEntity<>("Estudiante guardado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error al insertar estudiante, la persona ya esta asociada a un estudiante o a un profesor", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Persona no existente", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public String deletedById(String id) throws Exception {
        studentRepository.deleteById(id);
        return "El id "+id+" ha sido borrado";
    }

    @Override
    public ResponseEntity addAsignaturas(String idStudent, List<String> ids) {

        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) return ResponseEntity.ok("No existe estudiante con ese id");
        List<Subject> subjectsFromStudent = student.get().getSubjects();

        for (String id : ids) {
            Optional<Subject> subject = subjectRepository.findById(id);
            if (subject.isPresent()) {
                subjectsFromStudent.add(subject.get());
                List<Student> studentsFromSubject = subject.get().getStudents();
                studentsFromSubject.add(student.get());

                student.get().setSubjects(subjectsFromStudent);
                subject.get().setStudents(studentsFromSubject);
            }
        }

        studentRepository.save(student.get());
        return ResponseEntity.ok("Asignatura asignada");
    }

    @Override
    public ResponseEntity removeAsignaturas(String idStudent, List<String> ids) {

        Optional<Student> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) return ResponseEntity.ok("No existe estudiante con ese id");

        List<Subject> subjectsFromStudent = student.get().getSubjects();
        List<Subject> subjectsFromStudentToMap = new ArrayList<>(subjectsFromStudent);

        //realizo dos bucles para comprobar si algun id de asignatura coincide con los ids pasados
        for (Subject subject : subjectsFromStudentToMap) {
            for (String id : ids) {
                if (subject.getId_subject().equals(id)) {
                    Subject subjectToDelete = subjectRepository.findById(id).get();
                    subjectsFromStudent.remove(subjectToDelete);
                    subject.getStudents().remove(student.get());
                }
            }
        }
        student.get().setSubjects(subjectsFromStudent);

        studentRepository.save(student.get());
        return ResponseEntity.ok("Asignatura borrada");
    }

    @Override
    public OutputStudentDtoAll findFById(String id) throws Exception {
        Student student=studentRepository.findById(id).orElseThrow(()->new Exception("No se ha encontrado al alumno"));
        return new OutputStudentDtoAll(student);
    }
}
