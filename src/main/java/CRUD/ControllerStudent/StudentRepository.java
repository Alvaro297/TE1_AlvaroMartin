package CRUD.ControllerStudent;

import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerStudent.dto.OutputStudentDtoAll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository <Student,String>{
    @Query(value= "select * from Student where person_id = ?1", nativeQuery = true)
    Optional<Student> findByPersonId(String person);
}
