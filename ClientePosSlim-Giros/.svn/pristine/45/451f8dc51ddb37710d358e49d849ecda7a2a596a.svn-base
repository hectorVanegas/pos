package co.com.codesa.clienteposslimgiros.eventos.convenio;

import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;
import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.convenio.FormaConvenioPropiedades;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Convenio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;

/**
 * ****************************************************************
 * @autor Roberth Martinez Vargas
 * @fecha 24-sep-2015
 * @clase EventoFormaConvenioPropiedades
 * 		  Clase que representa los eventos de forma Convenio 
 * 		  Propiedades
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos 
 * 			   reservados.
 * ****************************************************************
 */
public class EventoFormaConvenioPropiedades extends EventoAbstracto{
	
	private Convenio objConvenio;
	
	private String strExpRegNumeros;
	private String strExpRegAlfanumerico;
	private String tipoExpresionValor = "<tipo_expresion_valor>";
	private String obligatorio = "<obligatorio>";
	private String longitudMaxima = "<longitud_maxima>";
	private String caracterListar = "<caracter_listar>";
	
	public EventoFormaConvenioPropiedades(FormaGenerica pForma,
										  FacturaGiro pFacturaGiro) throws Exception{
		super(pForma);
		
		this.objConvenio= pFacturaGiro.getObjConvenio();
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.castFrmConveniosPropiedades().getTxtIdentificacion().setText(this.objConvenio.getTercero().getIdentificacion());
		this.castFrmConveniosPropiedades().getTxtNombre().setText(this.objConvenio.getNombreCorto());
		
		this.strExpRegNumeros = EnumExpresionesRegulares.EXP_REG_FORMATO_NUMEROS.getValor();
		this.strExpRegAlfanumerico = EnumExpresionesRegulares.CVP_ALFANUMERICO.getValor();
		
		this.adicionarFilas();
	}
	
