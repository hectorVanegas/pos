package co.com.codesa.clienteposslimgiros.dto.tercero.internacional;

import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;

/** 
 * ********************************************************************
 * @class	ValidarTerceroInternacionalDTO
 *		 	Clase DTO encargada de almacenar todos los parametros y resultados
 *			obtenidos del proceso de validar tercero en las funcionalidades
 *			de giros internacionales
 * @author	hector.cuenca
 * @date  	4/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ValidarTerceroInternacionalDTO {

	/**
	 * @variable	frmForma
	 * 				Forma sobre la cual se esta llevando a cabo el proceso
	 */
	private FormaGenerica frmForma;
	
	/**
	 * @variable	objTercero
	 * 				Tercero al cual se le esta realizando el proceso de validacion
	 */
	private TerceroInternacional objTercero;
	
	/**
	 * @variable	strIdTransaccion
	 * 				Id generado para la transaccion
	 */
	private String strIdTransaccion;
	
	/**
	 * ********************************************************************
	 * @method	ValidarTerceroInternacionalDTO
	 * 		  	Metodo constructor que permite la inicializacion de los 
	 * 		   	valores y comportamientos necesarios para la construccion de
	 * 		   	este objeto DTO
	 * @param 	pFrmForma
	 * 			Forma sobre la cual se esta llevando a cabo el proceso
	 * @param 	pObjTercero
	 * 			Tercero al cual se le esta realizando el proceso de validacion
	 * @param 	pStrIdTransaccion
	 * 			Id generado para la transaccion
	 * @author	hector.cuenca
	 * @date	4/04/2018
	 * *********************************************************************
	 */
	public ValidarTerceroInternacionalDTO(FormaGenerica pFrmForma,
			TerceroInternacional pObjTercero, String pStrIdTransaccion) {
		super();
		this.frmForma = pFrmForma;
		this.objTercero = pObjTercero;
		this.strIdTransaccion = pStrIdTransaccion;
	}

	/**
	 * @method	getFrmForma
	 * 		  	Metodo get del atributo frmForma
	 * @return	FormaGenerica
	 *		  	Valor del atributo frmForma devuelto
	 * @author	hector.cuenca
	 * @date  	4/04/2018
	 */
	public FormaGenerica getFrmForma() {
		return frmForma;
	}

	/**
	 * @method	setFrmForma
	 * 		  	Metodo set del atributo frmForma
	 * @param	pFrmForma
	 * 			Valor que tomara el atributo frmForma
	 * @author	hector.cuenca
	 * @date	4/04/2018
	 */
	public void setFrmForma(FormaGenerica pFrmForma) {
		this.frmForma = pFrmForma;
	}

	/**
	 * @method	getObjTercero
	 * 		  	Metodo get del atributo objTercero
	 * @return	TerceroInternacional
	 *		  	Valor del atributo objTercero devuelto
	 * @author	hector.cuenca
	 * @date  	4/04/2018
	 */
	public TerceroInternacional getObjTercero() {
		return objTercero;
	}

	/**
	 * @method	setObjTercero
	 * 		  	Metodo set del atributo objTercero
	 * @param	pObjTercero
	 * 			Valor que tomara el atributo objTercero
	 * @author	hector.cuenca
	 * @date	4/04/2018
	 */
	public void setObjTercero(TerceroInternacional pObjTercero) {
		this.objTercero = pObjTercero;
	}

	/**
	 * @method	getStrIdTransaccion
	 * 		  	Metodo get del atributo strIdTransaccion
	 * @return	String
	 *		  	Valor del atributo strIdTransaccion devuelto
	 * @author	hector.cuenca
	 * @date  	4/04/2018
	 */
	public String getStrIdTransaccion() {
		return strIdTransaccion;
	}

	/**
	 * @method	setStrIdTransaccion
	 * 		  	Metodo set del atributo strIdTransaccion
	 * @param	pStrIdTransaccion
	 * 			Valor que tomara el atributo strIdTransaccion
	 * @author	hector.cuenca
	 * @date	4/04/2018
	 */
	public void setStrIdTransaccion(String pStrIdTransaccion) {
		this.strIdTransaccion = pStrIdTransaccion;
	}

	
}
