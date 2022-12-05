package co.com.codesa.clienteposslimgiros.eventos.cambioContrasena;

import java.awt.event.WindowEvent;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.cambioContrasena.FormaCambioContrasena;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.CambiarContrasenaVistaLogica;

public class EventoFormaCambioContrasena extends EventoAbstracto {
	
	private String strContrasenaActual;
	private String strNuevaContrasena;
	private boolean booSincronizarEquivalencia;
	private boolean booLimpiaClaveAnterior;
	
	public EventoFormaCambioContrasena(FormaGenerica pForma,
									   String pStrContrasenaActual,
									   boolean pBooSincronizarEquivalencia) {
		super(pForma);
		this.strContrasenaActual = pStrContrasenaActual;
		this.booSincronizarEquivalencia = pBooSincronizarEquivalencia;
		if (pStrContrasenaActual != null) {
			this.booLimpiaClaveAnterior = true;
		}
	}

	@Override
	public void iniciarValores(Object... pArrObjParametrosForma)throws Exception {
		
		//ControlFocosForma objControlFocosForma;
		
		this.configuracionCampos();
		this.cargarFormulario();
		
		/*objControlFocosForma = super.getFrmForma().activarControlFocosFormaPersonalizado();
		objControlFocosForma.getLstComponentes().add(this.castFrmCambioContrasena().getPfiContrasenaNueva());
		objControlFocosForma.getLstComponentes().add(this.castFrmCambioContrasena().getPfiContrasenaAnterior());
		objControlFocosForma.getLstComponentes().add(this.castFrmCambioContrasena().getPfiConfirmaContrasena());*/
	}

	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmCambioContrasena().getPfiContrasenaAnterior().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmCambioContrasena().getPfiContrasenaNueva().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmCambioContrasena().getPfiConfirmaContrasena().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void confirmar() throws Exception {
		
		/*UtilComponentesGUI.getInstance().validarCamposObligatorios(super.getFrmForma(), 
																   true, 
																   true);*/
		this.validarContrasena();
		this.realizarCambioContrasena();
	}
	
