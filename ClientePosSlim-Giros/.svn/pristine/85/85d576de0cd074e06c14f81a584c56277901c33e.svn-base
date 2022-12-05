package co.com.codesa.clienteposslimgiros.utilidades.terceros.peps;

import java.util.StringTokenizer;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTercero;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaPropiedadesPeps;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.terceroPeps.TerceroPepsVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * 
 * ********************************************************************
 * @class	UtilTerceroPeps
 *		 	Singleton encargado de la gestion del proceso de PEPS
 * @author	Stiven.Garcia
 * @date  	16/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilTerceroPeps {
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseÃ±o)
	 **/
	private static UtilTerceroPeps instance;

	/**
	 * ********************************************************************
	 * @method UtilTerceroPeps
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @author usuario
	 * @date   13/04/2018
	 * ********************************************************************
	 */
	private UtilTerceroPeps() throws Exception {

	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilTerceroPeps
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author usuario
	 * @date   13/04/2018
	 * ********************************************************************
	 */
	public static UtilTerceroPeps getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilTerceroPeps();
		}

		return instance;
	}	
	
	/**
	 * 
	 * ********************************************************************
	 * @method	realizarPreguntaTerceroPeps
	 * 		  	Se encarga de validar si al tercero debe realizarse la pregunta
	 * 			de Politica tratamiento de datos
	 * @param pObjUsuario
	 * 			Usuario cajero que realiza la peticion
	 * @param pObjTercero
	 * 			Tercero cliente al cual debe realizarse la pregunta
	 * @return
	 * 			Variable booleana indicando si se realiza la pregunta al tercero
	 * @throws Exception
 	 *         Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	13/04/2018
	 * *********************************************************************
	 */
	public boolean realizarPreguntaTerceroPeps( Usuario pObjUsuario, Tercero pObjTercero) throws Exception{
		
		boolean booRealizarPregunta = false;
		
		if( pObjTercero != null ) {		
			
			if(  this.validarServicioTerceroPeps() && this.validarTipoDocumentoPermitido(pObjTercero)) {
				
				try {
					TerceroPepsVistaLogica.getInstance().consultaTerceroPeps(pObjUsuario, pObjTercero);
				} catch (Exception e) {
					if( e  instanceof ClientePosSlimGirosException){
						Mensaje objMensaje = (Mensaje)((ClientePosSlimGirosException)e).getObjMensaje();
						if(objMensaje.getCodigo().equals(EnumMensajes.TERCERO_NO_EXISTE.getCodigo())){
							booRealizarPregunta = true;
						}else{
							throw e;
						}
					}
				}
				
				if(pObjTercero.getObjTerceroPeps() != null && !pObjTercero.getObjTerceroPeps().isBooExistePeps()) {
					booRealizarPregunta = true;
				}
			}					
		}
		
		return booRealizarPregunta;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarTipoDocumentoPermitido
	 * 		  	Metodo encargado de validar si el tipo de documento del tercero 
	 * 			recibido como parametro es valido para realizar proceso de 
	 * 			Persona Politicamente Expuesta
	 * @param pObjTercero
	 * 			Tercero cliente al cual se le debe realizar la pregunta de 
	 * 			Persona Politicamente Expuesta
	 * @return
	 * 			Variable boolean que indica si el tipo de documento es valido 
	 * @throws Exception
 	 *         Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	13/04/2018
	 * *********************************************************************
	 */
	public boolean validarTipoDocumentoPermitido( Tercero pObjTercero) throws Exception {
		
		boolean booTipoDocumentoPermitido = false;
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TIPOS_DOCUMENTO_PERMITIDOS_PEPS);
		
		String strTiposDocumento = EnumParametrosSistema.TIPOS_DOCUMENTO_PERMITIDOS_PEPS.obtenerValorCadena();
		
		StringTokenizer stkTiposDocumento = new StringTokenizer(strTiposDocumento, EnumGeneralidadesTramasGiros.PIPE.getValor());
		
		while (stkTiposDocumento.hasMoreElements()) {
			String strElemento = stkTiposDocumento.nextToken();
			if(strElemento.equalsIgnoreCase(String.valueOf(pObjTercero.getTipoIdentificacion().getId()))) {
				return true;
			}
		}
		
		return booTipoDocumentoPermitido;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarServicioTerceroPeps
	 * 		  	Metodo encargado de validar si el servicio PEPS se enucentra activo
	 * @return
	 * 			Booleano indicando si se encuentra activo o inactivo el servicio
	 * @throws Exception
 	 *         Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public boolean validarServicioTerceroPeps() throws Exception{
		
		boolean booRespuesta;
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ACTIVA_SERVICIO_PEPS);
		booRespuesta = EnumParametrosSistema.ACTIVA_SERVICIO_PEPS.obtenerValorBooleano("S");
		
		return booRespuesta;
		
	}	
	
	/**
	 * 
	 * ********************************************************************
	 * @method	procesarServicioTerceroPeps
	 * 		  	Metodo encargado de activar la ventana de peps si es 
	 * 			requerido para el tercero recibido como parametro
	 * @param pObjUsuario
	 * 			Usuario cajero que realiza la peticion 
	 * @param pObjTercero
	 * 			Es el tercero asociado a PEPS
	 * @param pObjFormaGenerica
	 * 			Forma principal que realiza el llamado a la forma propiedades peps
	 * @param pBooProcesarPeticion
	 * 			bandera encargada de definir si se realiza el proceso de PEPS
	 * 			inmediatamente o se hara luego de la creacion
	 * @return
	 * 			bandera indicando si se realizo alguna accion ddel servicio terceroPeps
	 * @throws Exception
 	 *         Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	14/04/2018
	 * *********************************************************************
	 */
	public boolean procesarServicioTerceroPeps( 	Usuario pObjUsuario, 
													Tercero pObjTercero,
													FormaGenerica pObjFormaGenerica,
													boolean pBooProcesarPeticion
											   )   throws Exception{
		
		FormaPropiedadesPeps frmPropiedadesPeps;
		
		boolean booProcesarTerceroPeps = false;
		
		if( this.realizarPreguntaTerceroPeps(pObjUsuario, pObjTercero) ) {
			
			frmPropiedadesPeps = new FormaPropiedadesPeps	( pObjFormaGenerica, 
															  true, 
															  pObjUsuario, 
															  pObjTercero, 
															  pBooProcesarPeticion
															);
			
			pObjTercero.setObjTerceroPeps( frmPropiedadesPeps.getObjTerceroPeps() );
			
			booProcesarTerceroPeps = frmPropiedadesPeps.isBooRealizoProcesoTerceroPeps();
			
		}else {
			booProcesarTerceroPeps = true;
		}
		
		return booProcesarTerceroPeps;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarContinuarProceso
	 * 		  	Metodo encargado de validar si se realizo la respuesta de peps 
	 * 			para alguno de los involucarados en la transaccion
	 * @param pObjUsuario
	 * 			Usuario cajero que se encuentra realizando las peticiones
	 * @param pObjFormaPanelTerceroPrincipal
	 * 			El el objeto panel tercero remitente/tramitador para el cual se gestiona peps
	 * @param pObjFormaPanelTerceroSegundario
	 * 			Es el objeto panel tercero destino/apoderado para el cual se gestiona peps
	 * @param pObjFormaGenerica
	 * 			Es el objeto forma padre que invoca la validación
	 * @return
	 * 			Retorna una bandera booleana indicando si se continua con el proceso o no
	 * @throws Exception
 	 *         Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author	stiven.garcia
	 * @date	30/07/2018
	 * *********************************************************************
	 */
	public boolean validarContinuarProceso( Usuario pObjUsuario, 
										FormaPanelTercero pObjFormaPanelTerceroPrincipal,
										FormaPanelTercero pObjFormaPanelTerceroSegundario,
										FormaGenerica pObjFormaGenerica
										) throws Exception {
		
		if ( this.validarServicioTerceroPeps() ) {
			
			Tercero objTerceroPrincipal  = pObjFormaPanelTerceroPrincipal.castEvaFrmTercero().getObjTercero();
			Tercero objTerceroSegundario = pObjFormaPanelTerceroSegundario.castEvaFrmTercero().getObjTercero();
			String  strIdentificacion;
			boolean booRealizarPreguntaPrincipal;
			boolean booRealizarPreguntaSegundario;
			
			
			if ( objTerceroSegundario != null ) {
				
				booRealizarPreguntaSegundario = this.realizarPreguntaTerceroPeps(pObjUsuario, objTerceroSegundario);
				
				if ( booRealizarPreguntaSegundario && !pObjFormaPanelTerceroSegundario.castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
					strIdentificacion = objTerceroSegundario.getIdentificacion();
					EnumMensajes.ALERTA_INGRESO_MARCA_PEPS.desplegarMensaje(null, EnumClasesMensaje.INFORMACION, strIdentificacion);
					return procesarServicioTerceroPeps(pObjUsuario, objTerceroSegundario, pObjFormaGenerica, true);
				}
				
			} else {
				
				booRealizarPreguntaPrincipal = this.realizarPreguntaTerceroPeps(pObjUsuario, objTerceroPrincipal);
				
				if ( booRealizarPreguntaPrincipal &&  !pObjFormaPanelTerceroPrincipal.castEvaFrmTercero().isBooRealizoProcesoTerceroPeps() ) {
					strIdentificacion = objTerceroPrincipal.getIdentificacion();
					EnumMensajes.ALERTA_INGRESO_MARCA_PEPS.desplegarMensaje(null, EnumClasesMensaje.INFORMACION, strIdentificacion);
					return procesarServicioTerceroPeps(pObjUsuario, objTerceroPrincipal, pObjFormaGenerica, true);
				}
				
			}			
		}	

		return true;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	activarValidacionPepsTercero
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @param pObjTipoDocumento
	 * @param pStrIdentificacion
	 * @return
	 * @throws Exception
	 * @author	stiven.garcia
	 * @date	4/08/2018
	 * *********************************************************************
	 */
	public boolean activarValidacionTerceroPeps(DatoEntidad pObjTipoDocumento, String pStrIdentificacion) throws Exception {
		
		Tercero objTercero = new Tercero(pObjTipoDocumento, pStrIdentificacion);
		
		if ( this.validarServicioTerceroPeps() && 
				this.validarTipoDocumentoPermitido(objTercero) ) {
			return true;
		}
		
		return false;
		
	}
}
