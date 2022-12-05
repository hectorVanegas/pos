package co.com.codesa.clienteposslimgiros.eventos.gridpropiedadesconvenios;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelPropiedadesAdmisionEntregaTirilla;
import co.com.codesa.clienteposslimgiros.formas.pruebaadmisionentregatirilla.FormaPropiedadesAdmisionEntregaTirilla;
import co.com.codesa.clienteposslimgiros.interfaces.promocion.IOperacionesPropiedades;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.pruebacrcadmisionentrega.PruebaCRC;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;

/**
 * 
 * ********************************************************************
 * 
 * @class EventoFormaPanelPropiedadesTransmiteTirillas Evento Panel encargado de
 *        pintar la tabla de propiedades de transmision de tirillas
 * @author dsalazar[PlayTech]
 * @date 14-feb-2019
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 *            *********
 *            ************************************************************
 */
public class EventoFormaPanelPropiedadesTransmiteTirillas extends
		EventoAbstracto implements IOperacionesPropiedades {

	/**
	 * @variable frmScpPropiedadesPeps forma panel propiedades peps
	 */
	private FormaPanelPropiedadesAdmisionEntregaTirilla frmScpPropiedadesTransmiteTirilla;

	/**
	 * @variable hmPropiedades Listado de promociones propuestas para ofrecer
	 */
	private HashMap<String, Propiedad> hmPropiedades;

	/**
	 * @variable hmEditorCeldaPropiedades Listado de los componentes de edicion
	 *           configurados y exclusivos para cada propiedad, indexado por el
	 *           codigo de estas
	 */
	private Hashtable<String, EditorCeldaGrilla> hmEditorCeldaPropiedades;

	/**
	 * @variable strIdPropiedadSeleccionada atributo que contendrá el id de la
	 *           propiedad seleccionada por el usuario.
	 */
	private String strIdPropiedadSeleccionada;

	/**
	 * @variable booActivaCambioItem Listado de promociones propuestas para
	 *           ofrecer
	 */
	private boolean booActivaCambioItem;
	
	
	private boolean booSeleccionDiferenteFisica;

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method EventoFormaPanelPropiedadesTransmiteTirillas Evento de la forma
	 *         panel de las propiedades peps
	 * @param pFrmScpPropiedadesPeps
	 *            Forma panel propiedades peps
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 * 
	 **********************************************************************/
	public EventoFormaPanelPropiedadesTransmiteTirillas(
			FormaPanelPropiedadesAdmisionEntregaTirilla pFrmScpPropiedadesTransmiteTirillas)
			throws Exception {
		super(pFrmScpPropiedadesTransmiteTirillas.getFrmGnrPadre());
		this.setFrmScpPropiedadesPeps(pFrmScpPropiedadesTransmiteTirillas);

	}

/*	@Override
	public void accionarCambioRegistro(
			ListSelectionModel pObjLisSelectionModel,
			ListSelectionEvent pEvtValueChanged) throws Exception {

		if (pObjLisSelectionModel.equals(this
				.getFrmScpPropiedadesTransmiteTirilla()
				.getTblPropiedadesAdmiGrillaUtil().getSelectionModel())) {

			this.seleccionarRegistroGrillaPropiedades();
			// this.evaluarRespuestasAfirmativas();

		} else {
			super.accionarCambioRegistro(pObjLisSelectionModel,
					pEvtValueChanged);
		}
	}*/

	@Override
	public void accionarCambioItem(Component pComponent,
			ItemEvent pEvtItemStateChanged) throws Exception {

		if (pComponent instanceof CajaComboUtil) {
			CajaComboUtil cmbCajaComboRespuesta = (CajaComboUtil) pComponent;
			if (!cmbCajaComboRespuesta
					.getSelectedItem()
					.toString()
					.equalsIgnoreCase(
							EnumEtiquetas.LBL_NO_SELECCIONADO.getValor(false))) {
				this.evaluarRespuestasCorrectas();
			}
			cmbCajaComboRespuesta.setFocusable(false);
		} else {

			super.accionarCambioItem(pComponent, pEvtItemStateChanged);
		}

	}

	@Override
	public void adicionarPropiedades(HashMap<String, Propiedad> pHmPropiedades)
			throws Exception {
		this.limpiarPropiedades();

		this.setHmPropiedades(pHmPropiedades);
		
		EditorFila editorFila = new EditorFila(this.getFrmScpPropiedadesTransmiteTirilla()
					.getTblPropiedadesAdmiGrillaUtil());
		  
		 
		int con = 0;    
		    
		for (Propiedad objPropiedad : pHmPropiedades.values()) {
			
			if (objPropiedad.getStrNumeroLineaImpresion().equals("*")) {
				this.getFrmScpPropiedadesTransmiteTirilla()
				.getTblPropiedadesAdmiGrillaUtil()
				.getPropiedades()
				.adicionarFilaGrilla(
						new Object[] {
								objPropiedad.getStrCodigo(),
								objPropiedad.getStrEtiqueta(),
								objPropiedad.getBooObligatorio(),
								objPropiedad.getStrEjemplo(),
								this.obtenerTextBoxRespuestas(objPropiedad)
								});
				editorFila.setEditorAt(con, new DefaultCellEditor((CajaTextoUtil)this.obtenerTextBoxRespuestas(objPropiedad)));
			} else {
				this.getFrmScpPropiedadesTransmiteTirilla()
						.getTblPropiedadesAdmiGrillaUtil()
						.getPropiedades()
						.adicionarFilaGrilla(
								new Object[] {
										objPropiedad.getStrCodigo(),
										objPropiedad.getStrEtiqueta(),
										objPropiedad.getBooObligatorio(),
										objPropiedad.getStrEjemplo(),
										this.obtenerComboRespuestas(objPropiedad) 
										});
				editorFila.setEditorAt(con, new DefaultCellEditor((CajaComboUtil)this.obtenerComboRespuestas(objPropiedad)));
			}
			con++;
		}
		
		this.getFrmScpPropiedadesTransmiteTirilla()
		.getTblPropiedadesAdmiGrillaUtil().getColumn(EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_DETALLE
				.toString()).setCellEditor(editorFila);
		
		
		
		
		this.booActivaCambioItem = true;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method evaluarRespuestasAfirmativas Metodo encargado de evaluar que si
	 *         encuentre seleccionada una unica propiedad del listado de
	 *         propiedades Transmision de tirillas
	 * @return Bandera indicando si se encuentra seleccionada una unica
	 *         propiedad o retornará false si se encuentra seleciconada como Si
	 *         mas de una propiedad del listado
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       **********************************************************
	 *       ***********
	 */
	private boolean evaluarRespuestasCorrectas() throws Exception {

		GrillaUtil tblPromociones;
		Object objValorDatoXPromocion;
		int intPosicionColumnaDato;
		int intPosicionColumnaId;
		int intContadorRespuestas = 0;
		boolean booResultadoValidacion = false;
		String strCodigoPropiedadSeleccionada = "";

		tblPromociones = this.getFrmScpPropiedadesTransmiteTirilla()
				.getTblPropiedadesAdmiGrillaUtil();

		intPosicionColumnaDato = tblPromociones.getColumnModel()
				.getColumnIndex(
						EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE.toString());
		intPosicionColumnaId = tblPromociones.getColumnModel().getColumnIndex(
				EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO.toString());

		if (booActivaCambioItem) {

			for (int i = 0; i < tblPromociones.getRowCount(); i++) {

				objValorDatoXPromocion = tblPromociones.getValueAt(i,
						intPosicionColumnaDato);

				if (objValorDatoXPromocion != null
						&& !objValorDatoXPromocion.toString().equalsIgnoreCase(
								EnumEtiquetas.LBL_NO_SELECCIONADO.toString())) {
					intContadorRespuestas += 1;
					strCodigoPropiedadSeleccionada = (String) (tblPromociones
							.getValueAt(i, intPosicionColumnaId));
				}
			}

			if (intContadorRespuestas > 0) {
				booResultadoValidacion = true;

				for (Propiedad objPropiedad : this.hmPropiedades.values()) {
					if (!objPropiedad.getStrCodigo().equalsIgnoreCase(
							strCodigoPropiedadSeleccionada)) {
						// this.getHmEditorCeldaPropiedades().get(objPropiedad.getStrCodigo()).getComponent().setEnabled(false);
					}
				}

			} else {
				for (Propiedad objPropiedad : this.hmPropiedades.values()) {
					CajaComboUtil cmbCajaComboUtil = (CajaComboUtil) (this
							.getHmEditorCeldaPropiedades().get(
									objPropiedad.getStrCodigo()).getComponent());
					if (cmbCajaComboUtil != null) {
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
	 * 
	 * @method obtenerPropiedadSeleccionada Metodo encargado de obtener la(s)
	 *         propiedad(es) que fue(ron) seleccionada(s) como correctas en el
	 *         proceso de prueba de admision o entrega de CRC
	 * @return Lista de Objeto propiedad que contiene(n) la(s) respuesta(s)
	 *         correcta(s)
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       **********************************************************
	 *       ***********
	 */
	public List<Propiedad> obtenerPropiedadSeleccionada() throws Exception {

		EditorCeldaGrilla ecgCeldaTabla;
		List<Propiedad> objPropiedadSeleciconada = new ArrayList<Propiedad>();
		GrillaUtil tblPropiedades;
		Object objValorDatoXPromocion;
		int intPosicionColumnaDato;
		int intPosicionColumnaId;
		String strCodigoPropiedadSeleccionada = "";
		String strValorPropiedadSeleccionada = "";

		if (this.evaluarRespuestasCorrectas()) {

			tblPropiedades = this.getFrmScpPropiedadesTransmiteTirilla()
					.getTblPropiedadesAdmiGrillaUtil();

			intPosicionColumnaDato = tblPropiedades.getColumnModel()
					.getColumnIndex(
							EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE
									.toString());
			intPosicionColumnaId = tblPropiedades
					.getColumnModel()
					.getColumnIndex(
							EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO.toString());

			for (int i = 0; i < tblPropiedades.getRowCount(); i++) {
				objValorDatoXPromocion = tblPropiedades.getValueAt(i,
						intPosicionColumnaDato);
				if (objValorDatoXPromocion != null
						&& !objValorDatoXPromocion.toString().equalsIgnoreCase(
								EnumEtiquetas.LBL_NO_SELECCIONADO.toString())) {
					strCodigoPropiedadSeleccionada = (String) (tblPropiedades
							.getValueAt(i, intPosicionColumnaId));
					strValorPropiedadSeleccionada = objValorDatoXPromocion
							.toString();
					// Agregando al listado de respuestas CRC
					// objPropiedadSeleciconada.get(i).setStrCodigo(strCodigoPropiedadSeleccionada);
					// objPropiedadSeleciconada.get(i).setStrEtiqueta(strCodigoPropiedadSeleccionada);
					// objPropiedadSeleciconada.get(i).setStrValor(strValorPropiedadSeleccionada);

					objPropiedadSeleciconada.add(i, this.hmPropiedades
							.get(strCodigoPropiedadSeleccionada));
					objPropiedadSeleciconada.add(i, this.hmPropiedades
							.get(strValorPropiedadSeleccionada));

				}
			}
			/*
			 * for ( Propiedad objPropiedad : this.hmPropiedades.values() ) {
			 * ecgCeldaTabla =
			 * this.getHmEditorCeldaPropiedades().get(objPropiedad
			 * .getStrCodigo()); String strValueComponent =
			 * ((CajaComboUtil)ecgCeldaTabla
			 * .getComponent()).getSelectedItem().toString(); if (
			 * !strValueComponent
			 * .equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.toString()) )
			 * { objPropiedadSeleciconada = objPropiedad; } }
			 */
		} else {
			throw EnumMensajes.SELECCIONE_UNA_RESPUESTA_CRC
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}

		return objPropiedadSeleciconada;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method obtenerComboRespuestas Metodo encargado de generar las posibles
	 *         respuestas de las propiedades Peps
	 * @param pObjPropiedad
	 *            Objeto propiedad que se desea listar en la forma
	 * @return Las opciones representadas en el componente CajaComboUtil
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	private Object obtenerComboRespuestas(Propiedad pObjPropiedad)
			throws Exception {

		CajaComboUtil cmbRespuestas;
		EditorCeldaGrilla ecgEditorCelda;

		if (this.getHmEditorCeldaPropiedades().containsValue(
				pObjPropiedad.getStrCodigo())) {
			cmbRespuestas = (CajaComboUtil) this.getHmEditorCeldaPropiedades()
					.get(pObjPropiedad.getStrCodigo()).getComponent();
		} else {
			cmbRespuestas = this.getFrmScpPropiedadesTransmiteTirilla()
					.iniciarPropCmbRespuestaPropiedad();
			ecgEditorCelda = new EditorCeldaGrilla(cmbRespuestas,
					super.getFrmForma());

			this.getHmEditorCeldaPropiedades().put(
					pObjPropiedad.getStrCodigo(), ecgEditorCelda);
		}

		String[] arrStrRespuesta = pObjPropiedad
				.getStrNumeroLineaImpresion()
				.split("\\" + EnumGeneralidadesTramasGiros.ASTERISCO.getValor());

		cmbRespuestas.getPropiedades().cargarCombo(arrStrRespuesta, true,
				EnumEtiquetas.LBL_NO_SELECCIONADO);

		return cmbRespuestas;
	}

	/**
	 * ********************************************************************
	 * 
	 * @method seleccionarRegistroGrillaPromociones Metodo que permite realizar
	 *         las acciones pertinentes cuando se selecciona un registro de la
	 *         grilla de promociones, ideal para re-definir el componente de
	 *         edicion que se utilizara para diligenciar el dato de la promocion
	 *         seleccionada
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       **********************************************************
	 *       ***********
	 */
	private void seleccionarRegistroGrillaPropiedades() throws Exception {

		GrillaUtil tblPropiedades;
		TableColumn objColumnaId;
		TableColumn objColumnaDato;
		String strIdPropiedad;
		int intFilaSeleccionada;
		EditorCeldaGrilla ecgCeldaTabla;

		tblPropiedades = this.getFrmScpPropiedadesTransmiteTirilla()
				.getTblPropiedadesAdmiGrillaUtil();
		objColumnaId = tblPropiedades
				.getColumn(EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_CODIGO
						.toString());
		objColumnaDato = tblPropiedades
				.getColumn(EnumEtiquetas.TTL_CRC_GRILLA_ADMENV_DETALLE
						.toString());
		intFilaSeleccionada = tblPropiedades.getSelectedRow();

		strIdPropiedad = (String) tblPropiedades.getValueAt(
				intFilaSeleccionada, objColumnaId.getModelIndex());

		strIdPropiedadSeleccionada = strIdPropiedad;
		ecgCeldaTabla = this.getHmEditorCeldaPropiedades().get(strIdPropiedad);
		
		
		    
	    objColumnaDato.setCellEditor(ecgCeldaTabla);
	}

	@Override
	public void limpiarPropiedades() throws Exception {
		this.getFrmScpPropiedadesTransmiteTirilla()
				.getTblPropiedadesAdmiGrillaUtil().getPropiedades()
				.limpiarGrilla();
		this.getHmEditorCeldaPropiedades().clear();
		this.setHmPropiedades(null);
	}
	
	
	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method obtenerTextBoxRespuestas Metodo encargado de generar las posibles
	 *         respuestas de las propiedades Peps
	 * @param pObjPropiedad
	 *            Objeto propiedad que se desea listar en la forma
	 * @return Las opciones representadas en el componente CajaComboUtil
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	private Object obtenerTextBoxRespuestas(Propiedad pObjPropiedad)
			throws Exception {

		CajaTextoUtil txtRespuestas;
		EditorCeldaGrilla ecgEditorCelda;

		if (this.getHmEditorCeldaPropiedades().containsValue(
				pObjPropiedad.getStrCodigo())) {
			txtRespuestas = (CajaTextoUtil) this.getHmEditorCeldaPropiedades()
					.get(pObjPropiedad.getStrCodigo()).getComponent();
		} else {
			EnumDimensionesComponentes pEnmDimension; 
			String pStrNombre;
			pStrNombre = "txtValor";
			pEnmDimension = EnumDimensionesComponentes.TXT_CRC_VALOR_PROPIEDAD;
			txtRespuestas = this.getFrmScpPropiedadesTransmiteTirilla()
					.iniciarPropTxtValor(pEnmDimension, pStrNombre);
					

			ecgEditorCelda = new EditorCeldaGrilla(txtRespuestas,
					super.getFrmForma());

			this.getHmEditorCeldaPropiedades().put(
					pObjPropiedad.getStrCodigo(), ecgEditorCelda);
		}

		
		return txtRespuestas;
	}
	

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getFrmScpPropiedadesPeps Metodo get para el atributo forma
	 *         propiedades peps
	 * @return Forma Propiedades peps
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public FormaPanelPropiedadesAdmisionEntregaTirilla getFrmScpPropiedadesTransmiteTirilla() {
		return frmScpPropiedadesTransmiteTirilla;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method setFrmScpPropiedadesPeps Metodo set de la forma propiedades peps
	 * @param frmScpPropiedadesPeps
	 *            Forma Propiedades peps
	 * @author stiven.garcia
	 * @date 18/05/2018
	 *       *********************************************************
	 *       ************
	 */
	public void setFrmScpPropiedadesPeps(
			FormaPanelPropiedadesAdmisionEntregaTirilla frmScpPropiedadesTransmiteTirilla) {
		this.frmScpPropiedadesTransmiteTirilla = frmScpPropiedadesTransmiteTirilla;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getHmPropiedades Metodo get de hashMap de propiedades
	 * @return HashMap propiedades peps
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public HashMap<String, Propiedad> getHmPropiedades() {
		return hmPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method setHmPropiedades Metodo set de hashMap de propiedades
	 * @param hmPropiedades
	 *            HashMap propiedades peps
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public void setHmPropiedades(HashMap<String, Propiedad> hmPropiedades) {
		this.hmPropiedades = hmPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method getHmEditorCeldaPropiedades Metodo get del hashMap editor de la
	 *         celda propiedades
	 * @return HashMap Editor de celda grilla
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public Hashtable<String, EditorCeldaGrilla> getHmEditorCeldaPropiedades() {
		if (this.hmEditorCeldaPropiedades == null) {
			this.hmEditorCeldaPropiedades = new Hashtable<String, EditorCeldaGrilla>();
		}
		return hmEditorCeldaPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method setHmEditorCeldaPropiedades Metodo set de hashmap celda editor
	 * @param hmEditorCeldaPropiedades
	 *            HashMap Editor de celda grilla
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       *********************************************************
	 *       ************
	 */
	public void setHmEditorCeldaPropiedades(
			Hashtable<String, EditorCeldaGrilla> hmEditorCeldaPropiedades) {
		this.hmEditorCeldaPropiedades = hmEditorCeldaPropiedades;
	}

	/**
	 * 
	 * ********************************************************************
	 * 
	 * @method obtenerValorSeleccionado Metodo encargado de obtener la(s)
	 *         valor(es) que fue(ron) seleccionada(s) como correctas en el
	 *         proceso de prueba de admision o entrega de CRC
	 * @return Lista de Objeto propiedad que contiene(n) la(s) respuesta(s)
	 *         correcta(s)
	 * @throws Exception
	 *             Controla, recupera y escala, cualquier tipo de excepcion
	 *             presentada
	 * @author dsalazar[PlayTech]
	 * @date 14-feb-2019
	 *       **********************************************************
	 *       ***********
	 */
	public PruebaCRC obtenerValorSeleccionado() throws Exception {

		String objPropiedadSeleccionada = "";
		Propiedad objPropiedad;
		
		
		
		
		PruebaCRC pcrcValorSeleccionado = null;

		GrillaUtil tblPropiedades;
		Object objValorDatoXPromocion;
		int intPosicionColumnaDato;
		int intPosicionColumnaId;
		int intPosicionColumnaPropiedad;
		String strCodigoPropiedadSeleccionada = "";
		String strDescripcioPropiedadSeleccionada = "";
		String strValorPropiedadSeleccionada = "";
		boolean blnSeleccionEntregaFisicaTirilla = false;
		//Capturando valor que hay en PASI en la propiedad CODCRCPR
		/*ParametroSistema psPASI;
		psPASI = UtilParametrosSistema.getInstance().consultar(
								EnumParametrosSistema.ID_PRUEBA_EN_FORMATO_FISICO);
		String strFormatoFisico = psPASI.getValor();*/
		String strFormatoFisico = ControlConsultaPasiVistaLogica.getInstance().getCodcrcpr();
		setBooSeleccionDiferenteFisica(true);

		if (this.evaluarRespuestasCorrectas()) {

			tblPropiedades = this.getFrmScpPropiedadesTransmiteTirilla()
					.getTblPropiedadesAdmiGrillaUtil();

			intPosicionColumnaDato = tblPropiedades.getColumnModel()
					.getColumnIndex(
							EnumEtiquetas.TTL_PPS_GRILLA_PEPS_DETALLE
									.toString());

			intPosicionColumnaId = tblPropiedades
					.getColumnModel()
					.getColumnIndex(
							EnumEtiquetas.TTL_PPS_GRILLA_PEPS_CODIGO.toString());

			intPosicionColumnaPropiedad = tblPropiedades.getColumnModel()
					.getColumnIndex(
							EnumEtiquetas.TTL_PPS_GRILLA_PEPS_PROPIEDAD
									.toString());

			for (int i = 0; i < tblPropiedades.getRowCount(); i++) {
				objValorDatoXPromocion = tblPropiedades.getValueAt(i,
						intPosicionColumnaDato);
				if (objValorDatoXPromocion != null
						&& !objValorDatoXPromocion.toString().equalsIgnoreCase(
								EnumEtiquetas.LBL_NO_SELECCIONADO.toString())) {
					strCodigoPropiedadSeleccionada = (String) (tblPropiedades
							.getValueAt(i, intPosicionColumnaId));

					strValorPropiedadSeleccionada = objValorDatoXPromocion
							.toString();
					
					objPropiedad = hmPropiedades.get(strCodigoPropiedadSeleccionada);
					
					if (strValorPropiedadSeleccionada!= null && !strValorPropiedadSeleccionada.isEmpty()){
						// Valide si se ha seleccionado la palabra FISICA (de un
						// listado) o el
						// Valor configurado en PASI en la propiedad CODCRCPR
						if (strValorPropiedadSeleccionada
								.equalsIgnoreCase("FISICA")
								|| strValorPropiedadSeleccionada
										.equalsIgnoreCase(strFormatoFisico)) {
							blnSeleccionEntregaFisicaTirilla = true;
							setBooSeleccionDiferenteFisica(false);
						}

						strDescripcioPropiedadSeleccionada = (String) (tblPropiedades
								.getValueAt(i, intPosicionColumnaPropiedad));
						// Agregando al listado de respuestas CRC
						objPropiedadSeleccionada = objPropiedadSeleccionada
								+ strCodigoPropiedadSeleccionada
								+ EnumGeneralidadesTramasGiros.PIPE.getValor()
								+ strDescripcioPropiedadSeleccionada
								+ EnumGeneralidadesTramasGiros.PIPE.getValor()
								+ strValorPropiedadSeleccionada
								+ EnumGeneralidadesTramasGiros.VIGURILLA
										.getValor();
					} else {
						if(objPropiedad.isBooObligatorio()){
						throw EnumMensajes.VALOR_NO_VALIDO
						.generarExcepcion(EnumClasesMensaje.ERROR);
						}
					}
				}else{
					if(objValorDatoXPromocion.toString().equalsIgnoreCase(
							EnumEtiquetas.LBL_NO_SELECCIONADO.toString())){
						throw EnumMensajes.SELECCIONE_UNA_RESPUESTA_CRC
						.generarExcepcion(EnumClasesMensaje.ERROR);
					}
				}
			}
			if (objPropiedadSeleccionada.toString() != null
					&& !objPropiedadSeleccionada.toString().isEmpty()) {
				pcrcValorSeleccionado = new PruebaCRC();
				if (blnSeleccionEntregaFisicaTirilla) {
					pcrcValorSeleccionado.setStrTipo(strFormatoFisico);
				} else {
					pcrcValorSeleccionado.setStrTipo("NO " + strFormatoFisico);
				}
				pcrcValorSeleccionado.setStrRespuesta(objPropiedadSeleccionada.toString());
				pcrcValorSeleccionado.setBlnSeleccionDiferenteFisca(!blnSeleccionEntregaFisicaTirilla);
			}
		} else {
			throw EnumMensajes.SELECCIONE_UNA_RESPUESTA_CRC
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}
          
		return pcrcValorSeleccionado ;
	}
	
	
	/**
  	 * ****************************************************************.
  	 * @method castcastfrmEnvioGiroPostal()
  	 * 		   Metodo estandar para formatear el tipo de dato general 
  	 * 		   a un tipo especifico ("Casteo"), del atributo
  	 * 		   super.getFrmForma()
  	 * @return FormaEnvioFacturacion 
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaPropiedadesAdmisionEntregaTirilla castfrmCRCAdmisionEntrega()throws Exception{
		return (FormaPropiedadesAdmisionEntregaTirilla)super.getFrmForma();
	}

	/**
	 * @return the booSeleccionDiferenteFisica
	 */
	public boolean isBooSeleccionDiferenteFisica() {
		return booSeleccionDiferenteFisica;
	}

	/**
	 * @param booSeleccionDiferenteFisica the booSeleccionDiferenteFisica to set
	 */
	public void setBooSeleccionDiferenteFisica(boolean booSeleccionDiferenteFisica) {
		this.booSeleccionDiferenteFisica = booSeleccionDiferenteFisica;
	}
	
	
	
	
	
	private class EditorFila implements TableCellEditor {
		  private Hashtable editors;

		  private TableCellEditor editor, defaultEditor;
		  private EnumDimensionesComponentes pEnmDimension; 

		  JTable table;

		  /**
		   * Constructs a EachRowEditor. create default editor
		   * 
		   * @see TableCellEditor
		   * @see DefaultCellEditor
		   */
		  public EditorFila(JTable table) throws Exception {
		    this.table = table;
		    editors = new Hashtable();
		    pEnmDimension = EnumDimensionesComponentes.TXT_CRC_VALOR_PROPIEDAD; 
		    defaultEditor =new DefaultCellEditor(frmScpPropiedadesTransmiteTirilla.iniciarPropTxtValor(pEnmDimension, "Default"));
		 //   defaultEditor = new DefaultCellEditor(new JTextField());
		  }

		  /**
		   * @param row
		   *            table row
		   * @param editor
		   *            table cell editor
		   */
		  public void setEditorAt(int row, TableCellEditor editor) {
		    editors.put(new Integer(row), editor);
		  }

		  public Component getTableCellEditorComponent(JTable table, Object value,
		      boolean isSelected, int row, int column) {
		    
			  return editor.getTableCellEditorComponent(table, value, isSelected,
		                                                row, column);
		  }

		  public Object getCellEditorValue() {
		    return editor.getCellEditorValue();
		  }

		  public boolean stopCellEditing() {
		    return editor.stopCellEditing();
		  }

		  public void cancelCellEditing() {
		    editor.cancelCellEditing();
		  }

		  public boolean isCellEditable(EventObject anEvent) {
		    selectEditor((MouseEvent) anEvent);
		    return editor.isCellEditable(anEvent);
		  }

		  public void addCellEditorListener(CellEditorListener l) {
		    editor.addCellEditorListener(l);
		  }

		  public void removeCellEditorListener(CellEditorListener l) {
		    editor.removeCellEditorListener(l);
		  }

		  public boolean shouldSelectCell(EventObject anEvent) {
		    selectEditor((MouseEvent) anEvent);
		    return editor.shouldSelectCell(anEvent);
		  }

		  protected void selectEditor(MouseEvent e) {
		    int row;
		    if (e == null) {
		      row = table.getSelectionModel().getAnchorSelectionIndex();
		    } else {
		      row = table.rowAtPoint(e.getPoint());
		    }
		    editor = (TableCellEditor) editors.get(new Integer(row));
		    if (editor == null) {
		      editor = defaultEditor;
		    }
		  }
	}
	
	
	
	
	
	

}
