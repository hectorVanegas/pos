package co.com.codesa.clienteposslimgiros.interfaces.genericas;

/** 
 * ********************************************************************
 * @class  	PropiedadesPanelCodigoDescripcion
 *		   	Interface que describe el conjunto de operaciones disponibles
 *		   	a traves del componente generico que representa la informacion
 *			basica de un objeto o entidad 
 * @author 	hector.cuenca
 * @date   	3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public interface PropiedadesPanelCodigoDescripcion{
	
	/** 
	 * ********************************************************************
	 * @method 	limpiarCampos
	 * 		   	Metodo que permite restablecer o limpiar el contenido de 
	 * 			los componentes graficos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	3/05/2017
	 * *********************************************************************
	 */
	public void limpiarCampos	()
			throws Exception;
	
	/** 
	 * ********************************************************************
	 * @method 	asignarDatos
	 * 		   	Metodo que permite realizar la asignacion de los datos basicos
	 * 			de la entidad u objeto de interes a representar
	 * @param 	pStrCodigo
	 * 			Codigo de la entidad u objeto que se representara
	 * @param 	pStrDescripcion
	 * 			Descripcion de la entidad u objeto que se representara
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	3/05/2017
	 * *********************************************************************
	 */
	public void asignarDatos	(	String pStrCodigo,
									String pStrDescripcion
								)
										throws Exception;
}
