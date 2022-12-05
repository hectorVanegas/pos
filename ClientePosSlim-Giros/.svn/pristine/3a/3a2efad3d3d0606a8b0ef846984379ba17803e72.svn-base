package co.com.codesa.clienteposslimgiros.enumeraciones.conexion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Conexion;

/**
 * ********************************************************************
 * @class	EnumConexiones
 *		  	Clase enumerador, que permite administrar de forma diciente 
 * 		  	los tipos de conexion hacia el proveedor de giros que puede 
 * 			manejar el sistema
 * @author 	hector.cuenca
 * @date 	15/09/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumConexiones 
{
	/**
	 * @variable 	NEGOCIO_EMPRESA
	 * 			 	Constante que identifica la conexion de negocio del lado de 
	 * 				la empresa
	 */
	NEGOCIO_EMPRESA(EnumParametrosSistema.CONEXION_PARAMEMPWS_SOCKET_EMPRESA_EJB),//"000000000|00|1|CXSEMPEJ"
	
	/**
	 * @variable 	NEGOCIO_PROVEEDOR
	 * 			 	Constante que identifica la conexion de negocio del lado del 
	 * 				proveedor
	 */
	NEGOCIO_PROVEEDOR(EnumParametrosSistema.CONEXION_PARAMEMPWS_EJB_SOCKET_SIMS_NEGOCIO),//"888999002|89"
	
	/**
	 * @variable 	TRANSMISOR_WSQ
	 * 			 	Constante que identifica la conexion que expone el proveedor
	 * 				para realizar la transmision de los WSQ almacenados localmente
	 */
	TRANSMISOR_WSQ(EnumParametrosSistema.CONEXION_PARAMEMPWS_EJB_SOCKET_SIMS_WSQ),//"888999002|88"
	
	;
	
	/**
	 * @variable 	pEnmParSisEspecificacionPARAMEMPWS
	 * 			 	Parametro de sistema que contiene la especificacion para 
	 * 				obtener el servicio de conexion a traves de la estructura
	 * 				paramempws definida por la empresa
	 */
	private EnumParametrosSistema pEnmParSisEspecificacionPARAMEMPWS;
	
	/**
	 * @variable 	pEnmParSisEspecificacionPARAMEMPWS
	 * 			 	Especificacion para obtener el servicio de conexion a traves 
	 * 				de la estructura paramempws definida por la empresa
	 */
	private String strParametrosPARAMEMPWS;
	
	/**
	 * @variable 	objConexion
	 * 			 	Objeto conexion que contiene y prepara la especificacion
	 * 				para obtener el servicio de conexion a traves de la estrucutra 
	 * 				paramempws definida por la empresa 
	 */
	private Conexion objConexion;
	
	/**
	 * ********************************************************************
	 * @method 	EnumConexiones
	 * 		   	Inicializacion de la constante de enumeracion
	 * @param 	pEnmParSisEspecificacionPARAMEMPWS
	 * 		  	Parametro de sistema que contiene la especificacion para 
	 * 			obtener el servicio de conexion a traves de la estructura
	 * 			paramempws definida por la empresa
	 * @author 	hector.cuenca
	 * @date 	15/09/2017
	 * *********************************************************************
	 */
	private EnumConexiones	(EnumParametrosSistema pEnmParSisEspecificacionPARAMEMPWS)
	{
		this.pEnmParSisEspecificacionPARAMEMPWS = pEnmParSisEspecificacionPARAMEMPWS;
	}
	
	/**
	 * ********************************************************************
	 * @method 	EnumConexiones
	 * 		   	Inicializacion de la constante de enumeracion
	 * @param 	pStrParametrosPARAMEMPWS
	 * 		  	Especificacion para obtener el servicio de conexion a traves 
	 * 			de la estructura paramempws definida por la empresa
	 * @author 	hector.cuenca
	 * @date 	15/09/2017
	 * *********************************************************************
	 */
	private EnumConexiones	(String pStrParametrosPARAMEMPWS)
	{
		this.strParametrosPARAMEMPWS = pStrParametrosPARAMEMPWS;
	}

	/**
	 * @method	getpEnmParSisEspecificacionPARAMEMPWS
	 * 		  	Metodo get del atributo pEnmParSisEspecificacionPARAMEMPWS
	 * @return	EnumParametrosSistema
	 *		  	Valor del atributo pEnmParSisEspecificacionPARAMEMPWS devuelto
	 * @author	hector.cuenca
	 * @date  	15/09/2017
	 */
	public EnumParametrosSistema getpEnmParSisEspecificacionPARAMEMPWS ()
	{
		return this.pEnmParSisEspecificacionPARAMEMPWS;
	}

	/**
	 * @method	setpEnmParSisEspecificacionPARAMEMPWS
	 * 		  	Metodo set del atributo pEnmParSisEspecificacionPARAMEMPWS
	 * @param	pPEnmParSisEspecificacionPARAMEMPWS
	 * 			Valor que tomara el atributo pEnmParSisEspecificacionPARAMEMPWS
	 * @author	hector.cuenca
	 * @date	15/09/2017
	 */
	public void setpEnmParSisEspecificacionPARAMEMPWS (EnumParametrosSistema pPEnmParSisEspecificacionPARAMEMPWS)
	{
		this.pEnmParSisEspecificacionPARAMEMPWS = pPEnmParSisEspecificacionPARAMEMPWS;
	}

	/**
	 * @method	getStrParametrosPARAMEMPWS
	 * 		  	Metodo get del atributo strParametrosPARAMEMPWS
	 * @return	String
	 *		  	Valor del atributo strParametrosPARAMEMPWS devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	15/09/2017
	 */
	public String getStrParametrosPARAMEMPWS ()
			throws Exception
	{
		if	(	this.strParametrosPARAMEMPWS	==	null	)	
		{
			this.strParametrosPARAMEMPWS	=	this.getpEnmParSisEspecificacionPARAMEMPWS ().obtenerValorCadena ();
			this.strParametrosPARAMEMPWS	+=	"|"+1;//destino
			this.strParametrosPARAMEMPWS	+=	"|"+this.getpEnmParSisEspecificacionPARAMEMPWS ().getStrCodigo();
		}
		
		return this.strParametrosPARAMEMPWS;
	}

	/**
	 * @method	setStrParametrosPARAMEMPWS
	 * 		  	Metodo set del atributo strParametrosPARAMEMPWS
	 * @param	pStrParametrosPARAMEMPWS
	 * 			Valor que tomara el atributo strParametrosPARAMEMPWS
	 * @author	hector.cuenca
	 * @date	15/09/2017
	 */
	public void setStrParametrosPARAMEMPWS (String pStrParametrosPARAMEMPWS)
	{
		this.strParametrosPARAMEMPWS = pStrParametrosPARAMEMPWS;
	}

	/**
	 * @method	getObjConexion
	 * 		  	Metodo get del atributo objConexion
	 * @return	Conexion
	 *		  	Valor del atributo objConexion devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	15/09/2017
	 */
	public Conexion getObjConexion ()
		throws Exception
	{
		if	(	this.objConexion	==	null	)
		{
			this.objConexion	=	new Conexion(this.getStrParametrosPARAMEMPWS ());
		}
		
		return objConexion;
	}

	/**
	 * @method	setObjConexion
	 * 		  	Metodo set del atributo objConexion
	 * @param	pObjConexion
	 * 			Valor que tomara el atributo objConexion
	 * @author	hector.cuenca
	 * @date	15/09/2017
	 */
	public void setObjConexion (Conexion pObjConexion)
	{
		this.objConexion = pObjConexion;
	}
}
