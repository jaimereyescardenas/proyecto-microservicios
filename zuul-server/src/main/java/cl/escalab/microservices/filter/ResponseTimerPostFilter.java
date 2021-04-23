package cl.escalab.microservices.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ResponseTimerPostFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return 2;
	}
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext context = RequestContext.getCurrentContext();
		Date start = (Date) context.get("start");
		Date end = new Date();
		
		Logger logger = Logger.getLogger("cl.escalab.microservices.filter.ResponseTimerPostFilter.class");
		String logEntry = "Tiempo de respuesta: " + (end.getTime() - start.getTime()) + " milisegundos";
		logger.info(logEntry);
		
		return null;
	}

}
