package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaConsultaMovimientosCajaGiros;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.ConMoviCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DetalleSaldoMovCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.SaldoConceptoCaja;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ********************************************************************
 * @class  	EventoFormaConsultaMovimientosCajaGiros
 *		   	Clase encargada de controlar los eventos de la forma de  
 * 		  	consulta de movimientos de caja
 * @author 	Roberth Martinez Vargas
 * @date   	30/11/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaConsultaMovimientosCajaGiros extends EventoAbstracto{
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	EventoFormaAperturarCaja
  	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
  	 * @param 	pForma 
  	 * 		  	referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public	EventoFormaConsultaMovimientosCajaGiros	(	FormaGenerica pForma	)	throws	Exception
	{
		super(pForma);
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		/**
		 * Seccion de Obliegatoridad de Campos
		 */
		this.castFrmConsultaMovCajaGiros().getDtcFechaConsulta().getLblObligatorio().aplicarObligatoriedad(true);
		
	}
	
	@Override
	public void consultar() throws Exception{
		
		DetalleSaldoMovCaja objDtoDetalleSaldoMovCaja;
		
		this.limpiar();
		this.validarParametrosConsulta();
		
		objDtoDetalleSaldoMovCaja = CajaVistaLogica.getInstance().consultaMovimientoCajaGiros	(	super.getObjUsuario(),
																									this.castFrmConsultaMovCajaGiros().getDtcFechaConsulta().toString()
																								);
		this.cargarDetalleConsulta(objDtoDetalleSaldoMovCaja);
	}
	
	@Override
	public	void	limpiar	() 
			throws Exception 
	{
		super.limpiar(true, this.castFrmConsultaMovCajaGiros().getDtcFechaConsulta());
	}
	
	/**
	 * ********************************************************************
	 * @method 	limpiarDatosTablas
	 * 		   	Metodo que permite restablecer y limpiar la informacion 
	 * 			consultada sobre el formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	Roberth Martinez Vargas
	 * @date   	30/11/2016
	 * *********************************************************************
	 */
	/*
	private void limpiarFormulario()throws Exception{
		
		this.castFrmConsultaMovCajaGiros().getTblDetalleMovimientos().getPropiedades().limpiarGrilla();
		this.castFrmConsultaMovCajaGiros().getTblSaldosMedioPago().getPropiedades().limpiarGrilla();
		this.castFrmConsultaMovCajaGiros().getTblTotalXmedioPagoConcepto().getPropiedades().limpiarGrilla();
	}
	*/
	
	/**
	 * ********************************************************************
	 * @method 	validarFechaConsulta
	 * 		   	Metodo que permite validar la fecha ingresada para proceder 
	 * 			con la consulta
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	Roberth Martinez Vargas
	 * @date   	30/11/2016
	 * *********************************************************************
	 */
	private void validarParametrosConsulta() throws Exception{
		
		Date datFechaActual;
		Date datFechaConsulta;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios	(	this.getFrmForma(), 
																		true, 
																		true
																	);
		
		datFechaActual 		=	UtilidadGiros.getInstancia().obtenerFechaSinHora(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
		datFechaConsulta	=	this.castFrmConsultaMovCajaGiros().getDtcFechaConsulta().getDate();
		
		if	(	datFechaConsulta.compareTo(datFechaActual)>0	)
		{
			throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion	(	EnumClasesMensaje.ERROR, 
																			EnumEtiquetas.LBL_MCG_BUSQUEDA.toString(),
																			EnumEtiquetas.LBL_FECHA_ACTUAL.toString()
																		);
		}
	}
	
	/**
     * ****************************************************************
     * @metodo: addFila
     * @descripcion: metodo encargado de llamas a los diferentes metodos que procesan
     * 				la informacion recibida y la insertan en las grillas.
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	
	/**
	 * ********************************************************************
	 * @method 	cargarDetalleConsulta
	 * 		   	Metodo que permite cargar el detalle de la consulta en los
	 * 			diferentes componentes graficos habilitados para ello
	 * @param 	pObjDtoDetalleSaldoMovCaja
	 * 			Objeto DTO que contiene el detalle de la consulta ejecutada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	Roberth Martinez Vargas
	 * @date   	30/11/2016
	 * *********************************************************************
	 */
	public void cargarDetalleConsulta(DetalleSaldoMovCaja pObjDtoDetalleSaldoMovCaja) throws Exception{

		List<SaldoConceptoCaja> lstObjSaldosConceptoCajaIngresos = pObjDtoDetalleSaldoMovCaja.getListSaldoConCjaIngr();
		List<SaldoConceptoCaja> lstObjSaldosConceptoCajaEgresos = pObjDtoDetalleSaldoMovCaja.getListSaldoConCjaEgr();

		this.cargarSaldosCajaXConcepto(lstObjSaldosConceptoCajaIngresos);
		this.cargarSaldosCajaXConcepto(lstObjSaldosConceptoCajaEgresos);

		this.cargarDetalleMovimientosCaja(pObjDtoDetalleSaldoMovCaja);
		this.cargarSaldosXMediosPago();

	}
	
	/**
	 * ********************************************************************
	 * @method 	cargarSaldosCajaXConcepto
	 * 		   	Metodo que permite realizar la carga de informacion para los 
	 * 			saldos de caja x concepto (ingreso/egreso)
	 * @param 	pLstObjSaldosConceptoCaja
	 * 			Listado de saldos de concepto de caja, puede representar un
	 * 			listado de conceptos de ingreso o egreso 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	Roberth Martinez Vargas
	 * @date   	30/11/2016
	 * *********************************************************************
	 */
	private	void	cargarSaldosCajaXConcepto	(	List<SaldoConceptoCaja> pLstObjSaldosConceptoCaja	)	throws	Exception
	{
		Object[] arrObjSaldoCajaXConcepto;
		Iterator<SaldoConceptoCaja> iter = pLstObjSaldosConceptoCaja.iterator();

		Double ingresos = 0.0;

		Double egresos = 0.0;

		while (iter.hasNext()) {

			SaldoConceptoCaja conceptoCaja = iter.next();

			if (conceptoCaja.getIdNat() == 33){
				ingresos = conceptoCaja.getValor();
			}else if (conceptoCaja.getIdNat() == 34){
				egresos = conceptoCaja.getValor();
			}
			arrObjSaldoCajaXConcepto = new Object[] { conceptoCaja.getConCount()+"",
								  conceptoCaja.getDescMpa(), conceptoCaja.getDescCon(),
								  ingresos, egresos };
			
			this.castFrmConsultaMovCajaGiros().getTblTotalXmedioPagoConcepto().getPropiedades().adicionarFilaGrilla(arrObjSaldoCajaXConcepto);
		}
		
		//this.castFrmConsultaMovCajaGiros().getTblTotalXmedioPagoConcepto().getRowSorter().toggleSortOrder(0);
	}
	
	/**
	 * ********************************************************************
	 * @method 	cargarDetalleMovimientosCaja
	 * 		   	Metodo que permite realizar la carga de informacion para el 
	 * 			detalle de movimientos de caja
	 * @param 	pObjDtoDetalleSaldoMovCaja
	 * 			Objeto DTO que contiene el detalle de la consulta ejecutada 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	Roberth Martinez Vargas
	 * @date   	30/11/2016
	 * *********************************************************************
	 */
	private void cargarDetalleMovimientosCaja(DetalleSaldoMovCaja pObjDtoDetalleSaldoMovCaja) throws Exception{
		
		Object[] arrObjDetalleMovimientosCaja;
		
		Double ingresos = 0.0;

		Double egresos = 0.0;
		Iterator<Object> iter = null;
		
		ConMoviCaja conMoviCja = null;
		
		List<Object> listConMoviCja = pObjDtoDetalleSaldoMovCaja
				.getListConMoviCja();
		
		if(listConMoviCja != null){
			
			iter = listConMoviCja.iterator();

			while (iter.hasNext()) {
				conMoviCja = (ConMoviCaja) iter.next();
				
				ingresos = 0.0;
				egresos = 0.0;

				if (conMoviCja.getIdNat() == 33){
					ingresos = conMoviCja.getValor();
				}else if (conMoviCja.getIdNat() == 34){
					egresos = conMoviCja.getValor();
				}
				arrObjDetalleMovimientosCaja = new Object[] { conMoviCja.getDescMon(),
						conMoviCja.getDescMpa(), conMoviCja.getDescCon(),
						conMoviCja.getFecha(), conMoviCja.getHora(),
						conMoviCja.getRefControl().toString(), ingresos, egresos };
				
				this.castFrmConsultaMovCajaGiros().getTblDetalleMovimientos().getPropiedades().adicionarFilaGrilla(arrObjDetalleMovimientosCaja);

			}
			//this.castFrmConsultaMovCajaGiros().getTblDetalleMovimientos().getRowSorter().toggleSortOrder(0);
		}
	}
	
	/**
	 * ********************************************************************
	 * @method 	cargarSaldosXMediosPago
	 * 		   	Metodo que permite realizar la carga de informacion para los
	 * 			saldos x medios de pago
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	Roberth Martinez Vargas
	 * @date   	30/11/2016
	 * *********************************************************************
	 */
	private void cargarSaldosXMediosPago() throws Exception{

		Object[][] mtrObjSaldosXMediosPago;
		int intContadorFila;
		
		mtrObjSaldosXMediosPago = new Object[super.getObjUsuario().getMediosPago().size()][7];
		intContadorFila=0;
		
		for(MedioPago medioPagoUsuario : super.getObjUsuario().getMediosPago()){

			mtrObjSaldosXMediosPago[intContadorFila][0]=medioPagoUsuario.getDescripcion();
			mtrObjSaldosXMediosPago[intContadorFila][1]=medioPagoUsuario.getMoneda().getDescripcion();
			mtrObjSaldosXMediosPago[intContadorFila][2]=medioPagoUsuario.getSaldoInicial();
			mtrObjSaldosXMediosPago[intContadorFila][3]=medioPagoUsuario.getIngreso();
			mtrObjSaldosXMediosPago[intContadorFila][4]=medioPagoUsuario.getEgreso();
			mtrObjSaldosXMediosPago[intContadorFila][5]=medioPagoUsuario.getTraslado();
			mtrObjSaldosXMediosPago[intContadorFila][6]=medioPagoUsuario.getSaldoFinal();

			intContadorFila++;
		}
		
		this.castFrmConsultaMovCajaGiros().getTblSaldosMedioPago().getPropiedades().adicionarFilasGrilla(mtrObjSaldosXMediosPago);
		
		//this.castFrmConsultaMovCajaGiros().getTblSaldosMedioPago().getRowSorter().toggleSortOrder(0);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	castFrmConsultaMovCajaGiros
  	 * 		   	Metodo estandar para formatear el tipo de dato general a 
  	 * 		   	un tipo especifico ("Casteo"), del atributo frmPadre
  	 * @return 	FormaConsultaMovimientosCajaGiros
  	 * 		   	valor especifico recuperado
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
  	 * @autor 	Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaConsultaMovimientosCajaGiros castFrmConsultaMovCajaGiros() throws Exception{
		return (FormaConsultaMovimientosCajaGiros)super.getFrmForma();
	}

}
