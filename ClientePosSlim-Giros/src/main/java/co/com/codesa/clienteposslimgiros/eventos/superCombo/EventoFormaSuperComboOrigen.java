package co.com.codesa.clienteposslimgiros.eventos.superCombo;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumAyudas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumOperacionesAyuda;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.ayuda.FormaAyuda;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.superCombo.FormaSuperComboOrigen;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesSuperCombo;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 27-may-2015
 * @descripcion: Clase que representa los eventos de forma 
 * 				 supercombo origen
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaSuperComboOrigen extends EventoAbstracto{
	
	private String strValSuperCombo;
	private Factura factura;
	
	public EventoFormaSuperComboOrigen(FormaGenerica pForma,
									   String pStrValSuperCombo,
									   Factura pFactura) {
		super(pForma);
		
		this.strValSuperCombo = pStrValSuperCombo;
		this.factura = pFactura;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.llenarInformacionFormulario();
		
		this.configuracionCamposTexto();
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo llenarInformacionFormulario
     * 		   metodo utilizado para inicializar los datos de la 
     * 		   forma super combo origen
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void llenarInformacionFormulario()throws Exception{
		String strTelTerceroOrigen;
		String strTelTerceroDestino;
		
		strTelTerceroDestino = this.factura.getTerceroDestino().getTelefono2().equals("0") ? "" : this.factura.getTerceroDestino().getTelefono2();
		strTelTerceroOrigen = this.factura.getTerceroOrigen().getTelefono2().equals("0") ? "" : this.factura.getTerceroOrigen().getTelefono2();		
		
		this.castfrmSuperComboOrigen().getLblVlrSuperCombo().setText(this.strValSuperCombo);
		this.castfrmSuperComboOrigen().getTxtTelefonoDestino().setText(strTelTerceroDestino);
		this.castfrmSuperComboOrigen().getTxtTelefonoRemitente().setText(strTelTerceroOrigen);
		
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTexto
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void configuracionCamposTexto() throws Exception{
		
		this.castfrmSuperComboOrigen().getTxtTelefonoDestino().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.castfrmSuperComboOrigen().getTxtTelefonoDestino().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CELULAR_TERCERO.getValor());
		
		this.castfrmSuperComboOrigen().getTxtTelefonoRemitente().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_INGRESO_CELULAR.getValor());
		this.castfrmSuperComboOrigen().getTxtTelefonoRemitente().getPropiedades().setControlFormatoFinal(EnumExpresionesRegulares.EXP_REG_FORMATO_CELULAR_TERCERO.getValor());
	}
	
	@Override
	public void ayudar()throws Exception{
		
		new FormaAyuda(this.castfrmSuperComboOrigen(),
				   	   true,
				   	   this.castfrmSuperComboOrigen().getTitle(),
				   	   EnumAyudas.SUPER_COMBO,
				   	   EnumOperacionesAyuda.SUPER_COMBO,
				   	   null);
		
		//new FormaAyudaSuperCombo(super.getFrmForma(), true);
	}
	
	@Override
	public void confirmar() throws Exception {
		
		this.validarFormatoCelular();
		this.validarTipoSMS();
		
	}
	
	@Override
	public void salir()throws Exception{
		
		this.actualizaTipoSMS(EnumParametrosApp.SPC_SMS_SIN_SMS, EnumParametrosApp.SPC_SMS_SIN_SMS_TRAMA);
		
		super.regresarFormaPadre();
	}
	
	/**
  	 * ****************************************************************
  	 * @metodo actualizaTipoSMS
  	 * 		   Metodo para setiar que no se envian mensajes de texto
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void actualizaTipoSMS(EnumParametrosApp tipoSMS, EnumParametrosApp tipoSMSTrama) throws Exception {
		
		ValidacionesSuperCombo.getObjSuperCombo().setStrTipoSMS(tipoSMS.getObjConstante());
		
		ValidacionesSuperCombo.getObjSuperCombo().setStrTipoSMSTrama(tipoSMSTrama.getObjConstante());
	}
	
	/**
  	 * ****************************************************************
  	 * @metodo validarFormatoCelular
  	 * 		   Metodo para validar que los campos de telefono celular
  	 * 		   cumplan con el formato
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void validarFormatoCelular() throws Exception {
		
		this.castfrmSuperComboOrigen().getTxtTelefonoRemitente().getPropiedades().validaFormatoFinal(true,
																									 this.castfrmSuperComboOrigen().getLblTelefonoRemitente().getTextoOriginal());
		
		this.castfrmSuperComboOrigen().getTxtTelefonoDestino().getPropiedades().validaFormatoFinal(true,
																								   this.castfrmSuperComboOrigen().getLblTelefonoDestino().getTextoOriginal());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarTipoSMS
  	 * 		   Metodo para validar tipo de sms se enviara, sea ambos, 
  	 * 		   solo remitente, solo destinatario, ninguno 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void validarTipoSMS() throws Exception {
		
		String strTelOrigen;
		String strTelDestino;
		
		strTelOrigen = this.castfrmSuperComboOrigen().getTxtTelefonoRemitente().getText();
		strTelDestino = this.castfrmSuperComboOrigen().getTxtTelefonoDestino().getText();
		
		if (!strTelOrigen.isEmpty()
				&& strTelDestino.isEmpty()) {
			
			this.actualizaTipoSMS(EnumParametrosApp.SPC_SMS_SOLO_REMITENTE, EnumParametrosApp.SPC_SMS_SOLO_REMITENTE_TRAMA);
			
		} else if (!strTelDestino.isEmpty()
						&& strTelOrigen.isEmpty()) {
			
			this.actualizaTipoSMS(EnumParametrosApp.SPC_SMS_SOLO_DESTINATARIO, EnumParametrosApp.SPC_SMS_SOLO_DESTINATARIO_TRAMA);
			
		} else if (!strTelDestino.isEmpty() 
						&& !strTelOrigen.isEmpty()) {
			
			this.actualizaTipoSMS(EnumParametrosApp.SPC_SMS_AMBOS, EnumParametrosApp.SPC_SMS_AMBOS_TRAMA);
			
		} else {
			
			this.actualizaTipoSMS(EnumParametrosApp.SPC_SMS_SIN_SMS, EnumParametrosApp.SPC_SMS_SIN_SMS_TRAMA);
			
		}
		
		this.factura.getTerceroOrigen().setTelefono2(strTelOrigen);
		this.factura.getTerceroDestino().setTelefono2(strTelDestino);
		
		if (ValidacionesSuperCombo.getObjSuperCombo().getStrTipoSMS().equals(EnumParametrosApp.SPC_SMS_SIN_SMS.getObjConstante())) {
			
			EnumMensajes.SPC_SMS_NO_RECUERDE_ACTUALIZAR_NUMEROS.desplegarMensaje(super.getFrmForma(), 
																				 EnumClasesMensaje.INFORMACION);
		}
		
		super.regresarFormaPadre();
	}


	/**
  	 * ****************************************************************.
  	 * @metodo  castfrmSuperComboOrigen (Metodo)
 	 *			Metodo estandar para formatear el tipo de dato general 
 	 *			a un tipo especifico ("Casteo"), del atributo super.getFrmForma()
  	 * @return FormaSuperComboOrigen, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaSuperComboOrigen castfrmSuperComboOrigen()throws Exception{
		return (FormaSuperComboOrigen)super.getFrmForma();
	}

}
