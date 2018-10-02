package in.co.test.audit.logging.bean;


import java.io.Serializable;
import java.util.List;

public class Audit implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String httpStatus;
	
	private String url;
	
	private String uri;
	
	private String httpMethod;
	
	private String clientIp;
	
	private String method;
	
	private String queryString;
	
	private List<RequestArgument> arguments;
	
	private String response;
	
	private ExceptionObject exception;
	
	private String hostName;
	
	private Integer serverPort; 
	
	public Integer getServerPort() {
		return serverPort;
	}

	public void setServerPort(Integer serverPort) {
		this.serverPort = serverPort;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<RequestArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<RequestArgument> arguments) {
		this.arguments = arguments;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ExceptionObject getException() {
		return exception;
	}

	public void setException(ExceptionObject exception) {
		this.exception = exception;
	}
	
	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	@Override
	public String toString() {
		return "Audit [httpStatus=" + httpStatus + ", url=" + url + ", uri=" + uri + ", httpMethod=" + httpMethod
				+ ", clientIp=" + clientIp + ", method=" + method + ", queryString=" + queryString + ", response="
				+ response + ", hostName=" + hostName + ", serverPort=" + serverPort + "]";
	}

	
	
}