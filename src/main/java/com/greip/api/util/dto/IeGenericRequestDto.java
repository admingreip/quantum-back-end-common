package com.greip.api.util.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IeGenericRequestDto implements Serializable {

	private String pgeCodEmpresa;
	private String pgeCodCanal;
	private String pgeCodAgencia;
	private String pgeUsuario;
	private String pgeTerminal;
}
