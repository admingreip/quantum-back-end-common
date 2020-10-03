package com.greip.api.util.dto;

import lombok.Getter;

@Getter
public class IeGenericParameterDto {

	private String pgsCodRespuesta;

	private String pgsDesRespuesta;

	private String pgsDetRespuesta;
	
	public void setPgsCodRespuesta(String pgsCodRespuesta) {
		this.pgsCodRespuesta = pgsCodRespuesta;
	}

	public void setPgsDesRespuesta(String pgsDesRespuesta) {
		this.pgsDesRespuesta = pgsDesRespuesta;
	}

	public void setPgsDetRespuesta(String pgsDetRespuesta) {
		this.pgsDetRespuesta = pgsDetRespuesta;
	}
	
	public void setPgsDetRespuesta(Exception e) {
		this.pgsDetRespuesta = e.getMessage() + " :: " + e.getCause().toString();
	}
	
	
}
