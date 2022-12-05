package co.com.codesa.clienteposslimgiros.eventos.generico.promocion;

import java.util.HashMap;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableColumn;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EditorCeldaGrilla;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.promocion.FormaPanelPromocion;
import co.com.codesa.clienteposslimgiros.interfaces.promocion.IOperacionesPromocion;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Promocion;

/**
 * ********************************************************************
 * @class  	EventoFormaPanelPromocion
 *		   	Clase encargada de controlar los eventos de la forma panel  
 * 		  	que permite indicar y gestionar las promociones
 * @author 	hector.cuenca
 * @date   	6/12/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPanelPromocion extends EventoAbstracto implements IOperacionesPromocion{
	
	/**
	 * @variable 	frmScpPromocion
	 * 			 	Referencia a la forma que representa una funcionalidad
	 * 				transversal para la gestion de promociones
	 */
	private FormaPanelPromocion frmScpPromocion;
	
	/**
	 * @variable 	hmEditorCeldaPromociones
	 * 			 	Listado de los componentes de edicion configurados y exclusivos 
	 * 				para cada promocion, indexado por el ID de estas
	 */
	private HashMap<String,EditorCeldaGrilla>	hmEditorCeldaPromociones;
	
	/**
	 * @variable 	hmPromociones
	 * 			 	Listado de promociones propuestas para ofrecer
	 */
	private HashMap<String,Promocion> hmPromociones;
	
	/**
	 * ********************************************************************
	 * @method 	EventoFormaPanelPromocion
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos iniciales requeridos para el 
  	 * 		   	despliegue de los eventos asociados a la funcionalidad en 
  	 * 			cuestion
	 * @param 	pFrmScpPromocion
	 * 			Forma que representa una funcionalidad transversal para la 
	 * 			gestion de promociones
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	6/12/2016
	 * *********************************************************************
	 */
	public EventoFormaPanelPromocion(FormaPanelPromocion pFrmScpPromocion) throws Exception
	{
		super(pFrmScpPromocion.getFrmGnrPadre());
		this.setFrmScpPromocion(pFrmScpPromocion);
	}
	
	@Override
	public void accionarCambioRegistro(ListSelectionModel pObjLisSelectionModel,
									   ListSelectionEvent pEvtValueChanged) throws Exception {
		
		if(pObjLisSelectionModel.equals(this.getFrmScpPromocion().getTblPromociones().getSelectionModel())){
		
			this.seleccionarRegistroGrillaPromociones();
			
		}else{
			
			super.accionarCambioRegistro(pObjLisSelectionModel, 
										 pEvtValueChanged);
		}
	}
	
	@Override
	public void adicionarPromociones(	HashMap<String,Promocion> pHmPromociones	)	throws	Exception
	{
		this.limpiarPromociones();
		
		this.setHmPromociones(pHmPromociones);
		
		for	(	Promocion objPromocion	:	pHmPromociones.values()	)
		{
			this.getFrmScpPromocion().getTblPromociones().getPropiedades().adicionarFilaGrilla	(	new Object[]{	objPromocion.getId(),
				  																									objPromocion.getDescripcion(),
				  																									objPromocion.getAtributo(),
				  																									objPromocion.getLongitud(),
				  																									this.obtenerCampoTextoDatoPromocion(objPromocion)
				  																								}
																								);
		}
	}
	
	@Override
	public	boolean	validarPromocionesDiligenciadas	(	boolean pBooGenerarExcepcion	)	throws 	Exception
	{
		GrillaUtil tblPromociones;
		Object objValorDatoXPromocion;
		String strValorIdXPromocion;
		int intPosicionColumnaDato;
		int intPosicionColumnaId;
		boolean booResultadoValidacion = true;

		tblPromociones	=	this.getFrmScpPromocion().getTblPromociones();
		
		intPosicionColumnaDato = tblPromociones.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_EGP_GRILLA_PROMO_DATO.toString());
		intPosicionColumnaId = tblPromociones.getColumnModel().getColumnIndex(EnumEtiquetas.TTL_EGP_GRILLA_PROMO_ID.toString());

		for(int i=0; i<tblPromociones.getRowCount();i++){

			objValorDatoXPromocion = tblPromociones.getValueAt(i, intPosicionColumnaDato);
			strValorIdXPromocion = tblPromociones.getValueAt(i, intPosicionColumnaId).toString();

			if(objValorDatoXPromocion == null || 
					objValorDatoXPromocion.toString().trim().isEmpty()){

				if(pBooGenerarExcepcion){

					throw EnumMensajes.PROMOCION_NO_DILIGENCIADA.generarExcepcion(EnumClasesMensaje.ERROR);

				}else{

					booResultadoValidacion = false;
					break;
				}
				
			}	else	{
				
				((CajaTextoUtil)this.getHmEditorCeldaPromociones().get(strValorIdXPromocion).getComponent()).getPropiedades().validaFormatoFinal(	pBooGenerarExcepcion, 
																																					EnumEtiquetas.TTL_EGP_GRILLA_PROMO_DATO.toString()
																																				);
			}

			this.getHmPromociones().get(strValorIdXPromocion).setDato(objValorDatoXPromocion.toString());
		}
		
		return booResultadoValidacion;
	}
	
	/**
	 * ********************************************************************
	 * @method 	obtenerCampoTextoDatoPromocion
	 * 		   	Metodo que permite obtener el campo de texto configurado para
	 * 			diligenciar el dato de la promocion
	 * @param 	pObjPromocion
	 * 			Objeto que relaciona la informacion especifica de una promocion,
	 * 			requerido para la configuracion del campo de texto 
	 * @return	CajaTextoUtil
	 * 			Campo de texto configurado para el ingreso del dato de la 
	 * 			promocion
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	private	CajaTextoUtil	obtenerCampoTextoDatoPromocion	(	Promocion pObjPromocion	)	throws	Exception
	{
		CajaTextoUtil txtDatoPromocion;
		EditorCeldaGrilla	ecgEditorCelda;
		
		String strFormato;
		String strFormatoIngreso;
		String strFormatoSalida;

		if	(	this.getHmEditorCeldaPromociones().containsValue(pObjPromocion.getId())	)
		{
			txtDatoPromocion	=	(CajaTextoUtil)this.getHmEditorCeldaPromociones().get(pObjPromocion.getId()).getComponent();
			
		}	else	{
			
			txtDatoPromocion	=	this.getFrmScpPromocion().iniciarPropTxtDatoPromocion();
			ecgEditorCelda		=	new EditorCeldaGrilla	(	txtDatoPromocion,
					 											super.getFrmForma()
					 										);
			
			this.getHmEditorCeldaPromociones().put(pObjPromocion.getId(), ecgEditorCelda);
		}
		
		txtDatoPromocion.setText(pObjPromocion.getDato());

		if	(	pObjPromocion.getTipoDato().equalsIgnoreCase(EnumParametrosApp.ALFANUMERICO.getObjConstante())	)
		{
			strFormato = EnumExpresionesRegulares.EXP_REG_FORMATO_ALFANUMERICO.getValor();

		}	else if	(	pObjPromocion.getTipoDato().equalsIgnoreCase(EnumParametrosApp.NUMERICO.getObjConstante())	)
		{
			strFormato = EnumExpresionesRegulares.EXP_REG_FORMATO_NUMEROS.getValor();

		}else
		{
			strFormato = EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor(); 
		}

		strFormatoIngreso = strFormato+"{0,"+pObjPromocion.getLongitud()+"}";
		strFormatoSalida = strFormato+"{"+pObjPromocion.getLongitud()+"}";

		txtDatoPromocion.getPropiedades().setControlFormatoIngreso(strFormatoIngreso);
		txtDatoPromocion.getPropiedades().setControlFormatoFinal(strFormatoSalida);
		
		return txtDatoPromocion;
	}
	
	/**
	 * ********************************************************************
	 * @method 	seleccionarRegistroGrillaPromociones
	 * 		   	Metodo que permite realizar las acciones pertinentes cuando
	 * 			se selecciona un registro de la grilla de promociones, ideal
	 * 			para re-definir el componente de edicion que se utilizara para
	 * 			diligenciar el dato de la promocion seleccionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	9/12/2016
	 * *********************************************************************
	 */
	private	void	seleccionarRegistroGrillaPromociones()	throws 	Exception
	{
		GrillaUtil tblPromociones;
		TableColumn objColumnaId;
		TableColumn objColumnaDato;
		String strIdPromocion;
		int intFilaSeleccionada;
		
		tblPromociones = this.getFrmScpPromocion().getTblPromociones();
		objColumnaId = tblPromociones.getColumn(EnumEtiquetas.TTL_EGP_GRILLA_PROMO_ID.toString());
		objColumnaDato = tblPromociones.getColumn(EnumEtiquetas.TTL_EGP_GRILLA_PROMO_DATO.toString());
		intFilaSeleccionada = tblPromociones.getSelectedRow();
		
		strIdPromocion	=	(String)tblPromociones.getValueAt	(	intFilaSeleccionada, 
												 					objColumnaId.getModelIndex()
												 				);
		
		objColumnaDato.setCellEditor(this.getHmEditorCeldaPromociones().get(strIdPromocion));
	}
	
	@Override
	public	void	limpiarPromociones	()	throws	Exception
	{
		this.getFrmScpPromocion().getTblPromociones().getPropiedades().limpiarGrilla();
		this.getHmEditorCeldaPromociones().clear();
		this.setHmPromociones(null);
	}
	
	/**
	 * @method getFrmScpPromocion
	 * 		   Metodo get del atributo frmScpPromocion
	 * @return FormaPanelPromocion
	 *		   Valor del atributo frmScpPromocion devuelto
	 * @author hector.cuenca
	 * @date   7/12/2016
	 */
	public FormaPanelPromocion getFrmScpPromocion() {
		return this.frmScpPromocion;
	}

	/**
	 * @method setFrmScpPromocion
	 * 		   Metodo set del atributo frmScpPromocion
	 * @param  pFrmScpPromocion
	 *		   Valor que tomara el atributo frmScpPromocion
	 * @author hector.cuenca
	 * @date   7/12/2016
	 */
	public void setFrmScpPromocion(FormaPanelPromocion pFrmScpPromocion) {
		this.frmScpPromocion = pFrmScpPromocion;
	}

	/**
	 * @method getHmEditorCeldaPromociones
	 * 		   Metodo get del atributo hmEditorCeldaPromociones
	 * @return HashMap<String,EditorCeldaGrilla>
	 *		   Valor del atributo hmEditorCeldaPromociones devuelto
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public HashMap<String, EditorCeldaGrilla> getHmEditorCeldaPromociones() {
		
		if	(	this.hmEditorCeldaPromociones	==	null)
		{
			this.hmEditorCeldaPromociones	=	new HashMap<String, EditorCeldaGrilla>();
		}
		
		return this.hmEditorCeldaPromociones;
	}

	/**
	 * @method setHmEditorCeldaPromociones
	 * 		   Metodo set del atributo hmEditorCeldaPromociones
	 * @param  pHmEditorCeldaPromociones
	 *		   Valor que tomara el atributo hmEditorCeldaPromociones
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public void setHmEditorCeldaPromociones(
			HashMap<String, EditorCeldaGrilla> pHmEditorCeldaPromociones) {
		this.hmEditorCeldaPromociones = pHmEditorCeldaPromociones;
	}

	/**
	 * @method getHmPromociones
	 * 		   Metodo get del atributo hmPromociones
	 * @return HashMap<String,Promocion>
	 *		   Valor del atributo hmPromociones devuelto
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public HashMap<String, Promocion> getHmPromociones() {
		return this.hmPromociones;
	}

	/**
	 * @method setHmPromociones
	 * 		   Metodo set del atributo hmPromociones
	 * @param  pHmPromociones
	 *		   Valor que tomara el atributo hmPromociones
	 * @author hector.cuenca
	 * @date   9/12/2016
	 */
	public void setHmPromociones(HashMap<String, Promocion> pHmPromociones) {
		this.hmPromociones = pHmPromociones;
	}
}
