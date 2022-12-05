package co.com.codesa.clienteposslimgiros.vista.logica.caja;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clientecajams.utilidades.integracion.UtilIntegracionAccesoCajaMultiservicio;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.OperacionesBiometriaMultiservicio;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.utilidades.biometria.UtilWSQ;
import co.com.codesa.clienteposslimgiros.utilidades.denominaciones.UtilTiposDenominaciones;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.vistaLogica.UtilVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.AceptaDesembolso;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.AperturaCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.CierreCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Concepto;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsulMoviProviDesem;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaCajasProvisiones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaConceptosMovCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaCuadreCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaMovimientosCajaGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultaSaldosCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DetalleSaldoMovCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.IngresoXDenominacion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MovimientoCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SaldoMedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ConsultarTipoBiometriaCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ProvisionCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RegistrarIngresoEgreso;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaAceptaDesembolso;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaAperturaCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaCierreCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsulMoviProviDesem;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaCajasProvisiones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaConceptosMovCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaCuadreCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaMovimientosCajaGiros;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultaSaldosCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaConsultarTipoBiometriaCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaProvisionCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaRealizarIngresoEgreso;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.RespuestaValidarCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.entidadesTrama.ValidarCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.IngresoEgreso;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.caja.arqueo.InfoCierreCajaDTO;
import co.com.codesa.codesawrappergiros.modelo.enumeraciones.EnumGeneralidadesTramasGiros;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor: Hector Q-en-K
 * @fecha: 19-mar-2015 
 * @descripcion: Clase implementada con patron de dise�o singleton, 
 * 				 que permite acceder a las diferentes funcionalidades
 * 				 que invocan y procesan peticiones de tramas, relacionadas
 * 				 con el proceso de negocio de caja, por ejemplo:
 * 				 el proceso de apertura de caja
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class CajaVistaLogica {

	/**
	 * @variable: instancia, atributo que vuelve estatico los accesos 
	 * 			  hacia las funciones que agrupa la clase de 
	 * 			  SesionVistaLogica
	 **/
	private static CajaVistaLogica instancia;

	/**
	 * ****************************************************************.
	 * @metodo: CajaVistaLogica (Constructor)
	 * @descripcion: Metodo constructor que se firma como privado, para
	 * 				 garantizar que solo se instancie un objeto de la
	 * 				 clase, a traves del getInstance 
	 * @autor: Hector Q-en-K
	 * ****************************************************************
	 */
	private CajaVistaLogica() {}

	/**
	 * ****************************************************************.
	 * @metodo: getInstance (Metodo)
	 * @descripcion: Metodo encargado de controlar e inicializar la 
	 * 				 instancia de la clase, para instanciarla una unica
	 * 				 vez durante todo el ciclo de vida de la aplicacion
	 * 				 (patron singleton)
	 * @return CajaVistaLogica: tipo de obj que representa a la clase 
	 * 		   misma
	 * @autor: Hector Q-en-K
	 * ****************************************************************
	 */
	public static CajaVistaLogica getInstance(){

		if(instancia==null){
			instancia = new CajaVistaLogica();
		}

		return instancia;
	}

	/**
	 * ****************************************************************.
	 * @metodo: validaCaja (Metodo)
	 * @descripcion: Metodo encargado de solicitar y procesar la respuesta
	 * 				 de la peticion bajo la trama 58, para validar si la 
	 * 				 caja se encuentra abierta o cerrada, es de unico interes 
	 * 				 saber si se encuentra cerrada, de encontrarse abierta no 
	 * 				 ocurrira nada
	 * @param pAgenciaDestino: Agencia que se requiere
	 * 		  validar caja
	 * @param pCajaDestino: caja que se requiere validar
	 * @return boolean: bandera que representa si la caja esta abierta (true) o 
	 * 				    cerrada (false)
	 * @throws Exception: Recupera, controla y escala cualquier tipo de 
	 * 		   excepcion presentada 
	 * @autor: Hector Q-en-K
	 * ****************************************************************
	 */
	public void validaCaja(Usuario pObjUsuario,
						   Agencia pAgenciaDestino, 
						   Caja pCajaDestino) throws Exception{
		/**
		 * [Trama 58 | Verifica que la caja se encuentre abierta: Permite realizar el proceso de validacion de estado de caja.]
		 */
		
		String strCodigoError;
		String[] strParametrosMensaje = null;
		ValidarCaja objEnvioTrama;
		RespuestaValidarCaja objRespuestaTrama;

		objEnvioTrama = new ValidarCaja(pObjUsuario,
										pAgenciaDestino,
										pCajaDestino);

		//objRespuestaTrama = (RespuestaValidarCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaValidarCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			strCodigoError = (String)objRespuestaTrama.getValorAtributoObj("codigoError");
			
			if (strCodigoError.equals(EnumMensajes.CAJA_NO_EXISTE_O_PROBLEMA_INFO.getCodigo())) {
				strParametrosMensaje = new String[]{": "+pCajaDestino.toString()};
			}
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ADVERTENCIA, 
													   		 strCodigoError,
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"),
													   		 strParametrosMensaje);
		}
	}

	/**
	 * ****************************************************************.
	 * @metodo 	consultarSaldosCaja
	 * 		   	Metodo encargado de solicitar y procesar la respuesta
	 * 		   	de la peticion bajo la trama 2, para consultar los
	 * 		   	saldos de caja.
	 * @param 	pDatFechaConsulta
	 * 			Fecha con la que se realizara la consulta de saldos de caja
	 * @param	pBooValidaEstadoCajaTesoreria
	 * 			Bandera que permite activar las validaciones predefinidas 
	 * 			para la caja de tesoreria, al momento de consultar los 
	 * 			saldos de esta
	 * @throws 	Exception
	 * 		   	Recupera, controla y escala cualquier tipo de excepcion 
	 * 		   	presentada 
	 * @autor 	Hector Q-en-K
	 * ****************************************************************
	 */
	public boolean consultarSaldosCaja	(	Usuario pObjUsuario,
										Date pDatFechaConsulta,
										boolean pBooValidaEstadoCajaTesoreria
									) 
		throws Exception 
	{
		/**
		 * [Trama 2 | Consultar Saldos de Caja: Permite realizar el proceso de consultar los saldos de la caja por medio de pago. 
		 * 			  Informacion de saldos recuperada de tesoreria]
		 */
		
		ConsultaSaldosCaja objEnvioTrama;
		RespuestaConsultaSaldosCaja objRespuestaTrama;
		boolean booTramaTesoreria;

		objEnvioTrama = new ConsultaSaldosCaja(pObjUsuario,
												pDatFechaConsulta,
												pBooValidaEstadoCajaTesoreria);

		//objRespuestaTrama = (RespuestaConsultaSaldosCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaSaldosCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (((String)objRespuestaTrama.getValorAtributoObj("tipoResultado")).equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {

			booTramaTesoreria	=	(Boolean)objRespuestaTrama.getValorAtributoObj("booTramaTesoreria");
			
		}	else	{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return booTramaTesoreria;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo consultarCuadreCaja
	 * 		   Metodo encargado de solicitar y procesar la respuesta de 
	 * 		   la peticion identificada con la trama 15, para consultar 
	 * 		   el cuadre de caja, requerido como fase inicial del proceso
	 * 		   de cierre de caja
	 * @return InfoCierreCajaDTO 
	 * 		   objeto DTO, que contiene el resultado procesado de la 
	 * 		   consulta de cuadre de caja
	 * @throws Exception 
	 * 		   Recupera, controla y escala cualquier tipo de excepcion 
	 * 		   presentada 
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public InfoCierreCajaDTO consultarCuadreCaja(Usuario pObjUsuario,
												 String pStrTipoOperacion,
												 boolean pBooUltimoCierreCaja,
												 String pStrFechaApertura) throws Exception {
		/**
		 * [Trama 15 | Consultar Cuadre de Caja: Trama utilizada para realizar la consulta del cuadre de caja, este es el primer paso para el cierre de caja]
		 */
		
		HashMap<String,Concepto> hmIngresosXConcepto;
		HashMap<String,Concepto> hmEgresosXConcepto;
		Object[][] mtrObjMediosPago=null;
		InfoCierreCajaDTO objInfoCierreCajaDTO = null;
		ConsultaCuadreCaja objEnvioTrama;
		RespuestaConsultaCuadreCaja objRespuestaTrama;
		int intContadorFila;
		//boolean booTramaTesoreria;
		
		objEnvioTrama = new ConsultaCuadreCaja(pObjUsuario,
											   pStrTipoOperacion,
											   pBooUltimoCierreCaja,
											   pStrFechaApertura,
											   UtilTiposDenominaciones.getInstance().getHmTiposDenominacionesXIdTipo());

		//objRespuestaTrama = (RespuestaConsultaCuadreCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaCuadreCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			/**
			 * Se ejecuta la trama 2 inmediatamente para modificar los saldos x medio de pago recibidos de SIMS por 
			 * los de tesoreria
			 */
			this.consultarSaldosCaja(pObjUsuario,
									UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),
									 true);
			/*
			if	(	!booTramaTesoreria	)
			{
				if	(	!objDetalleSaldoMovCaja.getListSaldosMpa().isEmpty()	)
				{
					for(MedioPago objMedioPago : pObjUsuario.getMediosPago()){
						
						for	(	SaldoMedioPago objSaldoMedioPago	:	objDetalleSaldoMovCaja.getListSaldosMpa()	)
						{
							if	(	String.valueOf(objSaldoMedioPago.getIdMpa()).equals(objMedioPago.getId())){
								
								objMedioPago.setEgreso(objSaldoMedioPago.getEgresosMpa());
								objMedioPago.setIngreso(objSaldoMedioPago.getIngresosMpa());
								
								break;
							}
						}
					}
				}
			}
			*/
			mtrObjMediosPago = new Object[pObjUsuario.getMediosPago().size()][7];
			intContadorFila=0;
			
			for(MedioPago medioPagoUsuario : pObjUsuario.getMediosPago()){

				mtrObjMediosPago[intContadorFila][0]=medioPagoUsuario.getDescripcion();
				mtrObjMediosPago[intContadorFila][1]=medioPagoUsuario.getMoneda().getDescripcion();
				mtrObjMediosPago[intContadorFila][2]=medioPagoUsuario.getSaldoInicial();
				mtrObjMediosPago[intContadorFila][3]=medioPagoUsuario.getIngreso();
				mtrObjMediosPago[intContadorFila][4]=medioPagoUsuario.getEgreso();
				mtrObjMediosPago[intContadorFila][5]=medioPagoUsuario.getTraslado();
				mtrObjMediosPago[intContadorFila][6]=medioPagoUsuario.getSaldoFinal();

				intContadorFila++;
			}
			
			hmIngresosXConcepto = (HashMap<String,Concepto>)objRespuestaTrama.getValorAtributoObj("hmIngresosXConcepto");
			hmEgresosXConcepto = (HashMap<String,Concepto>)objRespuestaTrama.getValorAtributoObj("hmEgresosXConcepto");

			objInfoCierreCajaDTO = new InfoCierreCajaDTO(mtrObjMediosPago,
														 hmIngresosXConcepto,
														 hmEgresosXConcepto);
		}else{//respuesta negativa

			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}

		return objInfoCierreCajaDTO;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo cerrarCaja
	 * 		   Metodo encargado de efectuar el cierre de caja
	 * @throws Exception 
	 * 		   Recupera, controla y escala cualquier tipo de excepcion 
	 * 		   presentada 
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public void cerrarCaja(Usuario pObjUsuario,
						   HashMap<String,IngresoXDenominacion> pLstIngresoBilletes,
						   HashMap<String,IngresoXDenominacion> pLstIngresoMonedas,
						   HashMap<String,IngresoXDenominacion> pLstIngresoCheques,
						   HashMap<String,IngresoXDenominacion> pLstIngresoVales,
			  			   String pStrNotas) throws Exception {
		/**
		 * [Trama 16 | Cerrar Caja: Trama utilizada para realizar el cierre de caja]
		 */
		
		CierreCaja objEnvioTrama;
		RespuestaCierreCaja objRespuestaTrama;
		
		objEnvioTrama = new CierreCaja(pObjUsuario,
									   pLstIngresoBilletes,
									   pLstIngresoMonedas,
									   pLstIngresoCheques,
									   pLstIngresoVales,
									   pStrNotas,
									   EnumParametrosSistema.INFORMACION_VALE_EXTRA_COMPLETAR_SALDO_SIMS.obtenerObjParametro());

		//objRespuestaTrama = (RespuestaCierreCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaCierreCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		/**
		 * No se controla la respuesta positiva, puesto que el objeto Usuario.Caja, ha sido internamente autocompletado
		 * los valores de la respuesta, se encuentran adicionados en el obj Usuario.Caja enviando en la peticion
		 */
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
													   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
													   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}

	/**
	 * ****************************************************************.
	 * @metodo: aperturarCaja (Metodo)
	 * @descripcion: Metodo encargado de solicitar y procesar la respuesta
	 * 				 de la peticion bajo la trama 3, para realizar el 
	 * 				 proceso de apertura de caja ante el sistema de Sims
	 * @throws Exception: Recupera, controla y escala cualquier tipo de 
	 * 		   excepcion presentada 
	 * @autor: Hector Q-en-K
	 * ****************************************************************
	 */
	public void aperturarCaja(Usuario pObjUsuarioAutenticado) throws Exception{

		/**
		 * [Trama 3 | Aperturar Caja: Trama utilizada para realizar apertura de una caja.]
		 */

		AperturaCaja objEnvioTrama;
		RespuestaAperturaCaja objRespuestaTrama;
		
		objEnvioTrama = new AperturaCaja(pObjUsuarioAutenticado);

		//objRespuestaTrama = (RespuestaAperturaCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaAperturaCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {//respuesta positiva
			
			pObjUsuarioAutenticado.getCaja().setAbierta(true);
			
		}else{//respuesta negativa
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR, 
						   							   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"), 
						   							   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo ConsultaMovimientoCajaGiros
	 * 		   metodo para consultar los movimientos de cajas de giros
	 * @param  pStrFechaBusqueda
	 * 		   fecha en la que se realiza la busqueda
	 * @return DetalleSaldoMovCaja
	 * 		   Detalle de movimiento de la caja de giros
	 * @throws Exception
	 * @autor  Roberth Martinez Vargas
	 * ****************************************************************
	 */
	public DetalleSaldoMovCaja consultaMovimientoCajaGiros(Usuario pObjUsuario,
														   String pStrFechaBusqueda) throws Exception{
		
		ConsultaMovimientosCajaGiros objEnvioTrama;
		RespuestaConsultaMovimientosCajaGiros objRespuestaTrama;
		DetalleSaldoMovCaja objDetalleSaldoMovCaja = null;
		boolean booTramaTesoreria;
		
		objEnvioTrama = new ConsultaMovimientosCajaGiros(pObjUsuario,
														 pStrFechaBusqueda);
		
		//objRespuestaTrama = (RespuestaConsultaMovimientosCajaGiros)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaMovimientosCajaGiros)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (((String)objRespuestaTrama.getValorAtributoObj("tipoResultado")).equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			objDetalleSaldoMovCaja = (DetalleSaldoMovCaja) objRespuestaTrama.getValorAtributoObj("detalleSaldoMovCaja"); 
			
			booTramaTesoreria	=	this.consultarSaldosCaja(pObjUsuario,
															UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH().parse(pStrFechaBusqueda),
															false);
			if	(	!booTramaTesoreria	)
			{
				if	(	!objDetalleSaldoMovCaja.getListSaldosMpa().isEmpty()	)
				{
					for(MedioPago objMedioPago : pObjUsuario.getMediosPago()){
						
						for	(	SaldoMedioPago objSaldoMedioPago	:	objDetalleSaldoMovCaja.getListSaldosMpa()	)
						{
							if	(	String.valueOf(objSaldoMedioPago.getIdMpa()).equals(objMedioPago.getId())){
								
								objMedioPago.setSaldoInicial(objSaldoMedioPago.getSaldoInicialMpa());
								objMedioPago.setEgreso(objSaldoMedioPago.getEgresosMpa());
								objMedioPago.setIngreso(objSaldoMedioPago.getIngresosMpa());
								
								break;
							}
						}
					}
				}
			}
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String) objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   	     (String) objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return objDetalleSaldoMovCaja;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: ConsultaMovimientoProvisiones
	 * @descripcion: metodo para consultar los movimientos provisiones de la caja
	 * @param pStrFechaBusqueda
	 * 		  fecha en la que se realiza la busqueda
	 * @return MovimientoCaja
	 * 		   Movimiento caja con las provisiones
	 * @throws Exception
	 * @autor: Roberth Martinez Vargas
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	public MovimientoCaja consultaMovimientoProvisiones(Usuario pObjUsuarioAutenticado,
														String pStrFechaBusqueda) throws Exception{
		
		ConsulMoviProviDesem objEnvioTrama;
		RespuestaConsulMoviProviDesem objRespuestaTrama;
		MovimientoCaja objMovimientoCaja = null;
		
		objEnvioTrama= new ConsulMoviProviDesem(pObjUsuarioAutenticado, 
												"2", 
												pStrFechaBusqueda);
		
		//objRespuestaTrama = (RespuestaConsulMoviProviDesem)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsulMoviProviDesem)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributo("tipoResultado").equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			objMovimientoCaja = (MovimientoCaja) objRespuestaTrama.getValorAtributoObj("movCaja");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 objRespuestaTrama.getValorAtributo("codigoError"),
					   								   		 objRespuestaTrama.getValorAtributo("descripcionError"));
		}
		
		return objMovimientoCaja;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: ConsultaConceptosMovCaja
	 * @descripcion: metodo para consultar los conceptos de movimientos caja
	 * @param pIntNaturaleza
	 * 		  naturaleza del concepto
	 * @param pIntDocumento
	 * 		  documento del concepto
	 * @throws Exception
	 * @autor: Roberth Martinez Vargas
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public void consultaConceptosMovCaja(Usuario pObjUsuario,
										 int pIntNaturaleza, 
										 int pIntDocumento) throws Exception{
		
		ConsultaConceptosMovCaja objEnvioTrama;
		RespuestaConsultaConceptosMovCaja objRespuestaTrama;
		
		objEnvioTrama = new ConsultaConceptosMovCaja(pObjUsuario,
													 pIntNaturaleza, 
													 pIntDocumento);
		
		//objRespuestaTrama = (RespuestaConsultaConceptosMovCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaConceptosMovCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (((String)objRespuestaTrama.getValorAtributoObj("tipoResultado")).equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			if (pIntNaturaleza == EnumParametrosApp.CONCEPTO_NATURALEZA_EGRESO.getValorEntero()) {
				
				pObjUsuario.getEmpresa().setLstConceptosEgresos((List<Concepto>) objRespuestaTrama.getValorAtributoObj("lstConceptos"));
				
			}else if (pIntNaturaleza == EnumParametrosApp.CONCEPTO_NATURALEZA_INGRESO.getValorEntero()) {
				
				pObjUsuario.getEmpresa().setLstConceptosIngresos((List<Concepto>) objRespuestaTrama.getValorAtributoObj("lstConceptos"));
			}
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
															 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
															 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: ConsultaCajasProvisiones
	 * @descripcion: metodo para consultar las cajas disponibles para 
	 * 				 provisiones de una agencia
	 * @param pAgenciaDestino
	 * 		  agencia sobre la que se consultan las cajas para provisiones
	 * @throws Exception
	 * @autor: Roberth Martinez Vargas
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	@SuppressWarnings("unchecked")
	public List<Caja> consultaCajasProvisiones(Usuario pObjUsuario,
											   Agencia pAgenciaDestino) throws Exception{
		
		ConsultaCajasProvisiones objEnvioTrama;
		RespuestaConsultaCajasProvisiones objRespuestaTrama;
		List<Caja> lstCajas = null;
		
		objEnvioTrama = new ConsultaCajasProvisiones(pObjUsuario,
													 pAgenciaDestino);
		
		//objRespuestaTrama = (RespuestaConsultaCajasProvisiones)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultaCajasProvisiones)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())) {
			
			lstCajas = (List<Caja>) objRespuestaTrama.getValorAtributoObj("lstCajas");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return lstCajas;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: ProvisionCaja
	 * @descripcion: metodo para realizar provision de caja
	 * @param pObjConceptoEgreso
	 * 		  Concepto de egreso
	 * @param pObjAgenciaDestino
	 * 		  agencia sobre la que se realiza la provision
	 * @param pObjCajaDestino
	 *        Caja destino que se le realizara la provision
	 * @param pObjNumValorEgreso
	 *        valor de la provision
	 * @param pObjMedioPago
	 * 		  Medio de pago de provision
	 * @param pStrDocumentoAux
	 * 		  documento auxiliar del medio de pago
	 * @param pStrNotas
	 * 	      notas de la provision
	 * @param pStrTipoOperacion
	 * 		  Tipo de operacion provision o desembolso
	 * @param pStrHaceCommit
	 * @param pStrTipoDesembolso
	 * @throws Exception
	 * @autor: Roberth Martinez Vargas
	 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */
	public void provisionCaja(Usuario pObjUsuario,
							  Concepto pObjConceptoEgreso,
							  Agencia pObjAgenciaDestino,
							  Caja pObjCajaDestino,
							  Number pObjNumValorEgreso,
							  MedioPago pObjMedioPago,
							  String pStrDocumentoAux, 
							  String pStrNotas, 
							  String pStrTipoOperacion, 
							  String pStrHaceCommit, 
							  String pStrTipoDesembolso) throws Exception{
		
		ProvisionCaja objEnvioTrama;
		RespuestaProvisionCaja objRespuestaTrama;
		
		objEnvioTrama = new ProvisionCaja(pObjUsuario,
										  pObjConceptoEgreso, 
										  pObjAgenciaDestino, 
										  pObjCajaDestino, 
										  pObjNumValorEgreso, 
										  pObjMedioPago, 
										  pStrDocumentoAux, 
										  pStrNotas, 
										  pStrTipoOperacion, 
										  pStrHaceCommit, 
										  pStrTipoDesembolso);
		
		//objRespuestaTrama = (RespuestaProvisionCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaProvisionCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	public void aceptarDesembolso(Usuario pObjUsuarioAutenticado,
								  String pStrReferencia, 
								  String pStrNotas, 
								  Concepto pObjConcepto, 
								  MedioPago pObjMedioPago,
								  int pIntIdEstado, 
								  int pIntDocumento, 
								  String pStrValidaCaja)throws Exception{
		
		AceptaDesembolso objEnvioTrama;
		RespuestaAceptaDesembolso objRespuestaTrama;
		
		objEnvioTrama= new AceptaDesembolso(pObjUsuarioAutenticado,
											pStrReferencia, 
											pStrNotas, 
											pObjConcepto, 
											pObjMedioPago, 
											pIntIdEstado, 
											pIntDocumento, 
											pStrValidaCaja);
		
		//objRespuestaTrama=(RespuestaAceptaDesembolso)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaAceptaDesembolso)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if (objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_NEGATIVO_TRAMA_RESPUESTA.getValor())) {
					
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
							   						   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
							   						   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method ingresoEgreso
	 * 		   Metodo utilizado para ejecutar la peticion de ingreso y 
	 * 		   egreso de dindero de la caja
	 * @param  pObjUsuario
	 * 		   Usuario cajero que realiza la transaccion
	 * @param  pObjFactura
	 *         Objeto factura que contiene todo el detalle de la 
	 * 		   transaccion que se esta llevando a cabo
	 * @param  pStrOperacion
	 *         tipo operacion de la transaccion ingreso y egreso 
	 * @return objeto IngresoEgreso con la informacion resultante de la trama
	 * @throws Exception
	 *    	   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   22/8/2016
	 * *********************************************************************
	 */
	public IngresoEgreso ingresoEgreso(Usuario pObjUsuario,
									   Factura pObjFactura,
									   String pStrOperacion) throws Exception {

		/**
		 * [Trama 489 | Ingreso Egreso: Trama utilizada para realizar ingreso y egreso a caja.]
		 */
		
		RegistrarIngresoEgreso objEnvioTrama;
		RespuestaRealizarIngresoEgreso objRespuestaTrama;
		IngresoEgreso ingresoEgreso=null;
		
		pObjFactura.setStrIdTtransaccion(UtilidadesGiros.getInstance().obtenerIdTransaccion(pObjUsuario));
		
		objEnvioTrama = new RegistrarIngresoEgreso(pObjUsuario, 
												   pObjFactura,
												   pStrOperacion);

		//objRespuestaTrama = (RespuestaRealizarIngresoEgreso)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaRealizarIngresoEgreso)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);

		if(objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())){
		
			ingresoEgreso = (IngresoEgreso) objRespuestaTrama.getValorAtributoObj("ingresoEgreso");
			
		}else{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return ingresoEgreso;
	}
	
	/** 
	 * ********************************************************************
	 * @method	consultarTipoBiometriaCaja
	 * 		  	Metodo que permite consultar el tipo de biometria configurado
	 * 			para la caja (Local o Central)
	 * @param  	pObjUsuario
	 * 		   	Usuario cajero que realiza la transaccion
	 * @return	EnumTiposBiometriaCaja
	 * 			Constante de enumeracion que identifica el tipo de biometria
	 * 			configurado para la caja 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	28/08/2017
	 * *********************************************************************
	 */
	public EnumTiposBiometriaCaja consultarTipoBiometriaCaja(	Usuario pObjUsuario	) 
			throws Exception
	{
		/**
		 * [Trama 466 | Consultar tipo biometria caja: permite consultar la configuracion biometrica de una caja (L: Local, C: Central, M: Multiservicio)]
		 */
		
		ConsultarTipoBiometriaCaja objEnvioTrama;
		RespuestaConsultarTipoBiometriaCaja objRespuestaTrama;
		EnumTiposBiometriaCaja enmTipoBiometriaCaja;
		
		objEnvioTrama = new ConsultarTipoBiometriaCaja(pObjUsuario);
		
		//objRespuestaTrama = (RespuestaConsultarTipoBiometriaCaja)ProcesadorTramas.getInstance().procesarPeticion(objEnvioTrama);
		objRespuestaTrama = (RespuestaConsultarTipoBiometriaCaja)UtilVistaLogica.getInstance().realizarPeticion(objEnvioTrama);
		
		if	(	objRespuestaTrama.getValorAtributoObj("tipoResultado").toString().equalsIgnoreCase(EnumGeneralidadesTramasGiros.ESTADO_POSITIVO_TRAMA_RESPUESTA.getValor())	)
		{	
			enmTipoBiometriaCaja = UtilTiposBiometriaCaja.getInstance ().getHmEnmTiposBiometriaCaja ().get ( (String) objRespuestaTrama.getValorAtributoObj("strTipoBiometria") );
			
			//enmTipoBiometriaCaja = EnumTiposBiometriaCaja.LOCAL;
			
			if	(	enmTipoBiometriaCaja	==	null	)
			{
				enmTipoBiometriaCaja	=	EnumTiposBiometriaCaja.CENTRAL;
			} else if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
			{
				UtilWSQ.getInstance ().desplegarHiloTransmisorWSQ ();
			}
			
			if	(	EnumTiposBiometriaCaja.MULTISERVICIO.equals ( enmTipoBiometriaCaja )	)
			{
				UtilIntegracionAccesoCajaMultiservicio.getInstancia().activar(OperacionesBiometriaMultiservicio.getInstance());
			}else{
				UtilIntegracionAccesoCajaMultiservicio.getInstancia().desactivar();
			}
			
		}	else	{
			
			throw EnumMensajes.generarExcepcionPersonalizada(EnumClasesMensaje.ERROR,	
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("codigoError"),
					   								   		 (String)objRespuestaTrama.getValorAtributoObj("descripcionError"));
		}
		
		return enmTipoBiometriaCaja;
	}
}
