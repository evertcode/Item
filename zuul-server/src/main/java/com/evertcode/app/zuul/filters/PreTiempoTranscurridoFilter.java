package com.evertcode.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger LOG = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {

		final RequestContext ctx = RequestContext.getCurrentContext();
		final HttpServletRequest req = ctx.getRequest();

		LOG.info("Entrando a POST filter");
		
		final Long initTime = Long.parseLong(req.getAttribute("initTime").toString());
		
		final Long transcurridoTime = System.currentTimeMillis() - initTime;
		
		LOG.info(String.format("Timepo transcurrido en segundos %s seg", transcurridoTime.doubleValue() / 100D));
		LOG.info(String.format("Timepo transcurrido en milisegundos %s ms", transcurridoTime));
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
