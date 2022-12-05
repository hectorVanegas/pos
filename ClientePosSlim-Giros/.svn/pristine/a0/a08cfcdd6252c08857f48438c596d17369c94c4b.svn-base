package co.com.codesa.clienteposslimgiros.eventos.generico.promocion;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.util.HashMap;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelPropiedadesPeps;
import co.com.codesa.clienteposslimgiros.interfaces.promocion.IOperacionesPropiedades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;

/**
 * 
 * ********************************************************************
 * @class	EventoFormaPanelPropiedadesPeps
 *		 	Evento Panel encargado de pintar la tabla de propiedades de PEPS
 * @author	stiven.garcia
 * @date  	2/05/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelPropiedadesPeps extends EventoAbstracto implements IOperacionesPropiedades {
	
	/**
	 * @variable 	frmScpPropiedadesPeps
	 * 			 	forma panel propiedades peps
	 */
	private FormaPanelPropiedadesPeps frmScpPropiedadesPeps;
	
	/**
	 * @variable 	hmPropiedades
	 * 			 	Listado de promociones propuestas para ofrecer
	 */
	private HashMap<String,Propiedad> hmPropiedades;
	
	/**
	 * @variable 	hmEditorCeldaPropiedades
	 * 			 	Listado de los componentes de edicion configurados y exclusivos 
	 * 				para cada propiedad, indexado por el codigo de estas
	 */
	private HashMap<String,EditorCeldaGrilla>	hmEditorCeldaPropiedades;
	
	/**
	 * @variable 	strIdPropiedadSeleccionada
	 * 			 	atributo que contendrá el id de la propiedad seleccionada por el usuario.
	 */
	private String strIdPropiedadSeleccionada;
	
	/**
	 * @variable 	booActivaCambioItem
	 * 			 	Listado de promociones propuestas para ofrecer
	 */
	private boolean booActivaCambioItem;
	
	/**
	 * 
	 * ********************************************************************
	 * @method	EventoFormaPanelPropiedadesPeps
	 * 		  	Evento de la forma panel de las propiedades peps
	 * @param pFrmScpPropiedadesPeps
	 * 			Forma panel propiedades peps
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public EventoFormaPanelPropiedadesPeps(FormaPanelPropiedadesPeps pFrmScpPropiedadesPeps) throws Exception
	{
		super(pFrmScpPropiedadesPeps.getFrmGnrPadre());
		this.setFrmScpPropiedadesPeps(pFrmScpPropiedadesPeps);
		
	}
	
	
	@Override
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel,
									   ListSelectionEvent pEvtValueChanged) throws Exception {
		
		
		if(pObjLisSelectionModel.equals(this.getFrmScpPropiedadesPeps().getTblPropiedadesPeps().getSelectionModel())){
		
			this.seleccionarRegistroGrillaPropiedades();
			this.evaluarRespuestasAfirmativas();

			
		}else {
			super.accionarCambioRegistro(pObjLisSelectionModel, 
					 					 pEvtValueChanged);				
		}
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
			   					   ItemEvent pEvtItemStateChanged)throws Exception{
		
		if(pComponent instanceof CajaComboUtil) {
			CajaComboUtil cmbCajaComboRespuesta = (CajaComboUtil) pComponent;
			if ( !cmbCajaComboRespuesta.getSelectedItem().toString().equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.getValor(false)) ) {
				this.evaluarRespuestasAfirmativas();				
			}
			cmbCajaComboRespuesta.setFocusable(false);
		}else{
			
			super.accionarCambioItem(pComponent,
									 pEvtItemStateChanged);
		}	
		
	}
	
	@Override
	public void adicionarPropiedades(	HashMap<String,Propiedad> pHmPropiedades	)	throws	Exception
	{
		this.limpiarPropiedades();
		
		this.setHmPropiedades(pHmPropiedades);
		
		for	(	Propiedad objPropiedad	:	pHmPropiedades.values()	) 
		{
			this.getFrmScpPropiedadesPeps().getTblPropiedadesPeps().getPropiedades().adicionarFilaGrilla	(	new Object[]{	objPropiedad.getStrCodigo(),
																																objPropiedad.getStrEtiqueta(),
																																objPropiedad.getBooObligatorio(),
																																objPropiedad.getStrEjemplo(),
																															  	this.obtenerComboRespuestas(objPropiedad)
				  																								}
																								);
		}
		this.booActivaCambioItem = true;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	evaluarRespuestasAfirmativas
	 * 		  	Metodo encargado de evaluar que si encuentre seleccionada 
	 * 			una unica propiedad del listado de propiedades PEPS
	 * @return
	 * 			Bandera indicando si se encuentra seleccionada una unica propiedad
	 * 			o retornará false si se encuentra seleciconada como Si mas de una 
	 * 			propiedad del listado
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	4/05/2018
	 * *********************************************************************
	 */
	private boolean evaluarRespuestasAfirmativas() throws Exception {
		
		GrillaUtil tblPromociones;
		Object objValorDatoXPromocion;
		int intPosicionColumnaDato;
		int intPosicionColumnaId;
		int intContadorRespuestas = 0;
		boolean booResultadoValidacion = false;
		String strCodigoPropiedadSeleccionada = "";

		tblPromociones	=	this.getFrmScpPropiedadesPeps().getTblPropiedadesPeps();
		
		intPosicionColumnaDato = tblPromociones.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE.toString());
		intPosicionColumnaId   = tblPromociones.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO.toString());

		if ( booActivaCambioItem ) {		
		
			for(int i=0; i<tblPromociones.getRowCount(); i++){
	
				objValorDatoXPromocion = tblPromociones.getValueAt(i, intPosicionColumnaDato);
	
				if(	objValorDatoXPromocion != null && !objValorDatoXPromocion.toString().equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.toString()) ){
					intContadorRespuestas += 1;		
					strCodigoPropiedadSeleccionada = (String)(tblPromociones.getValueAt(i, intPosicionColumnaId));
				}
			}
			
					
			if ( intContadorRespuestas == 1 ) {
				booResultadoValidacion = true;
				
				for	(	Propiedad objPropiedad	:	this.hmPropiedades.values()	) {				
					if ( !objPropiedad.getStrCodigo().equalsIgnoreCase(strCodigoPropiedadSeleccionada) ) {
						//this.getHmEditorCeldaPropiedades().get(objPropiedad.getStrCodigo()).getComponent().setEnabled(false);			
					}
				}
				
			}else {
				for	(	Propiedad objPropiedad	:	this.hmPropiedades.values()	) {				
						CajaComboUtil cmbCajaComboUtil = (CajaComboUtil)(this.getHmEditorCeldaPropiedades().get(objPropiedad.getStrCodigo()).getComponent());
						if ( cmbCajaComboUtil != null ) {
							cmbCajaComboUtil.setEnabled(true);
						}
				}
			}
		}
		
		return booResultadoValidacion;		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	obtenerPropiedadSeleccionada
	 * 		  	Metodo encargado de obtener la propiedad que fue seleccionada
	 * 			como afirmativa en el proceso de PEPS
	 * @return
	 * 			Objeto propiedad que contiene la respuesta afirmativa
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	4/05/2018
	 * *********************************************************************
	 */
