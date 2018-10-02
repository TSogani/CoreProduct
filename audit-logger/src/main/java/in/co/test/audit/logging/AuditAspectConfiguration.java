package in.co.test.audit.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
public class AuditAspectConfiguration {
	@Bean
    public LoggingReqResAspect loggingReqResAspect() {
        return new LoggingReqResAspect();
    }
}
