package co.com.codesa.clienteposslimgiros.eventos.caja;


import java.awt.event.WindowEvent;
import java.util.Date;

import co.com.codesa.clienteposslimexception.exceptions.ClientePosSlimGirosException;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.caja.FormaAperturarCaja;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.mensajes.Mensaje;
import co.com.codesa.clienteposslimgiros.vista.logica.GeneralGirosVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.caja.CajaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.sesion.SesionVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-mar-2015 
 * @clase EventoFormaAperturarCaja
 * 		  Clase encargada de controlar los eventos de la forma de  
 * 		  apertura de caja
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaAperturarCaja extends EventoAbstracto{
	
	/**
  	 * ****************************************************************.
  	 * @metodo EventoFormaAperturarCaja
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
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
	public EventoFormaAperturarCaja(FormaGenerica pForma) throws Exception{
		
		super(pForma);
	}
	
	@Override
	public	void	accionarVentanaDesplegada	(	WindowEvent pEvtWindowOpened	) 
			throws Exception 
	{
		this.getFrmForma().getPnlBarraHerramientas().getComponents()[0].requestFocus();
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFormulario();
	}
	
	@Override
	public void confirmar() throws Exception{
		
		//Mensaje objMensaje;
		//boolean booCajaYaEstaAbierta = false;
		
		if(this.isBooFinalizoExitosoValores()){
			
			//try{
			
				CajaVistaLogica.getInstance().aperturarCaja(super.getObjUsuario());
			
			/*}catch(ClientePosSlimGirosException cpsge){
				
				objMensaje = (Mensaje)cpsge.getObjMensaje();
				
				if(objMensaje.getCodigo().equals(EnumMensajes.CAJA_YA_ESTA_ABIERTA.getCodigo())){
					
					super.controlExcepcion(cpsge);
					booCajaYaEstaAbierta = true;
					
				}else{
					
					throw cpsge;
				}
			}*/
			
			//GeneralGirosVistaLogica.getInstance().procesarPermisosMenu(true);
			
			//if(!booCajaYaEstaAbierta){
				
				EnumMensajes.CAJA_APERTURADA_CORRECTAMENTE.desplegarMensaje(super.getFrmForma(), 
																			EnumClasesMensaje.INFORMACION);
			//}
			
				try{
					//dsalazar[PlayTech] consulte la version del producto giro
					SesionVistaLogica.getInstance().consultarVersionProductoGiros(super.getObjUsuario());
				}catch(Exception e)
				{
					super.controlExcepcion(e);
				}
				
			super.getFrmForma().dispose();
			
		}else{
			
			throw EnumMensajes.CARGUE_INCOMPLETO_NO_PERMITE_CONTINUAR_OPERACION.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario
  	 * 		   Metodo que se encarga de gestionar el cargue de la 
  	 * 		   informacion sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario()throws Exception{
		this.cargarGrillaMediosPago();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarGrillaMediosPago
  	 * 		   Metodo encargado de solicitar a la vista logica de caja, 
  	 * 		   la consulta de saldos, para desplegar la informacion sobre 
  	 * 		   la pantalla de apertura de caja al ser esta desplegada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarGrillaMediosPago() throws Exception{
		
		Object mtrObjMediosPago[][];
		int intContadorFila;
		
		CajaVistaLogica.getInstance().consultarSaldosCaja	(	super.getObjUsuario(),
																UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim(),
																true
															);
		
		mtrObjMediosPago = new Object[super.getObjUsuario().getMediosPago().size()][3];
		intContadorFila=0;

		for(MedioPago medioPagoUsuario : super.getObjUsuario().getMediosPago()){

			mtrObjMediosPago[intContadorFila][0]=medioPagoUsuario.getDescripcion();
			mtrObjMediosPago[intContadorFila][1]=medioPagoUsuario.getMoneda().getDescripcion();
			mtrObjMediosPago[intContadorFila][2]=medioPagoUsuario.getSaldoInicial();

			intContadorFila++;
		}
		
		this.castFrmAperturaCaja().getTblMediosPago().getPropiedades().adicionarFilasGrilla(mtrObjMediosPago);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo castFrmAperturaCaja
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo frmAperturaCaja
  	 * @return FormaAperturarCaja
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaAperturarCaja castFrmAperturaCaja()throws Exception{
		return (FormaAperturarCaja)super.getFrmForma();
	}
	
}
