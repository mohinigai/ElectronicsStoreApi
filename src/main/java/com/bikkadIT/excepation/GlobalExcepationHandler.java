package com.bikkadIT.excepation;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bikkadIT.payload.ApiResponse;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestControllerAdvice
public class GlobalExcepationHandler {

	private static Logger log = LoggerFactory.getLogger(GlobalExcepationHandler.class);
	
	@ExceptionHandler(ResourceNotFoundExcption.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundExcption ex) {
		
		log.info("Logger Exception handler!!");
		String message = ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
}
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodargsNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String field = ((FieldError)error).getField();
            String defaultMessage = error.getDefaultMessage();
            resp.put(field, defaultMessage);
        });
        return new ResponseEntity<Map<String, Object>>(resp,HttpStatus.BAD_REQUEST);
    }
}