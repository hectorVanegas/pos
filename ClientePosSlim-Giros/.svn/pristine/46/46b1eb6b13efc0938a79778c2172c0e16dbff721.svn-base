package co.com.codesa.clienteposslimgiros.eventos.terceros;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.terceros.FormaPropiedadesPeps;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPeps.PropiedadesPepsVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.terceroPeps.TerceroPepsVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.terceropeps.PreguntasTerceroPepsDTO;

/**
 * 
 * ********************************************************************
 * @class	EventoFormaPropiedadesPeps
 *		 	Clase EventoFormaPropiedadesPeps
 * @author	stiven.garcia
 * @date  	26/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPropiedadesPeps extends EventoAbstracto {
	
	/**
	 * @variable objTercero
	 * 			Tercero cliente al cual se le aplica el proceso o funcionalidad PEPS
	 */
	private Tercero objTercero;	
	
	/**
	 * @variable: booProcesarPeticion
	 *            bandera que indica si se debe enviarse la trama de registrar Peps o no.
	 */
	private boolean booProcesarPeticion;
	
	/**
	 * 
	 * ********************************************************************
	 * @method	EventoFormaPropiedadesPeps
	 * 		  	Constructor del EventoFormaPropiedadesPeps
	 * @param pForma
	 * 			FormaPropiedadesPeps asociada al evento 
	 * @param pObjTercero
	 * 			Tercero cliente al cual se le aplica el proceso o funcionalidad PEPS
	 * @param pBooProcesarPeticion
	 * 			Bandera que especifica si se procesa la respuesta de peps
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public EventoFormaPropiedadesPeps(FormaGenerica pForma,
									  Tercero pObjTercero,
									  boolean pBooProcesarPeticion) throws Exception {
		super(pForma);
		this.objTercero = pObjTercero;
		this.booProcesarPeticion = pBooProcesarPeticion;
		
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.cargarPreguntasPropiedades();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {		
	}
	
	@Override
	public void confirmar() throws Exception {
		
		if( this.objTercero != null ) {
			
			PreguntasTerceroPepsDTO objPreguntasTerceroPepsDto = this.validarRespuestaPreguntaPropiedadesPeps();
			
			if ( this.isBooProcesarPeticion() ) {				
				
				
				TerceroPepsVistaLogica.getInstance().registrarTerceroPeps(this.castFrmPropiedadesPeps().getObjUsuario(),
																		  this.objTercero, 
																		  true,
																		  objPreguntasTerceroPepsDto
																		 );
			}else {
				this.castFrmPropiedadesPeps().getObjTerceroPeps().setBooEsPeps(true);
				this.castFrmPropiedadesPeps().getObjTerceroPeps().setlPreguntasTerceroPeps(this.obtenerListaRespuestaPreguntasPeps(objPreguntasTerceroPepsDto));
			}
			
			this.castFrmPropiedadesPeps().setBooRealizoProcesoTerceroPeps(true);
			
			super.regresarFormaPadre();
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	accionAceptar
	 * 		  	Registra la informacio nde tercero peps diligenciada
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	30/07/2018
	 * *********************************************************************
	 */
	private void accionAceptar() throws Exception {
		
		if( this.objTercero != null ) {
			
			PreguntasTerceroPepsDTO objPreguntasTerceroPepsDto = this.validarRespuestaPreguntaPropiedadesPeps();
			
			if ( this.isBooProcesarPeticion() ) {				
				
				
				TerceroPepsVistaLogica.getInstance().registrarTerceroPeps(this.castFrmPropiedadesPeps().getObjUsuario(),
																		  this.objTercero, 
																		  true,
																		  objPreguntasTerceroPepsDto
																		 );
			}else {
				this.castFrmPropiedadesPeps().getObjTerceroPeps().setBooEsPeps(true);
				this.castFrmPropiedadesPeps().getObjTerceroPeps().setlPreguntasTerceroPeps(this.obtenerListaRespuestaPreguntasPeps(objPreguntasTerceroPepsDto));
			}
			
			this.castFrmPropiedadesPeps().setBooRealizoProcesoTerceroPeps(true);
			
			super.regresarFormaPadre();
		}
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	accionCancelar
	 * 		  	Metodo encargado de realizar la accion de registrar en 
	 *          el sistema que el tercero no es PEPS
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	30/07/2018
	 * *********************************************************************
	 */
	private void accionCancelar() throws Exception {
		
		if( this.objTercero != null ) {			
			
			if ( this.isBooProcesarPeticion() ) {
				TerceroPepsVistaLogica.getInstance().registrarTerceroPeps(this.castFrmPropiedadesPeps().getObjUsuario(), 
																		  this.objTercero, 
																		  false
																		 );
			}else {
				this.castFrmPropiedadesPeps().getObjTerceroPeps().setBooEsPeps(false);
			}
			
			this.castFrmPropiedadesPeps().setBooRealizoProcesoTerceroPeps(true);
		}
		
		super.regresarFormaPadre();
		
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castFrmPropiedadesPeps().getBtnAceptar())){
			
			this.accionAceptar();
			
		}else if(pComponent.equals(this.castFrmPropiedadesPeps().getBtnCancelar())){
			
			this.accionCancelar();
			
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void regresar() throws Exception{
		this.objTercero.setObjTerceroPeps(null);
		super.regresarFormaPadre();
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarRespuestaPreguntaPropiedadesPeps
	 * 		  	Metodo encargado de validar que almenos si seleccione una 
	 * 			respuesta afirmativa
	 * @return
	 * 			Objeto con la respuesta establecida o asignada por el usuario.
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	private PreguntasTerceroPepsDTO validarRespuestaPreguntaPropiedadesPeps() throws Exception {
		
		PreguntasTerceroPepsDTO objPreguntasTerceroPeps = null;
		Propiedad objPropiedad = this.castFrmPropiedadesPeps().getPnlPropiedadesPeps().getEvaControlEventos().obtenerPropiedadSeleccionada();
		
		if ( objPropiedad != null) {
			
			objPreguntasTerceroPeps = new PreguntasTerceroPepsDTO(objPropiedad.getStrCodigo(), objPropiedad.getStrEtiqueta(), true);
			
		}
		
		return objPreguntasTerceroPeps;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	cargarPreguntasPropiedades
	 * 		  	Metodo encargado de obtener las preguntas o propiedades almacenadas 
	 * 			en base de datos.
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	private void cargarPreguntasPropiedades() throws Exception{
		
		HashMap<String,Propiedad> lstPropiedad;
		List<Propiedad> lPropiedades = PropiedadesPepsVistaLogica.getInstance().consultarPropiedadesPeps(this.getObjUsuario());
		
		lstPropiedad = new HashMap<String,Propiedad>();
		
		for (Propiedad propiedad : lPropiedades) {
			lstPropiedad.put(propiedad.getStrCodigo(), propiedad);
		}
		
		this.castFrmPropiedadesPeps().getPnlPropiedadesPeps().getOperaciones().adicionarPropiedades(lstPropiedad);
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	obtenerListaRespuestaPreguntasPeps
				Metodo encargado de obtener el listado de las respuestas 
				seleccionadas por el usuario
	 * @param pObjPreguntasTerceroPepsDto
	 * 		  Objeto con la pregunta seleccionada por el usuario
	 * @return
	 * 		  objeto lista
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	private List<PreguntasTerceroPepsDTO> obtenerListaRespuestaPreguntasPeps(PreguntasTerceroPepsDTO pObjPreguntasTerceroPepsDto) throws Exception {
		
		List<PreguntasTerceroPepsDTO> lPreguntasTerceroPepsDto = new ArrayList<>();
		lPreguntasTerceroPepsDto.add(pObjPreguntasTerceroPepsDto);
		
		return lPreguntasTerceroPepsDto;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	castFrmPropiedadesPeps
	 * 		  	Metodo que se encarga de castear Forma recibida a 
	 * 			FormaPropiedadesPeps
	 * @return
	 * 			Objeto FormaPropiedadesPeps
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public FormaPropiedadesPeps castFrmPropiedadesPeps()throws Exception{
		return (FormaPropiedadesPeps)super.getFrmForma();
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getObjTercero
	 * 		  	Metodo get del objeto tercero
	 * @return
	 * 			Objeto Tercero
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public Tercero getObjTercero() {
		return objTercero;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	setObjTercero
	 * 		  	Metodo set del objeto tercero
	 * @param objTercero
	 * 			Objeto tercero
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public void setObjTercero(Tercero objTercero) {
		this.objTercero = objTercero;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	isBooProcesarPeticion
	 * 		  	metodo get del atributo booProcesarPeticion
	 * @return
	 * 			valor atributo booProcesarPeticion
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public boolean isBooProcesarPeticion() {
		return this.booProcesarPeticion;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	setBooProcesarPeticion
	 * 		  	metodo set del atributo booProcesarPeticion
	 * @param pBooProcesarPeticion
	 * 			boleano booProcesarPeticion
	 * @author	stiven.garcia
	 * @date	18/05/2018
	 * *********************************************************************
	 */
	public void setBooProcesarPeticion(boolean pBooProcesarPeticion) {
		this.booProcesarPeticion = pBooProcesarPeticion;
	}
	
		
}