public Propiedad obtenerPropiedadSeleccionada() throws Exception {
		
		EditorCeldaGrilla ecgCeldaTabla;	
		Propiedad objPropiedadSeleciconada = null;
		GrillaUtil tblPropiedades;
		Object objValorDatoXPromocion;
		int intPosicionColumnaDato;
		int intPosicionColumnaId;
		String strCodigoPropiedadSeleccionada = "";
		
		if ( this.evaluarRespuestasAfirmativas() ) {	
		
			tblPropiedades	=	this.getFrmScpPropiedadesPeps().getTblPropiedadesPeps();
			
			intPosicionColumnaDato = tblPropiedades.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE.toString());
			intPosicionColumnaId   = tblPropiedades.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO.toString());
			
			for(int i=0; i<tblPropiedades.getRowCount(); i++){
				objValorDatoXPromocion = tblPropiedades.getValueAt(i, intPosicionColumnaDato);
				if(	objValorDatoXPromocion != null && !objValorDatoXPromocion.toString().equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.toString()) ){
					strCodigoPropiedadSeleccionada = (String)(tblPropiedades.getValueAt(i, intPosicionColumnaId));
					objPropiedadSeleciconada = this.hmPropiedades.get(strCodigoPropiedadSeleccionada);
				}
			}
			/*for	(	Propiedad objPropiedad	:	this.hmPropiedades.values()	) {
				ecgCeldaTabla = this.getHmEditorCeldaPropiedades().get(objPropiedad.getStrCodigo());
				String strValueComponent = ((CajaComboUtil)ecgCeldaTabla.getComponent()).getSelectedItem().toString();
				if ( !strValueComponent.equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.toString()) ) {
					objPropiedadSeleciconada = objPropiedad;				
				}
			}*/
		} else {
			throw EnumMensajes.SELECCIONE_UNA_RESPUESTA_PEPS.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		return objPropiedadSeleciconada;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	obtenerComboRespuestas
	 * 		  	Metodo encargado de generar las posibles respuestas de las propiedades Peps
	 * @param pObjPropiedad
	 * 			Objeto propiedad que se desea listar en la forma
	 * @return
	 * 			Las opciones representadas en el componente CajaComboUtil
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	28/04/2018
	 * *********************************************************************
	 */
	private Object obtenerComboRespuestas( Propiedad pObjPropiedad ) throws Exception{
		
		CajaComboUtil 		cmbRespuestas;
		EditorCeldaGrilla	ecgEditorCelda;
		
		if	(	this.getHmEditorCeldaPropiedades().containsValue(pObjPropiedad.getStrCodigo())) {
			cmbRespuestas = (CajaComboUtil)this.getHmEditorCeldaPropiedades().get(pObjPropiedad.getStrCodigo()).getComponent();
		} else {
			cmbRespuestas 	= this.getFrmScpPropiedadesPeps().iniciarPropCmbRespuestaPropiedad();
			ecgEditorCelda 	= new EditorCeldaGrilla( cmbRespuestas, super.getFrmForma());
			
			this.getHmEditorCeldaPropiedades().put(pObjPropiedad.getStrCodigo(), ecgEditorCelda);
		}
		
		String [] arrStrRespuesta = pObjPropiedad.getStrNumeroLineaImpresion().split("\\"+EnumGeneralidadesTramasGiros.ASTERISCO.getValor());
		
		cmbRespuestas.getPropiedades().cargarCombo(arrStrRespuesta, true, EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		return cmbRespuestas.getSelectedItem();
	}
	
	/**
	 * ********************************************************************
	 * @method 	seleccionarRegistroGrillaPromociones
	 * 		   	Metodo que permite realizar las acciones pertinentes cuando
	 * 			se selecciona un registro de la grilla de promociones, ideal
	 * 			para re-definir el componente de edicion que se utilizara para
	 * 			diligenciar el dato de la promocion seleccionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	private	void	seleccionarRegistroGrillaPropiedades()	throws 	Exception {
		
		GrillaUtil tblPropiedades;
		TableColumn objColumnaId;
		TableColumn objColumnaDato;
		String strIdPropiedad;
		int intFilaSeleccionada;
		EditorCeldaGrilla ecgCeldaTabla;
		
		tblPropiedades = this.getFrmScpPropiedadesPeps().getTblPropiedadesPeps();
		objColumnaId = tblPropiedades.getColumn(EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO.toString());
		objColumnaDato = tblPropiedades.getColumn(EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE.toString());
		intFilaSeleccionada = tblPropiedades.getSelectedRow();
		
		strIdPropiedad	=	(String)tblPropiedades.getValueAt	(	intFilaSeleccionada, 
												 					objColumnaId.getModelIndex()
												 				);
		
		strIdPropiedadSeleccionada = strIdPropiedad;
		ecgCeldaTabla = this.getHmEditorCeldaPropiedades().get(strIdPropiedad);
		objColumnaDato.setCellEditor(ecgCeldaTabla);
		
	}

	@Override
	public void	limpiarPropiedades() throws	Exception {
		this.getFrmScpPropiedadesPeps().getTblPropiedadesPeps().getPropiedades().limpiarGrilla();
		this.getHmEditorCeldaPropiedades().clear();
		this.setHmPropiedades(null);
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getFrmScpPropiedadesPeps
	 * 		  	Metodo get para el atributo forma propiedades peps
	 * @return
	 * 			Forma Propiedades peps
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public FormaPanelPropiedadesPeps getFrmScpPropiedadesPeps() {
		return frmScpPropiedadesPeps;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	setFrmScpPropiedadesPeps
	 * 		  	Metodo set de la forma propiedades peps
	 * @param frmScpPropiedadesPeps
	 * 			Forma Propiedades peps
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public void setFrmScpPropiedadesPeps(FormaPanelPropiedadesPeps frmScpPropiedadesPeps) {
		this.frmScpPropiedadesPeps = frmScpPropiedadesPeps;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getHmPropiedades
	 * 		  	Metodo get de hashMap de propiedades
	 * @return	
	 * 			HashMap propiedades peps 
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public HashMap<String, Propiedad> getHmPropiedades() {
		return hmPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	setHmPropiedades
	 * 		  	Metodo set de hashMap de propiedades 
	 * @param hmPropiedades
	 * 			HashMap propiedades peps
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public void setHmPropiedades(HashMap<String, Propiedad> hmPropiedades) {
		this.hmPropiedades = hmPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getHmEditorCeldaPropiedades
	 * 		  	Metodo get del hashMap editor de la celda propiedades
	 * @return
	 * 			HashMap Editor de celda grilla
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public HashMap<String, EditorCeldaGrilla> getHmEditorCeldaPropiedades() {
		if	(	this.hmEditorCeldaPropiedades	==	null) {
			this.hmEditorCeldaPropiedades	=	new HashMap<String, EditorCeldaGrilla>();
		}
		return hmEditorCeldaPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	setHmEditorCeldaPropiedades
	 * 		  	Metodo set de hashmap celda editor
	 * @param hmEditorCeldaPropiedades
	 * 			HashMap Editor de celda grilla
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public void setHmEditorCeldaPropiedades(HashMap<String, EditorCeldaGrilla> hmEditorCeldaPropiedades) {
		this.hmEditorCeldaPropiedades = hmEditorCeldaPropiedades;
	}

}
