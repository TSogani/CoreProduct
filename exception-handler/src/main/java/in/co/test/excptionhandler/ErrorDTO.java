package in.co.test.excptionhandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
 
/**
* DTO for transfering error message with a list of field errors.
*/
public class ErrorDTO implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    private int status;
    private final String message;
    private final String description;
    private List<FieldErrorDTO> fieldErrors;
    
    ErrorDTO(int status) {
        this(status, "");
    }
    
    ErrorDTO(int status, String message) {
        this(status, message, null);
    }
 
    ErrorDTO(String message) {
        this(ErrorConstants.ERR_STATUS, message, null);
    }
 
    ErrorDTO(int status, String message, String description) {
    	this.status = status;
        this.message = message;
        this.description = description;
    }
 
    ErrorDTO(int status, String message, String description, List<FieldErrorDTO> fieldErrors) {
    	this.status = status;
        this.message = message;
        this.description = description;
        this.fieldErrors = fieldErrors;
    }
 
    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<FieldErrorDTO>();
        }
        fieldErrors.add(new FieldErrorDTO(objectName, field, message));
    }
    
    public int getStatus() {
        return status;
    }
 
    public String getMessage() {
        return message;
    }
 
    public String getDescription() {
        return description;
    }
 
    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}
