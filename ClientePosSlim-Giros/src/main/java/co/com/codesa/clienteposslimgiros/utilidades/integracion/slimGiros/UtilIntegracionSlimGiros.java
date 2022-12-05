package co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaCierreCaja;
import co.com.codesa.clienteposslimgiros.formas.mensajes.FormaMensajeAlerta;
import co.com.codesa.clienteposslimgiros.formas.sesion.FormaAutenticacion;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.CambiarContrasenaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.SesionVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 18-dic-2015
 * @Clase UtilIntegracionSlimGiros 
 * 		  Clase utilitaria relacionada con los procesos de integracion
 * 		  de los otros productos Slim hacia SlimGiros
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilIntegracionSlimGiros {

	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de diseno)
	 **/
	private static UtilIntegracionSlimGiros instancia;

	/**
	 * ****************************************************************.
	 * @metodo UtilIntegracionSlimGiros
	 * 		   Metodo constructor que permite inicializar variables y
	 * 		   ejecutar comportamientos de interes
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	private UtilIntegracionSlimGiros() {}

	/**
	 * ****************************************************************.
	 * @metodo getInstance
	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
	 * 		   clase, materializando esta por unica vez y manteniendo una 
	 * 		   sola instancia de esta
	 * @return UtilIntegracionSlimGiros
	 * 		   Tipo referente a la misma clase
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public static UtilIntegracionSlimGiros getInstance() {

		if (instancia == null) {

			instancia = new UtilIntegracionSlimGiros();
		}

		return instancia;
	}
	
	/**
	 * ********************************************************************
	 * @method	obtenerFechaHoraActualPosSlim
	 * 		  	Metodo que permite obtener la fecha y hora actual recuperada
	 * 			en el PosSlim del socket de empresa
	 * @throws	Exception
	 * 			Controla y escala cualquier tipo de excepcion presentada
	 * @author	hector.cuenca
	 * @date	27/03/*2019
	 * *********************************************************************
	 */
	public Date obtenerFechaHoraActualPosSlim()
	{
		
		Date datFechaHoraActual/* = new Date()*/;
		
		try{
			datFechaHoraActual = UtilidadGiros.getInstancia().getFORMATEADOR_FECHA_SLASH_COMPLETO().parse(InformacionSession.getInstance().getFechaHoraSistemaActual());
		}catch(Exception e){
			UtilidadesGiros.getInstance().controlExcepcion(e, null, false);
			datFechaHoraActual = new Date();
		}
		
		
		return datFechaHoraActual;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo cerrarCajaXCierreOtrosProductosSlim
	 * 		   Metodo dedicado al proceso de  integracion del cierre de 
	 * 		   caja de giros con el cierre de los otros productos Slim
	 * @param pFrmVentana
	 * 		  corresponde a la forma principal desde la que se despliegan 
	 * 		  las operaciones
	 * @return boolean
	 * 		   Bandera que permite identificar si el proceso de cierre
	 * 		   de caja se completo o no (true y false respectivamente)
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @autor Hector Q-en-K
	 * *****************************************************************
	 */
	public boolean cerrarCajaXCierreOtrosProductosSlim(JFrame pFrmVentana)throws Exception{

		Usuario objUsuarioSolicitante;
		FormaMensajeAlerta objFrmMsgAlerta;
		boolean booResultadoProceso = false;

		try{
			/**
			 * TODO validar con respecto a EnumTiposServicios.MODULO_GIROS, en versiones 
			 * 		posteriores del producto de giros
			 */
			if (InformacionSession.getInstance().getlServiciosConfigurados().contains("G")) {

				objUsuarioSolicitante = InformacionSessionGiros.getInstance().getObjUsuario();

				if(!objUsuarioSolicitante.isAutenticado()){

					objFrmMsgAlerta = EnumMensajes.REALIZAR_AUTENTICACION_SIN_DESPLIEGUE_PRODUCTO_GIROS.desplegarMensaje(pFrmVentana, 
							EnumClasesMensaje.CONFIRMACION);

					if(objFrmMsgAlerta.isOpcion()){

						new FormaAutenticacion(pFrmVentana,
								false,
								InformacionSession.getInstance().getUsuLoginSims(),
								InformacionSession.getInstance().getUsuPassSims(),
								false);
					}
				}

				if(objUsuarioSolicitante.isAutenticado()){

					try{

						CajaVistaLogica.getInstance().validaCaja(objUsuarioSolicitante,
																 objUsuarioSolicitante.getAgencia(),
																 objUsuarioSolicitante.getCaja());

						objFrmMsgAlerta = EnumMensajes.DETECTA_CAJA_ACTIVA_PROPONER_CIERRE.desplegarMensaje(pFrmVentana, 
								EnumClasesMensaje.CONFIRMACION);

						if(objFrmMsgAlerta.isOpcion()){

							new FormaCierreCaja(pFrmVentana, 
									true);

							booResultadoProceso = !objUsuarioSolicitante.getCaja().isAbierta();
						}

					}catch(Exception e){

						EnumMensajes.SISTEMA_NO_DETECTO_APERTURA_CAJA_ACTIVA.desplegarMensaje(pFrmVentana, 
								EnumClasesMensaje.INFORMACION);

						booResultadoProceso = true;
					}
				}
			}else{
				booResultadoProceso=true;
			}

		}catch(Exception e){

			UtilidadesGiros.getInstance().controlExcepcion(e, 
					pFrmVentana);
		}

		if(!booResultadoProceso){

			EnumMensajes.NO_SE_LOGRO_COMPLETAR_CIERRE_CAJA_PROCESO_INTEGRACION_CIERRE_PRODUCTOS.desplegarMensaje(pFrmVentana, 
					EnumClasesMensaje.ERROR);
		}

		return booResultadoProceso;
	}

	/**
	 * ****************************************************************.
	 * @metodo ejecutarCierreSesion
	 * 		   Metodo de integracion para ejecutar el cierre de sesion
	 * 		   sobre el producto de giros, este metodo es relacionado
	 * 		   sobre las funcionalidades basicas del PosSlim, que 
	 * 		   permiten ejecutar el cierre de sesion y asi, visualizar 
	 * 		   la operacion a nivel del cajero como el cierre de sesion
	 * 		   de un solo producto
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada 
	 * @autor Hector Q-en-K
	 * *****************************************************************
	 */
	public void ejecutarCierreSesion()throws Exception{

		Usuario objUsuario;

		/**
		 * TODO validar con respecto a EnumTiposServicios.MODULO_GIROS, en versiones 
		 * 		posteriores del producto de giros
		 */
		if (InformacionSession.getInstance().getlServiciosConfigurados().contains("G"))  
		{
			objUsuario = InformacionSessionGiros.getInstance().getObjUsuario();

			if	(		objUsuario	!=	null
					&&	objUsuario.isAutenticado()
				)
			{
				SesionVistaLogica.getInstance().cerrarSesion(objUsuario);
			}
		}
	}

	/**
	 * ****************************************************************.
	 * @metodo inicioGiros
	 * 		   metodo que permite realizar el inicio de giros, en caso
	 * 		   de que no existan las credenciales o falle el proceso de 
	 * 		   logueo, este debera mostrar una forma para ingresar login 
	 * 		   y password.
	 * @param pStrTipoServicio 
	 * 		  corresponde al indice del accordion seleccionado
	 * @param pFrmVentana
	 * 		  corresponde a la forma principal desde la que se despliegan 
	 * 		  las operaciones
	 * @autor Hector Q-en-K
	 * *****************************************************************
	 */
	public boolean inicioGiros(String pStrTipoServicio,
			JFrame pFrmVentana) throws Exception{

		boolean procesoExitoso=false;
		Usuario objUsuarioGiros;

		try {
			/**
			 * TODO validar con respecto a EnumTiposServicios.MODULO_GIROS, en versiones 
			 * 		posteriores del producto de giros
			 */
			if	(	pStrTipoServicio.equals("G")	)
			{
				objUsuarioGiros = InformacionSessionGiros.getInstance().getObjUsuario();
			
				if	(	!objUsuarioGiros.isAutenticado()	)
				{
	
					/*
					 * Si es el caso, realiza inicialmente el despliegue del proceso de
					 * autenticacion a nivel interno, transparente para el usuario final,
					 * de suceder cualquier problema a nivel interno, se expondra 
					 * automaticamente la forma que solicita el ingreso manual de las
					 * credenciales de autenticacion
					 */
					if	(		pFrmVentana!=null
							&& 	pFrmVentana.isVisible()
						)
					{
						new FormaAutenticacion(pFrmVentana,
								false,
								InformacionSession.getInstance().getUsuLoginSims(),
								InformacionSession.getInstance().getUsuPassSims(),
								true);
		
						//Valida si se completo una autenticacion exitosa
//						if(objUsuarioGiros.isAutenticado()){
//	
//							/*
//							 * de no haberse llevado a cabo una autenticacion valida, se
//							 * interrumpe el proceso elaborado por el evento, y conserva 
//							 * el tab de accordion anterior al ejecutar el de giros 
//							 */
//							if(!objUsuarioGiros.isBooIngresoAppAutomatico()){
//	
//								CambiarContrasenaVistaLogica.getInstance().cambiarContrasenaSims(InformacionSession.getInstance().getLogin(), 
//										InformacionSession.getInstance().getClaveUsuario(), 
//										objUsuarioGiros.getLogin(), 
//										InformacionSession.getInstance().getUsuPassSims(), 
//										objUsuarioGiros.getClave());
//							}
//	
							//procesoExitoso=!procesoExitoso;
//						}
					}
	
				}else{
	
					procesoExitoso=!procesoExitoso;
				}
			}	else	{
				procesoExitoso=!procesoExitoso;
			}

		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, pFrmVentana);
			throw e;
			//e.printStackTrace();
			//Logger.getInstance().info("Error en el proceso de inicio en giros, "+e.getMessage());
		}

		return procesoExitoso;
	}
	
	/**
	 * ********************************************************************
	 * @method	obtenerColorBordeSlimGiros
	 * 		   	Metodo que permite obtener el color definido como estandar
	 * 			para el contorno y deliniamientos de los componentes graficos
	 * 			utilizados para el producto de giros
	 * @return	Color
	 * 			Color definido para el contorno
	 * @author 	hector.cuenca
	 * @date   	3/11/2016
	 * *********************************************************************
	 */
	public Color obtenerColorContornoSlimGiros	(){
		
		return EnumColores.GNRL_CONTORNO.getColColor();
	}
}
