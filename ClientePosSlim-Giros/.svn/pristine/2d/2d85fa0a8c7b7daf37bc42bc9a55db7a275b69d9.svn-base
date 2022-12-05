package co.com.codesa.clienteposslimgiros.utilidades;

import java.awt.Window;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JComponent;

import co.com.codesa.clientecajams.utilidades.excepciones.CajaMultiservicioException;
import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslim.seguridad.Encriptador;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumFormatoPalabrasNegocio;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.libCajaMultiservicio.UtilIntegracionLibCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.objetos.UtilObjeto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrapper.modelo.enumeraciones.EnumModulos;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;
import co.com.codesa.codesawrapper.vista.logica.ProcesadorTramasVistaLogica;


/**
 * ****************************************************************.
 * @autor CesarO.Rendon
 * @fecha 03-mar-2015
 * @Clase UtilidadesGiros 
 * 		  Clase utilitaria general del modulo de giros
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilidadesGiros {

	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de dise�o)
	 **/
	private static UtilidadesGiros instancia;

	/**
  	 * ****************************************************************.
  	 * @metodo UtilidadesGiros
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilidadesGiros() {}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilidadesGiros
  	 * 		   Tipo referente a la misma clase
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilidadesGiros getInstance() {
		
		if (instancia == null) {
			
			instancia = new UtilidadesGiros();
		}
		
		return instancia;
	}

	/**
	 * @author: CesarO.Rendon
	 * @type: Metodo(metodo)
	 * @name: inputFileInJAR
	 * @description: Metodo que de vuelve un input de un archivo dentro de un
	 *               jar.
	 * @param pNombre
	 * @version: 07/03/2015
	 */
	public InputStream inputFileInJAR(String pNombreRecurso,EnumModulos pNombreModulo) {
		InputStream inputStream =null;
		
		try {
			inputStream  = UtilidadesGiros.class.getResourceAsStream("/"+pNombreRecurso);
		} catch (Exception e) {
			Logger.getInstance().info("Error en inputFileJar "+e.getMessage());
		}
		return  inputStream;
		
	}
	
	//Roberth
	public Number getValorFormato(String pValorFormato)
	{
		try
		{
			return NumberFormat.getInstance(Locale.ENGLISH).parse(pValorFormato);
		}
		catch (ParseException e)
		{
			return new Integer(0);
		}
	}
	
	public String aplicarPresentacion(String mensaje, 
									  String delimitadorGeneral)throws Exception{
		
		List<String> lstSeccionesIndependientes;
		String secciones[];
		String respuesta;
		String seccionesGeneral[];

		respuesta=mensaje;
		lstSeccionesIndependientes = null;
		
		if(respuesta!=null && 
				!respuesta.trim().isEmpty()){
			
			if(respuesta.contains(EnumParametrosApp.COMILLA_DOBLE.getValorPropiedad()) ||
					respuesta.contains(EnumParametrosApp.COMILLA_SIMPLE.getValorPropiedad()) ||
					respuesta.contains(EnumParametrosApp.COMILLA_SIMPLE_DERECHA.getValorPropiedad()) ||
					respuesta.contains(EnumParametrosApp.COMILLA_SIMPLE_IZQUIERDA.getValorPropiedad())){
				
				lstSeccionesIndependientes = new ArrayList<String>();
				
				respuesta = this.procesarIdentificadoresPresentacionIndependiente(respuesta,
						  											  			  lstSeccionesIndependientes);
			}
			
			if(delimitadorGeneral!=null && 
					!delimitadorGeneral.trim().isEmpty()){
				
				seccionesGeneral = respuesta.split(delimitadorGeneral);
				
			}else{
				
				seccionesGeneral = new String[]{respuesta};
			}
			
			for(String seccionGeneral: seccionesGeneral){
				
				secciones=seccionGeneral.split(EnumExpresionesRegulares.TXT_CARACTERES_QUE_CAUSAN_INICIO_MAYUSCULA.getValor());
				
				for(String seccion : secciones){
					
					respuesta = this.aplicarPresentacionOracion(seccion,
																respuesta);
				}
			}
			
			if(lstSeccionesIndependientes != null &&
					!lstSeccionesIndependientes.isEmpty()){
				
				for(int i=0;i<lstSeccionesIndependientes.size();i++){
					
					respuesta = respuesta.replace("{"+i+"}", lstSeccionesIndependientes.get(i));
				}
			}
		}

		respuesta	= 	this.formatearPalabrasClavesNegocio(respuesta);
		
		return respuesta;
	}
	
	private String formatearPalabrasClavesNegocio(String pStrMensaje)throws Exception{
		
		for(EnumFormatoPalabrasNegocio enmPalabrasClaves : EnumFormatoPalabrasNegocio.values()){
			
			pStrMensaje = enmPalabrasClaves.formatearPalabraClaves(pStrMensaje);
		}
		
		return pStrMensaje;
	}
	
	private String aplicarPresentacionOracion(String pStrSeccion,
											  String pStrRespuesta)throws Exception{
		
		String strReferenciaOriginal;
		String strReferenciaTmp;
		int intPosicionPrimerLetraOracion = 0;
		
		strReferenciaOriginal = pStrSeccion.trim();//remueve posibles espacios externos, izquierda y derecha
		
		if(!strReferenciaOriginal.isEmpty()){
		
			while(intPosicionPrimerLetraOracion<strReferenciaOriginal.length() &&
					!Character.isLetter(strReferenciaOriginal.charAt(intPosicionPrimerLetraOracion))
					&& !String.valueOf(strReferenciaOriginal.charAt(intPosicionPrimerLetraOracion)).equals(",")
					){
				
				intPosicionPrimerLetraOracion++;
			}
			
			if(intPosicionPrimerLetraOracion<strReferenciaOriginal.length()){
				
				strReferenciaTmp=String.valueOf(strReferenciaOriginal.charAt(intPosicionPrimerLetraOracion)).toUpperCase();//Mayuscula primer caracter de la seccion
				
				strReferenciaTmp=strReferenciaOriginal.substring(0,intPosicionPrimerLetraOracion)+
									strReferenciaTmp+
									strReferenciaOriginal.substring(intPosicionPrimerLetraOracion+1).toLowerCase();//Resto de la seccion en minuscula
				
				pStrRespuesta = pStrRespuesta.replace(strReferenciaOriginal,strReferenciaTmp);//Reemplaza lo procesado sobre la cadena original
			}
		}
		
		return pStrRespuesta;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method initcap
	 * 		   Metodo que permite procesar un texto de entrada, elevando la
	 * 		   primera letra de cada palabra (mayuscula) contenida en el 
	 * 		   texto, y colocando su resto en minuscula
	 * @param  pStrTexto
	 * 		   Texto que se procesara
	 * @return String
	 * 		   Nuevo texto resultante, con cada primera letra de cada palabra
	 * 		   en mayuscula y su resto en minuscula
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   10/06/2016
	 * *********************************************************************
	 */
	private String initcap(String pStrTexto) throws Exception{
        
		Pattern patExpPalabras;
		Matcher matPalabras;
		StringBuffer strBufResultado;
		String strPalabra;
		String strResultado;
		
		if(pStrTexto == null
				|| pStrTexto.isEmpty()){
			
			strResultado = "";
			
		}else if(pStrTexto.trim().equals("")){
			
			strResultado = pStrTexto;
			
		}else{
			
			pStrTexto = pStrTexto.replace("\\", "\\\\");
			pStrTexto = pStrTexto.replace("$", "\\$");
			
			patExpPalabras = Pattern.compile (EnumExpresionesRegulares.TXT_DETECTA_PALABRAS_ORACION.getValor());
			matPalabras = patExpPalabras.matcher (pStrTexto);
			
	        if(matPalabras.matches()){
	        	
	        	strPalabra = pStrTexto;
	        	strResultado = this.primeraLetraMayusculaRestoMinuscula(strPalabra);
	        	
	        }else{
	        	
	        	strBufResultado = new StringBuffer ();
	        	matPalabras.reset();
	        	
	        	while (matPalabras.find ()) {
	            	
	            	strPalabra = matPalabras.group();
	            	strPalabra = this.primeraLetraMayusculaRestoMinuscula(strPalabra);
	            	
	            	matPalabras.appendReplacement (strBufResultado, 
	            								   strPalabra);
	            }
	        
	        	matPalabras.appendTail (strBufResultado);
	        	strResultado = strBufResultado.toString();
	        }
		}
		
        return strResultado;
	}
	
	/** 
	 * ********************************************************************
	 * @method primeraLetraMayusculaRestoMinuscula
	 * 		   Metodo que permite para una palabra encontrar su primera letra
	 * 		   elevarla a mayuscula y convertir su resto en minuscula
	 * @param  pStrPalabra
	 * 		   Palabra a la que se le ejecutara el proceso
	 * @return String
	 * 		   Palabra procesada, con inicio de letra en mayuscula y su resto
	 * 		   en minuscula
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   10/06/2016
	 * *********************************************************************
	 */
	private String primeraLetraMayusculaRestoMinuscula(String pStrPalabra)throws Exception{
	
		Pattern patExpLetras;
		Matcher matLetras;
		String strPalabra;
		
		strPalabra = pStrPalabra;
		
		patExpLetras = Pattern.compile (EnumExpresionesRegulares.TXT_DETECTA_LETRAS_EN_PALABRA.getValor());
		matLetras = patExpLetras.matcher(strPalabra);
		
		if(matLetras.find()){
    		
			strPalabra = strPalabra.substring(0,
    										  matLetras.start());
    		
			strPalabra += Character.toUpperCase(matLetras.group().charAt(0));
			strPalabra += pStrPalabra.substring(matLetras.start()+1).toLowerCase();
    	}
		
		return strPalabra;
	}
	
	private String procesarIdentificadoresPresentacionIndependiente(String pStrMensaje,
																	List<String> pLstSeccionesIndependientes)throws Exception{
		
		String strSeccion;
		
		if(pStrMensaje.contains(EnumParametrosApp.COMILLA_DOBLE.getValorPropiedad())){
			
			pStrMensaje = this.recuperarSeccionesIndependientes(pStrMensaje,
											 	  				pLstSeccionesIndependientes,
											 	  				EnumParametrosApp.COMILLA_DOBLE.getValorPropiedad(),
											 	  				EnumParametrosApp.COMILLA_DOBLE.getValorPropiedad());
		}
		
		if(pStrMensaje.contains(EnumParametrosApp.COMILLA_SIMPLE.getValorPropiedad())){
			
			pStrMensaje = this.recuperarSeccionesIndependientes(pStrMensaje,
											 	  				pLstSeccionesIndependientes,
											 	  				EnumParametrosApp.COMILLA_SIMPLE.getValorPropiedad(),
											 	  				EnumParametrosApp.COMILLA_SIMPLE.getValorPropiedad());
		}
		
		if(pStrMensaje.contains(EnumParametrosApp.COMILLA_SIMPLE_IZQUIERDA.getValorPropiedad())){
			
			pStrMensaje = this.recuperarSeccionesIndependientes(pStrMensaje,
											 	  				pLstSeccionesIndependientes,
											 	  				EnumParametrosApp.COMILLA_SIMPLE_IZQUIERDA.getValorPropiedad(),
											 	  				EnumParametrosApp.COMILLA_SIMPLE_DERECHA.getValorPropiedad());
		}
		
		if(pStrMensaje.contains(EnumParametrosApp.COMILLA_SIMPLE_DERECHA.getValorPropiedad())){
			
			pStrMensaje = this.recuperarSeccionesIndependientes(pStrMensaje,
											 	  				pLstSeccionesIndependientes,
											 	  				EnumParametrosApp.COMILLA_SIMPLE_DERECHA.getValorPropiedad(),
											 	  				EnumParametrosApp.COMILLA_SIMPLE_IZQUIERDA.getValorPropiedad());
		}
		
		for(int i=0;i<pLstSeccionesIndependientes.size();i++){
			
			strSeccion = pLstSeccionesIndependientes.get(i);
			
			if(strSeccion.startsWith(EnumParametrosApp.COMILLA_DOBLE.getValorPropiedad())){
				
				pLstSeccionesIndependientes.set(i, this.initcap(strSeccion));
				
			}else if(strSeccion.startsWith(EnumParametrosApp.COMILLA_SIMPLE_IZQUIERDA.getValorPropiedad())){
				
				pLstSeccionesIndependientes.set(i, strSeccion.toUpperCase());
				
			}else if(strSeccion.startsWith(EnumParametrosApp.COMILLA_SIMPLE_DERECHA.getValorPropiedad())){
				
				pLstSeccionesIndependientes.set(i, strSeccion.toLowerCase());
			}
		}
		
		return pStrMensaje;
	}
	
	private String recuperarSeccionesIndependientes(String pStrMensaje,
													List<String> pLstSeccionesIndependientes,
													String pStrIdInicioSeccion,
													String pStrIdFinSeccion)throws Exception{
		String strSeccion;
		int intPosInicioSeccion;
		int intPosFinSeccion;
		
		while(pStrMensaje.contains(pStrIdInicioSeccion)){
			
			intPosInicioSeccion = pStrMensaje.indexOf(pStrIdInicioSeccion);
			
			intPosFinSeccion = pStrMensaje.indexOf(pStrIdFinSeccion,
												   intPosInicioSeccion+1);
			
			if(intPosFinSeccion<=0){
				break;
			}else{
			
				strSeccion = pStrMensaje.substring(intPosInicioSeccion,
												   intPosFinSeccion+1);
				
				pStrMensaje = pStrMensaje.substring(0,intPosInicioSeccion)+"{"+pLstSeccionesIndependientes.size()+"}"+pStrMensaje.substring(intPosFinSeccion+1);
				
				pLstSeccionesIndependientes.add(strSeccion);
			}
		}
		
		return pStrMensaje;
	}
	
	public boolean validaFormato(String pStrFormato, 
		   	 					 String pStrCadena)throws Exception{

		Pattern pat;
		Matcher mat;
		
		pat = Pattern.compile(pStrFormato);
		mat = pat.matcher(pStrCadena);
		
		return mat.matches();
	}
	
	public static boolean contieneExpresion(String pStrExpresion, 
											String pStrCadena)throws Exception{
		Pattern pat;
		Matcher mat;

		pat = Pattern.compile(pStrExpresion);
		mat = pat.matcher(pStrCadena);

		return mat.find();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	controlExcepcion
  	 * 		   	Metodo utilizado para centralizar el control de cualquier 
  	 * 		   	tipo de excepcion generada y su reaccion frente al sistema
  	 * @param 	e
  	 * 			Excepcion general, que puede representar una excepcion
  	 * 		  	personalizada o general del sistema
  	 * @param	pForma
  	 * 			Forma sobre la cual se desplegaria el mensaje, en caso de
  	 * 			ser null, se desplegara ante el sistema
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void controlExcepcion(Exception e, 
								 Window pForma)
	{
		this.controlExcepcion	(	e, 
		                     	 	pForma,
		                     	 	null
		                    	);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	controlExcepcion
  	 * 		   	Metodo utilizado para centralizar el control de cualquier 
  	 * 		   	tipo de excepcion generada y su reaccion frente al sistema
  	 * @param 	e
  	 * 			Excepcion general, que puede representar una excepcion
  	 * 		  	personalizada o general del sistema
  	 * @param	pForma
  	 * 			Forma sobre la cual se desplegaria el mensaje, en caso de
  	 * 			ser null, se desplegara ante el sistema
  	 * @param	pBooMuestraMsgPantallaLogAmbas
  	 * 			Badera que permite identificar el tratamiento a nivel de 
  	 * 			presentacion que se le da a la excepcion
  	 * 				true: Presenta en pantalla
  	 * 				false: Presenta en trazas (log)
  	 * 				null: Presenta tanto en pantalla como en trazas (log) 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void controlExcepcion(	Exception e, 
	                             	Window pForma,
	                             	Boolean pBooMuestraMsgPantallaLogAmbas
	                          	)
	{	
		Mensaje objMensaje;
		InvocationTargetException ite;
		boolean booMuestraMsgPantalla;
		boolean booMuestraMsgLog;
		
		try{
			
			booMuestraMsgPantalla	=	pBooMuestraMsgPantallaLogAmbas == null || pBooMuestraMsgPantallaLogAmbas.booleanValue ();
			booMuestraMsgLog		=	pBooMuestraMsgPantallaLogAmbas == null || !pBooMuestraMsgPantallaLogAmbas.booleanValue ();
			
			if(e instanceof ClientePosSlimGirosException)
			{
				if	(	booMuestraMsgPantalla	)
				{
					objMensaje = (Mensaje)((ClientePosSlimGirosException)e).getObjMensaje();
					objMensaje.desplegarMensaje(pForma);
				}
					
				if	(	booMuestraMsgLog	)
				{
					this.imprimirTrazaExcepcion(e);
				}
				
			}	else if	(	e instanceof CajaMultiservicioException	)
			{
				e = UtilIntegracionLibCajaMultiservicio.getInstance().interpretarExceptionNegocioCajaMultiservicio	(	(CajaMultiservicioException)e, 
																														false
																													);
				this.controlExcepcion(	e, 
						  			 	pForma,
						  			 	pBooMuestraMsgPantallaLogAmbas
						  			 );
			}	else	{
				
				if	(		e instanceof InvocationTargetException
						&& 	(ite = (InvocationTargetException) e).getTargetException() instanceof ClientePosSlimGirosException
					)
				{
					e = (ClientePosSlimGirosException) ite.getTargetException();
					
					this.controlExcepcion(	e, 
							  			 	pForma,
							  			 	pBooMuestraMsgPantallaLogAmbas
							  			 );
				}	else	{
				
					if	(	booMuestraMsgPantalla	)
					{
						EnumMensajes.ERROR_GENERAL.desplegarMensaje(pForma, 
																	EnumClasesMensaje.ERROR);
					}

					if	(	booMuestraMsgLog	)
					{
						this.imprimirTrazaExcepcion(e);
					}
				}
			}
		
		}catch(Exception e1){
			
			this.imprimirTrazaExcepcion(e1);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	imprimirTrazaExcepcion
	 * 		  	Metodo que permite imprimir una excepcion en log
	 * @param 	e
	 * 			Excepcion a imprimir
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 * *********************************************************************
	 */
	private void imprimirTrazaExcepcion(Exception e)
	{
		String strTraza;
		
		strTraza = Arrays.toString(e.getStackTrace());
		
		//e.printStackTrace();
		Logger.getInstance().error	(		"\n"+e.toString()
		                          	 	+	" \nTraza: "+strTraza.replace	(	",", 
		                          	 	 	                             	 	"\n\t"
		                           	 	                           			)
		                         	);
	}
	
	public boolean imprimir(String pStrCadena,
							String pStrNombreImpresora,
							FormaGenerica pFrmGnrVentana) throws Exception{
		
		DocFlavor objDocFlavor;
		//DocAttributeSet objDocAttributeSet;
		SimpleDoc objSimpleDoc;
		PrintService objPrintService = null;
		DocPrintJob objDocPrintJob;
		boolean booImprimio;
		
		objDocFlavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		//objDocAttributeSet = new HashDocAttributeSet();
		
		pStrCadena = UtilidadGiros.getInstancia().getINICIO()+
						pStrCadena+
						UtilidadGiros.getInstancia().getFIN();
		
		objSimpleDoc = new SimpleDoc(pStrCadena.getBytes(), 
							 		 objDocFlavor, 
								     null);
		
		if	(		pStrNombreImpresora!=null 
				&&	!pStrNombreImpresora.isEmpty()	
			)
		{
			objPrintService = this.buscarImpresora(pStrNombreImpresora);//PrintServiceLookup.lookupDefaultPrintService();
		}
		
		if	(	objPrintService == null	)
		{
			if	(		pStrNombreImpresora==null 
					||	pStrNombreImpresora.isEmpty()	
				)
			{
				EnumMensajes.IMPRESORA_NO_CONFIGURADA_IMPRIMIRA_PREDETERMINADA.desplegarMensaje(pFrmGnrVentana, 
																								EnumClasesMensaje.ADVERTENCIA, 
																							    pStrNombreImpresora);
			}	else	{
			
				EnumMensajes.IMPRESORA_NO_ENCONTRADA_IMPRIMIRA_PREDETERMINADA.desplegarMensaje(pFrmGnrVentana, 
																							   EnumClasesMensaje.ADVERTENCIA, 
																							   pStrNombreImpresora);
			}
			
			objPrintService = PrintServiceLookup.lookupDefaultPrintService();
		}
		
		objDocPrintJob = objPrintService.createPrintJob();
		objDocPrintJob.print(objSimpleDoc, null);
		
		booImprimio = true;
		
		return booImprimio;
	}
	
	private PrintService buscarImpresora(String pStrNombreImpresora) throws Exception{
		
		PrintService[] services;
		PrintService objPrintService = null;
		AttributeSet aset;
		PrinterName printerName = null;
		String strNombreServicio;
		
		services = PrintServiceLookup.lookupPrintServices(null, null);
		
		for (int i = 0; i < services.length; i++) {
			
			strNombreServicio = services[i].getName();
			
			if (strNombreServicio.equals(pStrNombreImpresora) || 
					strNombreServicio.endsWith(File.separator + 
														pStrNombreImpresora)) {
				
				printerName = new PrinterName(strNombreServicio, null);
				break;
			}
		}
		
		if (printerName != null) {
		
			aset = new HashAttributeSet();
			aset.add(printerName);
			services = PrintServiceLookup.lookupPrintServices(null, aset);
			
			if (services.length == 1) {
				
				objPrintService = services[0];
				//return PrintServiceLookup.lookupDefaultPrintService();
			}
		}
		
		return objPrintService;
	}
	
	public void mostrarEnConsola(String pStrCadena,
								 PrintStream pPrsTipoImpresion)throws Exception{
		
		pPrsTipoImpresion.println(pStrCadena);
	}
	
	public int calcularEdad(Date pDatFechaNacimiento)throws Exception{
		
		Calendar calFechaActual;
		Calendar calFechaNacimiento;
		int intDiferenciaAnos;
		int intDiferenciaMeses;
		int intDiferenciaDias;
		
		calFechaActual = Calendar.getInstance();
		calFechaNacimiento = Calendar.getInstance();
		
		calFechaNacimiento.setTime(pDatFechaNacimiento);
		
		intDiferenciaAnos = calFechaActual.get(Calendar.YEAR) - calFechaNacimiento.get(Calendar.YEAR);
		intDiferenciaMeses = calFechaActual.get(Calendar.MONTH) - calFechaNacimiento.get(Calendar.MONTH);
		intDiferenciaDias = calFechaActual.get(Calendar.DAY_OF_MONTH) - calFechaNacimiento.get(Calendar.DAY_OF_MONTH);
		
		if (intDiferenciaMeses < 0 || 
				(intDiferenciaMeses == 0 && 
					intDiferenciaDias < 0)) {
			
			intDiferenciaAnos = intDiferenciaAnos - 1;
		}
		
		return intDiferenciaAnos;
	}
	
	public boolean compararObjetos(Object pObjeto1,
								   Object pObjeto2)throws Exception{
		
		boolean booResultado;
		
		if(pObjeto1 != null && 
				pObjeto2!= null){
			
			booResultado = pObjeto1.equals(pObjeto2);
			
		}else if(pObjeto1 != null && 
					pObjeto2 == null ||
					pObjeto1 == null && 
					pObjeto2 != null){
			
			booResultado = false;
			
		}else{
			booResultado = true;
		}
		
		return booResultado;
	}
	
	public String reemplazarString(String pStrCadena, String pStrCadenaReemplazar, String pStrValorNuevo) {
		
		String result = null;
		Pattern p = Pattern.compile(pStrCadenaReemplazar);
		Matcher m = p.matcher(pStrCadena);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, pStrValorNuevo);
		}
		m.appendTail(sb);
		if(sb.toString().length() > 0){
			result = sb.toString();
		}else{
			result = pStrCadena;
		}
		return result;
	}
	
	//Solo Numeros
	public String llenarCerosIzq(String pStrCadena, String pStrLogitud){
		
		String strRespuesta;
		
		strRespuesta = "";
		
		strRespuesta = String.format("%1$0"+pStrLogitud+"d", new Long(pStrCadena));
		
		return strRespuesta;
	}
	
	public String obtenerIdTransaccion(Usuario pUsuario)throws Exception{
		
		String strIdTransaccion;
		String strNitempresa;
		String strIdentificacionCajero;
		
		strIdentificacionCajero = pUsuario.getStrDocumentoGamble();
		
		try{
			
			strNitempresa = (pUsuario.getEmpresa().getStrTokenDSeguridad().split("\\|"))[1];
			
		}catch(Exception e){
			
			throw EnumMensajes.TOKEN_D_MAL_CONFIGURADO.generarExcepcion(EnumClasesMensaje.ERROR,
																		pUsuario.getStrLoginGamble());
		}
		
		strIdTransaccion = llenarCerosIzq(strNitempresa, "13") 
								+ llenarCerosIzq(strIdentificacionCajero, "12") 
								+ String.valueOf(System.currentTimeMillis());
		
		return strIdTransaccion;
	}
	
	/** 
	 * ********************************************************************
	 * @method setTransferHandlerComponet
	 * 		   Metodo utilizado para setear la propiedad setTransferHandler
	 *         en null al componente recibido, esto permite evitar que se 
	 *         realice el copiado desde el componente
	 * @param  pComponent
	 * 		   Componente de interfaz que se le seteara la propiedad de 
	 * 		   copiado en null
	 * @author roberth.martinez
	 * @date   7/2/2017
	 * *********************************************************************
	 */
	public void setTransferHandlerComponet(JComponent pComponent){
		
		if (FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.PRODUCCION)) {
			
			pComponent.setTransferHandler(null);
		}
	}
	
	/**
	 * autor: Roberth Martinez Vargas
	 * */
	public void setToolTipText(JComponent pComponente,
							   EnumEtiquetas pEnmEtiquetas,
			   				   String ...pArrStrParametros){

		if(pEnmEtiquetas == null){
			
			pComponente.setToolTipText(null);
			
		}else{
		
			pComponente.setToolTipText(pEnmEtiquetas.getValor(false, 
						  									  pArrStrParametros));
		}
	}
	
	public String procesarParametrosEnTexto(String pStrTexto,
											String[] pArrStrParametros)throws Exception{

		String strParametro;
		
		if(pArrStrParametros!=null){
		
			for(int i=0;i<pArrStrParametros.length;i++){
		
				strParametro    =    pArrStrParametros[i]    == null    ||    pArrStrParametros[i].trim().isEmpty()
										?    "" : "'"+pArrStrParametros[i].replaceAll(EnumExpresionesRegulares.GRN_DETECTAR_IRREGULARIDADES_PARAMETROS_MENSAJE.getValor(), 
																					  "")+"'";
		
				pStrTexto = pStrTexto.replace( "{"+(i+1)+"}", strParametro);
			}
		}
		
		/**
		* remueve de la cadena a producir, parametros que no fueron diligenciados
		*/
		if(UtilidadesGiros.contieneExpresion(EnumExpresionesRegulares.GNR_DETECTAR_PARAMETROS_MENSAJE_NO_PROCESADOS.getValor(),
											 pStrTexto)){
		
			System.err.println("Detectado texto con parametros sin resolver: "+pStrTexto);
			pStrTexto = pStrTexto.replaceAll(EnumExpresionesRegulares.GNR_DETECTAR_PARAMETROS_MENSAJE_NO_PROCESADOS.getValor(), "");
		}
		
		return pStrTexto;
	}
	
	public Class<?>[] obtenerArrayClasesObjetos(Object ...pArrObjetos)throws Exception{
		
		Class<?>[] arrClsObjetos;
		
		if(pArrObjetos!=null){
			
			arrClsObjetos = new Class<?>[pArrObjetos.length];
			
			for(int i=0;i<pArrObjetos.length;i++){
				
				arrClsObjetos[i] = pArrObjetos[i].getClass();
			}
			
		}else{
			
			arrClsObjetos = null;
		}
		
		return arrClsObjetos;
	}
	
	/** 
	 * ********************************************************************
	 * @method validarObligatoriedadObjeto
	 * 		   Utilidad que permite validar la obligatoriedad de varios 
	 * 		   objetos, requeridos para un proceso en particular
	 * @param  pEnmEtiNombreProceso
	 * 		   Constante de enumeracion que representa el nombre del proceso
	 * @param  pArrStrParametrosNombreProceso
	 * 		   Conjunto de posibles parametros que pueda llegar a presentar
	 * 		   el nombre del proceso objeto que se esta llevando a cabo
	 * @param  pObjArrUtilObjetos
	 * 		   Listado de objetos de negocio encapsulados cada uno en un objeto 
	 * 		   generico con el fin de validar su obligatoriedad en el proceso 
	 * 		   de negocio que esta ejecutando
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author hector.cuenca
	 * @date   17/03/2016
	 * *********************************************************************
	 */
	public void validarObligatoriedadObjeto(EnumEtiquetas pEnmEtiNombreProceso,
		  	 								String[] pArrStrParametrosNombreProceso,
		  	 								UtilObjeto<?> ...pObjArrUtilObjetos)throws Exception{
		
		for(UtilObjeto<?> objUtilObjeto : pObjArrUtilObjetos){
		
			objUtilObjeto.requeridoParaProceso(pEnmEtiNombreProceso, 
											   pArrStrParametrosNombreProceso);
		}
	}
	
	public static void mainCifrarDescifrar(String args[]){
		
		String strDato = "iRB892nv/U4YLlMCiS0aiQ==";
		String strRespuesta;
		String strTipoOperacion;
		boolean booEncriptar = false;
		
		if(booEncriptar){
			
			strTipoOperacion = "Cifrar";
			strRespuesta = Encriptador.getInstance().encriptarString(strDato);
			
		}else{
			
			strTipoOperacion = "Descifrar";
			strRespuesta = Encriptador.getInstance().desencriptarString(strDato);
		}
		
		System.out.println(strTipoOperacion+": {"+strDato+"} --> "+strRespuesta);
	}
	
	public static void mainCifrarDescifrarSIMS(String args[]){
		
		String strDato = "ZA9R5UmCeNLdODgPjsruRAVEJlrpC39bmjH0GPgBpURz+EiypGbG1piqRfQBX6/q";//SGFLEX01DESARROLLO
		String strRespuesta;
		String strTipoOperacion;
		boolean booEncriptar = false;
		
		if(booEncriptar){
			
			strTipoOperacion = "Cifrar";
			strRespuesta = new ProcesadorTramasVistaLogica().procesarTramaGiros(strDato);
			
		}else{
			
			strTipoOperacion = "Descifrar";
			strRespuesta = new ProcesadorTramasVistaLogica().obtenerTramaProcesadaGiros(strDato);
		}
		
		System.out.println(strTipoOperacion+": {"+strDato+"} --> "+strRespuesta);
	}
	
	public static void mainAplicarPresentacion(String args[]){
		
		String strMensaje;
		
		//vi�eta: \u2022
		
		strMensaje = "El �nico autorizado para actualizar la informaci�n de un tercero NIT es personal administrativo de SuperGIROS S.A."; 
		
		try{
			
			//(\\b|(\\s)|'|\"|�|`)(S|s)\\.(A|a|�|�)\\.(\\b|'|\"|�|`|(\\.)|(\\s))
			Matcher matMatcher	= 	Pattern.compile("(S|s)\\.(A|a|�|�)\\.(\\b|'|\"|�|`|\\.|\\s|$)").matcher(strMensaje);
			
			System.out.println(matMatcher.find());
			
			System.out.println(UtilidadesGiros.getInstance().aplicarPresentacion(strMensaje, null));
			
			//strMensaje = "probando ";
			
			//System.out.println(strMensaje);
			
			//System.out.println(UtilidadesGiros.getInstance().initcap(strMensaje));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public Object ejecutarMetodo(Object pObjClase, 
								 String pStrMetodoLLamado, 
								 Object ...pArrObjParametros) throws Exception {
		
		Class<?> clsClaseCargada;
		Method[] arrMthMetodos;
		Method mthMetodoBuscado;
		Object objTmpClass;
		Object objResultado;
		
		if(pObjClase!=null){
			
			if(pObjClase instanceof String){
				
				objTmpClass = Class.forName(pObjClase.toString()).newInstance();
				
			}else{
				
				objTmpClass = pObjClase;
			}
			
			objResultado = objTmpClass;
			clsClaseCargada = objTmpClass.getClass();
		
			arrMthMetodos=clsClaseCargada.getDeclaredMethods();

			if(pStrMetodoLLamado!=null
					&& !pStrMetodoLLamado.isEmpty()){
				
				mthMetodoBuscado=null;
				
				for(int i=0;i<arrMthMetodos.length;i++){

					if(arrMthMetodos[i].getName().equals(pStrMetodoLLamado)){
						
						mthMetodoBuscado=arrMthMetodos[i];
						break;
					}
				}
				
				if(mthMetodoBuscado!=null){

					try{

						objResultado=mthMetodoBuscado.invoke(objTmpClass, 
															 pArrObjParametros);
					}catch(IllegalArgumentException iae){
						
						System.err.println("Tipos de parametros incompatibles, para ejecutar el metodo: " + pStrMetodoLLamado);
						throw iae;
					}

				}else{
					System.err.println("Metodo "+pStrMetodoLLamado+", no encontrado sobre la clase: "+pObjClase);
				}
			}
			
		}else{
			
			objResultado=null;
		}

		return objResultado;
	}
	
	/**
	 * ********************************************************************
	 * @method 	protegerDatosTrama
	 * 		   	Metodo encargado de proteger datos especificos de la trama
	 * @param	pStrTramaSimple
	 * 			Representa una trama simple (un delimitador), que se procesara 
	 * 			para proteger los datos
	 * @param 	pStrDelimitador
	 * 			Delimtador de trama, que permitira detectar los tokens de esta
	 * @param 	pStrReemplazarX
	 * 			Caracter por el cual se realizara el reemplazo y rellenara el
	 * 			token detectado para proteger
	 * @param 	pIntPosDatosProtegidos
	 * 			Especifica el listado de datos/tokens de trama que se 
	 * 			protegeran
	 * @return	String
	 * 			Devuelve la trama con los datos/tokens solicitados a proteger
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
	 * 			presentada 
	 * @author 	hector.cuenca
	 * @date   	12/01/2017
	 * *********************************************************************
	 */
	public	static	String	protegerDatosTrama	(	String	pStrTramaSimple,
													String	pStrDelimitador,
													String	pStrReemplazarX,
													Integer	...	pIntPosDatosProtegidos
												)
	throws	Exception
	{
		List<Integer>	lstIntPosDatosProtegidos;
		String[]	arrStrTrama;
		String 		strTramaProtegida;
		String 		strDatoTrama;
		
		lstIntPosDatosProtegidos	=	Arrays.asList(pIntPosDatosProtegidos);
		
		arrStrTrama	=	pStrTramaSimple.split("\\"+pStrDelimitador);
		
		strTramaProtegida	=	"";
		
		for	(	int i=0	;	i<arrStrTrama.length	;	i++	)
		{
			strDatoTrama	=	arrStrTrama[i];
			
			if	(		!lstIntPosDatosProtegidos.isEmpty()
					&&	lstIntPosDatosProtegidos.contains(i)	)
			{
				strDatoTrama	=	String.format	(	"%1$-"+strDatoTrama.length()+"s", 
														""
													).replace	(	" ", 
																	pStrReemplazarX
																);
			}
			
			strTramaProtegida	+=	strDatoTrama+pStrDelimitador;
		}
		
		return strTramaProtegida;
	}

	public String aplicarLongitudCadena	(	String pStrLinea,
									   		int pIntAnchoLinea,
									   		boolean pBooDerechaIzquierda
									   	)
		throws Exception
	{
		String strRespuesta;
		String strLado;
		
		strLado = pBooDerechaIzquierda?"-":"";
		
		strRespuesta = String.format("%1$"+
										strLado+
										pIntAnchoLinea+
										"s",
									 pStrLinea.replaceAll("\\s+$",
											 			  ""));
		return strRespuesta;
	}
	
	/**
	 * Metodo encargado de enmascarar datos sensibles. Este dato tendra
	 * visible la cantidad de datos que sea ingresado en
	 * el parametro: pNum. ejemplo: XXXXXXX601
	 *  
	 * @metodo: proteccionInfo
	 * @param pStrval
	 * @param pNum
	 * @return String
	 * @autor: Monica Llano
	 * @copyright: Copyright 1998-2018 CODESA, Todos los derechos reservados.
	 *             ***********************************************************
	 */

	public static String proteccionInfo(String pStrval, int pNum){
		
		//Dato que sera enmascarado con "X".
		String valforma = "";
		
		try {
			if(pStrval.length()>pNum){
				for(int i=0;i<pStrval.length()- pNum;i++){
					valforma+="X";
				}
				valforma+=pStrval.substring(pStrval.length()-pNum, pStrval.length());
			}else{
				valforma=pStrval;
			}
		} catch (Exception e) {
			valforma = "";
		}
		
		return valforma;
	}
	
	
	public static void main(String args[]) throws Exception{
		
		UtilidadesGiros.mainCifrarDescifrarSIMS(args);
		
		//UtilidadesGiros.mainAplicarPresentacion(args);
	}
}
