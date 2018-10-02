package in.co.test.audit.logging.bean;

import java.io.Serializable;

public class ExceptionObject implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String exception;

	private String message;

	private String exceptionId;

	private String stacktrace;

	public String getException() {
		return exception;
	}
	
	public void setException(String exception) {
		this.exception = exception;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getExceptionId() {
		return exceptionId;
	}
	
	public void setExceptionId(String exceptionId) {
		this.exceptionId = exceptionId;
	}
	
	public String getStacktrace() {
		return stacktrace;
	}
	
	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

	@Override
	public String toString() {
		return "ExceptionObject [exception=" + exception + ", message=" + message + ", exceptionId=" + exceptionId
				+ ", stacktrace=" + stacktrace + "]";
	}

}