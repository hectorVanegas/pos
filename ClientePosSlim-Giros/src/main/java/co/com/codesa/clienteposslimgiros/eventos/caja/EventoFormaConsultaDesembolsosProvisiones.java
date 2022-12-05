package co.com.codesa.clienteposslimgiros.eventos.caja;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaConsultaDesembolsosProvisiones;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Movimiento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MovimientoCaja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TotalMovCaja;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 14-abril-2015
 * @descripcion: Clase que representa los eventos de forma consulta 
 * 				 desembolsos provisiones
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaConsultaDesembolsosProvisiones  extends EventoAbstracto{
	
	private int filaSelec;
	private int colSelec;
	private String objSeleccionado;
	private String strFechaBus;
	private Long lngValor;
	private Vector vecMovCajas;
	private TreeMap tmTotales;
	
	private TotalMovCaja totalMovCaja;
	private MovimientoCaja movCaja;
	
	public EventoFormaConsultaDesembolsosProvisiones(FormaGenerica pForma) {
		super(pForma);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValores
  	 * 		   Metodo que permite desacoplar y centralizar todo el 
  	 * 		   despliegue logico inicial requerido por la funcionalidad 
  	 * 		   una vez desplegada la GUI
  	 * @param pArrObjParametrosForma
  	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{}

	@Override
	public void actionPerformed(ActionEvent pEvtActionPerformed) {
		try {
			Component component = (Component) pEvtActionPerformed.getSource();
			
			if(component.getName().equals(EnumBotonesEncabezado.BTNCONSULTAR.getCodigo())){
				this.consultar();
			}else if(component.getName().equals(EnumBotonesEncabezado.BTNSALIR.getCodigo())){
				this.cerrarVentana();
			}
		}catch (Exception e1) {
			super.controlExcepcion(e1);
		}
	}

	@Override
	public void keyReleased(KeyEvent pEvtKeyReleased) {
	}

	@Override
	public void keyTyped(KeyEvent pEvtKeyTyped) {
	}

	@Override
	public void keyPressed(KeyEvent pEvtKeyPressed) {
	}

	@Override
	public void itemStateChanged(ItemEvent pEvtItemStateChanged) {
	}

	@Override
	public void focusGained(FocusEvent pEvtFocusGained) {
	}

	@Override
	public void focusLost(FocusEvent pEvtFocusLost) {
	}

	/**
     * ****************************************************************
     * @metodo: mouseClicked
     * @descripcion: metodo para manejar los eventos del mouse, se controla 
     * 				cuando se da doble clic sobre la grilla para mostrar informacion de las columnas
     * @autor: Roberth Martinez Vargas
     *         ****************************************************************
     */
	@Override
	public void mouseClicked(MouseEvent pEvtMouseClicked) {
		
		Component component;
		try {
			
			component = (Component) pEvtMouseClicked.getSource();
			
			if(component.equals(this.castfrmConsultaDesemProvi().getTblMovProvisiones())){
				
				this.filaSelec = this.castfrmConsultaDesemProvi().getTblMovProvisiones().getSelectedRow();
				this.colSelec = this.castfrmConsultaDesemProvi().getTblMovProvisiones().getSelectedColumn();
				
				if (pEvtMouseClicked.getClickCount() == 2) {
					
					this.objSeleccionado = this.castfrmConsultaDesemProvi().getTblMovProvisiones().getValueAt(this.filaSelec, this.colSelec).toString();
					
					this.verInfoColumna();
				}
			}	
		} catch (Exception e) {
			super.controlExcepcion(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent pEvtMousePressed) {
	}

	@Override
	public void mouseReleased(MouseEvent pEvtMouseReleased) {
	}

	@Override
	public void mouseEntered(MouseEvent pEvtMouseEntered) {
	}

	@Override
	public void mouseExited(MouseEvent pEvtMouseExited) {
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: cerrarVentana (Metodo)
  	 * @descripcion: Metodo para cerrar la ventana padre
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void cerrarVentana() throws Exception {
		this.castfrmConsultaDesemProvi().dispose();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: consultar (Metodo)
  	 * @descripcion: Metodo para realizar la consulta de los movimientos provisiones
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void consultar() throws Exception {
		this.limpiarTablas();
		this.validaFechas();
		this.movCaja = CajaVistaLogica.getInstance().consultaMovimientoProvisiones(super.getObjUsuario(),
																				   strFechaBus);
		if(this.movCaja !=null && this.movCaja.getVecMovCajas()!=null){
			this.adicionarMovProvisiones();
			this.adicionarConceptos();
			this.adicionaMoneda();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: adicionarMovProvisiones (Metodo)
  	 * @descripcion: Metodo para realizar insercion de los datos a la tabla de provisiones
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void adicionarMovProvisiones() throws Exception {
		this.vecMovCajas = this.movCaja.getVecMovCajas();
		Movimiento movimiento = null;
		this.getTmTotales();
		this.lngValor = 0L;
		for (int i = 0; i < this.vecMovCajas.size(); i++) {
			movimiento = (Movimiento) this.vecMovCajas.get(i);
			this.lngValor += movimiento.getValor();
			this.castfrmConsultaDesemProvi().getTblMovProvisiones().getPropiedades().adicionarFilaGrilla(movimiento.getFila());
			this.evaluarTotal(movimiento);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: adicionarConceptos (Metodo)
  	 * @descripcion: Metodo para realizar insercion de los datos a la tabla de Conceptos
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void adicionarConceptos() throws Exception
	{
		Iterator iter = this.tmTotales.keySet().iterator();

		Object[] objData = null;

		while (iter.hasNext())
		{
			totalMovCaja = (TotalMovCaja) tmTotales.get(iter.next());

			if (totalMovCaja.getTipo() == EnumParametrosApp.CONCEPTO.getValorEntero())
			{
				objData = new Object[3];

				objData[0] = totalMovCaja.getNum()+"";
				objData[1] = totalMovCaja.getDescricion();
				objData[2] = new Double(totalMovCaja.getIngresos());

				this.castfrmConsultaDesemProvi().getTblConcepto().getPropiedades().adicionarFilaGrilla(objData);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: adicionaMoneda (Metodo)
  	 * @descripcion: Metodo para realizar insercion de los datos a la tabla de Monedas
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void adicionaMoneda() throws Exception
	{
		Iterator iter = this.tmTotales.keySet().iterator();

		Object[] objData = null;

		while (iter.hasNext())
		{
			totalMovCaja = (TotalMovCaja) tmTotales.get(iter.next());

			if (totalMovCaja.getTipo() == EnumParametrosApp.MONEDA.getValorEntero())
			{
				objData = new Object[3];

				objData[0] = totalMovCaja.getMoneda();
				objData[1] = totalMovCaja.getMedioPago();
				objData[2] = new Double(totalMovCaja.getIngresos());

				this.castfrmConsultaDesemProvi().getTblMoneda().getPropiedades().adicionarFilaGrilla(objData);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: limpiarTablas (Metodo)
  	 * @descripcion: Metodo para limpiar datos de las tablas
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void limpiarTablas() throws Exception {
		
		this.castfrmConsultaDesemProvi().getTblMovProvisiones().getPropiedades().limpiarGrilla();
		this.castfrmConsultaDesemProvi().getTblConcepto().getPropiedades().limpiarGrilla();
		this.castfrmConsultaDesemProvi().getTblMoneda().getPropiedades().limpiarGrilla();
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: validaFechas
     * @descripcion: Valida las fechas ingresadas y setea el nuevo formato
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validaFechas() throws Exception{
		
		
		if (this.castfrmConsultaDesemProvi().getDtcFechaBus().getDate() == null) {
			
			throw EnumMensajes.CAMPO_OBLIGATORIO.generarExcepcion(EnumClasesMensaje.ERROR, 
															"fecha");
		}

		//this.strFechaBus = CtrlUtilidad.getINSTANCIA().getFecha(this.castfrmConsultaDesemProvi().getDtcFechaBus().getDate());
		this.strFechaBus = this.castfrmConsultaDesemProvi().getDtcFechaBus().toString();
	}
	
	/**
     * ****************************************************************
     * @metodo: verInfoColumna
     * @descripcion: metodo para mostrar la informacion de las columnas 
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	private void verInfoColumna() throws Exception{
		
		if (this.objSeleccionado != null){
			
			EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
													   EnumClasesMensaje.INFORMACION, 
													   null, 
													   this.objSeleccionado);
		}			
		
	}
	
	private TreeMap getTmTotales()
	{
		if (tmTotales == null){
			tmTotales = new TreeMap();
		}else tmTotales.clear();

		return tmTotales;
	}
	
	private void evaluarTotal(Movimiento movCaja) throws Exception
	{
		/**
		 * MONEDA
		 */

		totalMovCaja = (TotalMovCaja) tmTotales.get(EnumParametrosApp.MONEDA.getValorPropiedad()+ movCaja.getMoneda());

		if (totalMovCaja != null){
			sumValue(movCaja, totalMovCaja);
		}else{

			totalMovCaja = new TotalMovCaja();
			totalMovCaja.setTipo(EnumParametrosApp.MONEDA.getValorEntero());
			totalMovCaja.setDescricion(movCaja.getMoneda());
			totalMovCaja.setMedioPago(movCaja.getMedioPago());
			totalMovCaja.setMoneda(movCaja.getMoneda());

			sumValue(movCaja, totalMovCaja);

			tmTotales.put(EnumParametrosApp.MONEDA.getValorPropiedad() + movCaja.getMoneda(), totalMovCaja);
		}

		/**
		 * CONCEPTO
		 */
		totalMovCaja = (TotalMovCaja) tmTotales.get(EnumParametrosApp.CONCEPTO.getValorPropiedad()+ movCaja.getConcepto());

		if (totalMovCaja != null)
		{
			sumValue(movCaja, totalMovCaja);
		}
		else
		{
			totalMovCaja = new TotalMovCaja();
			totalMovCaja.setTipo(EnumParametrosApp.CONCEPTO.getValorEntero());
			totalMovCaja.setDescricion(movCaja.getConcepto());

			sumValue(movCaja, totalMovCaja);

			tmTotales.put(EnumParametrosApp.CONCEPTO.getValorPropiedad()+ totalMovCaja.getDescricion(), totalMovCaja);
		}
	}
	
	private void sumValue(Movimiento movCaja, TotalMovCaja totalMovCaja)
	{
		int ingresos = totalMovCaja.getIngresos().intValue();

		ingresos += movCaja.getValor().intValue();

		totalMovCaja.setIngresos(Long.valueOf("" + ingresos));
		totalMovCaja.add();
	}
	
	
	/**
  	 * ****************************************************************.
  	 * @metodo: castfrmConsultaDesemProvi (Metodo)
  	 * @descripcion: Metodo estandar para formatear el tipo de dato 
  	 * 				 general a un tipo especifico ("Casteo"), del atributo
  	 * 				 frmConsultaDesemProvi
  	 * @return: FormaConsultaDesembolsosProvisiones, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaConsultaDesembolsosProvisiones castfrmConsultaDesemProvi()throws Exception{
		return (FormaConsultaDesembolsosProvisiones)super.getFrmForma();
	}
}
