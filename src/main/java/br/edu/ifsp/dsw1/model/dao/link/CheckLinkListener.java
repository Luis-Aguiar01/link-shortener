package br.edu.ifsp.dsw1.model.dao.link;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CheckLinkListener implements ServletContextListener {
	private ScheduledExecutorService scheduler;
	private static int urlSize = 5;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				var dao = new LinkDAOFactory().factory();
				if(dao.count() > Math.pow(63, urlSize) * 0.5) {
					urlSize = getUrlSize() + 1;
				}
			}
		}, 0, 30, TimeUnit.MINUTES);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		scheduler.shutdownNow();
	}

	public static int getUrlSize() {
		return urlSize;
	}
}
