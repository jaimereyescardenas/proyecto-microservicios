package cl.escalab.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class RibbonConfig {
	
	@Bean
	public IRule ribbonRule() {
		 return new CustomRule();
//		 return new RoundRobinRule();
	}
	
	@Bean
	public IPing ribbonPing() {
		return new PingUrl();
	}
	
}