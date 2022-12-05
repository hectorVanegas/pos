package co.com.codesa.clienteposslimgiros.utilidades.internacional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.codec.binary.Base64;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumConfiguracion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.transmision.ConsultarEstadoArchivoInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.transmision.internacional.ArchivoInternacionalDTO;

/**
 * 
 * ********************************************************************
 * @class	UtilTransmisionInternacional
 *		 	Clase encargada de la gestion de transmision de archivos 
 *			al socket receptor de imagenes internacionales 
 * @author	stiven.garcia
 * @date  	2/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilTransmisionInternacional {
	
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseño)
	 **/
	private static UtilTransmisionInternacional instance;
	
	/**
	 * @variable scliente
	 * 			 	Objeto Socket cliente por el cual se efectua la 
	 * 			 	transmision del archivo 
	 */
	private Socket scliente = null;
	
	/**
	 * @variable BUFFER_SIZE
	 * 			 	Constante de tipo entero que maneja el numero de bytes
	 * 				en el arreglo de datos a transmitir
	 */
	private static final int BUFFER_SIZE = 1024;

	/**
	 * ********************************************************************
	 * @method UtilTransmisionInternacional
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author usuario
	 * @date   2/04/2018
	 * ********************************************************************
	 */
	private UtilTransmisionInternacional() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilTransmisionInternacional
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author usuario
	 * @date   2/04/2018
	 * ********************************************************************
	 */
	public static UtilTransmisionInternacional getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilTransmisionInternacional();
		}

		return instance;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	enviarArchivoInternacional
	 * 		  		Metodo encargado de realizar la transmision de archivos 
	 * 				al socket receptor de imagenes internacional			
	 * @param pArchivo 
	 * 				Es el archivo que se requiere transmitir
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	5/04/2018
	 * *********************************************************************
	 */
	private void enviarArchivoInternacional(File pArchivo) throws Exception{
		
		if(pArchivo != null && pArchivo.exists()) {
			System.err.println("-----enviarArchivoInternacional:"+pArchivo.getName());
			if(	this.validarTransmisionArchivosInternacional()	) {
				
				UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.PUERTO_SOCKET_RECEPTOR_INTERNACIONAL,
															  EnumParametrosSistema.TIMEOUT_SOCKET_RECEPTOR_INTERNACIONAL);
				
				String strIpSocket      = EnumConfiguracion.DIRECCION_IP_SOCKET_RECEPTOR_INTERNACIONAL.obtenerValor();
				//String strIpSocket      = EnumParametrosSistema.CONEXION_SOCKET_SIMS_RECEPTOR.obtenerValorCadena();
				int    intPuertoSocket  = EnumParametrosSistema.PUERTO_SOCKET_RECEPTOR_INTERNACIONAL.obtenerValorEntero();
				int    intTimeOutSocket = EnumParametrosSistema.TIMEOUT_SOCKET_RECEPTOR_INTERNACIONAL.obtenerValorEntero();		
								
				String strUrlArchivo           = pArchivo.getAbsolutePath();
				String strUrlArchivoComprimido = strUrlArchivo.replaceAll("\\.[^.]+$", ".zip");
				comprimirArchivo(strUrlArchivoComprimido, strUrlArchivo);
				
				this.enviarArchivoSocketReceptor(strIpSocket, intPuertoSocket, strUrlArchivoComprimido, intTimeOutSocket);
				
				boolean booIsElimino = new File(strUrlArchivoComprimido).delete();
				
				if(booIsElimino) {
					System.out.println("Archivo comprimido eliminado con exito");
				}				
			}			
			
		}else {
			throw EnumMensajes.ARCHIVO_NO_EXISTE.generarExcepcion(EnumClasesMensaje.INFORMACION);
		}		
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	enviarArchivoSocketReceptor
	 * 		  	Metodo que se encarga de abirir la conexion a un socket,
	 * 			recibe los datos nencesarios ademas del archivo o ubicacion
	 * 			del mismo que se requiere transmitir
	 * @param pIpSocketReceptor
	 * 			Direccion Ip del Socket al cual se requiere transmitir
	 * @param pPuertoSocketReceptor
	 * 			Puerto por el cual escucha el socket al cual se requiere transmitir
	 * @param pUrlArchivoTransmitir
	 * 			Es la url del archivo que se requiere transmitir
	 * @param pTimeOutLectura
	 * 			TimeOut esablecido de conexion para el socket receptor
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	usuario
	 * @date	5/04/2018
	 * *********************************************************************
	 */
	private void enviarArchivoSocketReceptor(	String pIpSocketReceptor, 
												int    pPuertoSocketReceptor, 
												String pUrlArchivoTransmitir, 
												int    pTimeOutLectura
											)	throws Exception	{
		
        FileInputStream  inputStream  = null;
        FileOutputStream outputStream = null;
		
		try {
			
			scliente = new Socket(pIpSocketReceptor, pPuertoSocketReceptor);
			scliente.setPerformancePreferences(1, 2, 0);
			
			setTimeOut(pTimeOutLectura);
			
			
			outputStream = (FileOutputStream)scliente.getOutputStream();
			inputStream  = new FileInputStream(new File(pUrlArchivoTransmitir));
            
            scliente.sendUrgentData(10000);
            byte[] buf = new byte[BUFFER_SIZE];
            int len;
            while ((len = inputStream.read(buf)) > 0 ){
            	outputStream.write(buf, 0, len);
            }
            
            inputStream.close(); 
            outputStream.close();
            
			cerrarSocket();
			
		} catch (ConnectException connectException) {			
			
			throw EnumMensajes.TIMEOUT_NO_CONEXION_SOCKET_RECEPTOR.generarExcepcion(EnumClasesMensaje.ERROR);
			
		}catch (IOException ioExceptionGnrl) {
			
			throw EnumMensajes.ARCHIVO_NO_EXISTE.generarExcepcion(EnumClasesMensaje.ERROR, pUrlArchivoTransmitir);
			
		}catch (Exception e) {
			UtilidadesGiros.getInstance().controlExcepcion(e, null, null);
			if(scliente != null){
				cerrarSocket();
			}
		}finally {
			if(inputStream != null) {
				inputStream.close(); 
			}else if (outputStream != null) {				
	            outputStream.close();
			}
		}		
	}
	
	/** 
	 * ********************************************************************
	 * @method	prueba
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @param pFile
	 * 			file
	 * @throws Exception
	 * 			error
	 * @author	roberth.martinez
	 * @date	5/06/2018
	 * *********************************************************************
	 */
	public void prueba(File pFile) throws Exception{
		
		File file = new File("C:\\Users\\roberth.martinez\\businessnet\\ImagenesGirosInternacionales\\H_6635_1006071549.jpg");
		String strUrlArchivo           = file.getAbsolutePath();
		String strUrlArchivoComprimido = strUrlArchivo.split("\\.")[0].concat(".zip");
		String strUrlArchivoComprimido1 = strUrlArchivo.replaceAll("\\.[^.]+$", ".zip");
		System.out.println("strUrlArchivo:"+strUrlArchivo);
		System.out.println("strUrlArchivoComprimido:"+strUrlArchivoComprimido);
		System.out.println("strUrlArchivoComprimido1:"+strUrlArchivoComprimido1);
		/*
		String strCadena = new String(this.encodeFileToBase64Binary(file));
		System.out.println(strCadena);
		String str1 = Files.probeContentType(file.toPath());
		String str2 = String.valueOf(file.hashCode());
		System.out.println("probeContentType:"+str1);
		System.out.println("hascode:"+str2);*/
		
		//byte[] decodedBytes = new BASE64Decoder().decodeBuffer(strCadena);
	}
	
	/** 
	 * ********************************************************************
	 * @method	encodeFileToBase64Binary
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @param file
	 * 			file
	 * @return	byte
	 * @throws Exception
	 * 			error
	 * @author	roberth.martinez
	 * @date	5/06/2018
	 * *********************************************************************
	 */
	public byte[] encodeFileToBase64Binary(File file)
			throws Exception
		{
	        byte[] encodedfile = null;
	        FileInputStream fileInputStreamReader=null;
	        try {
	            fileInputStreamReader = new FileInputStream(file);
	            byte[] bytes = new byte[(int)file.length()];
	            fileInputStreamReader.read(bytes);
	            encodedfile = Base64.encodeBase64(bytes);
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            throw e;
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            throw e;
	        }finally{
	        	if(fileInputStreamReader!=null){
	        		fileInputStreamReader.close();
	        	}
	        }
	         
	        return encodedfile;
	    }
	
	/**
	 * 
	 * ********************************************************************
	 * @method	setTimeOut
	 * 		  	Establece el timeOut de lectura para el socket receptor
	 * @param pTimeOut
	 * 			Tiempo dde esperar para permitir conexion con socket receptor
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	3/04/2018
	 * *********************************************************************
	 */
	private void setTimeOut(int pTimeOut) throws Exception {
		
		int intMiliSegundos = 0;
		
		try {
			intMiliSegundos = pTimeOut * 1000;
			scliente.setSoTimeout(intMiliSegundos);

		} catch (NullPointerException e) {
			intMiliSegundos = 300000;
		}

		scliente.setSoTimeout(intMiliSegundos);
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	cerrarSocket
	 * 		  	Metodo encargado de cerrar la conexion al socket receptor
	 * @author	stiven.garcia
	 * @date	5/04/2018
	 * *********************************************************************
	 */
	private void cerrarSocket() {
		try {
			System.out.println("cerrando el socket..");
			if (!scliente.isClosed())
				scliente.close();
		} catch (Exception e) {
			System.out.println("Error cerrando el socket, el error es: " + e.toString());
		}
	}
	
	/**
	* Metodo que tiene como funcionalidad comprimir un archivo con extencion .zip
	* Recibe 2 parametros pDestinoZip, donde se manda la ruta de destino en donde va a
	* quedar alojado el archivo ya comprimido y pFileOrigen que es una lista de archivos 
	* que se pretende comprimir.  
	* @param pFileOrigen
	* 			Es el listado de url de archivos que se requieren comprimir
	* @param pDestinoZip
	* 			Define el nombre y ubicacion del archivo zip generado
	* @throws Exception
	*		   Controla, recupera y escala, cualquier tipo de excepcion 
	* 		   presentada
	*/
	private void comprimirArchivo(String pDestinoZip, String... pFileOrigen) throws Exception {		 
		// objetos en memoria
		FileInputStream  fInputStream  = null;
		FileOutputStream fOutputStream = null;
		ZipOutputStream  zOutputStream = null;
		try {
		    if (pFileOrigen != null) {
		    	byte[] buffer = new byte[BUFFER_SIZE];
		    	fOutputStream = new FileOutputStream(pDestinoZip);
		    	zOutputStream = new ZipOutputStream(fOutputStream);
		    	zOutputStream.setLevel(Deflater.BEST_COMPRESSION);
		        for (int i = 0; i < pFileOrigen.length; i++) {
		        	File fArchivoComprimir = new File(pFileOrigen[i]);
		        	if (fArchivoComprimir.exists()) {
		        		fInputStream      = new FileInputStream(pFileOrigen[i]);	                		
		            	ZipEntry zipEntry = new ZipEntry(fArchivoComprimir.getName()); 		
		            	zOutputStream.putNextEntry(zipEntry);	                		
		        	}else{
		        		throw new Exception("El archivo ["+pFileOrigen[i]+" no existe ");
		        	}
		        }
				int len = 0;
		        // zippear
		        while ((len = fInputStream.read(buffer, 0, BUFFER_SIZE)) != -1)
		        	zOutputStream.write(buffer, 0, len);
		        // volcar la memoria al disco
		        zOutputStream.flush(); 			            	
		    }
		} catch (Exception e) {
			throw e;
		}finally{
		    // cerramos los files
			if(zOutputStream != null) zOutputStream.close();
			if(fInputStream  != null) fInputStream.close();
			if(fOutputStream != null) fOutputStream.close();
		}
	}	 
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarTransmisionArchivosInternacional
	 * 		  	Metodo encargado de validar si se encuentra activa la 
	 * 			transmision de archivos al socket receptor
	 * @return
	 * 			variable booleana con valor true si es permitido o false 
	 * 			si no se encuentra habilitada la transmision
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	5/04/2018
	 * *********************************************************************
	 */
	private boolean validarTransmisionArchivosInternacional() throws Exception{
		
		boolean booActivaTransmision = false;
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ACTIVA_TRANSMISION_IMAGENES_INTERNACIONAL);
		booActivaTransmision = EnumParametrosSistema.ACTIVA_TRANSMISION_IMAGENES_INTERNACIONAL.obtenerValorBooleano("S");
		return booActivaTransmision;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	transmitirArchivosInternacional
	 * 		  	Metodo encargado de transmitir una lista de archivos recibidos
	 * 			como parametros, ademas verifica que los archivos se encuentren
	 * 			registrados en el sistema sims
	 * @param 	pObjUsuario
	 * 			Usuario que realiza la peticion de transmitir
	 * @param 	pListArchivosInternacionalDto
	 * 			Cada uno de los objetos que contiene los archivos a transmitir
	 * @return	boolean
	 * 			Retorna un valor verdadero o falso, si la transmision se realizo 
	 * 			exitosamente retorna un verdadero en caso contrario un falso  
	 * @throws 	Exception
	 *		   	Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   	presentada
	 * @author	stiven.garcia
	 * @date	7/04/2018
	 * *********************************************************************
	 */
	public boolean transmitirArchivosInternacional(	Usuario pObjUsuario, List<ArchivoInternacionalDTO> pListArchivosInternacionalDto	) throws Exception{
		
		boolean booTransmitioArchivos = false;
		
		if(pListArchivosInternacionalDto != null && !pListArchivosInternacionalDto.isEmpty()) {
			
			int intTiempoEspera = EnumParametrosSistema.TIEMPO_ESPERA_TRANSMISION_INTERNACIONAL.obtenerValorEntero() * 1000;
			
			for (ArchivoInternacionalDTO archivoInternacionalDTO : pListArchivosInternacionalDto) {
				File objArchivoInternacional = archivoInternacionalDTO.getObjFilArchivo();
				if(objArchivoInternacional != null && objArchivoInternacional.exists()) {
					this.enviarArchivoInternacional(objArchivoInternacional);
				}
				Thread.sleep(intTiempoEspera);
			}
			
			booTransmitioArchivos = ConsultarEstadoArchivoInternacionalVistaLogica.getInstancia().consultarEstadoArchivoInternacional(pObjUsuario, pListArchivosInternacionalDto);
			
			if(booTransmitioArchivos) {
				for (ArchivoInternacionalDTO archivoInternacionalDTO : pListArchivosInternacionalDto) {
					if(archivoInternacionalDTO.getObjFilArchivo().exists()) {
						archivoInternacionalDTO.getObjFilArchivo().delete();
					}
				}
			}
		}
		
		return booTransmitioArchivos;
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	validaTransmisionArchivos
	 * 		  	metodo para asegurarse de la transmision de los archivos
	 * @param 	pObjUsuario
	 * 			Usuario que realiza la peticion de transmitir
	 * @param 	pListArchivosInternacionalDto
	 * 			Cada uno de los objetos que contiene los archivos a transmitir
	 * @return	boolean
	 * 			bandera
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	15/04/2018
	 * *********************************************************************
	 */
	public boolean validaTransmisionArchivos(Usuario pObjUsuario, List<ArchivoInternacionalDTO> pListArchivosInternacionalDto) throws Exception{
		
		return true;
	}
	
	
	
	/*public static void main(String[] args) {

		
		//String pIpSocketReceptor     = "10.11.6.41";
		String pIpSocketReceptor     = "10.11.6.46";
		int pPuertoSocketReceptor    = 9009;
		String pUrlArchivoTransmitir = "/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123456.jpg";
		
		int pTimeOutLectura          = 15;
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCapturaDocumentoInternacional.class,
					   true, 
					   EnumDesplegarFormaConEventos.SI);
			
			InformacionSessionGiros.getInstance().getObjUsuario();
			
			File file = new File("/home/usuario/StivenGarcia/workspace/BnetGirosInternacionales2/ClientePosSlim-Giros/ImagenesGirosInternacionales/A_1234_123456.jpg");
			//String strIp = EnumConfiguracion.NOMBRE_IMPRESORA_GIROS_MC.obtenerValor();
			
			System.out.println("Direccion ip: " + pIpSocketReceptor);
			UtilTransmisionInternacional.getInstancia().enviarArchivoInternacional(file);
			//UtilTransmisionInternacional.getInstancia().enviarArchivoSocketReceptor(pIpSocketReceptor, pPuertoSocketReceptor, pUrlArchivoTransmitir, pTimeOutLectura);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/

	public static void main(String[] args) {
		try {
			System.out.println("si");
			UtilTransmisionInternacional.getInstancia().prueba(null);
			System.out.println("si2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
