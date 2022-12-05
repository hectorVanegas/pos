/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.List;

import co.com.codesa.clienteposslimcontrolador.conexion.ProcesadorTramas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarDatosEntidadesPorCodigoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarEnDatos;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaAgenciasProvisiones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarDatosEntidadesPorCodigoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarEnDatos;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de
 * datos entidaddes del sistema.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class DatoEntidadVistaLogica {

	private static DatoEntidadVistaLogica instancia ;

	/**
	 * ****************************************************************.
	 * @metodo: DatoEntidadVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private DatoEntidadVistaLogica(){}	

	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static DatoEntidadVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new DatoEntidadVistaLogica();

		return instancia;
	}

	/**
	 * ****************************************************************.
	 * @metodo: consultarConceptosEnDatoEntidad
	 * @descripcion: llama la trama consultar conceptos por tipo.
	 * @param pTipo
	 * @return RespuestaConsultarEnDatos
	 * @autor: CesarO.Rendon
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<DatoEntidad> consultarConceptosEnDatoEntidad(Usuario pObjUsuario,
															 String pStrTipo) throws Exception{
		
		/**
		 * [Trama 24 | Consultar Clases de Solicitudes: Permite consultar los "conceptos" de datos entidades por los 
		 * 	cuales se puede realizar una solicitud de Autorizacion sobre un giro] 
		 */
		
		List<DatoEntidad> lstSolicitudes = null;
		ConsultarEnDatos objEnvioTrama;
		RespuestaConsultarEnDatos objRespuestaTrama;
		
		objEnvioTrama = new ConsultarEnDatos(pObjUsuario,
											 pStrTipo);

		//objRespuestaTrama =(RespuestaConsultarEnDatos)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarEnDatos)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstSolicitudes = (List<DatoEntidad>)objRespuestaTrama.getValorAtributoObj("lstSolicitudes");
			
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstSolicitudes;
	}

	/**
	 * ****************************************************************.
	 * @metodo: consultarDatosPorEntidad
	 * @descripcion: llama la trama consultar dato por codigo de entidad.
	 * @return RespuestaConsultarDatosEntidadesPorCodigoEntidad
	 * @autor: CesarO.Rendon
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<DatoEntidad> consultarDatosPorEntidad(Usuario pObjUsuario,
													  String pStrIdEntidad) throws Exception{
		/**
		 * [Trama 39 | consultar datos asociados a una entidad] 
		 */
		
		List<DatoEntidad> lstDatosEntidad = null;
		ConsultarDatosEntidadesPorCodigoEntidad objEnvioTrama;
		RespuestaConsultarDatosEntidadesPorCodigoEntidad objRespuestaTrama;
		
		objEnvioTrama = new ConsultarDatosEntidadesPorCodigoEntidad(pObjUsuario,
																	pStrIdEntidad);
		
		//objRespuestaTrama =(RespuestaConsultarDatosEntidadesPorCodigoEntidad)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarDatosEntidadesPorCodigoEntidad)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstDatosEntidad = (List<DatoEntidad>)objRespuestaTrama.getValorAtributoObj("lstDatosEntidades");
			
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstDatosEntidad;
	}
}
