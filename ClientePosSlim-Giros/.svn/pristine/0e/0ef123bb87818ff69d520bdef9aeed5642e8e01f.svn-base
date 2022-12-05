package co.com.codesa.clienteposslimgiros.vista.logica.sesion;


import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumCodigosMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMediosPago;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.datosAdicionales.UtilDatosAdicionales;
import co.com.codesa.clienteposslimgiros.utilidades.documentos.UtilDocumentos;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.productos.UtilProductos;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlTerritorio;
import co.com.codesa.clienteposslimgiros.vista.logica.GeneralGirosVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CerrarSesion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.InicioSession;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaVersionGiroPostal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarUltimoInicioSesion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCerrarSesion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarUltimoInicioSesion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaInicioSession;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaValidarBiometria;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaVersionGiroPostal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ValidarBiometria;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 09-mar-2015 
 * @descripcion: Clase implementada con patron de diseño singleton, 
 * 				 que permite acceder a las diferentes funcionalidades
 * 				 que invocan y procesan peticiones de tramas, relacionadas
 * 				 con el proceso de negocio de sesion, por ejemplo:
 * 				 el proceso de autenticacion
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class SesionVistaLogica {

	/**
	 * @variable: instancia, atributo que vuelve estatico los accesos 
	 * 			  hacia las funciones que agrupa la clase de 
	 * 			  SesionVistaLogica
	 **/
	private static SesionVistaLogica instancia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo: SesionVistaLogica (Constructor)
  	 * @descripcion: Metodo constructor que se firma como privado, para
  	 * 				 garantizar que solo se instancie un objeto de la
  	 * 				 clase, a traves del getInstance 
  	 * @autor: Hector Q-en-K
  	 * ****************************************************************
  	 */
	private SesionVistaLogica(){}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: getInstance (Metodo)
  	 * @descripcion: Metodo encargado de controlar e inicializar la 
  	 * 				 instancia de la clase, para instanciarla una unica
  	 * 				 vez durante todo el ciclo de vida de la aplicacion
  	 * 				 (patron singleton)
  	 * @return SesionVistaLogica: tipo de obj que representa a la clase 
  	 * 		   misma
  	 * @autor: Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static SesionVistaLogica getInstance(){
		
		if(instancia==null){
			instancia = new SesionVistaLogica();
		}
		
		return instancia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: validaRequiereBiometria (Metodo)
  	 * @descripcion: Metodo encargado de solicitar y procesar la respuesta
  	 * 				 de la peticion recibida, para validar si aplica o no
  	 * 				 biometria para temas de autenticacion
  	 * @param pStrUsuario: credencial de usuario en el proceso de 
  	 * 		  autenticacion
  	 * @param pStrContrasena: credencial de contrasena en el proceso de 
  	 * 		  autenticacion
  	 * @return boolean: bandera que identifica si apica biometria o no, 
  	 * 		   para el proceso de autenticacion
  	 * @throws Exception: Recupera, controla y escala cualquier tipo de 
  	 * 		   excepcion presentada 
  	 * @autor: Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void validaRequiereBiometria(Usuario pObjUsuario)throws Exception{
		
		/**
		 * [Trama 97 | Validar Biometria: Trama utilizada para validar si el usuario necesita validacion con biometria]
		 */
		
		ValidarBiometria objEnvioTrama;
		RespuestaValidarBiometria objRespuestaTrama;
		
		objEnvioTrama = new ValidarBiometria(pObjUsuario);
		
		//objRespuestaTrama = (RespuestaValidarBiometria)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaValidarBiometria)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarSession
  	 * 		   Metodo encargado de realizar el proceso normal de 
  	 * 		   autenticacion frente al sistema Sims (tambien considera
  	 * 		   biometria), completa al objeto usuario que entra como
  	 * 		   parametro
  	 * @param pObjUsuarioSolicitante
  	 * 		  credencial de usuario en el proceso de autenticacion, 
  	 * 		  contiene la huella en el caso de biometria
  	 * @throws Exception
  	 * 		   Recupera, controla y escala cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void iniciarSession(Usuario pObjUsuarioSolicitante)throws Exception{
		
		/**
		 * [Trama 1  | Iniciar Sesion: Trama utilizada para validar el usuario]
		 */
		
		/**
		 * [Trama 98 | Iniciar Sesion Biometria: Trama utilizada para validar el usuario con Biometria]
		 */
		
		InicioSession objEnvioTrama;
		RespuestaInicioSession objRespuestaTrama;
		
		objEnvioTrama = new InicioSession(pObjUsuarioSolicitante);
		
		//objRespuestaTrama = (RespuestaInicioSession)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaInicioSession)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			pObjUsuarioSolicitante.getAgencia().setTerritorio(XmlTerritorio.getInstance().obtenerMunicipio(pObjUsuarioSolicitante.getAgencia().getTerritorio().getCodigo()));
			//pObjUsuarioSolicitante.setAutenticado(true);
			
			/**
			 * Provoca la carga inicial de parametros de sistema de no siempre consulta
			 */
			UtilParametrosSistema.getInstance().cargaInicialParametros ();
			
			UtilProductos.procesarProductosUsuario(pObjUsuarioSolicitante.getProductos());
			UtilDocumentos.procesarDocumentosUsuario(pObjUsuarioSolicitante.getDocumentos());
			UtilMediosPago.getInstance().procesarMediosPagoUsuario(pObjUsuarioSolicitante.getMediosPago());
			
			this.asociarDatosAdicionalesXMedioPago();
			pObjUsuarioSolicitante.setAutenticado(true);
			
		}else{//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	private void asociarDatosAdicionalesXMedioPago()throws Exception{
		
		MedioPago objMedioPagoTarjetaCredito;
		MedioPago objMedioPagoTarjetaDebito;
		
		objMedioPagoTarjetaCredito = EnumMediosPago.TARJETA_CREDITO.getObjMedioPago();
		
		if(objMedioPagoTarjetaCredito != null){
			
			UtilDatosAdicionales.incorporarDatosSobre(objMedioPagoTarjetaCredito, 
					  							  //UtilDatosAdicionales.generarNombreBanco(false),
					  							  UtilDatosAdicionales.generarCodigoAprobacion(true,
					  									  									   "UK_1")
					  							  //UtilDatosAdicionales.generarTipoTarjeta(false)
					  							  );
		}
		
		objMedioPagoTarjetaDebito = EnumMediosPago.TARJETA_DEBITO.getObjMedioPago();
		
		if(objMedioPagoTarjetaDebito != null){
		
			UtilDatosAdicionales.incorporarDatosSobre(objMedioPagoTarjetaDebito, 
					  							  //UtilDatosAdicionales.generarNombreBanco(false),
					  							  UtilDatosAdicionales.generarCodigoAprobacion(true,
					  									  									   "UK_1")
					  							  //UtilDatosAdicionales.generarTipoTarjeta(false)
					  							  );
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cerrarSesion
  	 * 		   metodo encargado de realizar el proceso de cierre de
  	 * 		   sesion del usuario frente al sistema Sims
  	 * @throws Exception: Recupera, controla y escala cualquier tipo de 
  	 * 		   excepcion presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void cerrarSesion(Usuario pObjUsuarioAutenticado)throws Exception{
		
		/**
		 * [Trama 80 | Cerrar Sesion: Trama utilizada para cerrar sesion]
		 */
		
		CerrarSesion objEnvioTrama;
		RespuestaCerrarSesion objRespuestaTrama;
		
		objEnvioTrama = new CerrarSesion(pObjUsuarioAutenticado);
		
		//objRespuestaTrama = (RespuestaCerrarSesion)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCerrarSesion)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	
	/***************************************************************
	 * 
	 * @method consultarVersionProductoGiros proposito invocacion de 
	 * 		   la trama 151 para poder obtener version habilitada del 
	 *         producto giro.
	 * @return nada
	 * @author dsalazar[PlayTech]
	 * @throws Exception
	 * @date 20-abr-2018
	 * 
	 * **************************************************************
	 */
	public boolean consultarVersionProductoGiros(Usuario pObjUsuarioAutenticado) 
			throws Exception 
	{	
		boolean  blnRespuesta=false; 

		try{
			
			ConsultaVersionGiroPostal objEnvioTrama;
			RespuestaVersionGiroPostal objRespuestaTrama;
	
			UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.VERSIONES_HABILITADAS_GIRO);
	
			objEnvioTrama = new ConsultaVersionGiroPostal	(	pObjUsuarioAutenticado,
																EnumParametrosApp.VERSION_GIRO.getValorPropiedad()
															);
			
			objRespuestaTrama = (RespuestaVersionGiroPostal) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
	
			if	(	objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())	) 
			{
				if	(	!objRespuestaTrama.getValorAtributoObj("objTokenB").equals("0")	) 
				{
					throw EnumMensajes.generarExcepcionPersonalizada(	EnumClasesMensaje.ERROR, 
																		EnumCodigosMensaje._POS_SG_187.getCodigo(),
																		EnumMensajes.VERSION_NO_HABILITADA.getMensaje(),
																		EnumParametrosApp.VERSION_GIRO.getValorPropiedad()
																	);
				}	else	{
					blnRespuesta = true;
				}
	
			}	else	{
				throw EnumMensajes.generarExcepcionPersonalizada(	EnumClasesMensaje.ERROR, 
																	(String)objRespuestaTrama.getValorAtributoObj("codigoError"),
																	(String)objRespuestaTrama.getValorAtributoObj("descripcionError")
																);
			}
		
		}	finally	{
			FormaGenerica.strVersion = ".     " + EnumEtiquetas.LBL_VERSION_GIROS +  EnumParametrosApp.VERSION_GIRO.getValorPropiedad();
			GeneralGirosVistaLogica.getInstance().procesarPermisosMenuVersion(blnRespuesta);
		}

		return blnRespuesta;
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultarUltimoInicioSesion
	 * 		  	consulta el ultimo incio sesion
	 * @param 	pObjUsuarioAutenticado
	 * 			Usuario que realiza la transaccion
	 * @return	Mensaje
	 * 			Mensaje a mostrar en pantalla
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de 
  	 * 		   	excepcion presentada
	 * @author	roberth.martinez
	 * @date	4/10/2018
	 * *********************************************************************
	 */
	public Mensaje consultarUltimoInicioSesion(Usuario pObjUsuarioAutenticado) throws Exception{
		
		/**
		 * [Trama 538 | Consultar ultimo inicio sesion : Consulta el ultimo inicio de sesion] 
		 */
		String strDescripcionAgencia;
		String strDescripcionCaja;
		String strFechaSesion;
		
		ConsultarUltimoInicioSesion objEnvioTrama;
		RespuestaConsultarUltimoInicioSesion objRespuestaTrama;
		
		objEnvioTrama = new ConsultarUltimoInicioSesion(pObjUsuarioAutenticado);
		
		objRespuestaTrama = (RespuestaConsultarUltimoInicioSesion) UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}else{
			strDescripcionAgencia =(String) objRespuestaTrama.getValorAtributoObj("strDescripcionAgencia");
			strDescripcionCaja =(String) objRespuestaTrama.getValorAtributoObj("strDescripcionCaja");
			strFechaSesion =(String) objRespuestaTrama.getValorAtributoObj("strFechaSesion");
			
			return EnumMensajes.ULTIMO_INICIO_SESION.obtenerMensaje(EnumClasesMensaje.INFORMACION, pObjUsuarioAutenticado.getLogin(), strDescripcionAgencia, strDescripcionCaja, strFechaSesion);
		}
	}

}
