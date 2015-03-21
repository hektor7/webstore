package com.packt.webstore.interceptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {

	/*
	 * Java provides a ThreadLocal class that we can set/get thread scoped
	 * variables. The values stored in ThreadLocal are local to the thread,
	 * which means that each thread will have its own ThreadLocal variable. One
	 * thread cannot access/modify the ThreadLocal variables of other threads.
	 * Since Spring MVC is based on the servlet programming model, each web
	 * request is an individual thread.
	 */
	ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	Logger logger = Logger.getLogger(this.getClass());

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatch.start(handler.toString());
		stopWatchLocal.set(stopWatch);

		this.logger.info("Accessing URL path: " + this.getURLPath(request));
		this.logger.info("Request processing started on: "
				+ this.getCurrentTime());
		return true;
	}

	public void postHandle(HttpServletRequest arg0,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		this.logger
				.info("Request processing ended on " + this.getCurrentTime());
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		StopWatch stopWatch = this.stopWatchLocal.get();
		if (stopWatch != null) { // In the last call this could be null
			stopWatch.stop();

			this.logger.info("Total time taken for processing: "
					+ stopWatch.getTotalTimeMillis() + " ms");
		}

		this.stopWatchLocal.set(null);
		this.logger
				.info("=======================================================");
	}

	private String getURLPath(HttpServletRequest request) {
		String currentPath = request.getRequestURI();
		String queryString = request.getQueryString();
		queryString = queryString == null ? "" : "?" + queryString;
		return currentPath + queryString;
	}

	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

}