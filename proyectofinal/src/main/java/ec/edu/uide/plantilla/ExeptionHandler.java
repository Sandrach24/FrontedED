/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uide.plantilla;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author dante
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExeptionHandler {

    private final static String INCORRECT_INFORMATION = "Información incorrecta";
    private final static String PARAMETER_VIOLATION = "Violación de parámetros";
    private final static String PARAMETER_NOT_FOUND = "Parámetro no encontrado";
    private final static String ID_NOT_FOUND = "ID no encontrado";

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        logger.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(JsonMappingException.class)
    protected ResponseEntity<Object> handlingSearchParameters(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage().contains("id not found")
                ? ID_NOT_FOUND : PARAMETER_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    protected ResponseEntity<Object> handlingSearchParametersExtra(Exception ex, WebRequest request) {
        return new ResponseEntity<>(PARAMETER_VIOLATION, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handlingSearchParametersNotFound(Exception ex, WebRequest request) {
        return new ResponseEntity<>(PARAMETER_VIOLATION, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handlingSearchParametersMandatory(Exception ex, WebRequest request) {
//        System.out.println("error:" + ex.getMessage());
        String[] error = ex.getMessage().split("\\[");
        return new ResponseEntity<>(INCORRECT_INFORMATION + ": " + error[error.length - 1].replaceAll("\\]", ""), HttpStatus.BAD_REQUEST);
    }
}
