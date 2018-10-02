package in.co.test.excptionhandler;

import java.io.Serializable;

/**
 * DTO for sending a parameterized error message.
 */
public class ParameterizedErrorDTO implements Serializable {

	private static final long serialVersionUID = 3152357514870071389L;
	
	private int status;
    private final String message;
    private final String description;
    private final String[] params;
    
    public ParameterizedErrorDTO(String message, String... params) {
        this.message = message;
        this.params = params;
        this.description = "";
    }
    
    public ParameterizedErrorDTO(int status, String message, String... params) {
    	this.status = status;
        this.message = message;
        this.params = params;
        this.description = "";
    }
    
    public ParameterizedErrorDTO(int status, String message, String decsription, String... params) {
    	this.status = status;
        this.message = message;
        this.params = params;
        this.description = decsription;
    }
    
    public String getMessage() {
        return message;
    }
    public String[] getParams() {
        return params;
    }
    public int getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }

}
