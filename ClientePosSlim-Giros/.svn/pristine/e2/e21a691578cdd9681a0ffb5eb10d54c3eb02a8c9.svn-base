package co.com.codesa.clienteposslimgiros.utilidades.biometria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.Arrays;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.enumeraciones.cifrados.EnumProcesosCifrado;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.biometria.BiometriaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.HuellaBiometria;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 14-abr-2015
 * @Clase UtilWSQ 
 * 		  Clase utilitaria relacionada con el objeto de negocio 
 * 		  concepto
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilWSQ {
	
	/**
	 * @variable	boo_ACSTRWSQ
	 * 				Bandera que permite activar servicio transmision archivos WSQ 
	 * 				[S] = Si [N] = No con valor S se activa y N lo inactiva
	 */
	private Boolean boo_ACSTRWSQ;
	
	/**
	 * @variable	int_TMCTRWSQ
	 * 				Cantidad de tiempo en segundos de espera para transmitir WSQ
	 */
	private Integer int_TMCTRWSQ; 
	
	/**
	 * @variable	int_CNCREWSQ
	 * 				Cantidad de caracteres a enviar de huella wsq por bloque en trama
	 */
	private Integer int_CNCREWSQ;
	
	/**
	 * @variable	int_TAMARWSQ
	 * 				Tamano maximo de archivo huella wsq permitido para transmitir 
	 * 				representado en KB
	 */
	private Integer int_TAMARWSQ;
	
	/**
	 * @variable	str_DIREHUWS
	 * 				Nombre de la carpeta donde se almacenan temporalmente las WSQ de 
	 * 				la biometría local
	 */
	private String str_DIREHUWS;
	
	/**
	 * @variable	int_TIESTRAR
	 * 				Cantidad de tiempo de pausa representado en segundos para transmitir 
	 * 				cada archivo de huellas wsq
	 */
	private Integer int_TIESTRAR;
	
	/**
	 * @variable	int_CAMAPEEN
	 * 				Capacidad maxima almacenamiento en carpeta permitida para enrolar 
	 * 				localmente representado en MB [Mega Bytes] Con [-1] no aplica control
	 */
	private Integer int_CAMAPEEN;
	
	/**
	 * @variable	int_CAMIALEL
	 * 				Capacidad minima almacenamiento en carpeta para lanzar alerta al momento 
	 * 				de enrolar local representado en MB [Mega bytes] Con [-1] no aplica control
	 */
	private Integer int_CAMIALEL;
	
	/**
	 * @variable	boo_DEPRENLO
	 * 				Detiene el proceso de enrolamiento local si cumple con el parametro de sistema 
	 * 				CAMAPEEN S = Si y N = No
	 */
	private Boolean boo_DEPRENLO;
	
	/**
	 * @variable	boo_ENALENLO
	 * 				Produce alerta si cumple con el parametro de sistema CAMIALEL S = Si y N = No
	 */
	private Boolean boo_ENALENLO;
	
	/**
	 * @variable	strRutaDirectorioWSQ
	 * 				Ruta local donde se almacenan los WSQ a transmitir
	 */
	private String strRutaDirectorioWSQ;
	
	/**
	 * @variable	filDirectorioWSQ
	 * 				Directorio local donde se almacenan los WSQ a transmitir
	 */
	private File filDirectorioWSQ;
	
	/**
	 * @variable	enmTipoBiometriaCaja
	 * 				Representa la constante que identifica el tipo de biometria configurada 
	 * 				para la caja
	 */
	private EnumTiposBiometriaCaja enmTipoBiometriaCaja;
	
	/**
	 * @variable	booHiloTransmisorCorriendo
	 * 				Bandera que permite detectar si el proceso paralelo para transmitir los WSQ
	 * 				esta activo, y controlar si debe o no re-activar el proceso 
	 */
	private boolean booHiloTransmisorCorriendo;

	/**
	 * @variable	strExtensionWSQ
	 * 				Representa la extension del archivo WSQ, ya disponible para el proceso de
	 * 				transmision WSQ que se ejecuta en paralelo
	 */
	private final String strExtensionWSQ;
	
	/**
	 * @variable	strExtensionWSQTemporal
	 * 				Representa la extension del archivo WSQ de manera temporal, es decir
	 * 				durante su proceso de registro localmente
	 */
	private final String strExtensionWSQTemporal;
	
	/**
	 * @variable 	instancia 
	 * 				Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 	SINGLETON (patron de diseño)
	 **/
	private static UtilWSQ instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo UtilWSQ
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilWSQ() 
			throws Exception
	{	
		this.setInt_TMCTRWSQ(16);
		this.strExtensionWSQ=".wsq";
		this.strExtensionWSQTemporal=this.strExtensionWSQ+"tmp";
	}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilMediosPago
  	 * 		   Tipo referente a la misma clase
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilWSQ getInstance()throws Exception{
		
		if (instancia == null) {
			
			instancia = new UtilWSQ();
		}
		
		return instancia;
	}
	
	/** 
	 * ********************************************************************
	 * @method	crearArchivosWSQ
	 * 		  	Metodo que permite materializar los archivos WSQ de huellas, 
	 * 			para almancenamiento local, exclusivo para el proceso de 
	 * 			biometria local
	 * @param	pObjTercero
	 * 			Tercero referente al proceso 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	31/08/2017
	 * *********************************************************************
	 */
	public void crearArchivosWSQ	(	Tercero pObjTercero	)
			throws Exception
	{
		this.validarAdvertenciasDirectorioWSQ();
		
		try{
		
			this.crearArchivoWSQXHuella	(	pObjTercero,
			                           	 	pObjTercero.getObjBiometria ().getHuellaDerecha ()
			                           	);
			
			this.crearArchivoWSQXHuella	(	pObjTercero,
			                           	 	pObjTercero.getObjBiometria ().getHuellaIzquierda ()
			                           	);
		}	catch	(	Exception e	)
		{
			UtilidadesGiros.getInstance ().controlExcepcion ( e, null, false );
			
			this.eliminarArchivosWSQ ( pObjTercero );
			
			throw EnumMensajes.ERROR_GENERANDO_ARCHIVOS_WSQ_HUELLAS_TERCERO.generarExcepcion(	EnumClasesMensaje.ERROR	);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	finalizarArchivosWSQparaTransmision
	 * 		  	Metodo que se encarga de finalizar los archivos WSQ generados
	 * 			para un tercero, y colocarlos a disposicion del proceso paralelo
	 * 			de transmision WSQ
	 * @param	pObjTercero
	 * 			Tercero del cual se estan procesando para finalizar los archivos 
	 * 			WSQ referente a sus huellas 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	public void finalizarArchivosWSQparaTransmision(	Tercero pObjTercero	) 
			throws Exception
	{
		
		this.finalizarArchivoWSQXHuella(pObjTercero.getObjBiometria ().getHuellaDerecha ());
		this.finalizarArchivoWSQXHuella(pObjTercero.getObjBiometria ().getHuellaIzquierda ());
	}
	
	/** 
	 * ********************************************************************
	 * @method	finalizarArchivoWSQXHuella
	 * 		  	Metodo que se encarga de finalizar el archivo WSQ para una 
	 * 			huella, y colocarla a disposicion del proceso paralelo de
	 * 			transmision WSQ
	 * @param 	pObjHuellaTercero
	 * 			Huella del tercero a la que se finalizara su archivo WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	private void finalizarArchivoWSQXHuella	(	HuellaBiometria pObjHuellaTercero	)
			throws Exception
	{
		if	(		pObjHuellaTercero	!=	null
				&&	pObjHuellaTercero.getFilArchivoWSQ ()	!=	null
			)
		{
			pObjHuellaTercero.setFilArchivoWSQ ( this.finalizarArchivoWSQ(pObjHuellaTercero.getFilArchivoWSQ ()) );
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	finalizarArchivoWSQParaTransmision
	 * 		  	Metodo que permite colocar a disposicion del proceso en 
	 * 			paralelo referente a la transmision WSQ, el nuevo archivo WSQ
	 * 			generado previamente.
	 * @param 	pFilArchivoWSQ
	 * 			Archivo WSQ que se colocara a disposicion
	 * @return	File
	 * 			Nuevo archivo WSQ ya finalizado y puesto a disposicion del 
	 * 			proceso paralelo de transmision WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	private File finalizarArchivoWSQ(	File pFilArchivoWSQ	)
			throws Exception
	{
		File filArchivoWSQFinalizado;
		
		filArchivoWSQFinalizado	=	new File(pFilArchivoWSQ.getAbsolutePath ().replaceAll ( this.getStrExtensionWSQTemporal()+"$", this.getStrExtensionWSQ() ));
		
		pFilArchivoWSQ.renameTo (  filArchivoWSQFinalizado	);
		
		return filArchivoWSQFinalizado;
	}
	
	/** 
	 * ********************************************************************
	 * @method	eliminarArchivosWSQ
	 * 		  	Metodo que permite eliminar los archivos WSQ materializados
	 * 			para el tercero en proceso
	 * @param 	pObjTercero
	 * 			Tercero al que se le ejecutaran las acciones para eliminar
	 * 			sus archivos WSQ generados y/o cargados previamente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	public void eliminarArchivosWSQ	(	Tercero pObjTercero	)
			throws Exception
	{
		HuellaBiometria objHueBioHuella;
		
		if	(		(objHueBioHuella	=	pObjTercero.getObjBiometria ().getHuellaDerecha ())	!=	null
				&&	objHueBioHuella.getFilArchivoWSQ ()	!=	null
			)
		{
			this.eliminarArchivoWSQ(objHueBioHuella.getFilArchivoWSQ ());
			objHueBioHuella.setFilArchivoWSQ ( null );
		}
		
		if	(		(objHueBioHuella	=	pObjTercero.getObjBiometria ().getHuellaIzquierda ())	!=	null
				&&	objHueBioHuella.getFilArchivoWSQ ()	!=	null
			)
		{
			this.eliminarArchivoWSQ(objHueBioHuella.getFilArchivoWSQ ());
			objHueBioHuella.setFilArchivoWSQ ( null );
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	eliminarArchivoWSQ
	 * 		  	Metodo que permite eliminar un archivo WSQ generado y/o cargado
	 * 			previamente
	 * @param 	filArchivoWSQ
	 * 			Referente al archivo WSQ que se preve eliminar
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	5/09/2017
	 * *********************************************************************
	 */
	public void eliminarArchivoWSQ	(	File filArchivoWSQ	)
			throws Exception
	{
		if	(	filArchivoWSQ	!=	null	)
		{
			filArchivoWSQ.delete ();
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarAdvertenciasDirectorioWSQ
	 * 		  	Metodo que permite validar, detectar y de ser el caso, provocar
	 * 			una advertencia en el sistema, con respecto al directorio 
	 * 			definido para el almacenamiento de los WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 * *********************************************************************
	 */
	private void validarAdvertenciasDirectorioWSQ() 
			throws Exception
	{
		double douPesoMbContenidoDirectorioWSQ	=	-1;
		
		this.cargarParametrosGeneracionWSQ();
		
		if	(		this.getInt_CAMAPEEN ()	>	-1
				&&	this.getBoo_DEPRENLO ()
			)
		{
			douPesoMbContenidoDirectorioWSQ	=	this.calcularPesoMbContenidoDirectorioWSQ();
			if	(	douPesoMbContenidoDirectorioWSQ	>=	this.getInt_CAMAPEEN ()	)
			{
				throw EnumMensajes.DIRECTORIO_WSQ_SUPERO_PESO_MAXIMO_PERMITIDO_BIOMETRIA_LOCAL_DETENIDO.generarExcepcion(	EnumClasesMensaje.ADVERTENCIA	,
				                                                                                                         	String.valueOf(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getInt_CAMAPEEN ())),
				                                                                                                         	String.valueOf ( UtilidadGiros.getInstancia().formatoPresentacionNumero(douPesoMbContenidoDirectorioWSQ) )
				                                                                                                       	);
			}
		}
		
		if	(		this.getInt_CAMIALEL ()	>	-1
				&&	this.getBoo_ENALENLO ()
			)
		{
			if	(	douPesoMbContenidoDirectorioWSQ	==	-1	)
			{
				douPesoMbContenidoDirectorioWSQ	=	this.calcularPesoMbContenidoDirectorioWSQ();
			}
			
			if	(	douPesoMbContenidoDirectorioWSQ	>=	this.getInt_CAMIALEL ()	)
			{
				EnumMensajes.PESO_DIRECTORIO_WSQ_ESTA_LLEGANDO_A_MAXIMO_PERMITIDO.desplegarMensaje	(	null,
				                                                                                  	 	EnumClasesMensaje.ADVERTENCIA	,
				                                                                                  	 	String.valueOf(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getInt_CAMIALEL ())),
				                                                                                  	 	String.valueOf ( UtilidadGiros.getInstancia().formatoPresentacionNumero(douPesoMbContenidoDirectorioWSQ) )
				                                                                                 	);
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	calcularPesoMbContenidoDirectorioWSQ
	 * 		  	Metodo que permite calcular el peso en Mb del contenido 
	 * 			almacenado en el directorio WSQ
	 * @return	double
	 * 			Peso calculado del contenido del directorio WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 * *********************************************************************
	 */
	private double calcularPesoMbContenidoDirectorioWSQ()
			throws Exception
	{
		File[] arrFilContenidoDirectorioWSQ;
		int intTotalPesoDirectorioWSQBytes;
		
		intTotalPesoDirectorioWSQBytes	=	0;
		arrFilContenidoDirectorioWSQ	=	this.getFilDirectorioWSQ ( false ).listFiles ();
		
		for(File filArchivo	:	arrFilContenidoDirectorioWSQ)
		{
			intTotalPesoDirectorioWSQBytes	+=	filArchivo.length ();
		}
		
		return (double)intTotalPesoDirectorioWSQBytes/(double)(1024*1024);
	}
	
	/** 
	 * ********************************************************************
	 * @method	crearArchivoWSQXHuella
	 * 		  	Metodo que permite materializar el archivo WSQ por huella
	 * @param	pObjTercero
	 * 			Tercero referente al proceso
	 * @param	pObjHuellaTercero
	 * 			Huella de interes a procesar
	 * @return	File
	 * 			Archivo WSQ generado por huella
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	31/08/2017
	 * *********************************************************************
	 */
	private File crearArchivoWSQXHuella	(	Tercero pObjTercero,
	                                  	 	HuellaBiometria pObjHuellaTercero
	                                  	)
			throws Exception
	{
		BufferedWriter bufWri;
		File filArchivoWSQ;
		String strRutaArchivoWSQ;
		String strContenidoArchivoWSQ;
		
		strRutaArchivoWSQ	=		this.getStrRutaDirectorioWSQ ( false )
								+	pObjTercero.getTipoIdentificacion ().getId ()		+"_"
								+	pObjTercero.getIdentificacion ()					+"_"
								+	pObjTercero.getObjBiometria ().getStrIdHuella ()	
								+	pObjHuellaTercero.getStrTipo ()						+this.getStrExtensionWSQTemporal ()
								;
		
		strContenidoArchivoWSQ	=		pObjHuellaTercero.getStrCodigoAgenciaEnrola ()	+"|"
									+	pObjHuellaTercero.getStrCodigoCajaEnrola ()		+"#"
									+	pObjHuellaTercero.getStrWsq ()
									;
		
		strContenidoArchivoWSQ	=	EnumProcesosCifrado.ARCHIVOS_WSQ.cifrar(strContenidoArchivoWSQ);
		
		filArchivoWSQ	=	new File(strRutaArchivoWSQ);
		
		bufWri = new BufferedWriter(new FileWriter(filArchivoWSQ));
		bufWri.write(strContenidoArchivoWSQ);
		
		bufWri.close();
		
		pObjHuellaTercero.setFilArchivoWSQ ( filArchivoWSQ );
		
		return filArchivoWSQ;
	}
	
	/** 
	 * ********************************************************************
	 * @method	transmitirWSQ
	 * 		  	Metodo encargado de desplegar el proceso en paralelo para 
	 * 			la transmision WSQ
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 * *********************************************************************
	 */
	public void desplegarHiloTransmisorWSQ() 
			throws Exception
	{
		if	(		InformacionSessionGiros.getInstance().getObjUsuario()!= null 
				&&	InformacionSessionGiros.getInstance().getObjUsuario().isAutenticado()
			)
		{
			if	(	!this.isBooHiloTransmisorCorriendo ()	)
			{
				new Thread("Hilo_Transmision_Huellas")
				{
					public void run()
					{
						setBooHiloTransmisorCorriendo(true);
						transmitirWSQ ();
						setBooHiloTransmisorCorriendo(false);
					}
				}.start ();
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	transmitirWSQ
	 * 		  	Metodo encargado de desplegar el proceso de transmision WSQ
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 * *********************************************************************
	 */
	private void transmitirWSQ() 
	{
		do{
			try{
				
				Thread.sleep(this.getInt_TMCTRWSQ(false));
				
				this.cargarParametrosTransmisionWSQ();
				
				if	(		this.isBoo_ACSTRWSQ (false)
						&&	EnumTiposBiometriaCaja.LOCAL.equals ( this.getEnmTipoBiometriaCaja (false) )
					)
				{
					this.ejecutarTransmisionWSQ();
					
					continue;
				}else{
					break;
				}
				
			}	catch	(	Exception e	)
			{
				UtilidadesGiros.getInstance ().controlExcepcion ( e, null,false );
				continue;
			}
		
		}	while	(true);
	}

	/** 
	 * ********************************************************************
	 * @method	ejecutarTransmisionWSQ
	 * 		  	Metodo que permite ejecutar y desplegar el proceso de 
	 * 			transmision de los WSQ
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	29/08/2017
	 * *********************************************************************
	 */
	private void ejecutarTransmisionWSQ() 
			throws Exception
	{
		File[] arrFilWSQAlmacenados;
		
		arrFilWSQAlmacenados	=	this.obtenerContenidoDirectorioWSQ();
		
		if	(		arrFilWSQAlmacenados	!=	null
				&&	arrFilWSQAlmacenados.length	>	0 
			)
		{
			for	(	File filWSQAlmacenado	:	arrFilWSQAlmacenados)
			{
				if	(	this.transmitirArchivoWSQ(filWSQAlmacenado)	)
				{
					this.eliminarArchivoWSQ ( filWSQAlmacenado );
				}
				Thread.sleep(this.getInt_TIESTRAR ( false ));
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	transmitirArchivoWSQ
	 * 		  	Metodo que permite transmitir el archivo WSQ
	 * @param	pFilWSQ
	 * 			Archivo a procesar
	 * @return	boolean
	 * 			Bandera que identifica si el proceso de transmision se 
	 * 			completo de manera existosa o no, true o false respectivamente 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 * *********************************************************************
	 */
	private boolean transmitirArchivoWSQ(File pFilWSQ)
			throws Exception
	{
		String[] arrDatosNombreArchivoWSQ;
		String[] arrStrContenidoArchivoWSQ;
		byte[] arrBytHuellaWSQ;
		byte arrBloques[ ];
		
		Tercero objTercero;
		String strHuellaWSQParcial;
		int intPesoArchivoWSQ;
		int intCantBloques;
		boolean booTransmitido = false;
		
		try{
			
			intPesoArchivoWSQ	=	this.obtenerPesoArchivoWSQ ( pFilWSQ );
			
			if	(	intPesoArchivoWSQ	<=	this.getInt_TAMARWSQ ( false )	)
			{
				arrDatosNombreArchivoWSQ	=	this.procesarNombreArchivoWSQ(pFilWSQ);
				
				objTercero = new Tercero(	new DatoEntidad(arrDatosNombreArchivoWSQ[0]),
				                         	arrDatosNombreArchivoWSQ[1]
				                        );
				objTercero.getObjBiometria ().gestionarHuellaDerecha ().setStrTipo ( arrDatosNombreArchivoWSQ[2] );
				
				arrStrContenidoArchivoWSQ	=	this.procesarContenidoArchivoWSQ(pFilWSQ);
				
				objTercero.getObjBiometria ().getHuellaDerecha ().setStrCodigoAgenciaEnrola ( arrStrContenidoArchivoWSQ[0] );
				objTercero.getObjBiometria ().getHuellaDerecha ().setStrCodigoCajaEnrola ( arrStrContenidoArchivoWSQ[1] );
				
				arrBytHuellaWSQ	=	arrStrContenidoArchivoWSQ[2].getBytes ();
				
				intCantBloques    =   (int)(Math.ceil ((double)arrBytHuellaWSQ.length/(double)this.getInt_CNCREWSQ ( false )));
				
				for(int i=0; i<intCantBloques; i++)
	            {
					if(    (i+1) == intCantBloques)
	                {
	                    arrBloques = Arrays.copyOfRange(arrBytHuellaWSQ, i*this.getInt_CNCREWSQ ( false ), arrBytHuellaWSQ.length);
	                    objTercero.getObjBiometria ().getHuellaDerecha ().setStrEstadoTransmision ("F");
	                    
	                }	else	{
	                	
	                    arrBloques = Arrays.copyOfRange(arrBytHuellaWSQ, i*this.getInt_CNCREWSQ ( false ), (i+1)*this.getInt_CNCREWSQ ( false ));
	                    objTercero.getObjBiometria ().getHuellaDerecha ().setStrEstadoTransmision ("P");
	                }
					
					strHuellaWSQParcial	=	new String(arrBloques);
					
					objTercero.getObjBiometria ().getHuellaDerecha ().setStrWsq ( strHuellaWSQParcial );
					objTercero.getObjBiometria ().getHuellaDerecha ().setIntConsecutivoTransmision ( i+1 );
					
					BiometriaVistaLogica.getInstance ().transmitirHuellaWSQ ( InformacionSessionGiros.getInstance().getObjUsuario(), 
					                                                          objTercero, 
					                                                          objTercero.getObjBiometria ().getHuellaDerecha () 
					                                                      	);
	            }
				
				booTransmitido = true;
			}
		
		}catch(Exception e)
		{
			UtilidadesGiros.getInstance ().controlExcepcion ( e, null,false );
		}
		
		return booTransmitido;
	}
	
	/** 
	 * ********************************************************************
	 * @method	procesarContenidoArchivoWSQ
	 * 		  	Metodo que permite procesar y obtener los valores registrados
	 * 			en el contenido del archivo WSQ
	 * @param 	pFilWSQ
	 * 			Archivo WSQ a procesar
	 * @return	String[]
	 * 			Listado de valores recuperados del contenido del archivo:
	 * 				[0]: Codigo de la agencia que enrolo
	 * 				[1]: Codigo de la caja que enrolo
	 * 				[2]: Huella WSQ
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 * *********************************************************************
	 */
	private String[] procesarContenidoArchivoWSQ(File pFilWSQ)
			throws Exception
	{
		String[] arrStrContenido;
		String strContenido;
		
		//86865006|23894#FFA0FFA8007A4E4953545F434F4D20390A5049585F5749445448203235360A5049585....
		strContenido	=	this.obtenerContenidoArchivoWSQ(pFilWSQ);
		
		arrStrContenido	=	strContenido.split ( EnumExpresionesRegulares.BIO_CONTENIDO_ARCHIVO_WSQ.getValor () );
		
		return arrStrContenido;
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerContenidoArchivoWSQ
	 * 		  	Metodo que permite obtener el contenido de un archivo WSQ
	 * @param 	pFilWSQ
	 * 			Archivo WSQ a obtener su contenido
	 * @return	String
	 * 			Contenido del archivo WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 * *********************************************************************
	 */
	private String obtenerContenidoArchivoWSQ(File pFilWSQ)
			throws Exception
	{
		BufferedReader bufReaWSQ;
		String strContenido = "";
		String strLinea;
		
		bufReaWSQ = new BufferedReader(new FileReader(pFilWSQ));
		
		while	(	(	strLinea = bufReaWSQ.readLine()	)	!=	null	)
		{
			strContenido += strLinea;
		}
		
		bufReaWSQ.close();
		
		if	(	!strContenido.trim ().isEmpty ()	)
		{
			strContenido	=	EnumProcesosCifrado.ARCHIVOS_WSQ.descifrar(strContenido);
		}	else	{
			strContenido	=	null;
		}
		
		return strContenido;
	}
	
	/** 
	 * ********************************************************************
	 * @method	procesarNombreArchivoWSQ
	 * 		  	Metodo que permite procesar y recuperar del nombre del archivo
	 * 			WSQ algunos datos de interes para el proceso
	 * @param 	pFilWSQ
	 * 			Archivo WSQ a procesar
	 * @return	String[]
	 * 			Listado de valores recuperados del nombre del archivo:
	 * 				[0]: Tipo de identificacion
	 * 				[1]: Identificacion
	 * 				[2]: Tipo huella (D: Derecha, I: Izquierda)
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 * *********************************************************************
	 */
	private String[] procesarNombreArchivoWSQ(File pFilWSQ)
			throws Exception
	{
		String[] arrDatosArchivoWSQ;
		
		//3_85246_20170824095221I.wsq
		arrDatosArchivoWSQ	=	pFilWSQ.getName ().split ( "_" );
		arrDatosArchivoWSQ[2] =arrDatosArchivoWSQ[2].replaceAll ( EnumExpresionesRegulares.BIO_TIPO_HUELLA_NOMBRE_ARCHIVO_WSQ.getValor (), "" );
		
		return arrDatosArchivoWSQ;
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerPesoArchivoWSQ
	 * 		  	Metodo que permite obtener el peso de un archivo WSQ 
	 * 			seleccionado para su transmision
	 * @param	pFilWSQ
	 * 			Archivo WSQ a transmitir
	 * @return	int
	 * 			Peso del archivo WSQ a transmitir
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	29/08/2017
	 * *********************************************************************
	 */
	private int obtenerPesoArchivoWSQ(	File pFilWSQ	) 
			throws Exception
	{
		BufferedReader bufReaWSQ;
		String strContenido = "";
		String strLinea;
		
		bufReaWSQ = new BufferedReader(new FileReader(pFilWSQ));
		
		while	(	(	strLinea = bufReaWSQ.readLine()	)	!=	null	)
		{
			strContenido += strLinea;
		}
		
		bufReaWSQ.close();
		
		strContenido	=	EnumProcesosCifrado.ARCHIVOS_WSQ.descifrar(strContenido);;
		
		return strContenido.length ();
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerContenidoDirectorioWSQ
	 * 		  	Metodo encargado de obtener el contenido del directorio WSQ
	 * 			y recuperar los archivos de interes a transmitir
	 * @return	File[]
	 * 			Listado de archivos WSQ recuperados
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	29/08/2017
	 * *********************************************************************
	 */
	private File[] obtenerContenidoDirectorioWSQ()
			throws Exception
	{
		return this.getFilDirectorioWSQ ( false ).listFiles (	new FilenameFilter() 
																{
																	public boolean accept(File dir, String name) {
																		return name.toLowerCase().endsWith(".wsq");
																	
																	}
																} );
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarParametrosGeneracionWSQ
	 * 		  	Metodo encargado de consultar y re-validar los parametros de 
	 * 			ejecucion por cada vez que se ejecute un proceso completo de 
	 * 			transmision WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 * *********************************************************************
	 */
	private void cargarParametrosGeneracionWSQ() 
			throws Exception
	{
		UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.MAXIMO_ALMACENAMIENTO_DIRECTORIO_WSQ,
		                                              	EnumParametrosSistema.MINIMO_ALMACENAMIENTO_DIRECTORIO_WSQ_LANZAR_ALERTA,
		                                              	EnumParametrosSistema.DETIENE_ENROLAMIENTO_LOCAL_AL_SUPERAR_PARAMETRO_CAMAPEEN,
		                                              	EnumParametrosSistema.ACTIVA_ALERTA_AL_SUPERAR_PARAMETRO_CAMIALEL
		                                             );
		
		this.setInt_CAMAPEEN ( EnumParametrosSistema.MAXIMO_ALMACENAMIENTO_DIRECTORIO_WSQ.obtenerValorEntero ());
		this.setInt_CAMIALEL ( EnumParametrosSistema.MINIMO_ALMACENAMIENTO_DIRECTORIO_WSQ_LANZAR_ALERTA.obtenerValorEntero ());
		this.setBoo_DEPRENLO ( EnumParametrosSistema.DETIENE_ENROLAMIENTO_LOCAL_AL_SUPERAR_PARAMETRO_CAMAPEEN.obtenerValorBooleano ( "S" ) );
		this.setBoo_ENALENLO ( EnumParametrosSistema.ACTIVA_ALERTA_AL_SUPERAR_PARAMETRO_CAMIALEL.obtenerValorBooleano ( "S" ) );
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarParametrosTransmisionWSQ
	 * 		  	Metodo encargado de consultar y re-validar los parametros de 
	 * 			ejecucion por cada vez que se ejecute un proceso completo de 
	 * 			transmision WSQ
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 * *********************************************************************
	 */
	private void cargarParametrosTransmisionWSQ() 
			throws Exception
	{
		UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.ACTIVA_TRANSMISION_WSQ,
		                                              	EnumParametrosSistema.TIEMPO_VALIDAR_EXISTENCIA_ARCHIVOS_WSQ_PARA_TRANSMISION,
		                                              	EnumParametrosSistema.CANTIDAD_CARACTERES_ENVIO_HUELLA_WSQ,
		                                              	EnumParametrosSistema.PESO_MAXIMO_ARCHIVO_WSQ_PERMITIDO_PARA_TRANSMISION_KB,
		                                              	EnumParametrosSistema.NOMBRE_DIRECTORIO_ALMACENAMIENTO_WSQ,
		                                              	EnumParametrosSistema.TIEMPO_PAUSA_ENTRE_CADA_TRANSMISION_WSQ
		                                             );
		
		this.setBoo_ACSTRWSQ ( EnumParametrosSistema.ACTIVA_TRANSMISION_WSQ.obtenerValorBooleano ( "S" ) );
		this.setInt_TMCTRWSQ ( EnumParametrosSistema.TIEMPO_VALIDAR_EXISTENCIA_ARCHIVOS_WSQ_PARA_TRANSMISION.obtenerValorEntero ());
		this.setInt_CNCREWSQ ( EnumParametrosSistema.CANTIDAD_CARACTERES_ENVIO_HUELLA_WSQ.obtenerValorEntero() );
		this.setInt_TAMARWSQ ( EnumParametrosSistema.PESO_MAXIMO_ARCHIVO_WSQ_PERMITIDO_PARA_TRANSMISION_KB.obtenerValorEntero());
		this.setStr_DIREHUWS ( EnumParametrosSistema.NOMBRE_DIRECTORIO_ALMACENAMIENTO_WSQ.obtenerValorCadena () );
		this.setInt_TIESTRAR ( EnumParametrosSistema.TIEMPO_PAUSA_ENTRE_CADA_TRANSMISION_WSQ.obtenerValorEntero ());
		
		this.setEnmTipoBiometriaCaja ( CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja(InformacionSessionGiros.getInstance().getObjUsuario()) );
	}
	
	/** 
	 * ********************************************************************
	 * @method	reValidarParametrosEjecucion
	 * 		  	Metodo que permite validar si se debe proceder con la 
	 * 			re-carga de todos los parametros de ejecucion vinculados en 
	 * 			el proceso de transmision WSQ
	 * @param 	pBooReValidar
	 * 			Bandera que en caso de ser null, procede a re-cargar los 
	 * 			parametros de ejecucion del proceso de transmision WSQ
	 * @return	Boolean
	 * 			Valor de la bandera recibido
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	29/08/2017
	 * *********************************************************************
	 */
	private Boolean reValidarParametrosEjecucion(	Boolean pBooReValidar	)
			throws Exception
	{
		if	(	pBooReValidar	==	null	){
			
			this.cargarParametrosTransmisionWSQ ();
			pBooReValidar = false;
		}
		
		return pBooReValidar;
	}
	
	/**
	 * @method	getInt_TMCTRWSQ
	 * 		  	Metodo get del atributo int_TMCTRWSQ
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	Integer
	 *		  	Valor del atributo int_TMCTRWSQ devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public Integer getInt_TMCTRWSQ (	Boolean pBooReValidar	) 
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.int_TMCTRWSQ	==	null
			)
		{
			UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.TIEMPO_VALIDAR_EXISTENCIA_ARCHIVOS_WSQ_PARA_TRANSMISION	);
			this.setInt_TMCTRWSQ ( EnumParametrosSistema.TIEMPO_VALIDAR_EXISTENCIA_ARCHIVOS_WSQ_PARA_TRANSMISION.obtenerValorEntero ());
		}
		
		return int_TMCTRWSQ;
	}

	/**
	 * @method	setInt_TMCTRWSQ
	 * 		  	Metodo set del atributo int_TMCTRWSQ
	 * @param	pInt_TMCTRWSQ
	 * 			Valor que tomara el atributo int_TMCTRWSQ
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setInt_TMCTRWSQ (Integer pInt_TMCTRWSQ)
	{
		this.int_TMCTRWSQ = pInt_TMCTRWSQ*1000;
	}

	/**
	 * @method	isBoo_ACSTRWSQ
	 * 		  	Metodo get del atributo boo_ACSTRWSQ
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	boolean
	 *		  	Valor del atributo boo_ACSTRWSQ devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public boolean isBoo_ACSTRWSQ (	Boolean pBooReValidar	) 
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.boo_ACSTRWSQ	==	null
			)
		{
			UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.ACTIVA_TRANSMISION_WSQ	);
			this.setBoo_ACSTRWSQ ( EnumParametrosSistema.ACTIVA_TRANSMISION_WSQ.obtenerValorBooleano ( "S" ) );
		}
		
		return this.boo_ACSTRWSQ;
	}

	/**
	 * @method	setBoo_ACSTRWSQ
	 * 		  	Metodo set del atributo boo_ACSTRWSQ
	 * @param	pBoo_ACSTRWSQ
	 * 			Valor que tomara el atributo boo_ACSTRWSQ
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setBoo_ACSTRWSQ (boolean pBoo_ACSTRWSQ)
	{
		this.boo_ACSTRWSQ = pBoo_ACSTRWSQ;
	}

	/**
	 * @method	getInt_CNCREWSQ
	 * 		  	Metodo get del atributo int_CNCREWSQ
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	Integer
	 *		  	Valor del atributo int_CNCREWSQ devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public Integer getInt_CNCREWSQ (	Boolean pBooReValidar	) 
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.int_CNCREWSQ	==	null
			)
		{
			UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.CANTIDAD_CARACTERES_ENVIO_HUELLA_WSQ	);
			this.setInt_CNCREWSQ ( EnumParametrosSistema.CANTIDAD_CARACTERES_ENVIO_HUELLA_WSQ.obtenerValorEntero() );
		}
		
		return int_CNCREWSQ;
	}

	/**
	 * @method	setInt_CNCREWSQ
	 * 		  	Metodo set del atributo int_CNCREWSQ
	 * @param	pInt_CNCREWSQ
	 * 			Valor que tomara el atributo int_CNCREWSQ
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setInt_CNCREWSQ (Integer pInt_CNCREWSQ)
	{
		this.int_CNCREWSQ = pInt_CNCREWSQ;
	}

	/**
	 * @method	getInt_TAMARWSQ
	 * 		  	Metodo get del atributo int_TAMARWSQ
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	Integer
	 *		  	Valor del atributo int_TAMARWSQ devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public Integer getInt_TAMARWSQ (	Boolean pBooReValidar	)
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.int_TAMARWSQ	==	null
			)
		{
			UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.PESO_MAXIMO_ARCHIVO_WSQ_PERMITIDO_PARA_TRANSMISION_KB	);
			this.setInt_TAMARWSQ ( EnumParametrosSistema.PESO_MAXIMO_ARCHIVO_WSQ_PERMITIDO_PARA_TRANSMISION_KB.obtenerValorEntero() );
		}
		
		return int_TAMARWSQ;
	}

	/**
	 * @method	setInt_TAMARWSQ
	 * 		  	Metodo set del atributo int_TAMARWSQ
	 * @param	pInt_TAMARWSQ
	 * 			Valor que tomara el atributo int_TAMARWSQ
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setInt_TAMARWSQ (Integer pInt_TAMARWSQ)
	{
		this.int_TAMARWSQ = pInt_TAMARWSQ*1024;
	}

	/**
	 * @method	getStr_DIREHUWS
	 * 		  	Metodo get del atributo str_DIREHUWS
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	String
	 *		  	Valor del atributo str_DIREHUWS devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public String getStr_DIREHUWS (	Boolean pBooReValidar	)
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.str_DIREHUWS	==	null
			)
		{
			UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.NOMBRE_DIRECTORIO_ALMACENAMIENTO_WSQ	);
			this.setStr_DIREHUWS ( EnumParametrosSistema.NOMBRE_DIRECTORIO_ALMACENAMIENTO_WSQ.obtenerValorCadena () );
		}
		
		return str_DIREHUWS;
	}

	/**
	 * @method	setStr_DIREHUWS
	 * 		  	Metodo set del atributo str_DIREHUWS
	 * @param	pStr_DIREHUWS
	 * 			Valor que tomara el atributo str_DIREHUWS
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setStr_DIREHUWS (String pStr_DIREHUWS)
	{
		this.str_DIREHUWS = pStr_DIREHUWS+File.separator;
	}

	/**
	 * @method	getInt_TIESTRAR
	 * 		  	Metodo get del atributo int_TIESTRAR
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	Integer
	 *		  	Valor del atributo int_TIESTRAR devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public Integer getInt_TIESTRAR (	Boolean pBooReValidar	)
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.int_TIESTRAR	==	null
			)
		{
			UtilParametrosSistema.getInstance().consultar(	EnumParametrosSistema.TIEMPO_PAUSA_ENTRE_CADA_TRANSMISION_WSQ	);
			this.setInt_TIESTRAR ( EnumParametrosSistema.TIEMPO_PAUSA_ENTRE_CADA_TRANSMISION_WSQ.obtenerValorEntero ());
		}
		
		return int_TIESTRAR;
	}

	/**
	 * @method	setInt_TIESTRAR
	 * 		  	Metodo set del atributo int_TIESTRAR
	 * @param	pInt_TIESTRAR
	 * 			Valor que tomara el atributo int_TIESTRAR
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setInt_TIESTRAR (Integer pInt_TIESTRAR)
	{
		this.int_TIESTRAR = pInt_TIESTRAR*1000;
	}

	/**
	 * @method	getEnmTipoBiometriaCaja
	 * 		  	Metodo get del atributo enmTipoBiometriaCaja
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir, true para validar,
	 * 			false para no validar, null para re-validar todos los parametros
	 * 			en juego
	 * @return	EnumTiposBiometriaCaja
	 *		  	Valor del atributo enmTipoBiometriaCaja devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	28/08/2017
	 */
	public EnumTiposBiometriaCaja getEnmTipoBiometriaCaja (	Boolean pBooReValidar	) 
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.enmTipoBiometriaCaja	==	null
			)
		{
			this.setEnmTipoBiometriaCaja ( CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja(InformacionSessionGiros.getInstance().getObjUsuario()) );
		}
		
		return enmTipoBiometriaCaja;
	}

	/**
	 * @method	setEnmTipoBiometriaCaja
	 * 		  	Metodo set del atributo enmTipoBiometriaCaja
	 * @param	pEnmTipoBiometriaCaja
	 * 			Valor que tomara el atributo enmTipoBiometriaCaja
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 */
	public void setEnmTipoBiometriaCaja (EnumTiposBiometriaCaja pEnmTipoBiometriaCaja)
	{
		this.enmTipoBiometriaCaja = pEnmTipoBiometriaCaja;
	}

	/**
	 * @method	getStrRutaDirectorioWSQ
	 * 		  	Metodo get del atributo strRutaDirectorioWSQ
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir
	 * @return	String
	 *		  	Valor del atributo strRutaDirectorioWSQ devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	29/08/2017
	 */
	public String getStrRutaDirectorioWSQ (	Boolean pBooReValidar	)
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.strRutaDirectorioWSQ	==	null
			)
		{
			this.strRutaDirectorioWSQ	=	System.getProperty("user.dir")+File.separator+this.getStr_DIREHUWS (pBooReValidar);
		}
		
		return strRutaDirectorioWSQ;
	}

	/**
	 * @method	setStrRutaDirectorioWSQ
	 * 		  	Metodo set del atributo strRutaDirectorioWSQ
	 * @param	pStrRutaDirectorioWSQ
	 * 			Valor que tomara el atributo strRutaDirectorioWSQ
	 * @author	hector.cuenca
	 * @date	29/08/2017
	 */
	public void setStrRutaDirectorioWSQ (String pStrRutaDirectorioWSQ)
	{
		this.strRutaDirectorioWSQ = pStrRutaDirectorioWSQ;
	}

	/**
	 * @method	getFilDirectorioWSQ
	 * 		  	Metodo get del atributo filDirectorioWSQ
	 * @param	pBooReValidar
	 * 			Bandera que permite re-validar la ruta del directorio
	 * 			donde se almacenan los WSQ a transmitir
	 * @return	File
	 *		  	Valor del atributo filDirectorioWSQ devuelto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date  	29/08/2017
	 */
	public File getFilDirectorioWSQ (	Boolean pBooReValidar	) 
			throws Exception
	{
		if	(		this.reValidarParametrosEjecucion(pBooReValidar).booleanValue ()
				||	this.filDirectorioWSQ	==	null
			)
		{
			this.filDirectorioWSQ	=	new File(this.getStrRutaDirectorioWSQ ( pBooReValidar ));
			
			if	(	!this.filDirectorioWSQ.exists ()	)
			{
				this.filDirectorioWSQ.mkdirs ();
			}
		}
		
		return filDirectorioWSQ;
	}

	/**
	 * @method	setFilDirectorioWSQ
	 * 		  	Metodo set del atributo filDirectorioWSQ
	 * @param	pFilDirectorioWSQ
	 * 			Valor que tomara el atributo filDirectorioWSQ
	 * @author	hector.cuenca
	 * @date	29/08/2017
	 */
	public void setFilDirectorioWSQ (File pFilDirectorioWSQ)
	{
		this.filDirectorioWSQ = pFilDirectorioWSQ;
	}

	/**
	 * @method	isBooHiloTransmisorCorriendo
	 * 		  	Metodo get del atributo booHiloTransmisorCorriendo
	 * @return	boolean
	 *		  	Valor del atributo booHiloTransmisorCorriendo devuelto
	 * @author	hector.cuenca
	 * @date  	30/08/2017
	 */
	public boolean isBooHiloTransmisorCorriendo ()
	{
		return booHiloTransmisorCorriendo;
	}

	/**
	 * @method	setBooHiloTransmisorCorriendo
	 * 		  	Metodo set del atributo pBooHiloTransmisorCorriendo
	 * @param	pBooHiloTransmisorCorriendo
	 * 			Valor que tomara el atributo pBooHiloTransmisorCorriendo
	 * @author	hector.cuenca
	 * @date	30/08/2017
	 */
	public void setBooHiloTransmisorCorriendo (boolean pBooHiloTransmisorCorriendo)
	{
		this.booHiloTransmisorCorriendo = pBooHiloTransmisorCorriendo;
	}

	/**
	 * @method	getInt_CAMAPEEN
	 * 		  	Metodo get del atributo int_CAMAPEEN
	 * @return	Integer
	 *		  	Valor del atributo int_CAMAPEEN devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public Integer getInt_CAMAPEEN ()
	{
		return int_CAMAPEEN;
	}

	/**
	 * @method	setInt_CAMAPEEN
	 * 		  	Metodo set del atributo int_CAMAPEEN
	 * @param	pInt_CAMAPEEN
	 * 			Valor que tomara el atributo int_CAMAPEEN
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setInt_CAMAPEEN (Integer pInt_CAMAPEEN)
	{
		this.int_CAMAPEEN = pInt_CAMAPEEN;
	}

	/**
	 * @method	getInt_CAMIALEL
	 * 		  	Metodo get del atributo int_CAMIALEL
	 * @return	Integer
	 *		  	Valor del atributo int_CAMIALEL devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public Integer getInt_CAMIALEL ()
	{
		return int_CAMIALEL;
	}

	/**
	 * @method	setInt_CAMIALEL
	 * 		  	Metodo set del atributo int_CAMIALEL
	 * @param	pInt_CAMIALEL
	 * 			Valor que tomara el atributo int_CAMIALEL
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setInt_CAMIALEL (Integer pInt_CAMIALEL)
	{
		this.int_CAMIALEL = pInt_CAMIALEL;
	}

	/**
	 * @method	getBoo_DEPRENLO
	 * 		  	Metodo get del atributo boo_DEPRENLO
	 * @return	Boolean
	 *		  	Valor del atributo boo_DEPRENLO devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public Boolean getBoo_DEPRENLO ()
	{
		return boo_DEPRENLO;
	}

	/**
	 * @method	setBoo_DEPRENLO
	 * 		  	Metodo set del atributo boo_DEPRENLO
	 * @param	pBoo_DEPRENLO
	 * 			Valor que tomara el atributo boo_DEPRENLO
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setBoo_DEPRENLO (Boolean pBoo_DEPRENLO)
	{
		this.boo_DEPRENLO = pBoo_DEPRENLO;
	}

	/**
	 * @method	getBoo_ENALENLO
	 * 		  	Metodo get del atributo boo_ENALENLO
	 * @return	Boolean
	 *		  	Valor del atributo boo_ENALENLO devuelto
	 * @author	hector.cuenca
	 * @date  	1/09/2017
	 */
	public Boolean getBoo_ENALENLO ()
	{
		return boo_ENALENLO;
	}

	/**
	 * @method	setBoo_ENALENLO
	 * 		  	Metodo set del atributo boo_ENALENLO
	 * @param	pBoo_ENALENLO
	 * 			Valor que tomara el atributo boo_ENALENLO
	 * @author	hector.cuenca
	 * @date	1/09/2017
	 */
	public void setBoo_ENALENLO (Boolean pBoo_ENALENLO)
	{
		this.boo_ENALENLO = pBoo_ENALENLO;
	}

	/**
	 * @method	getStrExtensionWSQ
	 * 		  	Metodo get del atributo strExtensionWSQ
	 * @return	String
	 *		  	Valor del atributo strExtensionWSQ devuelto
	 * @author	hector.cuenca
	 * @date  	5/09/2017
	 */
	public String getStrExtensionWSQ ()
	{
		return strExtensionWSQ;
	}

	/**
	 * @method	getStrExtensionWSQTemporal
	 * 		  	Metodo get del atributo strExtensionWSQTemporal
	 * @return	String
	 *		  	Valor del atributo strExtensionWSQTemporal devuelto
	 * @author	hector.cuenca
	 * @date  	5/09/2017
	 */
	public String getStrExtensionWSQTemporal ()
	{
		return strExtensionWSQTemporal;
	}
	
}
