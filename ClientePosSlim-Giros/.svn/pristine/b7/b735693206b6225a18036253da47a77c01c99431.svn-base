package co.com.codesa.clienteposslimgiros.eventos.componentesGUI;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesGrilla;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 18-jun-2015 
 * @clase EventoCompGrillaUtil
 * 		  Clase encargada de controlar los eventos de un componente de 
 * 		  grilla
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoCompGrillaUtil extends EventoAbstracto implements PropiedadesGrilla{
	
	private GrillaUtil cmpComponenteGrilla;
	
	private List<RowFilter<Object, Object>> lstFiltrosXColumna;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoCompGrillaUtil 
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pComponente
  	 * 		  referencia al componente de grilla del cual se estan 
  	 * 		  controlando los eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoCompGrillaUtil(GrillaUtil pComponente) throws Exception{
		
		this.setCmpComponenteGrilla(pComponente);
		
		this.inicializarPropiedades();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarUtilidades 
  	 * 		   Metodo encargado de inicializar aspectos relacionados con
  	 * 		   las diferentes utilidades a incorporar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void inicializarPropiedades()throws Exception{}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarIngresoXCaracter
  	 * 		   Metodo utilizado para centralizar y desacoplar las 
  	 * 		   acciones producidas como evento, cuando se va a realizar 
  	 * 		   un ingreso de cualquier caracter por teclado. Este evento
  	 * 		   se activa antes que el caracter ingresado se procese sobre 
  	 * 		   el componente grafico  
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pChrIngreso
  	 * 		  caracter que va a hacer asociado al componente grafico y 
  	 * 		  que fue capturado previo a esta asociacion por este evento
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public boolean accionarIngresoXCaracter(Component pComponent, 
											char pChrIngreso,
											KeyEvent pEvtKeyTyped) throws Exception {
		
		EditorCeldaGrilla objEditorCelda;
		JTable tblGrilla;
		TableColumn objColumnaSeleccionada;
		int intFilaSeleccionada;
		int intColumnaSeleccionada;
		boolean booAnularIngreso;
		boolean booCeldaEditable;
		
		booAnularIngreso = super.accionarIngresoXCaracter(pComponent, 
					  									  pChrIngreso,
					  									  pEvtKeyTyped);
		
		if(pComponent instanceof JTable){
			
			tblGrilla = (JTable)pComponent;
			intFilaSeleccionada = tblGrilla.getSelectedRow();
			intColumnaSeleccionada = tblGrilla.getSelectedColumn();
			
			if(intFilaSeleccionada >= 0 &&
					intColumnaSeleccionada >=0 ){
			
				booCeldaEditable = tblGrilla.getModel().isCellEditable(intFilaSeleccionada, 
						 											   intColumnaSeleccionada);
				
				objColumnaSeleccionada = tblGrilla.getColumnModel().getColumn(intColumnaSeleccionada);
				
				if(booCeldaEditable 
						&& objColumnaSeleccionada.getCellEditor() instanceof EditorCeldaGrilla){
					
					objEditorCelda = (EditorCeldaGrilla)objColumnaSeleccionada.getCellEditor();
					
					objEditorCelda.getComponent().requestFocus();
					
					pEvtKeyTyped.setSource(objEditorCelda.getComponent());
					objEditorCelda.getComponent().dispatchEvent(pEvtKeyTyped);
					
					booAnularIngreso = true;
				}
			}
		}
		
		return booAnularIngreso;
	}
	
	@Override
	public	void	accionarIngresoPresionado	(	Component pComponent, 
													KeyEvent pEvtKeyPressed
												) 
														throws Exception 
	{
		if	(		pEvtKeyPressed.isShiftDown()
				&&	pEvtKeyPressed.getKeyCode()	==	KeyEvent.VK_TAB
			)
		{
			pEvtKeyPressed.getComponent().transferFocusBackward();
			
		}	else	if	(	pEvtKeyPressed.getKeyCode()	==	KeyEvent.VK_TAB	)
		{
			pEvtKeyPressed.getComponent().transferFocus();
		}
	}
	
	@Override
	public void adicionarFilaGrilla(Object fila[])throws Exception{
		
		this.cmpComponenteGrilla.getObjModelo().addRow(fila);
	}
	
	@Override
	public void adicionarFilasGrilla(Object filas[][])throws Exception{
		
		for(Object fila[] : filas){
			this.adicionarFilaGrilla(fila);
		}
	}
	
	@Override
	public void limpiarGrilla()throws Exception{
		
		this.cmpComponenteGrilla.getObjModelo().setNumRows(0);
	}
	
	@Override
	public void removerFilaGrilla(int pIntFila)throws Exception{

		this.cmpComponenteGrilla.getObjModelo().removeRow(pIntFila);
	}
	
	@Override
	public void detectarRegistroGrilla(int pIntFila,
			   						   int pIntColumna)throws Exception{
		
		EditorCeldaGrilla objEditorCelda;
		TableCellEditor objTableCellEditor;
		
		/**
		 * [Q-en-K]: Se remueve la consideracion de aplicar el foco sobre la grilla dada una excepcion 
		 * 			 por motivos de irregularidad cuando se intenta acceder, posterior al error, para 
		 * 			 corregir el valor del campo
		 */
		//tblDatosAdicionalesXMedioPago.requestFocus();
		
		if(pIntFila >= 0){
			
			this.cmpComponenteGrilla.setRowSelectionInterval(pIntFila, 
															 pIntFila);
		}
		
		if(pIntColumna >= 0){
		
			this.cmpComponenteGrilla.setColumnSelectionInterval(pIntColumna, 
					  							  				pIntColumna);
		}
		
		objTableCellEditor = this.cmpComponenteGrilla.getCellEditor(pIntFila, 
				  													pIntColumna);
		
		if(objTableCellEditor instanceof EditorCeldaGrilla){
			
			objEditorCelda = (EditorCeldaGrilla)objTableCellEditor;
			objEditorCelda.getComponent().requestFocus();
		}
	}
	
	@Override
	public void aplicarFiltroSimple(String pStrCadena, 
						  	  	    int pIntColumna)throws Exception{
		
		String strCadena;
		/*
		String strCaracterTemporal;
		
		for(char chrCaracter : pStrCadena.toCharArray()){
			
			strCaracterTemporal = String.valueOf(chrCaracter);
			
			if(UtilidadesGiros.getInstance().validaFormato(EnumExpresionesRegulares.GENERICA_CARACTERES_RESERVADOS.getValor(), 
														   strCaracterTemporal)){
				
				strCaracterTemporal = "\\"+strCaracterTemporal;
			}
			
			strCadena += strCaracterTemporal;
		}
		*/
		strCadena = EnumExpresionesRegulares.escaparCaracteresEspeciales(pStrCadena);
		this.aplicarFiltroExpresion(strCadena,
						   pIntColumna);
	}
	
	/*public static void main(String[] args) {
		
		String strCadena = "-";
		String strFormato = "[\\[\\]\\{\\}\\(\\)\\+\\*\\?\\|\\.\\^\\$\\\\\\-]";
		
		try{
			
			System.out.println(UtilidadesGiros.getInstance().validaFormato(strFormato, strCadena));
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}*/
	
	@Override
	public void aplicarFiltroExpresion(String pStrFormato, 
		  	  				   		   int pIntColumna)throws Exception{
		
		this.getLstFiltrosXColumna().set(pIntColumna, 
				 						 RowFilter.regexFilter(pStrFormato, 
				 								 			   pIntColumna));

		this.obtenerTableRowSorter().setRowFilter(RowFilter.andFilter(this.getLstFiltrosXColumna()));
	}
	
	private void iniciarFiltros()throws Exception{
		
		String strFormato;
		
		strFormato = EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor();
		
		this.lstFiltrosXColumna = new ArrayList<RowFilter<Object, Object>>();
		
		for(int i=0 ; i<this.getCmpComponenteGrilla().getColumnCount() ; i++){
			
            this.lstFiltrosXColumna.add(RowFilter.regexFilter(strFormato, i));
        }
	}
	
	@Override
	public void reiniciarFiltros()
			throws Exception
	{
		this.setLstFiltrosXColumna(null);
		this.obtenerTableRowSorter().setRowFilter(RowFilter.andFilter(this.getLstFiltrosXColumna()));
	}
	
	public List<RowFilter<Object, Object>> getLstFiltrosXColumna() throws Exception{
		
		if(this.lstFiltrosXColumna == null){
			
			this.iniciarFiltros();
		}
		
		return this.lstFiltrosXColumna;
	}
	
	
	@SuppressWarnings("unchecked")
	public TableRowSorter<TableModel> obtenerTableRowSorter()throws Exception{
		
		if	(	this.getCmpComponenteGrilla().getRowSorter()	==	null	)
		{
			this.cmpComponenteGrilla.activarOrdenamiento(true);
		}
		
		return (TableRowSorter<TableModel>)this.getCmpComponenteGrilla().getRowSorter();
	}

	public void setLstFiltrosXColumna(
			List<RowFilter<Object, Object>> lstFiltrosXColumna) {
		this.lstFiltrosXColumna = lstFiltrosXColumna;
	}

	public GrillaUtil getCmpComponenteGrilla() {
		return cmpComponenteGrilla;
	}

	public void setCmpComponenteGrilla(GrillaUtil cmpComponenteGrilla) {
		this.cmpComponenteGrilla = cmpComponenteGrilla;
	}
	
}
