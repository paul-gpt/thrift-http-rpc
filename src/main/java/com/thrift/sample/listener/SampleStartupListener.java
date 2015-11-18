package com.thrift.sample.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.thrift.sample.servlet.SampleServlet;
import com.thrift.sample.util.SpringContextUtil;

@Component
public class SampleStartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	ServletContext servletContext;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		log.info("****************** Init SampleServlet Start ******************");
		SpringContextUtil.setApplicationContext(contextRefreshedEvent.getApplicationContext());
		ServletRegistration.Dynamic api = servletContext.addServlet("SampleServlet", (SampleServlet) SpringContextUtil.getBean("sampleServlet"));
		api.setLoadOnStartup(1);
		api.addMapping("/service/*");
		log.info("****************** Init SampleServlet End ******************");
	}

}
