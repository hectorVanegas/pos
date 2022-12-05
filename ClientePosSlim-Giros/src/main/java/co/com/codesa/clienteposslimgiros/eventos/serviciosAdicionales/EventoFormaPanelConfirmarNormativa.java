package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.FormaPanelConfirmarNormativa;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

public class EventoFormaPanelConfirmarNormativa extends EventoAbstracto {

	
	private FormaPanelConfirmarNormativa frmPnlConfirmarNormativa;
	
	/**
	 * @variable	strTelefonoCelular
	 * 				Telefono celular que se requiere confirmar
	 */
	private String strTelefonoCelular;
	
	/**
	 * @variable	strTelefonoFijo
	 * 				Telefono fijo que se requiere confirmar
	 */
	private String strTelefonoFijo;
	
	
	private Tercero objTercero;
	
	/** ********************************************************************
	 * @method 	EventoFormaPanelSMSGiro
	 * 		   	Constructor que ejecuta la inicializacion de valores y 
	 * 		   	ejecucion de comportamientos inicales requeridos para
	 *         	el despliegue del control de eventos de la forma 
	 * @param  	pFrmPnlSMSGiro
	 * 		   	Seccion de la cual se estan controlando los eventos
	 * @param	pStrTelefonoCelular
	 * 			Telefono celular propuesto actualmente
	 * @throws 	Exception
     * 	       	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	6/4/2018
	 * *********************************************************************
	 */
	public EventoFormaPanelConfirmarNormativa(FormaGenerica pFrmPnlSMSGiro,
			String pStrTelefonoCelular, String pStrTelefonoFijo, Tercero objTercero) throws Exception{
		super(pFrmPnlSMSGiro);
		this.setStrTelefonoCelular(pStrTelefonoCelular);
		this.setStrTelefonoFijo(pStrTelefonoFijo);
		this.setObjTercero(objTercero);
	}
	
	@Override
	public void iniciarValores(Object... pArrObjParametrosForma) throws Exception {
		this.configuracionCampoTexto();
		this.cargarFormulario(this.getStrTelefonoCelular(), this.getStrTelefonoFijo());
	}
	
