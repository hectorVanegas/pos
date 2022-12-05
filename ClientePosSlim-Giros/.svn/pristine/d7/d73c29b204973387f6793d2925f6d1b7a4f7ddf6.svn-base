
package co.com.codesa.clienteposslimgiros.vista.logica.biometria;

import co.com.codesa.clientecajams.utilidades.integracion.UtilIntegracionAccesoCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTipoOperacionesISO;
import co.com.codesa.clienteposslimgiros.enumeraciones.conexion.EnumConexiones;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.DescargarHuellaISO;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.EnviarHuellaISO;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PeticionSistemaBiometriaMultiservicio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarFirmaBiometricaLocal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaDescargarHuellaISO;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaEnviarHuellaISO;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaPeticionSistemaBiometriaMultiservicio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRegistrarFirmaBiometricaLocal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaTransmitirWSQ;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.TransmitirWSQ;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.HuellaBiometria;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;


/** 
 * ********************************************************************
 * @class  BiometriaVistaLogica
 *		   clase encargada de manejar el llamado a las tramas relacionadas
 * 		   con el proceso de biometria
 * @author hector.cuenca
 * @date   30/08/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class BiometriaVistaLogica {

	/**
	 * @variable instancia
	 * 			 instancia de la clase para manejo singleton
	 */
	private static BiometriaVistaLogica instancia;
	
	/**
	 * ****************************************************************.
	 * @method BiometriaVistaLogica
	 * 		   Contructor de la logica.
	 * @author Roberth Martinez Vargas
	 * ****************************************************************
	 */
	private BiometriaVistaLogica(){}	
	
	/**
	 * ****************************************************************.
	 * @method getInstance
	 * 		   metodo para cumplir con el patron singleton y tener
	 * 		   una unica instancia de la clase para ser accedida.
	 * @return BiometriaVistaLogica
	 * @author Roberth Martinez Vargas
	 * ****************************************************************
	 */
	public static BiometriaVistaLogica getInstance(){		
		
		if (instancia == null){
			
			instancia= new BiometriaVistaLogica();
		}
		
		return instancia;
	}

	/** 
	 * ********************************************************************
	 * @method	descargarISO
	 * 		  	Permite descargar la huella ISO de un tercero
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pObjTercero
	 * 			Tercero involucrado en la operacion
	 * @param 	pObjHuellaBiometria
	 * 			Captura de huella biometrica relacionada en la operacion
	 * @return	boolean
	 * 			Bandera que identifica si el proceso de descarga segun metrica
	 * 			de parametro TAMAHUEL, finalizo de manera correcta
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	4/09/2017
	 * *********************************************************************
	 */
	public boolean descargarISO	(	Usuario pObjUsuario	,
	                            	Tercero pObjTercero,
	                            	HuellaBiometria pObjHuellaBiometria
	                     		)
			throws Exception 
	{
		/**
		 * [Trama 467 | Envio y descarga de huellas ISO para terceros que 
		 * 				desarrollan procesos de biometría en cajas con 
		 * 				biometría local]
		 */
		
		DescargarHuellaISO objEnvioTrama;
		RespuestaDescargarHuellaISO objRespuestaTrama;
		String strTipoOperacion;
		int int_TAMAHUEL;
		boolean booEstadoDescarga;
		
		strTipoOperacion	=	EnumTipoOperacionesISO.DESCARGAR.getStrValorPropiedad ();
		
		/**
		 * Con el fin de descargar las ISO, se envia * en los dos ultimos posiciones de los token.
		 */
		
		pObjHuellaBiometria.setStrIso("*");
		
		objEnvioTrama = new DescargarHuellaISO	(	pObjUsuario,
		                                          	strTipoOperacion,
		                                          	pObjTercero,
		                                          	pObjHuellaBiometria
		                                 		);
		
		//objRespuestaTrama = (RespuestaDescargarHuellaISO)ProcesadorTramas.getInstance ().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaDescargarHuellaISO)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) 
		{
			int_TAMAHUEL	=	ValidacionesBiometria.getInstance ().getIntMaxHuella();
			
			booEstadoDescarga	=	pObjHuellaBiometria.getStrIso ().length ()	>	int_TAMAHUEL;
				
		}	else	{
			//respuesta negativa
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return booEstadoDescarga;
	}
	
	/** 
	 * ********************************************************************
	 * @method	emitirISO
	 * 		  	Permite emitir la huella ISO de un tercero al sistema central
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param 	pObjTercero
	 * 			Tercero involucrado en la operacion
	 * @param 	pObjHuellaBiometria
	 * 			Captura de huella biometrica relacionada en la operacion
	 * @return	boolean
	 * 			Bandera que identifica si el proceso de envio de ISO finalizo
	 * 			exitosamente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	4/09/2017
	 * *********************************************************************
	 */
	public boolean emitirISO(	Usuario pObjUsuario	,
	                         	Tercero pObjTercero,
	                         	HuellaBiometria pObjHuellaBiometria
	                     	)
			throws Exception 
	{
		/**
		 * [Trama 467 | Envio y descarga de huellas ISO para terceros que 
		 * 				desarrollan procesos de biometría en cajas con 
		 * 				biometría local]
		 */
		
		EnviarHuellaISO objEnvioTrama;
		RespuestaEnviarHuellaISO objRespuestaTrama;
		String strTipoOperacion;
		boolean booResultado;
		
		strTipoOperacion	=	EnumTipoOperacionesISO.EMITIR.getStrValorPropiedad ();
		
		objEnvioTrama = new EnviarHuellaISO	(	pObjUsuario,
		                                        strTipoOperacion,
		                                        pObjTercero,
		                                        pObjHuellaBiometria
		                                 	);
		
		//objRespuestaTrama = (RespuestaEnviarHuellaISO)ProcesadorTramas.getInstance ().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaEnviarHuellaISO)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) 
		{
			booResultado	=	(boolean)objRespuestaTrama.getValorAtributoObj("booResultado");
			
		}	else	{
			//respuesta negativa
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return booResultado;
	}
	
	/** 
	 * ********************************************************************
	 * @method	transmitirHuellaWSQ
	 * 		  	Permite realizar la transmision de la huella WSQ al proveedor
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param	pObjTercero
	 * 			Tercero al que pertenece las WSQ a transmitir
	 * @param	pObjHuellaWSQ
	 * 			Huella de interes a transmitir
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 * *********************************************************************
	 */
	public void transmitirHuellaWSQ	(	Usuario pObjUsuario,
	                               	 	Tercero pObjTercero,
	                               	 	HuellaBiometria pObjHuellaWSQ
	                               	)
			throws Exception
	{
		/**
		 * [Trama 510 | Transmitir huella WSQ]
		 */
		
		TransmitirWSQ objEnvioTrama;
		RespuestaTransmitirWSQ objRespuestaTrama;
			
		objEnvioTrama = new TransmitirWSQ(	pObjUsuario,
		                                  	pObjTercero,
		                                 	pObjHuellaWSQ,
		                                 	EnumConexiones.TRANSMISOR_WSQ.getObjConexion ()
		                                 );
		//objRespuestaTrama = (RespuestaTransmitirWSQ)ProcesadorTramas.getInstance ().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaTransmitirWSQ)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) 
		{
			//respuesta negativa
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	realizarPeticionSistemaMultiservicio
	 * 		  	Permite solicitar una peticion al sistema multiservicio, para
	 * 			consumir los diferentes servicios que este presenta:
	 * 				ValidarTercero
	 * 				EnrolarHuella
	 * 				SolicitarHuella
	 * @param 	pObjUsuario
	 * 			Usuario cajero que realiza la transaccion
	 * @param	pObjServicio
	 * 			Especificacion del servicio que se desea consumir
	 * @param 	pStrPeticion
	 * 			Peticion a emitir al sistema biometria multiservicio
	 * @return	String
	 * 			Respuesta de la peticion emitida al sistema biometria 
	 * 			multiservicio
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	01/02/2018
	 * *********************************************************************
	 */
	public String realizarPeticionSistemaMultiservicio	(	Usuario pObjUsuario,
															ServicioPeticion pObjServicio,
	                            							String pStrPeticion
	                            						)
			throws Exception
	{
		/**
		 * [Trama 530 | Realizar operaciones hacia el sistema biometria multiservicio]
		 */
		
		PeticionSistemaBiometriaMultiservicio objEnvioTrama;
		RespuestaPeticionSistemaBiometriaMultiservicio objRespuestaTrama;
		String strRespuestaMultiservicio = null;
		
		objEnvioTrama = new PeticionSistemaBiometriaMultiservicio	(	pObjUsuario,
																		pObjServicio,
																		pStrPeticion
		                                 							);
		
		//objRespuestaTrama = (RespuestaEnviarHuellaISO)ProcesadorTramas.getInstance ().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaPeticionSistemaBiometriaMultiservicio)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) 
		{
			strRespuestaMultiservicio	=	(String)objRespuestaTrama.getValorAtributoObj("strRespuestaPeticion");
			
		}	else	{
			//respuesta negativa
			
			UtilIntegracionAccesoCajaMultiservicio.getInstancia().generarExcepcionRespuestaPeticionNegativa	(	(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
				   		 																						(String)objRespuestaTrama.getValorAtributoObj("descripcionError")
				   		 																					);
		}
		
		return strRespuestaMultiservicio;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	registrarFirmaBiometricaBiometriaLocal
	 * 		  	Metodo encargado de invocar la trama de registrar huella 
	 * 			para firma biometrica con proceso de biometria local
	 * @param pObjUsuario
	 * 			Usuario que realiza la peticion al sistema
	 * @param pObjTercero
	 * 			Es el objeto tercero que interviene en el proceso
	 * @param pStrOperacion
	 * 			Es el proceso por el cual se requiere la firma biometrica
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	stiven.garcia
	 * @date	30/05/2018
	 * *********************************************************************
	 */
	public void registrarFirmaBiometricaBiometriaLocal( Usuario pObjUsuario	,
											         	Tercero pObjTercero,
											         	String pStrOperacion
											          ) throws Exception {
		
				
		RegistrarFirmaBiometricaLocal objEnvioTrama;
		RespuestaRegistrarFirmaBiometricaLocal objRespuestaTrama;
		
		String strEvento;
		String strFecha;
		
		objEnvioTrama = new RegistrarFirmaBiometricaLocal(pObjUsuario, pObjTercero, pStrOperacion);
		
		objRespuestaTrama = (RespuestaRegistrarFirmaBiometricaLocal) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) 
		{
			strFecha	=	(String)objRespuestaTrama.getValorAtributo("strFecha");
			strEvento   =   (String)objRespuestaTrama.getValorAtributo("strEvento");
			
		}	else	{
			//respuesta negativa
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError")
													   		);
		}
		
	}
}
