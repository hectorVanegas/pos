package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

public class RenderGrilla extends JLabel implements TableCellRenderer {
	
	private static final long serialVersionUID = 2697865260090507355L;
	
	private int intJustificacionNumerico;
	private int intJustificacionAlfanumerico;
	public Font FONT_TABLE;

	public RenderGrilla() throws Exception{
		
		this.intJustificacionNumerico = SwingConstants.RIGHT;
		this.intJustificacionAlfanumerico = SwingConstants.CENTER;
		FONT_TABLE = new Font("Arial", 0, 10);
	}

	public Component getTableCellRendererComponent(JTable table, 
												   Object obj,
												   boolean isSelected, 
												   boolean hasFocus, 
												   int row, 
												   int column) {	
		Component celda;
		JCheckBox celdaCheckBox;
		JLabel celdaLabel;
		
		if(obj instanceof Component){
			
			celda = (Component)obj;
			
		}else if (obj instanceof Boolean) {
			
			celda = new JCheckBox();
			celdaCheckBox = (JCheckBox)celda;
			celdaCheckBox.setSelected(((Boolean) obj).booleanValue());
			celdaCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
			celdaCheckBox.setBackground(Color.WHITE);
			celdaCheckBox.setFont(FONT_TABLE);
			
		}else {
			
			celda = new JLabel();
			celdaLabel = (JLabel)celda;
			
			if (obj != null 
					&& obj instanceof Number) {
				
				celdaLabel.setHorizontalAlignment(this.getIntJustificacionNumerico());
				
				try {
					
					Number numberValue = (Number) obj;
					if (obj instanceof Double) {
						
						obj = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO_DECIMAL().format(numberValue.doubleValue());
						
					}else{

						obj = UtilidadGiros.getInstancia().getFORMATEADOR_NUMERO().format(numberValue.doubleValue());
					}
					
				} catch (Exception e) {}
				
			}else{
				
				celdaLabel.setHorizontalAlignment(this.getIntJustificacionAlfanumerico());
			}
			
			if (isSelected) {
				
				celdaLabel.setBackground(Color.CYAN);
				celdaLabel.setOpaque(true);
				
			} else {
				
				celdaLabel.setBackground(Color.WHITE);
			}
			
			if(obj!=null){
				
				celdaLabel.setText(obj.toString().replace("$", ""));
			}
			
			celdaLabel.setFont(FONT_TABLE);
		}
		
		return celda;
	}

	public int getIntJustificacionNumerico() {
		return intJustificacionNumerico;
	}

	public void setIntJustificacionNumerico(int intJustificacionNumerico) {
		this.intJustificacionNumerico = intJustificacionNumerico;
	}

	public int getIntJustificacionAlfanumerico() {
		return intJustificacionAlfanumerico;
	}

	public void setIntJustificacionAlfanumerico(int intJustificacionAlfanumerico) {
		this.intJustificacionAlfanumerico = intJustificacionAlfanumerico;
	}
}


