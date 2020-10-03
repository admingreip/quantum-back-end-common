package com.greip.api.util.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.greip.api.util.constant.ConstantesCore;

public class GeEndPointException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger("GeEndPointException");

	public GeEndPointException(String message){
        super(ConstantesCore.Exception.CAPA_ENDPOINT + " > "+ message);
        logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_ENDPOINT + " > " + message);
    }

    public GeEndPointException(Exception ex){
    	super(ConstantesCore.Exception.CAPA_ENDPOINT + " > "+ ex.getMessage(), ex);
    	logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_ENDPOINT, ex);
    }

    public GeEndPointException(String message, Exception ex){
    	super(ConstantesCore.Exception.CAPA_ENDPOINT + " > "+message+" / "+ex.getMessage(), ex);
    	logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_ENDPOINT, ex);
    }

}
