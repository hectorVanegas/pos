package co.com.codesa.clienteposslimgiros.vista.logica.Internacional.reclamos;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarReclamoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarReclamoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ReclamoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

public class ReclamosInternacionalVistaLogica {
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static ReclamosInternacionalVistaLogica instance;

	/**
	 * ********************************************************************
	 * @method ReclamosInternacionalVistaLogica
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author stiven.garcia
	 * @date   23/03/2018
	 * ********************************************************************
	 */
	private ReclamosInternacionalVistaLogica() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return ReclamosInternacionalVistaLogica
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author stiven.garcia
	 * @date   23/03/2018
	 * ********************************************************************
	 */
	public static ReclamosInternacionalVistaLogica getInstancia() throws Exception {

		if (instance == null) {

			instance = new ReclamosInternacionalVistaLogica();
		}

		return instance;
	}
	
	public String registrarReclamoInternacional(Usuario pObjUsuario, FacturaGiroInternacional pObjFacturaGiroInternacional, 
												ReclamoInternacional pObjReclamoInternacional, ServicioPeticion pObjServicioPeticion) throws Exception{
		
		/**
		 * [Trama 508 | Registrar Reclamos internacionales]
		 */
		
		RegistrarReclamoInternacional objEnvioTrama;
		RespuestaRegistrarReclamoInternacional objRespuestaTrama;		
		
		objEnvioTrama = new RegistrarReclamoInternacional(pObjUsuario, pObjFacturaGiroInternacional, pObjReclamoInternacional, pObjServicioPeticion);
		objRespuestaTrama = (RespuestaRegistrarReclamoInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			return objRespuestaTrama.getFechaRegistroReclamo();
		}else {
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
				   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}

}
