package CRUD.ControllerSubject.Subject;

import CRUD.ControllerStudent.Student.Student;
import CRUD.ControllerSubject.dto.InputSubjectDTO;
import CRUD.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_su")
    @GenericGenerator(
            name = "seq_su",
            strategy = "CRUD.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SUBJECT"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%10d")
            }
    )
    private String id_subject;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "student_subject",
            joinColumns = {@JoinColumn(name = "id_subject")},
            inverseJoinColumns = {@JoinColumn(name = "id_student")}
    )
    @JsonIgnore
    private List<Student> students;

    private String subject_name;

    @Column(name= "coments")
    private String comentarios;

    private Date initial_date;

    private Date finish_date;


    public Subject(InputSubjectDTO inputSubjectDTO){
        setId_subject(inputSubjectDTO.getId_subject());
        setComentarios(inputSubjectDTO.getComents());
        setStudents(inputSubjectDTO.getStudents());
        setFinish_date(inputSubjectDTO.getFinish_date());
        setInitial_date(inputSubjectDTO.getInitial_date());
        setSubject_name(inputSubjectDTO.getSubject_name());
    }
}