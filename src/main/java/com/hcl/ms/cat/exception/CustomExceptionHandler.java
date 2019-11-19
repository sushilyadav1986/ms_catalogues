package com.hcl.ms.cat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hcl.ms.cat.model.ObjectResponse;

/**Create Exception Handling Class
 * @author SushilY
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

	
	/** Handle Exception type throws
	 * @param ex    // get Exception in String from ex Obj
	 * @return ResponseEntity<Object>
	 * @throws Exception
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) throws Exception {
		ObjectResponse exceptionResponse = new ObjectResponse(false, ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/**
	 * Product not found Exception If Not get id
	 * @param ex
	 * @return ResponseEntity<Object>
	 * @throws Exception
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<Object> handleProductNotFoundExceptions(Exception ex)
			throws Exception {
		ObjectResponse exceptionResponse = new ObjectResponse(true, ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	/**
	 * User not found Exception If Not get id
	 * @param ex
	 * @return ResponseEntity<Object>
	 * @throws Exception
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(Exception ex)
			throws Exception {
		ObjectResponse exceptionResponse = new ObjectResponse(true, ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

}
