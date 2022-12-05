package co.com.codesa.clienteposslimgiros.utilidades.archivo;

import java.io.File;
import java.io.FileOutputStream;

/** 
 * ********************************************************************
 * @class	UtilArchivo
 *		 	Clase utilitaria relacionada con el tratamiento de archivos
 * @author	hector.cuenca
 * @date  	2/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilArchivo {

	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilArchivo instance;

	/**
	 * ********************************************************************
	 * @method UtilArchivo
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   2/04/2018
	 * ********************************************************************
	 */
	private UtilArchivo() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilArchivo
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   2/04/2018
	 * ********************************************************************
	 */
	public static UtilArchivo getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilArchivo();
		}

		return instance;
	}
	
	/**
	 * ********************************************************************
	 * @method	crearArchivo
	 * 		  	Metodo que permite crear el archivo en el sistema, indicado 
	 * 			sobre la ruta, con el nombre especificado, y con su contenido
	 * @param 	pStrNombre
	 * 			Nombre del archivo a crear
	 * @param 	pStrRuta
	 * 			Ruta sobre la cual se llevara a cabo la creacion del archivo
	 * @param 	pStrContenido
	 * 			Detalle o contenido del archivo a grabar
	 * @return	File
	 * 			Archivo creado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date	2/04/2018
	 * *********************************************************************
	 */
	public File crearArchivo(	String pStrNombre, 
								String pStrRuta, 
								String pStrContenido
							)
		throws Exception 
	{
		File objFilarchivo;
		FileOutputStream objFilOutStm	=	null;
		
		try{
			
			objFilarchivo = new File(pStrRuta+System.getProperty("file.separator")+pStrNombre);
			objFilOutStm = new FileOutputStream(objFilarchivo);
			objFilOutStm.write(pStrContenido.getBytes());
			
		}catch(Exception e){
			throw e;
		}finally{
			
			if	(	objFilOutStm	!=	null	)
			{
				objFilOutStm.close();
			}
		}
		
		return objFilarchivo;
	}
	
}
