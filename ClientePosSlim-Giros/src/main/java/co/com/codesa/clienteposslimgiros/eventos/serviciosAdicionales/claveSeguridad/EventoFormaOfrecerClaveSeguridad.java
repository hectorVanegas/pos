package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadAutomaticaDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.enumeraciones.serviciosAdicionales.claveSeguridad.EnumTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.serviciosAdicionales.SMSGiro.UtilSMSGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ClaveSeguridad;


/**
 * ********************************************************************
 * @class  EventoFormaOfrecerClaveSeguridad
 *		   Clase encargada de controlar los eventos de la forma para  
 * 		   ofrecer el servicio de clave de seguridad, este sera el 
 * 		   control de eventos principal que ejecutara y permitira la 
 * 		   integracion de los diferentes tipos de clave de seguridad 
 * 		   detectados como disponibles, siendo el encargado de administrar 
 * 		   el contenedor donde se dispondran los formularios particulares 
 * 		   demandados por cada tipo de clave de seguridad
 * @author roberth.martinez
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaOfrecerClaveSeguridad extends EventoAbstracto{
	
	/**
	 * @variable objCfgOfrecerClaveSeguridad
	 * 			 Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		  	 el proceso de ofrecer el servicio de clave de seguridad
	 */
	private ConfigOfrecerClaveSeguridadDTO objCfgOfrecerClaveSeguridad;
	
	/**
	 * ********************************************************************
	 * @method EventoFormaOfrecerClaveSeguridad
	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
	 * @param  pForma
	 * 		   Referencia a la GUI de la cual se estan controlando los 
  	 * 		   eventos
	 * @param  pObjCfgClaveSeguridad
	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer el servicio de clave de seguridad
	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EventoFormaOfrecerClaveSeguridad(FormaGenerica pForma,
											ConfigOfrecerClaveSeguridadDTO pObjCfgClaveSeguridad) throws Exception{
		
		super(pForma);
		
		this.objCfgOfrecerClaveSeguridad = pObjCfgClaveSeguridad;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.cargarFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarCambioItem(Component pComponent, 
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().equals(pComponent)){
			
			this.validarCambioTipoClaveSeguridad();
			
		}else{
			
			super.accionarCambioItem(pComponent,
									 pEvtItemStateChanged);
		}
	}
	/*
	@Override
	public void cancelar() throws Exception {
	
		FormaMensajeAlerta frmAlerta;
		
		if (!this.objCfgOfrecerClaveSeguridad.getEnmTipoOperacion().equals(EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO)) {
		
			frmAlerta = EnumMensajes.DESEA_CANCELAR_SERVICIO_CLAVE_SEGURIDAD.desplegarMensaje(super.getFrmForma(), 
					  															  EnumClasesMensaje.CONFIRMACION);
			
			if(frmAlerta.isOpcion()){//aceptar mensaje de confirmacion

				this.objCfgOfrecerClaveSeguridad.getObjFacturaGiro().setObjClaveSeguridad(null);
				super.regresarFormaPadre();
			}
		}else{
			super.regresarFormaPadre();
		}
	}
	*/
	
	@Override
	public void confirmar() throws Exception {
		
		TipoClaveSeguridadDTO objTipoClaveSeguridadSeleccionada;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios(super.getFrmForma(), 
				   												   true, 
				   												   true);
		
		objTipoClaveSeguridadSeleccionada = this.obtenerTipoClaveSeguridadSeleccionada();
		
		if(objTipoClaveSeguridadSeleccionada != null){
			
			objTipoClaveSeguridadSeleccionada.getiFrmTipoClaveSeguridad().ejecutar();
		}
		
		super.regresarFormaPadre();
	}
	
	/**
	 * ********************************************************************
	 * @method validarCambioTipoClaveSeguridad
	 * 		   Metodo que realiza las acciones pertinentes cuando se 
	 * 		   selecciona un tipo de clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	private void validarCambioTipoClaveSeguridad()throws Exception{
		
		IFormasTiposClaveSeguridad iFormasTiposClaveSeguridad;
		TipoClaveSeguridadDTO objTipoClaveSeguridadSeleccionada;
		JPanel pnlFormuarioTipoClaveSeguridad;
		
		pnlFormuarioTipoClaveSeguridad = this.castfrmOfrecerClaveSeguridad().getPnlContenidoCuerpo();
		pnlFormuarioTipoClaveSeguridad.removeAll();
		
		objTipoClaveSeguridadSeleccionada = this.obtenerTipoClaveSeguridadSeleccionada();
		
		if(objTipoClaveSeguridadSeleccionada!=null){
		
			try{
				
				objTipoClaveSeguridadSeleccionada.iniciarPropFrmPnlTipoClaveSeguridad(this.castfrmOfrecerClaveSeguridad(), 
																		  	 		  this.objCfgOfrecerClaveSeguridad);
				
				iFormasTiposClaveSeguridad = objTipoClaveSeguridadSeleccionada.getiFrmTipoClaveSeguridad();
				
				this.castfrmOfrecerClaveSeguridad().getPnlContenidoCuerpo().add((SeccionUtil) iFormasTiposClaveSeguridad);
				
			}catch(Exception e){
				
				this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().removeItem(objTipoClaveSeguridadSeleccionada);
				this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
				throw e;
			}
		}
		
		this.castfrmOfrecerClaveSeguridad().repaint();
	}
	
	/**
	 * ********************************************************************
	 * @method obtenerTipoClaveSeguridadSeleccionada
	 * 		   Metodo encargado de obtener el tipo de clave de seguridad
	 * 		   seleccionada
	 * @return TipoClaveSeguridadDTO
	 * 		   Tipo de clave de seguridad seleccionada, en caso de ser nulo
	 * 		   correspondera a que no se ha producido una seleccion valida
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	private TipoClaveSeguridadDTO obtenerTipoClaveSeguridadSeleccionada() throws Exception{
		
		Object objItemSeleccionado;
		TipoClaveSeguridadDTO objTipoClaveSeguridadSeleccionada;
		
		objItemSeleccionado = this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().getSelectedItem();
		
		if(objItemSeleccionado instanceof TipoClaveSeguridadDTO){
			
			objTipoClaveSeguridadSeleccionada = (TipoClaveSeguridadDTO) objItemSeleccionado;
			
		}else{
			
			objTipoClaveSeguridadSeleccionada = null;
		}
		
		return objTipoClaveSeguridadSeleccionada;
	}
	
	/**
	 * ********************************************************************
	 * @method cargarFormulario
	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	private void cargarFormulario()throws Exception{
		
		this.cargarTiposClaveSeguridadDisponibles();
		this.validaSeleccionarTipoClaveSeguridad();
	}
	
	/** 
	 * ********************************************************************
	 * @method validaSeleccionarTipoClaveSeguridad
	 * 		   Valida si la factura tiene clave de seguridad, para 
	 * 		   seleccionarla por defecto y no permitir cambiar el tipo de
	 *		   clave
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   14/3/2016
	 * *********************************************************************
	 */
	private void validaSeleccionarTipoClaveSeguridad() throws Exception{
		
		ClaveSeguridad objClaveSeguridad;
		EnumTiposClaveSeguridad enmTipoClaveSeguridad;
		
		objClaveSeguridad = this.objCfgOfrecerClaveSeguridad.getObjFacturaGiro().getObjClaveSeguridad();
		
		if (objClaveSeguridad != null) {
			
			enmTipoClaveSeguridad = (EnumTiposClaveSeguridad)objClaveSeguridad.getEnmTipoClaveSeguridad();
			
			this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().setSelectedItem(enmTipoClaveSeguridad.getObjDtoTipoClaveSeguridad());
			
			if(EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO.equals(this.objCfgOfrecerClaveSeguridad.getEnmTipoOperacion())){
			
				this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().setEnabled(false);
			}
		}
	}

	/**
	 * ********************************************************************
	 * @method cargarTiposClaveSeguridadDisponibles
	 * 		   Metodo que realiza el cargue de los tipos de clave de 
	 * 		   seguridad detectados como disponibles
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	private void cargarTiposClaveSeguridadDisponibles()throws Exception{
		
		this.castfrmOfrecerClaveSeguridad().getCmbTipoClaveSeguridad().getPropiedades().cargarCombo(this.objCfgOfrecerClaveSeguridad.getLstTiposClaveSeguridad().toArray(), 
								  							  						   				true, 
								  							  						   				EnumEtiquetas.LBL_NO_SELECCIONADO);	
	}
	
	/**
	 * ********************************************************************
	 * @method castfrmOfrecerClaveSeguridad
	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
	 * @return FormaOfrecerClaveSeguridad
	 * 		   Valor especifico recuperado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public FormaOfrecerClaveSeguridad castfrmOfrecerClaveSeguridad()throws Exception{
		return (FormaOfrecerClaveSeguridad)super.getFrmForma();
	}

}
