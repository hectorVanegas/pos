package co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.claveSeguridad;

import java.util.HashMap;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ServicioClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.EventoFormaPanelClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaVerificarClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.serviciosAdicionales.claveSeguridad.ClaveSeguridadVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.tokenValidacion.ClaveSeguridadDTO;

/**
 * ********************************************************************
 * @class UtilClaveSeguridad
 *		  Clase utilitaria relacionada con el proceso de clave de 
 *		  seguridad
 * @author hector.cuenca
 * @date 3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class UtilClaveSeguridad {
	
	/**
	 * @variable instance
	 * 			 Referencia estatica de la clase utilitaria, clave para 
	 * 		 	 incorporar SINGLETON (patron de diseno)
	 **/
	private static UtilClaveSeguridad instance;
	
	/**
	 * @variable hmTiposClaveSeguridad
	 * 			 Listado de los tipos de claves de seguridad implementados
	 */
	private HashMap<String,ClaveSeguridadDTO> hmTiposClaveSeguridad;

	/**
	 * ********************************************************************
	 * @metodo UtilClaveSeguridad
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @autor hector.cuenca
	 * @date 3/03/2016
	 * ********************************************************************
	 */
	private UtilClaveSeguridad() throws Exception {
		
		this.cargarTiposClaveSeguridad();
	}

	/** 
	 * ********************************************************************
	 * @method getInstancia
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilClaveSeguridad
	 * 		   Tipo referente a la misma clase
	 * @throws Exception
	 *		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date 3/03/2016
	 * ********************************************************************
	 */
	public static UtilClaveSeguridad getInstancia() throws Exception {

		if (instance == null) {

			instance = new UtilClaveSeguridad();
		}

		return instance;
	}
	
	/** 
	 * ********************************************************************
	 * @method cargarTiposClaveSeguridad
	 * 		   Metodo que realiza el cargue de los diferentes tipos de clave
	 * 		   de seguridad implementados
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	private void cargarTiposClaveSeguridad()throws Exception{
		
		this.hmTiposClaveSeguridad = new HashMap<String,ClaveSeguridadDTO>();
		
		for(EnumTiposClaveSeguridad enmTipoClaveSeguridad : EnumTiposClaveSeguridad.values()){
		
			if(!this.hmTiposClaveSeguridad.containsKey(enmTipoClaveSeguridad.getStrCodigo())){
			
				this.hmTiposClaveSeguridad.put(enmTipoClaveSeguridad.getStrCodigo(), 
											   enmTipoClaveSeguridad.getObjDtoClaveSeguridad());
			}
		}
	}
	
	/**
	 * ********************************************************************
	 * @method verificarClaveSeguridad
	 * 		   Metodo encargado de realizar las validaciones pertinentes
	 * 		   para determinar si ejecuta o no la verificacion de la clave
	 * 		   de seguridad
	 * @param  pEvtFrmPnlClaveSeguridad
	 * 		   Control de eventos de la forma panel (seccion), que integra 
	 * 		   el proceso de clave de seguridad, importante para recuperar la 
	 * 		   forma de la funcionalidad, usuario y otro tipo de informacion 
	 * 		   alterna 
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoClaveSeguridad
	 * 		   Objeto DTO que encapsula los atributos adicionales requeridos
	 * 		   para el proceso de clave de seguridad
	 * @return boolean
	 * 		   resultado validacion de verificar clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public boolean verificarClaveSeguridad(EventoFormaPanelClaveSeguridad pEvtFrmPnlClaveSeguridad,
										   FacturaGiro pObjFacturaGiro,
										   EnumTiposOperaciones pEnmTipoOperacion,
										   ServicioClaveSeguridadDTO pObjDtoClaveSeguridad)throws Exception{
		
		boolean booVerificar = false;
		FormaVerificarClaveSeguridad objFrmValidarClaveTokenSeguridad;
			
		if (pObjFacturaGiro.getObjClaveSeguridad() != null) {
			
			objFrmValidarClaveTokenSeguridad = new FormaVerificarClaveSeguridad(pEvtFrmPnlClaveSeguridad.getFrmForma(),
											    								   true,
											    								   pObjFacturaGiro);
							
			if(objFrmValidarClaveTokenSeguridad.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
				//Validamos que la validacion de la clave se realizo exitosamente al salir de la forma por el boton guardar
				booVerificar = true;
			}
			
			if(EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO.equals(pEnmTipoOperacion)
					&& booVerificar){
				// solo ofrece el token de validacion si valido la clave correctamente y es solicitud de cambio de beneficiario.
				booVerificar = this.ofrecerServicioClaveSeguridad(pEvtFrmPnlClaveSeguridad,
																  pObjFacturaGiro,
																  pEnmTipoOperacion,
																  pObjDtoClaveSeguridad);
			}
		}
		return booVerificar;
	}
	
	/**
	 * ********************************************************************
	 * @method ofrecerServicioClaveSeguridad
	 * 		   Metodo encargado de realizar las validaciones pertinentes
	 * 		   para determinar si ofrece o no el servicio de clave de  
	 * 		   seguridad a la funcionalidad que lo requiere
	 * @param  pEvtFrmPnlClaveSeguridad
	 * 		   Control de eventos de la forma panel (seccion), que integra 
	 * 		   el proceso de clave de seguridad, importante para recuperar la 
	 * 		   forma de la funcionalidad, usuario y otro tipo de informacion 
	 * 		   alterna 
	 * @param  pObjFacturaGiro
	 * 		   Objeto factura que contiene todo el detalle de la transaccion 
	 * 		   que se esta llevando a cabo
	 * @param  pEnmTipoOperacion
	 * 		   Tipo de operacion que se esta llevando a cabo
	 * @param  pObjDtoClaveSeguridad
	 * 		   Objeto DTO que encapsula los atributos adicionales requeridos
	 * 		   para el proceso de clave de seguridad
	 * @return boolean acepta o no acepta clave seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   2/03/2016
	 * *********************************************************************
	 */
	public boolean ofrecerServicioClaveSeguridad(EventoFormaPanelClaveSeguridad pEvtFrmPnlClaveSeguridad,
											    FacturaGiro pObjFacturaGiro,
											    EnumTiposOperaciones pEnmTipoOperacion,
											    ServicioClaveSeguridadDTO pObjDtoClaveSeguridad)throws Exception{
		
		ConfigOfrecerClaveSeguridadDTO objCfgOfrecerClaveSeguridad;
		Object objSeleccionarItem;
		boolean booActivarChkIncluyeClaveSeguridad;
		boolean booAceptaClaveSeguridad;
		FormaOfrecerClaveSeguridad objFormaOfrecerClaveSeguridad;
		
		booAceptaClaveSeguridad = false;
				
		objCfgOfrecerClaveSeguridad = new ConfigOfrecerClaveSeguridadDTO(pObjFacturaGiro,
																		  pEnmTipoOperacion,
																		  pObjDtoClaveSeguridad);
		
		if(this.validarTiposClaveSeguridadDisponibles(pEvtFrmPnlClaveSeguridad,	
										  	 		  objCfgOfrecerClaveSeguridad)){
			
			objFormaOfrecerClaveSeguridad = new FormaOfrecerClaveSeguridad(pEvtFrmPnlClaveSeguridad.getFrmForma(), 
																			 true,
																			 objCfgOfrecerClaveSeguridad);
			
			if(objFormaOfrecerClaveSeguridad.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)){
				
				booAceptaClaveSeguridad = true;
			}
		}
		
		if(pObjFacturaGiro.getObjClaveSeguridad()!=null){
			
			objSeleccionarItem = pObjFacturaGiro.getObjClaveSeguridad().getEnmTipoClaveSeguridad();
			booActivarChkIncluyeClaveSeguridad = true;
			
		}else{
			
			booActivarChkIncluyeClaveSeguridad = false;
			objSeleccionarItem = EnumEtiquetas.LBL_NO_SELECCIONADO;
		}
		
		pEvtFrmPnlClaveSeguridad.modificarEstadoServicio(booActivarChkIncluyeClaveSeguridad, 
														  objSeleccionarItem);
				
		return booAceptaClaveSeguridad;
	}
	
	/** 
	 * ********************************************************************
	 * @method validarDisponibilidadServicio
	 * 		   Metodo encargado de validar la disponibilidad del servicio
	 * 		   de clave de seguridad, si esta activo y configurado tanto 
	 * 		   a nivel general como a nivel especifico del punto de venta
	 * @param  pEvtFrmPnlClaveSeguridad
	 * 		   Control de eventos de la forma panel (seccion), que integra 
	 * 		   el proceso de clave de seguridad, importante para recuperar la 
	 * 		   forma de la funcionalidad, usuario y otro tipo de informacion 
	 * 		   alterna 
	 * @return boolean
	 * 		   Bandera que permite identificar si el servicio se encuentra 
	 * 		   o no disponible, true y false respectivamente
	 * @author hector.cuenca
	 * @date   10/03/2016
	 * *********************************************************************
	 */
	public boolean validarDisponibilidadServicio(EventoFormaPanelClaveSeguridad pEvtFrmPnlClaveSeguridad){
		
		boolean booActivaClaveSeguridad;
		boolean booValido;
		
		booValido = false;
		
		try{
			
			UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ACTIVA_CLAVE_SEGURIDAD);
			booActivaClaveSeguridad = EnumParametrosSistema.ACTIVA_CLAVE_SEGURIDAD.obtenerValorBooleano("S");
			
			if (booActivaClaveSeguridad) {
				
				pEvtFrmPnlClaveSeguridad.setLstTiposClaveSeguridadPermitidos(ClaveSeguridadVistaLogica.getInstance().consultarDisponibilidadServicioClaveSeguridad(pEvtFrmPnlClaveSeguridad.getObjUsuario()));
				
				if (!pEvtFrmPnlClaveSeguridad.getLstTiposClaveSeguridadPermitidos().isEmpty()) {
					
					booValido = true;
				}
			}
		
		}catch(Exception e){
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   pEvtFrmPnlClaveSeguridad.getFrmForma());
		}
		
		return booValido;
	}
	
	/**
	 * ********************************************************************
	 * @method validarTiposClaveSeguridadDisponibles
	 * 		   Metodo encargado de validar la disponibilidad de cada tipo
	 * 		   de clave de seguridad
	 * @param  pEvtFrmPnlClaveSeguridad
	 * 		   Control de eventos de la forma panel (seccion), que integra 
	 * 		   el proceso de token de validacion, clave para recuperar la 
	 * 		   forma de la funcionalidad, usuario y otro tipo de informacion 
	 * 		   alterna 
	 * @param  pObjCfgOfrecerClaveSeguridad
	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer clave de seguridad
	 * @return boolean
	 * 		   Badera que identifica si se encontraron o no tipos de clave
	 * 		   de seguridad disponibles
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	private boolean validarTiposClaveSeguridadDisponibles(EventoFormaPanelClaveSeguridad pEvtFrmPnlClaveSeguridad,
												 		  ConfigOfrecerClaveSeguridadDTO pObjCfgOfrecerClaveSeguridad)throws Exception{
		
		TipoClaveSeguridadDTO objDtoTipoClaveSeguridad;
		
		for(EnumTiposClaveSeguridad enmTipoClaveSeguridad : pEvtFrmPnlClaveSeguridad.getLstTiposClaveSeguridadPermitidos()){
			
			try{
				
				objDtoTipoClaveSeguridad = enmTipoClaveSeguridad.validarDisponibilidad(pObjCfgOfrecerClaveSeguridad);
				
				if(objDtoTipoClaveSeguridad!=null){
				
					pObjCfgOfrecerClaveSeguridad.getLstTiposClaveSeguridad().add(objDtoTipoClaveSeguridad);
				}
				
			}catch(Exception e){
				
				UtilidadesGiros.getInstance().controlExcepcion(e, 
															   pEvtFrmPnlClaveSeguridad.getFrmForma());
			}
		}
		
		return !pObjCfgOfrecerClaveSeguridad.getLstTiposClaveSeguridad().isEmpty();
	}

	/** 
	 * ********************************************************************
	 * @method 	generarClaveAleatoria
	 * 		   	Metodo que permite generar de manera aleatoria una clave de
	 * 			seguridad
	 * @param 	pIntLongitudMinimaClave
	 * 			Longitud minima que deberia tener la clave generada 
	 * @param 	pIntLongitudMaximaClave
	 * 			Longitud maxima que deberia tener la clave generada
	 * @return	String
	 * 			Clave generada aleatoriamente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	hector.cuenca
	 * @date   	7/03/2017
	 * *********************************************************************
	 */
	public	String	generarClaveAleatoria	(	int	pIntLongitudMinimaClave,
												int	pIntLongitudMaximaClave
											)	
			throws Exception
	{
		String strClaveGenerada;
		int isNumero;
		int letraNumerica;
		int cantidadCaracteres;
		
		isNumero		=	1;
		letraNumerica	=	97;
		
		cantidadCaracteres	= 	(int)(Math.random() * (pIntLongitudMaximaClave - pIntLongitudMinimaClave) + pIntLongitudMinimaClave);
		
		strClaveGenerada	=	"";
		
		for (int i = 0; i <= cantidadCaracteres; i++) {
			letraNumerica = (int)(Math.random() * (122 - 97) + 97);
			char caracter = (char)letraNumerica;
			if(isNumero == 1){
				strClaveGenerada =	strClaveGenerada + (int)(Math.random() * 10 );
			}else{
				strClaveGenerada = strClaveGenerada.concat(String.valueOf(caracter));
			}
			isNumero = (int)(Math.random() * (3 - 1) + 1);
		}	
		
		strClaveGenerada	=	strClaveGenerada.toUpperCase();
		
		return strClaveGenerada;
	}
	
	/**
	 * @method getHmTiposClaveSeguridad
	 * 		   Metodo get del atributo hmTiposClaveSeguridad
	 * @return HashMap<String,ClaveSeguridadDTO>
	 *		   Valor del atributo hmTiposClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public HashMap<String, ClaveSeguridadDTO> getHmTiposClaveSeguridad() {
		return this.hmTiposClaveSeguridad;
	}

	/**
	 * @method setHmTiposClaveSeguridad
	 * 		   Metodo set del atributo hmTiposClaveSeguridad
	 * @param  pHmTiposClaveSeguridad
	 *		   Valor que tomara el atributo hmTiposClaveSeguridad
	 * @author hector.cuenca
	 * @date   8/03/2016
	 */
	public void setHmTiposClaveSeguridad(
			HashMap<String, ClaveSeguridadDTO> pHmTiposClaveSeguridad) {
		this.hmTiposClaveSeguridad = pHmTiposClaveSeguridad;
	}
}
