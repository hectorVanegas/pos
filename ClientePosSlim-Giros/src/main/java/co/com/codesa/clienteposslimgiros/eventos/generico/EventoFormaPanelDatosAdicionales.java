package co.com.codesa.clienteposslimgiros.eventos.generico;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDatosAdicionales;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.interfaces.datosAdicionales.PropiedadesPnlDatosAdicionales;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoAdicional;
import co.com.codesa.codesawrappergiros.modelo.interfaces.giros.iObjetoUsaDatosAdicionales;

/**
 * ****************************************************************.
 * @autor  Hector Q-en-K
 * @fecha  05-oct-2015
 * @clase EventoFormaPanelDatosAdicionales 
 * 		  Clase que representa los eventos de la seccion de datos
 * 		  adicionales
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaPanelDatosAdicionales extends EventoAbstracto implements PropiedadesPnlDatosAdicionales{
	
	private FormaPanelDatosAdicionales pnlDatosAdicionales;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaPanelDatosAdicionales
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pPnlDatosAdicionales 
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaPanelDatosAdicionales(FormaPanelDatosAdicionales pPnlDatosAdicionales) throws Exception{
	
		super.setFrmForma(pPnlDatosAdicionales.getFormaPadre());
		this.pnlDatosAdicionales = pPnlDatosAdicionales;
	}

	@Override
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel,
									   ListSelectionEvent pEvtValueChanged) throws Exception {
		
		if(pObjLisSelectionModel.equals(this.pnlDatosAdicionales.getTblDatosAdicionales().getSelectionModel())){
			
			this.seleccionarRegistroGrillaDatosAdicionales();
			
		}else{
			
			super.accionarCambioRegistro(pObjLisSelectionModel,pEvtValueChanged);
		}
	}
	
	@Override
	public void mostrarDatosAdicionales(iObjetoUsaDatosAdicionales pObjUsaDatosAdicionales,
										boolean pBooCargarValoresEnBlanco)throws Exception{
		
		this.pnlDatosAdicionales.getTblDatosAdicionales().getPropiedades().limpiarGrilla();
		
		if(pObjUsaDatosAdicionales != null){
		
			if(!pObjUsaDatosAdicionales.getHmDatosAdicionales().isEmpty()){
				
				for(DatoAdicional objDatoAdicional : pObjUsaDatosAdicionales.getHmDatosAdicionales().values()){
					
					if(pBooCargarValoresEnBlanco){
						
						UtilComponentesGUI.getInstance().restablecerComponentes((Component)objDatoAdicional.getObjComponente());
						
					}else{
						
						((ComponenteGUI)objDatoAdicional.getObjComponente()).setValorContenido(objDatoAdicional.getObjValor());
					}
					
					this.pnlDatosAdicionales.getTblDatosAdicionales().getPropiedades().adicionarFilaGrilla(new Object[]{objDatoAdicional,
							  																							objDatoAdicional.getObjComponente()});
				}
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo seleccionarRegistroGrillaDatosAdicionales
  	 * 		   Permite realizar las acciones respectivas cuando se 
  	 * 		   produce un interes particular del usuario sobre un registro 
  	 * 		   de la grilla de datos adicionales, que para esta situacion
  	 * 		   es de utilidad para re-definir el editor de celda
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void seleccionarRegistroGrillaDatosAdicionales()throws Exception{
		
		DatoAdicional objParametroSeleccionado;
		GrillaUtil tblDatosAdicionales;
		TableColumn objColumna;
		
		tblDatosAdicionales = this.pnlDatosAdicionales.getTblDatosAdicionales();
		
		objColumna = tblDatosAdicionales.getColumn(EnumEtiquetas.TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_DATO.toString());
		
		objParametroSeleccionado = (DatoAdicional)tblDatosAdicionales.getValueAt(tblDatosAdicionales.getSelectedRow(), 
																		   		 objColumna.getModelIndex());
		
		tblDatosAdicionales.getColumn(EnumEtiquetas.TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_VALOR.toString()).setCellEditor((DefaultCellEditor)objParametroSeleccionado.getObjEditorCelda());
	}
	
	@Override
	public void validarDatosAdicionalesIngresados()throws Exception{
		
		DatoAdicional objDatoAdicional;
		GrillaUtil tblDatosAdicionalesXMedioPago;
		TableColumn objColumnaDato;
		TableColumn objColumnaValor;
		
		tblDatosAdicionalesXMedioPago = this.pnlDatosAdicionales.getTblDatosAdicionales();
		objColumnaDato = tblDatosAdicionalesXMedioPago.getColumn(EnumEtiquetas.TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_DATO.toString());
		objColumnaValor = tblDatosAdicionalesXMedioPago.getColumn(EnumEtiquetas.TTL_PNL_DAT_ADI_GRILLA_DATOS_ADICIONALES_VALOR.toString());
		
		for(int i=0 ; i<tblDatosAdicionalesXMedioPago.getRowCount() ; i++){
			
			objDatoAdicional = (DatoAdicional)tblDatosAdicionalesXMedioPago.getValueAt(i, objColumnaDato.getModelIndex());
			
			try{
			
				if(objDatoAdicional.getObjComponente() instanceof CajaTextoUtil){
					
					((CajaTextoUtil)objDatoAdicional.getObjComponente()).getPropiedades().validaFormatoFinal(true,
																											 null);
				}
				
				if(objDatoAdicional.isBooObligatorio()){
					
					UtilComponentesGUI.getInstance().validarObligatoriedadCampo((Component)objDatoAdicional.getObjComponente(), 
																				objDatoAdicional.getStrNombre(), 
																				true, 
																				true);
				}
				
			}catch(ClientePosSlimGirosException cpsge){
				
				tblDatosAdicionalesXMedioPago.getPropiedades().detectarRegistroGrilla(i, 
																					  objColumnaValor.getModelIndex());
				
				throw cpsge;
			}
		}
		
		for(int i=0 ; i<tblDatosAdicionalesXMedioPago.getRowCount() ; i++){
		
			objDatoAdicional = (DatoAdicional)tblDatosAdicionalesXMedioPago.getValueAt(i, objColumnaDato.getModelIndex());
			objDatoAdicional.setObjValor(objDatoAdicional.getObjComponente().toString());
		}		
	}
	
	public FormaPanelDatosAdicionales getPnlDatosAdicionales() {
		return pnlDatosAdicionales;
	}

	public void setPnlDatosAdicionales(
			FormaPanelDatosAdicionales pnlDatosAdicionales) {
		this.pnlDatosAdicionales = pnlDatosAdicionales;
	}
}