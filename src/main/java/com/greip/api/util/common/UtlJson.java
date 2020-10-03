package com.greip.api.util.common;

import java.io.IOException;
import java.sql.Clob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greip.api.util.exception.GeServiceException;

public class UtlJson {

	public static Logger log = LoggerFactory.getLogger(UtlJson.class);
	public static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * Convierte un String en un com.fasterxml.jackson.databind.JsonNode
	 * 
	 * @param jsonString Text Json
	 * @return com.fasterxml.jackson.databind.JsonNode
	 * @throws GeServiceException
	 */
	public static JsonNode convertStringToJsonNode(String jsonString) throws GeServiceException {
		JsonNode node;
		try {
			node = mapper.readTree(jsonString);
			return node;
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		}

	}

	/**
	 * Convierte un Clob en un com.fasterxml.jackson.databind.JsonNode
	 * 
	 * @param jsonClob Clob
	 * @return com.fasterxml.jackson.databind.JsonNode
	 * @throws GeServiceException
	 */
	public static JsonNode convertClobToJsonNode(Clob jsonClob) throws GeServiceException {
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(UtlString.convertClobToString(jsonClob));
			return jsonNode;
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		}
	}

	/**
	 * Convierte un Object Entity en un String en Formato Json
	 * 
	 * @param entity object entity
	 * @return String format Json
	 * @throws GeServiceException
	 */
	public static String convertObjectToJsonString(Object entity) throws GeServiceException {
		String jsonParameter = null;
		try {
			jsonParameter = mapper.writeValueAsString(entity);
			return jsonParameter;
		} catch (JsonProcessingException e1) {
			log.error(e1.getMessage());
			throw new GeServiceException(e1);
		}
	}

	/**
	 * Convierte un com.fasterxml.jackson.databind.JsonNode en object entity o dto
	 * 
	 * @param obj   com.fasterxml.jackson.databind.JsonNode
	 * @param clase Clase a convertir el JsonNode
	 * @return Object de la clase
	 * @throws GeServiceException
	 */
	public static Object convertJsonNodeToObject(JsonNode obj, Class clase) throws GeServiceException {
		try {
			return mapper.readValue(obj.toString(), clase);
		} catch (JsonParseException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		} catch (JsonMappingException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		}
	}

	/**
	 * Convierte un JsonString en un Object de una clase especifica
	 * 
	 * @param jsonString Json String
	 * @param clase      Clase del Objeto
	 * @return Objeto de la Clase
	 * @throws GeServiceException
	 */
	public static Object convertJsonStringToObject(String jsonString, Class clase) throws GeServiceException {

		try {
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			return mapper.readValue(jsonString, clase);
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		}
	}

	/**
	 * Convierte JsonNode en un Object
	 * 
	 * @param jsonNode JsonNode
	 * @return Object
	 * @throws GeServiceException
	 */
	public static Object convertJsonNodeToObject(JsonNode jsonNode) throws GeServiceException {

		try {
			return mapper.readTree(jsonNode.asText());
		} catch (JsonParseException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		} catch (JsonMappingException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		} catch (IOException e) {
			log.error(e.getMessage());
			throw new GeServiceException(e);
		}
	}

	/**
	 * Instancia un nuevo ObjectNode
	 * 
	 * @return ObjectNode
	 */
	public static ObjectNode getNewJsonNode() {
		ObjectNode jNode = mapper.createObjectNode();
		return jNode;
	}

	/**
	 * Instancia un nuevo ObjectNode
	 * 
	 * @return ObjectNode
	 */
	public static ObjectNode getNewJsonNode(String jsonText) {
		ObjectNode jNode = null;
		try {
			jNode = (ObjectNode) new ObjectMapper().readTree(jsonText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jNode;
	}

	public static ObjectNode getNewJsonNode(JsonNode json) {
		return (ObjectNode) json;
	}
	
	public static boolean isJsonValid(String text) {
		try {
			if (text == null || text.isEmpty() || text.length() <= 1 || !text.substring(0,1).equals("{")|| !text.substring(text.length()-1,text.length()).equals("}")) {
				return false;
			} else {
				JsonNode jn = UtlJson.convertStringToJsonNode(text);
				return true;
			}

		} catch (GeServiceException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		try {
			JsonNode jn = convertStringToJsonNode("{\"header\":{\"tipOpe\":\"RD\"}}");
			System.out.println(jn.toString());
			JsonNode jnHeader = jn.get("header");
			System.out.println(jnHeader.toString());
			System.out.println(jnHeader.get("tipOpe"));
			
			ObjectNode on = getNewJsonNode(jn);
			ObjectNode onHeader = getNewJsonNode(jnHeader);
			onHeader.put("userId", 1223);
			onHeader.put("terminal", "17.029.012");
			onHeader.put("username", "rchang");
			
			on.set("header", onHeader);
			
			System.out.println(on.toString());
			
			
			
		} catch (GeServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
