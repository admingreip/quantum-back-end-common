package com.greip.api.util.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.greip.api.util.constant.ConstantesCore;

public class GeControllerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Logger logger = Logger.getLogger("GeControllerException");

	public GeControllerException(String message) {
		super(ConstantesCore.Exception.CAPA_CONTROLLER + " > " + message);
		logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_CONTROLLER + " > " + message);
	}

	public GeControllerException(Exception ex) {
		super(ConstantesCore.Exception.CAPA_CONTROLLER + " > " + ex.getMessage(), ex);
		logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_CONTROLLER, ex);
	}

	public GeControllerException(String message, Exception ex) {
		super(ConstantesCore.Exception.CAPA_CONTROLLER + " > " + message + " / " + ex.getMessage(), ex);
		logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_CONTROLLER, ex);
	}

}
