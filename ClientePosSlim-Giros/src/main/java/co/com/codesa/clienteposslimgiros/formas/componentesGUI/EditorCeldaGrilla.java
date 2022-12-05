package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.JTextComponent;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;

public class EditorCeldaGrilla extends DefaultCellEditor implements TableCellRenderer {

	private static final long serialVersionUID = 8373081539404039515L;
	
	//private FormaGenerica forma;
	private JTable tblGrilla;
	private boolean booAdministradoXComponente;
	private FocusListener evtControlFocos;
	
	public EditorCeldaGrilla(CajaTextoUtil pCajaTextoUtil,
							 FormaGenerica pForma){
		
		super(pCajaTextoUtil);
		//this.forma = pForma;
		this.inicializarControlEventos(pCajaTextoUtil);
	}
	
	private void inicializarControlEventos(JComponent pObjComponent){
		
		List<FocusListener> lstFocusListener;
		
		lstFocusListener = Arrays.asList(pObjComponent.getFocusListeners());
		
		if (!lstFocusListener.contains(this.getEvtControlFocos())) {
			
			pObjComponent.addFocusListener(this.getEvtControlFocos());
		}
	}
	public EditorCeldaGrilla(CajaComboUtil pCajaComboUtil,
			 				 FormaGenerica pForma){

		super(pCajaComboUtil);
		//this.forma = pForma;
	}
	
	@Override
	public Component getTableCellEditorComponent(JTable table, 
												 Object value, 
												 boolean isSelected, 
												 int row, 
												 int column) {
		JTextComponent objCampoTexto;
		JComboBox objCampoCombo;
		Component objComponente;
		
		this.tblGrilla = table;
		this.booAdministradoXComponente = false;
		
		table.setValueAt(null, row, column);
		
		if(value instanceof Component){
			
			objComponente = (Component)value;
			
			if(!objComponente.getClass().equals(super.getComponent().getClass())){
				
				super.cancelCellEditing();
				return null;
			}
			
			this.booAdministradoXComponente = true;
			
		}else{
			
			objComponente = super.getComponent();
			
			if(objComponente instanceof JTextComponent){
				
				objCampoTexto = (JTextComponent)objComponente;
						
				if(value != null){
					
					objCampoTexto.setText(value.toString());
					
				}else{
					
					objCampoTexto.setText("");
				}
				
			}else if(objComponente instanceof JComboBox){
				
				objCampoCombo = (JComboBox)objComponente;
				objCampoCombo.setSelectedItem(value);
			}
		}			
		
		return objComponente;
	}
	
	@Override
    public Object getCellEditorValue() {
		
		Object objValor;
		
		if(this.booAdministradoXComponente){
			
			objValor = super.getComponent();
			
		}else{
			
			objValor = super.getCellEditorValue();
		}
		
		this.tblGrilla.requestFocus();
		
        return objValor;
    }
	
	/*@Override
	public boolean stopCellEditing() {
		
		System.out.println("stopCellEditing");
		
		CajaTextoUtil objCajaTexto;
		boolean booFinalizarEdicion = true;
		
		if(super.getComponent() instanceof CajaTextoUtil){
			
			objCajaTexto = (CajaTextoUtil)super.getComponent();
			
			try{
				
				objCajaTexto.getPropiedades().validaFormatoFinal(true);
				
			}catch(Exception e){
				
				booFinalizarEdicion = !booFinalizarEdicion;
				UtilidadesGiros.getInstance().controlExcepcion(e, 
						   									   this.forma);
				//objCajaTexto.setText("");
			}
		}
		
		if(booFinalizarEdicion){
			super.delegate.stopCellEditing();
		}else{
			super.delegate.startCellEditing(null);
		}
		
		return booFinalizarEdicion;
	}*/
	
	@Override
	public Component getTableCellRendererComponent(JTable table,
												   Object value, 
												   boolean isSelected, 
												   boolean hasFocus, 
												   int row,
												   int column) {
		if (value == null)
            return null;         
         return super.getComponent();
		
	}

	public FocusListener getEvtControlFocos() {
		
		if (this.evtControlFocos == null) {
			
			 this.evtControlFocos = new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						
						tblGrilla.setFocusable(false);
						stopCellEditing();
						tblGrilla.setFocusable(true);
						//cancelCellEditing();
					}
					
					@Override
					public void focusGained(FocusEvent e) {}
				};
		}
		
		return evtControlFocos;
	}

	public void setEvtControlFocos(FocusListener evtControlFocos) {
		this.evtControlFocos = evtControlFocos;
	}
}
