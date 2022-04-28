package CRUD.Controller.servicios;

import CRUD.Controller.Person.Persona;
import CRUD.Controller.PersonaRepository;
import CRUD.Controller.dto.PersonaInputDTO;
import CRUD.Controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements PersonaI{


    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception{
        if(personaDTO.getUser().length()>10){
            throw new Exception("El usuario no puede tener mas de 10 caracteres");
        } else {
            Persona persona = new Persona(personaDTO);
            personaRepository.save(persona);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(persona);
            return saveOutputDTO;

        }
    }

    @Override
    public String deletedById(String id) throws Exception{
        personaRepository.deleteById(id);
        return "El id "+id+" ha sido borrado";
    }

}
