package co.com.codesa.clienteposslimgiros.eventos.reimpresion;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.dto.parametrosReimpresion.ParametrosReimpresionDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEstadoTransaccion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.impresion.EnumTiposImpresion;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.reimpresion.FormaReimpresion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.estadoTransaccion.EstadoTransaccion;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.mediosPago.UtilMediosPago;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.reimpresiones.UtilReimpresiones;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.impresion.ImpresionVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirEnvioGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirEnvioGiro566;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirPagoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ReimprimirPagoGiro566;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirEnvioGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirEnvioGiro566;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirPagoGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaReimprimirPagoGiro566;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.reimpresion.resultado.ProcesarResultadosReimpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.reimpresion.resultado.ResultadoReimpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.variablesImpresion.VariablesImpresionDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrapper.utilidades.Utilidades;

/**
 * ****************************************************************.
 * @autor  Hector Q-en-K
 * @fecha  05-oct-2015
 * @clase EventoFormaReimpresion 
 * 		  Clase que representa los eventos de la forma para ejecutar 
 * 		  las reimpresiones del sistema
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaReimpresion extends EventoAbstracto{
	
	private EnumReimpresiones enmReimpresionXDefecto;
	
	/**
	 * @variable lFacturas
	 * 		     listado de factura giro
	 **/
	private List<FacturaGiro> lFacturas;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaReimpresion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @param pEnmReimpresionXDefecto
  	 * 		  Constante de enumeracion que representa una reimpresion.
  	 * 		  con el fin de cargar una reimpresion de manera inicial
  	 * 		  sobre la forma
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaReimpresion(FormaReimpresion pForma,
								  EnumReimpresiones pEnmReimpresionXDefecto) throws Exception{
		super(pForma);
		
		this.enmReimpresionXDefecto = pEnmReimpresionXDefecto;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmReimpresion().getCmbTipoReimpresion().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmReimpresion().getCmbListaReimpresiones().getLblObligatorio().aplicarObligatoriedad(true);
		
		if(this.enmReimpresionXDefecto != null){
		
			this.castFrmReimpresion().getCmbTipoReimpresion().setEnabled(false);
			this.castFrmReimpresion().getCmbListaReimpresiones().setEnabled(false);
			
			EnumMensajes.VERIFICAR_TRANSACCION_PENDIENTE.desplegarMensaje(super.getFrmForma(), 
					  													  EnumClasesMensaje.ADVERTENCIA);
		}
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(this.castFrmReimpresion().getCmbTipoReimpresion().equals(pComponent)){
			
			this.cargarReimpresiones();
			
		}else if(this.castFrmReimpresion().getCmbListaReimpresiones().equals(pComponent)){
		
			this.mostrarParametros();
			
		}else{
			
			super.accionarCambioItem(pComponent,pEvtItemStateChanged);
		}
	}
	
	@Override
	public void imprimir() throws Exception {
		
		EnumReimpresiones enmReimpresion;
		this.castFrmReimpresion().getTblResultado().getPropiedades().limpiarGrilla();
		
		this.validarCamposObligatorios();
		
		enmReimpresion = (EnumReimpresiones)this.castFrmReimpresion().getCmbListaReimpresiones().getSelectedItem();
		
		if(this.validarEstadoTransaccion(enmReimpresion)){
		
			this.ejecutarReimpresion(enmReimpresion);
			
		}else{
			
			super.cerrarForma();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarEstadoTransaccion
  	 * 		   Metodo que permite notificar la confirmacion de la 
  	 * 		   operacion de consulta de transaccion, para procesos
  	 * 		   exclusivos del sistema
  	 * @param pEnmReimpresion
  	 * 		  Reimpresion seleccionada para ejecutar
  	 * @return boolean
  	 * 		   Bandera que permite continuar con el proceso de reimpresion
  	 * 		   ejecutado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private boolean validarEstadoTransaccion(EnumReimpresiones pEnmReimpresion) throws Exception{
		
		boolean booContinuaProcesoReimpresion;
		
		switch (pEnmReimpresion) {
		
			case REIMPRIMIR_ULTIMO_ENVIO_GIRO:
				
				booContinuaProcesoReimpresion = this.validarEstadoTransaccionUltimoEnvioGiro();
				
				break;
				
			case REIMPRIMIR_ULTIMO_PAGO_GIRO:
				
				booContinuaProcesoReimpresion = this.validarEstadoTransaccionUltimoPagoGiroExterno();
				
				break;
				
			case REIMPRIMIR_ULTIMO_PAGO_REMESA:
				
				booContinuaProcesoReimpresion = this.validarEstadoTransaccionUltimoEnvioGiro();
				
				break;
				
			default:
				booContinuaProcesoReimpresion = true;
				break;
		}
		
		return booContinuaProcesoReimpresion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarEstadoTransaccionUltimoEnvioGiro
  	 * 		   Metodo exlcusivo para operacion de reimpresion ultimo
  	 * 		   envio de giro, que permite notificar la confirmacion de la 
  	 * 		   operacion de consulta de transaccion, sobre un archivo 
  	 * 		   dedicado a controlar estos aspectos (estado.cfg), para
  	 * @return boolean
  	 * 		   Bandera que permite continuar con el proceso de reimpresion
  	 * 		   ejecutado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private boolean validarEstadoTransaccionUltimoEnvioGiro()throws Exception{
		
		boolean booContinuaProcesoReimpresion;
		
		booContinuaProcesoReimpresion = true;
		
		if(EstadoTransaccion.getInstance().compararValorPropiedad(EnumEstadoTransaccion.VERIFICADO, 
				  												  "true", 
				  												  "false")){

			EstadoTransaccion.getInstance().grabarValorPropiedad(EnumEstadoTransaccion.VERIFICADO, 
																 "true");
		}
		
		return booContinuaProcesoReimpresion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarEstadoTransaccionUltimoPagoGiroExterno
  	 * 		   Metodo exlcusivo para operacion de reimpresion ultimo
  	 * 		   pago de giro (externo), que permite notificar la 
  	 * 		   confirmacion de la operacion de consulta de transaccion, 
  	 * 		   sobre un archivo dedicado a controlar estos aspectos 
  	 * 		   (estado.cfg), adicionando otras operaciones relacionadas 
  	 * 		   con el tema
  	 * @return boolean
  	 * 		   Bandera que permite continuar con el proceso de reimpresion
  	 * 		   ejecutado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private boolean validarEstadoTransaccionUltimoPagoGiroExterno()throws Exception{
		
		boolean booContinuaProcesoReimpresion = true;
		
		if(!EstadoTransaccion.getInstance().compararValorPropiedad(EnumEstadoTransaccion.PIN_EXT, 
				   												   null, 
				   												   null)){
			if(this.enmReimpresionXDefecto != null){

				/**
				 * equivalente a un acceso automatico al modulo, redirigido por alguna funcionalidad
				 */

				booContinuaProcesoReimpresion = this.verificarTransaccionPagoGiroExternoPendiente(EnumMensajes.PAGO_GIRO_EXTERNO_RESPUESTA_INCORRECTA_PROVEEDOR);
				
			}else{//if(this.enmReimpresionXDefecto != null)

				/**
				 * equivalente a un acceso formal al modulo, desde el menu de opciones
				 */

				booContinuaProcesoReimpresion = this.verificarTransaccionPagoGiroExternoPendiente(EnumMensajes.PAGO_GIRO_EXTERNO_X_VALIDAR);
			}
			
		}
		
		return booContinuaProcesoReimpresion;
	}
	
	private boolean verificarTransaccionPagoGiroExternoPendiente(EnumMensajes pEnmMensaje)throws Exception{
		
		FormaMensajeAlerta frmMsgAlerta;
		boolean booContinuaProcesoReimpresion = true;
		
		frmMsgAlerta = pEnmMensaje.desplegarMensaje(super.getFrmForma(), 
													EnumClasesMensaje.CONFIRMACION);
		
		if(frmMsgAlerta.isOpcion()){
			
			booContinuaProcesoReimpresion = this.ejecutarVerificacionTransaccionPagoGiroExternoPendiente();
			
		}else{
			EstadoTransaccion.getInstance().grabarValorPropiedad(EnumEstadoTransaccion.PIN_EXT, 
					 											 null);
			if(this.enmReimpresionXDefecto != null){

				/**
				 * equivalente a un acceso automatico al modulo, redirigido por alguna funcionalidad
				 */
				
				booContinuaProcesoReimpresion = false;
				
			}else{//if(this.enmReimpresionXDefecto != null)

				/**
				 * equivalente a un acceso formal al modulo, desde el menu de opciones
				 */
				
				EnumMensajes.SE_IMPRIMIRA_ULTIMO_PAGO_DE_GIRO_INTERNO.desplegarMensaje(super.getFrmForma(), 
																					   EnumClasesMensaje.INFORMACION);
			}
		}
		
		return booContinuaProcesoReimpresion;
	}
	
	private boolean ejecutarVerificacionTransaccionPagoGiroExternoPendiente()throws Exception{
		
		FacturaGiro objFacturaGiro;
		Mensaje objMensaje;
		String strReferencia;
		String strFechaConsulta;
		String marcaCRC;
		boolean booContinuaProcesoReimpresion = true;
		
		strReferencia = EstadoTransaccion.getInstance().obtenerValorPropiedad(EnumEstadoTransaccion.PIN_EXT, 
																			  null);
		
		marcaCRC = EstadoTransaccion.getInstance().obtenerValorPropiedad(EnumEstadoTransaccion.MARCA_CRC, 
				  null);
		
		objFacturaGiro = new FacturaGiro();
		objFacturaGiro.setReferenciaControl(strReferencia);
		
		try{
			strFechaConsulta = UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_GUION().format(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
		
			this.lFacturas = GiroVistaLogica.getInstance().consultaGiroExterno(super.getObjUsuario(),
																			   strFechaConsulta, 
																			   strFechaConsulta, 
																			   null, 
																			   null, 
																			   strReferencia);
			
			objFacturaGiro = this.lFacturas.get(0);
			objFacturaGiro.setAgenciaDestino(super.getObjUsuario().getAgencia());
			UtilMediosPago.getInstance().gestionarMediosPagoXFactura(objFacturaGiro);
			GiroVistaLogica.getInstance().insertarMovimientoPagoFacturacionExterna(super.getObjUsuario(),
					   															   objFacturaGiro,
					   															   marcaCRC);
			
			booContinuaProcesoReimpresion = this.finalizarEstadoTransaccionPagoGiroExternoPendiente(false);
			
		}catch(ClientePosSlimGirosException cpsge){
		
			super.controlExcepcion(cpsge);
			
			objMensaje = (Mensaje)cpsge.getObjMensaje();
			
			if(objMensaje.getCodigo().equals(EnumMensajes.GIRO_EXTERNO_ESTA_PAGADO_SOBRE_SIMS.getCodigo())){
				
				booContinuaProcesoReimpresion = this.finalizarEstadoTransaccionPagoGiroExternoPendiente(true);
				
			}else{
				
				booContinuaProcesoReimpresion = this.verificarTransaccionPagoGiroExternoPendiente(EnumMensajes.PAGO_GIRO_EXTERNO_RESPUESTA_INCORRECTA_PROVEEDOR);
			}
		}
		
		return booContinuaProcesoReimpresion;
	}
	
	private boolean finalizarEstadoTransaccionPagoGiroExternoPendiente(boolean pBooConfirmarProcesoReimpresion)throws Exception{
		
		FormaMensajeAlerta frMsgAlerta;
		boolean booContinuaProcesoReimpresion = true;
		
		EstadoTransaccion.getInstance().grabarValorPropiedad(EnumEstadoTransaccion.PIN_EXT, 
															 null);
		
		EstadoTransaccion.getInstance().grabarValorPropiedad(EnumEstadoTransaccion.MARCA_CRC, 
				 null);
		
		if(pBooConfirmarProcesoReimpresion){
			
			frMsgAlerta = EnumMensajes.CONTINUAR_REIMPRESION.desplegarMensaje(super.getFrmForma(), 
															 				  EnumClasesMensaje.CONFIRMACION);
			
			booContinuaProcesoReimpresion = frMsgAlerta.isOpcion();
		}
		
		return booContinuaProcesoReimpresion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario
  	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario()throws Exception{
		
		EnumTiposImpresion[] arrEnmTiposImpresion; 
		Object[] arrEnmEtiTtlTiposReimpresion;
		
		arrEnmEtiTtlTiposReimpresion = new Object[EnumTiposImpresion.values().length]; 
		arrEnmTiposImpresion = EnumTiposImpresion.values();
		
		for	(int i = 0; i<arrEnmEtiTtlTiposReimpresion.length;i++)
		{
			arrEnmEtiTtlTiposReimpresion[i] = arrEnmTiposImpresion[i].getEnmTitulo();
		}
		
		this.castFrmReimpresion().getCmbTipoReimpresion().getPropiedades().cargarCombo(arrEnmEtiTtlTiposReimpresion, 
							  								  						   true, 
							  								  						   null);
		
		if(this.enmReimpresionXDefecto != null
				//&& this.enmReimpresionXDefecto.getEnmTipoImpresion() != null
				){
/*			
			if(this.enmReimpresionXDefecto.getEnmTipoImpresion().equals(EnumTiposImpresion.ULTIMA_TRANSACCION)){//.getObjBooTipo().equals(EnumReimpresiones.TIPO_REIMPRESION_ULTIMA_TRANSACCION)){
				
				etiTipoReimpresion = EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_ULTIMA_TRANSACCION;
				
			}else if(this.enmReimpresionXDefecto.getEnmTipoImpresion().equals(EnumTiposImpresion.POR_PIN)){//.getObjBooTipo().equals(EnumReimpresiones.TIPO_REIMPRESION_ULTIMA_TRANSACCION)){
				
				etiTipoReimpresion = EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_X_PIN;
				
			}else if(this.enmReimpresionXDefecto.getEnmTipoImpresion().equals(EnumTiposImpresion.OTROS)){
				
				etiTipoReimpresion = EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_OTRAS;
			}

			
			if(etiTipoReimpresion != null){
	*/			
				this.castFrmReimpresion().getCmbTipoReimpresion().setSelectedItem(this.enmReimpresionXDefecto.getEnmTipoImpresion().getEnmTitulo());
				this.castFrmReimpresion().getCmbListaReimpresiones().setSelectedItem(this.enmReimpresionXDefecto);
	//		}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarCamposObligatorios
  	 * 		   Permite realizar las validaciones necesarias realizar
  	 * 		   la operacion de reimpresion
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarCamposObligatorios()throws Exception{
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmReimpresion().getCmbTipoReimpresion(), 
															    this.castFrmReimpresion().getLblTipoReimpresion().getTextoOriginal(), 
															    true, 
															    true);

		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmReimpresion().getCmbListaReimpresiones(), 
																this.castFrmReimpresion().getLblListaReimpresiones().getTextoOriginal(), 
																true, 
																true);

		this.castFrmReimpresion().getPnlDatosAdicionales().getPropiedadesPnlDatosAdicionales().validarDatosAdicionalesIngresados();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarReimpresiones
  	 * 		   Permite, segun cargar la lista de reimpresiones definidas
  	 * 		   para el tipo seleccionado
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarReimpresiones()throws Exception{
		
		Object arrObjEnmReimpresiones[];
		Object objTipoSeleccionado;
		
		objTipoSeleccionado = this.castFrmReimpresion().getCmbTipoReimpresion().getSelectedItem();
		arrObjEnmReimpresiones = null;
		
		if(EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_X_PIN.equals(objTipoSeleccionado)){
			
			arrObjEnmReimpresiones = UtilReimpresiones.getInstance().getLstEnmReimpresionesXPin().toArray();
			
		}else if(EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_ULTIMA_TRANSACCION.equals(objTipoSeleccionado)){
			
			arrObjEnmReimpresiones = UtilReimpresiones.getInstance().getLstEnmReimpresionesXUltimaTransaccion().toArray();
			
		}else if(EnumEtiquetas.TTL_RMP_CMB_TIPO_REIMPRESION_OTRAS.equals(objTipoSeleccionado)){
			
			arrObjEnmReimpresiones = UtilReimpresiones.getInstance().getLstEnmReimpresionesOtras().toArray();
		}
		
		this.castFrmReimpresion().getCmbListaReimpresiones().getPropiedades().cargarCombo(arrObjEnmReimpresiones, 
				 								 					     				  true, 
				 								 					     				  null);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo mostrarParametros
  	 * 		   Permite, segun la reimpresion seleccionada cargar los 
  	 * 		   parametros asociados a esta, sobre la grilla de datos
  	 * 		   adicionales
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void mostrarParametros()throws Exception{
		
		ParametrosReimpresionDTO objParametrosReimpresionDTO = null;
		Object objValorSeleccionado;
		
		objValorSeleccionado = this.castFrmReimpresion().getCmbListaReimpresiones().getSelectedItem();
		
		if(objValorSeleccionado instanceof EnumReimpresiones){
			
			objParametrosReimpresionDTO = ((EnumReimpresiones)objValorSeleccionado).getObjParametrosReimpresion();
		}
		
		this.castFrmReimpresion().getPnlDatosAdicionales().getPropiedadesPnlDatosAdicionales().mostrarDatosAdicionales(objParametrosReimpresionDTO,
																													   true);
		
		this.castFrmReimpresion().getTblResultado().getPropiedades().limpiarGrilla();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo ejecutarReimpresion
  	 * 		   Permite ejecutar el proceso de reimpresion, segun el tipo
  	 * 		   de reimpresion y comprobante seleccionado
  	 * @param pEnmReimpresion
  	 * 		  Reimpresion seleccionada para ejecutar
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void ejecutarReimpresion(EnumReimpresiones pEnmReimpresion)throws Exception{
		
		VariablesImpresionDTO objVariablesImpresionDTO;
		ProcesarResultadosReimpresionDTO objProcesarResultadosReimpresionDTO;
		boolean booImpresionIngresoEgreso = true;
		
		objVariablesImpresionDTO = pEnmReimpresion.getEnmImpresion().getClsVariablesImpresionDTO().newInstance();
		
		objProcesarResultadosReimpresionDTO = new ProcesarResultadosReimpresionDTO();
		
		/**
		 * @autor brayan.rojas
		 * @fecha 28/10/2019	
		 * proposito: realizar el envio de la trama 566 para una reimpresion automatica.
		 */
		if (this.enmReimpresionXDefecto != null) {
			//validar que operacion es: envio o pago?

			if(pEnmReimpresion.getClsEntTrmEnvio().equals(ReimprimirEnvioGiro.class)) {
				pEnmReimpresion.setClsEntTrmEnvio(ReimprimirEnvioGiro566.class);
				pEnmReimpresion.setClsEntTrmRespuesta(RespuestaReimprimirEnvioGiro566.class);
			}else if (pEnmReimpresion.getClsEntTrmEnvio().equals(ReimprimirPagoGiro.class)) {
				pEnmReimpresion.setClsEntTrmEnvio(ReimprimirPagoGiro566.class);
				pEnmReimpresion.setClsEntTrmRespuesta(RespuestaReimprimirPagoGiro566.class);
				
			}
		}
		
		if (this.enmReimpresionXDefecto == null) {
			if(pEnmReimpresion.getClsEntTrmEnvio().equals(ReimprimirEnvioGiro566.class)) {
				pEnmReimpresion.setClsEntTrmEnvio(ReimprimirEnvioGiro.class);
				pEnmReimpresion.setClsEntTrmRespuesta(RespuestaReimprimirEnvioGiro.class);
			}else if (pEnmReimpresion.getClsEntTrmEnvio().equals(ReimprimirPagoGiro566.class)) {
				pEnmReimpresion.setClsEntTrmEnvio(ReimprimirPagoGiro.class);
				pEnmReimpresion.setClsEntTrmRespuesta(RespuestaReimprimirPagoGiro.class);
				
			}
		}
		
		ImpresionVistaLogica.getInstancia().consultarParaReimpresion(super.getObjUsuario(),
																	 pEnmReimpresion,
																	 objVariablesImpresionDTO,
																	 objProcesarResultadosReimpresionDTO);				
			for(ResultadoReimpresionDTO objResultadoReimpresion : objProcesarResultadosReimpresionDTO.getLstResultadosReimpresion()){
				
				this.castFrmReimpresion().getTblResultado().getPropiedades().adicionarFilaGrilla(new Object[]{objResultadoReimpresion.getStrNombre(),
						  																					  objResultadoReimpresion.getObjResultado()});
			}
			
			if (	pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_ULTIMO_INGRESO)	||
					pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_ULTIMO_EGRESO)	||
					pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_X_PIN_INGRESO)  ||
					pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_X_PIN_EGRESO)){
				
					booImpresionIngresoEgreso = validarImpresionIngresoEgreso(pEnmReimpresion);
				}
			
			if(EnumMensajes.CONFIRMAR_IMPRESION_COMPROBANTE.desplegarMensaje(super.getFrmForma(), EnumClasesMensaje.CONFIRMACION).isOpcion()){

				pEnmReimpresion.getEnmImpresion().ejecutarImpresion(super.getFrmForma(), true, objVariablesImpresionDTO);
			}
		}
	
	private boolean validarImpresionIngresoEgreso(EnumReimpresiones pEnmReimpresion) throws Exception {
		
		ParametroSistema psPASI;
		String strIdentColaborador;
		boolean booImprime = true;
		
		strIdentColaborador = InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().getRcNit();
		psPASI = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.IDENTIFICACIONES_COLABORADORES_RESTRINGIDOS_INGRESOS);
		
		validarParametroSistemaIDREOPIE(psPASI.getValor());
		
		booImprime = validarColaboradoresImpresion(psPASI.getValor(), strIdentColaborador, pEnmReimpresion);
		
		return booImprime;
	}
	
	/**
     * ****************************************************************
     * @metodo  validarColaboradoresImpresion
     *			metodo que valida el colaborador dependiendo de la configuracion
     *			en el parametro IDREOPIE
     * @throws  Exception
     * @autor   Roberth Martinez Vargas
     * ****************************************************************
     */
	private boolean validarColaboradoresImpresion(String pStrIDREOPIE, String strIdentColaborador, EnumReimpresiones pEnmReimpresion) throws Exception {
		
		boolean booImprimeT = true;
		
		if (pStrIDREOPIE != null) {
			
			if (pStrIDREOPIE.contains(EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor())) {
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(pStrIDREOPIE, ";");
				
				while (stk_pStrIDREOPIE.hasMoreElements()) {
					
					String registro = "";
					String strIdentificacion = "";
					String strImprimeIngreso = "";
					String strImprimeEgreso  = "";
					
					registro = stk_pStrIDREOPIE.nextToken();
					
					if (!registro.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
						
						throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
					}
					
					StringTokenizer stkRegistro = new StringTokenizer(registro, "|");
					
					strIdentificacion = stkRegistro.nextToken();
					strImprimeIngreso = stkRegistro.nextToken();
					strImprimeEgreso = stkRegistro.nextToken();
					
					validaDatosParameroIDREOPIE(strIdentificacion, strImprimeIngreso, strImprimeEgreso);
					
					if (	pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_ULTIMO_INGRESO)	||
							pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_X_PIN_INGRESO)  ){
						
						if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("N") ) {
							booImprimeT = false;
						} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("S") ) {
							booImprimeT = true;
						}
					}
					
					if (	pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_ULTIMO_EGRESO)	||
							pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_X_PIN_EGRESO)){
						
						if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("N") ) {
							booImprimeT = false;
						} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("S") ) {
							booImprimeT = true;
						}
					}
					
				}
				
			} else {
				
				if (!pStrIDREOPIE.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
					
					throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(pStrIDREOPIE, "|");
				
				String strIdentificacion = "";
				String strImprimeIngreso = "";
				String strImprimeEgreso  = "";
				strIdentificacion = stk_pStrIDREOPIE.nextToken();
				strImprimeIngreso = stk_pStrIDREOPIE.nextToken();
				strImprimeEgreso = stk_pStrIDREOPIE.nextToken();
				
				if (	pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_ULTIMO_INGRESO)	||
						pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_X_PIN_INGRESO)  ){
					
					if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("N") ) {
						booImprimeT = false;
					} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeIngreso.equals("S") ) {
						booImprimeT = true;
					}
				}
				
				if (	pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_ULTIMO_EGRESO)	||
						pEnmReimpresion.equals(EnumReimpresiones.REIMPRIMIR_X_PIN_EGRESO)){
					
					if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("N") ) {
						booImprimeT = false;
					} else if (	strIdentificacion.equals(strIdentColaborador) && strImprimeEgreso.equals("S") ) {
						booImprimeT = true;
					}
				}
			}
			
		} 
		
		return booImprimeT;
	}
	
	private void validarParametroSistemaIDREOPIE(String strpIDREOPIE) throws Exception{
		
		if (strpIDREOPIE != null) {
			
			if (strpIDREOPIE.contains(EnumGeneralidadesTramasGiros.PUNTO_Y_COMA.getValor())) {
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(strpIDREOPIE, ";");
				
				while (stk_pStrIDREOPIE.hasMoreElements()) {
					
					String registro = "";
					String strIdentificacion = "";
					String strImprimeIngreso = "";
					String strImprimeEgreso  = "";
					
					registro = stk_pStrIDREOPIE.nextToken();
					
					if (!registro.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
						
						throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
					}
					
					StringTokenizer stkRegistro = new StringTokenizer(registro, "|");
					
					try {
						strIdentificacion = stkRegistro.nextToken();
						strImprimeIngreso = stkRegistro.nextToken();
						strImprimeEgreso = stkRegistro.nextToken();
					} catch (NoSuchElementException e) {
						
						throw EnumMensajes.TOKEN_DE_PARAMETRO_VACIO.generarExcepcion(EnumClasesMensaje.ERROR);
					}
					
					validaDatosParameroIDREOPIE(strIdentificacion, strImprimeIngreso, strImprimeEgreso);
				}
				
			} else {
				
				String strIdentificacion = "";
				String strImprimeIngreso = "";
				String strImprimeEgreso  = "";
				
				if (!strpIDREOPIE.contains(EnumGeneralidadesTramasGiros.PIPE.getValor())) {
					
					throw EnumMensajes.ESTRUCTURA_PARAMETRO_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				StringTokenizer stk_pStrIDREOPIE = new StringTokenizer(strpIDREOPIE, "|");
				
				try {
					strIdentificacion = stk_pStrIDREOPIE.nextToken();
					strImprimeIngreso = stk_pStrIDREOPIE.nextToken();
					strImprimeEgreso  = stk_pStrIDREOPIE.nextToken();
				} catch (NullPointerException e) {
					
					throw EnumMensajes.TOKEN_DE_PARAMETRO_VACIO.generarExcepcion(EnumClasesMensaje.ERROR);
				}
				
				validaDatosParameroIDREOPIE(strIdentificacion, strImprimeIngreso, strImprimeEgreso);
				
			}
		}
	}
	
	private void validaDatosParameroIDREOPIE(String strIdent, String strImprIngreso, String strImprEgreso) throws Exception {		
		
		if (!Utilidades.esStringConTamanoMinimo(strImprIngreso, 1)) {
			throw EnumMensajes.VALOR_TOKEN_INGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if ( !strImprIngreso.equals("S") && !strImprIngreso.equals("N")) {
			throw EnumMensajes.VALOR_TOKEN_INGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if (!Utilidades.esStringConTamanoMinimo(strImprEgreso, 1)) {
			throw EnumMensajes.VALOR_TOKEN_EGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		if (!strImprEgreso.equals("S") && !strImprEgreso.equals("N")) {
			throw EnumMensajes.VALOR_TOKEN_EGRESOS_PARAM_IDREOPIE.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmReimpresion
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaReimpresion
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaReimpresion castFrmReimpresion()throws Exception{
		return (FormaReimpresion)super.getFrmForma(); 
	}

	/**
	 * @method getlFacturas
	 * 		   Metodo get del atributo lFacturas
	 * @return List<FacturaGiro>
	 *		   Valor del atributo lFacturas devuelto
	 * @author roberth.martinez
	 * @date   20/4/2017
	 */
	public List<FacturaGiro> getlFacturas() {
		return lFacturas;
	}

	/**
	 * @method setlFacturas
	 * 		   Metodo set del atributo lFacturas
	 * @param  lFacturas
	 *		   Valor que tomara el atributo lFacturas
	 * @author roberth.martinez
	 * @date   20/4/2017
	 */
	public void setlFacturas(List<FacturaGiro> lFacturas) {
		this.lFacturas = lFacturas;
	}
}
