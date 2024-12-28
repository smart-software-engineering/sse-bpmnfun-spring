package com.sse.bpmn.bpmn;

import org.camunda.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BpmnProcessApplication {

	public static void main(String[] args) {
		System.out.println("BpmnProcessApplication started");
		SpringApplication.run(BpmnProcessApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<ProcessEngineAuthenticationFilter> processEngineAuthenticationFilter() {
		FilterRegistrationBean<ProcessEngineAuthenticationFilter> registration = new FilterRegistrationBean<>();
		registration.setName("camunda-rest-auth");
		registration.setFilter(getProcessEngineAuthenticationFilter());
		registration.addInitParameter("authentication-provider", "org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider");
		registration.addUrlPatterns("/engine-rest/*");
		return registration;
	}

	@Bean
	public ProcessEngineAuthenticationFilter getProcessEngineAuthenticationFilter() {
		return new ProcessEngineAuthenticationFilter();
	}
}
