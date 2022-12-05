package co.com.codesa.clienteposslimgiros.utilidades.validaciones;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumProductos;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.superCombo.SuperComboVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaSeguro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Producto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SuperCombo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;


/** 
 * ********************************************************************
 * @class  ValidacionesSuperCombo
 *		   Clase implementada con patron de diseño singleton, que 
 *         permite acceder a las diferentes funcionalidades del proceso
 *         de negocio de SuperCombo
 * @author roberth.martinez
 * @date   25/05/2015
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class ValidacionesSuperCombo {
	
	/**
	 * @variable: instancia, atributo que vuelve estatico los accesos 
	 * 			  hacia las funciones que agrupa la clase de 
	 * 			  ValidacionesSuperCombo
	 **/
	private static ValidacionesSuperCombo instancia;

	/**
	 * @variable objDocumentoSeg
	 * 			 objeto del documento de seguro
	 */
	private Documento objDocumentoSeg;
	
	/**
	 * @variable objSuperCombo
	 * 			 objeto de la clase SuperCombo
	 */
	private static SuperCombo objSuperCombo;
	
	/** 
	 * ********************************************************************
	 * @method ValidacionesSuperCombo
	 * 		   metodo constructor de la clase ValidacionesSuperCombo
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private ValidacionesSuperCombo() {}
	
	
	/** 
	 * ********************************************************************
	 * @method getInstance
	 * 		   Metodo encargado de controlar e inicializar la  instancia de 
	 * 	       la clase, para instanciarla una unica vez durante todo el 
	 *         ciclo de vida de la aplicacion (patron singleton)
  	 * @return ValidacionesSuperCombo
  	 *         tipo de obj que representa a la clase misma
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public static ValidacionesSuperCombo getInstance(){
		
		if(instancia==null){
			instancia = new ValidacionesSuperCombo();
			objSuperCombo = new SuperCombo();
		}
		
		return instancia;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarSuperCombo
	 * 		   Metodo que valida si un cajero tiene habilitado el
  	 * 		   producto de SuperCombo
	 * @param  pFrame
	 * 		   frame desde la cual se invoca la validacion
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public void validarSuperCombo(JFrame pFrame){
		try{
			
			this.validarProductoActivo();
			
			//this.validarMostrarVentanaDespuesLogin(pFrame);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarMostrarVentanaDespuesLogin
	 * 		   Metodo que valida si se muestra la venta de recordatorio
  	 *  	   de supercombo despues del login
  	 * 		   Se deja de utilizar el metodo por el ticket 380949, 
  	 * 		   no se muestra la ventana de ayuda en el login
	 * @param  pFrame
	 * 		   frame desde la cual se invoa la validacion
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void validarMostrarVentanaDespuesLogin(JFrame pFrame){
		/*try{
			
			String strActivoSuperCombo;
			String strMuestraVentana;
			
			if (InformacionSessionGiros.getInstance().getObjUsuario().isBooSuperComboActivo()) {
				
				UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.SUPERCOMBO_ACTIVO,
															  EnumParametrosSistema.SUPERCOMBO_VENTANA_LOGIN);
				
				strActivoSuperCombo = EnumParametrosSistema.SUPERCOMBO_ACTIVO.obtenerValor().getValor();
				strMuestraVentana = EnumParametrosSistema.SUPERCOMBO_VENTANA_LOGIN.obtenerValor().getValor(); 
				
				if (strActivoSuperCombo.equalsIgnoreCase("SI")) {
					
					if (strMuestraVentana.equalsIgnoreCase("SI")) {
						
						EnumOperacionesAyuda.SUPER_COMBO.filtrarSeccionesXId(1);
						
						new FormaAyuda(pFrame,
								   	   true,
								   	   EnumEtiquetas.TTL_SCO_VENTANA.getValor(false),
								   	   EnumAyudas.SUPER_COMBO,
								   	   EnumOperacionesAyuda.SUPER_COMBO,
								   	   null);
					}
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarProductoActivo
	 * 		   Metodo encargado de validar si el cajero tiene activo
  	 * 		   el producto de SuperCombo
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void validarProductoActivo(){
		try {
			
			//this.cargarParametrosSistema();
			
			//if (this.validarVentaSMS()) {
				
				if (this.validarVentaSeguro()) {
					
					this.activaDesactivaSuperCombo(true);
					
				}else {
					this.activaDesactivaSuperCombo(false);
				}
				
			/*}else {
				
				this.activaDesactivaSuperCombo(false);
				
			}*/
			
		} catch (Exception e) {
			this.activaDesactivaSuperCombo(false);
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarVentaSMS
	 * 		   Metodo encargado de realizar las validaciones para saber 
  	 * 		   si la agencia tiene configurado el producto de sms combo
	 * @return boolean
	 * 		   bandera indica como sale de la validacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private boolean validarVentaSMS() throws Exception{
		boolean booRespuesta = false;
		/*String strIdDocumentoSMS;
		String strIdConceptoSMS;
		String strCodDocumentoSMS;
		String strInformacionSMS;
		String strIvaSMS;
		Usuario objUsuario;
		
		objUsuario = InformacionSessionGiros.getInstance().getObjUsuario();
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ID_DOCUMENTO_SMS,
													  EnumParametrosSistema.ID_CONCEPTO_SMS_COMBO,
													  EnumParametrosSistema.CODIGO_DOCUMENTO_SMS,
													  EnumParametrosSistema.PORCENTAJE_IVA_SMS,
													  EnumParametrosSistema.INFORMACION_SMS);
		
		strIdDocumentoSMS = EnumParametrosSistema.ID_DOCUMENTO_SMS.obtenerValor().getValor();
		strIdConceptoSMS = EnumParametrosSistema.ID_CONCEPTO_SMS_COMBO.obtenerValor().getValor();
		strCodDocumentoSMS = EnumParametrosSistema.CODIGO_DOCUMENTO_SMS.obtenerValor().getValor();
		strIvaSMS = EnumParametrosSistema.PORCENTAJE_IVA_SMS.obtenerValor().getValor();
		strInformacionSMS = EnumParametrosSistema.INFORMACION_SMS.obtenerValor().getValor();
		
		//validamos que los parametros esten bien configurados
		if (strIdDocumentoSMS == null || strIdDocumentoSMS.equals("") 
				|| strIdConceptoSMS == null || strIdConceptoSMS.equals("")) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//validamos el documento
		if (strCodDocumentoSMS != null && !strCodDocumentoSMS.equals("")) {
			
			if(objUsuario.buscarDocumentoPorCodigo(strCodDocumentoSMS) == null){
				
				booRespuesta = false;
				return booRespuesta;
			}
		}else {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//validamos el documento asociado al concepto
		if (!SuperComboVistaLogica.getInstance().validaAgenciaDocumentoConcepto(objUsuario,
																				strIdDocumentoSMS, 
																				strIdConceptoSMS)) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//validamos QUE ESTE CONFIGURADO EL PORCENTAJE IVA
		if (strIvaSMS == null || strIvaSMS.equals("")) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//Validamos el producto
		this.objProductoSMS = objUsuario.buscarProductoPorCodigo(EnumParametrosApp.PRODUCTO_MENSAJE_TEXTO.getValorPropiedad());
		if (this.objProductoSMS == null) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		ValidacionesSuperCombo.getObjSuperCombo().setProductoSMS(this.objProductoSMS);
		
		this.objDocumentoSMS = objUsuario.buscarDocumentoPorCodigo(objProductoSMS, strCodDocumentoSMS);
		if (this.objDocumentoSMS == null) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		this.objDocumentoSMS.setNaturaleza(EnumParametrosApp.DOCUMENTO_NATURALEZA_POSITIVA.getValorPropiedad());
		ValidacionesSuperCombo.getObjSuperCombo().setDocumentoSMS(objDocumentoSMS);
		
		StringTokenizer stkInformacionSMS = new StringTokenizer(strInformacionSMS, ";");
		ValidacionesSuperCombo.getObjSuperCombo().setStrNombreProveedorSMS(stkInformacionSMS.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrNitProveedorSMS(stkInformacionSMS.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrDireccionProveedorSMS(stkInformacionSMS.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrTelefonoProveedorSMS(stkInformacionSMS.nextToken());
		booRespuesta = true;*/
		return booRespuesta;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarVentaSeguro
	 * 		   Metodo encargado de realizar las validaciones para saber 
  	 * 		   si la agencia tiene configurado el producto de seguro combo
	 * @return boolean
	 * 		   bandera indica como sale de la validacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private boolean validarVentaSeguro() throws Exception{
		boolean booRespuesta = false;
		//String strIdConceptoSeguro;
		//String strIdConceptoSMS;
		String strIdDocumentoSeg;
		String strIdConceptoSeg;
		String strCodDocumentoSeg;
		//String strVlrSeguroSMS;
		String strVlrMaxSeguroVida;
		String strTelefonosAseguradora;
		String strInformacionSeguro;
		String[] arrTelefonosAseguradora;
		double douVlrMaxSeguroVida = 0d;
		//double douVlrPrimaSeguro=0.0;
		//double douVlrSMS= 0.0;
		//double douVlrSuperCombo;
		Usuario objUsuario;
		Producto objProductoSeg;
		//Concepto conceptoSeguro;
		//Concepto conceptoSMS;
		
		objUsuario = InformacionSessionGiros.getInstance().getObjUsuario();
		
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ID_DOCUMENTO_SEGURO,
													  EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO,
													  EnumParametrosSistema.CODIGO_DOCUMENTO_SEGURO,
													  EnumParametrosSistema.VALOR_MAXIMO_SEGURO_ACCIDENTES,
													  EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO,
													  EnumParametrosSistema.TELEFONOS_ATENCION_COMPANIA_ASEGURADORA,
													  EnumParametrosSistema.INFORMACION_SEGURO);
		
		strIdDocumentoSeg = EnumParametrosSistema.ID_DOCUMENTO_SEGURO.obtenerObjParametro().getValor();
		strIdConceptoSeg = EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO.obtenerObjParametro().getValor();
		strCodDocumentoSeg = EnumParametrosSistema.CODIGO_DOCUMENTO_SEGURO.obtenerObjParametro().getValor();
		//strVlrSeguroSMS = EnumParametrosSistema.VALOR_SEGURO_SMS.obtenerValor().getValor();
		strVlrMaxSeguroVida = EnumParametrosSistema.VALOR_MAXIMO_SEGURO_ACCIDENTES.obtenerObjParametro().getValor();
		//strIdConceptoSeguro = EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO.obtenerValor().getValor();
		//strIdConceptoSMS = EnumParametrosSistema.ID_CONCEPTO_SMS_COMBO.obtenerValor().getValor();
		strTelefonosAseguradora = EnumParametrosSistema.TELEFONOS_ATENCION_COMPANIA_ASEGURADORA.obtenerObjParametro().getValor();
		strInformacionSeguro = EnumParametrosSistema.INFORMACION_SEGURO.obtenerObjParametro().getValor();
		
		//validamos que los parametros esten bien configurados
		if (strIdDocumentoSeg == null || strIdDocumentoSeg.equals("") 
				|| strIdConceptoSeg == null || strIdConceptoSeg.equals("")) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//validamos el documento
		if (strCodDocumentoSeg != null && !strCodDocumentoSeg.equals("")) {
			
			if(objUsuario.buscarDocumentoPorCodigo(strCodDocumentoSeg) == null){
				
				booRespuesta = false;
				return booRespuesta;
			}
		}else {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//validamos el documento asociado al concepto
		if (!SuperComboVistaLogica.getInstance().validaAgenciaDocumentoConcepto(objUsuario,
																				strIdDocumentoSeg, 
																				strIdConceptoSeg)) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		
		//Validamos el producto 
		objProductoSeg = objUsuario.buscarProductoPorCodigo(EnumProductos.SEGURO.getObjProducto().getCodigo());
		if (objProductoSeg == null) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		ValidacionesSuperCombo.getObjSuperCombo().setProductoSeguro(objProductoSeg);
		
		this.objDocumentoSeg = objUsuario.buscarDocumentoPorCodigo(objProductoSeg, strCodDocumentoSeg);
		if (this.objDocumentoSeg == null) {
			
			booRespuesta = false;
			return booRespuesta;
		}
		this.objDocumentoSeg.setNaturaleza(EnumParametrosApp.DOCUMENTO_NATURALEZA_POSITIVA.getValorPropiedad());
		ValidacionesSuperCombo.getObjSuperCombo().setDocumentoSeguro(objDocumentoSeg);
		
		/*if (strVlrSeguroSMS == null || strVlrSeguroSMS.equals("") 
				|| strVlrMaxSeguroVida == null || strVlrMaxSeguroVida.equals("")) {
			booRespuesta = false;
			return booRespuesta;
		}else{
			StringTokenizer stkValSMSSeg = new StringTokenizer(strVlrSeguroSMS, ";");
			douVlrPrimaSeguro = Double.parseDouble(stkValSMSSeg.nextToken());
			douVlrSMS = Double.parseDouble(stkValSMSSeg.nextToken());
			douVlrMaxSeguroVida = Double.parseDouble(strVlrMaxSeguroVida);
			System.out.println("-->validarVentaSeguro--douVlrPrimaSeguro:"+douVlrPrimaSeguro);
			System.out.println("-->validarVentaSeguro--douVlrSMS:"+douVlrSMS);
			System.out.println("-->validarVentaSeguro--douVlrMaxSeguroVida:"+douVlrMaxSeguroVida);
			if (douVlrPrimaSeguro > 0.0 && douVlrSMS> 0.0) {
				douVlrSuperCombo = douVlrPrimaSeguro + douVlrSMS;
				ValidacionesSuperCombo.getObjSuperCombo().setDouVlrPrimaSeguro(douVlrPrimaSeguro);
				ValidacionesSuperCombo.getObjSuperCombo().setDouVlrSMS(douVlrSMS);
				ValidacionesSuperCombo.getObjSuperCombo().setDouVlrSuperCombo(douVlrSuperCombo);
				ValidacionesSuperCombo.getObjSuperCombo().setDouVlrMaxSeguroVida(douVlrMaxSeguroVida);
			}else {
				booRespuesta = false;
				return booRespuesta;
			}
		}*/
		douVlrMaxSeguroVida = Double.parseDouble(strVlrMaxSeguroVida);
		ValidacionesSuperCombo.getObjSuperCombo().setDouVlrMaxSeguroVida(douVlrMaxSeguroVida);
		/*System.out.println("-->validarVentaSeguro--conceptoSeguro");
		conceptoSeguro = this.getConcepto(strIdConceptoSeguro, 
				 						  ValidacionesSuperCombo.getObjSuperCombo().getDouVlrPrimaSeguro());
		
		if (conceptoSeguro == null) {
			booRespuesta = false;
			return booRespuesta;
		}
		ValidacionesSuperCombo.getObjSuperCombo().setConceptoSeguro(conceptoSeguro);*/
		
		/*conceptoSMS = this.getConcepto(strIdConceptoSMS, 
				   					   ValidacionesSuperCombo.getObjSuperCombo().getDouVlrSMS());

		if (conceptoSMS == null) {
			booRespuesta = false;
			return booRespuesta;
		}
		ValidacionesSuperCombo.getObjSuperCombo().setConceptoSMS(conceptoSMS);*/
		
		arrTelefonosAseguradora=strTelefonosAseguradora.split("\\;");
		ValidacionesSuperCombo.getObjSuperCombo().setStrTelefonoNacional(arrTelefonosAseguradora[0]);
		ValidacionesSuperCombo.getObjSuperCombo().setStrTelefonoCali(arrTelefonosAseguradora[1]);
		ValidacionesSuperCombo.getObjSuperCombo().setStrTelefonosCelular(arrTelefonosAseguradora[2] + "," +
																		 arrTelefonosAseguradora[3] + "," +
																		 arrTelefonosAseguradora[4] + "," +
																		 arrTelefonosAseguradora[5]);
		ValidacionesSuperCombo.getObjSuperCombo().setStrTelefonosAseguradora(arrTelefonosAseguradora);
		
		StringTokenizer stkInformacionSeguro = new StringTokenizer(strInformacionSeguro, ";");
		ValidacionesSuperCombo.getObjSuperCombo().setStrPolizaMatriz(stkInformacionSeguro.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrNombreAseguradora(stkInformacionSeguro.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrNitAseguradora(stkInformacionSeguro.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrNombreTomador(stkInformacionSeguro.nextToken());
		ValidacionesSuperCombo.getObjSuperCombo().setStrNitTomador(stkInformacionSeguro.nextToken());
		
		booRespuesta = true;
		return booRespuesta;
	}
	
	/** 
	 * ********************************************************************
	 * @method obtenerVlrSeguroAccidente
	 * 		   Metodo encargado de obtener el valor del seguro de 
  	 * 		   accidentes.
	 * @param  pDouVlrGiro
	 * 		   valor double del giro
	 * @return double
	 * 		   valor del seguro accidente
	 * @throws Exception
	 *    	   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public double obtenerVlrSeguroAccidente(double pDouVlrGiro) throws Exception{
		
		double douVlrSeguroAccidente;
		
		if((pDouVlrGiro*6)>=ValidacionesSuperCombo.objSuperCombo.getDouVlrMaxSeguroVida()){
			douVlrSeguroAccidente = ValidacionesSuperCombo.objSuperCombo.getDouVlrMaxSeguroVida();
		}else{
			douVlrSeguroAccidente = pDouVlrGiro*6;
		}
		
		return douVlrSeguroAccidente;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method activaDesactivaSuperCombo
	 * 		   Metodo encargado setear al usuario si el producto supercombo
	 * 		   esta activo o desactivo
	 * @param  booEstado
	 * 		   bandera indicando para activar o desactivar supercombo
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void activaDesactivaSuperCombo(boolean booEstado){
		
		InformacionSessionGiros.getInstance().getObjUsuario().setBooSuperComboActivo(booEstado);
		
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarSuperComboCotizacion
	 * 		   Metodo que valida si se puede ofrecer superCombo en la 
  	 *         cotizacion del giro, valida que los terceros sean 
  	 *         asegurables, que este activo el parametro supercombo,
  	 *         que el tercero no tenga tipo documento nit.
	 * @param  pEvento
	 * 		   clase evento desde la cual se invoca la validacion
	 * @param  pTerceroOrigen
	 * 		   objeto tercero origen
	 * @param  pTerceroDestino
	 * 		   objeto tercero destino
	 * @param  pDouValGiro
	 * 		   valor double del giro
	 * @return boolean
	 * 		   bandera indicando si se puede ofrecer supercombo
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public boolean validarSuperComboCotizacion(EventoAbstracto pEvento,
											   Tercero pTerceroOrigen,
											   Tercero pTerceroDestino,
											   double pDouValGiro,
											   Factura pFactura)throws Exception{
		boolean booPasaSuperCombo = false;
		String strPsActivoSuperCombo = "";
		String strIdDaEnTipoconvenio = "";
		String strCodPlanTarifarioSeguro = "";
		String strVlrPlanTarifarioSeguro = "";
		Concepto conceptoSeguro;
		
		ParametroSistema PASI_ActivoSuperCombo;
		ParametroSistema PASI_PlanTarSuperCombo;
		ParametroSistema PASI_TipoConvenio;
		
				
		//Se valida si la cotizacion del seguro(protegiro) proviene de la operacion envio o pago de giro nacional
		if (pFactura.getReferenciaControl() != null){
			
			pFactura.setBooRespCotizaProtegiro(false);
	
			PASI_ActivoSuperCombo = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.SUPERCOMBO_ACTIVO_PAGO);
			strPsActivoSuperCombo = PASI_ActivoSuperCombo.getValor();
			
			PASI_TipoConvenio = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.ID_TIPO_TERCERO_CONVENIO);
			strIdDaEnTipoconvenio = PASI_TipoConvenio.getValor();
			
			PASI_PlanTarSuperCombo = UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.COD_GRUPO_PLAN_TARIFARIO_SEGURO_PAGO);
			strCodPlanTarifarioSeguro = PASI_PlanTarSuperCombo.getValor();

			
			strVlrPlanTarifarioSeguro = GiroVistaLogica.getInstance().consultarValorPlanTarifario(InformacionSessionGiros.getInstance().getObjUsuario(), 
					  strCodPlanTarifarioSeguro, 
					  pDouValGiro, 
					  "S",
					  "PagoGiro");
			
		}
		
		try{
			
			if (!InformacionSessionGiros.getInstance().getObjUsuario().isBooSuperComboActivo()) {
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
			}
			
			
			if (pFactura.getReferenciaControl() == null){
				
			UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.SUPERCOMBO_ACTIVO,
														  EnumParametrosSistema.ID_TIPO_TERCERO_CONVENIO,
														  EnumParametrosSistema.COD_GRUPO_PLAN_TARIFARIO_SEGURO);
			
			strPsActivoSuperCombo = EnumParametrosSistema.SUPERCOMBO_ACTIVO.obtenerObjParametro().getValor();
			strIdDaEnTipoconvenio = EnumParametrosSistema.ID_TIPO_TERCERO_CONVENIO.obtenerObjParametro().getValor();
			strCodPlanTarifarioSeguro = EnumParametrosSistema.COD_GRUPO_PLAN_TARIFARIO_SEGURO.obtenerObjParametro().getValor();
			
			}
			
			//validar que el parametro principal este activo
			if (!strPsActivoSuperCombo.equals("SI")) {
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;				
			}
			
			//valodar que los terceros no sean tipo convenio
			if(pTerceroOrigen.getTipoTecero().getId().equals(strIdDaEnTipoconvenio)
					|| pTerceroDestino.getTipoTecero().getId().equals(strIdDaEnTipoconvenio)) {
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
			}
			
			//validar que el tercero destino no tenga tipo de documento NIT
			if (pTerceroDestino.getTipoIdentificacion().getId().equals(EnumParametrosApp.COD_DAT_ENT_TPDOC_NIT.getValorPropiedad())) {
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
			}
			
			//validar que los terceros puedan ser asegurables
			if (!this.validarListaNegraSeguro(pEvento, pTerceroDestino)) {
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
			}
			
			if (!this.validarListaNegraSeguro(pEvento, pTerceroOrigen)) {
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
			}
			
			if (pFactura.getReferenciaControl() == null){
			strVlrPlanTarifarioSeguro = GiroVistaLogica.getInstance().consultarValorPlanTarifario(InformacionSessionGiros.getInstance().getObjUsuario(), 
																								  strCodPlanTarifarioSeguro, 
																								  pDouValGiro, 
																								  "S",
																								  "EnvioGiro");
			}
			
			try {
			
				ValidacionesSuperCombo.getObjSuperCombo().setDouVlrPrimaSeguro(Double.parseDouble(strVlrPlanTarifarioSeguro));
				
				ValidacionesSuperCombo.getObjSuperCombo().setDouVlrSuperCombo(Double.parseDouble(strVlrPlanTarifarioSeguro));
			} catch (Exception e) {
				
				EnumMensajes.SPC_ERROR_FORMATO_VALOR_SEGURO.desplegarMensaje(pEvento.getFrmForma(), 
																			 EnumClasesMensaje.ERROR);
			}
			
			
			if (ValidacionesSuperCombo.getObjSuperCombo().getDouVlrSuperCombo() < 1) {
				
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
				
			}
			conceptoSeguro = this.getConcepto(EnumParametrosSistema.ID_CONCEPTO_SEGURO_HURTO.obtenerObjParametro().getValor(), 
					 						  ValidacionesSuperCombo.getObjSuperCombo().getDouVlrPrimaSeguro());
			
			if (conceptoSeguro == null) {
				
				booPasaSuperCombo = false;
				pFactura.setBooRespCotizaProtegiro(true);
				return booPasaSuperCombo;
			}
			ValidacionesSuperCombo.getObjSuperCombo().setConceptoSeguro(conceptoSeguro);
			
			booPasaSuperCombo = true;
			
		}catch(Exception e){
			booPasaSuperCombo = false;
			//pEvento.controlExcepcion(e);
		}
		return booPasaSuperCombo;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validarListaNegraSeguro
	 * 		   Metodo encargado de validar si un tercero esta en la
  	 * 		   lista negra de la aseguradora
	 * @param  pEvento
	 * 		   Calse evento desde la cual se invoca la utilidad
	 * @param  pTercero
	 * 		   objeto tercero a validar
	 * @return boolean
	 *     	   bandera indica si el tercero supera la validacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private boolean validarListaNegraSeguro(EventoAbstracto pEvento, 
										    Tercero pTercero) throws Exception{
		boolean booValidacion = false;
		String strResValidacion;
		try {
			
			strResValidacion = SuperComboVistaLogica.getInstance().validarListaNegraSeguro(pEvento.getObjUsuario(),
																						   pTercero);
			
			if (strResValidacion.contains(EnumParametrosApp.SC_TERCERO_ASEGURABLE.getValorPropiedad())) {
				booValidacion = true;
				return booValidacion;
			}
			
			if (strResValidacion.toLowerCase().contains(EnumParametrosApp.SC_ASEGURADO_EXCEDE_LIMITE_SEGURO.getValorPropiedad())) {
				
				EnumMensajes.SPC_TERCERO_NO_ASEGURABLE.desplegarMensaje(pEvento.getFrmForma(), 
																		EnumClasesMensaje.INFORMACION, 
																		pTercero.getDescripcion());
				booValidacion = false;
				return booValidacion;
			}
			
			if (strResValidacion.contains(EnumParametrosApp.SC_PROBLEMAS_CONSULTANDO_CLIENTE_WS.getValorPropiedad())) {
				
				EnumMensajes.SPC_NO_CONEXION_WS_SEGUROS_PROVEEDOR.desplegarMensaje(pEvento.getFrmForma(), 
																				   EnumClasesMensaje.INFORMACION);
				booValidacion = false;
				return booValidacion;
			}
			
			if (strResValidacion.contains(EnumParametrosApp.SC_ILLEGAL_CHARACTER.getValorPropiedad())) {
				
				EnumMensajes.SPC_NO_CONEXION_WS_SEGUROS_CODESA.desplegarMensaje(pEvento.getFrmForma(), 
																			    EnumClasesMensaje.INFORMACION);
				booValidacion = false;
				return booValidacion;
			}else{
				
				EnumMensajes.SPC_ERROR_CONSULTANDO_LISTA_NEGRA_SEGURO.desplegarMensaje(pEvento.getFrmForma(), 
																					   EnumClasesMensaje.INFORMACION);
				booValidacion = false;
				return booValidacion;
				
			}
			
		} catch (Exception e) {
			booValidacion = false;
		}
		return booValidacion;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method cotizarSeguro
	 * 		   Metodo encargado de realizar la cotizacion de la factura
  	 *  	   de seguro
	 * @param  pEvento
	 * 		   Clase evento desde la cual se invoca la utilidad
	 * @param  pDouVlrSeguroHurto
	 * 		   valor double del seguro hurto
	 * @param  pDouVlrSeguroAccidentes
	 * 		   valor double del seguro contra accidentes
	 * @param  pFacturaSeguro
	 * 		   objeto factura seguro
	 * @param  pFacturaGiro
	 *   	   objeto factura giro
	 * @return boolean
	 * 		   bandera indica como termina la cotizacion de la factura seguro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public boolean cotizarSeguro(EventoAbstracto pEvento, 
								 double pDouVlrSeguroHurto, 
								 double pDouVlrSeguroAccidentes,
								 FacturaSeguro pFacturaSeguro,
							     FacturaGiro pFacturaGiro) throws Exception{
		
		boolean booRespuesta = false;
		
		pFacturaSeguro.setDocumento(ValidacionesSuperCombo.getObjSuperCombo().getDocumentoSeguro());
		pFacturaSeguro.setProducto(ValidacionesSuperCombo.getObjSuperCombo().getProductoSeguro());
		pFacturaSeguro.setValorAsegurado(pDouVlrSeguroHurto);
		pFacturaSeguro.setValorPrima(ValidacionesSuperCombo.getObjSuperCombo().getDouVlrPrimaSeguro());
		pFacturaSeguro.setValorAseguradoAccidente(pDouVlrSeguroAccidentes);
		pFacturaSeguro.setValorSms(ValidacionesSuperCombo.getObjSuperCombo().getDouVlrSMS());
		pFacturaSeguro.setPin((pFacturaGiro.getFacturaSeguro()==null)?"" : pFacturaGiro.getFacturaSeguro().getReferenciaControl());
		pFacturaSeguro.setTerceroAsegurado(pFacturaGiro.getTerceroDestino());
		pFacturaSeguro.setTerceroRemitente(pFacturaGiro.getTerceroOrigen());
		pFacturaSeguro.setTerceroBeneficiario(ValidacionesSuperCombo.getObjSuperCombo().getTerceroBeneficiarioSeguro());
		pFacturaSeguro.setConcepto(ValidacionesSuperCombo.getObjSuperCombo().getConceptoSeguro());
		pFacturaSeguro.setAgenciaDestino(pFacturaGiro.getAgenciaDestino());
		pFacturaSeguro.setTerceroOrigen(pFacturaGiro.getTerceroOrigen());
		pFacturaSeguro.setTerceroDestino(pFacturaGiro.getTerceroDestino());
		
		SuperComboVistaLogica.getInstance().calcularConceptosSeguro(pEvento.getObjUsuario(),
																	pFacturaSeguro, 
																	false);
		booRespuesta = true;
		
		return booRespuesta;
		
	}
	
	
	/** 
	 * ********************************************************************
	 * @method cotizarSMS
	 * 		   Metodo encargado de realizar la cotizacion de la factura
  	 *  	   de sms. por evolucion del Supercombo, se elimina la 
  	 *  	   cotizacion de la factura SMS, validando solo el tipo de sms
  	 *  	   a enviar
	 * @param  pEvento
	 * 		   Clase evento desde la cual se invoca la utilidad
	 * @param  pFacturaGiroSMS
	 * 		   objeto factura sms
	 * @param  pFacturaGiro
	 * 		   objeto factura giro
	 * @return boolean
	 * 		   bandera indicando si la cotizacion se realiza de manera 
	 * 		   exitosa
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public boolean cotizarSMS(EventoAbstracto pEvento,
			 				  FacturaGiro pFacturaGiroSMS,
			 				  FacturaGiro pFacturaGiro) throws Exception{
		
		boolean booRespuesta = false;
		try {
			
			this.validaTipoSMS(pEvento);
			
			/*pFacturaGiroSMS.setDocumento(ValidacionesSuperCombo.getObjSuperCombo().getDocumentoSMS());
			pFacturaGiroSMS.setNumero(pFacturaGiro.getNumero());
			pFacturaGiroSMS.setProducto(ValidacionesSuperCombo.getObjSuperCombo().getProductoSMS());
			pFacturaGiroSMS.getFacturaSMS().setPin((pFacturaGiro.getFacturaSeguro()==null)?"" : pFacturaGiro.getFacturaSeguro().getReferenciaControl());
			pFacturaGiroSMS.setTerceroOrigen(pFacturaGiro.getTerceroOrigen());
			pFacturaGiroSMS.setTerceroDestino(pFacturaGiro.getTerceroDestino());
			pFacturaGiroSMS.setConcepto(ValidacionesSuperCombo.getObjSuperCombo().getConceptoSMS());
			pFacturaGiroSMS.setAgenciaDestino(pFacturaGiro.getAgenciaDestino());
			pFacturaGiroSMS.setAgenciaOrigen(pFacturaGiro.getAgenciaOrigen());
			pFacturaGiroSMS.setDomicilio(false);
			pFacturaGiroSMS.setIncluyeFlete(false);
			pFacturaGiroSMS.setIncluyeDomicilio(false);
			pFacturaGiroSMS.setIncluyeOtros(false);
			
			GiroVistaLogica.getInstance().calcularConceptosGiro(pEvento.getObjUsuario(),
																pFacturaGiroSMS);*/
			
			booRespuesta = true;
		
		} catch (Exception e) {
			pEvento.controlExcepcion(e);
		}
		return booRespuesta;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method validaTipoSMS
	 * 		   Metodo encargado de validar el tipo de SMS
	 * @param  pEvento
	 * 		   Clase evento desde la que se invoca la validacion
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public void validaTipoSMS(EventoAbstracto pEvento)throws Exception{
		
		if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SOLO_REMITENTE.getObjConstante())) {
			
			EnumMensajes.SPC_MSJ_REMITENTE_BENEFICIARIO_RECLAMA_GIRO.desplegarMensaje(pEvento.getFrmForma(), 
																					  EnumClasesMensaje.INFORMACION);
			
		}else if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SOLO_DESTINATARIO.getObjConstante())) {
			
			EnumMensajes.SPC_MSJ_BENEFICIARIO_INFORMACION_GIRO.desplegarMensaje(pEvento.getFrmForma(), 
																				EnumClasesMensaje.INFORMACION);
			
		}else if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_AMBOS.getObjConstante())) {
			
			EnumMensajes.SPC_MSJ_REMITENTE_BENEFICIARIO_INFO_GIRO.desplegarMensaje(pEvento.getFrmForma(), 
																				   EnumClasesMensaje.INFORMACION);
			
		}else if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SIN_SMS.getObjConstante())) {
			
			EnumMensajes.SPC_MSJ_NO_SE_ENVIA_MENSAJE.desplegarMensaje(pEvento.getFrmForma(), 
																	  EnumClasesMensaje.INFORMACION);
		}
	}
	
	
	/** 
	 * ********************************************************************
	 * @method getConcepto
	 * 		   Metodo encargado de crear un concepto, con los 
  	 * 		   parametros recibidos
	 * @param  pStrIdConcepto
	 * 		   id del concepto a crear
	 * @param  pDouValor
	 * 		   valor double del concepto
	 * @return Concepto
	 * 		   objeto Concepto con la informacion recibida
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private Concepto getConcepto(String pStrIdConcepto, double pDouValor) throws Exception {
		
		Concepto concepto = new Concepto();
		concepto.setCantidad(1);
		concepto.setDescripcion("");
		concepto.setId(pStrIdConcepto);
		concepto.setValor(pDouValor);
		
		return concepto;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method crearMovimientoSeguro
	 * 		   Metodo encargado de crear el movimiento del seguro, 
	 * 		   invocando la vista logica
	 * @param  pObjUsuario
	 * 		   objeto usuario de la aplicacion
	 * @param  pFacturaSeguro
	 *   	   objeto factura seguro 
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public void crearMovimientoSeguro(Usuario pObjUsuario,
									  FacturaSeguro pFacturaSeguro) throws Exception {
		
		SuperComboVistaLogica.getInstance().crearSeguro(pObjUsuario,
														pFacturaSeguro, 
														"*");
		
			//throw EnumMensajes.SPC_ERROR_FACTURANDO_SEGURO_SIMS.generarExcepcion(EnumClasesMensaje.ERROR);
		
		/*SuperComboVistaLogica.getInstance().crearSeguroDestino(pObjUsuario,
															   pFacturaSeguro);*/
	}
	
	
	/** 
	 * ********************************************************************
	 * @method cargarMedioPagoSeguro
	 * 		   Metodo para cargar los medios de pago del usuario, a la 
	 * 		   factura de seguro 
	 * @param  pFacturaSeguro
	 * 		   objeto factura seguro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public void cargarMedioPagoSeguro(FacturaSeguro pFacturaSeguro) throws Exception{
		MedioPago medioPagoSeguro; 
		MedioPago medioPagoUsr; 
		
		medioPagoUsr = InformacionSessionGiros.getInstance().getObjUsuario().getMediosPago().get(0);
		
		medioPagoSeguro = new MedioPago();
		medioPagoSeguro.setId(medioPagoUsr.getId());
		medioPagoSeguro.setValor(pFacturaSeguro.getValorPrima());
		medioPagoSeguro.setDocumentoAuxiliar(medioPagoUsr.getDescripcion());
		if (pFacturaSeguro.getListMediosPago() == null) {
			pFacturaSeguro.setListMediosPago(new ArrayList<MedioPago>());
		}else{
			pFacturaSeguro.getListMediosPago().clear();
		}
		pFacturaSeguro.getListMediosPago().add(medioPagoSeguro);
	}
	
	
	/** 
	 * ********************************************************************
	 * @method cargarMedioPagoSMS
	 * 		   Metodo para cargar los medios de pago del usuario, a la 
	 * 		   factura de SMS
	 * @param  pFacturaGiroSMS
	 *         objeto factura giro sms
	 * @param  pFacturaGiro
	 * 		   objeto factura giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	private void cargarMedioPagoSMS(Factura pFacturaGiroSMS, Factura pFacturaGiro) throws Exception{
		MedioPago medioPagoSMS; 
		MedioPago medioPagoGiro; 
		
		medioPagoGiro = pFacturaGiro.getListMediosPago().get(0);
		
		medioPagoSMS = new MedioPago();
		medioPagoSMS.setId(medioPagoGiro.getId());
		medioPagoSMS.setValor(pFacturaGiroSMS.getListaConceptos().get(0).getValor());
		medioPagoSMS.setDocumentoAuxiliar(null);
		if (pFacturaGiroSMS.getListMediosPago() == null) {
			pFacturaGiroSMS.setListMediosPago(new ArrayList<MedioPago>());
		}else{
			pFacturaGiroSMS.getListMediosPago().clear();
		}
		pFacturaGiroSMS.getListMediosPago().add(medioPagoSMS);
	}
	
	
	/** 
	 * ********************************************************************
	 * @method crearMovimientoSMS
	 * 		   Metodo encargado de crear el movimiento del SMS
	 * @param  pObjUsuario
	 * 		   objeto usuario de la aplicacion
	 * @param  pFacturaGiroSMS
	 * 		   objeto factura giro sms
	 * @param  pFacturaGiro
	 * 		   objeto factura giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	@Deprecated
	public void crearMovimientoSMS(Usuario pObjUsuario,
								   FacturaGiro pFacturaGiroSMS, 
								   FacturaGiro pFacturaGiro) throws Exception {
		
		ValidacionesSuperCombo.getInstance().cargarMedioPagoSMS(pFacturaGiroSMS, 
																pFacturaGiro);
		
		pFacturaGiroSMS.setReferenciaControl(pFacturaGiro.getReferenciaControl());
		pFacturaGiroSMS.setObjNota(pFacturaGiro.getObjNota());
		
		SuperComboVistaLogica.getInstance().enviarSMS(pObjUsuario,
													  pFacturaGiroSMS, 
													  this.obtenerSMS(pFacturaGiroSMS));
		
		pFacturaGiroSMS.getFacturaSMS().setFacturaVenta(pFacturaGiroSMS.getDocumento().getAbreviatura()+ " " +pFacturaGiroSMS.getNumero());
		
	}
	
	
	/** 
	 * ********************************************************************
	 * @method obtenerSMS
	 * 		   Metodo encargado validar el tipo sms a enviar, y llama al 
	 * 		   metodo obtenerSMSAEnviar para obtener la cadena a enviar
	 * @param  pFacturaGiroSMS
	 * 		   objeto factura giro sms
	 * @return String
	 * 		   cadena mensaje
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	@Deprecated
	private String obtenerSMS(FacturaGiro pFacturaGiroSMS) throws Exception{
		String strSMS = null;
		
		/*if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SOLO_REMITENTE.getObjConstante())) {
			
			strSMS = this.obtenerSMSAEnviar(pFacturaGiroSMS, EnumParametrosSistema.MENSAJE_REMITENTE);
			
		}else if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SOLO_DESTINATARIO.getObjConstante())
					|| ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_AMBOS.getObjConstante())) {
			
			strSMS = this.obtenerSMSAEnviar(pFacturaGiroSMS, EnumParametrosSistema.MENSAJE_DESTINATARIO);
			
		}else if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SIN_SMS.getObjConstante())) {
			
			strSMS = "NINGUNO";
			
		}
		
		strSMS = this.reemplazarCaracteresSMS(strSMS);*/
		
		return strSMS;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method reemplazarCaracteresSMS
	 * 		   Metodo encargado para limpiar caracteres especiales
	 * @param  strCadena
	 * 		   cadena a revisar
	 * @return String
	 * 	   	   cadena sin los caracteres de reemplazo
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private String reemplazarCaracteresSMS(String strCadena) throws Exception{
		String strSMS = strCadena;
		
		strSMS = strSMS.replace("Á", "A");
		strSMS = strSMS.replace("É", "E");
		strSMS = strSMS.replace("Í", "I");
		strSMS = strSMS.replace("Ó", "O");
		strSMS = strSMS.replace("Ú", "U");
		
		strSMS = strSMS.replace("á", "a");
		strSMS = strSMS.replace("é", "e");
		strSMS = strSMS.replace("í", "i");
		strSMS = strSMS.replace("ó", "o");
		strSMS = strSMS.replace("ú", "u");
		
		return strSMS;
	}
	
	/**
	 * ********************************************************************
	 * @method obtenerSMSAEnviar
	 * 		   Obtiene el mensaje (SMS) que se desea enviar al celular del 
	 * 		   destinatario o remitente del giro, reemplazando antes las 
	 * 		   variables con los valores correspondientes. Las variables a 
	 * 		   reemplazar pueden ser 1 o maximo 5, se reconocen como 
	 * 		   variables porque empiezan por el signo ':', estas pueden ser :
	 * 		   OFIORIGEN, :OFIDESTINO, :TERRITORIO, :EMPRESA y :VALORGIRO. 
	 * 		   El texto final a enviar no puede superar los 150 caracteres 
	 * 		   ya que seria rechazado por quattromobil.
	 * @param  pFacturaGiroSMS
	 *         objeto que contiene toda la información relacionada con el
	 *         giro.
	 * @param  pParametroEnum
	 *         Codigo de el registro que se debe buscar en la tabla
	 *         PARAMETROS_SISTEMA. Este registro contiene como valor la 
	 *         cadena de texto que se enviara al cliente, esta cadena de
	 *         texto puede contener referencias a variables que deben ser
	 *         reemplazadas antes del envio, que es lo que hace este metodo.
	 * @return String
	 *         cadena con el texto definitivo a enviar.
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * ********************************************************************
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private String obtenerSMSAEnviar(FacturaGiro pFacturaGiroSMS, EnumParametrosSistema pParametroEnum) throws Exception {

		int numVariables = 0; // Numero de variables contenidas en la cadena
		int size = 0;
		int charsXvariable = 0; // Numero de caracteres maximo que puede tomar
								// cada variable.
		String strValue = null;
		String MAX_CHARS = "0";//UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.MAXIMO_CARACTERES_EN_SMS).getValor();
		int MAX_MSJ = new Integer(MAX_CHARS);
		/*
		 * Se toma el mensaje original se copia a la variable msjFijo y se
		 * obtiene su tamaño. Esta copia se hace porque necesitamos saber cual
		 * es el tamaño de la cadena sin las variables. Para ellos tomaremos el
		 * mensaje y borraremos todas las variables, por esta razón se hace
		 * sobre una copia de la cadena.
		 */
		String msj = UtilParametrosSistema.getInstance().consultar(pParametroEnum).getValor();
		String msjFijo = msj;
		size = msjFijo.length();

		/*
		 * Se iran borrando las varibales y sumara 1 a numVariables por cada una
		 * que se haya borrado. Nos daremos cuenta que la variable existia
		 * porque el tamaño de la cadena msjFijo cambiara encuanto se borre una
		 * de ellas
		 */
		msjFijo = UtilidadesGiros.getInstance().reemplazarString(msjFijo, ":OFIORIGEN", "");
		// Verificamos si cambio el tamaño, si es asi sumamos 1 de lo contrario
		// nada (0).
		numVariables += msjFijo.length() != size ? 1 : 0;
		// Guardar el tamaño actual de la cadena, para la siguiente comparacion.
		size = msjFijo.length();

		msjFijo = UtilidadesGiros.getInstance().reemplazarString(msjFijo, ":OFIDESTINO", "");
		numVariables += msjFijo.length() != size ? 1 : 0;
		size = msjFijo.length();
		msjFijo = UtilidadesGiros.getInstance().reemplazarString(msjFijo, ":TERRITORIO", "");
		numVariables += msjFijo.length() != size ? 1 : 0;
		size = msjFijo.length();
		msjFijo = UtilidadesGiros.getInstance().reemplazarString(msjFijo, ":EMPRESA", "");
		numVariables += msjFijo.length() != size ? 1 : 0;
		size = msjFijo.length();
		msjFijo = UtilidadesGiros.getInstance().reemplazarString(msjFijo, ":VALORGIRO", "");
		numVariables += msjFijo.length() != size ? 1 : 0;
		size = msjFijo.length();
		msjFijo = UtilidadesGiros.getInstance().reemplazarString(msjFijo, ":PROPIETARIO", "");
		numVariables += msjFijo.length() != size ? 1 : 0;

		/*
		 * Se resta el maximo numero de caracteres permitido en el mensaje con
		 * el tamaño de la cadena sin variables, esto nos da como resultado el
		 * numero de caracteres faltantes para completar el total maximo, luego
		 * dividimos este valor por el numero de variables contenidas en la
		 * cadena, esto nos da el numero de caracteres maximo que puede tener
		 * cada variable.
		 */
		charsXvariable = (MAX_MSJ - msjFijo.length()) / numVariables;

		if (msj.contains(":OFIORIGEN")) {
			strValue = pFacturaGiroSMS.getAgenciaOrigen().getNombre();
			// Validar si el tamaño de la cadena reemplazante es mayor que lo
			// permitido.
			if (strValue.length() > charsXvariable) {
				// Si es mayor entonces cortar la cadena de texto hasta el
				// limite permitido.
				strValue = strValue.substring(0, charsXvariable - 1);
			}
			// Reemplazar la variable con el texto adecuado.
			msj = UtilidadesGiros.getInstance().reemplazarString(msj, ":OFIORIGEN", strValue);
		}
		if (msj.contains(":OFIDESTINO")) {
			strValue = pFacturaGiroSMS.getAgenciaDestino().getNombre();
			if (strValue.length() > charsXvariable) {
				strValue = strValue.substring(0, charsXvariable - 1);
			}
			msj = UtilidadesGiros.getInstance().reemplazarString(msj, ":OFIDESTINO", strValue);
		}
		if (msj.contains(":TERRITORIO")) {
			strValue = pFacturaGiroSMS.getAgenciaDestino().getTerritorio().getNombre();
			if (strValue.length() > charsXvariable) {
				strValue = strValue.substring(0, charsXvariable - 1);
			}
			msj = UtilidadesGiros.getInstance().reemplazarString(msj, ":TERRITORIO", strValue);
		}
		if (msj.contains(":EMPRESA")) {
			strValue = InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().getNombre();
			if (strValue.length() > charsXvariable) {
				strValue = strValue.substring(0, charsXvariable - 1);
			}
			msj = UtilidadesGiros.getInstance().reemplazarString(msj, ":EMPRESA", strValue);
		}
		if (msj.contains(":VALORGIRO")) {
			strValue = pFacturaGiroSMS.getTotal()+"";
			if (strValue.length() > charsXvariable) {
				strValue = strValue.substring(0, charsXvariable - 1);
			}
			msj = UtilidadesGiros.getInstance().reemplazarString(msj, ":VALORGIRO", strValue);
		}
		if (msj.contains(":PROPIETARIO")) {
			strValue = pFacturaGiroSMS.getAgenciaDestino().getPropietario();
			if (strValue.length() > charsXvariable) {
				strValue = strValue.substring(0, charsXvariable - 1);
			}
			msj = UtilidadesGiros.getInstance().reemplazarString(msj, ":PROPIETARIO", strValue);
		}
		return msj;
	}
	
	
	/** 
	 * ********************************************************************
	 * @method reiniciaSuperCombo
	 * 		   Metodo encargado de reiniciar las variables de la clase
  	 * 		   SuperCombo
	 * @author roberth.martinez
	 * @date   1/12/2016
	 * *********************************************************************
	 */
	public void reiniciaSuperCombo(){
		
		ValidacionesSuperCombo.getObjSuperCombo().setBooRealizaSeguro(false);
		ValidacionesSuperCombo.getObjSuperCombo().setStrTipoSMS(EnumParametrosApp.SPC_SMS_SIN_SMS.getObjConstante());
		ValidacionesSuperCombo.getObjSuperCombo().setStrTipoSMSTrama(EnumParametrosApp.SPC_SMS_SIN_SMS_TRAMA.getObjConstante());
		ValidacionesSuperCombo.getObjSuperCombo().setTerceroBeneficiarioSeguro(null);
		
	}


	/**
	 * @method getObjSuperCombo
	 * 		   Metodo get del atributo objSuperCombo
	 * @return SuperCombo
	 *		   Valor del atributo objSuperCombo devuelto
	 * @author roberth.martinez
	 * @date   1/12/2016
	 */
	public static SuperCombo getObjSuperCombo() {
		return objSuperCombo;
	}


	/**
	 * @method setObjSuperCombo
	 * 		   Metodo set del atributo objSuperCombo
	 * @param  objSuperCombo
	 *		   Valor que tomara el atributo objSuperCombo
	 * @author roberth.martinez
	 * @date   1/12/2016
	 */
	public static void setObjSuperCombo(SuperCombo objSuperCombo) {
		ValidacionesSuperCombo.objSuperCombo = objSuperCombo;
	}

}
