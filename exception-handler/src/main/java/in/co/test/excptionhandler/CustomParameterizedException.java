package in.co.test.excptionhandler;

/**
 * Custom, parameterized exception, which can be translated on the client side.
 * For example:
 * 
 * <pre>
 * throw new CustomParameterizedException(&quot;myCustomError&quot;, &quot;hello&quot;, &quot;world&quot;);
 * </pre>
 * 
 * Can be translated with:
 * 
 * <pre>
 * "error.myCustomError" :  "The server says {{params[0]}} to {{params[1]}}"
 * </pre>
 */
public class CustomParameterizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private final int status;
    private final String message;
    private final String description;
    private final String[] params;
    
    public CustomParameterizedException(String message, String... params) {
        super(message);
        this.status = ErrorConstants.ERR_STATUS;
        this.message = message;
        this.params = params;
        this.description = "";
    }
    
    public CustomParameterizedException(int status, String message, String... params) {
        super(message);
        this.status = status;
        this.message = message;
        this.params = params;
        this.description = "";
    }

    public CustomParameterizedException(int status, String message, String description, String... params) {
        super(message);
        this.status = status;
        this.message = message;
        this.params = params;
        this.description = description;
    }

    public ParameterizedErrorDTO getErrorDTO() {
        return new ParameterizedErrorDTO(status, message, description, params);
    }

}
