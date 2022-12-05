package co.com.codesa.clienteposslimgiros.vista.logica.Internacional.transmision;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaCapturaDocumentoInternacional;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.internacional.UtilTransmisionInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaEstadoArchivoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaEstadoArchivoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.transmision.internacional.ArchivoInternacionalDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * 
 * ********************************************************************
 * @class	ConsultarEstadoArchivoInternacionalVistaLogica
 *		 	Singleton encargado de realizar la peticion de trama 509,
 *			la cual consta de verificar el estado de los archivos 
 *			transmitidos en el sistema sism
 * @author	stiven.garcia
 * @date  	7/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ConsultarEstadoArchivoInternacionalVistaLogica {
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static ConsultarEstadoArchivoInternacionalVistaLogica instance;

	/**
	 * ********************************************************************
	 * @method ConsultarEstadoArchivoInternacionalVistaLogica
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author usuario
	 * @date   6/04/2018
	 * ********************************************************************
	 */
	private ConsultarEstadoArchivoInternacionalVistaLogica() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return ConsultarEstadoArchivoInternacionalVistaLogica
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author usuario
	 * @date   6/04/2018
	 * ********************************************************************
	 */
	public static ConsultarEstadoArchivoInternacionalVistaLogica getInstancia() throws Exception {

		if (instance == null) {

			instance = new ConsultarEstadoArchivoInternacionalVistaLogica();
		}

		return instance;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	consultarEstadoArchivoInternacional
	 * 		  	Consulta el estado de un listado de archivos en base de datos
	 * 			si alguno de los archivos enviados en la lista no se encuentra
	 * 			retorna un falso, pero si todos se encuentran en base de datos
	 * 			el metodo retorna un verdadero
	 * @param pObjUsuario
	 * 			Usuario cajero que efectua la peticion.
	 * @param pListArchivosInternacionalDto
	 * 			Lista de archivos que se envian a verificar
	 * @return
	 * 			Retorna un verdadero o un falso dependiendo el resultado del proceso
	 * @throws Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	stiven.garcia
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public boolean consultarEstadoArchivoInternacional(	Usuario pObjUsuario,
														List<ArchivoInternacionalDTO> pListArchivosInternacionalDto 
												   )	throws Exception{
		
		/**
		* [Trama 509 | Consultar Estado Archivo Internacional]9000847779,B,C,88|800040390|9397B7AEBEB5089612CE10C53F69D1DC,509,91111056868,5000111,343,I|981298|104~I|981298|111~H|415|123456~
		*/
		
		ConsultaEstadoArchivoInternacional objEnvioTrama;
		RespuestaConsultaEstadoArchivoInternacional objRespuestaTrama;
		boolean booExisteArchivosGeneral = false;
		
		objEnvioTrama = new ConsultaEstadoArchivoInternacional(pObjUsuario, pListArchivosInternacionalDto);
		objRespuestaTrama = (RespuestaConsultaEstadoArchivoInternacional)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pListArchivosInternacionalDto = objEnvioTrama.getlArchivoInternacionalDto();
			booExisteArchivosGeneral      = Boolean.valueOf(objRespuestaTrama.getValorAtributoObj("envioExitoso").toString());
			
		}else {
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return booExisteArchivosGeneral;
		
	}
	
	
	public static void main(String[] args) {
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCapturaDocumentoInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			
			InformacionSessionGiros.getInstance().getObjUsuario();
			
			File file;
			ArchivoInternacionalDTO archivoDTO;
			
			List<ArchivoInternacionalDTO> pListArchivosInternacionalDto = new ArrayList<>();
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123456.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123457.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123458.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123459.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123450.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123451.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123452.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123453.jpg");
			archivoDTO = new ArchivoInternacionalDTO(file);
			pListArchivosInternacionalDto.add(archivoDTO);
			
			
			
			UtilTransmisionInternacional.getInstancia().transmitirArchivosInternacional(InformacionSessionGiros.getInstance().getObjUsuario(),
																						pListArchivosInternacionalDto);
			
			//UtilTransmisionInternacional.getInstancia().enviarArchivoSocketReceptor(pIpSocketReceptor, pPuertoSocketReceptor, pUrlArchivoTransmitir, pTimeOutLectura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
