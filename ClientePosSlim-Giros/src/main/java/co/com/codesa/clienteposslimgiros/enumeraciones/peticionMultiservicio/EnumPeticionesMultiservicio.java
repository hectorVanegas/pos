package co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ServicioPeticion;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ********************************************************************
 * @class	EnumPeticionesMultiservicio
 *		  	Clase enumerador, que permite administrar de forma diciente 
 * 		  	los diferentes tipos de peticiones multiservicio implementadas
 * @author 	hector.cuenca
 * @date 	15/09/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public enum EnumPeticionesMultiservicio 
{
	//Biometria Multiservicio
	
	/**
	 * @variable 	BMS_VALIDAR_TERCERO
	 * 			 	Constante que identifica el servicio de validar tercero hacia
	 * 				el sistema biometria multiservicio
	 */
	BMS_VALIDAR_TERCERO	(	EnumParametrosSistema.SERVICIO_VALIDAR_TERCERO_BMS,
							EnumEtiquetas.NOMB_PMS_SERVICIO_VALIDAR_TERCERO_BMS
						),
						
	/**
	 * @variable 	BMS_ENROLAR_HUELLA
	 * 			 	Constante que identifica el servicio de enrolar huella hacia
	 * 				el sistema biometria multiservicio
	 */
	BMS_ENROLAR_HUELLA	(	EnumParametrosSistema.SERVICIO_ENROLAR_HUELLA_BMS,
							EnumEtiquetas.NOMB_PMS_SERVICIO_ENROLAR_HUELLA_BMS
						),
	
	/**
	 * @variable 	BMS_SOLICITAR_HUELLA
	 * 			 	Constante que identifica el servicio de solicitar huella hacia
	 * 				el sistema biometria multiservicio
	 */
	BMS_SOLICITAR_HUELLA	(	EnumParametrosSistema.SERVICIO_SOLICITAR_HUELLA_BMS,
								EnumEtiquetas.NOMB_PMS_SERVICIO_SOLICITAR_HUELLA_BMS
							),
	
	/**
	 * @variable 	BMS_TRANSMITIR_ARCHIVO
	 * 			 	Constante que identifica el servicio de transmitir archivo hacia
	 * 				el sistema biometria multiservicio
	 */
	BMS_TRANSMITIR_ARCHIVO	(	EnumParametrosSistema.SERVICIO_TRANSMITIR_ARCHIVO_BMS,
								EnumEtiquetas.NOMB_PMS_SERVICIO_TRANSMITIR_ARCHIVO_BMS
							),
	
	/**
	 * @variable 	BMS_AUTORIZAR_TERCERO
	 * 			 	Constante que identifica el servicio de transmitir archivo hacia
	 * 				el sistema biometria multiservicio
	 */
	BMS_AUTORIZAR_TERCERO	(	EnumParametrosSistema.SERVICIO_AUTORIZAR_TERCERO_BMS,
								EnumEtiquetas.NOMB_PMS_SERVICIO_AUTORIZAR_TERCERO_BMS
							),
							
	//Giros internacionales
	/**
	 * @variable	GIN_CONSULTAR_CORRESPONSALES
	 * 				Contante que identifica la consulta de corresponsales en FPISA
	 */
	GIN_CONSULTAR_CORRESPONSALES(EnumParametrosSistema.FPISA_CODIGO_CORRESPONSSALES,
								 EnumEtiquetas.FPISA_CODIGO_CORRESPONSSALES),
	
	/**
	 * @variable	GIN_CONSULTAR_TIPO_DOCUMENTOS
	 * 				Contante que identifica la consulta de tipos de documentos en FPISA
	 */
	GIN_CONSULTAR_TIPO_DOCUMENTOS(EnumParametrosSistema.FPISA_CODIGO_TIPO_DOCUMENTOS,
								  EnumEtiquetas.FPISA_CODIGO_TIPO_DOCUMENTOS),
	
	/**
	 * @variable	GIN_CONSULTAR_ACTIVIDADES_ECONOMICAS
	 * 				Contante que identifica la consulta de actividades economicas en FPISA
	 */
	GIN_CONSULTAR_ACTIVIDADES_ECONOMICAS(EnumParametrosSistema.FPISA_CODIGO_ACTIVIDADES_ECONOMICAS,
								         EnumEtiquetas.FPISA_CODIGO_ACTIVIDADES_ECONOMICAS),
	
	/**
	 * @variable	GIN_CONSULTAR_PROFESIONES
	 * 				Contante que identifica la consulta de profesiones en FPISA
	 */
	GIN_CONSULTAR_PROFESIONES(EnumParametrosSistema.FPISA_CODIGO_PROFESIONES,
							  EnumEtiquetas.FPISA_CODIGO_PROFESIONES),
	
	/**
	 * @variable	GIN_CONSULTAR_PAISES
	 * 				Contante que identifica la consulta de paises en FPISA
	 */
	GIN_CONSULTAR_PAISES(EnumParametrosSistema.FPISA_CODIGO_PAISES,
						 EnumEtiquetas.FPISA_CODIGO_PAISES),
						 
	/**
	 * @variable	GIN_CONSULTAR_PAISES_ENVIO
	 * 				Contante que identifica la consulta de paises envio en FPISA
	 */
	GIN_CONSULTAR_PAISES_ENVIO(EnumParametrosSistema.FPISA_CODIGO_PAISES_ENVIO,
						   	   EnumEtiquetas.FPISA_CODIGO_PAISES_ENVIO),
	
   	/**
   	 * @variable	GIN_CONSULTAR_DEPARTAMENTOS
   	 * 				Contante que identifica la consulta de paises en FPISA
   	 */
   	GIN_CONSULTAR_DEPARTAMENTOS(EnumParametrosSistema.FPISA_CODIGO_DEPARTAMENTOS,
   						 		EnumEtiquetas.FPISA_CODIGO_DEPARTAMENTOS),
						   	   
	/**
	 * @variable	GIN_CONSULTAR_CIUDADES
	 * 				Contante que identifica la consulta de ciudades en FPISA
	 */
	GIN_CONSULTAR_CIUDADES(EnumParametrosSistema.FPISA_CODIGO_CIUDADES,
						   EnumEtiquetas.FPISA_CODIGO_CIUDADES),
	
	/**
	 * @variable	GIN_CONSULTAR_TIPOS_MOTIVOS_GIROS
	 * 				Contante que identifica la consulta de tipos motivos giros en FPISA
	 */
	GIN_CONSULTAR_TIPOS_MOTIVOS_GIROS(EnumParametrosSistema.FPISA_CODIGO_TIPOS_MOTIVOS_GIROS,
						   			  EnumEtiquetas.FPISA_CODIGO_TIPOS_MOTIVOS_GIROS),
	
	/**
	 * @variable	GIN_CONSULTAR_NUMERALES_ENVIO
	 * 				Contante que identifica la consulta de numerales envio en FPISA
	 */
	GIN_CONSULTAR_NUMERALES_ENVIO(EnumParametrosSistema.FPISA_CODIGO_NUMERALES_ENVIO,
						   	      EnumEtiquetas.FPISA_CODIGO_NUMERALES_ENVIO),
	
	/**
	 * @variable	GIN_CONSULTAR_NUMERALES_PAGO
	 * 				Contante que identifica la consulta de numerales pago en FPISA
	 */
	GIN_CONSULTAR_NUMERALES_PAGO(EnumParametrosSistema.FPISA_CODIGO_NUMERALES_PAGO,
						   	     EnumEtiquetas.FPISA_CODIGO_NUMERALES_PAGO),
	
	
	/**
	 * @variable	GIN_CONSULTAR_SENALES_ALERTA
	 * 				Contante que identifica la consulta de senales alerta en FPISA
	 */
	GIN_CONSULTAR_SENALES_ALERTA(EnumParametrosSistema.FPISA_CODIGO_SENALES_ALERTA,
						   	     EnumEtiquetas.FPISA_CODIGO_SENALES_ALERTA),
	
	/**
	 * @variable	GIN_REGISTRAR_RECLAMOS
	 * 				Contante que identifica el registro de reclamos en FPISA
	 */
	GIN_REGISTRAR_RECLAMOS(EnumParametrosSistema.FPISA_CODIGO_GESTION_RECLAMOS,
						   			    EnumEtiquetas.FPISA_CODIGO_GESTION_RECLAMOS),
	
	/**
	 * @variable	GIN_CONSULTAR_GIRO_REFERENCIA
	 * 				Contante que identifica la consulta de giro por referencia en FPISA
	 */
	GIN_CONSULTAR_GIRO_REFERENCIA(EnumParametrosSistema.FPISA_CODIGO_CONSULTA_GIRO_X_REFERENCIA,
						   		  EnumEtiquetas.FPISA_CODIGO_CONSULTA_GIRO_X_REFERENCIA),
	
	/**
	 * @variable	GIN_CONSULTAR_GIRO_BENEFICIARIO
	 * 				Contante que identifica la consulta de giro por beneficiario en FPISA
	 */
	GIN_CONSULTAR_GIRO_BENEFICIARIO(EnumParametrosSistema.FPISA_CODIGO_CONSULTA_GIRO_X_BENEFICIARIO,
						   		  	EnumEtiquetas.FPISA_CODIGO_CONSULTA_GIRO_X_BENEFICIARIO),
						   		  
	 /**
	 * @variable	GIN_CONSULTAR_TERCERO
	 * 				Contante que identifica la consulta de un tercero en FPISA 
	 */
	GIN_CONSULTAR_TERCERO	(	EnumParametrosSistema.FPISA_CODIGO_CONSULTA_TERCERO,
						   		EnumEtiquetas.FPISA_CODIGO_CONSULTA_TERCERO
						   	),
						   	
    /**
	 * @variable	GIN_PAGO_GIRO
	 * 				Contante que identifica la consulta de un tercero en FPISA 
	 */
	GIN_PAGO_GIRO	(EnumParametrosSistema.FPISA_CODIGO_PAGO_GIRO,
				   	 EnumEtiquetas.FPISA_CODIGO_PAGO_GIRO),
				   	 
   	/**
 	 * @variable	GIN_ENVIO_GIRO
 	 * 				Contante que identifica el enviode una remesa en FPISA 
 	 */
 	GIN_ENVIO_GIRO	(EnumParametrosSistema.FPISA_CODIGO_ENVIO_GIRO,
 				   	 EnumEtiquetas.FPISA_CODIGO_ENVIO_GIRO),
						   		  	
	
	
	/**
	 * @variable	GIN_CREAR_ACTUALIZAR_TERCERO_USUARIO
	 * 				Contante que identifica la creacion o actualizacion de un tercero usuario en FPISA 
	 */
	GIN_CREAR_ACTUALIZAR_TERCERO_USUARIO	(	EnumParametrosSistema.FPISA_CREAR_ACTUALIZAR_TERCERO_USUARIO,
						   						EnumEtiquetas.FPISA_CODIGO_CREAR_ACTUALIZAR_TERCERO_USUARIO
						   					),
						   			
	/**
	 * @variable	GIN_CREAR_ACTUALIZAR_TERCERO
	 * 				Contante que identifica la creacion o actualizacion de un tercero cliente en FPISA 
	 */
	GIN_CREAR_ACTUALIZAR_TERCERO_CLIENTE	(	EnumParametrosSistema.FPISA_CREAR_ACTUALIZAR_TERCERO_CLIENTE,
						   						EnumEtiquetas.FPISA_CODIGO_CREAR_ACTUALIZAR_TERCERO_CLIENTE
						   					),
	
	/**
	 * @variable	GIN_COTIZAR_GIRO
	 * 				Constante que identifica la cotizacion de un giro internacional 
	 */
    GIN_COTIZAR_GIRO(EnumParametrosSistema.FPISA_CODIGO_COTIZAR_GIRO,
					 EnumEtiquetas.FPISA_CODIGO_COTIZAR_GIRO),
					 
	/**
	 * @variable	GIN_REIMPRESION_INTERNACIONAL
	 * 				Constante que identifica la cotizacion de un giro internacional 
	 */
	GIN_REIMPRESION_INTERNACIONAL(EnumParametrosSistema.FPISA_REIMPRESION_INTERNACIONAL,
								  EnumEtiquetas.FPISA_CODIGO_REIMPRESION_INTERNACIONAL),
								  
	GIN_OPERACIONES_INUSUALES(EnumParametrosSistema.FPISA_CODIGO_OPERACIONES_INUSUALES,
							  EnumEtiquetas.FPISA_CODIGO_OPERACIONES_INUSUALES),
						   	
						   	
	;
	/**
	 * @variable 	pEnmParSisServicioPeticion
	 * 			 	Parametro de sistema que contiene la especificacion para 
	 * 				obtener el codigo del servicio de una peticion bajo el
	 * 				concepto multiservicio
	 */
	private EnumParametrosSistema enmParSisServicioPeticion;
	
	/**
	 * @variable 	enmEtiNombreServicio
	 * 			 	Constante enumerador que maneja la etiqueta o nombre del 
	 * 				servicio
	 */
	private EnumEtiquetas enmEtiNombreServicio;
	
	/**
	 * @variable 	objServicioPeticion
	 * 			 	objeto que especifica el servicio de una peticion bajo el 
	 * 				concepto multiservicio
	 */
	private ServicioPeticion objServicioPeticion;
	
	/**
	 * ********************************************************************
	 * @method 	EnumPeticionesMultiservicio
	 * 		   	Inicializacion de la constante de enumeracion
	 * @param 	pEnmParSisServicioPeticion
	 * 		  	Parametro de sistema que contiene la especificacion para 
	 * 			obtener el codigo del servicio de una peticion bajo el
	 * 			concepto multiservicio
	 * @param   pEnmEtiNombreServicio
	 * 		    Enumerador de etiquetas con el nombre del servicio a consultar
	 * @author 	hector.cuenca
	 * @date 	15/09/2017
	 * *********************************************************************
	 */
	private EnumPeticionesMultiservicio	(	EnumParametrosSistema pEnmParSisServicioPeticion,
											EnumEtiquetas pEnmEtiNombreServicio
										)
	{
		this.setpEnmParSisServicioPeticion(pEnmParSisServicioPeticion);
		this.setEnmEtiNombreServicio(pEnmEtiNombreServicio);
	}

	/**
	 * @method	getpEnmParSisServicioPeticion
	 * 		  	Metodo get del atributo enmParSisServicioPeticion
	 * @return	EnumParametrosSistema
	 *		  	Valor del atributo enmParSisServicioPeticion devuelto
	 * @author	hector.cuenca
	 * @date  	15/09/2017
	 */
	public EnumParametrosSistema getpEnmParSisServicioPeticion ()
	{
		return this.enmParSisServicioPeticion;
	}

	/**
	 * @method	setpEnmParSisServicioPeticion
	 * 		  	Metodo set del atributo enmParSisServicioPeticion
	 * @param	pPEnmParSisServicioPeticion
	 * 			Valor que tomara el atributo enmParSisServicioPeticion
	 * @author	hector.cuenca
	 * @date	15/09/2017
	 */
	public void setpEnmParSisServicioPeticion (EnumParametrosSistema pPEnmParSisServicioPeticion)
	{
		this.enmParSisServicioPeticion = pPEnmParSisServicioPeticion;
	}

	/**
	 * @method	getObjServicioPeticion
	 * 		  	Metodo get del atributo objServicioPeticion
	 * @return	ServicioPeticion
	 *		  	Valor del atributo objServicioPeticion devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	15/09/2017
	 */
	public ServicioPeticion getObjServicioPeticion ()
			throws Exception
	{
		ParametroSistema objParametroSistema;
		
		if	(	this.objServicioPeticion	==	null	)	
		{
			objParametroSistema	=	UtilParametrosSistema.getInstance().consultar(this.getpEnmParSisServicioPeticion());
			this.objServicioPeticion	=	new ServicioPeticion	(	objParametroSistema.getValor(),
																		this.getEnmEtiNombreServicio().toString()
																	);
			this.objServicioPeticion.setStrLocalIp(UtilidadGiros.getInstancia().obtenerDireccionIp());
		}
		
		return this.objServicioPeticion;
	}
	
	public ServicioPeticion getObjServicioPeticionSinThrows()
	{	
		ServicioPeticion objServicioPeticion;
		
		try{
			objServicioPeticion = this.getObjServicioPeticion();
		}catch(Exception e){
			objServicioPeticion = null;
		}
		
		return objServicioPeticion;
	}

	/**
	 * @method	setObjServicioPeticion
	 * 		  	Metodo set del atributo objServicioPeticion
	 * @param	pObjServicioPeticion
	 * 			Valor que tomara el atributo objServicioPeticion
	 * @author	hector.cuenca
	 * @date	15/09/2017
	 */
	public void setObjServicioPeticion(ServicioPeticion pObjServicioPeticion) {
		this.objServicioPeticion = pObjServicioPeticion;
	}

	/**
	 * @method	getEnmEtiNombreServicio
	 * 		  	Metodo get del atributo enmEtiNombreServicio
	 * @return	EnumEtiquetas
	 *		  	Valor del atributo enmEtiNombreServicio devuelto
	 * @author	hector.cuenca
	 * @date  	15/09/2017
	 */
	public EnumEtiquetas getEnmEtiNombreServicio() {
		return enmEtiNombreServicio;
	}

	/**
	 * @method	setEnmEtiNombreServicio
	 * 		  	Metodo set del atributo enmEtiNombreServicio
	 * @param	pEnmEtiNombreServicio
	 * 			Valor que tomara el atributo enmEtiNombreServicio
	 * @author	hector.cuenca
	 * @date	15/09/2017
	 */
	public void setEnmEtiNombreServicio(EnumEtiquetas pEnmEtiNombreServicio) {
		this.enmEtiNombreServicio = pEnmEtiNombreServicio;
	}
	
	
}
