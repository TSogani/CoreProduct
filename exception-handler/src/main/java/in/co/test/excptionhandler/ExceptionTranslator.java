package in.co.test.excptionhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice to translate the server side exceptions to client-friendly
 * json structures.
 */
@ControllerAdvice
public class ExceptionTranslator {
	
	@ExceptionHandler(ConcurrencyFailureException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorDTO processConcurencyError(ConcurrencyFailureException ex) {
		return new ErrorDTO(ErrorConstants.ERR_CONCURRENCY_FAILURE_STATUS, ErrorConstants.ERR_CONCURRENCY_FAILURE);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldErrorDTO> fieldErrors = processFieldErrors(result.getFieldErrors());
		
		ErrorDTO errorDto = new ErrorDTO(ErrorConstants.ERR_VALIDATION_STATUS, 
				ErrorConstants.ERR_VALIDATION, "Method Arguments Not Valid", fieldErrors);
		return errorDto;
	}

	@ExceptionHandler(CustomParameterizedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ParameterizedErrorDTO processParameterizedValidationError(
			CustomParameterizedException ex) {
		return ex.getErrorDTO();
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ResponseBody
	public ErrorDTO processAccessDeniedExcpetion(AccessDeniedException e) {
		return new ErrorDTO(ErrorConstants.ERR_ACCESS_DENIED_STATUS, ErrorConstants.ERR_ACCESS_DENIED, e.getMessage());
	}

	private List<FieldErrorDTO> processFieldErrors(List<FieldError> fieldErrors) {
		List<FieldErrorDTO> fieldErrorDtoList = new ArrayList<FieldErrorDTO>();
		
		for (FieldError fieldError : fieldErrors) {
			FieldErrorDTO fieldErrorDto = new FieldErrorDTO(
					fieldError.getObjectName(), 
					fieldError.getField(),
					fieldError.getDefaultMessage());
			fieldErrorDtoList.add(fieldErrorDto);
		}
		return fieldErrorDtoList;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ErrorDTO processMethodNotSupportedException(
			HttpRequestMethodNotSupportedException exception) {
		return new ErrorDTO(ErrorConstants.ERR_METHOD_NOT_SUPPORTED_STATUS, ErrorConstants.ERR_METHOD_NOT_SUPPORTED,
				exception.getMessage());
	}
}
