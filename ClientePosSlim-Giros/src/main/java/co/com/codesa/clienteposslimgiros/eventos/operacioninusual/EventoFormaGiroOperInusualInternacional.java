package co.com.codesa.clienteposslimgiros.eventos.operacioninusual;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.monedaInternacional.EnumMonedaInternacional;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.enumeraciones.productoInternacional.EnumProductoInternacional;
import co.com.codesa.clienteposslimgiros.enumeraciones.tipoVinculo.EnumTipoVinculo;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaGiroOperInusualInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.MonedaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.OperacionInusualInternacionalRelacionada;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ProductoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.TipoVinculoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Corresponsal;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.OperacionInusualInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SenalAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class EventoFormaGiroOperInusualInternacional extends EventoAbstracto {

	/**
	 * @variable 	hmObjProductoInternacional
	 * 			 	Listado de los producto internacionales utilizados en operaciones inusuales
	 */
	private HashMap<String, ProductoInternacional> hmObjProductoInternacional;
	
	/**
	 * @variable 	hmObjMonedaInternacional
	 * 			 	Listado de las monedas para operaciones inusuales
	 */
	private HashMap<String, MonedaInternacional> hmObjMonedaInternacional;
	
	/**
	 * @variable 	hmObjTipoVinculo
	 * 			 	Listado de los tipos de vinsulo para operaciones inusuales
	 */
	private HashMap<String, TipoVinculoInternacional> hmObjTipoVinculo;
	
	/**
	 * @variable 	hmEditorCeldaSenalesAlerta
	 * 			 	Listado de los componentes de edicion configurados y exclusivos 
	 * 				para cada senal alerta, indexado por el codigo de estas
	 */
	private HashMap<String,EditorCeldaGrilla>	hmEditorCeldaSenalesAlerta;
	
	/**
	 * @variable 	objOperInusualInternacional
	 * 			 	Objeto gestiona la informacion de transacciones asociadas.
	 */
	private OperacionInusualInternacional objOperInusualInternacional;
	
	/**
	 * @variable	strCadenaSenalesAlerta
	 * 				variable para manejar la cadena de senales alerta diligenciadas
	 */
	private String strCadenaSenalesAlerta;
	
	/**
	 * @variable	strCadenaTransaccionesAsoc
	 * 				variable para manejar la cadena de transacciones asociadas
	 */
	private String strCadenaTransaccionesAsoc;
	
	Vector vectorOrdenTiposVinculo = new Vector();
	
	public EventoFormaGiroOperInusualInternacional(FormaGenerica pForma,
												   HashMap<String, EditorCeldaGrilla> pHmEditorCeldaSenalesAlerta){
		
		super(pForma);
		
		this.setHmEditorCeldaSenalesAlerta(pHmEditorCeldaSenalesAlerta);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{

		this.configuracionCampoTexto();
		this.cargarFormulario();
	}
	
	private void cargarFormulario() throws Exception{
		
		this.cargarCmbTiposDocumento();
		this.cargarCmbCorresponsales();
		this.cargarCmbProductoInternacional();
		this.cargarCmbMonedaInternacional();
		this.cargarCmbTiposVinculo();
		this.adicionarSenalesAlerta();
	}
	
	/**
     * ****************************************************************
     * @method configuracionCampoTexto
     *		   metodo utilizado para inicializar los datos de la forma 
     *		   envio giro postal
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
     * @author Roberth Martinez Vargas
     * ****************************************************************
     */
	private void configuracionCampoTexto() throws Exception{
		
		this.castFrmOperacionInusual().getTxtValorOperacion().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castFrmOperacionInusual().getTxtValorOperacion().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castFrmOperacionInusual().getTxtValorOperacion().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
		
		this.castFrmOperacionInusual().getTxtNumDocumento().getPropiedades().setActivaMayusculaMinuscula(true);
		this.castFrmOperacionInusual().getTxtNoOperacion().getPropiedades().setActivaMayusculaMinuscula(true);
		this.castFrmOperacionInusual().getTxtNumOperacion().getPropiedades().setActivaMayusculaMinuscula(true);
		
		this.castFrmOperacionInusual().getTxtNumOperacion().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO_EXT.getValor());
		this.castFrmOperacionInusual().getTxtNoOperacion().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO_EXT.getValor());
		this.castFrmOperacionInusual().getTxtCliUsuario().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DOCUMENTO_CE_INTER.getValor());
		
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
		
		this.castFrmOperacionInusual().getCmbTipoDocumento().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstTiposDocumentosInternacional().toArray(), 
					  							  						   		  		  true, 
					  							  						   		  		  null);
		
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception{
		
		if(pComponent.equals(this.castFrmOperacionInusual().getBtnAgregar())){
			
			this.agregarAGrillaOperacionRelacionada();
						
		} else if(pComponent.equals(this.castFrmOperacionInusual().getBtnEliminar())){
			
			this.borrarTransacciones();
		
		}else {
			super.accionarEjecucion(pComponent, pEvtEjecucion);
		}
	}
	
	@Override
	public void confirmar() throws Exception{
		
		this.registrarOperacionInusual();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception{
		
		this.configuracionCampos();
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception{
		
		if(pComponent.equals(this.castFrmOperacionInusual().getCmbTipoDocumento())){
			
			this.configurarFormatoIdentificacionXTipo();
			
		}
	}
	
	@Override
	public void accionarCambioRegistro	(	ListSelectionModel pObjLisSelectionModel,
									   		ListSelectionEvent pEvtValueChanged
									   	) 
		throws Exception 
	{
		if(pObjLisSelectionModel.equals(this.castFrmOperacionInusual().getGrillaSenalesAlerta().getSelectionModel())){
			
			this.seleccionarRegistroAlertas();
			
		}else {
			super.accionarCambioRegistro(pObjLisSelectionModel, 
					 					 pEvtValueChanged);				
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	configuracionCampos
	 * 		  	encargado de gestionar la configuracion personalizada
  	 * 		   	para los campos del formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	private void configuracionCampos()throws Exception{
		
		this.castFrmOperacionInusual().getCmbTipoDocumento().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getTxtNumDocumento().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getCmbProducto().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getCmbCorresponsal().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getTxtNoOperacion().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getTxtValorOperacion().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getCmbMoneda().getLblObligatorio().aplicarObligatoriedad(true);
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmOperacionInusual().getTxtNumDocumento(),
													this.castFrmOperacionInusual().getCmbTipoDocumento());
	}
	
	/** 
	 * ********************************************************************
	 * @method	agregarAGrillaOperacionRelacionada
	 * 		  	encargado de agrear a la grilla los datos ingresados
	 * 			en la seccion transacciones asociadas
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	didier.silva
	 * @date	01/06/2018
	 * *********************************************************************
	 */
	private void agregarAGrillaOperacionRelacionada() throws Exception{
		
		this.castFrmOperacionInusual().getTxtCliUsuario().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getTxtNumOperacion().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getCmbProductoTE().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getCmbCorresponsalTE().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionInusual().getCmbTipoVinculo().getLblObligatorio().aplicarObligatoriedad(true);
		
		if(this.castFrmOperacionInusual().getTxtCliUsuario().getText().isEmpty() &&
		   this.castFrmOperacionInusual().getTxtNumOperacion().getText().isEmpty() &&
		   this.castFrmOperacionInusual().getCmbProductoTE().getSelectedItem().toString().equals("-- SELECCIONAR --") &&
		   this.castFrmOperacionInusual().getCmbCorresponsalTE().getSelectedItem().toString().equals("-- SELECCIONAR --") &&
		   this.castFrmOperacionInusual().getCmbTipoVinculo().getSelectedItem().toString().equals("-- SELECCIONAR --")){
			
			this.castFrmOperacionInusual().getTxtCliUsuario().getLblObligatorio().aplicarObligatoriedad(false);
			this.castFrmOperacionInusual().getTxtNumOperacion().getLblObligatorio().aplicarObligatoriedad(false);
			this.castFrmOperacionInusual().getCmbProductoTE().getLblObligatorio().aplicarObligatoriedad(false);
			this.castFrmOperacionInusual().getCmbCorresponsalTE().getLblObligatorio().aplicarObligatoriedad(false);
			this.castFrmOperacionInusual().getCmbTipoVinculo().getLblObligatorio().aplicarObligatoriedad(false);
			
			throw EnumMensajes.TRANSACCION_ASOCIADA_AGREGAR_VACIO.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			
		}
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		OperacionInusualInternacionalRelacionada operInusuRelacionadas = new OperacionInusualInternacionalRelacionada();
		
		operInusuRelacionadas.setStrNumeroDocumento(this.castFrmOperacionInusual().getTxtCliUsuario().getText());
		operInusuRelacionadas.setStrNumeroOperacion(this.castFrmOperacionInusual().getTxtNumOperacion().getText());
		operInusuRelacionadas.setObjProductoInternacional((ProductoInternacional) this.castFrmOperacionInusual().getCmbProductoTE().getSelectedItem());
		operInusuRelacionadas.setObjCorresponsal((Corresponsal) this.castFrmOperacionInusual().getCmbCorresponsalTE().getSelectedItem());
		operInusuRelacionadas.setObjTipoVinsulo((TipoVinculoInternacional) this.castFrmOperacionInusual().getCmbTipoVinculo().getSelectedItem());
		
		this.castFrmOperacionInusual().getGrillaExisteTransaccion().getPropiedades().adicionarFilaGrilla(new Object[] {operInusuRelacionadas.getStrNumeroDocumento(),
																													   operInusuRelacionadas.getStrNumeroOperacion(),
																													   operInusuRelacionadas.getObjProductoInternacional().getStrDescripcionProducto(),
																													   operInusuRelacionadas.getObjCorresponsal().getStrNombre(),
																													   operInusuRelacionadas.getObjTipoVinsulo().getStrDescripcion()});
		this.limpiarCamposTransaccionAsociada();
		this.castFrmOperacionInusual().getTxtCliUsuario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmOperacionInusual().getTxtNumOperacion().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmOperacionInusual().getCmbProductoTE().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmOperacionInusual().getCmbCorresponsalTE().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmOperacionInusual().getCmbTipoVinculo().getLblObligatorio().aplicarObligatoriedad(false);
	}
	
	/** 
	 * ********************************************************************
	 * @method	borrarTransacciones
	 * 		  	detecta la fila que ha sido seleccionada de la grilla de
	 * 			transacciones asociadas y la elimina.
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	didier.silva
	 * @date	30/05/2018
	 * *********************************************************************
	 */
	private void borrarTransacciones() throws Exception{
		
		int filaSeleccionada = this.castFrmOperacionInusual().getGrillaExisteTransaccion().getSelectedRow();
		
		if(filaSeleccionada == -1){
			
			throw EnumMensajes.TRANSACCION_ASOCIADA_BOTON_ELIMINAR.generarExcepcion(EnumClasesMensaje.ADVERTENCIA); /****************************************/
			
		}else{
			this.castFrmOperacionInusual().getGrillaExisteTransaccion().getPropiedades().removerFilaGrilla(filaSeleccionada);
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method	registrarOperacionInusual
	 * 		  	Metodo que realiza el registro de una operacion inusual
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	didier.silva
	 * @date	30/05/2018
	 * *********************************************************************
	 */
	private void registrarOperacionInusual() throws Exception{
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
				true,
				true);

		objOperInusualInternacional = new OperacionInusualInternacional();
		TipoDocumentoInternacional objTipoDocInternacional;
		ProductoInternacional objProductoInternacional;
		Corresponsal objCorresponsale;
		MonedaInternacional objMonedaInternacional;
		String strRespuestaRegistroOperInusual;
		String strNoOperacion = "";
		
		objTipoDocInternacional = (TipoDocumentoInternacional) this.castFrmOperacionInusual().getCmbTipoDocumento().getSelectedItem();
		objProductoInternacional = (ProductoInternacional) this.castFrmOperacionInusual().getCmbProducto().getSelectedItem();
		objCorresponsale = (Corresponsal) this.castFrmOperacionInusual().getCmbCorresponsal().getSelectedItem();
		objMonedaInternacional = (MonedaInternacional) this.castFrmOperacionInusual().getCmbMoneda().getSelectedItem();
		
		strNoOperacion = this.castFrmOperacionInusual().getTxtValorOperacion().getText();
		strNoOperacion = strNoOperacion.replace(",", "");
		objOperInusualInternacional.setStrNumeroDocumento(this.castFrmOperacionInusual().getTxtNumDocumento().getText());
		objOperInusualInternacional.setStrNumeroOperacion(this.castFrmOperacionInusual().getTxtNoOperacion().getText());
		objOperInusualInternacional.setDouValorOperacion(Double.parseDouble(strNoOperacion));
		this.validarSenalesAlertaDiligenciadas();
		objOperInusualInternacional.setStrTramaSenalesAlerta(strCadenaSenalesAlerta);
		this.recorrerTablaTransacciones();
		objOperInusualInternacional.setStrOperInusualRelacionada(strCadenaTransaccionesAsoc);
		objOperInusualInternacional.setObjTipoDocumento(objTipoDocInternacional);
		objOperInusualInternacional.setObjProductoInternacional(objProductoInternacional);
		objOperInusualInternacional.setObjCorresponsal(objCorresponsale);
		objOperInusualInternacional.setObjMonedaInternacional(objMonedaInternacional);
		
		strRespuestaRegistroOperInusual = GiroInternacionalVistaLogica.getInstancia().registrarOperacionInusual(this.getObjUsuario(), 
																												EnumPeticionesMultiservicio.GIN_OPERACIONES_INUSUALES.getObjServicioPeticion(), 
																												this.objOperInusualInternacional);
		
		EnumMensajes.OPERACION_INUSUAL_EXITOSA.desplegarMensaje(super.getFrmForma(), 
															    EnumClasesMensaje.INFORMACION, 
															    strRespuestaRegistroOperInusual);
		
		this.limpiarPantalla();
		this.limpiarObjTemporales();
		super.cerrarForma();
	}
	
	/**
	 * ********************************************************************
	 * 
	 * @method limpiarObjTemporales Metodo encargado de considerar labores de
	 *         limpieza en los objetos temporales de la funcionalidad
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion presentada
	 * @author hector.cuenca
	 * @date 12/06/2017
	 *       *********************************************************************
	 */
	private void limpiarObjTemporales() throws Exception {
		if (objOperInusualInternacional != null) {
			objOperInusualInternacional = new OperacionInusualInternacional();
		}
	}
	
	private void limpiarPantalla() throws Exception{
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmOperacionInusual().getCmbTipoDocumento(),
													this.castFrmOperacionInusual().getTxtNumDocumento(),
													this.castFrmOperacionInusual().getCmbProducto(),
													this.castFrmOperacionInusual().getCmbCorresponsal(),
													this.castFrmOperacionInusual().getTxtNoOperacion(),
													this.castFrmOperacionInusual().getTxtValorOperacion(),
													this.castFrmOperacionInusual().getCmbMoneda(),
													this.castFrmOperacionInusual().getTxtCliUsuario(),
													this.castFrmOperacionInusual().getTxtNumOperacion(),
													this.castFrmOperacionInusual().getCmbProductoTE(),
													this.castFrmOperacionInusual().getCmbCorresponsalTE(),
													this.castFrmOperacionInusual().getCmbTipoVinculo());
		
		this.reiniciarTablaSenalesAlerta();
		this.reiniciarTablaTransacciones();
	}
	
	/**
	 * ********************************************************************
	 * 
	 * @method reiniciarTablaSenalesAlerta Metodo encargado de limpiar la grilla
	 * 		   de señales de alerta
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion presentada
	 * @author hector.cuenca
	 * @date   2/06/2018
	 *       *********************************************************************
	 */
	private void reiniciarTablaSenalesAlerta() throws Exception{
			
		for(int i = 0; i < this.castFrmOperacionInusual().getGrillaSenalesAlerta().getRowCount(); i++){
			
			String comentario = this.castFrmOperacionInusual().getGrillaSenalesAlerta().getValueAt(i, 2).toString();
			
			if(comentario != null){
				
				this.castFrmOperacionInusual().getGrillaSenalesAlerta().setValueAt(null, i, 2);
			}
		}
	}
	
	/**
	 * ********************************************************************
	 * 
	 * @method reiniciarTablaTransacciones Metodo encargado de limpiar la grilla
	 * 		   de transacciones asociadas
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion presentada
	 * @author hector.cuenca
	 * @date   2/06/2018
	 *       *********************************************************************
	 */
	private void reiniciarTablaTransacciones() throws Exception{
		
		int filas = this.castFrmOperacionInusual().getGrillaExisteTransaccion().getRowCount()-1;
		
		if(filas >= 0){
			
			for(int i = 0; i <= filas; i++){
				
				this.castFrmOperacionInusual().getGrillaExisteTransaccion().getPropiedades().removerFilaGrilla(0);
				
			}
		}	
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
		Object objValorComentario = null;
		String strComentatio = null; 
		String strValorCodSenalAlerta = null;
		String strCodSenal = null;
		int intPosicionColumnaComentario;
		int intPosicionColumnaCod;
		int senalesAlertaDiligenciadas = 0;
		int senalesAlertaNulas = 0;

		tblSenalesAlerta	=	this.castFrmOperacionInusual().getGrillaSenalesAlerta();
		
		strCadenaSenalesAlerta = "";
		
		intPosicionColumnaComentario = tblSenalesAlerta.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_GSA_GRILLA_COMENTARIO.toString());
		intPosicionColumnaCod = tblSenalesAlerta.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_GSA_GRILLA_CODIGO.toString());

		for(int i = 0; i < tblSenalesAlerta.getRowCount();i++){

			objValorComentario = tblSenalesAlerta.getValueAt(i, intPosicionColumnaComentario);
			strValorCodSenalAlerta = tblSenalesAlerta.getValueAt(i, intPosicionColumnaCod).toString();

			if(objValorComentario.toString() == null ||
					objValorComentario.toString().trim().isEmpty()){

				senalesAlertaNulas++;
				
			}	else	{
				
				if(!this.validaCaracteresEspeciales(objValorComentario.toString())){
					
					throw EnumMensajes.SENALES_ALERTA_CARACTERES_ESPECIALES.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, strValorCodSenalAlerta);
					
					}else{
				
				strCadenaSenalesAlerta += strValorCodSenalAlerta + "~" + objValorComentario.toString().trim() + "?";
				strCodSenal = strValorCodSenalAlerta;
				strComentatio = objValorComentario.toString();
				senalesAlertaDiligenciadas++;
				
				strCadenaSenalesAlerta = strCadenaSenalesAlerta.substring(0, strCadenaSenalesAlerta.length()-1);
				
				if(strComentatio.length() < 10 || strComentatio.length() > 500){
					
					throw EnumMensajes.SENALES_ALERTA_COMENTARIO_TAMANO.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, strCodSenal);
					
				}
			}
			
			((CajaTextoUtil) this.getHmEditorCeldaSenalesAlerta().get(strValorCodSenalAlerta).getComponent()).setText(objValorComentario.toString());
		}
		
		if (tblSenalesAlerta.getRowCount() == senalesAlertaNulas) {
			
			throw EnumMensajes.SENALES_ALERTA_NULA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA); /********************************/
		}
		
		if (senalesAlertaDiligenciadas > 8) {
			
			throw EnumMensajes.SENALES_ALERTA_MAX_8.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
		
	  }
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	validaCaracteresEspeciales
	 * 		  	Metodo que valida si el comentario de la señal de alerta contiene
	 * 			caracteres especiales.
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	3/06/2018
	 * *********************************************************************
	 */
	private boolean validaCaracteresEspeciales(String cadena) throws Exception{
		
		boolean retorno = false;
		
		if(cadena != null && !cadena.isEmpty()){
			retorno = cadena.matches("[a-zA-Z0-9 ]+");
		}
        return retorno;
         
    }
	
	/** 
	 * ********************************************************************
	 * @method	recorrerTablaTransacciones
	 * 		  	Metodo que recorre la grilla de transacciones asociadas para
	 * 			capturarlas y enviarlas en la trama de reistro de la operacion
	 * 			inusual.
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	3/06/2018
	 * *********************************************************************
	 */
	public void recorrerTablaTransacciones() throws Exception{
		
		strCadenaTransaccionesAsoc = "";
		
		if(this.castFrmOperacionInusual().getGrillaExisteTransaccion().getRowCount() != 0){
			if(this.castFrmOperacionInusual().getGrillaExisteTransaccion().getRowCount() > EnumParametrosApp.OII_NUMERO_TRANSACCIONES_ASOCIADAS.getValorEntero()){
				throw EnumMensajes.TRANSACCION_ASOCIADAS_PERMITIDAS.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}else{
				for(int i=0; i<this.castFrmOperacionInusual().getGrillaExisteTransaccion().getRowCount(); i++){
					String documento = (String)this.castFrmOperacionInusual().getGrillaExisteTransaccion().getValueAt(i, 0);
					String referencia = (String)this.castFrmOperacionInusual().getGrillaExisteTransaccion().getValueAt(i, 1);
					String producto = (String)this.castFrmOperacionInusual().getGrillaExisteTransaccion().getValueAt(i, 2);
					String corres = (String)this.castFrmOperacionInusual().getGrillaExisteTransaccion().getValueAt(i, 3);
					String vinculo = (String)this.castFrmOperacionInusual().getGrillaExisteTransaccion().getValueAt(i, 4);
					
					producto = this.obtenerCodigoProductoGrilla(producto);
					corres = this.obtenerCodigoCorresponsalGrilla(corres);
					vinculo = this.obtenerCodigoTipoVinculoGrilla(vinculo);
					
					strCadenaTransaccionesAsoc += documento +"~"+ referencia +"~"+ producto +"~"+ corres +"~"+ vinculo+ "?";
				}
				strCadenaTransaccionesAsoc = strCadenaTransaccionesAsoc.substring(0, strCadenaTransaccionesAsoc.length() - 1).replace("$","").replace(",","");
			}
			
		}else{
			strCadenaTransaccionesAsoc = "*";
			throw EnumMensajes.OPERACION_INUSUAL_MINIMO_TX_ASOCIADA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
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
		
		this.castFrmOperacionInusual().getCmbCorresponsal().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstCorresponsales().toArray(), 
								  							  						   		  		true, 
								  							  						   		  		null);
		
		this.castFrmOperacionInusual().getCmbCorresponsalTE().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstCorresponsales().toArray(), 
																		   		  		 true, 
																		   		  		 null);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiarCamposTransaccionAsociada
	 * 		   	Metodo que limpia los campos que se diligencian para agregar
	 * 			una transaccion asociada.
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	01/06/2018
	 * *********************************************************************
	 */
	private void limpiarCamposTransaccionAsociada() throws Exception{
		
		this.castFrmOperacionInusual().getTxtCliUsuario().setText("");
		this.castFrmOperacionInusual().getTxtNumOperacion().setText("");
		this.castFrmOperacionInusual().getCmbProductoTE().setSelectedIndex(0);
		this.castFrmOperacionInusual().getCmbCorresponsalTE().setSelectedIndex(0);
		this.castFrmOperacionInusual().getCmbTipoVinculo().setSelectedIndex(0);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumProductoInternacional
	 * 		   	Metodo que realiza el cargue de las diferentes constantes
	 * 			de enumeracion registradas en EnumProductoInternacional
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void cargarHashEnumProductoInternacional() throws Exception{
		
		this.hmObjProductoInternacional = new HashMap<String, ProductoInternacional>();
		
		for (	EnumProductoInternacional enmProd : EnumProductoInternacional.values()	){
			
			this.hmObjProductoInternacional.put(	String.valueOf(enmProd.getIntNumeroProducto()), 
													new ProductoInternacional(String.valueOf(enmProd.getIntNumeroProducto()), 
																			  enmProd.getEnmDescripcionProducto().toString())
											   );
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumMonedaInternacional
	 * 		   	Metodo que realiza el cargue de las diferentes constantes
	 * 			de enumeracion registradas en EnumMonedaInternacional
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void cargarHashEnumMonedaInternacional() throws Exception{
		
		this.hmObjMonedaInternacional = new HashMap<String, MonedaInternacional>();
		
		for (	EnumMonedaInternacional enmMoneda : EnumMonedaInternacional.values()	){
			
			this.hmObjMonedaInternacional.put(	String.valueOf(enmMoneda.getIntNumeroMoneda()), 
											  	new MonedaInternacional(String.valueOf(enmMoneda.getIntNumeroMoneda()), 
													  				  	enmMoneda.getEnmDescripcionMoneda().toString())
											 );
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumTipoVinculo
	 * 		   	Metodo que realiza el cargue de las diferentes constantes
	 * 			de enumeracion registradas en EnumTipoVinculo
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void cargarHashEnumTipoVinculo() throws Exception{
		
		this.hmObjTipoVinculo = new HashMap<String, TipoVinculoInternacional>();
		
		for (	EnumTipoVinculo enmTipoVinculo : EnumTipoVinculo.values()	){
			
			this.hmObjTipoVinculo.put(String.valueOf(enmTipoVinculo.getIntNumeroTipoVinculo()), 
									  new TipoVinculoInternacional(String.valueOf(enmTipoVinculo.getIntNumeroTipoVinculo()), 
											  					   enmTipoVinculo.getEnmDescripcionTipoVinculo().toString())
									 );
		}
		
		this.ordenarTiposVinculo();
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarCmbMonedaInternacional
	 * 		   	Metodo que se realiza el cargue de los valores en la lista desplegable
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbMonedaInternacional() throws Exception{
		
		this.cargarHashEnumMonedaInternacional();
		this.castFrmOperacionInusual().getCmbMoneda().getPropiedades().cargarCombo(this.getHmObjMonedaInternacional().values().toArray(), 
																				   true,
																				   null);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarCmbProductoInternacional
	 * 		   	Metodo que se realiza el cargue de los valores en la lista desplegable
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbProductoInternacional() throws Exception{
		
		this.cargarHashEnumProductoInternacional();
		this.castFrmOperacionInusual().getCmbProducto().getPropiedades().cargarCombo(this.getHmObjProductoInternacional().values().toArray(), 
																					 true,
																					 null);
		
		this.castFrmOperacionInusual().getCmbProductoTE().getPropiedades().cargarCombo(this.getHmObjProductoInternacional().values().toArray(), 
																					 true,
																					 null);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarCmbTiposVinculo
	 * 		   	Metodo que se realiza el cargue de los valores en la lista desplegable
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbTiposVinculo() throws Exception{
			
		this.cargarHashEnumTipoVinculo();
//		this.castFrmOperacionInusual().getCmbTipoVinculo().getPropiedades().cargarCombo(this.getHmObjTipoVinculo().values().toArray(), 
//																						true,
//																						null);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	adicionarSenalesAlerta
	 * 		   	Metodo que se realiza el cargue de las señale de alerta a la grilla
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	25/05/2018
	 * *********************************************************************
	 */
	private void adicionarSenalesAlerta() throws Exception{
		
		List<SenalAlertaInternacional> lstSenalAlerta;
		
		lstSenalAlerta = InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstSenalesAlertaInternacional();
		
		for (SenalAlertaInternacional objSenalAlertaInternacional : lstSenalAlerta)	{
			
			this.castFrmOperacionInusual().getGrillaSenalesAlerta().getPropiedades().adicionarFilaGrilla(new Object[]{		objSenalAlertaInternacional.getStrCodigo(),
																															objSenalAlertaInternacional.getStrNombre(),
																															this.obtenerCampoTextoSenalAlerta(objSenalAlertaInternacional)});
		}
	}
	
	private String obtenerCodigoProductoGrilla(String pStrProductoDescripcion) throws Exception{
		
		String strCodProducto = "";
		
		for (	EnumProductoInternacional enmProd : EnumProductoInternacional.values()	){
			
			if (	enmProd.getEnmDescripcionProducto().toString().equals(pStrProductoDescripcion)){
				
				strCodProducto = String.valueOf(enmProd.getIntNumeroProducto());
			}
		}
		
		return strCodProducto;
	}
	
	private String obtenerCodigoCorresponsalGrilla(String pStrCorresponsal) throws Exception{
		
		String strCodCorresponsal = "";
		List<Corresponsal> lstCorresponsales;
		
		lstCorresponsales = InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstCorresponsales();
		
		for (	Corresponsal corresponsal : lstCorresponsales){
			
			if (	corresponsal.getStrNombre().equals(pStrCorresponsal)	){
				
				strCodCorresponsal = corresponsal.getStrCodigo();
			}
		}
		
		return strCodCorresponsal;
	}
	
	private String obtenerCodigoTipoVinculoGrilla(String pStrVinculo) throws Exception{
		
		String strCodVinculo = "";
		
		for (	EnumTipoVinculo enmVinculo : EnumTipoVinculo.values()	){
			
			if (	enmVinculo.getEnmDescripcionTipoVinculo().toString().equals(pStrVinculo)	){
				
				strCodVinculo = String.valueOf(enmVinculo.getIntNumeroTipoVinculo());
			}
		}
		
		return strCodVinculo;
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
		
		tblAlertas = this.castFrmOperacionInusual().getGrillaSenalesAlerta();
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
		
		String strFormatoIngreso;
		
		if	(	(ecgEditorCelda = this.getHmEditorCeldaSenalesAlerta().get(pObjSenalAlerta.getStrCodigo())) == null	)
		{
			txtSenalAlerta	=	this.castFrmOperacionInusual().iniciarPropTxtSenalAlerta();
			ecgEditorCelda		=	new EditorCeldaGrilla	(	txtSenalAlerta,
					 											super.getFrmForma()
					 										);
			
			this.getHmEditorCeldaSenalesAlerta().put(pObjSenalAlerta.getStrCodigo(), ecgEditorCelda);
			
		}	else	{
			
			txtSenalAlerta	=	(CajaTextoUtil)ecgEditorCelda.getComponent();
		}
		
		//txtSenalAlerta.setText("");

		//strFormatoIngreso = EnumExpresionesRegulares.EXP_REG_FORMATO_ALFANUMERICO.getValor()+"{0,500}";
		//strFormatoSalida = strFormato+"{"+pObjPromocion.getLongitud()+"}";

		//txtSenalAlerta.getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
		//txtSenalAlerta.getPropiedades().setControlFormatoFinal(strFormatoSalida);
		
		return txtSenalAlerta.getText();
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
		
		this.castFrmOperacionInusual().getTxtNumDocumento().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strFormatoIngreso = null;
		objTipoDocumentoInternacional = this.obtenerTipoIdentificacion();
		
		if(objTipoDocumentoInternacional != null){
			
			this.castFrmOperacionInusual().getTxtNumDocumento().setEnabled(true);
			
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
			this.castFrmOperacionInusual().getTxtNumDocumento().setEnabled(false);
		}
		
		this.castFrmOperacionInusual().getTxtNumDocumento().getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
	}
	
	public FormaGiroOperInusualInternacional castFrmOperacionInusual() throws Exception{
		return (FormaGiroOperInusualInternacional) super.getFrmForma();
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
		
		objSeleccionado = this.castFrmOperacionInusual().getCmbTipoDocumento().getSelectedItem();
		
		if(objSeleccionado instanceof TipoDocumentoInternacional){
			objTipoDocumentoInternacional = (TipoDocumentoInternacional) objSeleccionado;
		}
		
		return objTipoDocumentoInternacional;
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
	public void ordenarTiposVinculo() throws Exception{
		
		if (!hmObjTipoVinculo.isEmpty()){
			
			String cadena = "";
			String cadenaObjeto = "";
			List<TipoVinculoInternacional> listaTipoVinculo = new ArrayList<TipoVinculoInternacional>();
			
			for (Map.Entry<String, TipoVinculoInternacional> entry : hmObjTipoVinculo.entrySet()) {
				
			    cadenaObjeto = entry.getKey() + "~" + entry.getValue();
			    
			    cadena = cadena + "?" + cadenaObjeto;
			}
			
			cadena = cadena.substring(1, cadena.length());
			
			listaTipoVinculo = this.tokenizarTiposEnvio(cadena);
			
			this.cargarCmbTiposVinculoOrdenado(listaTipoVinculo);
			
		}
			
	}
	
	private void cargarCmbTiposVinculoOrdenado(List<TipoVinculoInternacional> listaTipoVinculo) throws Exception{
		
		this.castFrmOperacionInusual().getCmbTipoVinculo().getPropiedades().cargarCombo(GiroInternacionalVistaLogica.getInstancia().ordenarTiposVinculoInternacional(listaTipoVinculo).toArray(), 
																						true, 
																						null);
	}
	
	public List<TipoVinculoInternacional> tokenizarTiposEnvio(String cadenaTiposEnvio) throws Exception{
		
		List<TipoVinculoInternacional> listaTipoVinculo = new ArrayList<TipoVinculoInternacional>();
		
		if(!cadenaTiposEnvio.isEmpty()) {
			
			String strCodigo = "";
			String strDescripcion = "";
			
			StringTokenizer stkTipo = new StringTokenizer(cadenaTiposEnvio, "?");
			while (stkTipo.hasMoreElements()) {
				String convenioPa = stkTipo.nextToken();
				StringTokenizer stkDocumento = new StringTokenizer(convenioPa, "~");
				if (stkDocumento.hasMoreElements()) {
					strCodigo = stkDocumento.nextToken();
					strDescripcion = stkDocumento.nextToken();
					TipoVinculoInternacional tVinculo = new TipoVinculoInternacional(strCodigo, strDescripcion);
					listaTipoVinculo.add(tVinculo);
				}
			}
		}
		
		return listaTipoVinculo;
	}

	public HashMap<String, ProductoInternacional> getHmObjProductoInternacional() {
		return hmObjProductoInternacional;
	}

	public void setHmObjProductoInternacional(
			HashMap<String, ProductoInternacional> pHmObjProductoInternacional) {
		this.hmObjProductoInternacional = pHmObjProductoInternacional;
	}

	public HashMap<String, MonedaInternacional> getHmObjMonedaInternacional() {
		return hmObjMonedaInternacional;
	}

	public void setHmObjMonedaInternacional(
			HashMap<String, MonedaInternacional> pHmObjMonedaInternacional) {
		this.hmObjMonedaInternacional = pHmObjMonedaInternacional;
	}

	public HashMap<String, TipoVinculoInternacional> getHmObjTipoVinculo() {
		return hmObjTipoVinculo;
	}

	public void setHmObjTipoVinculo(
			HashMap<String, TipoVinculoInternacional> pHmObjTipoVinculo) {
		this.hmObjTipoVinculo = pHmObjTipoVinculo;
	}

	public HashMap<String, EditorCeldaGrilla> getHmEditorCeldaSenalesAlerta() {
		return hmEditorCeldaSenalesAlerta;
	}

	public void setHmEditorCeldaSenalesAlerta(
			HashMap<String, EditorCeldaGrilla> pHmEditorCeldaSenalesAlerta) {
		this.hmEditorCeldaSenalesAlerta = pHmEditorCeldaSenalesAlerta;
	}

	public OperacionInusualInternacional getObjOperInusualInternacional() {
		return objOperInusualInternacional;
	}

	public void setObjOperInusualInternacional(
			OperacionInusualInternacional pObjOperInusualInternacional) {
		this.objOperInusualInternacional = pObjOperInusualInternacional;
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

	public String getStrCadenaTransaccionesAsoc() {
		
		if(strCadenaTransaccionesAsoc == null || strCadenaTransaccionesAsoc.isEmpty()){
			
			strCadenaTransaccionesAsoc = "*";
		}
		return strCadenaTransaccionesAsoc;
	}

	public void setStrCadenaTransaccionesAsoc(String pStrCadenaTransaccionesAsoc) {
		this.strCadenaTransaccionesAsoc = pStrCadenaTransaccionesAsoc;
	}
	
}
