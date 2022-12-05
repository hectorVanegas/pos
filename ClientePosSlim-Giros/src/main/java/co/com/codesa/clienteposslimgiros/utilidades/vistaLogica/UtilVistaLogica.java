package co.com.codesa.clienteposslimgiros.utilidades.vistaLogica;

import java.util.Date;

import co.com.codesa.client.socketcliente.socket.SocketCliente;
import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.vista.logica.biometria.BiometriaVistaLogica;
import co.com.codesa.codesawrapper.controlador.conexion.ProcesadorTramas;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.HuellaBiometria;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrapper.modelo.enumeraciones.EnumPropiedades;
import co.com.codesa.codesawrapper.modelo.interfaces.IEntidadTrama;
import co.com.codesa.codesawrapper.modelo.interfaces.IRespuestaTrama;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2017
 * @Clase UtilVistaLogica 
 * 		  Clase utilitaria relacionada con el componente de vistalogica
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilVistaLogica 
{
	/**
	 * @variable 	instancia 
	 * 				Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 	SINGLETON (patron de diseño)
	 **/
	private static UtilVistaLogica instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilVistaLogica
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilVistaLogica() 
			throws Exception
	{}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilVistaLogica
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilVistaLogica getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilVistaLogica();
		}
		
		return instancia;
	}
	
	public IRespuestaTrama realizarPeticion(IEntidadTrama	pIEntidadTrama)	
			throws Exception
	{
		ProcesadorTramas	objProcesadorTramas;
		
		objProcesadorTramas	=	new ProcesadorTramas(	InformacionSession.getInstance().getIpSocket(),
																			InformacionSession.getInstance().getPuertoSocket()
																		);
		
		return objProcesadorTramas.procesarPeticion	(	pIEntidadTrama, 
														EnumPropiedades.MAC,
														EnumPropiedades.TIME_OUT
													);
	}
}
