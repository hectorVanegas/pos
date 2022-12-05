package co.com.codesa.clienteposslimgiros.eventos.gridpropiedadesconvenios;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDatosAdicionalesCRC;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.pruebaadmisionentregatirilla.FormaPanelCelularCRC;
import co.com.codesa.clienteposslimgiros.formas.pruebaadmisionentregatirilla.FormaPropiedadesAdmisionEntregaTirilla;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesTercero;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaTramaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.propiedadesPruebaAdmisionEntregaTirilla.PropiedadesPruebaAdmisionEntregaTirilla;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Propiedad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.PruebaCRCAdmisionEntrega;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.pruebacrcadmisionentrega.PruebaCRC;
import co.com.codesa.codesawrappergiros.modelo.dto.giros.terceropeps.PreguntasTerceroPepsDTO;


/**
 * 
 * ********************************************************************
 * @class	EventoFormaPropiedadesAdmisionEntregaTirilla
 *		 	Clase EventoFormaPropiedadesAdmisionEntregaTirilla
 * @author	dsalazar[PlayTech]
 * @date  	19-feb-2019
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaPropiedadesAdmisionEntregaTirilla extends EventoAbstracto {
	
	/**
	 * @propiedad objPruebaCRC
	 * 			  Respuesta obtenida que notifica la prueba o constancia
	 *            de admision[Envio giro] o de entrega[Pago giro]
	 *            
	 */
	private PruebaCRCAdmisionEntrega objPruebaCRC;
	
	
	private String strRespuestaCRC; 
	
	/**
	 * @variable objTercero
	 * 			Tercero cliente 
	 */
	private Tercero objTercero;	
	
	/**
	 * @variable: booProcesarPeticion
	 *            bandera que indica si se debe enviarse la trama de registrar prueba
	 *            de admisión y entrega de tirilla.
	 */
	private boolean booProcesarPeticion;
	
	
	/**
	 * @variable: enmTipoOperacion
	 *            define el tipo de operacion en curso envio, pago, cambio beneficiario.
	 */
	private EnumTiposOperaciones enmTipoOperacion;
	
	/**
	 * 
	 * ********************************************************************
	 * @method	EventoFormaPropiedadesAdmisionEntregaTirilla
	 * 		  	Constructor del EventoFormaPropiedadesAdmisionEntregaTirilla
	 * @param pForma
	 * 			EventoFormaPropiedadesAdmisionEntregaTirilla asociada al evento 
	 * @param pObjTercero
	 * 			Tercero cliente
	 * @param pBooProcesarPeticion
	 * 			Bandera que especifica si se procesa la respuesta de peps
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	public EventoFormaPropiedadesAdmisionEntregaTirilla(FormaPropiedadesAdmisionEntregaTirilla pForma,
									  PruebaCRCAdmisionEntrega pobjPruebaCRC,
									  Tercero pObjTercero,
									  boolean pBooProcesarPeticion,
									  EnumTiposOperaciones pEnmTipoOperacion) throws Exception {
		super(pForma);
		this.objPruebaCRC = pobjPruebaCRC;
		this.objTercero = pObjTercero;
		this.booProcesarPeticion = pBooProcesarPeticion;
		this.enmTipoOperacion = pEnmTipoOperacion;
		
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
		this.accionAceptar();
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	accionAceptar
	 * 		  	Registra la informacion diligenciada del CRC
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	private void accionAceptar() throws Exception {
		
		if( this.objTercero != null ) {
			String strRespuestaCRC = "";
			PruebaCRC pcrcRespuesta = this.validarRespuestaPreguntaPropiedadesCRC();
			strRespuestaCRC = pcrcRespuesta.getStrRespuesta();
			this.castFrmPropiedadesAdmisionEntregaTirilla().setStrRespuetaCRC(strRespuestaCRC);
			//Llamada a validar el celular del tercero requerimiento fase 2
			presentarCambioCelular(super.getFrmForma(), objTercero,
					pcrcRespuesta.isBlnSeleccionDiferenteFisca());
			 
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
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	private void accionCancelar() throws Exception {
		accionRetornar();
	}
	
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion) throws Exception {
		
		if(pComponent.equals(this.castFrmPropiedadesAdmisionEntregaTirilla().getBtnAceptar())){
			
			this.accionAceptar();
			
		}else if(pComponent.equals(this.castFrmPropiedadesAdmisionEntregaTirilla().getBtnCancelar())){
			
			this.accionCancelar();
			
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	@Override
	public void regresar() throws Exception{
		accionRetornar();
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	validarRespuestaPreguntaPropiedadesPeps
	 * 		  	Metodo encargado de validar que almenos si seleccione una 
	 * 			respuesta correcta
	 * @return
	 * 			Objeto con la respuesta establecida o asignada por el usuario.
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	private PruebaCRC validarRespuestaPreguntaPropiedadesCRC() throws Exception {
		PruebaCRC pcrcRespuesta =  this.castFrmPropiedadesAdmisionEntregaTirilla().getPnlPropiedadesAdmEntTirillas().getEvaControlEventos().obtenerValorSeleccionado();
		return pcrcRespuesta;
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
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	private void cargarPreguntasPropiedades() throws Exception{
		
		HashMap<String,Propiedad> lstPropiedad;
		//List<Propiedad> lPropiedades = PropiedadesPruebaAdmisionEntregaTirilla.getInstance().consultarListaPropiedadTransmisionTirillas(this.getObjUsuario());
		List<Propiedad> lPropiedades = ControlConsultaTramaVistaLogica.getInstance().getPropiedadesTransTirillas();
		lstPropiedad = new HashMap<String,Propiedad>();
		
		for (Propiedad propiedad : lPropiedades) {
			lstPropiedad.put(propiedad.getStrCodigo(), propiedad);
		}
		
		this.castFrmPropiedadesAdmisionEntregaTirilla().getPnlPropiedadesAdmEntTirillas().getOperaciones().adicionarPropiedades(lstPropiedad);
		
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
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	public FormaPropiedadesAdmisionEntregaTirilla castFrmPropiedadesAdmisionEntregaTirilla()throws Exception{
		return (FormaPropiedadesAdmisionEntregaTirilla)super.getFrmForma();
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getObjTercero
	 * 		  	Metodo get del objeto tercero
	 * @return
	 * 			Objeto Tercero
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
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
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	public void setObjTercero(Tercero objTercero) {
		this.objTercero = objTercero;
	}
	
	
	private void accionRetornar() throws Exception{
		this.objTercero.setObjTerceroPeps(null);
		this.castFrmPropiedadesAdmisionEntregaTirilla().setStrRespuetaCRC(null);
		super.regresarFormaPadre();
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	isBooProcesarPeticion
	 * 		  	metodo get del atributo booProcesarPeticion
	 * @return
	 * 			valor atributo booProcesarPeticion
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
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
	 * @author	dsalazar[PlayTech]
	 * @date	19-feb-2019
	 * *********************************************************************
	 */
	public void setBooProcesarPeticion(boolean pBooProcesarPeticion) {
		this.booProcesarPeticion = pBooProcesarPeticion;
	}

	/**
	 * @return the objPruebaCRC
	 */
	public PruebaCRCAdmisionEntrega getObjPruebaCRC() {
		return objPruebaCRC;
	}

	/**
	 * @param objPruebaCRC the objPruebaCRC to set
	 */
	public void setObjPruebaCRC(PruebaCRCAdmisionEntrega objPruebaCRC) {
		this.objPruebaCRC = objPruebaCRC;
	}

	/**
	 * @return the strRespuestaCRC
	 */
	public String getStrRespuestaCRC() {
		return strRespuestaCRC;
	}

	/**
	 * @param strRespuestaCRC the strRespuestaCRC to set
	 */
	public void setStrRespuestaCRC(String strRespuestaCRC) {
		this.strRespuestaCRC = strRespuestaCRC;
	}

	/**
	 * @return the enmTipoOperacion
	 */
	public EnumTiposOperaciones getEnmTipoOperacion() {
		return enmTipoOperacion;
	}

	/**
	 * @param enmTipoOperacion the enmTipoOperacion to set
	 */
	public void setEnmTipoOperacion(EnumTiposOperaciones enmTipoOperacion) {
		this.enmTipoOperacion = enmTipoOperacion;
	}
	
    
	
	/**
	 * 
	 * ********************************************************************
	 * @method	presentarCambioCelular
	 * 		  	Metodo que se encarga de presentar pantalla para cambio 
	 * 			de celular del cliente
	 * @return
	 * 			nada
	 * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author	dsalazar[PlayTech]
	 * @date	07-marzo-2019
	 * *********************************************************************
	 */
	private void presentarCambioCelular(FormaGenerica pFrmGnrVentana,
			Tercero pObjTercero, boolean blnSeleccionDiferenteFisica) throws Exception{
		// Validando el servicio si se encuentra activo para una operacion
		ParametroSistema psPASI=null;
		String strValor;
		boolean blnPresentar=true; 
		String strTitulo="Beneficiario";
		boolean booRespuesta=false;
		             
		if (blnSeleccionDiferenteFisica){
			if (this.enmTipoOperacion == EnumTiposOperaciones.ENVIO_FACTURACION_GIRO) {
				/*UtilParametrosSistema
				.getInstance()
				.consultar(
						EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_ENVIO);
				
				booRespuesta = EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_ENVIO
						.obtenerValorBooleano("S");*/
				booRespuesta = ControlConsultaPasiVistaLogica.getInstance().getSercoenv();
				
				strTitulo="Remitente";

			} else if (this.enmTipoOperacion == EnumTiposOperaciones.PAGO_FACTURACION_GIRO) {
				
				/*UtilParametrosSistema
						.getInstance()
						.consultar(
								EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_PAGO);
				
				booRespuesta = EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_PAGO
						.obtenerValorBooleano("S");*/
				booRespuesta = ControlConsultaPasiVistaLogica.getInstance().getSercopag();								

			} else if (this.enmTipoOperacion == EnumTiposOperaciones.SOLICITUD_CAMBIO_BENEFICIARIO) {
				
				strTitulo="Remitente";
				
				/*UtilParametrosSistema
						.getInstance()
						.consultar(
								EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_CAMBIOBENEFICIARIO);
				
				booRespuesta = EnumParametrosSistema.ID_PASI_PRUEBA_CRC_SERVICIO_CELULAR_CAMBIOBENEFICIARIO
						.obtenerValorBooleano("S");*/
				booRespuesta = ControlConsultaPasiVistaLogica.getInstance().getSercocbf();

			}
			if (booRespuesta) {
				
				//Valide si ya se actualizo el telefono en una etapa anterior 
				if (pObjTercero.isBooActualizoCelular()){
					blnPresentar = false;
				}
				
				if (blnPresentar) {
					this.proponerActualizacionCelular(pFrmGnrVentana, pObjTercero,strTitulo);
				}
			}
		}
		
    }
	
	
	
	/**
	 * ********************************************************************
	 * @method	proponerActualizacionCelular
	 * 		  	Metodo que propone la actualizacion de celular del tercero
	 * 			  que se notificara via SMS de la operacion realizada para obtener
           el token para consultar la tirilla de forma fisica 
	 * @param	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando
	 * 			las operaciones
	 * @param	pObjTercero
	 * 			Tercero al que se le notificara por via SMS
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	dsalazar[PlayTech]
	 * @date	07-mar-2019 
	 * *********************************************************************
	 */
	private void proponerActualizacionCelular	(FormaGenerica pFrmGnrVentana,
												Tercero pObjTercero,
												String  pStrTitulo)
		throws Exception
	{
		FormaPanelCelularCRC pnlSMSCelularCRC;
		FormaDatosAdicionalesCRC objFormaDatosAdicionales;
		String strTelefonoInicial;
		EnumEtiquetas.PERSONALIZADA.setValor(pStrTitulo);

		pnlSMSCelularCRC = new FormaPanelCelularCRC	(	pFrmGnrVentana,
												pObjTercero.getTelefono2(),
												EnumDimensionesComponentes.PNL_PNL_SMS_SECCION,
												EnumEtiquetas.PERSONALIZADA
											);

		objFormaDatosAdicionales = new FormaDatosAdicionalesCRC(	pFrmGnrVentana,
																true,
																pnlSMSCelularCRC
															);

		if	(	objFormaDatosAdicionales.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNGUARDAR)	)
		{
			strTelefonoInicial = pObjTercero.getTelefono2();
			boolean blnContinuar = validarDatosTelefonos(pnlSMSCelularCRC,strTelefonoInicial);
			if (blnContinuar){
				pObjTercero.setTelefono2(pnlSMSCelularCRC.getTxtIngresaCelular().getText());
				ValidacionesTercero.getInstance().validaActualizaCelularTerceroCRC	(strTelefonoInicial,
																				pObjTercero,
																				pFrmGnrVentana
																			);
			}else{
				throw EnumMensajes.ERROR_NUMEROS_CELULAR_CRC
						.generarExcepcion(EnumClasesMensaje.ERROR);
				
			}
		}else if(objFormaDatosAdicionales.getEnmBotEncAccionSolicitada().equals(EnumBotonesEncabezado.BTNVOLVER)){
			throw EnumMensajes.PENDIENTES_NUMEROS_CELULAR_CRC
					.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	
	/**
	 * ********************************************************************
	 * @method	validarDatosTelefonos
	 * 		  	Metodo para validar la informacion de telefono ingresada
                 
	 * @param	pnlSMSCelularCRC
	 * 			Forma que se presenta con los datos del telefono
	 * @param	strTelefonoInicial
	 * 			Tercero al que se le notificara por via SMS
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion
	 *		   	presentada
	 * @author	dsalazar[PlayTech]
	 * @date	07-mar-2019 
	 * *********************************************************************
	 */
	private boolean validarDatosTelefonos(FormaPanelCelularCRC pnlSMSCelularCRC, String strTelefonoInicial) throws Exception{
		boolean blnResultado = true;
		String strTelefonoIngresado = pnlSMSCelularCRC.getTxtIngresaCelular().getText();
		String strTelefonConfirmado =  pnlSMSCelularCRC.getTxtConfirmaCelular().getText();
		//Validando si el telefono ingresado  es igual al confirmado
		if (!strTelefonoIngresado.equals(strTelefonConfirmado)) {
			blnResultado = false;
		}
		return blnResultado;
	}
	
		
}
