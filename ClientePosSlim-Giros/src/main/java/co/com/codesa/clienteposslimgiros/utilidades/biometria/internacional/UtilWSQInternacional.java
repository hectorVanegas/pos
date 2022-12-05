package co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional;

import java.io.File;
import java.io.FileOutputStream;

import org.jnbis.api.Jnbis;

import spg.bio.Converter;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;


/**
 * ********************************************************************
 * @class	UtilWSQInternacional
 *		 	Clase utilitaria relacionada con las operaciones que involucra
 *			el tratamiento de WSQ internacional 
 * @author	hector.cuenca
 * @date  	3/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilWSQInternacional {
	
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilWSQInternacional instance;

	/**
	 * ********************************************************************
	 * @method UtilWSQInternacional
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/04/2018
	 * ********************************************************************
	 */
	private UtilWSQInternacional() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilWSQInternacional
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   3/04/2018
	 * ********************************************************************
	 */
	public static UtilWSQInternacional getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilWSQInternacional();
		}

		return instance;
	}
	

	public File generarImagenWSQ(	String pStrWsq, 
									String pStrNombreImagen,
									FormaGenerica pFrmGenerica
								)
		throws Exception
	{
		FileOutputStream objFilOutStrImgJpeg = null;
		File objFilDirTransmisionInternacional;
		File objFilImagenWSQ;
		byte[] arrBytDataWsq;
		byte[] arrBytDataImgJpeg;
		
		try{
			objFilDirTransmisionInternacional = InformacionSessionGirosInternacional.getInstance(pFrmGenerica.getObjUsuario()).getObjFilDirectorioCapturaInternacional();
			
			objFilImagenWSQ = new File(objFilDirTransmisionInternacional.getAbsolutePath()+File.separator+pStrNombreImagen);
			
			arrBytDataWsq = new Converter().hexaToByte(pStrWsq);    		
			//Procedemos a generar la imagen con el arreglo de byte resultante del Converter
			arrBytDataImgJpeg = Jnbis.wsq().decode(arrBytDataWsq).toJpg().asByteArray();
			objFilOutStrImgJpeg = new FileOutputStream(objFilImagenWSQ);//objFilDirTransmisionInternacional.getAbsolutePath()+File.separator+pStrNombreImagen
			objFilOutStrImgJpeg.write(arrBytDataImgJpeg);
			//objFilImagenWSQ = Jnbis.wsq().decode(arrBytDataWsq).toJpg().asFile(objFilDirTransmisionInternacional.getAbsolutePath()+File.separator+pStrNombreImagen);
			
			objFilImagenWSQ.deleteOnExit();
			
		}catch(Exception e){
			UtilidadesGiros.getInstance().controlExcepcion(	e, 
															pFrmGenerica, 
															false);
			
			throw EnumMensajes.PROBLEMA_GENERANDO_IMAGEN_HUELLA.generarExcepcion(EnumClasesMensaje.ERROR);
		}finally{
			if	(	objFilOutStrImgJpeg	!=	null	)
			{
				objFilOutStrImgJpeg.close();
			}
		}
		
		return objFilImagenWSQ;
	}
	
}
