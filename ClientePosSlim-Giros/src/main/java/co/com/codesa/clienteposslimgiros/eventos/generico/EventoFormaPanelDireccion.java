package co.com.codesa.clienteposslimgiros.eventos.generico;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.FocusEvent;

import co.com.codesa.clienteposslimgiros.dto.direccion.ConfigDireccionDTO;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDireccion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDireccion;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 15-may-2015 
 * @clase EventoFormaPanelDireccion
 * 		  Clase encargada de controlar los eventos de la forma panel  
 * 		  que permite indicar y gestionar la direccion
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaPanelDireccion extends EventoAbstracto{
	
	private FormaPanelDireccion frmPnlDireccion;
	
	/**
	 * @variable	objDtoConfigDireccion
	 * 				Objeto DTO encargado de almacenar toda la configuracion 
	 *				relacionada con el formulario para diligenciar la direccion
	 */
	private ConfigDireccionDTO objDtoConfigDireccion;
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaPanelDireccion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos iniciales requeridos para el 
  	 * 		   despliegue de sus acciones
  	 * @param pForma
  	 * 		  referencia a la GUI de la cual se estan controlando los 
  	 * 		  eventos
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaPanelDireccion(FormaGenerica pForma,
									 FormaPanelDireccion pFrmPnlDireccion) throws Exception{
		super(pForma);
		this.frmPnlDireccion = pFrmPnlDireccion;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.configuracionCampos();
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion)throws Exception{
		
		if(pComponent.equals(this.frmPnlDireccion.getBtnMantenimiento())){
			
			this.solicitarMantenimientoDireccion();
			
		}else if(pComponent.equals(this.frmPnlDireccion.getBtnLimpiar())){
			
			this.limpiarDireccion();
		}
	}
	
	@Override
	public void accionarFocoAdquirido(Component pComponent, 
									  FocusEvent pEvtFocusGained) throws Exception {
		
		if(pComponent.equals(this.frmPnlDireccion.getTxtDescripcion())){
		
			this.trasladarFocoTxtDireccion();
			
		}else{
			
			super.accionarFocoAdquirido(pComponent, 
										pEvtFocusGained);
		}
	}
	
	private void trasladarFocoTxtDireccion()throws Exception{
		
		Component pComponenteSiguiente;
		
		pComponenteSiguiente = super.getFrmForma().getFocusTraversalPolicy().getComponentAfter(super.getFrmForma(), 
																							   this.frmPnlDireccion.getTxtDescripcion());
		pComponenteSiguiente.requestFocus();
	}
	
	private void configuracionCampos()throws Exception{
		
		this.configuracionCamposTexto();
	}
	
	private void configuracionCamposTexto()throws Exception{
		
		this.frmPnlDireccion.getTxtDescripcion().getPropiedades().setActivaDesplegarContenido(true);
	}
	
	private void solicitarMantenimientoDireccion()throws Exception{
		
		FormaDireccion objFrmDireccion;
		String strDireccionDiligenciada;
		
		objFrmDireccion = new FormaDireccion(super.getFrmForma(),
						   					 true,
						   					 this.frmPnlDireccion.getTxtDescripcion().getText(),
						   					 this.getObjDtoConfigDireccion());
		
		strDireccionDiligenciada = objFrmDireccion.castEvtFrmDireccion().getStrDireccionConfigurada();
		
		if(strDireccionDiligenciada!=null){
			this.frmPnlDireccion.getTxtDescripcion().setText(strDireccionDiligenciada);
		}
	}
	
	private void limpiarDireccion()throws Exception{
		
		this.frmPnlDireccion.getTxtDescripcion().setText("");
	}

	/**
	 * @method	getObjDtoConfigDireccion
	 * 		  	Metodo get del atributo objDtoConfigDireccion
	 * @return	ConfigDireccionDTO
	 *		  	Valor del atributo objDtoConfigDireccion devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public ConfigDireccionDTO getObjDtoConfigDireccion() {
		return objDtoConfigDireccion;
	}

	/**
	 * @method	setObjDtoConfigDireccion
	 * 		  	Metodo set del atributo objDtoConfigDireccion
	 * @param	pObjDtoConfigDireccion
	 * 			Valor que tomara el atributo objDtoConfigDireccion
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setObjDtoConfigDireccion(ConfigDireccionDTO pObjDtoConfigDireccion) {
		this.objDtoConfigDireccion = pObjDtoConfigDireccion;
	}
	
}
