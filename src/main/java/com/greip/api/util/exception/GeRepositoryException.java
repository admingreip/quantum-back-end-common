package com.greip.api.util.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.greip.api.util.constant.ConstantesCore;


public class GeRepositoryException extends Exception {
	
	public static Logger logger = Logger.getLogger("GeRepositoryException");
	
	public GeRepositoryException(String message){
        super(ConstantesCore.Exception.CAPA_REPOSITORY + " > "+ message);
        logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_REPOSITORY + " > "+ message);
    }

    public GeRepositoryException(Exception ex){
    	super(ConstantesCore.Exception.CAPA_REPOSITORY + " > "+ ex.getMessage(), ex);
    	logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_REPOSITORY, ex);
    }

    public GeRepositoryException(String message, Exception ex){
    	super(ConstantesCore.Exception.CAPA_REPOSITORY + " > "+message+" / "+ex.getMessage(), ex);
    	logger.log(Level.SEVERE, ConstantesCore.Exception.CAPA_REPOSITORY, ex);
    }

}
