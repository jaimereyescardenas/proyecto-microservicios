package cl.escalab.microservices.config;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class CustomRule implements IRule {

	private ILoadBalancer lb;
	
	@Override
	public Server choose(Object key) {
		
		List<Server> servers = lb.getAllServers();
		if (servers.size() == 0) {
			return null;
		}
		Random r = new Random();
		return servers.get(r.nextInt(servers.size()));
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb = lb;
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		return lb;
	}

}
