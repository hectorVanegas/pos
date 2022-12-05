/** 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
package co.com.codesa.clienteposslimgiros.vista.logica.Internacional.territorio;

import java.util.TreeMap;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarCiudadesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarDepartamentosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarPaisesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarCiudadesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarDepartamentosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarPaisesInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerritorioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/** 
 * ********************************************************************
 * @class  TerritorioInternacionalVistaLogica
 *		   clase encargada de manejar el llamado a las tramas relacionadas
 * 		   con territorios de la funcionalidad de giros internacionales
 * @author roberth.martinez
 * @date   14/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class TerritorioInternacionalVistaLogica {

	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static TerritorioInternacionalVistaLogica instance;

	/**
	 * ********************************************************************
	 * @method TerritorioInternacionalVistaLogica
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   22/03/2018
	 * ********************************************************************
	 */
	private TerritorioInternacionalVistaLogica() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return TerritorioInternacionalVistaLogica
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   22/03/2018
	 * ********************************************************************
	 */
	public static TerritorioInternacionalVistaLogica getInstancia()
			throws Exception {

		if (instance == null) {

			instance = new TerritorioInternacionalVistaLogica();
		}

		return instance;
	}	
	
	/** 
	 * ********************************************************************
	 * @method	consultaPaisesInternacionales
	 * 		  	Metodo que permite consultar el listado paises autorizados 
	 * 			por la red internacional
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @return  TreeMap<String, Territorio>
	 * 		    Listado paises autorizados por la red internacional
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public TreeMap<String, Territorio> consultaPaisesInternacionales(	Usuario pObjUsuario,
   			  	 														ServicioPeticion pObjServicioPeticion
   			  	 													)
   		throws Exception
   	{
		/**
		* [Trama 508 | Consultar listado de Paises autorizados]
		*/
		
		ConsultarPaisesInternacional objEnvioTrama;
		RespuestaConsultarPaisesInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarPaisesInternacional(	pObjUsuario, 
															pObjServicioPeticion,
															EnumParametrosApp.CODIGO_TIPO_TERRITORIO_PAIS.getValorEntero()
														);
		
		objRespuestaTrama = (RespuestaConsultarPaisesInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			return (TreeMap<String, Territorio>) objRespuestaTrama.getValorAtributoObj("tmPaises");
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaDepartamentosXPaisInternacional
	 * 		  	Metodo que permite consultar el listado departamentos x pais 
	 * 			autorizados por la red internacional
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @param	pObjTrrIntPais
	 * 			Objeto territorio que representa el pais al cual se consultara
	 * 			los departamentos asociados
	 * @return  TreeMap<String, Territorio>
	 * 		    Listado departamentos x pais autorizados por la red internacional
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public TreeMap<String, Territorio> consultaDepartamentosXPaisInternacional	(	Usuario pObjUsuario,
   			  	 																	ServicioPeticion pObjServicioPeticion,
   			  	 																	TerritorioInternacional pObjTrrIntPais
   			  	 																)
   		throws Exception
   	{
		/**
		* [Trama 508 | Consultar listado de departamentos autorizados]
		*/
		
		ConsultarDepartamentosInternacional objEnvioTrama;
		RespuestaConsultarDepartamentosInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarDepartamentosInternacional(	pObjUsuario, 
																	pObjServicioPeticion,
																	pObjTrrIntPais,
																	EnumParametrosApp.CODIGO_TIPO_TERRITORIO_DEPARTAMENTO.getValorEntero()
																);
		
		objRespuestaTrama = (RespuestaConsultarDepartamentosInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			return (TreeMap<String, Territorio>) objRespuestaTrama.getValorAtributoObj("tmDepartamentos");
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultaMunicipiosXDepartamentoInternacional
	 * 		  	Metodo que permite consultar el listado municipios x departamento 
	 * 			autorizados por la red internacional
	 * @param   pObjUsuario
	 * 			Objeto usuario de la aplicacion
	 * @param   pObjServicioPeticion
	 * 			Objeto ServicioPeticion, con los datos de la consulta a FPISA
	 * @param	pObjTrrIntDepartamento
	 * 			Objeto territorio que representa el departamento al cual se consultara
	 * 			los municipios asociados
	 * @return  TreeMap<String, Territorio>
	 * 		    Listado municipios x departamento autorizados por la red internacional
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		    presentada
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public TreeMap<String, Territorio> consultaMunicipiosXDepartamentoInternacional	(	Usuario pObjUsuario,
	   			  	 																	ServicioPeticion pObjServicioPeticion,
	   			  	 																	TerritorioInternacional pObjTrrIntDepartamento
	   			  	 																)
   		throws Exception
   	{
		/**
		* [Trama 508 | Consultar listado de municipios autorizados]
		*/
		
		ConsultarCiudadesInternacional objEnvioTrama;
		RespuestaConsultarCiudadesInternacional objRespuestaTrama;
		
		objEnvioTrama = new ConsultarCiudadesInternacional	(	pObjUsuario, 
																pObjServicioPeticion,
																pObjTrrIntDepartamento,
																EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero()
															);
		
		objRespuestaTrama = (RespuestaConsultarCiudadesInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
		
			return (TreeMap<String, Territorio>) objRespuestaTrama.getValorAtributoObj("tmMunicipios");
		
		}else{//respuesta negativa
		
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
}
