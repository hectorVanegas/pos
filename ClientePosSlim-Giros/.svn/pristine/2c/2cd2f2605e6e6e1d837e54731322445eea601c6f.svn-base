package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import javax.swing.table.DefaultTableModel;

public class ModeloGrilla extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	boolean[] canEdit; 

	public boolean isCellEditable(int rowIndex, int columnIndex) {

		boolean permiteEditar=false;

		try{

			if(canEdit!=null){

				permiteEditar=canEdit[columnIndex];

			}

		}catch(Exception e){

		}

		return permiteEditar;

	}

	public boolean[] getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean[] canEdit) {
		this.canEdit = canEdit;
	}

}