	@Override
	public void salir() throws Exception {
		
		if(this.strNuevaContrasena != null){
			
			EnumMensajes.CONTRASENA_NO_CAMBIO.desplegarMensaje(super.getFrmForma(), 
															   EnumClasesMensaje.INFORMACION);
		}
		
		super.salir();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCampos
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los campos del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCampos()throws Exception{
		this.configuracionCamposTexto();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionCamposTexto
  	 * 		   encargado de gestionar la configuracion personalizada
  	 * 		   para los diferentes campos de texto del formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionCamposTexto()throws Exception{
		
		this.castFrmCambioContrasena().getPfiContrasenaAnterior().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_CMC_CONTRASENA_USUARIO.getValor());
		this.castFrmCambioContrasena().getPfiContrasenaNueva().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_CMC_CONTRASENA_USUARIO.getValor());
		this.castFrmCambioContrasena().getPfiConfirmaContrasena().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_CMC_CONTRASENA_USUARIO.getValor());
	}
	
	private void cargarFormulario() throws Exception{
		
		this.castFrmCambioContrasena().getTxtUsuario().setText(super.getObjUsuario().getLogin());
		this.castFrmCambioContrasena().getPfiContrasenaAnterior().setText(this.strContrasenaActual);
	}

	private void validarContrasena() throws Exception{

		String strContrasenaAnterior;
		String strContrasenaNueva;
		String strConfirmaContrasena;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmCambioContrasena().getPfiContrasenaAnterior(), 
																	this.castFrmCambioContrasena().getLblContrasenaAnterior().getTextoOriginal(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmCambioContrasena().getPfiContrasenaNueva(), 
																this.castFrmCambioContrasena().getLblContrasenaNueva().getTextoOriginal(), 
																true, 
																true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmCambioContrasena().getPfiConfirmaContrasena(), 
																this.castFrmCambioContrasena().getLblConfirmaContrasena().getTextoOriginal(), 
																true, 
																true);
		
		strContrasenaAnterior = this.castFrmCambioContrasena().getPfiContrasenaAnterior().getText().toUpperCase();
		strContrasenaNueva = this.castFrmCambioContrasena().getPfiContrasenaNueva().getText().toUpperCase();
		strConfirmaContrasena = this.castFrmCambioContrasena().getPfiConfirmaContrasena().getText().toUpperCase();

		try{
		
			if(strContrasenaNueva.equals(strContrasenaAnterior)){
				
				throw EnumMensajes.CONTRASENA_DIFERENTE_ANTERIOR.generarExcepcion(EnumClasesMensaje.ERROR);
				
			}else if(!strContrasenaNueva.equalsIgnoreCase(strConfirmaContrasena)){
				
				throw EnumMensajes.CONTRASENA_ERROR_CONFIRMACION.generarExcepcion(EnumClasesMensaje.ERROR);
			
			}else if(strContrasenaNueva.length() < 8){
				
				throw EnumMensajes.CONTRASENA_MAYOR_CARACTERES.generarExcepcion(EnumClasesMensaje.ERROR);
				
			}else if(this.validaSecuenciaNumerica(strContrasenaNueva)){
				
				throw EnumMensajes.CONTRASENA_NO_PERMITIDA.generarExcepcion(EnumClasesMensaje.ERROR);
				
			}/*else if(strContrasenaNueva.equals(EnumParametrosApp.CONTRASENA_NO_PERMITIDA.getValorPropiedad())){
				
				throw EnumMensajes.CONTRASENA_NO_PERMITIDA.generarExcepcion(EnumClasesMensaje.ERROR, 
																	  EnumParametrosApp.CONTRASENA_NO_PERMITIDA.getValorPropiedad());
				
			}*/else if(this.validaCaracteresRepetidos(strContrasenaNueva)){
				
				throw EnumMensajes.CONTRASENA_CONTIENE_CARACTERES_REPETIDOS.generarExcepcion(EnumClasesMensaje.ERROR);
			}
		
		}catch(Exception e){
			
			this.limpiarCampos(this.booLimpiaClaveAnterior);
			throw e;
		}
	}
	
	private boolean validaSecuenciaNumerica(String pStrContrasenaNueva)throws Exception{
		
		char arrChrConstrasenaNueva [];
		boolean booResultado = true;
		
		arrChrConstrasenaNueva = pStrContrasenaNueva.toCharArray();
		
		for(int i=0 ;i<arrChrConstrasenaNueva.length;i++){
			
			if(!String.valueOf(arrChrConstrasenaNueva[i]).equals(String.valueOf((i+1)))){
				
				booResultado = false;
				break;
			}
		}
			
		return booResultado;
	}
	
	private boolean validaCaracteresRepetidos(String pStrContrasenaNueva) throws Exception{

		String strCaracterActual;
		int intNumeroDeVeces = 0;
		boolean booResultado = false;

		for (int i = 0; i < pStrContrasenaNueva.length(); i++) {

			strCaracterActual = pStrContrasenaNueva.substring(i, i + 1);

			for (int j = (i + 1); j < pStrContrasenaNueva.length(); j++) {

				if (strCaracterActual.equals(pStrContrasenaNueva.substring(j, j + 1))) {

					intNumeroDeVeces++;
				}
			}
		}

		if (intNumeroDeVeces != 0) {
			
			booResultado = true;
		}
		
		return booResultado;
	}
	
	private void realizarCambioContrasena() throws Exception{
		
		String strFechaCambio;
		
		try{
			
			strFechaCambio = CambiarContrasenaVistaLogica.getInstance().cambiarContrasena(super.getObjUsuario(),
																						  this.castFrmCambioContrasena().getPfiContrasenaAnterior().getText(),
					  																	  this.castFrmCambioContrasena().getPfiContrasenaNueva().getText(),
					  																	  this.castFrmCambioContrasena().getTxtUsuario().getText(),
					  																	  this.booSincronizarEquivalencia);
			
			this.strNuevaContrasena = this.castFrmCambioContrasena().getPfiContrasenaNueva().getText();
			super.getObjUsuario().setClave(this.strNuevaContrasena);
			
			EnumMensajes.CAMBIO_CONTRASENA_OK.desplegarMensaje(super.getFrmForma(), 
															   EnumClasesMensaje.INFORMACION, 
															   strFechaCambio);
			super.regresarFormaPadre();
			
		}catch(Exception e){
			
			this.limpiarCampos(this.booLimpiaClaveAnterior);
			throw e;
		}
	}
	
	private void limpiarCampos(boolean pBooDescartarContrasenaAnterior)throws Exception {
		
		if(!pBooDescartarContrasenaAnterior){
			this.castFrmCambioContrasena().getPfiContrasenaAnterior().setText("");
		}
			
		this.castFrmCambioContrasena().getPfiContrasenaNueva().setText("");
		this.castFrmCambioContrasena().getPfiConfirmaContrasena().setText("");
	}
	
	public FormaCambioContrasena castFrmCambioContrasena()throws Exception{
		return (FormaCambioContrasena)super.getFrmForma();
	}

	public String getStrNuevaContrasena() {
		return strNuevaContrasena;
	}

	public void setStrNuevaContrasena(String strNuevaContrasena) {
		this.strNuevaContrasena = strNuevaContrasena;
	}
	
}