package co.com.codesa.clienteposslimgiros.eventos.terceros;

import java.util.ArrayList;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaPropiedadesPepsInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ParentescoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;

/** 
 * ********************************************************************
 * @class	EventoFormaPagoGiroInternacional
 *		 	Clase encargada de controlar los eventos de la forma de
 * 		  	protegiro en el pago de giro internacional
 * @author	roberth.martinez
 * @date  	22/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPropiedadesPepsInternacional extends EventoAbstracto{
	
	/**
	 * @variable	objTercero
	 * 				objeto tercero de la transaccion
	 */
	private TerceroInternacional objTercero;
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaPagoGiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		  	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @param 	pObjTercero
	 * 			objeto Tercero del cual se esta llevando a cabo la 
  	 * 		  	transaccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	public EventoFormaPropiedadesPepsInternacional(FormaGenerica pForma,
									   	     	   TerceroInternacional pObjTercero) throws Exception{
		super(pForma);
		this.setObjTercero(pObjTercero);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.configuracionCamposTexto();
		this.llenarInformacionFormulario();
	}
	
	@Override
	public void confirmar() throws Exception {
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		if (objTercero != null) {
			this.setearInfoPEPS(objTercero);
		}
		
		super.regresarFormaPadre();
		
	}
	
	@Override
	public void cancelar() throws Exception {
		
		super.regresarFormaPadre();
	}
	
	@Override
	public void accionarVentanaDesplegada(java.awt.event.WindowEvent pEvtWindowOpened) throws Exception {
		this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().getLblObligatorio().aplicarObligatoriedad(true);
		
		this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarCambioItem(java.awt.Component pComponent, java.awt.event.ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castfrmPropiedadesPepsInternacional().getChkConyuge())){
			
			if (!this.castfrmPropiedadesPepsInternacional().getChkConyuge().isSelected()) {
				this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().setText("");
			}
			this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().setEditable(this.castfrmPropiedadesPepsInternacional().getChkConyuge().isSelected());
			
		}else if(pComponent.equals(this.castfrmPropiedadesPepsInternacional().getChkFamiliarConsanguinidad())){
			
			if (!this.castfrmPropiedadesPepsInternacional().getChkFamiliarConsanguinidad().isSelected()) {
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().setText("");
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().setSelectedIndex(0);
			}
			this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().setEditable(this.castfrmPropiedadesPepsInternacional().getChkFamiliarConsanguinidad().isSelected());
			this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().setEnabled(this.castfrmPropiedadesPepsInternacional().getChkFamiliarConsanguinidad().isSelected());
			
		}else if(pComponent.equals(this.castfrmPropiedadesPepsInternacional().getChkFamiliarAfinidad())){
			
			if (!this.castfrmPropiedadesPepsInternacional().getChkFamiliarAfinidad().isSelected()) {
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().setText("");
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().setSelectedIndex(0);
			}
			this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().setEditable(this.castfrmPropiedadesPepsInternacional().getChkFamiliarAfinidad().isSelected());
			this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().setEnabled(this.castfrmPropiedadesPepsInternacional().getChkFamiliarAfinidad().isSelected());
			
		}else if(pComponent.equals(this.castfrmPropiedadesPepsInternacional().getChkFamiliarCivil())){
			
			if (!this.castfrmPropiedadesPepsInternacional().getChkFamiliarCivil().isSelected()) {
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().setText("");
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().setSelectedIndex(0);
			}
			this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().setEditable(this.castfrmPropiedadesPepsInternacional().getChkFamiliarCivil().isSelected());
			this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().setEnabled(this.castfrmPropiedadesPepsInternacional().getChkFamiliarCivil().isSelected());
			
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	configuracionCamposTexto
	 * 		  	encargado de gestionar la configuracion personalizada
  	 * 		   	para los diferentes campos de texto del formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	23/04/2018
	 * *********************************************************************
	 */
	private void configuracionCamposTexto() throws Exception{
		
		this.cargarCmbParentescoFamiliarConsanguinidad();
		this.cargarCmbParentescoFamiliarAfinidad();
		this.cargarCmbParentescoFamiliarCivil();
		
		this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
		this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
		this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
		this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
	}
	
	/** 
	 * ********************************************************************
	 * @method	llenarInformacionFormulario
	 * 		  	metodo para llenar los datos de la forma Protegiro en el
	 * 		    pago internacional
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	private void llenarInformacionFormulario()throws Exception{
		
		if(this.getObjTercero() != null){
			
			ParentescoInternacional objParentescoInternacional;
			if (this.getObjTercero().isBooConyugePEPs()) {
				this.castfrmPropiedadesPepsInternacional().getChkConyuge().setSelected(true);
				this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().setText(objTercero.getStrNombreCompletoConyugePEPs());
				this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().setEditable(true);
			}
			
			if (this.getObjTercero().isBooFamiliarConsanguinidad()) {
				
				this.castfrmPropiedadesPepsInternacional().getChkFamiliarConsanguinidad().setSelected(true);
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().setText(objTercero.getStrNombreFamiliarConsaguinidad());
				
				objParentescoInternacional = new ParentescoInternacional();
				objParentescoInternacional.setStrCodigo(objTercero.getStrParentescoFamiliarConsaguinidad());
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().setSelectedItem(objParentescoInternacional);
			
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().setEditable(true);
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().setEnabled(true);
			}
			
			if (this.getObjTercero().isBooFamiliarAfinidad()) {
				
				this.castfrmPropiedadesPepsInternacional().getChkFamiliarAfinidad().setSelected(true);
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().setText(objTercero.getStrNombreFamiliarAfinidad());
				
				objParentescoInternacional = new ParentescoInternacional();
				objParentescoInternacional.setStrCodigo(objTercero.getStrParentescoFamiliarAfinidad());
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().setSelectedItem(objParentescoInternacional);
			
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().setEditable(true);
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().setEnabled(true);
			}
			
			if (this.getObjTercero().isBooFamiliarCivil()) {
				
				this.castfrmPropiedadesPepsInternacional().getChkFamiliarCivil().setSelected(true);
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().setText(objTercero.getStrNombreFamiliarCivil());
				
				objParentescoInternacional = new ParentescoInternacional();
				objParentescoInternacional.setStrCodigo(objTercero.getStrParentescoFamiliarCivil());
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().setSelectedItem(objParentescoInternacional);
			
				this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().setEditable(true);
				this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().setEnabled(true);
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbParentescoFamiliarConsanguinidad
	 * 		  	metodo para cargar el Parentesco Familiar Consanguinidad
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	11/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbParentescoFamiliarConsanguinidad() throws Exception{
		
		List<ParentescoInternacional> lstParentescoInternacional = new ArrayList<>();
		
		this.adicionaParentescoLista(lstParentescoInternacional, "01", EnumEtiquetas.LBL_PPI_PARENTESCO_PADRE);
		this.adicionaParentescoLista(lstParentescoInternacional, "02", EnumEtiquetas.LBL_PPI_PARENTESCO_MADRE);
		this.adicionaParentescoLista(lstParentescoInternacional, "07", EnumEtiquetas.LBL_PPI_PARENTESCO_ABUELO);
		this.adicionaParentescoLista(lstParentescoInternacional, "08", EnumEtiquetas.LBL_PPI_PARENTESCO_NIETO);
		this.adicionaParentescoLista(lstParentescoInternacional, "09", EnumEtiquetas.LBL_PPI_PARENTESCO_HERMANO);
		this.adicionaParentescoLista(lstParentescoInternacional, "11", EnumEtiquetas.LBL_PPI_PARENTESCO_BISABUELO);
		this.adicionaParentescoLista(lstParentescoInternacional, "12", EnumEtiquetas.LBL_PPI_PARENTESCO_TIO);
		this.adicionaParentescoLista(lstParentescoInternacional, "13", EnumEtiquetas.LBL_PPI_PARENTESCO_SOBRINO);
		this.adicionaParentescoLista(lstParentescoInternacional, "15", EnumEtiquetas.LBL_PPI_PARENTESCO_PRIMO);
		this.adicionaParentescoLista(lstParentescoInternacional, "15", EnumEtiquetas.LBL_PPI_PARENTESCO_TIO_ABUELO);
		this.adicionaParentescoLista(lstParentescoInternacional, "16", EnumEtiquetas.LBL_PPI_PARENTESCO_HIJO);

		this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().getPropiedades().cargarCombo(lstParentescoInternacional.toArray(), 
			   		  																	   								 true, 
			   		  																	   								 null);
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbParentescoFamiliarAfinidad
	 * 		  	metodo para cargar el Parentesco Familiar Afinidad
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	11/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbParentescoFamiliarAfinidad() throws Exception{
		
		List<ParentescoInternacional> lstParentescoInternacional = new ArrayList<>();
		
		this.adicionaParentescoLista(lstParentescoInternacional, "04", EnumEtiquetas.LBL_PPI_PARENTESCO_YERNO);
		this.adicionaParentescoLista(lstParentescoInternacional, "05", EnumEtiquetas.LBL_PPI_PARENTESCO_NUERA);
		this.adicionaParentescoLista(lstParentescoInternacional, "06", EnumEtiquetas.LBL_PPI_PARENTESCO_SUEGRO);
		this.adicionaParentescoLista(lstParentescoInternacional, "10", EnumEtiquetas.LBL_PPI_PARENTESCO_HERMANO_CONYUGE);
		this.adicionaParentescoLista(lstParentescoInternacional, "17", EnumEtiquetas.LBL_PPI_PARENTESCO_HIJO_ESPOSO);
		this.adicionaParentescoLista(lstParentescoInternacional, "18", EnumEtiquetas.LBL_PPI_PARENTESCO_ABUELO_CONYUGE);
		
		this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().getPropiedades().cargarCombo(lstParentescoInternacional.toArray(), 
			   		  																	   						   true, 
			   		  																	   						   null);
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbParentescoFamiliarCivil
	 * 		  	metodo para cargar el Parentesco Familiar Civil
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	11/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbParentescoFamiliarCivil() throws Exception{
		
		List<ParentescoInternacional> lstParentescoInternacional = new ArrayList<>();

		this.adicionaParentescoLista(lstParentescoInternacional, "19", EnumEtiquetas.LBL_PPI_PARENTESCO_HIJO_ADOPTIVO);
		this.adicionaParentescoLista(lstParentescoInternacional, "20", EnumEtiquetas.LBL_PPI_PARENTESCO_HIJO_ADOPTIVO_CONYUGUE);
		
		this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().getPropiedades().cargarCombo(lstParentescoInternacional.toArray(), 
			   		  																	   						true, 
			   		  																	   						null);
	}
	
	/** 
	 * ********************************************************************
	 * @method	adicionaParentescoLista
	 * 		  	crea el objeto parentesco, con el codigo y nombre, lo 
	 * 			adiciona a una lista de parentesco
	 * @param	pLstParentescoInternacional
	 * 			Lista de parentesco
	 * @param 	pStrCodigoParentesco
	 * 			codigo parentesco
	 * @param 	pEnmEtiquetaParentesco
	 * 			EnumEtiquetas con el nombre del parentesco
	 * @author	roberth.martinez
	 * @date	11/05/2018
	 * *********************************************************************
	 */
	private void adicionaParentescoLista(List<ParentescoInternacional> pLstParentescoInternacional, 
									   	 String pStrCodigoParentesco, 
									   	 EnumEtiquetas pEnmEtiquetaParentesco){

		ParentescoInternacional objParentesco;
		
		objParentesco = new ParentescoInternacional();
		objParentesco.setStrCodigo(pStrCodigoParentesco);
		objParentesco.setStrNombre(pEnmEtiquetaParentesco.toString());
		pLstParentescoInternacional.add(objParentesco);
	
	}
	
	/** 
	 * ********************************************************************
	 * @method	setearInfoPEPS
	 * 		  	setea los datos PEPS al tercero
	 * @param 	pObjTercero
	 * 			objeto tercero que se le setea los datos peps 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	15/05/2018
	 * *********************************************************************
	 */
	public void setearInfoPEPS(TerceroInternacional pObjTercero) throws Exception{
		
		if (this.castfrmPropiedadesPepsInternacional().getChkConyuge().isSelected()) {
			
			pObjTercero.setBooConyugePEPs(true);
			pObjTercero.setStrNombreCompletoConyugePEPs(this.castfrmPropiedadesPepsInternacional().getTxtNombreConyuge().getText());
			
		}else{
			
			pObjTercero.setBooConyugePEPs(false);
			pObjTercero.setStrNombreCompletoConyugePEPs("*");
			
		}
		
		if (this.castfrmPropiedadesPepsInternacional().getChkFamiliarConsanguinidad().isSelected()) {
			
			pObjTercero.setBooFamiliarConsanguinidad(true);
			pObjTercero.setStrNombreFamiliarConsaguinidad(this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarConsaguinidad().getText());
			pObjTercero.setStrParentescoFamiliarConsaguinidad(((ParentescoInternacional)this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarConsanguinidad().getSelectedItem()).getStrCodigo());
			
		}else{
			
			pObjTercero.setBooFamiliarConsanguinidad(false);
			pObjTercero.setStrNombreFamiliarConsaguinidad("*");
			pObjTercero.setStrParentescoFamiliarConsaguinidad("*");
			
		}
		
		if (this.castfrmPropiedadesPepsInternacional().getChkFamiliarAfinidad().isSelected()) {
			
			pObjTercero.setBooFamiliarAfinidad(true);
			pObjTercero.setStrNombreFamiliarAfinidad(this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarAfinidad().getText());
			pObjTercero.setStrParentescoFamiliarAfinidad(((ParentescoInternacional)this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarAfinidad().getSelectedItem()).getStrCodigo());
			
		}else{
			
			pObjTercero.setBooFamiliarAfinidad(false);
			pObjTercero.setStrNombreFamiliarAfinidad("*");
			pObjTercero.setStrParentescoFamiliarAfinidad("*");
			
		}
		
		if (this.castfrmPropiedadesPepsInternacional().getChkFamiliarCivil().isSelected()) {
			
			pObjTercero.setBooFamiliarCivil(true);
			pObjTercero.setStrNombreFamiliarCivil(this.castfrmPropiedadesPepsInternacional().getTxtNombreFamiliarCivil().getText());
			pObjTercero.setStrParentescoFamiliarCivil(((ParentescoInternacional)this.castfrmPropiedadesPepsInternacional().getCmbParentescoFamiliarCivil().getSelectedItem()).getStrCodigo());
			
		}else{
			
			pObjTercero.setBooFamiliarCivil(false);
			pObjTercero.setStrNombreFamiliarCivil("*");
			pObjTercero.setStrParentescoFamiliarCivil("*");
			
		}
	}

	/**
	 * @method	getObjTercero
	 * 		  	Metodo get del atributo objTercero
	 * @return	TerceroInternacional
	 *		  	Valor del atributo objTercero devuelto
	 * @author	roberth.martinez
	 * @date  	11/05/2018
	 */
	public TerceroInternacional getObjTercero() {
		return objTercero;
	}

	/**
	 * @method	setObjTercero
	 * 		  	Metodo set del atributo objTercero
	 * @param	pObjTercero
	 * 			Valor que tomara el atributo objTercero
	 * @author	roberth.martinez
	 * @date	11/05/2018
	 */
	public void setObjTercero(TerceroInternacional pObjTercero) {
		this.objTercero = pObjTercero;
	}

	/** 
	 * ********************************************************************
	 * @method	castFrmPropiedadesPepsInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    FormaPropiedadesPepsInternacional
	 * @return	FormaPropiedadesPepsInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	10/05/2018
	 * *********************************************************************
	 */
	public FormaPropiedadesPepsInternacional castfrmPropiedadesPepsInternacional()throws Exception{
		return (FormaPropiedadesPepsInternacional)super.getFrmForma();
	}

}
