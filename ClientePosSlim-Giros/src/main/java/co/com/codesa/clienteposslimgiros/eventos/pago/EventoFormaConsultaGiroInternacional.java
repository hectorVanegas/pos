package co.com.codesa.clienteposslimgiros.eventos.pago;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaConsultaGiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaPagoGiroInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Corresponsal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class	EventoFormaConsultaGiroInternacional
 *		 	Clase que representa los eventos de forma consulta giro
 *			internacional
 * @author	roberth.martinez
 * @date  	20/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaConsultaGiroInternacional extends EventoAbstracto{
	
	/**
	 * @variable strReferenciaSeleccionada
	 * 		     referencia seleccionada de la grilla
	 **/
	private String strReferenciaSeleccionada;
	
	/**
	 * @variable	objFacturaGiroInternacional
	 * 				objeto FacturaGiroInternacional con la informacion del giro
	 */
	private FacturaGiroInternacional objFacturaGiroInternacional;
	
	/**
	 * @variable	objFormaDatosAdicionales
	 * 				objeto de la forma FormaDatosAdicionales, 
	 * 				para la informacion de la empresa y el cargo
	 */
	private FormaDatosAdicionales objFormaDatosAdicionales;
	
	/**
	 * @variable lstFacturas
	 * 		     listado de factura giro internacional
	 **/
	
	private List<FacturaGiroInternacional> lstFacturas;
	/**
	 * @variable hmFacturas
	 * 		     hashmap de factura giro
	 **/
	private HashMap<String, FacturaGiroInternacional> hmFacturas;
	
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaConsultaGiroInternacional
	 * 		  	Constructor de la clase EventoFormaConsultaGiroInternacional
	 * @param   pForma
	 * 			Forma desde la cual se invoca el evento
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 * *********************************************************************
	 */
	public EventoFormaConsultaGiroInternacional(FormaConsultaGiroInternacional pForma) throws Exception{
		
		super(pForma);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		InformacionSessionGirosInternacional.getInstance(getObjUsuario());
		this.configuracionCampoTexto();
		this.cargarFormulario();
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if (pComponent.equals(this.castFrmConsultaGiroInternacional().getCmbBusqueda())) {
			
			if(this.castFrmConsultaGiroInternacional().getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO)){
				
				this.habilitarBusquedaXTipo(true);
				
			}else if (this.castFrmConsultaGiroInternacional().getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN)) {
				
				this.habilitarBusquedaXTipo(false);
				
			}else{
				
				this.habilitarBusquedaXTipo(null);
			}
			
		}else if (pComponent.equals(this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen())) {
			
			this.configurarFormatoIdentificacionXTipo();
		}
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmConsultaGiroInternacional().getCmbBusqueda().getLblObligatorio().aplicarObligatoriedad(true);
		
		this.castFrmConsultaGiroInternacional().getTxtReferencia().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConsultaGiroInternacional().getCmbCorresponsales().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getLblObligatorio().aplicarObligatoriedad(true);
		
		this.castFrmConsultaGiroInternacional().getTxtNombreTerceroBen().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroBen().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConsultaGiroInternacional().getTxtNombreTerceroRem().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroRem().getLblObligatorio().aplicarObligatoriedad(true);
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmConsultaGiroInternacional().getTblGiros(),
													this.castFrmConsultaGiroInternacional().getCmbBusqueda(),
													this.castFrmConsultaGiroInternacional().getTxtReferencia(),
													this.castFrmConsultaGiroInternacional().getCmbCorresponsales(),
													this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen(),
													this.castFrmConsultaGiroInternacional().getTxtDocumentoBen(),
													this.castFrmConsultaGiroInternacional().getTxtNombreTerceroBen(),
													this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroBen(),
													this.castFrmConsultaGiroInternacional().getTxtNombreTerceroRem(),
													this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroRem());
		
		/*super.configurarLimpiarXCamposAccionados(	this.castFrmConsultaGiroInternacional().getTblGiros(),
													this.castFrmConsultaGiroInternacional().getPnlReferencia());*/
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmConsultaGiroInternacional().getPnlBeneficiario(),
													this.castFrmConsultaGiroInternacional().getCmbBusqueda());
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmConsultaGiroInternacional().getPnlRemitente(),
													this.castFrmConsultaGiroInternacional().getCmbBusqueda());
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmConsultaGiroInternacional().getPnlReferencia(),
													this.castFrmConsultaGiroInternacional().getCmbBusqueda());
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmConsultaGiroInternacional().getTxtDocumentoBen(),
													this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen());
	}
	
	@Override
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel,
										ListSelectionEvent pEvtValueChanged) throws Exception {
		
		if(pObjLisSelectionModel.equals(this.castFrmConsultaGiroInternacional().getTblGiros().getSelectionModel())){
			
			this.seleccionarGiroGrilla();
			
		}else{
			
			super.accionarCambioRegistro(pObjLisSelectionModel,pEvtValueChanged);
		}
	}
	
	@Override
	public void accionarDobleClick(Component pObjComponent,
								   MouseEvent pEvtMouseClicked) throws Exception {
		
		if(pObjComponent.equals(this.castFrmConsultaGiroInternacional().getTblGiros())){
			
			
			
		}else{
			
			super.accionarDobleClick(pObjComponent,pEvtMouseClicked);
		}
	}
	
	@Override
	public void accionarFocoPerdido(Component pComponent, java.awt.event.FocusEvent pEvtFocusLost) throws Exception {
		
		if(pComponent.equals(this.castFrmConsultaGiroInternacional().getTxtDocumentoBen())){
			
			super.getFrmForma().setBooAnularEventosXFocusLost(true);
			
			if	(	!this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getText().trim().isEmpty()	)
			{
				this.cargarDocumentoAlReves();
			}
			
		}else{
			
			super.accionarFocoPerdido(pComponent,pEvtFocusLost);
		}
	}
	
	@Override
	public void confirmar() throws Exception{
		
		FacturaGiroInternacional facturaGiro;
		
		if(!this.castFrmConsultaGiroInternacional().getTblGiros().getSelectionModel().isSelectionEmpty()){
			
			facturaGiro = this.hmFacturas.get(this.strReferenciaSeleccionada);
			
			if(facturaGiro.isBooConsultaXReferencia()){
				
				new FormaPagoGiroInternacional(this.castFrmConsultaGiroInternacional(), 
						   					   true, 
						   					   facturaGiro);
				
			}else{
				
				facturaGiro = this.consultarGiroXReferencia(this.strReferenciaSeleccionada,
															this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getText(),
															facturaGiro.getObjCorresponsal(),
															(TipoDocumentoInternacional) this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().getSelectedItem());
				
				new FormaPagoGiroInternacional(this.castFrmConsultaGiroInternacional(), 
	   					   					   true, 
	   					   					   facturaGiro);
			}
			
		}else{
			
			throw EnumMensajes.DEBE_SELECCIONAR_UN_GIRO_PARA_PAGO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
	}
	
	@Override
	public void consultar() throws Exception{
		
		this.limpiarXCampo	(	null,
								this.castFrmConsultaGiroInternacional().getTblGiros());
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		if(this.castFrmConsultaGiroInternacional().getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO)){
			
			
			this.accionConsultarGiroXBeneficiario();
			
		}else if (this.castFrmConsultaGiroInternacional().getCmbBusqueda().getSelectedItem().equals(EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN)) {
			
			this.accionConsultarGiroXReferencia();
		}
		
	}
	
	@Override
	public	void	limpiarXCampo	(	Component pObjCmpAccionaLimpieza, 
										Component... pArrObjCmpALimpiar
									) 
											throws Exception 
	{
		super.limpiarXCampo	(	pObjCmpAccionaLimpieza, 
								pArrObjCmpALimpiar
							);
		
		this.limpiarObjTemporales();
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarFormulario
	 * 		  	Metodo para cargar los datos del formulario
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 * *********************************************************************
	 */
	private void cargarFormulario()throws Exception{
		
		this.cargarTiposBusqueda();
		this.cargarCmbCorresponsales();
		this.cargarCmbTiposDocumento();
	}
	
	/** 
	 * ********************************************************************
	 * @method	configuracionCampoTexto
	 * 		  	metodo utilizado para inicializar los datos de la forma 
     *		    envio giro postal
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	9/08/2018
	 * *********************************************************************
	 */
	private void configuracionCampoTexto()throws Exception{
		
		this.castFrmConsultaGiroInternacional().getTxtReferencia().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO_INTERNACIONAL2.getValor());
		this.castFrmConsultaGiroInternacional().getTxtNombreTerceroRem().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CGI_NOMBRE_TERCERO.getValor());
		this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroRem().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CGI_APELLIDO_TERCERO.getValor());
		this.castFrmConsultaGiroInternacional().getTxtNombreTerceroBen().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CGI_NOMBRE_TERCERO.getValor());
		this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroBen().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.CGI_APELLIDO_TERCERO.getValor());
		
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarTiposBusqueda
	 * 		  	Carga las opciones de busqueda
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 * *********************************************************************
	 */
	private void cargarTiposBusqueda()throws Exception{
		
		this.castFrmConsultaGiroInternacional().getCmbBusqueda().getPropiedades().cargarCombo(new Object[]{EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_DOCUMENTO,
								  							  						   		  EnumEtiquetas.LBL_BUS_ITEM_BUSQUEDA_POR_PIN}, 
								  							  						   		  true, 
								  							  						   		  null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbCorresponsales
	 * 		  	Carga los corresponsales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 * *********************************************************************
	 */
	private void cargarCmbCorresponsales()throws Exception{
		
		this.castFrmConsultaGiroInternacional().getCmbCorresponsales().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstCorresponsales().toArray(), 
								  							  						   		  		true, 
								  							  						   		  		null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbTiposDocumento
	 * 		  	Carga los tipos documentos
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 * *********************************************************************
	 */
	private void cargarCmbTiposDocumento()throws Exception{
		
		this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstTiposDocumentosInternacional().toArray(), 
								  							  						   		  		  true, 
								  							  						   		  		  null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	habilitarBusquedaXTipo
	 * 		  	Metodo para gestionar la visibilidad y posicion de los 
	 * 			campos para busqueda por pin, documento o ninguna
	 * @param   pBooTipoBusqueda
	 * 			Bandera booleana, null no muestra los campos de busqueda,
	 * 			true muestra los campos de busqueda por dicumento
	 * 			false muestra los campos de busquedad por referencia
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 * *********************************************************************
	 */
	private void habilitarBusquedaXTipo(Boolean pBooTipoBusqueda)throws Exception{
		
		if(pBooTipoBusqueda != null){
			
			if (pBooTipoBusqueda) {
				
				this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen().setBounds(EnumDimensionesComponentes.LBL_CPI_TIPO_DOCUMENTO_BEN_D.getRectangulo());
				this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().setBounds(EnumDimensionesComponentes.CMB_CPI_TIPO_DOCUMENTO_BEN_D.getRectangulo());
				this.castFrmConsultaGiroInternacional().getLblDocumentoBen().setBounds(EnumDimensionesComponentes.LBL_CPI_DOCUMENTO_BEN_D.getRectangulo());
				this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setBounds(EnumDimensionesComponentes.TXT_CPI_DOCUMENTO_BEN_D.getRectangulo());
				
				this.castFrmConsultaGiroInternacional().getPnlReferencia().remove(this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().remove(this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().remove(this.castFrmConsultaGiroInternacional().getLblDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().remove(this.castFrmConsultaGiroInternacional().getTxtDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().add(this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().add(this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().add(this.castFrmConsultaGiroInternacional().getLblDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().add(this.castFrmConsultaGiroInternacional().getTxtDocumentoBen());
				
			}else{
				
				this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen().setBounds(EnumDimensionesComponentes.LBL_CPI_TIPO_DOCUMENTO_BEN_R.getRectangulo());
				this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().setBounds(EnumDimensionesComponentes.CMB_CPI_TIPO_DOCUMENTO_BEN_R.getRectangulo());
				this.castFrmConsultaGiroInternacional().getLblDocumentoBen().setBounds(EnumDimensionesComponentes.LBL_CPI_DOCUMENTO_BEN_R.getRectangulo());
				this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setBounds(EnumDimensionesComponentes.TXT_CPI_DOCUMENTO_BEN_R.getRectangulo());
				
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().remove(this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().remove(this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().remove(this.castFrmConsultaGiroInternacional().getLblDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlBeneficiario().remove(this.castFrmConsultaGiroInternacional().getTxtDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().add(this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().add(this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().add(this.castFrmConsultaGiroInternacional().getLblDocumentoBen());
				this.castFrmConsultaGiroInternacional().getPnlReferencia().add(this.castFrmConsultaGiroInternacional().getTxtDocumentoBen());
				
			}
			
			/*this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen().setVisible(true);
			this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().setVisible(true);
			this.castFrmConsultaGiroInternacional().getLblDocumentoBen().setVisible(true);
			this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setVisible(true);
			
			this.castFrmConsultaGiroInternacional().getLblReferencia().setVisible(!pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getTxtReferencia().setVisible(!pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getLblCorresponsal().setVisible(!pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getCmbCorresponsales().setVisible(!pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getLblEstadoRemesa().setVisible(!pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getTxtEstadoRemesa().setVisible(!pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getLblNombreTerceroBen().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getTxtNombreTerceroBen().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getLblApellidoTerceroBen().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroBen().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getLblNombreTerceroRem().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getTxtNombreTerceroRem().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getLblApellidoTerceroRem().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroRem().setVisible(pBooTipoBusqueda);*/
			this.castFrmConsultaGiroInternacional().getPnlRemitente().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getPnlBeneficiario().setVisible(pBooTipoBusqueda);
			this.castFrmConsultaGiroInternacional().getPnlReferencia().setVisible(!pBooTipoBusqueda);
			
			
			
		}else{
			
			/*this.castFrmConsultaGiroInternacional().getLblReferencia().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtReferencia().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblCorresponsal().setVisible(false);
			this.castFrmConsultaGiroInternacional().getCmbCorresponsales().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblTipoDocumentoBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblDocumentoBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblEstadoRemesa().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtEstadoRemesa().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblNombreTerceroBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtNombreTerceroBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblApellidoTerceroBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroBen().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblNombreTerceroRem().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtNombreTerceroRem().setVisible(false);
			this.castFrmConsultaGiroInternacional().getLblApellidoTerceroRem().setVisible(false);
			this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroRem().setVisible(false);*/
			this.castFrmConsultaGiroInternacional().getPnlBeneficiario().setVisible(false);
			this.castFrmConsultaGiroInternacional().getPnlRemitente().setVisible(false);
			this.castFrmConsultaGiroInternacional().getPnlReferencia().setVisible(false);
			
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method	configurarFormatoIdentificacionXTipo
	 * 		  	configura los formatos de ingreso dependiendo el tipo de
     * 		   	identificacion seleccionado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	2/04/2018
	 * *********************************************************************
	 */
	private void configurarFormatoIdentificacionXTipo()throws Exception{
		
		TipoDocumentoInternacional objTipoDocumentoInternacional;
		String strFormatoIngreso;
		
		this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strFormatoIngreso = null;
		objTipoDocumentoInternacional = this.obtenerTipoIdentificacion();
		
		if(objTipoDocumentoInternacional != null){
			
			this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setEnabled(true);
			
			if(objTipoDocumentoInternacional.getId().equals(EnumParametrosApp.COD_TPDOC_INTER_CC.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CC_INTER.getValor();
				
			}else if(objTipoDocumentoInternacional.getId().equals(EnumParametrosApp.COD_TPDOC_INTER_CE.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CE_INTER.getValor();
				
			}else if(objTipoDocumentoInternacional.getId().equals(EnumParametrosApp.COD_TPDOC_INTER_TI.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_TI_INTER.getValor();
				
			}else if(objTipoDocumentoInternacional.getId().equals(EnumParametrosApp.COD_TPDOC_INTER_PA.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_PA_INTER.getValor();
				
			}else if(objTipoDocumentoInternacional.getId().equals(EnumParametrosApp.COD_TPDOC_INTER_OT.getValorPropiedad())){
				
				strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_OT_INTER.getValor();
			}
			
		}else{
			this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setEnabled(false);
		}
		
		this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
	}
	
	
	/** 
	 * ********************************************************************
	 * @method	obtenerTipoIdentificacion
	 * 		  	obtiene el tipo de identificacion seleccionado
	 * @return  TipoDocumentoInternacional
	 * 			tipo documento internacional seleccionado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	2/04/2018
	 * *********************************************************************
	 */
	public TipoDocumentoInternacional obtenerTipoIdentificacion()throws Exception{
		
		TipoDocumentoInternacional objTipoDocumentoInternacional = null;
		Object objSeleccionado;
		
		objSeleccionado = this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().getSelectedItem();
		
		if(objSeleccionado instanceof TipoDocumentoInternacional){
			objTipoDocumentoInternacional = (TipoDocumentoInternacional) objSeleccionado;
		}
		
		return objTipoDocumentoInternacional;
	}
	
	/** 
	 * ********************************************************************
	 * @method	accionConsultarGiroXReferencia
	 * 		  	metodo para consultar giro por referencia y agregar a la 
	 * 			grilla de resultados
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 * *********************************************************************
	 */
	private void accionConsultarGiroXReferencia() throws Exception{
		
		lstFacturas = new ArrayList<FacturaGiroInternacional>();
		
		Corresponsal objCorresponsal;
		TipoDocumentoInternacional objTipoDocumentoInternacional;
		
		objCorresponsal = (Corresponsal) this.castFrmConsultaGiroInternacional().getCmbCorresponsales().getSelectedItem();
		objTipoDocumentoInternacional = (TipoDocumentoInternacional) this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().getSelectedItem();
		
		lstFacturas.add(this.consultarGiroXReferencia(this.castFrmConsultaGiroInternacional().getTxtReferencia().getText(),
						this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getText(),
						objCorresponsal,
						objTipoDocumentoInternacional));
		
		this.cargarFacturas();
	}
	
	/** 
	 * ********************************************************************
	 * @method	accionConsultarGiroXBeneficiario
	 * 		  	metodo para consultar giro por beneficiario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	private void accionConsultarGiroXBeneficiario() throws Exception{
		Tercero objTeceroRem;
		Tercero objTeceroBen;
		
		objTeceroBen = new Tercero();
		objTeceroRem = new Tercero();
		TipoDocumentoInternacional objTipoDocumentoInternacional;
		
		objTipoDocumentoInternacional = (TipoDocumentoInternacional) this.castFrmConsultaGiroInternacional().getCmbTipoDocumentoBen().getSelectedItem();
		
		objTeceroBen.setTipoIdentificacion(objTipoDocumentoInternacional);
		objTeceroBen.setIdentificacion(this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getText());
		objTeceroBen.setNombres(this.castFrmConsultaGiroInternacional().getTxtNombreTerceroBen().getText());
		objTeceroBen.setApellido1(this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroBen().getText());
		
		objTeceroRem.setNombres(this.castFrmConsultaGiroInternacional().getTxtNombreTerceroRem().getText());
		objTeceroRem.setApellido1(this.castFrmConsultaGiroInternacional().getTxtApellidoTerceroRem().getText());
		
		lstFacturas = GiroInternacionalVistaLogica.getInstancia().consultarGiroXBeneficiario(this.getObjUsuario(), 
															 							     EnumPeticionesMultiservicio.GIN_CONSULTAR_GIRO_BENEFICIARIO.getObjServicioPeticion(),
															 							     objTeceroRem,
															 							     objTeceroBen);
		
		this.cargarFacturas();
		
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultarGiroXReferencia
	 * 		  	metodo para consultar giro por referencia
	 * @param 	pStrReferencia
	 * 			refrencia a consultar
	 * @param	pStrDocumento
	 * 			Documento del beneficiario
	 * @param	pObjCorresponsal
	 * 			objeto corresponsal
	 * @param	pObjTipoDocumentoInternacional
	 * 			tipo documento internacional
	 * @return 	FacturaGiroInternacional
	 * 			objeto FacturaGiroInternacional con los datos de la factura
	 * 			consultada por referencia
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	21/03/2018
	 * *********************************************************************
	 */
	private FacturaGiroInternacional consultarGiroXReferencia(String pStrReferencia,
															  String pStrDocumento,
															  Corresponsal pObjCorresponsal,
															  TipoDocumentoInternacional pObjTipoDocumentoInternacional) throws Exception{
		
		FacturaGiroInternacional objFacturaGiroInternacional;
		
		objFacturaGiroInternacional = GiroInternacionalVistaLogica.getInstancia().consultarGiroXReferencia(this.getObjUsuario(), 
																			 			   				   EnumPeticionesMultiservicio.GIN_CONSULTAR_GIRO_REFERENCIA.getObjServicioPeticion(), 
																			 			   				   pStrReferencia, 
																			 			   				   pObjCorresponsal, 
																			 			   				   pObjTipoDocumentoInternacional, 
																			 			   				   pStrDocumento);
		
		if (objFacturaGiroInternacional.getStrCodEstadoGiro().equals("2")) {
			
			super.limpiar();
			throw EnumMensajes.GIRO_INTERNACIONAL_ESTADO_PAGADO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		return objFacturaGiroInternacional;
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarFacturas
	 * 		  	metodo para cargar las facturas en de la lista en la grilla
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	29/03/2018
	 * *********************************************************************
	 */
	private void cargarFacturas() throws Exception{
		
		FacturaGiroInternacional objFacturaGiroInternacional;
		
		if(lstFacturas!=null && !lstFacturas.isEmpty()){
			
			getHmFacturas();
			
			Iterator<FacturaGiroInternacional> iter = lstFacturas.iterator();	
			
			while (iter.hasNext()) {
			
				objFacturaGiroInternacional = iter.next();
				
				if (hmFacturas.get("" + objFacturaGiroInternacional.getStrReferenciaControlExterna()) == null) {
					
					hmFacturas.put("" + objFacturaGiroInternacional.getStrReferenciaControlExterna(), objFacturaGiroInternacional);
					
					this.castFrmConsultaGiroInternacional().getTblGiros().getPropiedades().adicionarFilaGrilla(new Object[] { objFacturaGiroInternacional.getTerceroDestino().getNombres(), 
																															  objFacturaGiroInternacional.getTerceroOrigen().getNombres(),
																															  objFacturaGiroInternacional.getObjCorresponsal().getStrCodigo(),
																															  objFacturaGiroInternacional.getStrReferenciaControlExterna(),
																															  UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroInternacional.getTotal()),
																															  objFacturaGiroInternacional.getTerceroOrigen().getObjTrrCiudadResidencia().getTerritorioPadre().getTerritorioPadre().getCodigo()});
				}
			}
			
		}else{
			
			throw EnumMensajes.NO_HAY_DATOS.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
	}
	
	
	
	/** 
	 * ********************************************************************
	 * @method	getHmFacturas
	 * 		  	metodo para manejar el hashmap de facturas que arroja 
     * 		   	la consulta
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	29/03/2018
	 * *********************************************************************
	 */
	private void getHmFacturas() throws Exception{

		if (hmFacturas == null) {
			hmFacturas = new HashMap<String, FacturaGiroInternacional>(1, 1);
		} else {
			hmFacturas.clear();
		}

	}
	
	
	/** 
	 * ********************************************************************
	 * @method	seleccionarGiroGrilla
	 * 		  	metodo para obetener la refrencia del giro de la fila 
	 * 			seleccionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/03/2018
	 * *********************************************************************
	 */
	private void seleccionarGiroGrilla()throws Exception{
		
		int intFilaSeleccionada;
		int intColumnaReferencia;
		
		intColumnaReferencia = 3;
		intFilaSeleccionada = this.castFrmConsultaGiroInternacional().getTblGiros().getSelectedRow();
		
		this.setStrReferenciaSeleccionada(this.castFrmConsultaGiroInternacional().getTblGiros().getValueAt(intFilaSeleccionada, 
					 																				 	   intColumnaReferencia).toString());
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiarObjTemporales
	 * 		   	Metodo encargado de considerar labores de limpieza en los
	 * 			objetos temporales de la funcionalidad
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	12/06/2017
	 * *********************************************************************
	 */
	private	void	limpiarObjTemporales()	
			throws Exception
	{
		if(lstFacturas!=null){
			lstFacturas.clear();
		}
		if(hmFacturas!=null && !hmFacturas.isEmpty()){
			hmFacturas.clear();
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarDocumentoAlReves
	 * 		  	carga la forma FormaDatosAdicionales
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
  	 * 			boton guardar 
	 * @author	roberth.martinez
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	public void cargarDocumentoAlReves() throws Exception{
		StringBuilder strBuilder;
		String strCadenaInvertida;
		String strCadenaOriginal;
		strCadenaOriginal = this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().getText();
		this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setVisible(false);
		
		objFormaDatosAdicionales = new FormaDatosAdicionales(super.getFrmForma(), 
					 										 true, 
					 										 this.castFrmConsultaGiroInternacional().iniciarPropPnlContenedorDocAlRevesDatAdd());
		
		this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setVisible(true);
		
		if(EnumBotonesEncabezado.BTNGUARDAR.equals(objFormaDatosAdicionales.getEnmBotEncAccionSolicitada())){
			
			strBuilder = new StringBuilder(this.castFrmConsultaGiroInternacional().getTxtNumeroDocAlReves().getText());
			strCadenaInvertida = strBuilder.reverse().toString();
			
			if (!strCadenaOriginal.equals(strCadenaInvertida)) {
				this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setText("");
				this.castFrmConsultaGiroInternacional().getTxtNumeroDocAlReves().setText("");
				throw EnumMensajes.NUMEROS_DOCUMENTOS_NO_CONINCIDEN.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}
		}else{
			this.castFrmConsultaGiroInternacional().getTxtDocumentoBen().setText("");
		}
		this.castFrmConsultaGiroInternacional().getTxtNumeroDocAlReves().setText("");
	}
	
	/**
	 * @method	getObjFacturaGiroInternacional
	 * 		  	Metodo get del atributo objFacturaGiroInternacional
	 * @return	FacturaGiroInternacional
	 *		  	Valor del atributo objFacturaGiroInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	26/03/2018
	 */
	public FacturaGiroInternacional getObjFacturaGiroInternacional() {
		return objFacturaGiroInternacional;
	}

	/**
	 * @method	setObjFacturaGiroInternacional
	 * 		  	Metodo set del atributo objFacturaGiroInternacional
	 * @param	pObjFacturaGiroInternacional
	 * 			Valor que tomara el atributo objFacturaGiroInternacional
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 */
	public void setObjFacturaGiroInternacional(
			FacturaGiroInternacional pObjFacturaGiroInternacional) {
		this.objFacturaGiroInternacional = pObjFacturaGiroInternacional;
	}

	/** 
	 * ********************************************************************
	 * @method	castFrmConsultaGiroInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general 
  	 * 		    a un tipo especifico ("Casteo"), del atributo
  	 * 		   	super.getFrmForma()
	 * @return  FormaConsultaGiroInternacional
	 * 			valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de 
  	 * 		   	excepcion presentada
	 * @author	roberth.martinez
	 * @date	20/03/2018
	 * *********************************************************************
	 */
	public FormaConsultaGiroInternacional castFrmConsultaGiroInternacional()throws Exception{
		return (FormaConsultaGiroInternacional)super.getFrmForma(); 
	}

	/**
	 * @method	getStrReferenciaSeleccionada
	 * 		  	Metodo get del atributo strReferenciaSeleccionada
	 * @return	String
	 *		  	Valor del atributo strReferenciaSeleccionada devuelto
	 * @author	user
	 * @date  	30/03/2018
	 */
	public String getStrReferenciaSeleccionada() {
		return strReferenciaSeleccionada;
	}

	/**
	 * @method	setStrReferenciaSeleccionada
	 * 		  	Metodo set del atributo strReferenciaSeleccionada
	 * @param	pStrReferenciaSeleccionada
	 * 			Valor que tomara el atributo strReferenciaSeleccionada
	 * @author	user
	 * @date	30/03/2018
	 */
	public void setStrReferenciaSeleccionada(String pStrReferenciaSeleccionada) {
		strReferenciaSeleccionada = pStrReferenciaSeleccionada;
	}

}
