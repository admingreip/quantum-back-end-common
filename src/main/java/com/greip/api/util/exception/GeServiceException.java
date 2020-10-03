package com.greip.api.util.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.greip.api.util.constant.ConstantesCore;

public class GeServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Logger logger = Logger.getLogger("GeServiceException");

	public GeServiceException(String message){
        super(ConstantesCore.Exception.CAPA_SERVICE + " > "+ message);
        logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_SERVICE + " > " + message);
    }

    public GeServiceException(Exception ex){
    	super(ConstantesCore.Exception.CAPA_SERVICE + " > "+ ex.getMessage(), ex);
    	logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_SERVICE, ex);
    }

    public GeServiceException(String message, Exception ex){
    	super(ConstantesCore.Exception.CAPA_SERVICE + " > "+message+" / "+ex.getMessage(), ex);    
    	logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_SERVICE+ " > "+message, ex);
    }

}
