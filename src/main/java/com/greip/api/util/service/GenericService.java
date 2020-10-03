package com.greip.api.util.service;

import java.util.LinkedList;
import java.util.List;

public class GenericService {
	
	/**
	 * Devuelve la lista de los properties genéricos de todos los proyectos.
	 * @return list
	 */
	public static List<String> getGenericProperties() {
		List<String> lst = new LinkedList<String>();
		lst.add("spring.application.name");
		lst.add("server.port");
		lst.add("eureka.client.serviceUrl.defaultZone");
		lst.add("eureka.instance.instance-id");
		lst.add("logging.file");
		lst.add("spring.datasource.jndi-name");
		lst.add("spring.datasource.url");
		lst.add("spring.datasource.username");
		lst.add("spring.jpa.properties.hibernate.dialect");
		lst.add("spring.datasource.driver-class-name");
		lst.add("spring.profiles.active");
		lst.add("spring.cloud.config.uri");
		lst.add("business.url.client");
		lst.add("spring.cloud.discovery.enabled");		
		return lst;
	}
	
}
