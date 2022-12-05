package co.com.codesa.clienteposslimgiros.eventos.terceros;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.dto.capturaDocumentosInternacional.TipoImagenDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumTipoImagenes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaCapturaDocumentoInternacional;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.capturaDocumentos.CapturaDocumentosInternacionalVistaLogica;

/**
 * 
 * ********************************************************************
 * @class	EventoFormaCapturaDocumentosInternacional
 *		 	[TODO - DOC]: Descripcion de la clase, su intencion, 
 *		 	proposito y objetivo
 * @author	usuario
 * @date  	27/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaCapturaDocumentosInternacional extends EventoAbstracto {
	
	private List<TipoImagenDTO> lstTipoImagenesInternacionales;
	
	public EventoFormaCapturaDocumentosInternacional(FormaGenerica pFormaGenerica) {
		super(pFormaGenerica);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.cargarImagenes();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmCapturaDocumentoInternacional().getCmbTipoImagenDocumento().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		TipoImagenDTO objTipoImagen = null;
		
		if(pComponent.equals(this.castFrmCapturaDocumentoInternacional().getBtnCapturaImg())){
			
			String strIdTransaccion       = this.castFrmCapturaDocumentoInternacional().getStrIdTransaccion();
			String strIdentificacion      = this.castFrmCapturaDocumentoInternacional().getObjTerceroInternacional().getIdentificacion();
			Object objItemSeleccionado    = this.castFrmCapturaDocumentoInternacional().getCmbTipoImagenDocumento().getSelectedItem();
			if	(	objItemSeleccionado	instanceof TipoImagenDTO	)
			{
				objTipoImagen = (TipoImagenDTO)objItemSeleccionado;
			}else{
				throw EnumMensajes.DEBE_SELECCIONAR_TIPO_IMAGEN.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}
			String strLadoImagenDocumento = objTipoImagen.getEnmTipoImagenes().getEnumParametrosApp().getValorPropiedad();
			
			CapturaDocumentosInternacionalVistaLogica.getInstancia().gestionarCapturaFotoDocumento(	strIdTransaccion, 
																									strIdentificacion, 
																									strLadoImagenDocumento, 
																									objTipoImagen,
																									this.castFrmCapturaDocumentoInternacional(),
																									getObjUsuario());
		}else{
			
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void accionarCambioItem	(	Component pComponent, 
										ItemEvent pEvtItemStateChanged
									) 
		throws Exception 
	{
		if	(	this.castFrmCapturaDocumentoInternacional().getCmbTipoImagenDocumento().equals(pComponent)	)	
		{
			this.validarImagenSeleccionada(this.castFrmCapturaDocumentoInternacional().getCmbTipoImagenDocumento());
		}	else	{			
			super.accionarCambioItem(pComponent,pEvtItemStateChanged);
		}
	}

	@Override
	public void confirmar() throws Exception {
		
		if(!this.validarCapturaImagenesInternacional()) {
			
			EnumMensajes.TOMA_FOTO_ADVERTENCIA.desplegarMensaje(super.getFrmForma(), EnumClasesMensaje.INFORMACION);
			
		}else {
			super.regresarFormaPadre();
		}		
	}
	
	private boolean validarCapturaImagenesInternacional() throws Exception{
		
		if(	this.castFrmCapturaDocumentoInternacional().getCmbTipoImagenDocumento().getItemCount() > 1) {
			return false;
		}else {
			return true;
		}		
	}
	
	/** 
	 * ********************************************************************
	 * @method validarImagenSeleccionada
	 * 		   cambia la imagen del boton de captura, dependiendo la imagen 
	 * 		   seleccionada
	 * @param  pCmbCapturaImg
	 *         componente combo donde esta las imagenes a capturar
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   26/02/2018
	 * *********************************************************************
	 */
	private void validarImagenSeleccionada	(	CajaComboUtil pCmbCapturaImg	)
		throws Exception
	{
		Object objItemSeleccionado;
		TipoImagenDTO	objDtoTipoImagen;
		EnumImagenes enmImagenCaptura;
		
		objItemSeleccionado = pCmbCapturaImg.getSelectedItem();
		
		if	(	objItemSeleccionado	instanceof TipoImagenDTO	)
		{
			objDtoTipoImagen	=	(TipoImagenDTO)objItemSeleccionado;
			
			enmImagenCaptura	=	objDtoTipoImagen.getEnmTipoImagenes().getEnmImgImagen();
			
		}	else	{
			enmImagenCaptura	=	EnumImagenes.APP_POS_CAPTURA_IMG;
		}
		
		this.castFrmCapturaDocumentoInternacional().getBtnCapturaImg().setIcon(enmImagenCaptura.ajustarIcono(new Dimension(70, 50)));
	}
	
	@Override
	public void cancelar() throws Exception {
		super.regresarFormaPadre();
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	cargarImagenes
	 * 		  	MEtodo encargado de cargar los tipos de imagenes para captura de documento
	 * @throws Exception
	 * @author	usuario
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	private void cargarImagenes() throws Exception{
		
		if(lstTipoImagenesInternacionales == null) {
			lstTipoImagenesInternacionales = new ArrayList<TipoImagenDTO>();
			lstTipoImagenesInternacionales.add(new TipoImagenDTO("DOCUMENTO_ANVERSO", EnumTipoImagenes.IMG_ANVERSO_DOC));
			lstTipoImagenesInternacionales.add(new TipoImagenDTO("DOCUMENTO_REVERSO", EnumTipoImagenes.IMG_REVERSO_DOC));			
		}
		
		this.castFrmCapturaDocumentoInternacional().getCmbTipoImagenDocumento().getPropiedades().cargarCombo(lstTipoImagenesInternacionales.toArray(), 
																										   	 true, 
																										   	 null);
	}
	
	/** 
	 * ********************************************************************
	 * @method	castFrmCapturaDocumentoInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		   	un tipo especifico ("Casteo"), del atributo padre frmForma
	 * @return	FormaCapturaDocumentoInternacional
  	 * 		   	valor especifico recuperado
	 * @throws	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	stiven.garcia
	 * @date    27/03/2018
	 * *********************************************************************
	 */
	public FormaCapturaDocumentoInternacional castFrmCapturaDocumentoInternacional()throws Exception{
		return (FormaCapturaDocumentoInternacional)super.getFrmForma(); 
	}

	public List<TipoImagenDTO> getLstTipoImagenesInternacionales() {
		return this.lstTipoImagenesInternacionales;
	}

	public void setLstTipoImagenesInternacionales(List<TipoImagenDTO> pLstTipoImagenesInternacionales) {
		this.lstTipoImagenesInternacionales = pLstTipoImagenesInternacionales;
	}	

}
