package cl.escalab.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@RibbonClients({
	@RibbonClient(name = "servicio-tipo"), 
	@RibbonClient(name = "servicio-item"), 
	@RibbonClient(name = "servicio-usuario")
	})
public class MsComposerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsComposerApplication.class, args);
	}

}
