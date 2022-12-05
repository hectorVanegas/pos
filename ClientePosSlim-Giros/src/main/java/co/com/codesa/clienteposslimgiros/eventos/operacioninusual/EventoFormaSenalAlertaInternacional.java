package co.com.codesa.clienteposslimgiros.eventos.operacioninusual;

import java.util.HashMap;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SenalAlertaInternacional;
/** 
 * ********************************************************************
 * @class	EventoFormaSenalAlertaInternacional
 *		 	Clase que representa los eventos de forma consulta giro
 *			internacional
 * @author	roberth.martinez
 * @date  	2/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaSenalAlertaInternacional extends EventoAbstracto {
	/**
	 * @variable 	hmEditorCeldaSenalesAlerta
	 * 			 	Listado de los componentes de edicion configurados y exclusivos 
	 * 				para cada senal alerta, indexado por el codigo de estas
	 */
	private HashMap<String,EditorCeldaGrilla>	hmEditorCeldaSenalesAlerta;
	
	/**
	 * @variable	strCadenaSenalesAlerta
	 * 				variable para manejar la cadena de senales alerta diligenciadas
	 */
	private String strCadenaSenalesAlerta;

	/**
	 * ********************************************************************
	 * @method	EventoFormaSenalAlertaInternacional
	 * 		  	Constructor de la clase EventoFormaConsultaGiroInternacional
	 * @param   pForma
	 * 			Forma desde la cual se invoca el evento
	 * @param   pHmEditorCeldaSenalesAlerta
	 * 			Listado de los componentes de edicion configurados y exclusivos 
	 * 			para cada senal alerta, indexado por el codigo de estas
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	2/04/2018
	 * *********************************************************************
	 */
	public EventoFormaSenalAlertaInternacional(FormaGenerica pForma,
											   HashMap<String,EditorCeldaGrilla>	pHmEditorCeldaSenalesAlerta) throws Exception{
		
		super(pForma);
		
		this.setHmEditorCeldaSenalesAlerta(pHmEditorCeldaSenalesAlerta);
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
	
		this.adicionarSenalesAlerta();
	}

	@Override
	public void accionarCambioRegistro	(	ListSelectionModel pObjLisSelectionModel,
									   		ListSelectionEvent pEvtValueChanged
									   	) 
		throws Exception 
	{
		if(pObjLisSelectionModel.equals(this.castFrmSenalAlerta().getTblSenalesAlerta().getSelectionModel())){
			
			this.seleccionarRegistroAlertas();
			
		}else {
			super.accionarCambioRegistro(pObjLisSelectionModel, 
					 					 pEvtValueChanged);				
		}
	}
	
	@Override
	public void confirmar() throws Exception {		
		
		this.validarSenalesAlertaDiligenciadas();
		super.regresarFormaPadre();
	}
	
	@Override
	public void cancelar() throws Exception {
		
		super.regresarFormaPadre();
	}
	
	/**
	 * ********************************************************************
	 * @method 	seleccionarRegistroAlertas
	 * 		   	Metodo que permite realizar las acciones pertinentes cuando
	 * 			se selecciona un registro de la grilla de alertas, ideal
	 * 			para re-definir el componente de edicion que se utilizara para
	 * 			diligenciar el dato editable
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	private void seleccionarRegistroAlertas()
		throws Exception 
	{
		GrillaUtil tblAlertas;
		TableColumn objColumnaId;
		TableColumn objColumnaDato;
		String strIdPropiedad;
		int intFilaSeleccionada;
		EditorCeldaGrilla ecgCeldaTabla;
		
		tblAlertas = this.castFrmSenalAlerta().getTblSenalesAlerta();
		objColumnaId = tblAlertas.getColumn(EnumEtiquetas.TTL_GSA_GRILLA_CODIGO.toString());
		objColumnaDato = tblAlertas.getColumn(EnumEtiquetas.TTL_GSA_GRILLA_COMENTARIO.toString());
		intFilaSeleccionada = tblAlertas.getSelectedRow();
		
		strIdPropiedad	=	(String)tblAlertas.getValueAt	(	intFilaSeleccionada, 
											 					objColumnaId.getModelIndex()
											 				);
		
		ecgCeldaTabla = this.getHmEditorCeldaSenalesAlerta().get(strIdPropiedad);
		objColumnaDato.setCellEditor(ecgCeldaTabla);
	}
	
	/** 
	 * ********************************************************************
	 * @method	adicionarPromociones
	 * 		  	metodo para agregar las senales alerta a la grilla
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	3/04/2018
	 * *********************************************************************
	 */
	public void adicionarSenalesAlerta()	throws	Exception
	{
		List<SenalAlertaInternacional> lstSenalesAlerta;
		
		lstSenalesAlerta = InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstSenalesAlertaInternacional();
		
		for (SenalAlertaInternacional objSenalAlertaInternacional : lstSenalesAlerta) {
			this.castFrmSenalAlerta().getTblSenalesAlerta().getPropiedades().adicionarFilaGrilla(new Object[]{	objSenalAlertaInternacional.getStrCodigo(),
																												objSenalAlertaInternacional.getStrNombre(),
																												this.obtenerCampoTextoSenalAlerta(objSenalAlertaInternacional)});
		}
	}
	
	/**
	 * ********************************************************************
	 * @method 	obtenerCampoTextoSenalAlerta
	 * 		   	Metodo que permite obtener el campo de texto configurado para
	 * 			diligenciar el dato de la promocion
	 * @param 	pObjSenalAlerta
	 * 			Objeto que relaciona la informacion especifica de una senal alerta,
	 * 			requerido para la configuracion del campo de texto 
	 * @return	CajaTextoUtil
	 * 			Campo de texto configurado para el ingreso del dato de la 
	 * 			senal alerta
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	roberth.martinez
	 * @date   	03/04/2018
	 * *********************************************************************
	 */
	private	String obtenerCampoTextoSenalAlerta(SenalAlertaInternacional pObjSenalAlerta) throws Exception{
		CajaTextoUtil txtSenalAlerta;
		EditorCeldaGrilla	ecgEditorCelda;
		
		//String strFormato;
		//String strFormatoIngreso;
		//String strFormatoSalida;
		
		if	(	(ecgEditorCelda = this.getHmEditorCeldaSenalesAlerta().get(pObjSenalAlerta.getStrCodigo())) == null	)
		{
			txtSenalAlerta	=	this.castFrmSenalAlerta().iniciarPropTxtSenalAlerta();
			ecgEditorCelda		=	new EditorCeldaGrilla	(	txtSenalAlerta,
					 											super.getFrmForma()
					 										);
			//txtSenalAlerta.setText("qqqq");
			this.getHmEditorCeldaSenalesAlerta().put(pObjSenalAlerta.getStrCodigo(), ecgEditorCelda);
			
		}	else	{
			
			txtSenalAlerta	=	(CajaTextoUtil)ecgEditorCelda.getComponent();
		}
		
		//txtSenalAlerta.setText("");
		
		return txtSenalAlerta.getText();
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarSenalesAlertaDiligenciadas
	 * 		  	metodo para recorrer la grillla de senales alerta, y armar 
	 * 			la trama de envio con la senal y el comentario, valida que 
	 * 			se realicen senales alerta y el maximo de alertas permitidas
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	3/04/2018
	 * *********************************************************************
	 */
	public void	validarSenalesAlertaDiligenciadas() throws Exception
	{
		GrillaUtil tblSenalesAlerta;
		Object objValorComentario;
		String strValorCodSenalAlerta;
		int intPosicionColumnaComentario;
		int intPosicionColumnaCod;
		int senalesAlertaDiligenciadas = 0;
		int senalesAlertaNulas = 0;

		tblSenalesAlerta	=	this.castFrmSenalAlerta().getTblSenalesAlerta();
		
		strCadenaSenalesAlerta = "";
		
		intPosicionColumnaComentario = tblSenalesAlerta.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_GSA_GRILLA_COMENTARIO.toString());
		intPosicionColumnaCod = tblSenalesAlerta.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_GSA_GRILLA_CODIGO.toString());

		for(int i=0; i<tblSenalesAlerta.getRowCount();i++){

			objValorComentario = tblSenalesAlerta.getValueAt(i, intPosicionColumnaComentario);
			strValorCodSenalAlerta = tblSenalesAlerta.getValueAt(i, intPosicionColumnaCod).toString();

			if(objValorComentario == null ||
					objValorComentario.toString().trim().isEmpty()){

				senalesAlertaNulas++;
				
			}	else	{
				
				strCadenaSenalesAlerta += strValorCodSenalAlerta + "~" + objValorComentario.toString().trim() + "?";
				senalesAlertaDiligenciadas++;
			}
			
			((CajaTextoUtil) this.getHmEditorCeldaSenalesAlerta().get(strValorCodSenalAlerta).getComponent()).setText(objValorComentario.toString());
		}
		
		if (tblSenalesAlerta.getRowCount() == senalesAlertaNulas) {
			
			throw EnumMensajes.SENALES_ALERTA_NULA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
		
		if (senalesAlertaDiligenciadas > 8) {
			
			throw EnumMensajes.SENALES_ALERTA_MAX_8.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
		
		strCadenaSenalesAlerta = strCadenaSenalesAlerta.substring(0, strCadenaSenalesAlerta.length()-1);
	}	
	
	/**
	 * @method	getStrCadenaSenalesAlerta
	 * 		  	Metodo get del atributo strCadenaSenalesAlerta
	 * @return	String
	 *		  	Valor del atributo strCadenaSenalesAlerta devuelto
	 * @author	roberth.martinez
	 * @date  	3/04/2018
	 */
	public String getStrCadenaSenalesAlerta() {
		
		if (strCadenaSenalesAlerta == null || strCadenaSenalesAlerta.isEmpty()) {
			
			strCadenaSenalesAlerta = "*";
		}
		return strCadenaSenalesAlerta;
	}

	/**
	 * @method	setStrCadenaSenalesAlerta
	 * 		  	Metodo set del atributo strCadenaSenalesAlerta
	 * @param	pStrCadenaSenalesAlerta
	 * 			Valor que tomara el atributo strCadenaSenalesAlerta
	 * @author	roberth.martinez
	 * @date	3/04/2018
	 */
	public void setStrCadenaSenalesAlerta(String pStrCadenaSenalesAlerta) {
		this.strCadenaSenalesAlerta = pStrCadenaSenalesAlerta;
	}

	/**
	 * @method	getHmEditorCeldaSenalesAlerta
	 * 		  	Metodo get del atributo hmEditorCeldaSenalesAlerta
	 * @return	HashMap<String,EditorCeldaGrilla>
	 *		  	Valor del atributo hmEditorCeldaSenalesAlerta devuelto
	 * @author	roberth.martinez
	 * @date  	3/04/2018
	 */
	public HashMap<String,EditorCeldaGrilla> getHmEditorCeldaSenalesAlerta() {
		return hmEditorCeldaSenalesAlerta;
	}

	/**
	 * @method	setHmEditorCeldaSenalesAlerta
	 * 		  	Metodo set del atributo hmEditorCeldaSenalesAlerta
	 * @param	pHmEditorCeldaSenalesAlerta
	 * 			Valor que tomara el atributo hmEditorCeldaSenalesAlerta
	 * @author	roberth.martinez
	 * @date	3/04/2018
	 */
	public void setHmEditorCeldaSenalesAlerta(
			HashMap<String,EditorCeldaGrilla> pHmEditorCeldaSenalesAlerta) {
		this.hmEditorCeldaSenalesAlerta = pHmEditorCeldaSenalesAlerta;
	}

	/** 
	 * ********************************************************************
	 * @method	castFrmSenalAlerta
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		   	un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return 	FormaSenalAlertaInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	2/04/2018
	 * *********************************************************************
	 */
	public FormaSenalAlertaInternacional castFrmSenalAlerta()throws Exception{
		return (FormaSenalAlertaInternacional)super.getFrmForma();
	}
}