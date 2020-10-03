package com.greip.api.util.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeHeaderResponseDto {
	private String codRes;
	private String desRes;
	private String detRes;
	private int canRes;
	
	public GeHeaderResponseDto(String codRes,String desRes,String detRes,int canRes) {
		this.codRes = codRes;
		this.desRes = desRes;
		this.detRes = detRes;
		this.canRes = canRes;
	}
	
	public GeHeaderResponseDto(String codRes,String desRes,String detRes) {
		this.codRes = codRes;
		this.desRes = desRes;
		this.detRes = detRes;
	}
}
