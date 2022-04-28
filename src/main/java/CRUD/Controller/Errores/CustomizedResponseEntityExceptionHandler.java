package CRUD.Controller.Errores;

import CRUD.Controller.Errores.ErrorBean.BeanNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//@ControllerAdvice
// @RestController
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BeanNotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(BeanNotFoundException ex, WebRequest request) {
        CustomError exceptionResponse = new CustomError(new Date(), ex.getMessage(),
                request.getDescription(false), HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }

}