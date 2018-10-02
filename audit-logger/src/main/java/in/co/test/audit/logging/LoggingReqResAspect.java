package in.co.test.audit.logging;

import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import in.co.test.audit.logging.bean.Audit;

@Aspect
@Component
public class LoggingReqResAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("rawtypes")
	@AfterReturning(pointcut = "execution(@AuditLogging * *.*(..)) && @annotation(auditLogging)", returning = "result")
	public void auditReqAndRes(JoinPoint joinPoint, Object result, AuditLogging auditLogging) throws UnknownHostException {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();
		
		InetAddress address = InetAddress.getLocalHost();
		
		Audit audit = new Audit();
		audit.setUrl(request.getRequestURL().toString());
		audit.setUri(request.getRequestURI());
		audit.setHttpMethod(request.getMethod());
		audit.setClientIp(request.getRemoteAddr());
		audit.setMethod(request.getContentType());
		audit.setServerPort(request.getServerPort());
		audit.setQueryString(request.getQueryString());
		audit.setArguments(null);
		audit.setHostName(address.getHostName());

		
	    if (result instanceof ResponseEntity) {
	    	ResponseEntity responseObj = (ResponseEntity) result;
	        
	        audit.setHttpStatus(""+responseObj.getStatusCodeValue());
	        audit.setResponse(responseObj.getBody().toString());
	    }
	    
	    audit.setException(null);
	    
	    Gson gson = new Gson();
        Type type = new TypeToken<Audit>() {}.getType();
        String json = gson.toJson(audit, type);
        
        if (log.isTraceEnabled()) {
			log.trace("Audit: {}", json);
		}
	}


}
