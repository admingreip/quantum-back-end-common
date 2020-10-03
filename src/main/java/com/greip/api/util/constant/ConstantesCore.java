package com.greip.api.util.constant;

public class ConstantesCore {
	public static final String COMILLA = "\"";
	
	public static class TipoOperacion {
		public static final String READ = "R"; //Consultar devuelve header y data
		public static final String READ_DATA = "RD"; //Consultar solo devuelve data sin header (Esto se usa a la interna)
		public static final String READ_SELECT_ITEM = "RS"; //Consultar solo devuelve clave valor sin header (Esto se usa a la interna)
		public static final String READ_FORMULARIO = "RF"; //Consulta los datos de la entidad y ademas otros datos para un formulrio formulario
		public static final String CREATE = "C";//Crear un registro
		public static final String UPDATE = "U"; //Actualizar un registro
		public static final String DELETE = "D"; //Eliminar un registro
		public static final String PROCESO = "P"; //Un proceso
	}

	public static class Proceso {
		public static final String BASEDATOS = "Q"; //Consultar devuelve header y data
		public static final String EMAIL = "E"; //Consultar solo devuelve data sin header (Esto se usa a la interna)
		public static final String JAVA = "J"; //Consultar solo devuelve clave valor sin header (Esto se usa a la interna)
		public static final String BASH = "B"; //Consulta los datos de la entidad y ademas otros datos para un formulrio formulario
		
	}

	
	
	public static class Exception {
		public static final String CAPA_SERVICE = "Excepcion en la Capa de Servicio";
		public static final String CAPA_SERVICE_ERROR_INVOKE_CLIENT = "Error al invocar el Cliente";
		public static final String CAPA_ENDPOINT = "Excepcion en la Capa EndPoint";
		public static final String CAPA_CONTROLLER = "Excepcion en la Capa Controller";
		public static final String CAPA_REPOSITORY = "Excepcion en la Capa Repository";
	}
	
	public static class SpringBootMessages {
		public static final String LOAD_APP = "%s Loading....";
		public static final String LOAD_APP_LOADING = "%s Loading in %s";
		public static final String LOAD_APP_ERROR = "%s Load with errors - Posiblemente no esté configurado la variable de entorno GREIP_WS_HOME";
		public static final String LOAD_APP_ERRO_JNDI = "JNDI no existe";
	}

	public static class Idioma {
		public static final String LNG_ES = "ES";
	}

	public static class System {
		public static final String GETTER = "G";
		public static final String SETTER = "S";
	}

	public static class ResponseMessages {
		public static final String GE_MENSAJE_API_SERVER_GET_ERROR = "geMensajeApiServerGetError";
		public static final String GE_MENSAJE_API_SERVER_GET_OK = "geMensajeApiServerGetOk";
		public static final String GE_MENSAJE_API_SERVER_GET_FILTRO_VACIO = "geMensajeApiServerGetFiltroVacio";
	}

	public static class DaoMessages {
		public static final String ERROR_CONTROLADO = "Error controlado";
		public static final String ERROR_EMPTY_RESULT = "La consulta no devolvió resultados";
	}

	public static class Controller {
		public static final String TITULO_MENSAJE = "titulo";
		public static final String MENSAJE = "mensaje";
		public static final String DETALLE = "detalle";
		public static final String EXCEPTION = "exception";
		public static final String OBJECT = "object";
		public static final String TOTAL_ITEMS = "totalItems";
		public static final String ESTADO = "estado";
		public static final String ID_ESTADO = "idestado";
		
		public static final String LOCATION_URI = "";

	}
	
	/* Constantes para los JSON que devuelve la base de datos */
	public class Json {
		/* Constantes para los tags que devuelven los json de la base de datos */
		public static final String C_RESP_TAG_RESP = "pgsCodRespuesta";
		public static final String C_RESP_TAG_DETA = "pgsDesRespuesta";
		public static final String C_RESP_TAG_CAUS = "pgsDetRespuesta";
		public static final String C_RESP_TAG_DATA = "data";

		/* Constantes para los codigos de errores */
		public static final String C_RESP_PRO_NOEXI = "PNE";
		public static final String C_RESP_PRO_PARAM_NO_JSON = "PNJS";
		public static final String C_RESP_PRO_PARAM_NO_AT_JSON = "PNJSAT";
		public static final String C_RESP_PRO_EXITOSO = "PEX";
		public static final String C_RESP_PRO_EXITOSO_DET = "Proceso ejecutado exitosamente";
		public static final String C_RESP_PRO_NOEXITOSO = "PNEX";
		public static final String  C_RESP_PRO_NOEXITOSO_DET = "Error no controlado al ejecutar el proceso";
		
		public static final String C_RESP_PRO_EXITOSO_SD = "PNEXSD";
		public static final String C_RESP_PRO_EXITOSO_SD_DET = "Proceso ejecutado exitosamente pero no retorno data";
		public static final String C_RESP_PRO_NOEXITOSOID = "PNEXID";
		public static final String C_RESP_PRO_NOEXITOSODBNORESP = "PNEXDBNORE";
		public static final String C_RESP_PRO_NOEXITOSODBNORESP_DET = "La base de datos no respondió data";
		public static final String C_RESP_PRO_NOEXITOSODBCNX = "PNEXDBCNX";
		public static final String C_RESP_PRO_NOEXITOSODBCNX_DET = "Error de conexión con la base de datos";
	}

	public class ProcedureParameters {
		public class ProcesoJavaWithFile {
			public static final String P_SERVICE_NAME = "P_SERVICE_NAME";
			public static final String P_PROCESS_NAME = "P_PROCESS_NAME";
			public static final String P_PROCESS_PARAMETER_JS = "P_PROCESS_PARAMETER_JS";
			public static final String P_PROCESS_RESPONSE_JS = "P_PROCESS_RESPONSE_JS";
			public static final String P_PROCESS_RESPONSE_BLOB = "P_PROCESS_RESPONSE_BLOB";
			public static final String P_PROCESS_RESPONSE_CLOB = "P_PROCESS_RESPONSE_CLOB";
			public static final String P_PROCESS_RESPONSE_BLOB2 = "P_PROCESS_RESPONSE_BLOB2";
			public static final String P_PROCESS_RESPONSE_CLOB2 = "P_PROCESS_RESPONSE_CLOB2";
			public static final String P_PROCESS_RESPONSE_BLOB3 = "P_PROCESS_RESPONSE_BLOB3";
			public static final String P_PROCESS_RESPONSE_CLOB3 = "P_PROCESS_RESPONSE_CLOB3";
		}

	}
	
	public class Soap {
		public static final String LOCATION_URI = "/ws";
		public static final String LOCATION_REGISTRATION_BEAN = LOCATION_URI + "/*";
	}

}
