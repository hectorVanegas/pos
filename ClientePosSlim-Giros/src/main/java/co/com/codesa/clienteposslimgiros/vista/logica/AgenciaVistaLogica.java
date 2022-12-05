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
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaAgenciasProvisiones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarAgenciasPorTerritorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaAgenciasProvisiones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarAgenciasPorTerritorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarEnviarSMS;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 19-mar-2015 
 * @descripcion: clase encargada de manejar el llamado a las tramas de
 * de agencias.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class AgenciaVistaLogica {

	private static AgenciaVistaLogica instancia ;

	/**
	 * ****************************************************************.
	 * @metodo: AgenciaVistaLogica
	 * @descripcion: contructor de la logica.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	private AgenciaVistaLogica(){}	

	/**
	 * ****************************************************************.
	 * @metodo: getInstance
	 * @descripcion: metodo para cumplir con el patron singleton y tener
	 * una unica instancia de la clase para se accedida.
	 * @autor: CesarO.Rendon
	 * ****************************************************************
	 */
	public static AgenciaVistaLogica getInstance(){		
		if (instancia == null)
			instancia= new AgenciaVistaLogica();

		return instancia;
	}
	
	@SuppressWarnings("unchecked")
	public List<Agencia> consultarAgenciasPorTerritorio(Usuario pObjUsuario,
														Territorio pObjTerrMunicipio, 
													    String pStrValorGiro, 
													    boolean pBooFiltro)throws Exception{
		/**
		 * [Trama 4 | Consultar Agencias por Territorio (Pin)]
		 */
		
		List<Agencia> lstAgencias = null;
		ConsultarAgenciasPorTerritorio objEnvioTrama;
		RespuestaConsultarAgenciasPorTerritorio objRespuestaTrama;
		
		objEnvioTrama = new ConsultarAgenciasPorTerritorio(pObjUsuario,
														   pObjTerrMunicipio,
													       pBooFiltro,
													       pStrValorGiro);
		
		//objRespuestaTrama = (RespuestaConsultarAgenciasPorTerritorio)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarAgenciasPorTerritorio)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstAgencias = (List<Agencia>)objRespuestaTrama.getValorAtributoObj("listaAgencias");
			
		}else{//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstAgencias;
	}

	/**
	 * ****************************************************************.
	 * @metodo: consultarAgenciasPrivisiones
	 * @descripcion: metodo consultar las agencias para provisiones del municipio
	 * @param pObjTerrMunicipio
	 * 		  municio sobre el cual se consultara la agencia
	 * @param pBooFiltro
	 * @param pStrValorGiro
	 * 		  valor del giro
	 * @param pStrCajaOrigen
	 * 		  caja origen
	 * @throws Exception
	 * @return: List<Agencia> listado de agencias
	 * @autor: Roberth Martinez Vargas
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<Agencia> consultarAgenciasPrivisiones(Usuario pObjUsuario,
													  Territorio pObjTerrMunicipio, 
													  boolean pBooFiltro,
													  String pStrValorGiro, 
													  String pStrCajaOrigen)throws Exception{
		/**
		* [Trama 100 | Consultar Agencias provisiones]
		*/
											
		List<Agencia> lstAgencias = null;
		ConsultaAgenciasProvisiones objEnvioTrama;
		RespuestaConsultaAgenciasProvisiones objRespuestaTrama;
		
		objEnvioTrama = new ConsultaAgenciasProvisiones(pObjUsuario,
														pObjTerrMunicipio, 
													 	pBooFiltro, 
													 	pStrValorGiro);
		
		//objRespuestaTrama = (RespuestaConsultaAgenciasProvisiones)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaAgenciasProvisiones)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstAgencias = (List<Agencia>) objRespuestaTrama.getValorAtributoObj("lstAgencias");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstAgencias;
	}
	
}
