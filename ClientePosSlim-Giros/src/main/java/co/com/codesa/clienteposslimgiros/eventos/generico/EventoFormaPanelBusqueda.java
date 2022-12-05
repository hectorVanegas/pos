package co.com.codesa.clienteposslimgiros.eventos.generico;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEstadoTransaccion;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumReimpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelBusqueda;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.reimpresion.FormaReimpresion;
import co.com.codesa.clienteposslimgiros.utilidades.estadoTransaccion.EstadoTransaccion;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;

/**
 * ****************************************************************
 * @autor  Roberth Martinez Vargas
 * @fecha  7-mar-2014
 * @descripcion Clase que representa los eventos del panel de 
 * 			    busqueda por pin o documento
 * @copyright  Copyright  1998-2012 Codesa, Todos los derechos 
 * 			   reservados.
 * ****************************************************************
 */
public class EventoFormaPanelBusqueda extends EventoAbstracto{

	/**
	 * @variable frmPnlBusqueda
	 * 		     objeto de la forma FormaPanelBusqueda
	 **/
	private FormaPanelBusqueda frmPnlBusqueda;
	
	/**
     * ****************************************************************
     * @param  pFormaBusqueda
     * @param  eventoGenerica
     * @metodo EventoFormaPanelBusqueda
     * 		   Constructor de la FormaPanelBusqueda
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public EventoFormaPanelBusqueda(FormaPanelBusqueda pFrmPnlBusqueda,
							   		FormaGenerica pFrmPadre) {
		
		super(pFrmPadre);
		this.frmPnlBusqueda = pFrmPnlBusqueda;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.configuracionCampos();
		this.cargarFormulario();
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if (pComponent.equals(this.frmPnlBusqueda.getCmbBusqueda())) {
			
			if(this.frmPnlBusqueda.getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO)){
				
				this.habilitarBusquedaXTipo(true);
				this.configurarFormatoIdentificacionXTipo();
				
			}else if (this.frmPnlBusqueda.getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN)) {
				
				this.frmPnlBusqueda.getTxtReferencia().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
				this.habilitarBusquedaXTipo(false);
				
			}else{
				
				this.habilitarBusquedaXTipo(null);
			}
			
		}else if (pComponent.equals(this.frmPnlBusqueda.getChkExterno())) {
			
			if(this.frmPnlBusqueda.getChkExterno().isSelected()){
				
				if(EstadoTransaccion.getInstance().compararValorPropiedad(EnumEstadoTransaccion.PIN_EXT, 
																	   	  "", 
																	   	  "")){
					
					if(this.frmPnlBusqueda.getChkRemitente() != null && 
							this.frmPnlBusqueda.getChkRemitente().isVisible()){
						
						this.frmPnlBusqueda.getChkRemitente().setEnabled(false);
						this.frmPnlBusqueda.getChkDestinatario().setSelected(true);
		    		}
					
				}else{
					
					new FormaReimpresion((JFrame)super.cerrarForma(), 
										 true, 
										 EnumReimpresiones.REIMPRIMIR_ULTIMO_PAGO_GIRO);
				}
				
				if (this.frmPnlBusqueda.getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN)) {
					this.frmPnlBusqueda.getTxtReferencia().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO_EXT.getValor());
				}
				
			}else{
				
				if(this.frmPnlBusqueda.getChkRemitente().isVisible()){
					
					this.frmPnlBusqueda.getChkRemitente().setEnabled(true);
	    		}
				
				if (this.frmPnlBusqueda.getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN)) {
					this.frmPnlBusqueda.getTxtReferencia().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
					this.frmPnlBusqueda.getTxtReferencia().setText("");
				}
			}
			
		}else if(pComponent.equals(this.frmPnlBusqueda.getCmbTiposIdentificacion())){
			
			this.frmPnlBusqueda.getTxtIdentificacion().setText("");
			this.configurarFormatoIdentificacionXTipo();
		}
	}
	
	/**
     * ****************************************************************
     * @autor  Roberth Martinez Vargas
     * @throws Exception
     * @metodo configuracionCampos
     * 		   metodo para configurar campos
     * ****************************************************************
     */
	private void configuracionCampos()throws Exception{
		
		this.configuracionCamposTexto();
	}
	
	/**
     * ****************************************************************
     * @autor  Roberth Martinez Vargas
     * @throws Exception
     * @metodo configuracionCamposTexto
     * 		   metodo para configurar campos de texto
     * ****************************************************************
     */
	private void configuracionCamposTexto()throws Exception{
		
		this.frmPnlBusqueda.getTxtReferencia().getPropiedades().setActivaMayusculaMinuscula(true);
		
		this.configurarFormatoIdentificacionXTipo();
	}
	
	/**
     * ****************************************************************
     * @autor  Roberth Martinez Vargas
     * @throws Exception
     * @metodo cargarFormulario
     * 		   metodo para cargar datos del formulario
     * ****************************************************************
     */
	private void cargarFormulario()throws Exception{
		
		this.cargarTiposBusqueda();
		this.cargarTiposIdentificacion();
	}
	
