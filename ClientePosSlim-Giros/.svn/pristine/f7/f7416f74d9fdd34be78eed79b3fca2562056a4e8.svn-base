package co.com.codesa.clienteposslimgiros.eventos.envioRemesaInternacional;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimgiros.dto.tercero.internacional.ValidarTerceroInternacionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.enumeraciones.tiposEnvioInternacional.EnumOpcionesEnvioInternacional;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.envioRemesaInternacional.FormaEnvioRemesaInternacional;
import co.com.codesa.clienteposslimgiros.formas.envioRemesaInternacional.FormaMovimientoCajaInternacional;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaCapturaDocumentoInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.internacional.UtilTransmisionInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.tercero.internacional.UtilTerceroInternacional;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.OpcionEnvioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.PaisesEnvioGirosInternacionales;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.TiposEnvioGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.NumeralInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SenalAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.transmision.internacional.ArchivoInternacionalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class EventoFormaEnvioRemesaInternacional extends EventoAbstracto{

	/**
	 * @variable objResCotiGiroInternalDatos
	 * 		     objeto cotizar del cual se esta llevando a cabo la transaccion
	 **/
	private FacturaGiroInternacional ObjEnvioGiroInternacional;
	
	private HashMap<String, OpcionEnvioInternacional> hmObjOpcionesEnvio;
	
	private String strIdentificacionTmp;
	
	private String strMontoTmp;
	
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
	 * @variable	booCapturoFotosAnvRev
	 * 				bandera para indicar si se capturaron las fotos anverso y reverso del documento
	 */
	private boolean booCapturoFotosAnvRev;
	
	/**
	 * @variable	booValidaCapturaHuella
	 * 				bandera para indicar si se capturo la huella. Si no, lanza un mensaje de excepcion y no deja habilitar
	 * 				los campos del beneficiario obligandolo a cotizar nuevamente.
	 */
	private boolean booValidaCapturaHuella;
	
	/**
	 * @variable	objFormaDatosAdicionales
	 * 				objeto de la forma FormaDatosAdicionales, 
	 * 				para la informacion de la empresa y el cargo
	 */
	private FormaDatosAdicionales objFormaDatosAdicionales;
	
	public EventoFormaEnvioRemesaInternacional(FormaGenerica pForma) throws Exception{
		
		super(pForma);
//		this.setObjEnvioGiroInternacional(pObjEnvioGiroInter);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
//		InformacionSessionGirosInternacional.getInstance(getObjUsuario());
		this.cargarFormulario();
		this.configuracionCampoTexto();
		this.strIdentificacionTmp = this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText();
		this.strMontoTmp = this.castFrmEnvioRemesaInternacional().getTxtMonto().getText();
		this.booValidaCapturaHuella = true;
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception{
		
		if(pComponent.equals(this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente())){
			
			this.configurarFormatoIdentificacionXTipo();
			
		}
		
		if (pComponent.equals(this.castFrmEnvioRemesaInternacional().getCmbOpcionEnvio())){
			
			this.limpiarComponentesCombos();
			
		}
		
		if (pComponent.equals(this.castFrmEnvioRemesaInternacional().getCmbPais())){
			
			this.limpiarComponentesCombos();
				
		}
	}
	
	@Override
	public void accionarIngresoLiberado(Component pComponent,
										KeyEvent pEvtKeyReleased)throws Exception{
		
		if(pComponent.equals(this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente()) &&
				!this.strIdentificacionTmp.equals(this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText())){
			
			this.strIdentificacionTmp = this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText();
			this.limpiarComponentesDocRemitente();
		}
		
		else if(pComponent.equals(this.castFrmEnvioRemesaInternacional().getTxtMonto()) &&
				!this.strMontoTmp.equals(this.castFrmEnvioRemesaInternacional().getTxtMonto().getText())){
			
			this.strMontoTmp = this.castFrmEnvioRemesaInternacional().getTxtMonto().getText();
			this.limpiarComponentesMonto();
		}
	}
	
	private void cargarFormulario() throws Exception{
		
		this.cargarCmbTiposDocumento();
		this.cargarCmbTiposEnvio();
		this.cargarCmbPaisesEnvio();
		this.cargarCmbNumeralesEnvio();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)
		throws Exception
	{
		
		this.configuracionCampos();
	}
	
	@Override
	public void accionarFocoPerdido(Component pComponent, java.awt.event.FocusEvent pEvtFocusLost) throws Exception {
		
		if(pComponent.equals(this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente())){
			
			super.getFrmForma().setBooAnularEventosXFocusLost(true);
			
			if	(	!this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText().trim().isEmpty()	)
			{
				this.cargarDocumentoAlReves();
			}
			
		}else{
			
			super.accionarFocoPerdido(pComponent,pEvtFocusLost);
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
		
		this.castFrmEnvioRemesaInternacional().getCmbPais().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmEnvioRemesaInternacional().getCmbOpcionEnvio().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmEnvioRemesaInternacional().getTxtMonto().getLblObligatorio().aplicarObligatoriedad(true);
		
		super.configurarLimpiarXCamposAccionados(	this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente(),
													this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente());
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
		
		this.castFrmEnvioRemesaInternacional().getTxtMonto().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castFrmEnvioRemesaInternacional().getTxtMonto().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
		this.castFrmEnvioRemesaInternacional().getTxtMonto().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setEnabled(false);
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
		
		this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstTiposDocumentosInternacional().toArray(), 
								  							  						   		  		  true, 
								  							  						   		  		  null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarHashEnumOpcionEnvio
	 * 		   	Metodo que realiza el cargue de las diferentes constantes
	 * 			de enumeracion registradas en EnumOpcionesEnvioInternacional
	 * @throws 	Exception
	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author 	didier.silva
	 * @date   	.0/04/2018
	 * *********************************************************************
	 */
	private void cargarHashEnumOpcionEnvio() throws Exception{
		
		this.hmObjOpcionesEnvio = new HashMap<String, OpcionEnvioInternacional>();
		
		for (	EnumOpcionesEnvioInternacional enmOpcion : EnumOpcionesEnvioInternacional.values()	){
			
			this.hmObjOpcionesEnvio.put(	String.valueOf(enmOpcion.getIntNumeroOpcion()), 
											new OpcionEnvioInternacional(String.valueOf(enmOpcion.getIntNumeroOpcion()), 
																		 enmOpcion.getEnmDescripcionOpcion().toString())
										);
		}
	}
	
	private void cargarCmbTiposEnvio() throws Exception{
		
		this.cargarHashEnumOpcionEnvio();
		this.castFrmEnvioRemesaInternacional().getCmbOpcionEnvio().getPropiedades().cargarCombo(this.getHmObjOpcionesEnvio().values().toArray(), 
																								true,
																								null);
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbPaisesEnvio
	 * 		  	Carga los paises de envio
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	didier.silva
	 * @date	28/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbPaisesEnvio() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getCmbPais().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstPaisesEnvio().toArray(), 
																					     true, 
																					     null);
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
		if (ObjEnvioGiroInternacional != null) {
			ObjEnvioGiroInternacional = new FacturaGiroInternacional();
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbNumeralesEnvio
	 * 		  	Carga los numerales de envio
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	didier.silva
	 * @date	03/05/2018
	 * *********************************************************************
	 */
	private void cargarCmbNumeralesEnvio() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstNumeralesEnvioInternacional().toArray(), 
																								 true,
																								 null);
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception{
		
		if(pComponent.equals(this.castFrmEnvioRemesaInternacional().getBtnCotizar())){
			
			this.cotizarGiroInternacional();
			
		} else if (pComponent.equals(this.castFrmEnvioRemesaInternacional().getBtnLimpiar())){
			
			this.limpiarComponentes();
			
		} else if (pComponent.equals(this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta())){
			
			this.accionGestionSenalesAlerta();
			
		} else if(pComponent.equals(this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos())){
			
			this.accionCapturaFotos();
						
		}else {
			super.accionarEjecucion(pComponent, pEvtEjecucion);
		}
	}
	
	@Override
	public void confirmar() throws Exception{
		
		this.validacionesEnvioGiro();
		this.enviarGiro();
	}
	
	/** 
	 * ********************************************************************
	 * @method	cotizarGiroInternacional
	 * 		  	metodo que realiza el envio de la trama de cotizar remesa
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	didier.silva
	 * @date	02/05/2018
	 * *********************************************************************
	 */
	private void cotizarGiroInternacional() throws Exception{
		
		this.limpiarXCampo	(	null,
				this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio());
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setEnabled(false);
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		ObjEnvioGiroInternacional = new FacturaGiroInternacional();
		TipoDocumentoInternacional objTipoDocumentoInter;
		OpcionEnvioInternacional objOpcion;
		PaisesEnvioGirosInternacionales objPais;
		double douValorEnvio;
		String strValor;
		
		objTipoDocumentoInter = (TipoDocumentoInternacional) this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente().getSelectedItem();
		objOpcion = (OpcionEnvioInternacional) this.castFrmEnvioRemesaInternacional().getCmbOpcionEnvio().getSelectedItem();
		objPais = (PaisesEnvioGirosInternacionales) this.castFrmEnvioRemesaInternacional().getCmbPais().getSelectedItem();
		douValorEnvio = Double.valueOf(this.castFrmEnvioRemesaInternacional().getTxtMonto().getText().replace(",", ""));
		strValor = UtilidadGiros.getInstancia().formatearABigDecimal(douValorEnvio);
		
		ObjEnvioGiroInternacional = GiroInternacionalVistaLogica.getInstancia().cotizarGiroInternacional(this.getObjUsuario(), 
																			 EnumPeticionesMultiservicio.GIN_COTIZAR_GIRO.getObjServicioPeticion(), 
																			 objTipoDocumentoInter, 
																			 this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText(), 
																			 objOpcion, 
																			 objPais, 
																			 strValor);
		
		
//		this.castFrmEnvioRemesaInternacional().getTxtMonto().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(strValorEnvio));
		ObjEnvioGiroInternacional.setDouValorEnvio(Double.parseDouble(strValor));
		ObjEnvioGiroInternacional.getTerceroOrigen().setIdentificacion(this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText());
		this.mostrarSenalesAlerta();
		this.cargarCotizacion();		
		this.consultarTerceroInternacional();
		this.aplicarObligatoriedadCamposBeneficiario();
		if(this.ObjEnvioGiroInternacional.getTerceroOrigen().getObjDtoConfigTerceroInternacional().isBooEnviarFotos()){
			
			this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(true);
		}
	}
	
	private void consultarTerceroInternacional() throws Exception{
		
		ValidarTerceroInternacionalDTO objDtoValidarTercero;
		
		objDtoValidarTercero = new ValidarTerceroInternacionalDTO	(	this.getFrmForma(),
																		this.getObjEnvioGiroInternacional().getTerceroOrigen(), 
																		this.getObjEnvioGiroInternacional().getStrIdTtransaccion()
																	);
		try{
		
			this.booValidaCapturaHuella = true;
			
			UtilTerceroInternacional.getInstancia().validarTercero	(objDtoValidarTercero);
			
		}catch(Exception e){
			this.booValidaCapturaHuella = false;
			super.controlExcepcion(e);
		}
		
		if (booValidaCapturaHuella) {
			this.getObjEnvioGiroInternacional().setTerceroOrigen(objDtoValidarTercero.getObjTercero());
			this.habilitarBeneficiarioNumerales();
		}
	}
	
	private void enviarGiro() throws Exception{
		
		NumeralInternacional objNumeralesEnvio;
		TerceroInternacional objTerceroDestino;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		objTerceroDestino = new TerceroInternacional();
		
		if(!this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getSelectionModel().isSelectionEmpty()){
		
			this.capturarTipoEnvioGrilla();
			this.ObjEnvioGiroInternacional.setTotal(Double.parseDouble(this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().getStrTotalEnvio()));
			this.ObjEnvioGiroInternacional.setDouTotalMovimiento(Double.parseDouble(this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().getStrTotalEnvio()) + Double.parseDouble(this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().getStrTotalComision()));
			objNumeralesEnvio = (NumeralInternacional) this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getSelectedItem();
			this.ObjEnvioGiroInternacional.setObjNumeralInternacional(objNumeralesEnvio);
			objTerceroDestino.setNombres(this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getText());
			objTerceroDestino.setApellido1(this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getText());
			
			this.ObjEnvioGiroInternacional.setTerceroDestino(objTerceroDestino);
			
			this.mostrarMovimientoCajaInternacional();
			
//				GiroInternacionalVistaLogica.getInstancia().envioGiro(	getObjUsuario(), 
//																		EnumPeticionesMultiservicio.GIN_ENVIO_GIRO.getObjServicioPeticion(), 
//																		this.ObjEnvioGiroInternacional);
//				
//				EnumMensajes.GIRO_ENVIADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
//						   EnumClasesMensaje.INFORMACION, 
//						   this.ObjEnvioGiroInternacional.getReferenciaControl());
//	
//				boolean imprimio;
//				
//				imprimio = EnumImpresiones.ENVIO_GIRO_INTERNACIONAL.ejecutarImpresion(super.getFrmForma(), 
//											  		 false,
//											  		 this.ObjEnvioGiroInternacional,
//											  		 super.getObjUsuario(),
//											  		 EnumPeticionesMultiservicio.GIN_ENVIO_GIRO.getObjServicioPeticion());
//				
//				this.limpiarObjTemporales();
				
		} else {
			
			throw EnumMensajes.DEBE_SELECCIONAR_UN_GIRO_PARA_PAGO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	private void mostrarMovimientoCajaInternacional() throws Exception{
		
		new FormaMovimientoCajaInternacional(this.castFrmEnvioRemesaInternacional(), 
											 true, 
											 this.ObjEnvioGiroInternacional);
	}
	
	private void habilitarBeneficiarioNumerales() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setEnabled(true);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setEnabled(true);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setEnabled(true);
	}
	
	private void limpiarComponentes() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setText("");
		this.castFrmEnvioRemesaInternacional().getCmbOpcionEnvio().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getCmbPais().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getTxtMonto().setText("");
		this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getPropiedades().limpiarGrilla();
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getLblObligatorio().aplicarObligatoriedad(false);
		
		this.limpiarObjTemporales();
	}
	
	private void limpiarComponentesDocRemitente() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getCmbOpcionEnvio().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getCmbPais().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getTxtMonto().setText("");
		this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getPropiedades().limpiarGrilla();
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getLblObligatorio().aplicarObligatoriedad(false);
		
		this.limpiarObjTemporales();
	}
	
private void limpiarComponentesMonto() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getPropiedades().limpiarGrilla();
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setSelectedIndex(0);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getLblObligatorio().aplicarObligatoriedad(false);
		
		this.limpiarObjTemporales();
	}
	
	private void limpiarComponentesCombos() throws Exception{
			
		this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getPropiedades().limpiarGrilla();
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setText("");
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setText("");
		if(this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getSelectedIndex() > 0){
			this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setSelectedIndex(0);
		}
		this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getBtnCapturarFotos().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().setEnabled(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().setEnabled(false);
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getLblObligatorio().aplicarObligatoriedad(false);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getLblObligatorio().aplicarObligatoriedad(false);
	}
	
	private void aplicarObligatoriedadCamposBeneficiario() throws Exception{
		
		this.castFrmEnvioRemesaInternacional().getTxtNombreBeneficiario().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmEnvioRemesaInternacional().getTxtApellidoBeneficiario().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmEnvioRemesaInternacional().getCmbNumeralEnvio().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCotizacion
	 * 		  	metodo para cargar las tipos de envio de la lista en la grilla
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	didier.silva
	 * @date	02/05/2018
	 * *********************************************************************
	 */
	private void cargarCotizacion() throws Exception{
		
		if(ObjEnvioGiroInternacional != null){
			
			this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getPropiedades().limpiarGrilla();
			for (TiposEnvioGiroInternacional objTiposEnvio : ObjEnvioGiroInternacional.getLstTiposEnvio()) {
				this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getPropiedades().adicionarFilaGrilla(new Object[] { objTiposEnvio.getStrIdOpcionEnvio(),
																																 objTiposEnvio.getStrCodigoOpcionEnvio(),
						 																										 objTiposEnvio.getStrNombreOpcionEnvio(),
																																 objTiposEnvio.getStrMonedaRecibir(),
																																 objTiposEnvio.getStrMontoRecibe(),
																																 objTiposEnvio.getStrTotalEnvio(),
																																 objTiposEnvio.getStrTotalComision()});
			}
			
			this.castFrmEnvioRemesaInternacional().getBtnSenalesAlerta().setEnabled(true);
			
		} else {
			
			throw EnumMensajes.NO_HAY_DATOS.generarExcepcion(EnumClasesMensaje.ERROR);
			
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	capturarTipoEnvioGrilla
	 * 		  	Captura la informacion de la fila seleccionada y se guarda
	 * 			en un objeto de tipo TiposEnvioGiroInternacional
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	didier.silva
	 * @date	15/05/2018
	 * *********************************************************************
	 */
	private void capturarTipoEnvioGrilla() throws Exception{
		
		if(!this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getSelectionModel().isSelectionEmpty()){
			
			int filaSeleccionada = this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getSelectedRow();
			
			this.ObjEnvioGiroInternacional.setObjTipoEnvioInternacional(new TiposEnvioGiroInternacional());
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrCodigoOpcionEnvio((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 0));
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrMonedaRecibir((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 3));
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrMontoRecibe((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 4));
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrNombreOpcionEnvio((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 2));
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrIdOpcionEnvio((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 1));
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrTotalComision((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 6));
			this.ObjEnvioGiroInternacional.getObjTipoEnvioInternacional().setStrTotalEnvio((String) this.castFrmEnvioRemesaInternacional().getGrillaTiposEnvio().getValueAt(filaSeleccionada, 5));			
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	mostrarSenalesAlerta
	 * 		  	muestra las senales de alerta que se tienen de la consulta
	 * 			por referencia
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	15/04/2018
	 * *********************************************************************
	 */
	public void mostrarSenalesAlerta() throws Exception{
		
		if (this.ObjEnvioGiroInternacional.getLstSenalesAlerta()!=null) {
			for (SenalAlertaInternacional objSenalAlertaInternacional  : this.ObjEnvioGiroInternacional.getLstSenalesAlerta()) {
				
				EnumMensajes.SENALES_ALERTA_CONSULTA.desplegarMensaje(super.getFrmForma(), 
																	  EnumClasesMensaje.ADVERTENCIA, 
																	  objSenalAlertaInternacional.getStrNombre());
			}
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
		
		this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strFormatoIngreso = null;
		objTipoDocumentoInternacional = this.obtenerTipoIdentificacion();
		
		if(objTipoDocumentoInternacional != null){
			
			this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setEnabled(true);
			
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
			this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setEnabled(false);
		}
		
		this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
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
		
		objSeleccionado = this.castFrmEnvioRemesaInternacional().getCmbTipoDocumentoRemitente().getSelectedItem();
		
		if(objSeleccionado instanceof TipoDocumentoInternacional){
			objTipoDocumentoInternacional = (TipoDocumentoInternacional) objSeleccionado;
		}
		
		return objTipoDocumentoInternacional;
	}
	
	/** 
	 * ********************************************************************
	 * @method	accionGestionSenalesAlerta
	 * 		  	metodo para realizar las acciones del boton de gestion de 
	 * 			senales alerta
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	private void accionGestionSenalesAlerta() throws Exception{
		FormaSenalAlertaInternacional objFrmSenalAlertaInternacional;
		
		objFrmSenalAlertaInternacional = new FormaSenalAlertaInternacional(this.getFrmForma(), 
																		   true, 
																		   this.getHmEditorCeldaSenalesAlerta());
		
		this.ObjEnvioGiroInternacional.setStrTramaSenalesAlerta(((EventoFormaSenalAlertaInternacional)objFrmSenalAlertaInternacional.getEventoForma()).getStrCadenaSenalesAlerta());
	}
	
	/** 
	 * ********************************************************************
	 * @method	accionCapturaFotos
	 * 		  	metodo para realizar las acciones del boton de captura de 
	 * 			fotos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	02/04/2018
	 * *********************************************************************
	 */
	private void accionCapturaFotos() throws Exception{
		
		FormaCapturaDocumentoInternacional frmCapturaDocumentoInternacional;
		
		frmCapturaDocumentoInternacional = new FormaCapturaDocumentoInternacional(this.getFrmForma(), 
											   									  true, 
											   									  (TerceroInternacional)ObjEnvioGiroInternacional.getTerceroOrigen(), 
											   									  ObjEnvioGiroInternacional.getStrIdTtransaccion());
		
		if (EnumBotonesEncabezado.BTNGUARDAR.equals(frmCapturaDocumentoInternacional.getEnmBotEncAccionSolicitada())) {
			
			this.setBooCapturoFotosAnvRev(true);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validacionesEnvioGiro
	 * 		  	validaciones previas al envio del giro
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	didier.silva
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	public void validacionesEnvioGiro() throws Exception{
		
		List<ArchivoInternacionalDTO> lstTransmitirArchivos = null;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		if(this.ObjEnvioGiroInternacional.getTerceroOrigen().getObjDtoConfigTerceroInternacional().isBooEnviarFotos()){
			
			if(this.isBooCapturoFotosAnvRev()){
				
				lstTransmitirArchivos = lstTransmitirArchivos==null?lstTransmitirArchivos = new ArrayList<>():lstTransmitirArchivos;
				
				lstTransmitirArchivos.add(new ArchivoInternacionalDTO(ObjEnvioGiroInternacional.getTerceroOrigen().getFilArchivoImgDocAnverso()));
				lstTransmitirArchivos.add(new ArchivoInternacionalDTO(ObjEnvioGiroInternacional.getTerceroOrigen().getFilArchivoImgDocReverso()));
				
				boolean booTransmiteArchivosDoc;
				booTransmiteArchivosDoc = UtilTransmisionInternacional.getInstancia().transmitirArchivosInternacional(this.getObjUsuario(), 
																												   	  lstTransmitirArchivos);
				System.err.println("-----booTransmiteArchivosDoc:"+booTransmiteArchivosDoc);
				
				
			}else{
				throw EnumMensajes.DEBE_CAPTURAR_IMG_DOC_ANV_REV.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}
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
		strCadenaOriginal = this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().getText();
		this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setVisible(false);
		
		objFormaDatosAdicionales = new FormaDatosAdicionales(super.getFrmForma(), 
					 										 true, 
					 										 this.castFrmEnvioRemesaInternacional().iniciarPropPnlContenedorDocAlRevesDatAdd());
		
		this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setVisible(true);
		
		if(EnumBotonesEncabezado.BTNGUARDAR.equals(objFormaDatosAdicionales.getEnmBotEncAccionSolicitada())){
			
			strBuilder = new StringBuilder(this.castFrmEnvioRemesaInternacional().getTxtNumeroDocAlReves().getText());
			strCadenaInvertida = strBuilder.reverse().toString();
			
			if (!strCadenaOriginal.equals(strCadenaInvertida)) {
				this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setText("");
				this.castFrmEnvioRemesaInternacional().getTxtNumeroDocAlReves().setText("");
				throw EnumMensajes.NUMEROS_DOCUMENTOS_NO_CONINCIDEN.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}
		}else{
			this.castFrmEnvioRemesaInternacional().getTxtNumDocRemitente().setText("");
		}
		this.castFrmEnvioRemesaInternacional().getTxtNumeroDocAlReves().setText("");
	}
	
	public FormaEnvioRemesaInternacional castFrmEnvioRemesaInternacional() throws Exception{
		return (FormaEnvioRemesaInternacional) super.getFrmForma();
	}

	public HashMap<String, OpcionEnvioInternacional> getHmObjOpcionesEnvio() {
		return hmObjOpcionesEnvio;
	}

	public void setHmObjOpcionesEnvio(
			HashMap<String, OpcionEnvioInternacional> hmObjOpcionesEnvio) {
		this.hmObjOpcionesEnvio = hmObjOpcionesEnvio;
	}
	
	public FacturaGiroInternacional getObjEnvioGiroInternacional() {
		return ObjEnvioGiroInternacional;
	}
	
	public void setObjEnvioGiroInternacional(
			FacturaGiroInternacional objEnvioGiroInternacional) {
		ObjEnvioGiroInternacional = objEnvioGiroInternacional;
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
		
		if	(	this.hmEditorCeldaSenalesAlerta	==	null)
		{
			this.hmEditorCeldaSenalesAlerta	=	new HashMap<String, EditorCeldaGrilla>();
		}
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
	 * @method	isBooCapturoFotosAnvRev
	 * 		  	Metodo get del atributo booCapturoFotosAnvRev
	 * @return	boolean
	 *		  	Valor del atributo booCapturoFotosAnvRev devuelto
	 * @author	user
	 * @date  	8/04/2018
	 */
	public boolean isBooCapturoFotosAnvRev() {
		return booCapturoFotosAnvRev;
	}

	/**
	 * @method	setBooCapturoFotosAnvRev
	 * 		  	Metodo set del atributo booCapturoFotosAnvRev
	 * @param	pBooCapturoFotosAnvRev
	 * 			Valor que tomara el atributo booCapturoFotosAnvRev
	 * @author	user
	 * @date	8/04/2018
	 */
	public void setBooCapturoFotosAnvRev(boolean pBooCapturoFotosAnvRev) {
		booCapturoFotosAnvRev = pBooCapturoFotosAnvRev;
	}

	public boolean isBooValidaCapturaHuella() {
		return booValidaCapturaHuella;
	}

	public void setBooValidaCapturaHuella(boolean booValidaCapturaHuella) {
		this.booValidaCapturaHuella = booValidaCapturaHuella;
	}
}
