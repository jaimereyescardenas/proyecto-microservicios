package cl.escalab.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import cl.escalab.microservices.config.RibbonConfig;

@SpringBootApplication()
@EnableDiscoveryClient
@EnableCircuitBreaker
@RibbonClient(name = "servicio-item", configuration = {RibbonConfig.class})
public class MsUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsuariosApplication.class, args);
	}

}
