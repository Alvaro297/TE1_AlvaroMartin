package CRUD.Controller.feign;

import CRUD.ControllerProfesor.dto.OutputProfesorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "personClient", url = "http://localhost:8081/")
public interface IFeign {

    @GetMapping("person/profesor/{id}")
    ResponseEntity<OutputProfesorDTO> getProfesor(@PathVariable String id);
}