package CRUD.Controller;

import CRUD.Controller.Errores.ErrorBean.BeanNotFoundException;
import CRUD.Controller.Person.Persona;
import CRUD.Controller.dto.PersonaInputDTO;
import CRUD.Controller.dto.PersonaOutputDTO;
import CRUD.Controller.servicios.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaControler {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaRepository personaRepository;

    @PostMapping("/addPersona")
    public String addPersona(@RequestBody PersonaInputDTO persona) throws Exception{
        try{
        personaService.addPersona(persona);
        }catch (Exception e){
            throw new BeanNotFoundException(e.getMessage());
        }
        return "Persona creada correctamente";
    }

    @GetMapping("/getPerson/{id}")
    public Persona getPersonById(@PathVariable String id) throws Exception {
        try{
            return personaRepository.findById(id).orElseThrow(()->new Exception("No encontrado"));
        }catch (Exception e){
            throw new BeanNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/getPersona")
    public List<Persona> getPersona(){
        try{
            return personaRepository.findAll();
        }catch (Exception e){
             throw new BeanNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/getPerson/name/{name}")
    public List<PersonaOutputDTO> deletePersonaByName(@PathVariable String name) {
        try{
            return personaRepository.findByName(name);
         }catch (Exception e){
             throw new BeanNotFoundException(e.getMessage());
         }
    }

    @DeleteMapping("/delete/{id}")
    public String deletePersonaById(@PathVariable String id) throws Exception {
        try{
        personaService.deletedById(id);
        }catch (Exception e){
            throw new BeanNotFoundException(e.getMessage());
        }
        return "El id "+id+" ha sido borrado";

    }



}
