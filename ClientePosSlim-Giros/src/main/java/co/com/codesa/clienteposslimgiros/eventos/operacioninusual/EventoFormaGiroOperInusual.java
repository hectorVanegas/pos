package co.com.codesa.clienteposslimgiros.eventos.operacioninusual;

import java.awt.event.WindowEvent;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.operacioninusual.FormaGiroOperInusual;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDatosEntidades;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.OperacionInusual;

public class EventoFormaGiroOperInusual extends EventoAbstracto {
	
	/**
	 * @variable objOperacionInusual
	 * 		     objeto OperacionInusual para manejar el dato 
	 * 			 entidad de la operacion inusual y la nota
	 **/
	OperacionInusual objOperacionInusual;
	
	/**
	 * @variable objDatEntOperacionInusual
	 * 		     objeto Datoentidad para manejar el dato 
	 * 			 entidad de la operacion inusual
	 **/
	DatoEntidad objDatEntOperacionInusual;
	
	/**
	 * @variable strAnotacion
	 * 		     nota para la operacion inusual
	 **/
	String strAnotacion;

	public EventoFormaGiroOperInusual(FormaGenerica pForma, 
									  OperacionInusual pObjOperacionInusual) {
		super(pForma);
		setObjOperacionInusual(pObjOperacionInusual);
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		String strTpOperInusuales;

		strTpOperInusuales = EnumParametrosApp.ENT_TIPOS_OPER_INUSUALES.getObjConstante();

		this.castFrmOperacionesInusuales().getJcbOperInusual().getPropiedades().cargarCombo(XmlDatosEntidades.getInstance().obtenerEntidad(strTpOperInusuales).getHmDatos().values().toArray(), 
																						    true, 
																							EnumEtiquetas.LBL_NO_SELECCIONADO);
		this.cargarDatos();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmOperacionesInusuales().getJcbOperInusual().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmOperacionesInusuales().getTxtNotas().getLblObligatorio().aplicarObligatoriedad(true);
	}

	@Override
	public void confirmar() throws Exception {
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmOperacionesInusuales().getJcbOperInusual(), 
																	this.castFrmOperacionesInusuales().getLblOperInusual().getTextoOriginal(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmOperacionesInusuales().getTxtNotas(),
																	this.castFrmOperacionesInusuales().getLblNotas().getTextoOriginal(),
																	true,
																	true);
		
		this.objDatEntOperacionInusual = (DatoEntidad) (this.castFrmOperacionesInusuales().getJcbOperInusual().getSelectedItem());
		
		this.strAnotacion = this.castFrmOperacionesInusuales().getTxtNotas().getText();
		
		super.regresarFormaPadre();
	}
	
	@Override
	public void cancelar() throws Exception {
		
		this.strAnotacion = null;
		this.objDatEntOperacionInusual = null;
		super.regresarFormaPadre();
	}
	
	/**
     * ****************************************************************
     * @metodo cargarDatos
     * 		   metodo utilizado para validar si existe una operacion 
     * 		   inusual, de ser asi la carga para ser editada o borrada
     * @throws Exception
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void cargarDatos() throws Exception{
		
		if (this.getObjOperacionInusual().getObjDaenOperacionInusual() != null) {
			
			this.castFrmOperacionesInusuales().getJcbOperInusual().setSelectedItem(this.getObjOperacionInusual().getObjDaenOperacionInusual());
			this.castFrmOperacionesInusuales().getTxtNotas().setText(this.getObjOperacionInusual().getStrNota());
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castFrmOperacionesInusuales
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
  	 * @return FormaGiroOperInusual
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaGiroOperInusual castFrmOperacionesInusuales()throws Exception{
		return (FormaGiroOperInusual)super.getFrmForma();
	}

	public OperacionInusual getObjOperacionInusual() {
		return objOperacionInusual;
	}

	public void setObjOperacionInusual(OperacionInusual objOperacionInusual) {
		this.objOperacionInusual = objOperacionInusual;
	}

	public DatoEntidad getObjDatEntOperacionInusual() {
		return objDatEntOperacionInusual;
	}

	public void setObjDatEntOperacionInusual(DatoEntidad objDatEntOperacionInusual) {
		this.objDatEntOperacionInusual = objDatEntOperacionInusual;
	}

	public String getStrAnotacion() {
		return strAnotacion;
	}

	public void setStrAnotacion(String strAnotacion) {
		this.strAnotacion = strAnotacion;
	}
}