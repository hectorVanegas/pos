package co.com.codesa.clienteposslimgiros.dto.direccion;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;

/**
 * ********************************************************************
 * @class	ConfigDireccionDTO
 *		 	Clase DTO encargada de almacenar toda la configuracion 
 *			relacionada con el formulario para diligenciar la direccion
 * @author	hector.cuenca
 * @date  	21/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ConfigDireccionDTO {

	/**
	 * FALTA X CONFIGURAR
	 * 	EXP_REG_FORMATO_DIR_CLASE_VIA
	 * 	EXP_REG_FORMATO_DIR_ZONA
	 * 	EXP_REG_FORMATO_DIR_CARACTERISTICA_LUGAR
	 * 	EXP_REG_FORMATO_DIR_ESTRATO
	 */
	
	/**
	 * @variable	strEntLstClaseVia
	 * 				Especifica el codigo de la entidad configurada en direcciones.xml, sobre
	 * 				la cual se especifican los valores asociados a la clase de via
	 */
	private String strEntLstClaseVia;
	
	/**
	 * @variable	strEntLstSectoresUbicacion
	 * 				Especifica el codigo de la entidad configurada en direcciones.xml, sobre
	 * 				la cual se especifican los valores asociados a los sectores de una ubicacion
	 */
	private String strEntLstSectoresUbicacion;
	
	/**
	 * @variable	strEntLstCaracteristicasLugar
	 * 				Especifica el codigo de la entidad configurada en direcciones.xml, sobre
	 * 				la cual se especifican los valores asociados a las caracteristicas de un lugar
	 */
	private String strEntLstCaracteristicasLugar;
	
	/**
	 * @variable	strEntLstEstratosBarrio
	 * 				Especifica el codigo de la entidad configurada en direcciones.xml, sobre
	 * 				la cual se especifican los valores asociados a los estratos del barrio
	 */
	private String strEntLstEstratosBarrio;
	
	/**
	 * @variable	booHabilitarUbicacion
	 * 				Bandera que permite colocar como disponible la seccion de ubicacion sobre el 
	 * 				formulario para diligenciar la direccion
	 */
	private boolean booHabilitarUbicacion = true;
	
	/**
	 * @variable	booHabilitarLugar
	 * 				Bandera que permite colocar como disponible la seccion de lugar sobre el formulario
	 * 				para diligenciar la direccion
	 */
	private boolean booHabilitarLugar = true;
	
	/**
	 * @variable	enmExpRegCtrlFrmDireccionCompleto
	 * 				Expresion que permite controlar el formato completo de una direccion
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmDireccionCompleto;
	
	/**
	 * @variable	enmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * 				Expresion que permite controlar el formato de ingreso para la caja de texto que
	 * 				representa la especificacion abierta
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmIngresoEspecificacionAbierta;
	
	/**
	 * @variable	enmExpRegCtrlFrmFinalEspecificacionAbierta
	 * 				Expresion que permite controlar el formato final para la caja de texto que
	 * 				representa la especificacion abierta
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmFinalEspecificacionAbierta;
	
	/**
	 * @variable	enmExpRegCtrlFrmIngresoNumeroVia
	 * 				Expresion que permite controlar el formato de ingreso para la caja de texto que
	 * 				representa el numero de via en la direccion tradicional
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmIngresoNumeroVia;
	
	/**
	 * @variable	enmExpRegCtrlFrmIngresoNumeroInterseccion
	 * 				Expresion que permite controlar el formato de ingreso para la caja de texto que
	 * 				representa el numero de interseccion en la direccion tradicional
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmIngresoNumeroInterseccion;
	
	/**
	 * @variable	enmExpRegCtrlFrmIngresoNumeroLugar
	 * 				Expresion que permite controlar el formato de ingreso para la caja de texto que
	 * 				representa el numero de lugar en la direccion tradicional
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmIngresoNumeroLugar;
	
	/**
	 * @variable	enmExpRegCtrlFrmIngresoEspecificacionLugar
	 * 				Expresion que permite controlar el formato de ingreso para la caja de texto que
	 * 				representa la especificacion del lugar
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmIngresoEspecificacionLugar;
	
	/**
	 * @variable	enmExpRegCtrlFrmIngresoNombreBarrio
	 * 				Expresion que permite controlar el formato de ingreso para la caja de texto que
	 * 				representa el nombre del barrio
	 */
	private EnumExpresionesRegulares enmExpRegCtrlFrmIngresoNombreBarrio;
	
	
	/** 
	 * ********************************************************************
	 * @method ConfigDireccionDTO
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto DTO
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public ConfigDireccionDTO() {
		
		super();
	}

	/**
	 * @method	getStrEntLstClaseVia
	 * 		  	Metodo get del atributo strEntLstClaseVia
	 * @return	String
	 *		  	Valor del atributo strEntLstClaseVia devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public String getStrEntLstClaseVia() {
		
		if	(	this.strEntLstClaseVia	==	null	)
		{
			this.strEntLstClaseVia = EnumParametrosApp.ENT_DIRECCION_CLASES_VIA.getValorPropiedad();
		}
		
		return strEntLstClaseVia;
	}

	/**
	 * @method	setStrEntLstClaseVia
	 * 		  	Metodo set del atributo strEntLstClaseVia
	 * @param	pStrEntLstClaseVia
	 * 			Valor que tomara el atributo strEntLstClaseVia
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setStrEntLstClaseVia(String pStrEntLstClaseVia) {
		this.strEntLstClaseVia = pStrEntLstClaseVia;
	}

	/**
	 * @method	getStrEntLstSectoresUbicacion
	 * 		  	Metodo get del atributo strEntLstSectoresUbicacion
	 * @return	String
	 *		  	Valor del atributo strEntLstSectoresUbicacion devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public String getStrEntLstSectoresUbicacion() {
		
		if	(	this.strEntLstSectoresUbicacion	==	null	)
		{
			this.strEntLstSectoresUbicacion = EnumParametrosApp.ENT_DIRECCION_SECTORES_UBICACION.getValorPropiedad();
		}
		
		return strEntLstSectoresUbicacion;
	}

	/**
	 * @method	setStrEntLstSectoresUbicacion
	 * 		  	Metodo set del atributo strEntLstSectoresUbicacion
	 * @param	pStrEntLstSectoresUbicacion
	 * 			Valor que tomara el atributo strEntLstSectoresUbicacion
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setStrEntLstSectoresUbicacion(
			String pStrEntLstSectoresUbicacion) {
		this.strEntLstSectoresUbicacion = pStrEntLstSectoresUbicacion;
	}

	/**
	 * @method	getStrEntLstCaracteristicasLugar
	 * 		  	Metodo get del atributo strEntLstCaracteristicasLugar
	 * @return	String
	 *		  	Valor del atributo strEntLstCaracteristicasLugar devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public String getStrEntLstCaracteristicasLugar() {
		
		if	(	this.strEntLstCaracteristicasLugar	==	null	)
		{
			this.strEntLstCaracteristicasLugar = EnumParametrosApp.ENT_DIRECCION_CARACTERISTICAS_LUGAR.getValorPropiedad();
		}
		
		return strEntLstCaracteristicasLugar;
	}

	/**
	 * @method	setStrEntLstCaracteristicasLugar
	 * 		  	Metodo set del atributo strEntLstCaracteristicasLugar
	 * @param	pStrEntLstCaracteristicasLugar
	 * 			Valor que tomara el atributo strEntLstCaracteristicasLugar
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setStrEntLstCaracteristicasLugar(
			String pStrEntLstCaracteristicasLugar) {
		this.strEntLstCaracteristicasLugar = pStrEntLstCaracteristicasLugar;
	}

	/**
	 * @method	getStrEntLstEstratosBarrio
	 * 		  	Metodo get del atributo strEntLstEstratosBarrio
	 * @return	String
	 *		  	Valor del atributo strEntLstEstratosBarrio devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public String getStrEntLstEstratosBarrio() {
		
		if	(	this.strEntLstEstratosBarrio	==	null	)
		{
			this.strEntLstEstratosBarrio = EnumParametrosApp.ENT_DIRECCION_ESTRATOS_BARRIO.getValorPropiedad();
		}
		
		return strEntLstEstratosBarrio;
	}

	/**
	 * @method	setStrEntLstEstratosBarrio
	 * 		  	Metodo set del atributo strEntLstEstratosBarrio
	 * @param	pStrEntLstEstratosBarrio
	 * 			Valor que tomara el atributo strEntLstEstratosBarrio
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setStrEntLstEstratosBarrio(String pStrEntLstEstratosBarrio) {
		this.strEntLstEstratosBarrio = pStrEntLstEstratosBarrio;
	}

	/**
	 * @method	isBooHabilitarUbicacion
	 * 		  	Metodo get del atributo booHabilitarUbicacion
	 * @return	boolean
	 *		  	Valor del atributo booHabilitarUbicacion devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public boolean isBooHabilitarUbicacion() {
		return booHabilitarUbicacion;
	}

	/**
	 * @method	setBooHabilitarUbicacion
	 * 		  	Metodo set del atributo booHabilitarUbicacion
	 * @param	pBooHabilitarUbicacion
	 * 			Valor que tomara el atributo booHabilitarUbicacion
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setBooHabilitarUbicacion(boolean pBooHabilitarUbicacion) {
		this.booHabilitarUbicacion = pBooHabilitarUbicacion;
	}

	/**
	 * @method	isBooHabilitarLugar
	 * 		  	Metodo get del atributo booHabilitarLugar
	 * @return	boolean
	 *		  	Valor del atributo booHabilitarLugar devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public boolean isBooHabilitarLugar() {
		return booHabilitarLugar;
	}

	/**
	 * @method	setBooHabilitarLugar
	 * 		  	Metodo set del atributo booHabilitarLugar
	 * @param	pBooHabilitarLugar
	 * 			Valor que tomara el atributo booHabilitarLugar
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setBooHabilitarLugar(boolean pBooHabilitarLugar) {
		this.booHabilitarLugar = pBooHabilitarLugar;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmIngresoNumeroVia
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmIngresoNumeroVia
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmIngresoNumeroVia devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmIngresoNumeroVia() {
		
		if	(	this.enmExpRegCtrlFrmIngresoNumeroVia	==	null	)
		{
			this.enmExpRegCtrlFrmIngresoNumeroVia = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_VIA;
		}
		
		return enmExpRegCtrlFrmIngresoNumeroVia;
	}

	/**
	 * @method	setEnmExpRegCtrFrmIngresoNumeroVia
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmIngresoNumeroVia
	 * @param	pEnmExpRegCtrlFrmIngresoNumeroVia
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmIngresoNumeroVia
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrFrmIngresoNumeroVia(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmIngresoNumeroVia) {
		this.enmExpRegCtrlFrmIngresoNumeroVia = pEnmExpRegCtrlFrmIngresoNumeroVia;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmIngresoNumeroInterseccion
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmIngresoNumeroInterseccion
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmIngresoNumeroInterseccion devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmIngresoNumeroInterseccion() {
		
		if	(	this.enmExpRegCtrlFrmIngresoNumeroInterseccion	==	null	)
		{
			this.enmExpRegCtrlFrmIngresoNumeroInterseccion = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_INTERSECCION;
		}
		
		return enmExpRegCtrlFrmIngresoNumeroInterseccion;
	}

	/**
	 * @method	setEnmExpRegCtrlFrmIngresoNumeroInterseccion
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmIngresoNumeroInterseccion
	 * @param	pEnmExpRegCtrlFrmIngresoNumeroInterseccion
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmIngresoNumeroInterseccion
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmIngresoNumeroInterseccion(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmIngresoNumeroInterseccion) {
		this.enmExpRegCtrlFrmIngresoNumeroInterseccion = pEnmExpRegCtrlFrmIngresoNumeroInterseccion;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmIngresoNumeroLugar
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmIngresoNumeroLugar
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmIngresoNumeroLugar devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmIngresoNumeroLugar() {
		
		if	(	this.enmExpRegCtrlFrmIngresoNumeroLugar	==	null	)
		{
			this.enmExpRegCtrlFrmIngresoNumeroLugar = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_LUGAR;
		}
		
		return enmExpRegCtrlFrmIngresoNumeroLugar;
	}

	/**
	 * @method	setEnmExpRegCtrlFrmIngresoNumeroLugar
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmIngresoNumeroLugar
	 * @param	pEnmExpRegCtrlFrmIngresoNumeroLugar
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmIngresoNumeroLugar
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmIngresoNumeroLugar(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmIngresoNumeroLugar) {
		this.enmExpRegCtrlFrmIngresoNumeroLugar = pEnmExpRegCtrlFrmIngresoNumeroLugar;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmIngresoEspecificacionLugar
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmIngresoEspecificacionLugar
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmIngresoEspecificacionLugar devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmIngresoEspecificacionLugar() {
		
		if	(	this.enmExpRegCtrlFrmIngresoEspecificacionLugar	==	null	)
		{
			this.enmExpRegCtrlFrmIngresoEspecificacionLugar = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ESPECIFICACION_LUGAR;
		}
		
		return enmExpRegCtrlFrmIngresoEspecificacionLugar;
	}

	/**
	 * @method	setEnmExpRegCtrlFrmIngresoEspecificacionLugar
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmIngresoEspecificacionLugar
	 * @param	pEnmExpRegCtrlFrmIngresoEspecificacionLugar
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmIngresoEspecificacionLugar
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmIngresoEspecificacionLugar(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmIngresoEspecificacionLugar) {
		this.enmExpRegCtrlFrmIngresoEspecificacionLugar = pEnmExpRegCtrlFrmIngresoEspecificacionLugar;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmIngresoNombreBarrio
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmIngresoNombreBarrio
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmIngresoNombreBarrio devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmIngresoNombreBarrio() {
		
		if	(	this.enmExpRegCtrlFrmIngresoNombreBarrio	==	null	)
		{
			this.enmExpRegCtrlFrmIngresoNombreBarrio = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_NOMBRE_BARRIO;
		}
		
		return enmExpRegCtrlFrmIngresoNombreBarrio;
	}

	/**
	 * @method	setEnmExpRegControlFormatoIngresoNombreBarrio
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmIngresoNombreBarrio
	 * @param	pEnmExpRegControlFormatoIngresoNombreBarrio
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmIngresoNombreBarrio
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmIngresoNombreBarrio(
			EnumExpresionesRegulares pEnmExpRegControlFormatoIngresoNombreBarrio) {
		this.enmExpRegCtrlFrmIngresoNombreBarrio = pEnmExpRegControlFormatoIngresoNombreBarrio;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmIngresoEspecificacionAbierta devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmIngresoEspecificacionAbierta() {
		
		if	(	this.enmExpRegCtrlFrmIngresoEspecificacionAbierta	==	null	)
		{
			this.enmExpRegCtrlFrmIngresoEspecificacionAbierta = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ESPECIFICACION_ABIERTA;
		}
		
		return enmExpRegCtrlFrmIngresoEspecificacionAbierta;
	}

	/**
	 * @method	setEnmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * @param	pEnmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmIngresoEspecificacionAbierta
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmIngresoEspecificacionAbierta(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmIngresoEspecificacionAbierta) {
		this.enmExpRegCtrlFrmIngresoEspecificacionAbierta = pEnmExpRegCtrlFrmIngresoEspecificacionAbierta;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmFinalEspecificacionAbierta
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmFinalEspecificacionAbierta
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmFinalEspecificacionAbierta devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmFinalEspecificacionAbierta() {
		
		if	(	this.enmExpRegCtrlFrmFinalEspecificacionAbierta	==	null	)
		{
			this.enmExpRegCtrlFrmFinalEspecificacionAbierta = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ESPECIFICACION_ABIERTA_FINAL;
		}
		
		return enmExpRegCtrlFrmFinalEspecificacionAbierta;
	}

	/**
	 * @method	setEnmExpRegCtrlFrmFinalEspecificacionAbierta
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmFinalEspecificacionAbierta
	 * @param	pEnmExpRegCtrlFrmFinalEspecificacionAbierta
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmFinalEspecificacionAbierta
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmFinalEspecificacionAbierta(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmFinalEspecificacionAbierta) {
		this.enmExpRegCtrlFrmFinalEspecificacionAbierta = pEnmExpRegCtrlFrmFinalEspecificacionAbierta;
	}

	/**
	 * @method	getEnmExpRegCtrlFrmDireccionCompleto
	 * 		  	Metodo get del atributo enmExpRegCtrlFrmDireccionCompleto
	 * @return	EnumExpresionesRegulares
	 *		  	Valor del atributo enmExpRegCtrlFrmDireccionCompleto devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public EnumExpresionesRegulares getEnmExpRegCtrlFrmDireccionCompleto() {
		
		if	(	this.enmExpRegCtrlFrmDireccionCompleto	==	null	)
		{
			this.enmExpRegCtrlFrmDireccionCompleto = EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_COMPLETO;
		}
		
		return enmExpRegCtrlFrmDireccionCompleto;
	}

	/**
	 * @method	setEnmExpRegCtrlFrmDireccionCompleto
	 * 		  	Metodo set del atributo enmExpRegCtrlFrmDireccionCompleto
	 * @param	pEnmExpRegCtrlFrmDireccionCompleto
	 * 			Valor que tomara el atributo enmExpRegCtrlFrmDireccionCompleto
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setEnmExpRegCtrlFrmDireccionCompleto(
			EnumExpresionesRegulares pEnmExpRegCtrlFrmDireccionCompleto) {
		this.enmExpRegCtrlFrmDireccionCompleto = pEnmExpRegCtrlFrmDireccionCompleto;
	}

	
	
}
