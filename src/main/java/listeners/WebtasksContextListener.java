package listeners;

import constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import services.WebtasksServiceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebtasksContextListener implements ServletContextListener {
	private static final Logger LOGGER = Logger.getLogger(WebtasksContextListener.class);
	
	protected String getContext (ServletContextEvent sce) {
		String context = sce.getServletContext().getContextPath();
		return StringUtils.isBlank(context) ? "ROOT" : context;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String context = sce.getServletContext().getContextPath();
		sce.getServletContext().setAttribute(Constants.CONTEXT, context);
		
		WebtasksServiceManager webtasksServiceManager = WebtasksServiceManager.getInstance(sce.getServletContext());
		webtasksServiceManager.startAllServices();
		
		LOGGER.info("Context '"+getContext(sce)+"' started");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		WebtasksServiceManager webtasksServiceManager = WebtasksServiceManager.getInstance(sce.getServletContext());
		webtasksServiceManager.closeAllServices();
		
		LOGGER.info("Context '"+getContext(sce)+"' stopped");
	}
}
