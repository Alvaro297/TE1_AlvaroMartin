package CRUD.Controller.servicios;

import CRUD.Controller.dto.PersonaInputDTO;
import CRUD.Controller.dto.PersonaOutputDTO;

public interface PersonaI {
    PersonaOutputDTO addPersona(PersonaInputDTO personaDTO) throws Exception;
    String deletedById(String id) throws Exception;
}