	/**
	 * ********************************************************************
	 * @method	configuracionCampoTexto
	 * 		  	metodo utilizado para inicializar la configuracion de los 
     *		   	campos de texto de la forma/seccion de la cual se estan 
     *		   	controlando los eventos
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	private void configuracionCampoTexto()
		throws Exception
	{	
		
		if(this.getStrTelefonoCelular() != null && !this.getStrTelefonoCelular().isEmpty())
			this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getLblObligatorio().aplicarObligatoriedad(true);
		
		this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CELULAR_TERCERO.getValor());
		
		
		if(this.getStrTelefonoFijo() != null && !this.getStrTelefonoFijo().isEmpty())
			this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getLblObligatorio().aplicarObligatoriedad(true);
		
		this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_TELEFONO.getValor());
		this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_TELEFONO_TERCERO.getValor());
		
	}
	
	/**
	 * ********************************************************************
	 * @method	cargarFormulario
	 * 		  	metodo utilizado para cargar el formulario segun los datos
     * 		   	e informacion recibidos
	 * @param	pStrTelefonoCelular
	 * 			Telefono celular que se requiere confirmar
	 * @param	pStrTelefonoFijo
	 * 			Telefono fijo que se requiere confirmar
     * @throws 	Exception
     * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void cargarFormulario(String pStrTelefonoCelular, String pStrTelefonoFijo)
		throws Exception
	{	
		this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().setText(pStrTelefonoCelular);
		this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().setText(pStrTelefonoFijo);
	}
	
	/**
	 * ********************************************************************
	 * @method	ejecutar
	 * 		  	
	 * 		   	automatica
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	public void ejecutar() 
		throws Exception
	{
		this.setStrTelefonoCelular(this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getText());
		this.setStrTelefonoFijo(this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getText());
	}
	
	@Override
	public void confirmar() throws Exception {
		
		if(validarCampos()) {
			TerceroVistaLogica.getInstance().actualizarTercero(this.getFrmForma().getObjUsuario(),
					this.getObjTercero());
			
			EnumMensajes
			.desplegarMensajePersonalizado(getFrmForma(),
					EnumClasesMensaje.INFORMACION,
					null,
					"{1}",
					"Actualización realizada satisfactoriamente.");
			
			super.regresarFormaPadre();
		}
		else {
			FormaMensajeAlerta frmMensajeAlerta = EnumMensajes
			.desplegarMensajePersonalizado(getFrmForma(),
					EnumClasesMensaje.CONFIRMACION,
					null,
					"{1}",
					"Los números de contactos NO fueron actualizados. ¿Está seguro de continuar?");
			if(frmMensajeAlerta.isOpcion()) {
				super.regresarFormaPadre();
			}
		}
	}
	
	@Override
	public void regresar() throws Exception {
		FormaMensajeAlerta frmMensajeAlerta = EnumMensajes
				.desplegarMensajePersonalizado(getFrmForma(),
						EnumClasesMensaje.CONFIRMACION,
						null,
						"{1}",
						"¿Está seguro que desea cancelar esta operación?");
		if(frmMensajeAlerta.isOpcion()) {
			super.regresarFormaPadre();
		}
	}
	
	private boolean validarCampos() throws Exception {
		boolean actualizado = false;
		if(!this.getObjTercero().getTelefono2().equals(this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getText())) {
			
			if(this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getText().trim().length() == 0) {
				throw EnumMensajes.CAMPO_SIN_DESCRIPCION_NO_CUMPLE_CON_FORMATO.generarExcepcion(EnumClasesMensaje.ERROR);
			}
				
			
			this.validarCampoTextoObligatorio(this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular(),	
					  this.getFrmPnlConfirmarNormativa().getLblIngresaCelular().getTextoOriginal());
			
			this.getObjTercero().setTelefono2(this.getFrmPnlConfirmarNormativa().getTxtIngresaCelular().getText());
			actualizado = true;
		}
			
		if(!this.getObjTercero().getTelefono1().equals(this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getText())) {
			if(this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getText().trim().length() == 0)
				throw EnumMensajes.CAMPO_SIN_DESCRIPCION_NO_CUMPLE_CON_FORMATO.generarExcepcion(EnumClasesMensaje.ERROR);
			
			this.validarCampoTextoObligatorio(this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono(),
					  this.getFrmPnlConfirmarNormativa().getLblIngresaTelefono().getTextoOriginal());
			
			this.getObjTercero().setTelefono1(this.getFrmPnlConfirmarNormativa().getTxtIngresaTelefono().getText());
			actualizado = true;
		}
		
		return actualizado;
	}
	
	private void validarCampoTextoObligatorio(CajaTextoUtil pCompCajaTextoUtil,
			  String pStrDescripcionCampo)throws Exception{

		if(pCompCajaTextoUtil.isEnabled() &&
		pCompCajaTextoUtil.isEditable()){
		
			pCompCajaTextoUtil.getPropiedades().validaFormatoFinal(true,
										   pStrDescripcionCampo);
		}
		
	}
	
	public FormaPanelConfirmarNormativa getFrmPnlConfirmarNormativa() {
		return (FormaPanelConfirmarNormativa)super.getFrmForma();
	}

	public void setFrmPnlConfirmarNormativa(FormaPanelConfirmarNormativa frmPnlConfirmarNormativa) {
		this.frmPnlConfirmarNormativa = frmPnlConfirmarNormativa;
	}

	public String getStrTelefonoCelular() {
		return strTelefonoCelular;
	}

	public void setStrTelefonoCelular(String strTelefonoCelular) {
		this.strTelefonoCelular = strTelefonoCelular;
	}

	public String getStrTelefonoFijo() {
		return strTelefonoFijo;
	}

	public void setStrTelefonoFijo(String strTelefonoFijo) {
		this.strTelefonoFijo = strTelefonoFijo;
	}
	
	public Tercero getObjTercero() {
		return objTercero;
	}
	
	public void setObjTercero(Tercero objTercero) {
		this.objTercero = objTercero;
	}
	
}
