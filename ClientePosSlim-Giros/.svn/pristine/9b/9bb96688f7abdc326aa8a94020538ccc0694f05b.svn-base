package co.com.codesa.clienteposslimgiros.eventos.pago;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimgiros.dto.tercero.internacional.ValidarTerceroInternacionalDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaGestionReclamoInternacional;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaSenalAlertaInternacional;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaPagoGiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.superCombo.FormaProtegiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaCapturaDocumentoInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.internacional.UtilTransmisionInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.tercero.internacional.UtilTerceroInternacional;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.NumeralInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SenalAlertaInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoMotivoGiroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.transmision.internacional.ArchivoInternacionalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/** 
 * ********************************************************************
 * @class	EventoFormaPagoGiroInternacional
 *		 	Clase encargada de controlar los eventos de la forma de
 * 		  	pago de giro internacional
 * @author	roberth.martinez
 * @date  	25/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPagoGiroInternacional extends EventoAbstracto{
	
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
	 * @variable objFacturaGiroInternacional
	 * 		     objeto factura del cual se esta llevando a cabo la transaccion
	 **/
	private FacturaGiroInternacional objFacturaGiroInternacional;
	
	/**
	 * @variable 	hmEditorCeldaSenalesAlerta
	 * 			 	Listado de los componentes de edicion configurados y exclusivos 
	 * 				para cada senal alerta, indexado por el codigo de estas
	 */
	private HashMap<String,EditorCeldaGrilla>	hmEditorCeldaSenalesAlerta;
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaPagoGiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		  	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @param 	pObjFacturaGiroInternacional
	 * 			objeto factura del cual se esta llevando a cabo la 
  	 * 		  	transaccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public EventoFormaPagoGiroInternacional(FormaGenerica pForma,
							   				FacturaGiroInternacional pObjFacturaGiroInternacional) throws Exception{
		super(pForma);
		this.setObjFacturaGiroInternacional(pObjFacturaGiroInternacional);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFormulario();
		
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened)
		throws Exception
	{
		
		this.mostrarSenalesAlerta();
		this.configuracionCampos();
		
		ValidarTerceroInternacionalDTO objDtoValidarTercero;
		
		objDtoValidarTercero = new ValidarTerceroInternacionalDTO	(	super.getFrmForma(),
																		this.getObjFacturaGiroInternacional().getTerceroDestino(), 
																		this.getObjFacturaGiroInternacional().getStrIdTtransaccion()
																	);
		try{
		
			UtilTerceroInternacional.getInstancia().validarTercero	(objDtoValidarTercero);
			
			this.castFrmPagoGiroInternacional().getTxtClienteTerceroBen().setText(this.getObjFacturaGiroInternacional().getTerceroDestino().toString());
			
			this.getObjFacturaGiroInternacional().setTerceroDestino(objDtoValidarTercero.getObjTercero());
			
			this.validaDespligueProtegiro();
			
		}catch(Exception e){
			super.controlExcepcion(e);
			super.regresarFormaPadre();
		}
		
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castFrmPagoGiroInternacional().getCmbMotivoRemesa())){
			
			this.accionCmbTiposMotivosGiros();
			
		}else{
		
			super.accionarCambioItem(pComponent,
					 				 pEvtItemStateChanged);
		}
			
		
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if (pComponent.equals(this.castFrmPagoGiroInternacional().getBtnGestionReclamos())) {
			
			this.accionGestionDeReclamos();
			
		}else if(pComponent.equals(this.castFrmPagoGiroInternacional().getBtnGestionSenalesAlerta())){
			
			this.accionGestionSenalesAlerta();
			
		}else if (pComponent.equals(this.castFrmPagoGiroInternacional().getBtnCapturarFotos())) {
			
			this.accionCapturaFotos();
			
		}else{
			super.accionarEjecucion(pComponent, pEvtEjecucion);
		}
		
	}
	
	@Override
	public void confirmar() throws Exception{
		
		this.validacionesPagoGiro();
		this.pagarGiro();
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
		
		this.castFrmPagoGiroInternacional().getCmbMotivoRemesa().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmPagoGiroInternacional().getCmbNumerales().getLblObligatorio().aplicarObligatoriedad(true);
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarFormulario
	 * 		  	Metodo que se encarga de gestionar el cargue de la 
  	 * 		    informacion sobre el formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	private void cargarFormulario()throws Exception{
		
		this.cargarCmbTiposMotivosGiros();
		this.cargarDatosFactura();
		
		if (this.objFacturaGiroInternacional.getTerceroDestino().getObjDtoConfigTerceroInternacional().isBooEnviarFotos()) {
			
			this.castFrmPagoGiroInternacional().getBtnCapturarFotos().setEnabled(true);
		}
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbTiposMotivosGiros
	 * 		  	Carga los tipos motivos giros  
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	private void cargarCmbTiposMotivosGiros()throws Exception{
		
		this.castFrmPagoGiroInternacional().getCmbMotivoRemesa().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstTipoMotivoGiroInternacional().toArray(), 
								  							  						   		  true, 
								  							  						   		  null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarDatosFactura
	 * 		  	Metodo para cargar los datos de la factura en pantalla
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	private void cargarDatosFactura() throws Exception{
		
		this.castFrmPagoGiroInternacional().getTxtNombreTerceroRem().setText(objFacturaGiroInternacional.getTerceroOrigen().getNombres());
		this.castFrmPagoGiroInternacional().getTxtTelefonoTerceroRem().setText(objFacturaGiroInternacional.getTerceroOrigen().getTelefono1());
		
		this.castFrmPagoGiroInternacional().getTxtNombreTerceroBen().setText(objFacturaGiroInternacional.getTerceroDestino().getNombres());
		this.castFrmPagoGiroInternacional().getTxtTelefonoTerceroBen().setText(objFacturaGiroInternacional.getTerceroDestino().getTelefono1());
		
		this.castFrmPagoGiroInternacional().getTxtFormaPago().setText(objFacturaGiroInternacional.getListMediosPago().get(0).getCodigo().equals("EFE")?"EFECTIVO":"");
		this.castFrmPagoGiroInternacional().getTxtNotas().setText(objFacturaGiroInternacional.getObjNota().getStrDescripcion());
		
		this.castFrmPagoGiroInternacional().getTxtVlrPesos().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroInternacional.getTotal()));
		this.castFrmPagoGiroInternacional().getTxtVlrDolares().setText("USD "+objFacturaGiroInternacional.getDouValorEnDolar()+"");
		
		this.castFrmPagoGiroInternacional().getTxtTasa().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(objFacturaGiroInternacional.getDouTMR()));
		this.castFrmPagoGiroInternacional().getTxtGMF().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(objFacturaGiroInternacional.getDouGMF()));
		
		this.castFrmPagoGiroInternacional().getTxtGastosAdmin().setText(objFacturaGiroInternacional.getStrGastosAdministrativos());
		this.castFrmPagoGiroInternacional().getTxtVlrProtegiro().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(0));//objFacturaGiroInternacional.getDouValorPrima()));
		
		this.castFrmPagoGiroInternacional().getTxtVlrTotalPagar().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroInternacional.getTotal()));//-objFacturaGiroInternacional.getDouValorPrima()));
		
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	accionCmbTiposMotivosGiros
	 * 		  	accion que se ejecuta al accionar el componente 
	 * 			CmbTiposMotivosGiro
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	private void accionCmbTiposMotivosGiros() throws Exception{
		Object objSeleccion;
		
		objSeleccion = this.castFrmPagoGiroInternacional().getCmbMotivoRemesa().getSelectedItem();
		
		if (objSeleccion instanceof TipoMotivoGiroInternacional) {
			
			this.cargarCmbNumerales();
			
		}else{
			
			this.castFrmPagoGiroInternacional().getCmbNumerales().removeAllItems();
		}
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbNumerales
	 * 		  	metodo para cargar el combo de numerales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	27/03/2018
	 * *********************************************************************
	 */
	private void cargarCmbNumerales() throws Exception{
		
		TipoMotivoGiroInternacional objTipoMotivoGiroInternacional;
		List<NumeralInternacional> lstNumerales;
		
		objTipoMotivoGiroInternacional = (TipoMotivoGiroInternacional) this.castFrmPagoGiroInternacional().getCmbMotivoRemesa().getSelectedItem();
		lstNumerales = GiroInternacionalVistaLogica.getInstancia().consultaNumeralesInternacional(this.getObjUsuario(), 
																								  EnumPeticionesMultiservicio.GIN_CONSULTAR_NUMERALES_PAGO.getObjServicioPeticion(),
																								  objTipoMotivoGiroInternacional);
		
		this.castFrmPagoGiroInternacional().getCmbNumerales().getPropiedades().cargarCombo(lstNumerales.toArray(), 
			   		  																	   true, 
			   		  																	   null);
	}
	
	
	/** 
	 * ********************************************************************
	 * @method	accionGestionDeReclamos
	 * 		  	metodo para realizar las acciones del boton de gestion de 
	 * 			reclamos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	private void accionGestionDeReclamos() throws Exception{
		
		new FormaGestionReclamoInternacional(this.getFrmForma(), 
											 objFacturaGiroInternacional, 
											 true);
		
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
		
		this.strCadenaSenalesAlerta = ((EventoFormaSenalAlertaInternacional)objFrmSenalAlertaInternacional.getEventoForma()).getStrCadenaSenalesAlerta();
		
		//System.out.println("--strCadenaSenalesAlerta:"+strCadenaSenalesAlerta);
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
											   									  (TerceroInternacional)objFacturaGiroInternacional.getTerceroDestino(), 
											   									  objFacturaGiroInternacional.getStrIdTtransaccion());
		
		if (EnumBotonesEncabezado.BTNGUARDAR.equals(frmCapturaDocumentoInternacional.getEnmBotEncAccionSolicitada())) {
			
			this.setBooCapturoFotosAnvRev(true);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validaDespligueProtegiro
	 * 		  	metodo para validar el despliegue de del protegiro
	 * @author	roberth.martinez
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @date	23/04/2018
	 * *********************************************************************
	 */
	public void validaDespligueProtegiro() throws Exception{
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.VALIDA_SERVICIO_PROTEGIRO_INTERNACIONAL,
													  EnumParametrosSistema.TOPE_VLR_TOPE_ASEGURADO_SEGURO_FPISA);
		
		if (EnumParametrosSistema.VALIDA_SERVICIO_PROTEGIRO_INTERNACIONAL.obtenerValorBooleano ( "S" )) {
			
			double vlrMaximoAsegurado = EnumParametrosSistema.TOPE_VLR_TOPE_ASEGURADO_SEGURO_FPISA.obtenerValorEntero();
			
			if (this.objFacturaGiroInternacional.getTotal() > vlrMaximoAsegurado) {
				
				this.objFacturaGiroInternacional.getFacturaSeguro().setValorAsegurado(vlrMaximoAsegurado);
			}else{
				
				this.objFacturaGiroInternacional.getFacturaSeguro().setValorAsegurado(this.objFacturaGiroInternacional.getTotal());
			}
			
			FormaProtegiroInternacional frmProtegiroInternacional;
			
			frmProtegiroInternacional = new FormaProtegiroInternacional(this.getFrmForma(), 
																		true, 
																		objFacturaGiroInternacional);
			
			if (frmProtegiroInternacional.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)) {
				
				this.castFrmPagoGiroInternacional().getTxtVlrProtegiro().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroInternacional.getDouValorPrima()));	
				this.castFrmPagoGiroInternacional().getTxtVlrTotalPagar().setText(UtilidadGiros.getInstancia().formatoPresentacionDinero(objFacturaGiroInternacional.getTotal()-objFacturaGiroInternacional.getDouValorPrima()));
				
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validacionesPagoGiro
	 * 		  	validaciones previas al pago del giro
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	8/04/2018
	 * *********************************************************************
	 */
	public void validacionesPagoGiro() throws Exception{
		
		List<ArchivoInternacionalDTO> lstTransmitirArchivos = null;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios (super.getFrmForma(),
																	true,
																	true);
		
		if(this.objFacturaGiroInternacional.getTerceroDestino().getObjDtoConfigTerceroInternacional().isBooEnviarFotos()){
			
			if(this.isBooCapturoFotosAnvRev()){
				
				lstTransmitirArchivos = lstTransmitirArchivos==null?lstTransmitirArchivos = new ArrayList<>():lstTransmitirArchivos;
				
				lstTransmitirArchivos.add(new ArchivoInternacionalDTO(objFacturaGiroInternacional.getTerceroDestino().getFilArchivoImgDocAnverso()));
				lstTransmitirArchivos.add(new ArchivoInternacionalDTO(objFacturaGiroInternacional.getTerceroDestino().getFilArchivoImgDocReverso()));
				
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
	 * @method	pagarGiro
	 * 		  	metodo que realiza el envio de la trama de pago de giro
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	4/04/2018
	 * *********************************************************************
	 */
	private void pagarGiro() throws Exception{
		
		TipoMotivoGiroInternacional objTipoMotivoGiroInternacional;
		NumeralInternacional objNumeralInternacional;
		
		objTipoMotivoGiroInternacional = (TipoMotivoGiroInternacional) this.castFrmPagoGiroInternacional().getCmbMotivoRemesa().getSelectedItem();
		objNumeralInternacional = (NumeralInternacional) this.castFrmPagoGiroInternacional().getCmbNumerales().getSelectedItem();
		
		this.objFacturaGiroInternacional.setObjTipoMotivoGiroInternacional(objTipoMotivoGiroInternacional);
		this.objFacturaGiroInternacional.setObjNumeralInternacional(objNumeralInternacional);
		this.objFacturaGiroInternacional.setStrTramaSenalesAlerta(this.getStrCadenaSenalesAlerta());
		
		GiroInternacionalVistaLogica.getInstancia().pagarGiro(getObjUsuario(), 
															  EnumPeticionesMultiservicio.GIN_PAGO_GIRO.getObjServicioPeticion(), 
															  this.objFacturaGiroInternacional);
		
		EnumMensajes.GIRO_PAGADO_EXITOSAMENTE.desplegarMensaje(super.getFrmForma(), 
				   											   EnumClasesMensaje.INFORMACION, 
				   											   this.objFacturaGiroInternacional.getStrReferenciaControlExterna());
		
		EnumImpresiones.PAGO_GIRO_INTERNACIONAL.ejecutarImpresion(super.getFrmForma(), 
	  													  		  false,
		  													  	  this.objFacturaGiroInternacional,
		  													  	  super.getObjUsuario(),
		  													  	  EnumPeticionesMultiservicio.GIN_PAGO_GIRO.getObjServicioPeticion());
		
		if (!objFacturaGiroInternacional.getFacturaSeguro().getPin().equals("*")) {
			
			EnumImpresiones.SEGURO_INTERNACIONAL.ejecutarImpresion(super.getFrmForma(), 
				  		 										   false,
				  		 										   this.objFacturaGiroInternacional,
				  		 										   super.getObjUsuario());
		}
		
		if (objFacturaGiroInternacional.isBooEnviaSMS()) {
			EnumImpresiones.SMS_INTERNACIONAL.ejecutarImpresion(super.getFrmForma(), 
															    false,
															    this.objFacturaGiroInternacional,
															    super.getObjUsuario());
		}
		
		
		super.cerrarForma();
		
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
		
		if (this.objFacturaGiroInternacional.getLstSenalesAlerta()!=null) {
			for (SenalAlertaInternacional objSenalAlertaInternacional  : this.objFacturaGiroInternacional.getLstSenalesAlerta()) {
				
				EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
														   EnumClasesMensaje.ADVERTENCIA, 
														   null, 
														   objSenalAlertaInternacional.getStrNombre(), 
														   null);
			}
		}
		
	}

	/**
	 * @method	getObjFacturaGiroInternacional
	 * 		  	Metodo get del atributo objFacturaGiroInternacional
	 * @return	FacturaGiroInternacional
	 *		  	Valor del atributo objFacturaGiroInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	25/03/2018
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
	 * @date	25/03/2018
	 */
	public void setObjFacturaGiroInternacional(FacturaGiroInternacional pObjFacturaGiroInternacional) {
		objFacturaGiroInternacional = pObjFacturaGiroInternacional;
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

	/** 
	 * ********************************************************************
	 * @method	castFrmPagoGiroInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    frmPagoGiroInternacional
	 * @return	FormaPagoGiroInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	25/03/2018
	 * *********************************************************************
	 */
	public FormaPagoGiroInternacional castFrmPagoGiroInternacional()throws Exception{
		return (FormaPagoGiroInternacional)super.getFrmForma();
	}
}
