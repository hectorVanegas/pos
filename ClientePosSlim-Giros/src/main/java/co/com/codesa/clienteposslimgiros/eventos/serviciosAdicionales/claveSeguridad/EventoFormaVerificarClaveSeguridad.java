package co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.cifrados.EnumProcesosCifrado;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaVerificarClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.vista.logica.serviciosAdicionales.claveSeguridad.ClaveSeguridadVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/** 
 * ********************************************************************
 * @class  EventoFormaVerificarClaveSeguridad
 *		   [TODO - DOC]: Descripcion de la clase, su intencion, 
 *		   proposito y objetivo
 * @author roberth.martinez
 * @date   7/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class EventoFormaVerificarClaveSeguridad extends EventoAbstracto{

	/**
	 * @variable objFacturaGiro
	 * 			 objeto de factura giro
	 */
	private FacturaGiro objFacturaGiro;
	
	/** 
	 * ********************************************************************
	 * @method EventoFormaVerificarClaveSeguridad
	 * 		   constructor de la clase EventoFormaVerificarClaveSeguridad
	 * @param  pForma
	 * 		   Forma de la que se ejecuta el evento
	 * @param  pObjFacturaGiro
	 * 		   objeto de factura giro
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author roberth.martinez
	 * @date   8/3/2016
	 * *********************************************************************
	 */
	public EventoFormaVerificarClaveSeguridad(FormaGenerica pForma,
											     FacturaGiro pObjFacturaGiro) throws Exception{
		
		super(pForma);
		this.setObjFacturaGiro(pObjFacturaGiro);
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma) throws Exception{
		
		this.configuracionCampoTexto();
	}
	
	@Override
	public void confirmar() throws Exception {
		
		String strClave;
		String strClaveCifrada;
		boolean booValidaClave;
		Mensaje objMensaje;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios(super.getFrmForma(), 
				   												   true, 
				   												   true);
		
		strClave = this.castfrmValidarClaveTokenSeguridad().getPfiIngresarClave().getText().toUpperCase();
		strClaveCifrada = EnumProcesosCifrado.CLAVE_SEGURIDAD.cifrar(strClave);
		this.getObjFacturaGiro().getObjClaveSeguridad().setStrClaveCifrada(strClaveCifrada);
		try {
			booValidaClave = ClaveSeguridadVistaLogica.getInstance().verificarClaveSeguridad(super.getObjUsuario(), 
					 																		 this.getObjFacturaGiro());

			if (booValidaClave) {

				EnumMensajes.CLAVE_SEGURIDAD_MANUAL_INGRESADA_CORRECTA.desplegarMensaje(super.getFrmForma(), 
																						EnumClasesMensaje.INFORMACION);
				super.regresarFormaPadre();
			}else{

				EnumMensajes.CLAVE_SEGURIDAD_MANUAL_INGRESADA_INCORRECTA.desplegarMensaje(super.getFrmForma(), 
																						  EnumClasesMensaje.ERROR);
				this.castfrmValidarClaveTokenSeguridad().getPfiIngresarClave().setText("");
			}
		} catch (Exception e) {
			
			super.controlExcepcion(e);
			this.castfrmValidarClaveTokenSeguridad().getPfiIngresarClave().setText("");
			
			if(e instanceof ClientePosSlimGirosException){
				
				objMensaje = (Mensaje)((ClientePosSlimGirosException)e).getObjMensaje();
				
				if(objMensaje.getCodigo().equals(EnumMensajes.CVS_SE_BLOQUEA_PIN_X_TIEMPO.getCodigo())){
					this.getObjFacturaGiro().getObjClaveSeguridad().setBooRevalidar(true);
					super.regresar();
					
				}
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method configuracionCampoTexto
	 * 		   inicializa los componentes de texto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   8/3/2016
	 * *********************************************************************
	 */
	private void configuracionCampoTexto()throws Exception{
		
		String strExpresionRegularIngreso;
		//String strExpresionRegularFinal;
		//String longitudMinima = "<longitud_minima>";
		//String longitudMaxima = "<longitud_maxima>";
		
		//int intLongitudMinimaClave;
		//int intLongitudMaximaClave;
		
		/*
		UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL,
				  									  EnumParametrosSistema.LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL);
		*/
		//intLongitudMinimaClave = EnumParametrosSistema.LONGITUD_MINIMA_CLAVE_SEGURIDAD_MANUAL.obtenerValorEntero();
		//intLongitudMaximaClave = EnumParametrosSistema.LONGITUD_MAXIMA_CLAVE_SEGURIDAD_MANUAL.obtenerValorEntero();
		
		strExpresionRegularIngreso = EnumExpresionesRegulares.VCS_CLAVE_VERIFICACION.getValor();
		//strExpresionRegularFinal = EnumExpresionesRegulares.PNL_CSM_CLAVE.getValor();
		
		//strExpresionRegularIngreso = strExpresionRegularIngreso.replace(longitudMaxima, String.valueOf(intLongitudMaximaClave));
		//strExpresionRegularFinal = strExpresionRegularFinal.replaceAll(longitudMinima, String.valueOf(intLongitudMinimaClave));
		//strExpresionRegularFinal = strExpresionRegularFinal.replaceAll(longitudMaxima, String.valueOf(intLongitudMaximaClave));
		
		this.castfrmValidarClaveTokenSeguridad().getPfiIngresarClave().getLblObligatorio().aplicarObligatoriedad(true);
		this.castfrmValidarClaveTokenSeguridad().getPfiIngresarClave().getPropiedades().setControlFormatoIngreso(strExpresionRegularIngreso);
		//this.castfrmValidarClaveTokenSeguridad().getPfiIngresarClave().getPropiedades().setControlFormatoFinal(strExpresionRegularFinal);
		
	}
	
	/**
	 * ********************************************************************
	 * @method castfrmValidarClaveTokenSeguridad
	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre frmForma
	 * @return FormaVerificarClaveSeguridad
	 * 		   Valor especifico recuperado
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   8/03/2016
	 * *********************************************************************
	 */
	public FormaVerificarClaveSeguridad castfrmValidarClaveTokenSeguridad()throws Exception{
		return (FormaVerificarClaveSeguridad)super.getFrmForma();
	}

	/**
	 * @method getObjFacturaGiro
	 * 		   Metodo get del atributo objFacturaGiro
	 * @return FacturaGiro
	 *		   Valor del atributo objFacturaGiro devuelto
	 * @author roberth.martinez
	 * @date   9/3/2016
	 */
	public FacturaGiro getObjFacturaGiro() {
		return objFacturaGiro;
	}

	/**
	 * @method setObjFacturaGiro
	 * 		   Metodo set del atributo objFacturaGiro
	 * @param  pObjFacturaGiro
	 *		   Valor que tomara el atributo objFacturaGiro
	 * @author roberth.martinez
	 * @date   9/3/2016
	 */
	public void setObjFacturaGiro(FacturaGiro pObjFacturaGiro) {
		this.objFacturaGiro = pObjFacturaGiro;
	}
}
