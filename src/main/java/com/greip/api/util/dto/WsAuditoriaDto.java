package com.greip.api.util.dto;

import java.io.Serializable;

public class WsAuditoriaDto implements Serializable{
	
	private String codEmpresa;
	private String codCanal;
	private String usuario;
	private String terminal;
	private String jsonParametros;
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public String getCodCanal() {
		return codCanal;
	}
	public void setCodCanal(String codCanal) {
		this.codCanal = codCanal;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getJsonParametros() {
		return jsonParametros;
	}
	public void setJsonParametros(String jsonParametros) {
		this.jsonParametros = jsonParametros;
	}
	
	

}
