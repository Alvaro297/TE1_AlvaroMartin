import CRUD.Controller.Person.Persona;
import CRUD.Controller.PersonaControler;
import CRUD.Controller.PersonaRepository;
import CRUD.Controller.dto.PersonaInputDTO;
import CRUD.Controller.dto.PersonaOutputDTO;
import CRUD.Controller.servicios.PersonaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TestPerson {

    @Mock
    PersonaService personaService;

    @InjectMocks
    PersonaControler personaControler;

    @Mock
    PersonaRepository personaRepository;

    PersonaInputDTO personaInputDTO =
            new PersonaInputDTO("1", "dsa", "dsa", "dsa", "dsa", "asd@gmail.com", "asd@gmail.com", "Madrid", true, new Date(), "a", new Date());
    PersonaOutputDTO personaOutputDTO =
            new PersonaOutputDTO("1", "dsa", "dsa", "dsa", "asd@gmail.com", "asd@gmail.com", "Madrid", true, new Date(), "a", new Date());
    List<PersonaOutputDTO> personaOutputDTOList;
    @Before
    void before() {
        personaOutputDTOList = new ArrayList<>();
        personaOutputDTOList.add(personaOutputDTO);
    }
    @Test
    void findByIdTest() throws Exception {
        when(personaRepository.findById("1")).thenReturn(personaOutputDTO);
        Assert.assertEquals(personaOutputDTO, personaControler.getPersonById("1"));
        System.out.println(personaOutputDTO);
    }



    @Test
    void findAllTest() throws Exception {
        when(personaRepository.findAll()).thenReturn(personaOutputDTOList);
        Assert.assertEquals(personaOutputDTOList, personaControler.getPersona());
        System.out.println(personaOutputDTOList);
    }


    @Test
    void addPersonTest() throws Exception {
        when(personaService.addPersona(personaInputDTO))
                .thenReturn(new PersonaOutputDTO(new Persona(personaInputDTO)));
        Assert.assertEquals(personaOutputDTO, personaControler.addPersona(personaInputDTO));
        System.out.println(personaOutputDTO);
    }
    @Test
    void deletePersonTest() throws Exception {
        when(personaService.deletedById("1"));
        Assert.assertEquals(new Persona(personaInputDTO), personaControler.deletePersonaById("1"));
    }

}
