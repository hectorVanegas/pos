package co.com.codesa.clienteposslimgiros.dto.territorio;

import java.util.TreeMap;

import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlTerritorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;

/**
 * ********************************************************************
 * @class	ConfigTerritorioDTO
 *		 	Clase DTO encargada de almacenar toda la configuracion 
 *			relacionada con el componente generico para determinar un 
 *			territorio (Panel territorio)
 * @author	hector.cuenca
 * @date  	21/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ConfigTerritorioDTO {	
	
	/**
	 * @variable	tmPais
	 * 				Estructura de datos para la administracion de los paises
	 */
	private TreeMap<String, Territorio> tmPais;
	
	/**
	 * @variable	tmDepartamento
	 * 				Estructura de datos para la administracion de los departamentos
	 */
	private TreeMap<String, Territorio> tmDepartamento;
	
	/**
	 * @variable	tmMunicipio
	 * 				Estructura de datos para administracion de los municipios
	 */
	private TreeMap<String, Territorio> tmMunicipio;
	
	/** 
	 * ********************************************************************
	 * @method ConfigTerritorioDTO
	 * 		   Metodo constructor que permite la inicializacion de los 
	 * 		   valores y comportamientos necesarios para la construccion de
	 * 		   este objeto DTO
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public ConfigTerritorioDTO() {
		
		super();
	}

	/**
	 * @method	getTmPais
	 * 		  	Metodo get del atributo tmPais
	 * @return	TreeMap<String,Territorio>
	 *		  	Valor del atributo tmPais devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public TreeMap<String, Territorio> getTmPais() 
			throws Exception
	{
		if	(	this.tmPais	==	null	)
		{
			this.tmPais	=	XmlTerritorio.getInstance().getTmPais();
		}
		
		return tmPais;
	}

	/**
	 * @method	setTmPais
	 * 		  	Metodo set del atributo tmPais
	 * @param	pTmPais
	 * 			Valor que tomara el atributo tmPais
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setTmPais(TreeMap<String, Territorio> pTmPais) {
		this.tmPais = pTmPais;
	}

	/**
	 * @method	getTmDepartamento
	 * 		  	Metodo get del atributo tmDepartamento
	 * @return	TreeMap<String,Territorio>
	 *		  	Valor del atributo tmDepartamento devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public TreeMap<String, Territorio> getTmDepartamento() {
		return tmDepartamento;
	}

	/**
	 * @method	setTmDepartamento
	 * 		  	Metodo set del atributo tmDepartamento
	 * @param	pTmDepartamento
	 * 			Valor que tomara el atributo tmDepartamento
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setTmDepartamento(TreeMap<String, Territorio> pTmDepartamento) {
		this.tmDepartamento = pTmDepartamento;
	}

	/**
	 * @method	getTmMunicipio
	 * 		  	Metodo get del atributo tmMunicipio
	 * @return	TreeMap<String,Territorio>
	 *		  	Valor del atributo tmMunicipio devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public TreeMap<String, Territorio> getTmMunicipio() {
		return tmMunicipio;
	}

	/**
	 * @method	setTmMunicipio
	 * 		  	Metodo set del atributo tmMunicipio
	 * @param	pTmMunicipio
	 * 			Valor que tomara el atributo tmMunicipio
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setTmMunicipio(TreeMap<String, Territorio> pTmMunicipio) {
		this.tmMunicipio = pTmMunicipio;
	}
	
}