	/**
     * ****************************************************************
     * @autor  Roberth Martinez Vargas
     * @throws Exception
     * @metodo cargarTiposBusqueda
     * 		   carga la informacion del combo de opciones de busqueda
     * ****************************************************************
     */
	private void cargarTiposBusqueda()throws Exception{
		
		this.frmPnlBusqueda.getCmbBusqueda().getPropiedades().cargarCombo(new Object[]{EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO,
								  							  						   EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN}, 
								  							  			  true, 
								  							  			  null);	
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo cargarTiposIdentificacion
     * 		   carga la informacion del combo tipos de identificacion
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void cargarTiposIdentificacion()throws Exception{
		
		String strIdEntidadTipoIdentificacion;
		
		strIdEntidadTipoIdentificacion = EnumParametrosApp.ENT_TIPOS_IDENTIFICACION.getValorPropiedad();
		
		this.frmPnlBusqueda.getCmbTiposIdentificacion().getPropiedades().cargarCombo(XmlDatosEntidades.getInstance().obtenerEntidad(strIdEntidadTipoIdentificacion).getHmDatos().values().toArray(), 
												 									 true);
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo configurarFormatoIdentificacionXTipo
     * 		   configura los formatos de ingreso dependiendo el tipo de
     * 		   identificacion seleccionado
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void configurarFormatoIdentificacionXTipo()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion;
		String strFormatoIngreso;
		
		this.frmPnlBusqueda.getTxtIdentificacion ().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strFormatoIngreso = null;
		objDatEntTipoIdentificacion = this.obtenerTipoIdentificacion();
		
		if(objDatEntTipoIdentificacion != null){
			
			this.frmPnlBusqueda.getTxtIdentificacion().setEnabled(true);
			
			if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CC.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CC.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CE.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CE.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_TI.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_TI.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_NIT.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_PA.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_PA.getValor();
				
			}else if(objDatEntTipoIdentificacion.getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_CEX.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CEX.getValor();
			}
			
		}else{
			this.frmPnlBusqueda.getTxtIdentificacion().setEnabled(false);
		}
		
		this.frmPnlBusqueda.getTxtIdentificacion().getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo obtenerTipoIdentificacion
     * 		   obtiene el tipo de identificacion seleccionado
     * @return DatoEntidad tipo de identificacion
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	public DatoEntidad obtenerTipoIdentificacion()throws Exception{
		
		DatoEntidad objDatEntTipoIdentificacion = null;
		Object objSeleccionado;
		
		objSeleccionado = this.frmPnlBusqueda.getCmbTiposIdentificacion().getSelectedItem();
		
		if(objSeleccionado instanceof DatoEntidad){
			objDatEntTipoIdentificacion = (DatoEntidad) objSeleccionado;
		}
		
		return objDatEntTipoIdentificacion;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo habilitarBusquedaXTipo
     * 		   habilita los componentes graficos dependiendo la opcion
     * 		   de busqueda
     * @return DatoEntidad tipo de identificacion
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void habilitarBusquedaXTipo(Boolean pBooTipoBusqueda)throws Exception{
		
		if(pBooTipoBusqueda != null){
			
			this.frmPnlBusqueda.getChkDestinatario().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getChkRemitente().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getChkRemitente().setEnabled(pBooTipoBusqueda);
			this.frmPnlBusqueda.getCmbTiposIdentificacion().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getLblFechaInicial().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getLblFechaFinal().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getDtcFechaInicial().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getDtcFechaFinal().setVisible(pBooTipoBusqueda);
			this.frmPnlBusqueda.getChkExterno().setVisible(true);
			this.frmPnlBusqueda.getChkExterno().setSelected(false);
			this.frmPnlBusqueda.getChkDestinatario().setSelected(true);
			
			this.frmPnlBusqueda.getTxtReferencia().setVisible(!pBooTipoBusqueda);
			this.frmPnlBusqueda.getTxtIdentificacion().setVisible(pBooTipoBusqueda);
			
			if	(	pBooTipoBusqueda	)
			{
				this.frmPnlBusqueda.getTxtIdentificacion().setText("");
				
			}	else	{
				
				this.frmPnlBusqueda.getTxtReferencia().setText("");
			}
			
		}else{
			
			this.frmPnlBusqueda.getChkDestinatario().setVisible(false);
			this.frmPnlBusqueda.getChkRemitente().setVisible(false);
			this.frmPnlBusqueda.getTxtReferencia().setVisible(false);
			this.frmPnlBusqueda.getTxtIdentificacion().setVisible(false);
			this.frmPnlBusqueda.getCmbTiposIdentificacion().setVisible(false);
			this.frmPnlBusqueda.getLblFechaInicial().setVisible(false);
			this.frmPnlBusqueda.getLblFechaFinal().setVisible(false);
			this.frmPnlBusqueda.getDtcFechaInicial().setVisible(false);
			this.frmPnlBusqueda.getDtcFechaFinal().setVisible(false);
			this.frmPnlBusqueda.getChkExterno().setVisible(false);
		}
	}

}
