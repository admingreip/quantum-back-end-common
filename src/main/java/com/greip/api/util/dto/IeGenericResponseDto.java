package com.greip.api.util.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IeGenericResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IeGenericResponseDto() {
		pgsRespuesta = new IeGenericParameterDto();
	}

	private IeGenericParameterDto pgsRespuesta;
	
	private JsonNode pgsRespuestaData;

}
