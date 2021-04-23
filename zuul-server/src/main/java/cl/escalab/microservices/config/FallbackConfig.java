package cl.escalab.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FallbackConfig {

	@Bean
	public CustomFallbackProvider getCustomFallbackProvider() {
		return new CustomFallbackProvider();
	}
	
}