	@Override
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel,
									   ListSelectionEvent pEvtValueChanged) throws Exception {
		
		if(pObjLisSelectionModel.equals(this.castFrmConveniosPropiedades().getTblPropiedades().getSelectionModel())){
		
			this.seleccionarRegistroGrillaPropiedades();
			
		}else{
			
			super.accionarCambioRegistro(pObjLisSelectionModel, 
										 pEvtValueChanged);
		}
	}
	
	@Override
	public void confirmar() throws Exception {
		
		this.actualizarValoresPropiedades();
		
		this.validarPropiedadesDiligenciadas();
		
		super.regresarFormaPadre();
	}
	
	/**
     * ****************************************************************
     * @metodo adicionarFilas
     * 		   metodo utilizado para adicionar los datos consultados de
     * 		   las sedes en la tabla
     * @throws Exception 
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void adicionarFilas() throws Exception{
		
		CajaTextoUtil txtValorPropiedad;
		
		for(Propiedad objPropiedad : this.objConvenio.getLstPropiedades()){
			
			txtValorPropiedad = this.castFrmConveniosPropiedades().iniciarPropTxtValorPropiedad();
			txtValorPropiedad.setText(objPropiedad.getStrValor());
			
			objPropiedad.setObjComponente(txtValorPropiedad);
			
			objPropiedad.setObjEditorCelda(new EditorCeldaGrilla(txtValorPropiedad,
																 super.getFrmForma()));
			
			this.inicializarCaracteristicasEdicion(txtValorPropiedad,
												   objPropiedad);
			
			this.castFrmConveniosPropiedades().getTblPropiedades().getPropiedades().adicionarFilaGrilla(new Object[] {objPropiedad,
		             																					objPropiedad.getStrListarSeparador(),
		             																					objPropiedad.getStrEjemplo(),
		             																					objPropiedad.getObjComponente()});
		}
	}
	
	private void inicializarCaracteristicasEdicion(CajaTextoUtil pTxtValorPropiedad,
												   Propiedad pObjPropiedad)throws Exception{
		
		String strExpRegValorPropiedadIngreso;
		
		strExpRegValorPropiedadIngreso = EnumExpresionesRegulares.CVP_VALOR_PROPIEDAD_INGRESO.getValor();
		
		if (pObjPropiedad.getStrTipoDato().equals("NUMERICO")){
			
			strExpRegValorPropiedadIngreso = strExpRegValorPropiedadIngreso.replaceAll(this.tipoExpresionValor, 
						 															   this.strExpRegNumeros);
		}else{
			
			strExpRegValorPropiedadIngreso = strExpRegValorPropiedadIngreso.replaceAll(this.tipoExpresionValor, 
						 															   this.strExpRegAlfanumerico);
		}
		
		/**
		 * Se pone como longitud minima 0 asi sea obligatorio, para controlarlo en el metodo de confirmar
		 * 22/10/2015
		 * */
		strExpRegValorPropiedadIngreso = strExpRegValorPropiedadIngreso.replaceAll(this.obligatorio, 
																				   pObjPropiedad.isBooObligatorio()?"1" : "0");
		
		strExpRegValorPropiedadIngreso = strExpRegValorPropiedadIngreso.replaceAll(this.longitudMaxima, 
																				   pObjPropiedad.getStrExtension());
		
		strExpRegValorPropiedadIngreso = strExpRegValorPropiedadIngreso.replaceAll(this.caracterListar, 
																				   pObjPropiedad.getStrListarSeparador());
		
		pTxtValorPropiedad = (CajaTextoUtil)pObjPropiedad.getObjComponente();
		
		pTxtValorPropiedad.getPropiedades().setControlFormatoIngreso(strExpRegValorPropiedadIngreso);
		pTxtValorPropiedad.getPropiedades().setControlFormatoFinal(strExpRegValorPropiedadIngreso);
		pTxtValorPropiedad.setToolTipText(pObjPropiedad.getStrEtiqueta());
	}
	
	private void seleccionarRegistroGrillaPropiedades()throws Exception{
	
		Propiedad objPropiedad;
		GrillaUtil tblPropiedades;
		TableColumn objColumnaPropiedad;
		TableColumn objColumnaValor;
		int intFilaSeleccionada;
		
		tblPropiedades = this.castFrmConveniosPropiedades().getTblPropiedades();
		objColumnaPropiedad = tblPropiedades.getColumn(EnumEtiquetas.TTL_CVP_GRILLA_PROPIEDAD.toString());
		objColumnaValor = tblPropiedades.getColumn(EnumEtiquetas.TTL_CVP_GRILLA_DETALLE.toString());
		intFilaSeleccionada = tblPropiedades.getSelectedRow();
		
		objPropiedad = (Propiedad)tblPropiedades.getValueAt(intFilaSeleccionada, 
												 			objColumnaPropiedad.getModelIndex());
		
		objColumnaValor.setCellEditor(objPropiedad.getObjEditorCelda());
	}
	
	/**
     * ****************************************************************
     * @metodo actualizarValoresPropiedades
     * 		   se actualiza el valor de la propiedad con lo digitado
     * 		   en la grilla
     * @throws Exception 
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void actualizarValoresPropiedades() throws Exception{
		
		Propiedad objPropiedad;
		GrillaUtil tblPropiedades;
		CajaTextoUtil txtValorPropiedad;
		int intColumnaValor;
		int intColumnaPropiedad;
		
		tblPropiedades = this.castFrmConveniosPropiedades().getTblPropiedades();
		intColumnaValor = tblPropiedades.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_CVP_GRILLA_DETALLE.toString());
		intColumnaPropiedad = tblPropiedades.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_CVP_GRILLA_PROPIEDAD.toString());
		
		for(int i=0; i<tblPropiedades.getRowCount();i++){
			
			objPropiedad = (Propiedad) tblPropiedades.getValueAt(i, 
																 intColumnaPropiedad);
			
			txtValorPropiedad = (CajaTextoUtil) tblPropiedades.getValueAt(i, 
																		  intColumnaValor);
			objPropiedad.setStrValor(txtValorPropiedad.getText());
		}
	}
	
	/**
     * ****************************************************************
     * @metodo validarValorPropiedades
     * 		   metodo utilizado para validar las propiedades, 
     * 		   obligatorias y envia la trama 437 para validar el valor 
     * 		   de cada propiedad con su formato
     * @throws Exception
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void validarPropiedadesDiligenciadas() throws Exception{
		
		GrillaUtil tblPropiedades;
		TableColumn objColumnaPropiedad;
		TableColumn objColumnaValor;
		
		tblPropiedades = this.castFrmConveniosPropiedades().getTblPropiedades();
		objColumnaPropiedad = tblPropiedades.getColumn(EnumEtiquetas.TTL_CVP_GRILLA_PROPIEDAD.toString());
		objColumnaValor = tblPropiedades.getColumn(EnumEtiquetas.TTL_CVP_GRILLA_DETALLE.toString());
		
		this.validarValorIngresadoXPropiedad(tblPropiedades,
					 						 objColumnaPropiedad,
					 						 objColumnaValor);
		
		this.notificarValorXPropiedad(tblPropiedades,
				 	 				  objColumnaPropiedad,
				 	 				  objColumnaValor);
	}
	
	private void notificarValorXPropiedad(GrillaUtil pTblPropiedades,
			 			 				  TableColumn pObjColumnaPropiedad,
			 			 				  TableColumn pObjColumnaValor)throws Exception{
		
		String [] arrStrDatos;
		
		Propiedad objPropiedad;
		
		for (int i=0 ; i<pTblPropiedades.getRowCount() ; i++) {
			
			try{
				
				objPropiedad = (Propiedad)pTblPropiedades.getValueAt(i,
																	 pObjColumnaPropiedad.getModelIndex());
				
				if (objPropiedad.getStrValor() != null 
						&& !objPropiedad.getStrValor().isEmpty() 
						&& objPropiedad.getStrEjemplo() != null 
						&& !objPropiedad.getStrEjemplo().equals("*")) {
				
					arrStrDatos = objPropiedad.obtenerArrayValor();
					
					for (String strDato : arrStrDatos) {
						
						if(!TerceroVistaLogica.getInstance().validarPropiedadConvenio(super.getObjUsuario(),
																					  objPropiedad, 
																					  strDato).equals("0")){
							
							throw EnumMensajes.CNV_REVISAR_VALOR_ETIQUETA.generarExcepcion(EnumClasesMensaje.ERROR, 
																						   objPropiedad.getStrEtiqueta());
						}
					}
				}
				
			}catch(ClientePosSlimGirosException cpsge){
				
				pTblPropiedades.getPropiedades().detectarRegistroGrilla(i, 
																		pObjColumnaValor.getModelIndex());
				throw cpsge;
			}
		}
	}
	
	private void validarValorIngresadoXPropiedad(GrillaUtil pTblPropiedades,
						 						 TableColumn pObjColumnaPropiedad,
						 						 TableColumn pObjColumnaValor)throws Exception{
		
		Propiedad objPropiedad;
		Object objValorCelda;
		
		for (int i=0 ; i<pTblPropiedades.getRowCount() ; i++) {
			
			try{
				
				objPropiedad = (Propiedad)pTblPropiedades.getValueAt(i,
																	 pObjColumnaPropiedad.getModelIndex());
				objValorCelda = pTblPropiedades.getValueAt(i,
														   pObjColumnaValor.getModelIndex());
				
				if(objPropiedad.isBooObligatorio()){
					
					UtilComponentesGUI.getInstance().validarObligatoriedadCampo((JComponent)objValorCelda, 
																				objPropiedad.getStrEtiqueta(), 
																				true, 
																				true);
				}
				
				if(objValorCelda instanceof CajaTextoUtil){
					
					((CajaTextoUtil)objValorCelda).getPropiedades().validaFormatoFinal(true,
																					   null);
				}
				
			}catch(ClientePosSlimGirosException cpsge){
				
				pTblPropiedades.getPropiedades().detectarRegistroGrilla(i, 
																		pObjColumnaValor.getModelIndex());
				throw cpsge;
			}
		}
	}

	public FormaConvenioPropiedades castFrmConveniosPropiedades()throws Exception{
		return (FormaConvenioPropiedades)super.getFrmForma();
	}	
}
