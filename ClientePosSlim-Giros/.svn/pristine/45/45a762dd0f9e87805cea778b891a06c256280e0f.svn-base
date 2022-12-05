package co.com.codesa.clienteposslimgiros.eventos.terceros;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import co.com.codesa.clientecajams.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslim.controladoretiquetas.ControladorEtiquetas;
import co.com.codesa.clienteposslim.utilidades.Utilidades;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionales;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaActualizarCrearTerceroInternacional;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaPropiedadesPepsInternacional;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUITexto;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesTexto;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGirosInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.internacional.UtilBiometriaInternacional;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.tercero.TerceroInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ActividadEconomica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Cargo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MonedaExtranjera;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ObjetoBasico;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ProductoMonedaExtranjera;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ProfesionInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerritorioInternacional;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TipoDocumentoInternacional;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.tercero.internacional.ConfigTerceroInternacionalDTO;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ********************************************************************
 * @class	EventoFormaActualizarCrearTerceroInternacional
 *		 	Clase encargada de controlar los eventos de la forma para
 *			realizar el mantenimiento del tercero internacional
 * @author	hector.cuenca
 * @date  	26/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaActualizarCrearTerceroInternacional extends EventoAbstracto{
	
	/**
	 * @variable	objTercero
	 * 				Tercero involucrado en el proceso
	 */
	private TerceroInternacional objTercero;
	
	/**
	 * @variable	objTerceroTmp
	 * 				Tercero tempporal para almacenar datos de formas externas
	 * 				cuando el tercero entrante es null
	 */
	private TerceroInternacional objTerceroTmp;
	
	/**
	 * @variable	objDatEntTipoIdentificacion
	 * 				Tipo de identificacion asociado al tercero
	 */
	private TipoDocumentoInternacional objDatEntTipoIdentificacion;
	
	/**
	 * @variable	strIdentificacion
	 * 				Identificacion asociada al tercero
	 */
	private String strIdentificacion;
	
	/**
	 * @variable	strIdTransaccion
	 * 				id transaccion
	 */
	private String strIdTransaccion;
	
	/**
	 * @variable	booTerceroPresente
	 * 				Bandera que identifica si el tercero a realizar el mantenimiento
	 * 				se encuentra presente en el proceso
	 */
	private boolean booTerceroPresente;
	
	/**
	 * @variable	booActvOInfoPeps
	 * 				bandera para indicar si esta activo el cmb de peps
	 */
	private boolean booActvOInfoPeps;
	
	/**
	 * @variable	frmActualizarCrearTerceroInternacional
	 * 				Referencia a la GUI de la cual se estan controlando los eventos
	 */
	private FormaActualizarCrearTerceroInternacional frmActualizarCrearTerceroInternacional;
	
	/**
	 * @variable	objFormaDatosAdicionales
	 * 				objeto de la forma FormaDatosAdicionales, 
	 * 				para la informacion de la empresa y el cargo
	 */
	private FormaDatosAdicionales objFormaDatosAdicionales;
	
	/**
	 * @variable	objFrmPropiedadesPepsInternacional
	 * 				objeto de la forma FormaPropiedadesPepsInternacional
	 * 				para los datos de peps
	 */
	private FormaPropiedadesPepsInternacional objFrmPropiedadesPepsInternacional;
	
	/**
	 * @variable	objDtoConfigTercero
	 * 				Objeto DTO encargado de almacenar toda la configuracion 
  	 *				relacionada con un tercero internacional
	 */
	private ConfigTerceroInternacionalDTO objDtoConfigTercero;
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaActualizarCrearTerceroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			Referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @param 	pBooTerceroPresente
	 * 			Bandera que identifica si el tercero a realizar el mantenimiento
	 * 			se encuentra presente en el proceso
	 * @param 	pObjDatEntTipoId
	 * 			Tipo de identificacion asociado al tercero
	 * @param 	pStrIdentificacion
	 * 			Identificacion asociada al tercero
	 * @param	pObjDtoConfigTercero
	 * 			Objeto DTO encargado de almacenar toda la configuracion 
  	 *			relacionada con un tercero internacional
  	 * @param	pStrIdTransaccion
  	 * 			id transaccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author	hector.cuenca
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	public EventoFormaActualizarCrearTerceroInternacional	(	FormaActualizarCrearTerceroInternacional pForma,
										   						boolean pBooTerceroPresente,
										   						ConfigTerceroInternacionalDTO pObjDtoConfigTercero,
										   						TipoDocumentoInternacional pObjDatEntTipoId,
													  			String pStrIdentificacion,
													  			String pStrIdTransaccion
										   					) 
		throws Exception
	{
		super(pForma);
		this.setFrmActualizarCrearTerceroInternacional(pForma);
		this.setBooTerceroPresente(pBooTerceroPresente);
		this.setObjDatEntTipoIdentificacion(pObjDatEntTipoId);
		this.setStrIdentificacion(pStrIdentificacion);
		this.setObjDtoConfigTercero(pObjDtoConfigTercero);
		this.setStrIdTransaccion(pStrIdTransaccion); 
		booActvOInfoPeps = false;
	}	
	
	/**
	 * ********************************************************************
	 * @method	EventoFormaActualizarCrearTerceroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
	 * @param 	pForma
	 * 			Referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
	 * @param 	pBooTerceroPresente
	 * 			Bandera que identifica si el tercero a realizar el mantenimiento
	 * 			se encuentra presente en el proceso
	 * @param 	pObjTercero
	 * 			Objeto tercero que realiza la transaccion
	 * @param	pStrIdTransaccion
  	 * 			id transaccion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	public EventoFormaActualizarCrearTerceroInternacional	(	FormaActualizarCrearTerceroInternacional pForma,
										   						boolean pBooTerceroPresente,
										   						TerceroInternacional pObjTercero,
													  			String pStrIdTransaccion
										   					) 
		throws Exception
	{
		super(pForma);
		this.setFrmActualizarCrearTerceroInternacional(pForma);
		this.setBooTerceroPresente(pBooTerceroPresente);
		this.setObjTercero(pObjTercero);
		this.setObjDtoConfigTercero(pObjTercero.getObjDtoConfigTerceroInternacional());
		this.setStrIdTransaccion(pStrIdTransaccion); 
		booActvOInfoPeps = false;
	}	
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)
		throws Exception
	{
		this.cargarFormulario();		
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) 
		throws Exception 
	{
		this.getFrmActualizarCrearTerceroInternacional().getTxtPrimerNombre().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getTxtPrimerApellido().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getDtcFechaNacimiento().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getTxtCiudadNacimiento().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getTxtTelefonoFijoCelular().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbPais().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbDepartamento().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbMunicipio().getLblObligatorio().aplicarObligatoriedad(true);
		this.getFrmActualizarCrearTerceroInternacional().getPnlDireccionResidencia().getTxtDescripcion().getLblObligatorio().aplicarObligatoriedad(true);
		
		
		if (this.getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()!= null &&
				this.getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()) {
			
			this.getFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getCmbProfesion().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getCmbOperacionesMonedaExtranjera().getLblObligatorio().aplicarObligatoriedad(true);			
			this.getFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getCmbMonedaExtranjera().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtEntidadExtranjera().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtNumProductoExtranjera().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtDetaVlrOtrosIngresos().getLblObligatorio().aplicarObligatoriedad(true);
			
			this.getFrmActualizarCrearTerceroInternacional().getDtcFechaExpedicion().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getTxtCiudadExpedicion().getLblObligatorio().aplicarObligatoriedad(true);
			this.getFrmActualizarCrearTerceroInternacional().getCmbPEPS().getLblObligatorio().aplicarObligatoriedad(true);
			
			this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CORREO_ELECTRONICO.getValor());
			this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CORREO_ELECTRONICO_TERCERO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_DINERO_GIRO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().getPropiedades().setFormatoSalida(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO());
			
			booActvOInfoPeps = true;
		}
	}
	
	@Override
	public void confirmar() 
		throws Exception 
	{	
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios	(	super.getFrmForma(), 
																		true, 
																		true
																);
		//10/11/2022 Cgamboa Se comenta linea de validacion de correo- soporte 2002159
		//this.validarCorreoFPisa();
		this.validarCampoTextoObligatorio(this.getFrmActualizarCrearTerceroInternacional().getTxtTelefonoFijoCelular());
	
	
		
		if(this.validarEmpresa()){
			if	(	this.getObjTercero()	!=	null	)
			{
				this.actualizarTercero();
			}	else	{
				this.crearTercero();
			}
			
			this.validarBiometria();
			this.crearActualizarTercero();
			
			this.regresarFormaPadre();
		}
		
	}
	
	@Override
	public	void	limpiar()	
			throws Exception 
	{
		CajaFechaUtil dtcCampoFecha;
		
		super.limpiar();
		
		if	(	(dtcCampoFecha	=	this.getFrmActualizarCrearTerceroInternacional().getDtcFechaNacimiento()).isEnabled()	)
		{
			dtcCampoFecha.setDate(null);
		}
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castFrmActualizarCrearTerceroInternacional().getBtnEmpresaSocEcono())){
			
			this.cargarEmpresaDatSocEco();
			
		}else if(pComponent.equals(this.castFrmActualizarCrearTerceroInternacional().getBtnVerInfoPEPS())){
			
			this.cargarInfoPeps();
			
		}else{
			
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void iniciarValoresDatosAdicionales(javax.swing.JPanel pnlSeccionAdicional) throws Exception {
		
		if (pnlSeccionAdicional.equals(this.castFrmActualizarCrearTerceroInternacional().getPnlEmpresaDatAdd())) {
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().getLblObligatorio().aplicarObligatoriedad(true);
			this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().getLblObligatorio().aplicarObligatoriedad(true);
			this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().getLblObligatorio().aplicarObligatoriedad(true);
			this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().getLblObligatorio().aplicarObligatoriedad(true);
			this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().getLblObligatorio().aplicarObligatoriedad(true);
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_NOMBRE_BARRIO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_TELEFONO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
			this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_NOMBRES_TERCERO.getValor());
			
			if	(	this.getObjTercero()	!=	null	)
			{
				this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getNombre());
				this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getDireccion());
				this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getTelefono());
				this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getStrCiudad());
				this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().setText(this.getObjTercero().getObjCargo().getStrNombre());
			}
		}
	}
	
	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.castFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera())){
			
			this.accionCmbManejaOperMonedaExtranjera();
			
		}else if(pComponent.equals(this.castFrmActualizarCrearTerceroInternacional().getCmbPEPS())){
			
			if (booActvOInfoPeps) {
				this.cargarInfoPeps();
			}
			
		} else if(pComponent.equals(this.castFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas())){
				
			this.validarActivacionBotonEmpresa();
			
		}else{
		
			super.accionarCambioItem(pComponent,
					 				 pEvtItemStateChanged);
		}
	}
	
	@Override
	public void accionarIngresoLiberado(Component pComponent,
			KeyEvent pEvtKeyReleased) throws Exception {
		
		if (pComponent.equals(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos())) {
			
			this.validarValorOtrosIngresos();
		}else{
		
			super.accionarIngresoLiberado(pComponent, pEvtKeyReleased);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarValorOtrosIngresos
	 * 		  	Valida el valor del campo de otros ingresos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	6/06/2018
	 * *********************************************************************
	 */
	public void validarValorOtrosIngresos() throws Exception{
		
		if (this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().getText().equals("")) {
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtDetaVlrOtrosIngresos().setEditable(false);
		}else{
			
			this.castFrmActualizarCrearTerceroInternacional().getTxtDetaVlrOtrosIngresos().setEditable(true);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	accionCmbManejaOperMonedaExtranjera
	 * 		  	accion que se ejecuta al seleccional el combo 
	 * 			CmbOperacionesMonedaExtranjera
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	17/05/2018
	 * *********************************************************************
	 */
	public void accionCmbManejaOperMonedaExtranjera() throws Exception{
		
		boolean booHabilita;
		EnumEtiquetas enmEtiquetas = (EnumEtiquetas) this.castFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().getSelectedItem();
		
		if (EnumEtiquetas.LBL_SI.equals(enmEtiquetas)) {
			booHabilita = true;
		}else{
			booHabilita = false;
		}
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbOperacionesMonedaExtranjera().setEnabled(booHabilita);			
		this.getFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().setEditable(booHabilita);
		this.getFrmActualizarCrearTerceroInternacional().getCmbMonedaExtranjera().setEnabled(booHabilita);
		this.getFrmActualizarCrearTerceroInternacional().getTxtEntidadExtranjera().setEditable(booHabilita);
		this.getFrmActualizarCrearTerceroInternacional().getTxtNumProductoExtranjera().setEditable(booHabilita);
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarFormulario
	 * 		  	carga la informacion en el formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	private void cargarFormulario() throws Exception
	{	
		//Objeto temporal
		this.objTerceroTmp = new TerceroInternacional();
		Cargo objCargo = new Cargo();
		objCargo.setStrNombre("");
		Empresa objEmpresa = new Empresa();
		objEmpresa.setNombre("");
		objEmpresa.setDireccion("");
		objEmpresa.setTelefono("");
		objEmpresa.setStrCiudad("");
		
		objCargo.setObjEmpTrabaja(objEmpresa);
		objTerceroTmp.setObjCargo(objCargo);
		//Objeto temporal
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbTipoDocumento().addItem(this.obtenerTipoIdentificacion());
		this.getFrmActualizarCrearTerceroInternacional().getTxtDocumento().setText(this.obtenerIdentificacion());
		
		if (this.getObjDtoConfigTercero().getObjBooActualizaClienteUsuario() != null &&
				this.getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()) {
			
			this.cargarCmbActvEconomicas();
			this.cargarCmbProfesion();
			this.cargarCmbManejaOperMonedaExtranjera();
			this.cargarCmbPEPS();
			this.cargarCmbOperacionesMonedaExtranjera();
			this.cargarCmbMonedaExtranjera();
		}
		
		if	(	this.getObjTercero()	!=	null	)
		{
			this.cargarYBloquear();
			
			this.cargarCiudadResidencia();
			
			this.getFrmActualizarCrearTerceroInternacional().getPnlDireccionResidencia().getTxtDescripcion().setText(this.getObjTercero().getDireccion());
			this.getFrmActualizarCrearTerceroInternacional().getTxtCiudadNacimiento().setText(this.getObjTercero().getStrCiudadNacimiento());
			this.getFrmActualizarCrearTerceroInternacional().getDtcFechaNacimiento().setDate(UtilidadGiros.getInstancia().getFecha(this.getObjTercero().getFechaNacimiento()));
			this.getFrmActualizarCrearTerceroInternacional().getTxtTelefonoFijoCelular().setText(this.getObjTercero().getTelefono1());
			
			if (objTercero.getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario() != null &&
					objTercero.getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario()) {
				
				this.getFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().setText(this.getObjTercero().getDouIngresos()==0?"":UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getObjTercero().getDouIngresos()));
				this.getFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().setText(this.getObjTercero().getDouEgresos()==0?"":UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getObjTercero().getDouEgresos()));
				this.getFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().setText(this.getObjTercero().getDouActivos()==0?"":UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getObjTercero().getDouActivos()));
				this.getFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().setText(this.getObjTercero().getDouPasivos()==0?"":UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getObjTercero().getDouPasivos()));

				this.getFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().setSelectedItem(this.getObjTercero().getActividadEconomica());
				this.getFrmActualizarCrearTerceroInternacional().getCmbProfesion().setSelectedItem(this.getObjTercero().getObjProfesionInternacional());
				
				if(this.getObjTercero().getBooRealizaOperacionesMonedaExtranjera() !=null){
					if (this.getObjTercero().getBooRealizaOperacionesMonedaExtranjera()) {
						this.getFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().setSelectedItem(EnumEtiquetas.LBL_SI);
					}else{
						this.getFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().setSelectedItem(EnumEtiquetas.LBL_NO);
					}
				}
				
				if(this.getObjTercero().getBooPEPs() != null){
					if (this.getObjTercero().getBooPEPs()) {
						this.getFrmActualizarCrearTerceroInternacional().getCmbPEPS().setSelectedItem(EnumEtiquetas.LBL_SI);
					}else{
						this.getFrmActualizarCrearTerceroInternacional().getCmbPEPS().setSelectedItem(EnumEtiquetas.LBL_NO);
					}
				}
				
				if(this.getObjTercero().getDouVlrOtrosIngresos() != 0D){
					this.getFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().setText(UtilidadGiros.getInstancia().formatoPresentacionNumero(this.getObjTercero().getDouVlrOtrosIngresos()));
				}
				
				if(!this.getObjTercero().getStrDetalleOtrosIngresos().equals("*")){
					this.getFrmActualizarCrearTerceroInternacional().getTxtDetaVlrOtrosIngresos().setText(this.getObjTercero().getStrDetalleOtrosIngresos());
				}
				
				if (!this.getObjTercero().getFechaExpedicion().equals("*")) {
					this.getFrmActualizarCrearTerceroInternacional().getDtcFechaExpedicion().setDate(UtilidadGiros.getInstancia().getFecha(this.getObjTercero().getFechaExpedicion()));
				}
				this.getFrmActualizarCrearTerceroInternacional().getTxtCiudadExpedicion().setText(this.getObjTercero().getStrNombreCiudadExpedicionDocumento());
			}
		}
		
		if	(	!this.isBooTerceroPresente()	)
		{
			UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.getFrmActualizarCrearTerceroInternacional().getPnlInfoDocumento(), 
																				  false, 
																				  false, 
																				  false);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarYBloquear
	 * 		  	cargar los datos en los componente y los bloquea
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	private void cargarYBloquear()
		throws Exception
	{
		this.cargarYBloquear(	this.getFrmActualizarCrearTerceroInternacional().getTxtPrimerNombre(),
								this.getObjTercero().getStrNombre1()
							);
		this.cargarYBloquear(	this.getFrmActualizarCrearTerceroInternacional().getTxtSegundoNombre(),
								this.getObjTercero().getStrNombre2()
							);
		this.cargarYBloquear(	this.getFrmActualizarCrearTerceroInternacional().getTxtPrimerApellido(),
								this.getObjTercero().getApellido1()
							);
		this.cargarYBloquear(	this.getFrmActualizarCrearTerceroInternacional().getTxtSegundoApellido(),
								this.getObjTercero().getApellido2()
							);
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarYBloquear
	 * 		  	cargar el dato en el componente y lo bloquea
	 * @param 	pIComponenteGui
	 * 			componente
	 * @param 	pObjValor
	 * 			valor a setear en el componente
	 * @throws 	Exception
	 * 			cargar el dato en el componente y lo bloquea
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	private void cargarYBloquear(	ComponenteGUI pIComponenteGui,
								 	Object pObjValor
								)
		throws Exception
	{
		if	(	pObjValor	!=	null	)
		{
			pIComponenteGui.setValorContenido(pObjValor);
			((Component)pIComponenteGui).setEnabled(false);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbActvEconomicas
	 * 		  	Carga los corresponsales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	24/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbActvEconomicas() throws Exception{
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstActividadesEconomicasInternacional().toArray(), 
								  							  						   		  				 true, 
								  							  						   		  				 null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbProfesion
	 * 		  	Carga los corresponsales
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	24/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbProfesion() throws Exception{
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbProfesion().getPropiedades().cargarCombo(InformacionSessionGirosInternacional.getInstance(getObjUsuario()).getLstProfesionesInternacional().toArray(), 
								  							  						   		  			true, 
								  							  						   		  			null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbManejaOperMonedaExtranjera
	 * 		  	Carga la opcion SI o NO
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbManejaOperMonedaExtranjera() throws Exception{
		
		List<EnumEtiquetas> lstenmEtiquetas = new ArrayList<EnumEtiquetas>();
		
		lstenmEtiquetas.add(EnumEtiquetas.LBL_SI) ;
		lstenmEtiquetas.add(EnumEtiquetas.LBL_NO) ;
		
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().getPropiedades().cargarCombo(lstenmEtiquetas.toArray(), 
								  							  						   		  							 true, 
								  							  						   		  							 null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbPEPS
	 * 		  	Carga la opcion SI o NO
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbPEPS() throws Exception{
		
		List<EnumEtiquetas> lstenmEtiquetas = new ArrayList<EnumEtiquetas>();
		
		lstenmEtiquetas.add(EnumEtiquetas.LBL_SI);
		lstenmEtiquetas.add(EnumEtiquetas.LBL_NO);
		
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbPEPS().getPropiedades().cargarCombo(lstenmEtiquetas.toArray(), 
								  							  						   		  	   true, 
								  							  						   		  	   null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbOperacionesMonedaExtranjera
	 * 		  	Carga la opcion Operaciones Moneda Extranjera
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbOperacionesMonedaExtranjera() throws Exception{
		
		List<ProductoMonedaExtranjera> lstProductoMonedaExtranjera;
		String strValorParametro;
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TIPO_PRODUCTO_MONEDA_EXTRANJERA);
		
		strValorParametro = EnumParametrosSistema.TIPO_PRODUCTO_MONEDA_EXTRANJERA.obtenerValorCadena();
		
		lstProductoMonedaExtranjera = this.obtenerLista(strValorParametro,MonedaExtranjera.class);
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbOperacionesMonedaExtranjera().getPropiedades().cargarCombo(lstProductoMonedaExtranjera.toArray(), 
								  							  						   		  	   						  true, 
								  							  						   		  	   						  null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCmbMonedaExtranjera
	 * 		  	Carga la opcion Operaciones Moneda Extranjera
	 * @throws  Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private void cargarCmbMonedaExtranjera() throws Exception{
		
		List<MonedaExtranjera> lstMonedaExtranjera;
		String strValorParametro;
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.TIPO_MONEDA_EXTRANJERA);
		
		strValorParametro = EnumParametrosSistema.TIPO_MONEDA_EXTRANJERA.obtenerValorCadena();
		
		lstMonedaExtranjera = this.obtenerLista(strValorParametro,MonedaExtranjera.class);
		
		this.getFrmActualizarCrearTerceroInternacional().getCmbMonedaExtranjera().getPropiedades().cargarCombo(lstMonedaExtranjera.toArray(), 
								  							  						   		  	   			   true, 
								  							  						   		  	   			   null);	
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarEmpresaDatSocEco
	 * 		  	carga la forma FormaDatosAdicionales
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
  	 * @return	boolean
  	 * 			bandera boolean indica true si salio de la forma con el 
  	 * 			boton guardar 
	 * @author	roberth.martinez
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	public boolean cargarEmpresaDatSocEco() throws Exception{
		
		
		objFormaDatosAdicionales = new FormaDatosAdicionales(super.getFrmForma(), 
					 										 true, 
					 										 this.castFrmActualizarCrearTerceroInternacional().iniciarPropPnlEmpresaDatAdd());
		
		if(EnumBotonesEncabezado.BTNGUARDAR.equals(objFormaDatosAdicionales.getEnmBotEncAccionSolicitada())){
			return true;
		}
		
		return false;
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarInfoPeps
	 * 		  	Carga la forma FormaPropiedadesPepsInternacional
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	public void cargarInfoPeps() throws Exception{
		
		setObjFrmPropiedadesPepsInternacional(new FormaPropiedadesPepsInternacional(super.getFrmForma(), 
					 										 					    true, 
					 										 					    objTercero==null?objTerceroTmp:objTercero));
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerLista
	 * 		  	llena una lista con el objeto pasado y los datos 
	 * 			suministrados
	 * @param 	pStrCaneda
	 * 			valores a ingresar a la lista
	 * @param 	pObjClase
	 * 			Clase a ingresar a la lista
	 * @return  List
	 * 			lista de tipo de objeto basico
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	@SuppressWarnings("unchecked")
	public <T extends ObjetoBasico> List<T> obtenerLista(String pStrCaneda, Class<? extends ObjetoBasico> pObjClase) throws Exception{
		
		List<T> lstObjetos = new ArrayList<T>();
		String[] arrStrObjetos;
		String[] arrStrDatos;
		T genObjeto;
		
		arrStrObjetos = pStrCaneda.split("\\?");
		
		for (String strObjetos : arrStrObjetos) 
		{
			arrStrDatos = strObjetos.split("\\~");
			
			genObjeto = (T) pObjClase.newInstance();
			
			genObjeto.setStrCodigo(arrStrDatos[0]);
			genObjeto.setStrNombre(arrStrDatos[1]);
			
			lstObjetos.add(genObjeto);
		}
		
		return (List<T>) lstObjetos;
	}
	
	/** 
	 * ********************************************************************
	 * @method	actualizarTercero
	 * 		  	actualiza el tercero usuario cliente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	16/05/2018
	 * *********************************************************************
	 */
	private void actualizarTercero() throws Exception{
		
		String strVlrOtrosIngresos;
		EnumEtiquetas enmEtiquetaEsPeps;
		EnumEtiquetas enmEtiquetaManejaOperMonedaExtrajera;
		TerritorioInternacional objTrrCiudadResidencia;
		MonedaExtranjera objMonedaExtranjera = null;
		MonedaExtranjera objOperMonedaExtranjera = null;
		
		objTercero.setFechaNacimiento(this.castFrmActualizarCrearTerceroInternacional().getDtcFechaNacimiento().toString());
		objTercero.setStrCiudadNacimiento(this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadNacimiento().getText());
		objTercero.setTelefono1(this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoFijoCelular().getText());
		objTrrCiudadResidencia = (TerritorioInternacional) this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbMunicipio().getSelectedItem(); 
		objTercero.setObjTrrCiudadResidencia(objTrrCiudadResidencia);
		objTercero.setDireccion(this.getFrmActualizarCrearTerceroInternacional().getPnlDireccionResidencia().getTxtDescripcion().getText());
		
		if (this.objDtoConfigTercero.getObjBooActualizaClienteUsuario() != null &&
				this.objDtoConfigTercero.getObjBooActualizaClienteUsuario()) {
			//Tercero Cliente
			objTercero.setMail(this.castFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getText().trim());
			objTercero.setFechaExpedicion(this.castFrmActualizarCrearTerceroInternacional().getDtcFechaExpedicion().toString());
			objTercero.setStrNombreCiudadExpedicionDocumento(this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadExpedicion().getText());
			
			objTercero.setDouIngresos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().getText()).doubleValue());
			objTercero.setDouEgresos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().getText()).doubleValue());
			objTercero.setDouActivos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().getText()).doubleValue());
			objTercero.setDouPasivos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().getText()).doubleValue());
			
			objTercero.setActividadEconomica((ActividadEconomica) this.castFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().getSelectedItem());
			objTercero.setObjProfesionInternacional((ProfesionInternacional) this.castFrmActualizarCrearTerceroInternacional().getCmbProfesion().getSelectedItem());
			
			enmEtiquetaManejaOperMonedaExtrajera = (EnumEtiquetas) this.castFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().getSelectedItem();
			objTercero.setBooRealizaOperacionesMonedaExtranjera(EnumEtiquetas.LBL_SI.equals(enmEtiquetaManejaOperMonedaExtrajera));
			
			if (objTercero.getBooRealizaOperacionesMonedaExtranjera()) {
				objMonedaExtranjera = new MonedaExtranjera();
				objOperMonedaExtranjera = (MonedaExtranjera) this.castFrmActualizarCrearTerceroInternacional().getCmbOperacionesMonedaExtranjera().getSelectedItem();
				objMonedaExtranjera.setStrCodigoTipoProducto(objOperMonedaExtranjera.getStrCodigo());
				
				objOperMonedaExtranjera = (MonedaExtranjera) this.castFrmActualizarCrearTerceroInternacional().getCmbMonedaExtranjera().getSelectedItem();
				objMonedaExtranjera.setStrCodigo(objOperMonedaExtranjera.getStrNombre());
				
				objMonedaExtranjera.setDouValor(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().getText()).doubleValue());
				objMonedaExtranjera.setStrEntidad(this.castFrmActualizarCrearTerceroInternacional().getTxtEntidadExtranjera().getText());
				objMonedaExtranjera.setStrNumeroProductos(this.castFrmActualizarCrearTerceroInternacional().getTxtNumProductoExtranjera().getText());
			}
			objTercero.setObjMonedaExtranjera(objMonedaExtranjera);
			
			enmEtiquetaEsPeps = (EnumEtiquetas) this.castFrmActualizarCrearTerceroInternacional().getCmbPEPS().getSelectedItem();
			objTercero.setBooPEPs(EnumEtiquetas.LBL_SI.equals(enmEtiquetaEsPeps));
			
			//Datos Empresa
			if(this.castFrmActualizarCrearTerceroInternacional().getBtnEmpresaSocEcono().isEnabled()){
				objTercero.getObjCargo().setStrNombre(this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().getText());
				objTercero.getObjCargo().getObjEmpTrabaja().setNombre(this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().getText());
				objTercero.getObjCargo().getObjEmpTrabaja().setDireccion(this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().getText());
				objTercero.getObjCargo().getObjEmpTrabaja().setTelefono(this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().getText());
				objTercero.getObjCargo().getObjEmpTrabaja().setStrCiudad(this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().getText());
			}
			strVlrOtrosIngresos = this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().getText();
			objTercero.setDouVlrOtrosIngresos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(strVlrOtrosIngresos.equals("")?"0":strVlrOtrosIngresos).doubleValue());
			objTercero.setStrDetalleOtrosIngresos(this.castFrmActualizarCrearTerceroInternacional().getTxtDetaVlrOtrosIngresos().getText());
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	crearTercero
	 * 		  	crear tercero usuario cliente
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	private void crearTercero()throws Exception{
		
		String strVlrOtrosIngresos;
		TerceroInternacional objTercero;
		TerritorioInternacional objTrrIntCiudadResidencia;
		Cargo objCargo = null;
		Empresa objEmpresa = null;
		MonedaExtranjera objMonedaExtranjera = null;
		MonedaExtranjera objOperMonedaExtranjera = null;
		
		objTercero = objTerceroTmp;
		
		objTercero.setObjDtoConfigTerceroInternacional(this.getObjDtoConfigTercero());
		objTercero.setTipoIdentificacion(this.getObjDatEntTipoIdentificacion());
		objTercero.setIdentificacion(this.getStrIdentificacion());
		objTercero.setStrNombre1(this.getFrmActualizarCrearTerceroInternacional().getTxtPrimerNombre().getText());
		objTercero.setStrNombre2(this.getFrmActualizarCrearTerceroInternacional().getTxtSegundoNombre().getText());
		objTercero.setApellido1(this.getFrmActualizarCrearTerceroInternacional().getTxtPrimerApellido().getText());
		objTercero.setApellido2(this.getFrmActualizarCrearTerceroInternacional().getTxtSegundoApellido().getText());
		
		objTercero.setFechaNacimiento(UtilidadGiros.getInstancia().getFecha(this.getFrmActualizarCrearTerceroInternacional().getDtcFechaNacimiento().getDate(), 
																			UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH()));
		
		objTercero.setStrCiudadNacimiento(this.getFrmActualizarCrearTerceroInternacional().getTxtCiudadNacimiento().getText());
		
		if	(	this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbMunicipio().getSelectedItem() instanceof TerritorioInternacional	)
		{
			objTrrIntCiudadResidencia = (TerritorioInternacional)this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbMunicipio().getSelectedItem();
			
		}	else	{
			
			objTrrIntCiudadResidencia = null;
		}
		
		objTercero.setObjTrrCiudadResidencia(objTrrIntCiudadResidencia);
		objTercero.setDireccion(this.getFrmActualizarCrearTerceroInternacional().getPnlDireccionResidencia().getTxtDescripcion().getText());
		objTercero.setTelefono1(this.getFrmActualizarCrearTerceroInternacional().getTxtTelefonoFijoCelular().getText().trim());
		
		
		EnumEtiquetas enmEtiquetaEsPeps;
		EnumEtiquetas enmEtiquetaManejaOperMonedaExtrajera;
		
		// revisar solo para cliente

		if (objDtoConfigTercero.getObjBooActualizaClienteUsuario() != null &&
				objDtoConfigTercero.getObjBooActualizaClienteUsuario()) {
			
			//Tercero Cliente
			objTercero.setMail(this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getText().trim());
			objTercero.setFechaExpedicion(this.castFrmActualizarCrearTerceroInternacional().getDtcFechaExpedicion().toString());
			objTercero.setStrNombreCiudadExpedicionDocumento(this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadExpedicion().getText());
			
			objTercero.setDouIngresos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrIngresoMensual().getText()).doubleValue());
			objTercero.setDouEgresos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrEgresoMensualActivos().getText()).doubleValue());
			objTercero.setDouActivos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrActivos().getText()).doubleValue());
			objTercero.setDouPasivos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtVlrPasivos().getText()).doubleValue());
			
			objTercero.setActividadEconomica((ActividadEconomica) this.castFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().getSelectedItem());
			objTercero.setObjProfesionInternacional((ProfesionInternacional) this.castFrmActualizarCrearTerceroInternacional().getCmbProfesion().getSelectedItem());
			
			enmEtiquetaManejaOperMonedaExtrajera = (EnumEtiquetas) this.castFrmActualizarCrearTerceroInternacional().getCmbManejaOperMonedaExtranjera().getSelectedItem();
			objTercero.setBooRealizaOperacionesMonedaExtranjera(EnumEtiquetas.LBL_SI.equals(enmEtiquetaManejaOperMonedaExtrajera));
			
			if (objTercero.getBooRealizaOperacionesMonedaExtranjera()) {
				objMonedaExtranjera = new MonedaExtranjera();
				objOperMonedaExtranjera = (MonedaExtranjera) this.castFrmActualizarCrearTerceroInternacional().getCmbOperacionesMonedaExtranjera().getSelectedItem();
				objMonedaExtranjera.setStrCodigoTipoProducto(objOperMonedaExtranjera.getStrCodigo());
				
				objOperMonedaExtranjera = (MonedaExtranjera) this.castFrmActualizarCrearTerceroInternacional().getCmbMonedaExtranjera().getSelectedItem();
				objMonedaExtranjera.setStrCodigo(objOperMonedaExtranjera.getStrNombre());
				
				objMonedaExtranjera.setDouValor(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(this.castFrmActualizarCrearTerceroInternacional().getTxtValorIngresoExt().getText()).doubleValue());
				objMonedaExtranjera.setStrEntidad(this.castFrmActualizarCrearTerceroInternacional().getTxtEntidadExtranjera().getText());
				objMonedaExtranjera.setStrNumeroProductos(this.castFrmActualizarCrearTerceroInternacional().getTxtNumProductoExtranjera().getText());
			}
			objTercero.setObjMonedaExtranjera(objMonedaExtranjera);
			
			enmEtiquetaEsPeps = (EnumEtiquetas) this.castFrmActualizarCrearTerceroInternacional().getCmbPEPS().getSelectedItem();
			objTercero.setBooPEPs(EnumEtiquetas.LBL_SI.equals(enmEtiquetaEsPeps));
			
			if (this.castFrmActualizarCrearTerceroInternacional().getBtnEmpresaSocEcono().isEnabled()) {
				//Datos empresa
				objCargo = new Cargo();
				objCargo.setStrNombre(this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().getText());
				
				objEmpresa = new Empresa();
				objEmpresa.setNombre(this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().getText());
				objEmpresa.setDireccion(this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().getText());
				objEmpresa.setTelefono(this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().getText());
				objEmpresa.setStrCiudad(this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().getText());
				
				objCargo.setObjEmpTrabaja(objEmpresa);
				objTercero.setObjCargo(objCargo);
			}
			
			//Datos Peps
			//la comente por que ya se usa un objTerceroTmp que tiene los datos de peps y empresa.
			//objFrmPropiedadesPepsInternacional.castEvtfrmPropiedadesPepsInternacional().setearInfoPEPS(objTercero);
			
			strVlrOtrosIngresos = this.castFrmActualizarCrearTerceroInternacional().getTxtVlrOtrosIngresos().getText();
			objTercero.setDouVlrOtrosIngresos(UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().parse(strVlrOtrosIngresos.equals("")?"0":strVlrOtrosIngresos).doubleValue());
			objTercero.setStrDetalleOtrosIngresos(this.castFrmActualizarCrearTerceroInternacional().getTxtDetaVlrOtrosIngresos().getText());
		}
		
		this.setObjTercero(objTercero);
		
		//super.regresarFormaPadre();
		
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarActivacionBotonEmpresa
	 * 		  	valida la activacion del boton empresa, dependiendo la 
	 * 			actividad economica 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	15/08/2018
	 * *********************************************************************
	 */
	public void validarActivacionBotonEmpresa() throws Exception{
		
		ActividadEconomica objActividadEconomica;
		TerceroInternacional objTerceroUso = objTercero==null?objTerceroTmp:objTercero;
		
		if (!this.castFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().getSelectedItem().equals(EnumEtiquetas.LBL_NO_SELECCIONADO)){
			
			objActividadEconomica = (ActividadEconomica) this.castFrmActualizarCrearTerceroInternacional().getCmbActvEconomicas().getSelectedItem();
			//System.out.println("Actividad Economica ==> " + objActividadEconomica.getCodigo());
			
			if (objActividadEconomica.getCodigo().equals("9881") || 
				objActividadEconomica.getCodigo().equals("9882") ||
				objActividadEconomica.getCodigo().equals("9883")){
				
				this.castFrmActualizarCrearTerceroInternacional().getBtnEmpresaSocEcono().setEnabled(false);
				
				objTerceroUso.getObjCargo().getObjEmpTrabaja().setNombre("NO APLICA");
				objTerceroUso.getObjCargo().getObjEmpTrabaja().setDireccion("NO APLICA");
				objTerceroUso.getObjCargo().getObjEmpTrabaja().setTelefono("NO APLICA");
				objTerceroUso.getObjCargo().getObjEmpTrabaja().setStrCiudad("NO APLICA");
				objTerceroUso.getObjCargo().setStrNombre("NO APLICA");
				
				/*if (this.getObjTercero() != null) {
					
					this.getObjTercero().getObjCargo().getObjEmpTrabaja().setNombre("NO APLICA");
					this.getObjTercero().getObjCargo().getObjEmpTrabaja().setDireccion("NO APLICA");
					this.getObjTercero().getObjCargo().getObjEmpTrabaja().setTelefono("NO APLICA");
					this.getObjTercero().getObjCargo().getObjEmpTrabaja().setStrCiudad("NO APLICA");
					this.getObjTercero().getObjCargo().setStrNombre("NO APLICA");
				}else{
					//Datos empresa
					Cargo objCargo = new Cargo();
					objCargo.setStrNombre(this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().getText());
					
					Empresa objEmpresa = new Empresa();
					objEmpresa.setNombre(this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().getText());
					objEmpresa.setDireccion(this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().getText());
					objEmpresa.setTelefono(this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().getText());
					objEmpresa.setStrCiudad(this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().getText());
					
					objCargo.setObjEmpTrabaja(objEmpresa);
					objTerceroTmp.setObjCargo(objCargo);
				}*/
				
			} else {
				
				this.castFrmActualizarCrearTerceroInternacional().getBtnEmpresaSocEcono().setEnabled(true);
				
				/*if (this.getObjTercero() != null) {
					if(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getNombre().equals("NO APLICA")){
						this.getObjTercero().getObjCargo().getObjEmpTrabaja().setNombre("");
					}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa() != null) {
						this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getNombre());
					}
					if (this.getObjTercero().getObjCargo().getObjEmpTrabaja().getDireccion().equals("NO APLICA")){
						this.getObjTercero().getObjCargo().getObjEmpTrabaja().setDireccion("");
					}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa() != null) {
						this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getDireccion());
					}
					if (this.getObjTercero().getObjCargo().getObjEmpTrabaja().getTelefono().equals("NO APLICA")){
						this.getObjTercero().getObjCargo().getObjEmpTrabaja().setTelefono("");
					}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa() != null) {
						this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getTelefono());
					}
					if (this.getObjTercero().getObjCargo().getObjEmpTrabaja().getStrCiudad().equals("NO APLICA")){
						this.getObjTercero().getObjCargo().getObjEmpTrabaja().setStrCiudad("");
					}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa() != null) {
						
						this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().setText(this.getObjTercero().getObjCargo().getObjEmpTrabaja().getStrCiudad());
					}
					if (this.getObjTercero().getObjCargo().getStrNombre().equals("NO APLICA")){
						this.getObjTercero().getObjCargo().setStrNombre("");
					}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa() != null) {
						this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().setText(this.getObjTercero().getObjCargo().getStrNombre());
					}
				}*/
				
				//System.out.println(" tercero "+objTerceroUso.toString());
				//System.out.println(" cargo "+objTerceroUso.getObjCargo().toString());

				//CGAMBOA -- 17/11/2022 -- Se adiciona validaciones, para evitar el Nullpointer
				boolean boolNombre = true;
				if(objTerceroUso.getObjCargo().getObjEmpTrabaja().getNombre()== null) 
				{
					boolNombre = false;
				}
				
				if (boolNombre) {
				if(objTerceroUso.getObjCargo().getObjEmpTrabaja().getNombre().equals("NO APLICA")){
					objTerceroUso.getObjCargo().getObjEmpTrabaja().setNombre("");
				}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa() != null) {
					this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().setText(objTerceroUso.getObjCargo().getObjEmpTrabaja().getNombre());
				}}
				
				boolean boolDireccion = true;
				if(objTerceroUso.getObjCargo().getObjEmpTrabaja().getDireccion()== null) 
				{
					boolDireccion = false;
				}
				
				if(boolDireccion) {
				if (objTerceroUso.getObjCargo().getObjEmpTrabaja().getDireccion().equals("NO APLICA")){
					objTerceroUso.getObjCargo().getObjEmpTrabaja().setDireccion("");
				}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa() != null) {
					this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().setText(objTerceroUso.getObjCargo().getObjEmpTrabaja().getDireccion());
				}}
				
				boolean boolTelefono = true;
				if(objTerceroUso.getObjCargo().getObjEmpTrabaja().getTelefono()== null) 
				{
					boolTelefono = false;
				}
				
				if(boolTelefono) {
				if (objTerceroUso.getObjCargo().getObjEmpTrabaja().getTelefono().equals("NO APLICA")){
					objTerceroUso.getObjCargo().getObjEmpTrabaja().setTelefono("");
				}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa() != null) {
					this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().setText(objTerceroUso.getObjCargo().getObjEmpTrabaja().getTelefono());
				}}
				
				boolean boolStrCiudad = true;
				if(objTerceroUso.getObjCargo().getObjEmpTrabaja().getStrCiudad()== null) 
				{
					boolStrCiudad = false;
				}
				
				if(boolStrCiudad) {
				if (objTerceroUso.getObjCargo().getObjEmpTrabaja().getStrCiudad().equals("NO APLICA")){
					objTerceroUso.getObjCargo().getObjEmpTrabaja().setStrCiudad("");
				}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa() != null) {
					
					this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().setText(objTerceroUso.getObjCargo().getObjEmpTrabaja().getStrCiudad());
				}}
				
				boolean boolNombreCargo = true;
				if(objTerceroUso.getObjCargo().getStrNombre()== null) 
				{
					boolNombreCargo = false;
				}
				
				if (boolNombreCargo) {
				if (objTerceroUso.getObjCargo().getStrNombre().equals("NO APLICA")){
					objTerceroUso.getObjCargo().setStrNombre("");
				}else if (this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa() != null) {
					this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().setText(objTerceroUso.getObjCargo().getStrNombre());
				}}
				
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarEmpresa
	 * 		  	valida si esta diligenciado los datos de la empresa
	 * @return 	boolean
	 * 			bandera que indica true si los datos de la empresa estan 
	 * 			diligenciados
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	29/05/2018
	 * *********************************************************************
	 */
	public boolean validarEmpresa() throws Exception{
		
		boolean booEmpresaDiligenciada;
		
		if (this.getObjDtoConfigTercero().getObjBooActualizaClienteUsuario()) {
			//Datos Empresa
			if (this.castFrmActualizarCrearTerceroInternacional().getBtnEmpresaSocEcono().isEnabled() &&
					(this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa() == null ||
					this.castFrmActualizarCrearTerceroInternacional().getTxtCargoEmpresa().getText().equals("") ||
					this.castFrmActualizarCrearTerceroInternacional().getTxtNombreEmpresa().getText().equals("") ||
					this.castFrmActualizarCrearTerceroInternacional().getTxtDireccionEmpresa().getText().equals("") ||
					this.castFrmActualizarCrearTerceroInternacional().getTxtTelefonoEmpresa().getText().equals("") ||
					this.castFrmActualizarCrearTerceroInternacional().getTxtCiudadEmpresa().getText().equals(""))) {
				
				//Mensaje que hace falta diligenciar empresa y abre ventana.
				
				if(this.cargarEmpresaDatSocEco()){
					booEmpresaDiligenciada = true;
				}else{
					booEmpresaDiligenciada = false;
					EnumMensajes.DEBE_DILIGENCIAR_DATOS_EMPRESA.desplegarMensaje(this.getFrmForma(), 
			   	   			 													 EnumClasesMensaje.ADVERTENCIA);
				}
			}else{
				booEmpresaDiligenciada = true;
			}
		}else{
			booEmpresaDiligenciada = true;
		}
		return booEmpresaDiligenciada;
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarBiometria
	 * 		  	realiza el llamado a la utilidad de biometria
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	22/05/2018
	 * *********************************************************************
	 */
	private void validarBiometria() throws Exception{
		
		boolean booProcesoValidarTercero = UtilBiometriaInternacional.getInstancia().validarBiometria	(	this.objTercero, 
																											this.getFrmForma(), 
																											this.strIdTransaccion);
		if (!booProcesoValidarTercero) {
			
			throw EnumMensajes.BIO_DEBE_VALIDAR_BIOMETRIA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarCorreoFpisa
	 * 		  	valida el formato y los caracteres contenidos en un correo
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	Monica Llano
	 * @date	19/11/2019
	 * *********************************************************************
	 */
	private void validarCorreoFPisa() throws Exception{																							
																											
		/*if (this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getText() != null) {
			this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getPropiedades().validaFormatoFinal(true,this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getText());
			Utilidades.cantidadDigitosValidos("El correo electrónico ingresado no debe superar los 100 caracteres", this.getFrmActualizarCrearTerceroInternacional().getTxtCorreoElectronico().getText(), 100);	
			
		}*/
	}
	

	/** 
	 * ********************************************************************
	 * @method	crearActualizarTercero
	 * 		  	envia trama de crear o actualizar tercero
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	29/05/2018
	 * *********************************************************************
	 */
	private void crearActualizarTercero() throws Exception{
		
		if (this.objTercero.getObjDtoConfigTerceroInternacional().getObjBooActualizaClienteUsuario()){
			
			TerceroInternacionalVistaLogica.getInstancia().crearActualizarTerceroCliente(	this.getFrmForma().getObjUsuario(), 
																							EnumPeticionesMultiservicio.GIN_CREAR_ACTUALIZAR_TERCERO_CLIENTE.getObjServicioPeticion(), 
																							this.objTercero, 
																							
																							this.getStrIdTransaccion());
		}else{
			
			TerceroInternacionalVistaLogica.getInstancia().crearActualizarTerceroUsuario(	this.getFrmForma().getObjUsuario(), 
																							EnumPeticionesMultiservicio.GIN_CREAR_ACTUALIZAR_TERCERO_USUARIO.getObjServicioPeticion(), 
																							this.objTercero, 
																							this.getStrIdTransaccion());
		}
		
		
		EnumMensajes.TERCERO_CREADO_ACTUALIZADO_EXITOSO.desplegarMensaje(this.getFrmForma(), 
														   	   			 EnumClasesMensaje.INFORMACION);
		
		this.objTercero.getObjDtoConfigTerceroInternacional().setBooEnviaTramaActualizaTercero(false);
	}
	
	/** 
	 * ********************************************************************
	 * @method	validarCampoTextoObligatorio
	 * 		  	valida texto obligatorio
	 * @param 	pCompTextoUtil
	 * 			componente de texto
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	29/05/2018
	 * *********************************************************************
	 */
	private void validarCampoTextoObligatorio(ComponenteGUITexto pCompTextoUtil)
		throws Exception
	{	
		JTextComponent objCmpTexto;
		
		objCmpTexto = (JTextComponent)pCompTextoUtil;
		
		if	(	objCmpTexto.isEnabled() 
				&&	objCmpTexto.isEditable()
			)
		{
			pCompTextoUtil.getPropiedades().validaFormatoFinal	(	true,
																	((ComponentesObligatorios)pCompTextoUtil).getLblObligatorio().getEnmEtiNombreCampo().toString()
																);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method	cargarCiudadResidencia
	 * 		  	carga la ciudad de residencia
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	private void cargarCiudadResidencia()
		throws Exception
	{
		Territorio objTrrPais;
		Territorio objTrrDepartamento;
		Territorio objTrrMunicipio;
		
		objTrrMunicipio = this.getObjTercero().getObjTrrCiudadResidencia();
		objTrrDepartamento = objTrrMunicipio.getTerritorioPadre();
		objTrrPais = objTrrDepartamento.getTerritorioPadre();
		
		this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbPais().setSelectedItem(objTrrPais);
		this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbDepartamento().setSelectedItem(objTrrDepartamento);
		this.getFrmActualizarCrearTerceroInternacional().getPnlTerritorioResidencia().getCmbMunicipio().setSelectedItem(objTrrMunicipio);
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerIdentificacion
	 * 		  	obtiene la identificacion
	 * @return	String
	 * 			identificacion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	private String obtenerIdentificacion()throws Exception{
		
		String strIdentificacion;
		
		if(this.getObjTercero() != null){
			strIdentificacion = this.getObjTercero().getIdentificacion();
		}else{
			strIdentificacion = this.getStrIdentificacion();
		}
		
		return strIdentificacion;
	}
	
	/** 
	 * ********************************************************************
	 * @method	obtenerTipoIdentificacion
	 * 		  	obtener tipo identificacion
	 * @return	TipoDocumentoInternacional
	 * 			tipo identificacion del tercero
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		    presentada
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 * *********************************************************************
	 */
	private TipoDocumentoInternacional obtenerTipoIdentificacion()throws Exception{
		
		TipoDocumentoInternacional objDatEntTipoIdentificacion;
		
		if(this.getObjTercero() != null){
			objDatEntTipoIdentificacion = (TipoDocumentoInternacional)this.getObjTercero().getTipoIdentificacion();
		}else{
			objDatEntTipoIdentificacion = this.getObjDatEntTipoIdentificacion();
		}
		
		return objDatEntTipoIdentificacion;
	}

	/**
	 * @method	getObjTercero
	 * 		  	Metodo get del atributo objTercero
	 * @return	TerceroInternacional
	 *		  	Valor del atributo objTercero devuelto
	 * @author	roberth.martinez
	 * @date  	21/05/2018
	 */
	public TerceroInternacional getObjTercero() {
		return this.objTercero;
	}

	/**
	 * @method	setObjTercero
	 * 		  	Metodo set del atributo objTercero
	 * @param	pObjTercero
	 * 			Valor que tomara el atributo objTercero
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 */
	public void setObjTercero(TerceroInternacional pObjTercero) {
		this.objTercero = pObjTercero;
	}

	/**
	 * @method	getObjDatEntTipoIdentificacion
	 * 		  	Metodo get del atributo objDatEntTipoIdentificacion
	 * @return	TipoDocumentoInternacional
	 *		  	Valor del atributo objDatEntTipoIdentificacion devuelto
	 * @author	roberth.martinez
	 * @date  	21/05/2018
	 */
	public TipoDocumentoInternacional getObjDatEntTipoIdentificacion() {
		return this.objDatEntTipoIdentificacion;
	}

	/**
	 * @method	setObjDatEntTipoIdentificacion
	 * 		  	Metodo set del atributo objDatEntTipoIdentificacion
	 * @param	pObjDatEntTipoIdentificacion
	 * 			Valor que tomara el atributo objDatEntTipoIdentificacion
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 */
	public void setObjDatEntTipoIdentificacion(
			TipoDocumentoInternacional pObjDatEntTipoIdentificacion) {
		this.objDatEntTipoIdentificacion = pObjDatEntTipoIdentificacion;
	}

	/**
	 * @method	getStrIdentificacion
	 * 		  	Metodo get del atributo strIdentificacion
	 * @return	String
	 *		  	Valor del atributo strIdentificacion devuelto
	 * @author	roberth.martinez
	 * @date  	21/05/2018
	 */
	public String getStrIdentificacion() {
		return this.strIdentificacion;
	}

	/**
	 * @method	setStrIdentificacion
	 * 		  	Metodo set del atributo strIdentificacion
	 * @param	pStrIdentificacion
	 * 			Valor que tomara el atributo strIdentificacion
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 */
	public void setStrIdentificacion(String pStrIdentificacion) {
		this.strIdentificacion = pStrIdentificacion;
	}

	/**
	 * @method	isBooTerceroPresente
	 * 		  	Metodo get del atributo booTerceroPresente
	 * @return	boolean
	 *		  	Valor del atributo booTerceroPresente devuelto
	 * @author	roberth.martinez
	 * @date  	21/05/2018
	 */
	public boolean isBooTerceroPresente() {
		return this.booTerceroPresente;
	}

	/**
	 * @method	setBooTerceroPresente
	 * 		  	Metodo set del atributo booTerceroPresente
	 * @param	pBooTerceroPresente
	 * 			Valor que tomara el atributo booTerceroPresente
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 */
	public void setBooTerceroPresente(boolean pBooTerceroPresente) {
		this.booTerceroPresente = pBooTerceroPresente;
	}

	/**
	 * @method	getObjFormaDatosAdicionales
	 * 		  	Metodo get del atributo objFormaDatosAdicionales
	 * @return	FormaDatosAdicionales
	 *		  	Valor del atributo objFormaDatosAdicionales devuelto
	 * @author	roberth.martinez
	 * @date  	21/05/2018
	 */
	public FormaDatosAdicionales getObjFormaDatosAdicionales() {
		return this.objFormaDatosAdicionales;
	}

	/**
	 * @method	setObjFormaDatosAdicionales
	 * 		  	Metodo set del atributo objFormaDatosAdicionales
	 * @param	pObjFormaDatosAdicionales
	 * 			Valor que tomara el atributo objFormaDatosAdicionales
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 */
	public void setObjFormaDatosAdicionales(
			FormaDatosAdicionales pObjFormaDatosAdicionales) {
		this.objFormaDatosAdicionales = pObjFormaDatosAdicionales;
	}

	/**
	 * @method	getFrmActualizarCrearTerceroInternacional
	 * 		  	Metodo get del atributo frmActualizarCrearTerceroInternacional
	 * @return	FormaActualizarCrearTerceroInternacional
	 *		  	Valor del atributo frmActualizarCrearTerceroInternacional devuelto
	 * @author	hector.cuenca
	 * @date  	26/03/2018
	 */
	public FormaActualizarCrearTerceroInternacional getFrmActualizarCrearTerceroInternacional() {
		return this.frmActualizarCrearTerceroInternacional;
	}

	/**
	 * @method	setFrmActualizarCrearTerceroInternacional
	 * 		  	Metodo set del atributo frmActualizarCrearTerceroInternacional
	 * @param	pFrmActualizarCrearTerceroInternacional
	 * 			Valor que tomara el atributo frmActualizarCrearTerceroInternacional
	 * @author	hector.cuenca
	 * @date	26/03/2018
	 */
	public void setFrmActualizarCrearTerceroInternacional(
			FormaActualizarCrearTerceroInternacional pFrmActualizarCrearTerceroInternacional) {
		this.frmActualizarCrearTerceroInternacional = pFrmActualizarCrearTerceroInternacional;
	}

	/**
	 * @method	getObjDtoConfigTercero
	 * 		  	Metodo get del atributo objDtoConfigTercero
	 * @return	ConfigTerceroInternacionalDTO
	 *		  	Valor del atributo objDtoConfigTercero devuelto
	 * @author	hector.cuenca
	 * @date  	28/03/2018
	 */
	public ConfigTerceroInternacionalDTO getObjDtoConfigTercero() {
		return objDtoConfigTercero;
	}

	/**
	 * @method	setObjDtoConfigTercero
	 * 		  	Metodo set del atributo objDtoConfigTercero
	 * @param	pObjDtoConfigTercero
	 * 			Valor que tomara el atributo objDtoConfigTercero
	 * @author	hector.cuenca
	 * @date	28/03/2018
	 */
	public void setObjDtoConfigTercero(ConfigTerceroInternacionalDTO pObjDtoConfigTercero) {
		this.objDtoConfigTercero = pObjDtoConfigTercero;
	}
	
	/**
	 * @method	getObjFrmPropiedadesPepsInternacional
	 * 		  	Metodo get del atributo objFrmPropiedadesPepsInternacional
	 * @return	FormaPropiedadesPepsInternacional
	 *		  	Valor del atributo objFrmPropiedadesPepsInternacional devuelto
	 * @author	roberth.martinez
	 * @date  	21/05/2018
	 */
	public FormaPropiedadesPepsInternacional getObjFrmPropiedadesPepsInternacional() {
		return objFrmPropiedadesPepsInternacional;
	}

	/**
	 * @method	setObjFrmPropiedadesPepsInternacional
	 * 		  	Metodo set del atributo objFrmPropiedadesPepsInternacional
	 * @param	pObjFrmPropiedadesPepsInternacional
	 * 			Valor que tomara el atributo objFrmPropiedadesPepsInternacional
	 * @author	roberth.martinez
	 * @date	21/05/2018
	 */
	public void setObjFrmPropiedadesPepsInternacional(
			FormaPropiedadesPepsInternacional pObjFrmPropiedadesPepsInternacional) {
		this.objFrmPropiedadesPepsInternacional = pObjFrmPropiedadesPepsInternacional;
	}

	/**
	 * @method	isBooActvOInfoPeps
	 * 		  	Metodo get del atributo booActvOInfoPeps
	 * @return	boolean
	 *		  	Valor del atributo booActvOInfoPeps devuelto
	 * @author	roberth.martinez
	 * @date  	22/05/2018
	 */
	public boolean isBooActvOInfoPeps() {
		return booActvOInfoPeps;
	}

	/**
	 * @method	setBooActvOInfoPeps
	 * 		  	Metodo set del atributo booActvOInfoPeps
	 * @param	pBooActvOInfoPeps
	 * 			Valor que tomara el atributo booActvOInfoPeps
	 * @author	roberth.martinez
	 * @date	22/05/2018
	 */
	public void setBooActvOInfoPeps(boolean pBooActvOInfoPeps) {
		this.booActvOInfoPeps = pBooActvOInfoPeps;
	}

	/**
	 * @method	getStrIdTransaccion
	 * 		  	Metodo get del atributo strIdTransaccion
	 * @return	String
	 *		  	Valor del atributo strIdTransaccion devuelto
	 * @author	roberth.martinez
	 * @date  	22/05/2018
	 */
	public String getStrIdTransaccion() {
		return strIdTransaccion;
	}

	/**
	 * @method	setStrIdTransaccion
	 * 		  	Metodo set del atributo strIdTransaccion
	 * @param	pStrIdTransaccion
	 * 			Valor que tomara el atributo strIdTransaccion
	 * @author	roberth.martinez
	 * @date	22/05/2018
	 */
	public void setStrIdTransaccion(String pStrIdTransaccion) {
		this.strIdTransaccion = pStrIdTransaccion;
	}

	/** 
	 * ********************************************************************
	 * @method	castFrmActualizarCrearTerceroInternacional
	 * 		  	Metodo estandar para formatear el tipo de dato general a 
  	 * 		    un tipo especifico ("Casteo"), del atributo 
  	 * 		    frmActualizarCrearTerceroInternacional
	 * @return	FormaPagoGiroInternacional
  	 * 		   	valor especifico recuperado
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	03/05/2018
	 * *********************************************************************
	 */
	public FormaActualizarCrearTerceroInternacional castFrmActualizarCrearTerceroInternacional()throws Exception{
		return (FormaActualizarCrearTerceroInternacional)super.getFrmForma();
	}

	/**
	 * @method	getObjTerceroTmp
	 * 		  	Metodo get del atributo objTerceroTmp
	 * @return	TerceroInternacional
	 *		  	Valor del atributo objTerceroTmp devuelto
	 * @author	roberth.martinez
	 * @date  	15/08/2018
	 */
	public TerceroInternacional getObjTerceroTmp() {
		return objTerceroTmp;
	}

	/**
	 * @method	setObjTerceroTmp
	 * 		  	Metodo set del atributo objTerceroTmp
	 * @param	pObjTerceroTmp
	 * 			Valor que tomara el atributo objTerceroTmp
	 * @author	roberth.martinez
	 * @date	15/08/2018
	 */
	public void setObjTerceroTmp(TerceroInternacional pObjTerceroTmp) {
		this.objTerceroTmp = pObjTerceroTmp;
	}
	
}
