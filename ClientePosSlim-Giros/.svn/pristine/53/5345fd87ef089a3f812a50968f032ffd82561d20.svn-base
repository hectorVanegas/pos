package co.com.codesa.clienteposslimgiros.eventos.biometria;

import java.awt.AWTEvent;
import java.awt.Component;
import co.com.codesa.client.socketcliente.util.AdministradorPropiedades;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.biometria.EnumTiposBiometriaCaja;
import co.com.codesa.clienteposslimgiros.enumeraciones.operaciones.EnumTiposOperaciones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.biometria.FormaEnrolarTercero;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.validaciones.ValidacionesBiometria;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.biometria.BiometriaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 17-abril-2015
 * @descripcion: Clase que representa los eventos de forma Enrolar tercero
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaEnrolarTercero extends EventoAbstracto{
	
	private String strWsqHuellaDerecha;
	private String strWsqHuellaIzquierda;
	private String strHuellaHEXADer;
	private String strHuellaHEXAIzq;
	private boolean booHuellaDer;
	private boolean booHuellaIzq;
	private boolean booEnrolado;
	
	public EventoFormaEnrolarTercero(FormaGenerica pForma) {
		
		super(pForma);
		this.booHuellaDer = false;
		this.booHuellaIzq  = false;
		this.booEnrolado = false;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarEjecucion
  	 * 			Metodo utilizado para centralizar y desacoplar las 
  	 * 			acciones de ejecucion (Enter o confirmar con raton) de 
  	 * 			los eventos 
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento que 
  	 * 		  activa la ejecucion
  	 * @param pEvtEjecucion
  	 * 			Evento AWTEvent.Se usa debido a que el método es usado por diferentes listener
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void accionarEjecucion(Component pComponent,
								  AWTEvent pEvtEjecucion)throws Exception{
		
		if(pComponent.equals(this.castfrmEnrolarTercero().getBtnHuellaDerecha())){
			this.solicitaHuellaDerecha();
		}else if(pComponent.equals(this.castfrmEnrolarTercero().getBtnHuellaIzquierda())){
			this.solicitaHuellaIzquierda();
		}else{
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: confirmar
     * @descripcion: metodo utilizado para realizar el enrolamiento del 
     * 				 tercero
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	public void confirmar()throws Exception{
		
		if (this.isBooHuellaDer()) {//valida que ambas huellas estes capturadas correctamente.
			
			if (this.isBooHuellaIzq()) {
				
				this.enrolarTercero();
				
			}else {
				
				throw EnumMensajes.CAMPO_OBLIGATORIO.generarExcepcion(EnumClasesMensaje.ERROR, 
																	  EnumEtiquetas.LBL_ETC_HUELLA_IZQUIERDA.toString());
			}
		}else{
			
			throw EnumMensajes.CAMPO_OBLIGATORIO.generarExcepcion(EnumClasesMensaje.ERROR, 
																  EnumEtiquetas.LBL_ETC_HUELLA_DERECHA.toString());
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValores
  	 * 		   Metodo que permite desacoplar y centralizar todo el 
  	 * 		   despliegue logico inicial requerido por la funcionalidad 
  	 * 		   una vez desplegada la GUI
  	 * @param pArrObjParametrosForma
  	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.llenarInformacionFormulario();
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo: llenarInformacionFormulario
     * @descripcion: metodo utilizado para inicializar los datos del 
     * 			     tercero a enrolar
     * @autor: Roberth Martinez Vargas
     * ****************************************************************
     */
	private void llenarInformacionFormulario()throws Exception{
		
		this.castfrmEnrolarTercero().castPnlTercero().castEvaFrmTercero().forzarTercero(this.castfrmEnrolarTercero().getTercero());
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo solicitaHuellaDerecha
  	 * 			Metodo utilizado para realizar las acciones para 
  	 * 			solicitar la huella derecha
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void solicitaHuellaDerecha()throws Exception{
		
		this.castfrmEnrolarTercero().getBtnHuellaDerecha().setEnabled(false);
		this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText("");
    	this.setBooHuellaDer(false);
		
    	EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
				   								   EnumClasesMensaje.INFORMACION, 
				   								   null, 
				   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA_DER.getValorPropiedad()));

		strHuellaHEXADer = ValidacionesBiometria.getInstance().capturarHuella(EnumParametrosApp.SOLICITAR_LEER_HUELLA_DER.getValorPropiedad(),
																			  this.castfrmEnrolarTercero().getTercero());
		
		this.strWsqHuellaDerecha = this.castfrmEnrolarTercero().getTercero().getObjBiometria().gestionarHuellaDerecha().getStrWsq();
		
		if(strHuellaHEXADer.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad())){

        	this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText("");
        	this.setBooHuellaDer(false);
        	
        	EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
					   								   EnumClasesMensaje.INFORMACION, 
					   								   null, 
					   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad()));

            try {
            	// Espera 5 segundos para que la maquina active el sensor.
				Thread.sleep(5000);
			} catch (Exception e) {}
            
		}else if(strHuellaHEXADer.equals(EnumParametrosApp.BIO_RESPUESTA_INCOMPLETA.getValorPropiedad())){
			  
			this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText(EnumParametrosApp.BIO_REINICIE_IDVERIFY.getValorPropiedad());
			this.setBooHuellaDer(false);
	        	
		} else if(strHuellaHEXADer.equals(EnumParametrosApp.BIO_HUELLA_FALLIDA.getValorPropiedad())){

			this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText(EnumParametrosApp.BIO_RES_FALLA_LECTURA.getValorPropiedad()+"!");
			this.setBooHuellaDer(false); 	
        	
		}else if(strHuellaHEXADer.equals(EnumParametrosApp.BIO_HUELLA_CALIDAD_BAJA.getValorPropiedad())){
			
			EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
					   								   EnumClasesMensaje.INFORMACION, 
					   								   null, 
					   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.BIO_ADMPRO_CALIDAD_BAJA.getValorPropiedad()));
              
            this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText(EnumParametrosApp.BIO_RES_CALIDAD_BAJA.getValorPropiedad()+"!");
            this.setBooHuellaDer(false);
		
		}else if(strHuellaHEXADer.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad())){

			this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText(EnumParametrosApp.BIO_RES_LECTOR_NO_DETECTADO.getValorPropiedad()+"!");
			this.setBooHuellaDer(false);

		}else if (strHuellaHEXADer.length() > ValidacionesBiometria.getInstance().getIntMaxHuella() 
					&& !strHuellaHEXADer.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())) {

			this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText(AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad()));
			this.setBooHuellaDer(true);

        }else {

        	this.castfrmEnrolarTercero().getLblHuellaDerExitoso().setText(EnumParametrosApp.BIO_CAPTURA_NO_EXITOSA_ND.getValorPropiedad());
        	this.setBooHuellaDer(false);

        }
		
		this.castfrmEnrolarTercero().getBtnHuellaDerecha().setEnabled(true);

	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo solicitaHuellaIzquierda
  	 * 			Metodo utilizado para realizar las acciones para 
  	 * 			solicitar la huella izquierda
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void solicitaHuellaIzquierda()throws Exception{
		
		this.castfrmEnrolarTercero().getBtnHuellaIzquierda().setEnabled(false);
		this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText("");
    	this.setBooHuellaIzq(false);
		
    	EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
				   								   EnumClasesMensaje.INFORMACION, 
				   								   null, 
				   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.SOLICITAR_LEER_HUELLA_IZQ.getValorPropiedad()));
    	
		strHuellaHEXAIzq = ValidacionesBiometria.getInstance().capturarHuella(EnumParametrosApp.SOLICITAR_LEER_HUELLA_IZQ.getValorPropiedad(),
																			  this.castfrmEnrolarTercero().getTercero());
		
		this.strWsqHuellaIzquierda = this.castfrmEnrolarTercero().getTercero().getObjBiometria().gestionarHuellaIzquierda().getStrWsq();
		
		if(strHuellaHEXAIzq.equals(EnumParametrosApp.DEDO_NO_DETECTADO.getValorPropiedad())){

        	this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText("");
        	this.setBooHuellaIzq(false);
        	
        	EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
					   								   EnumClasesMensaje.INFORMACION, 
					   								   null, 
					   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.NO_SE_LOGRO_DETECTAR_HUELLA.getValorPropiedad()));
        	
            try {
            	// Espera 5 segundos para que la maquina active el sensor.
				Thread.sleep(5000);
			} catch (Exception e) {}
            
		}else if(strHuellaHEXAIzq.equals(EnumParametrosApp.BIO_RESPUESTA_INCOMPLETA.getValorPropiedad())){
			  
			this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText(EnumParametrosApp.BIO_REINICIE_IDVERIFY.getValorPropiedad());
			this.setBooHuellaIzq(false);
	        	
		} else if(strHuellaHEXAIzq.equals(EnumParametrosApp.BIO_HUELLA_FALLIDA.getValorPropiedad())){

			this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText(EnumParametrosApp.BIO_RES_FALLA_LECTURA.getValorPropiedad()+"!");
			this.setBooHuellaIzq(false); 	
        	
		}else if(strHuellaHEXAIzq.equals(EnumParametrosApp.BIO_HUELLA_CALIDAD_BAJA.getValorPropiedad())){
			
			EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
					   								   EnumClasesMensaje.INFORMACION, 
					   								   null, 
					   								   AdministradorPropiedades.getMensaje(EnumParametrosApp.BIO_ADMPRO_CALIDAD_BAJA.getValorPropiedad()));
			
            this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText(EnumParametrosApp.BIO_RES_CALIDAD_BAJA.getValorPropiedad()+"!");
            this.setBooHuellaIzq(false);
		
		}else if(strHuellaHEXAIzq.equals(EnumParametrosApp.LECTOR_NO_DETECTADO.getValorPropiedad())){

			this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText(EnumParametrosApp.BIO_RES_LECTOR_NO_DETECTADO.getValorPropiedad()+"!");
			this.setBooHuellaIzq(false);

		}else if (strHuellaHEXAIzq.length() > ValidacionesBiometria.getInstance().getIntMaxHuella() 
					&& !strHuellaHEXAIzq.equals(EnumParametrosApp.ERROR_IMAGEN_NULA.getValorPropiedad())) {

			this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText(AdministradorPropiedades.getMensaje(EnumParametrosApp.CAPTURA_EXITOSA.getValorPropiedad()));
			this.setBooHuellaIzq(true);

		}else if (strHuellaHEXAIzq.length() == 0){
			
			this.setBooHuellaIzq(false);
			
        }else {

        	this.castfrmEnrolarTercero().getLblHuellaIzqExitoso().setText(EnumParametrosApp.BIO_CAPTURA_NO_EXITOSA_ND.getValorPropiedad());
        	this.setBooHuellaIzq(false);

        }
		
		this.castfrmEnrolarTercero().getBtnHuellaIzquierda().setEnabled(true);

	}

	/**
  	 * ****************************************************************.
  	 * @metodo enrolarTercero
  	 * 			Metodo utilizado para enrolar un tercero cliente
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public void enrolarTercero()throws Exception{
		
		EnumTiposBiometriaCaja enmTipoBiometriaCaja;
		Tercero objTerceroAEnrolar;
		//String strRespuestaEnrolar;
		
		objTerceroAEnrolar	=	this.castfrmEnrolarTercero().getTercero();
		
		enmTipoBiometriaCaja	=	CajaVistaLogica.getInstance ().consultarTipoBiometriaCaja ( super.getObjUsuario() );
		
		if	(	EnumTiposBiometriaCaja.LOCAL.equals ( enmTipoBiometriaCaja )	)
		{
			ValidacionesBiometria.getInstance ().validarBiometriaLocal 	(	super.getObjUsuario(),
			                                                           	 	super.getFrmForma (),
			                                                           	 	objTerceroAEnrolar, 
			                                                           	 	objTerceroAEnrolar.getObjBiometria ().getHuellaDerecha().getStrIso ()
			                                                         	);
			objTerceroAEnrolar.getObjBiometria().setRequiereBiometria(true);			
			//strRespuestaEnrolar = "Tercero enrolado";
		}	else	{
			/*strRespuestaEnrolar = */TerceroVistaLogica.getInstance().registraHuellaEnrolarTercero(super.getObjUsuario(),
			                                                                                    objTerceroAEnrolar,
																		  						this.strWsqHuellaDerecha, 
																		  						this.strWsqHuellaIzquierda, 
																		  						this.strHuellaHEXADer, 
																		  						this.strHuellaHEXAIzq);
		}
		
		this.booEnrolado = true;
		
		EnumMensajes.TERCERO_ENROLADO_SATISFACTORAMENTE.desplegarMensaje(	super.getFrmForma(), 
																			EnumClasesMensaje.INFORMACION,
																			objTerceroAEnrolar.getIdentificacion()
																		);
		/*
		EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
												   EnumClasesMensaje.INFORMACION, 
												   null, 
												   strRespuestaEnrolar);
		*/
		this.regresarFormaPadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo: castfrmEnrolarTercero (Metodo)
  	 * @descripcion: Metodo estandar para formatear el tipo de dato 
  	 * 				 general a un tipo especifico ("Casteo"), del atributo
  	 * 				 super.getFrmForma()
  	 * @return: FormaEnrolarTercero, valor especifico recuperado
  	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
  	 * @autor: Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaEnrolarTercero castfrmEnrolarTercero()throws Exception{
		return (FormaEnrolarTercero)super.getFrmForma();
	}

	public boolean isBooHuellaIzq() {
		return booHuellaIzq;
	}

	public void setBooHuellaIzq(boolean booHuellaIzq) {
		this.booHuellaIzq = booHuellaIzq;
	}

	public boolean isBooHuellaDer() {
		return booHuellaDer;
	}

	public void setBooHuellaDer(boolean booHuellaDer) {
		this.booHuellaDer = booHuellaDer;
	}

	public boolean isBooEnrolado() {
		return booEnrolado;
	}

	public void setBooEnrolado(boolean booEnrolado) {
		this.booEnrolado = booEnrolado;
	}

}
