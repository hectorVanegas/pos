package co.com.codesa.clienteposslimgiros.interfaces.promocion;

import java.util.HashMap;

import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Promocion;

/**
 * 
 * ********************************************************************
 * @class  	IOperacionesPromocion
 *		   	Interface que describe el conjunto de operaciones disponibles
 *			a traves del mecanismo que gestiona las promociones
 * @author 	hector.cuenca
 * @date   	7/12/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface IOperacionesPromocion {
	
	/**
	 * ********************************************************************
	 * @method	adicionarPromociones
	 * 		   	Metodo que permite adicionar las promociones al contenedor
	 * 			dedicado para gestionar su diligenciamiento
	 * @param 	pHmPromociones
	 * 			Listado de promociones indexado por ID, que se cargara sobre
	 * 			la grilla dedicada para su despliegue y diligenciamiento
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	public void adicionarPromociones(	HashMap<String,Promocion> pHmPromociones	)	throws	Exception;
	
	/**
	 * ********************************************************************
	 * @method 	validarPromocionesDiligenciadas
	 * 		   	Metodo que permite validar las promociones diligenciadas
	 * @param 	pBooGenerarExcepcion
	 * 			Bandera que permite identificar si la validacion de las 
	 * 			promociones diligenciadas, en caso de encontrar una 
	 * 			irregularidad, debe producir una excepcion o retornar una
	 * 			bandera false al respecto
	 * @return	boolean
	 * 			Bandera que notifica el resultado del proceso de validacion
	 * 			de las promociones diligenciadas
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	public	boolean	validarPromocionesDiligenciadas	(	boolean pBooGenerarExcepcion	)	throws 	Exception;
	
	/**
	 * ********************************************************************
	 * @method 	limpiarPromociones
	 * 		   	Metodo que permite restablecer (limpiar), el contenedor de
	 * 			promociones, re-inicializando todo su despliegue
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	public	void	limpiarPromociones	()	throws	Exception;
}

