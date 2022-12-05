package co.com.codesa.clienteposslimgiros.utilidades;

import java.io.File;
import java.util.List;
import java.util.TreeMap;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.tercero.TerceroInternacionalVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.territorio.TerritorioInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PaisesEnvioGirosInternacionales;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomicaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Corresponsal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.NumeralInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ProfesionInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SenalAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoMotivoGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

/** 
 * ********************************************************************
 * @class  InformacionSessionGirosInternacional
 *		   Clase encargada de brinda atributos en session de giros 
 * 		   internacionales durante la ejecucion del aplicativo
 * @author roberth.martinez
 * @date   15/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class InformacionSessionGirosInternacional {
	
	
	/**
	 * @variable	instance
	 * 				instancia de la clase InformacionSessionGirosInternacional
	 */
	private static InformacionSessionGirosInternacional instance;
	
	/**
	 * @variable	lstCorresponsales
	 * 				Listado de corresponsales autorizados por la red internacional
	 */
	private List<Corresponsal>	lstCorresponsales;
	
	/**
	 * @variable	lstTiposDocumentosInternacional
	 * 				Listado Tipos de documentos autorizados por la red internacional
	 */
	private List<TipoDocumentoInternacional>	lstTiposDocumentosInternacional;
	
	/**
	 * @variable	lstActividadesEconomicasInternacional
	 * 				Listado actividades economicas autorizados por la red internacional
	 */
	private List<ActividadEconomicaInternacional>	lstActividadesEconomicasInternacional;
	
	/**
	 * @variable	lstTipoMotivoGiroInternacional
	 * 				Listado tipos motivos giros autorizados por la red internacional
	 */
	private List<TipoMotivoGiroInternacional> lstTipoMotivoGiroInternacional;
	
	/**
	 * @variable	lstSenalesAlertaInternacional
	 * 				Listado senales alerta autorizados por la red internacional
	 */
	private List<SenalAlertaInternacional> lstSenalesAlertaInternacional;
	
	/**
	 * @variable	lstProfesionesInternacional
	 * 				Listado profesiones autorizados por la red internacional
	 */
	private List<ProfesionInternacional> lstProfesionesInternacional;
	
	/**
	 * @variable	tmPaises
	 * 				Listado paises autorizados por la red internacional
	 */
	private TreeMap<String, Territorio> tmPaises;
	
	/**
	 * @variable	tmPaisesEnvio
	 * 				Listado paises autorizados por la red internacional
	 */
	private List<PaisesEnvioGirosInternacionales> lstPaisesEnvio;
	
	/**
	 * @variable	lstTipoMotivoGiroInternacional
	 * 				Listado tipos motivos giros autorizados por la red internacional
	 */
	private List<NumeralInternacional> lstNumeralesEnvioInternacional;
	
	/**
	 * @variable	strRutaCapturaInternacional
	 * 				cadena con la ruta de almacenamiento de imagenes
	 */
	private String strRutaCapturaInternacional;
	
	/**
	 * @variable	objFilDirectorioCapturaInternacional
	 * 				Directorio donde se consolidan los archivos para transmision internacional
	 */
	private File objFilDirectorioCapturaInternacional;
	
	/**
     * ****************************************************************
     * @method getInstance
     * 		   metodo para cumplir con el patron singleton y tener
	 * 		   una unica instancia de la clase para se accedida.
	 * @param  pObjUsuario
	 * 		   objeto del usuario que realiza la transaccion 
	 * @return InformacionSessionGirosInternacional
	 * 		   instancia de la clase
	 * @throws Exception
	 * 	  	   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
     * @date   14/03/2018
     * ****************************************************************
     */
	public static InformacionSessionGirosInternacional getInstance(Usuario pObjUsuario) throws Exception {
		
		if(instance==null){
			instance = new InformacionSessionGirosInternacional();
			try {
				instance.inicializarInformacionSessionGirosInternacional(pObjUsuario);
			} catch (Exception e) {
				instance=null;
				throw e;
			}
			
		}
		
		return instance;
	}
	
	/**
     * ****************************************************************
     * @method getInstanceSinThrows
     * 		   metodo para cumplir con el patron singleton y tener
	 * 		   una unica instancia de la clase para se accedida.
	 * @param  pObjUsuario
	 * 		   objeto del usuario que realiza la transaccion 
	 * @return InformacionSessionGirosInternacional
	 * 		   instancia de la clase
	 * @author roberth.martinez
     * @date   14/03/2018
     * ****************************************************************
     */
	public static InformacionSessionGirosInternacional getInstanceSinThrows(Usuario pObjUsuario) {
		
		try{
			instance = InformacionSessionGirosInternacional.getInstance(pObjUsuario);
		}catch(Exception e){
			instance = null;
		}
		
		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method inicializarInformacionSessionGirosInternacional
	 * 		   inicia los valores necesarios para las transacciones de giros
	 * 		   internacionales
	 * @param  pObjUsuario
	 * 		   objeto del usuario que realiza la transaccion 
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   15/03/2018
	 * *********************************************************************
	 */
	private void inicializarInformacionSessionGirosInternacional(Usuario pObjUsuario) throws Exception {
		
		this.lstCorresponsales = GiroInternacionalVistaLogica.getInstancia().consultaCorresponsalesInternacional(pObjUsuario, 
																					   					   EnumPeticionesMultiservicio.GIN_CONSULTAR_CORRESPONSALES.getObjServicioPeticion());
		
		this.lstTiposDocumentosInternacional = TerceroInternacionalVistaLogica.getInstancia().consultaTiposDocumentosInternacional	(	pObjUsuario, 
				   																										  				EnumPeticionesMultiservicio.GIN_CONSULTAR_TIPO_DOCUMENTOS.getObjServicioPeticion()
				   																										  			);
		
		this.lstActividadesEconomicasInternacional = GiroInternacionalVistaLogica.getInstancia().consultaActividadesEconomicasInternacional(pObjUsuario, 
				   																													  EnumPeticionesMultiservicio.GIN_CONSULTAR_ACTIVIDADES_ECONOMICAS.getObjServicioPeticion());
		
		this.tmPaises	=	TerritorioInternacionalVistaLogica.getInstancia().consultaPaisesInternacionales	(	pObjUsuario, 
																												EnumPeticionesMultiservicio.GIN_CONSULTAR_PAISES.getObjServicioPeticion()
																											);
		
		this.lstPaisesEnvio = GiroInternacionalVistaLogica.getInstancia().consultaPaisesEnvioInternacional(pObjUsuario, 
																										   EnumPeticionesMultiservicio.GIN_CONSULTAR_PAISES_ENVIO.getObjServicioPeticion());
		
		this.lstTipoMotivoGiroInternacional = GiroInternacionalVistaLogica.getInstancia().consultaTiposMotivosGirosInternacional(pObjUsuario, 
				   																											EnumPeticionesMultiservicio.GIN_CONSULTAR_TIPOS_MOTIVOS_GIROS.getObjServicioPeticion());
		
		this.lstSenalesAlertaInternacional = GiroInternacionalVistaLogica.getInstancia().consultaSenalesAlerta	(	pObjUsuario, 
				   																									EnumPeticionesMultiservicio.GIN_CONSULTAR_SENALES_ALERTA.getObjServicioPeticion());
		
		this.lstProfesionesInternacional = GiroInternacionalVistaLogica.getInstancia().consultaProfesionesInternacional(	pObjUsuario, 
																															EnumPeticionesMultiservicio.GIN_CONSULTAR_PROFESIONES.getObjServicioPeticion());
		
		this.lstNumeralesEnvioInternacional = GiroInternacionalVistaLogica.getInstancia().consultarNumeralesEnvio(	pObjUsuario, 
																												  	EnumPeticionesMultiservicio.GIN_CONSULTAR_NUMERALES_ENVIO.getObjServicioPeticion());
	}

	/**
	 * @method	getLstCorresponsales
	 * 		  	Metodo get del atributo lstCorresponsales
	 * @return	List<Corresponsal>
	 *		  	Valor del atributo lstCorresponsales devuelto
	 * @author	roberth.martinez
	 * @date  	19/03/2018
	 */
	public List<Corresponsal> getLstCorresponsales() {
		return lstCorresponsales;
	}

	/**
	 * @method	setLstCorresponsales
	 * 		  	Metodo set del atributo lstCorresponsales
	 * @param	pLstCorresponsales
	 * 			Valor que tomara el atributo lstCorresponsales
	 * @author	roberth.martinez
	 * @date	19/03/2018
	 */
	public void setLstCorresponsales(List<Corresponsal> pLstCorresponsales) {
		lstCorresponsales = pLstCorresponsales;
	}
	
	/**
	 * @method	getLstPaisesEnvio
	 * 		  	Metodo get del atributo lstPaisesEnvio
	 * @return	List<Corresponsal>
	 *		  	Valor del atributo lstPaisesEnvio devuelto
	 * @author	didier.silva
	 * @date  	28/04/2018
	 */
	public List<PaisesEnvioGirosInternacionales> getLstPaisesEnvio() {
		return lstPaisesEnvio;
	}
	
	/**
	 * @method	setLstPaisesEnvio
	 * 		  	Metodo set del atributo lstPaisesEnvio
	 * @param	pLstPaisesEnvio
	 * 			Valor que tomara el atributo lstPaisesEnvio
	 * @author	didier.silva
	 * @date	28/04/2018
	 */
	public void setLstPaisesEnvio(
			List<PaisesEnvioGirosInternacionales> pLstPaisesEnvio) {
		this.lstPaisesEnvio = pLstPaisesEnvio;
	}

	/**
	 * @method	getLstTiposDocumentosInternacional
	 * 		  	Metodo get del atributo lstTiposDocumentosInternacional
	 * @return	List<TipoDocumentoInternacional>
	 *		  	Valor del atributo lstTiposDocumentosInternacional devuelto
	 * @author	user
	 * @date  	19/03/2018
	 */
	public List<TipoDocumentoInternacional> getLstTiposDocumentosInternacional() {
		return lstTiposDocumentosInternacional;
	}

	/**
	 * @method	setLstTiposDocumentosInternacional
	 * 		  	Metodo set del atributo lstTiposDocumentosInternacional
	 * @param	pLstTiposDocumentosInternacional
	 * 			Valor que tomara el atributo lstTiposDocumentosInternacional
	 * @author	user
	 * @date	19/03/2018
	 */
	public void setLstTiposDocumentosInternacional(List<TipoDocumentoInternacional> pLstTiposDocumentosInternacional) {
		lstTiposDocumentosInternacional = pLstTiposDocumentosInternacional;
	}

	/**
	 * @method	getLstActividadesEconomicasInternacional
	 * 		  	Metodo get del atributo lstActividadesEconomicasInternacional
	 * @return	List<ActividadEconomicaInternacional>
	 *		  	Valor del atributo lstActividadesEconomicasInternacional devuelto
	 * @author	user
	 * @date  	19/03/2018
	 */
	public List<ActividadEconomicaInternacional> getLstActividadesEconomicasInternacional() {
		return lstActividadesEconomicasInternacional;
	}

	/**
	 * @method	setLstActividadesEconomicasInternacional
	 * 		  	Metodo set del atributo lstActividadesEconomicasInternacional
	 * @param	pLstActividadesEconomicasInternacional
	 * 			Valor que tomara el atributo lstActividadesEconomicasInternacional
	 * @author	user
	 * @date	19/03/2018
	 */
	public void setLstActividadesEconomicasInternacional(List<ActividadEconomicaInternacional> pLstActividadesEconomicasInternacional) {
		lstActividadesEconomicasInternacional = pLstActividadesEconomicasInternacional;
	}

	/**
	 * @method	getTmPaises
	 * 		  	Metodo get del atributo tmPaises
	 * @return	TreeMap<String,Territorio>
	 *		  	Valor del atributo tmPaises devuelto
	 * @author	hector.cuenca
	 * @date  	22/03/2018
	 */
	public TreeMap<String, Territorio> getTmPaises() {
		return tmPaises;
	}

	/**
	 * @method	setTmPaises
	 * 		  	Metodo set del atributo tmPaises
	 * @param	pTmPaises
	 * 			Valor que tomara el atributo tmPaises
	 * @author	hector.cuenca
	 * @date	22/03/2018
	 */
	public void setTmPaises(TreeMap<String, Territorio> pTmPaises) {
		this.tmPaises = pTmPaises;
	}

	/**
	 * @method	getLstTipoMotivoGiroInternacional
	 * 		  	Metodo get del atributo lstTipoMotivoGiroInternacional
	 * @return	List<TipoMotivoGiroInternacional>
	 *		  	Valor del atributo lstTipoMotivoGiroInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public List<TipoMotivoGiroInternacional> getLstTipoMotivoGiroInternacional() {
		return lstTipoMotivoGiroInternacional;
	}

	/**
	 * @method	setLstTipoMotivoGiroInternacional
	 * 		  	Metodo set del atributo lstTipoMotivoGiroInternacional
	 * @param	pLstTipoMotivoGiroInternacional
	 * 			Valor que tomara el atributo lstTipoMotivoGiroInternacional
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setLstTipoMotivoGiroInternacional(
			List<TipoMotivoGiroInternacional> pLstTipoMotivoGiroInternacional) {
		this.lstTipoMotivoGiroInternacional = pLstTipoMotivoGiroInternacional;
	}

	/**
	 * @method	getStrRutaCapturaInternacional
	 * 		  	Metodo get del atributo strRutaCapturaInternacional
	 * @return	String
	 *		  	Valor del atributo strRutaCapturaInternacional devuelto
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date  	2/04/2018
	 */
	public String getStrRutaCapturaInternacional() 
		throws Exception
	{
		if	(	this.strRutaCapturaInternacional	==	null	)
		{
			this.strRutaCapturaInternacional	=	EnumParametrosApp.RUTA_APP.getObjConstante() + EnumParametrosSistema.NOMBRE_DIRECTORIO_ALMACENAMIENTO_CAPTURA_DOCUMENTOS.obtenerValorCadena();
		}
		
		return this.strRutaCapturaInternacional;
	}

	/**
	 * @method	setStrRutaCapturaInternacional
	 * 		  	Metodo set del atributo strRutaCapturaInternacional
	 * @param	pStrRutaCapturaInternacional
	 * 			Valor que tomara el atributo strRutaCapturaInternacional
	 * @author	hector.cuenca
	 * @date	2/04/2018
	 */
	public void setStrRutaCapturaInternacional(String pStrRutaCapturaInternacional) {
		this.strRutaCapturaInternacional = pStrRutaCapturaInternacional;
	}

	/**
	 * @method	getObjFilDirectorioCapturaInternacional
	 * 		  	Metodo get del atributo objFilDirectorioCapturaInternacional
	 * @return	File
	 *		  	Valor del atributo objFilDirectorioCapturaInternacional devuelto
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	hector.cuenca
	 * @date  	2/04/2018
	 */
	public File getObjFilDirectorioCapturaInternacional()
		throws Exception
	{
		if	(	this.objFilDirectorioCapturaInternacional	==	null	)
		{
			this.objFilDirectorioCapturaInternacional = new File(this.getStrRutaCapturaInternacional());
			if	(	!this.objFilDirectorioCapturaInternacional.exists()	)
			{
				this.objFilDirectorioCapturaInternacional.mkdirs();
        	}
		}
		
		return this.objFilDirectorioCapturaInternacional;
	}

	/**
	 * @method	setObjFilDirectorioCapturaInternacional
	 * 		  	Metodo set del atributo objFilDirectorioCapturaInternacional
	 * @param	pObjFilDirectorioCapturaInternacional
	 * 			Valor que tomara el atributo objFilDirectorioCapturaInternacional
	 * @author	hector.cuenca
	 * @date	2/04/2018
	 */
	public void setObjFilDirectorioCapturaInternacional(
			File pObjFilDirectorioCapturaInternacional) {
		this.objFilDirectorioCapturaInternacional = pObjFilDirectorioCapturaInternacional;
	}
	
	/**
	 * @method	getLstSenalesAlertaInternacional
	 * 		  	Metodo get del atributo lstSenalesAlertaInternacional
	 * @return	List<SenalAlertaInternacional>
	 *		  	Valor del atributo lstSenalesAlertaInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	2/04/2018
	 */
	public List<SenalAlertaInternacional> getLstSenalesAlertaInternacional() {
		return lstSenalesAlertaInternacional;
	}

	/**
	 * @method	setLstSenalesAlertaInternacional
	 * 		  	Metodo set del atributo lstSenalesAlertaInternacional
	 * @param	pLstSenalesAlertaInternacional
	 * 			Valor que tomara el atributo lstSenalesAlertaInternacional
	 * @author	roberth.martinez
	 * @date	2/04/2018
	 */
	public void setLstSenalesAlertaInternacional(
			List<SenalAlertaInternacional> pLstSenalesAlertaInternacional) {
		this.lstSenalesAlertaInternacional = pLstSenalesAlertaInternacional;
	}

	/**
	 * @method	getLstProfesionesInternacional
	 * 		  	Metodo get del atributo lstProfesionesInternacional
	 * @return	List<ProfesionInternacional>
	 *		  	Valor del atributo lstProfesionesInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	24/04/2018
	 */
	public List<ProfesionInternacional> getLstProfesionesInternacional() {
		return lstProfesionesInternacional;
	}

	/**
	 * @method	setLstProfesionesInternacional
	 * 		  	Metodo set del atributo lstProfesionesInternacional
	 * @param	pLstProfesionesInternacional
	 * 			Valor que tomara el atributo lstProfesionesInternacional
	 * @author	roberth.martinez
	 * @date	24/04/2018
	 */
	public void setLstProfesionesInternacional(
			List<ProfesionInternacional> pLstProfesionesInternacional) {
		this.lstProfesionesInternacional = pLstProfesionesInternacional;
	}
	
	/**
	 * @method	getLstNumeralesEnvioInternacional
	 * 		  	Metodo get del atributo lstNumeralesEnvioInternacional
	 * @return	List<NumeralesEnvioInternacional>
	 *		  	Valor del atributo lstNumeralesEnvioInternacional devuelto
	 * @author	didier.silva
	 * @date  	03/05/2018
	 */
	public List<NumeralInternacional> getLstNumeralesEnvioInternacional() {
		return lstNumeralesEnvioInternacional;
	}
	
	/**
	 * @method	setLstNumeralesEnvioInternacional
	 * 		  	Metodo set del atributo lstNumeralesEnvioInternacional
	 * @param	pLstNumeralesEnvioInternacional
	 * 			Valor que tomara el atributo lstNumeralesEnvioInternacional
	 * @author	didier.silva
	 * @date	03/05/2018
	 */
	public void setLstNumeralesEnvioInternacional(
			List<NumeralInternacional> pLstNumeralesEnvioInternacional) {
		this.lstNumeralesEnvioInternacional = pLstNumeralesEnvioInternacional;
	}
}
