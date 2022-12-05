package co.com.codesa.clienteposslimgiros.eventos.generico;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import co.com.codesa.clienteposslimgiros.dto.direccion.ConfigDireccionDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaDireccion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlDirecciones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 19-mar-2015 
 * @clase EventoFormaDireccion
 * 		  Clase encargada de controlar los eventos de la forma para  
 * 		  diligenciar la direccion
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaDireccion extends EventoAbstracto{
	
	private String strDireccionConfigurada;
	
	/**
	 * @variable	objDtoConfigDireccion
	 * 				Objeto DTO encargado de almacenar toda la configuracion 
	 *				relacionada con el formulario para diligenciar la direccion
	 */
	private ConfigDireccionDTO objDtoConfigDireccion;
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	EventoFormaDireccion
  	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
  	 * @param 	pForma
  	 * 		  	referencia a la GUI de la cual se estan controlando los 
  	 * 		  	eventos
  	 * @param	pObjDtoConfigDireccion
  	 * 			Objeto DTO encargado de almacenar toda la configuracion 
	 *			relacionada con el formulario para diligenciar la direccion
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaDireccion	(	FormaGenerica pForma,
									ConfigDireccionDTO pObjDtoConfigDireccion
								) 
		throws Exception
	{
		super(pForma);
		
		this.setObjDtoConfigDireccion(pObjDtoConfigDireccion);
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
  	 * 		  [0]: direccion ingresada para el despliegue inicial
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFormulario();
		this.configuracionIngresoCajasTexto();
		this.cargarDireccionIngresada((String)pArrObjParametrosForma[0]);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarVentanaDesplegada
  	 * 		   Metodo utilizado para centralizar y desacoplar la accion
  	 * 		   inmediatamente despues de hacerse el despliegue de una 
  	 * 		   ventana, ideal para realizar implementaciones de focos
  	 * 		   iniciales
  	 * @param pEvtWindowOpened 
  	 * 		  Evento correspondiente a la ventana, sobre la cual se 
  	 * 		  produce esta accion 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmDireccion().getCmbClasesVia().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmDireccion().getTxtEspecificacionAbierta().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmDireccion().getTxtNumeroVia().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmDireccion().getTxtNumeroLugar().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmDireccion().getTxtNumeroInterseccion().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	private String procesarFormato(String pStrFormato,
								   Enum<?> pEnmExpresion)throws Exception{
		
		EnumExpresionesRegulares enmExpresion;
		EnumEtiquetas enmEtiquetas;
		
		if(pEnmExpresion instanceof EnumExpresionesRegulares){
			
			enmExpresion = (EnumExpresionesRegulares)pEnmExpresion;
			
			pStrFormato = pStrFormato.replace("<"+enmExpresion.getCodigo()+">", 
											  enmExpresion.getValor());
			
		}else if(pEnmExpresion instanceof EnumEtiquetas){
			
			enmEtiquetas = (EnumEtiquetas)pEnmExpresion;
			
			pStrFormato = pStrFormato.replace("<"+enmEtiquetas.getEtiqueta()+">", 
											  "("+enmEtiquetas.toString()+"|"+enmEtiquetas.toString().toUpperCase()+")");
		}
		
		return pStrFormato;
	}
	
	private String obtenerFormatoDireccion()throws Exception{
		
		String strFormato;
		
		strFormato = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmDireccionCompleto().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_COMPLETO.getValor();

		strFormato = this.procesarFormato(strFormato,EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_CLASE_VIA);
		strFormato = this.procesarFormato(strFormato,this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoEspecificacionAbierta());
		strFormato = this.procesarFormato(strFormato,this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNumeroVia());
		strFormato = this.procesarFormato(strFormato,this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNumeroInterseccion());
		strFormato = this.procesarFormato(strFormato,this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNumeroLugar());
		strFormato = this.procesarFormato(strFormato,EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ZONA);
		strFormato = this.procesarFormato(strFormato,EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_CARACTERISTICA_LUGAR);
		strFormato = this.procesarFormato(strFormato,this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoEspecificacionLugar());
		strFormato = this.procesarFormato(strFormato,this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNombreBarrio());
		strFormato = this.procesarFormato(strFormato,EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ESTRATO);
		strFormato = this.procesarFormato(strFormato,EnumEtiquetas.LBL_DIR_ZONAS_UBICACION);
		strFormato = this.procesarFormato(strFormato,EnumEtiquetas.LBL_DIR_ESTRATOS_BARRIO);
		strFormato = this.procesarFormato(strFormato,EnumEtiquetas.LBL_DIR_NOMBRE_BARRIO);
		
		return strFormato;
	}
	
	private void validarFormatoDireccion(String pStrEntradaDireccion)throws Exception{
		
		String strFormato;
		boolean booFormatoIncorrecto=false;
		
		if(pStrEntradaDireccion!=null &&
				!pStrEntradaDireccion.trim().isEmpty()){
			
			strFormato = this.obtenerFormatoDireccion();
			
			if(!UtilidadesGiros.getInstance().validaFormato(strFormato, pStrEntradaDireccion)){
				booFormatoIncorrecto = true;
			}
		}else{
			booFormatoIncorrecto = true;
		}
		
		if(booFormatoIncorrecto){
			
			throw EnumMensajes.DIRECCION_NO_CUMPLE_CON_FORMATO.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																		  pStrEntradaDireccion);
		}
	}
	
	private void cargarDireccionIngresada(String pStrEntradaDireccion)throws Exception{
		
		String arrSeccionesDireccion[];
		
		try{
		
			this.validarFormatoDireccion(pStrEntradaDireccion);
			
			if(pStrEntradaDireccion.contains(".")){
				
				arrSeccionesDireccion = pStrEntradaDireccion.split("\\.");
				this.procesarDireccionIngresadaEspecifica(arrSeccionesDireccion);
				
			}else{
				this.procesarDireccionIngresadaAbierta(pStrEntradaDireccion);
			}
			
		}catch(Exception e){
			//super.controlExcepcion(e);
			this.restablecerForma();
		}
	}
	
	private void restablecerForma()throws Exception{
		
		UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.castFrmDireccion().getPnlContenido(), 
				  														  false, //pBooHabilitar
				  														  false,//pBooObviarOpuesto
				  														  true//pActivaRestablecerValores
				  														  );
		
		this.castFrmDireccion().getCmbClasesVia().setEnabled(true);
	}
	
	private void procesarDireccionIngresadaEspecifica(String pArrSeccionesDireccionEspecifica[])throws Exception{
		
		String strDireccionTradicional;
		
		strDireccionTradicional = pArrSeccionesDireccionEspecifica[0];
		
		this.cargarDireccionEspecificaTradicional(strDireccionTradicional);
		this.cargarSeccionesEspecificasNoObligatorias(pArrSeccionesDireccionEspecifica);
	}
	
	private void cargarSeccionesEspecificasNoObligatorias(String pArrSeccionesDireccionEspecifica[])throws Exception{
		
		String strSeccionNoObligatoria;
		
		if(pArrSeccionesDireccionEspecifica.length>1){
			
			for(int i=1; i<pArrSeccionesDireccionEspecifica.length;i++){
				
				strSeccionNoObligatoria = pArrSeccionesDireccionEspecifica[i].toUpperCase();
				
				if(strSeccionNoObligatoria.contains(EnumEtiquetas.LBL_DIR_ZONAS_UBICACION.toString().toUpperCase())){
					this.cargarZona(strSeccionNoObligatoria);
				}else if(strSeccionNoObligatoria.contains(EnumEtiquetas.LBL_DIR_NOMBRE_BARRIO.toString().toUpperCase())){
					this.cargarNombreBarrio(strSeccionNoObligatoria);
				}else if(strSeccionNoObligatoria.contains(EnumEtiquetas.LBL_DIR_ESTRATOS_BARRIO.toString().toUpperCase())){
					this.cargarEstratoBarrio(strSeccionNoObligatoria);
				}else{
					this.cargarLugar(strSeccionNoObligatoria);
				}
			}
		}
	}
	
	private void cargarZona(String pStrCadenaZona)throws Exception{
		
		String arrStrSeccionesZona[];
		DatoEntidad objDatZona;
		String strDescripcionZona;
		
		arrStrSeccionesZona = pStrCadenaZona.split(":");
		
		strDescripcionZona = arrStrSeccionesZona[1].trim();
		
		objDatZona = this.validarZona(strDescripcionZona);
		
		this.castFrmDireccion().getCmbZonasUbicacion().setSelectedItem(objDatZona);
	}
	
	private DatoEntidad validarZona(String pStrDescripcionZona)throws Exception{
		
		DatoEntidad objDatZona;
		String strIdEntidadDireccion;
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstSectoresUbicacion();//EnumParametrosApp.ENT_DIRECCION_SECTORES_UBICACION.getValorPropiedad();
		objDatZona = XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).buscarDatoXValor(pStrDescripcionZona);
		
		if(objDatZona == null){
			
			throw EnumMensajes.ZONA_DIRECCION_NO_ENCONTRADA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																	   pStrDescripcionZona);
		}
		
		return objDatZona;
	}
	
	private void cargarNombreBarrio(String pStrCadenaNombreBarrio)throws Exception{
		
		String arrStrSeccionesNombreBarrio[];
		String strNombreBarrio;
		
		arrStrSeccionesNombreBarrio = pStrCadenaNombreBarrio.split(":");
		
		strNombreBarrio = arrStrSeccionesNombreBarrio[1];
		
		this.castFrmDireccion().getTxtNombreBarrio().setText(strNombreBarrio);
		this.validarCajaTextoNombreBarrio(this.castFrmDireccion().getTxtNombreBarrio());
	}
	
	private void cargarEstratoBarrio(String pStrCadenaEstratoBarrio)throws Exception{
		
		String arrStrSeccionesEstratoBarrio[];
		DatoEntidad objDatEstratoBarrio;
		String strEstratoBarrio;
		
		arrStrSeccionesEstratoBarrio = pStrCadenaEstratoBarrio.split(":");
		
		strEstratoBarrio = arrStrSeccionesEstratoBarrio[1].trim();
		
		objDatEstratoBarrio = this.validarEstratoBarrio(strEstratoBarrio);
		
		this.castFrmDireccion().getCmbEstratosBarrio().setSelectedItem(objDatEstratoBarrio);
	}
	
	private DatoEntidad validarEstratoBarrio(String pStrEstratoBarrio)throws Exception{
		
		DatoEntidad objDatEstratoBarrio;
		String strIdEntidadDireccion;
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstEstratosBarrio();//EnumParametrosApp.ENT_DIRECCION_ESTRATOS_BARRIO.getValorPropiedad();
		objDatEstratoBarrio = XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).buscarDatoXValor(pStrEstratoBarrio);
		
		if(objDatEstratoBarrio == null){
			
			throw EnumMensajes.ESTRATO_DIRECCION_NO_ENCONTRADO.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																		  pStrEstratoBarrio);
		}
		
		return objDatEstratoBarrio;
	}
	
	private void cargarLugar(String pStrCadenaLugar)throws Exception{
		
		String arrStrSeccionesLugar[];
		String strCaracteristicaLugar;
		String strEspecificacionLugar;
		
		arrStrSeccionesLugar = pStrCadenaLugar.split(":");
		
		strCaracteristicaLugar = arrStrSeccionesLugar[0].trim();
		
		this.cargarCaracteristicaLugar(strCaracteristicaLugar);
		
		if(arrStrSeccionesLugar.length==2){
			
			strEspecificacionLugar = arrStrSeccionesLugar[1].trim();
			this.cargarEspecificacionLugar(strEspecificacionLugar);
		}
	}
	
	private void cargarEspecificacionLugar(String pStrEspecificacionLugar)throws Exception{
		this.castFrmDireccion().getTxtEspecificacionLugar().setText(pStrEspecificacionLugar);
	}
	
	private void cargarCaracteristicaLugar(String pStrCaracteristicaLugar)throws Exception{
		
		DatoEntidad objDatCaracteristicaLugar;
		
		objDatCaracteristicaLugar = this.validarCaracteristicaLugar(pStrCaracteristicaLugar);
		
		this.castFrmDireccion().getCmbCaracteristicasLugar().setSelectedItem(objDatCaracteristicaLugar);
		this.validarComboCaracteristicasLugar(this.castFrmDireccion().getCmbCaracteristicasLugar());
	}
	
	private DatoEntidad validarCaracteristicaLugar(String pStrCaracteristicaLugar)throws Exception{
		
		DatoEntidad objDatCaracteristicaLugar;
		String strIdEntidadDireccion;
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstCaracteristicasLugar();//EnumParametrosApp.ENT_DIRECCION_CARACTERISTICAS_LUGAR.getValorPropiedad();
		objDatCaracteristicaLugar = XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).buscarDatoXValor(pStrCaracteristicaLugar);
		
		if(objDatCaracteristicaLugar==null){
			
			throw EnumMensajes.CARACTERISTICA_LUGAR_DIRECCION_NO_ENCONTRADA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																					   pStrCaracteristicaLugar);
		}
		
		return objDatCaracteristicaLugar;
	}
	
	private void cargarDireccionEspecificaTradicional(String pStrDireccionTradicional)throws Exception{
		
		String arrStrSeccionesDireccionTradicional[];
		String strDescripcionClaseVia;
		String strNumeroViaTradicional;
		String strNumeroInterseccionTradicional;
		String strNumeroLugarTradicional;
		
		arrStrSeccionesDireccionTradicional = pStrDireccionTradicional.split(" ");
		
		strNumeroViaTradicional = arrStrSeccionesDireccionTradicional[arrStrSeccionesDireccionTradicional.length-5];
		strNumeroInterseccionTradicional = arrStrSeccionesDireccionTradicional[arrStrSeccionesDireccionTradicional.length-3];
		strNumeroLugarTradicional = arrStrSeccionesDireccionTradicional[arrStrSeccionesDireccionTradicional.length-1];//5
		
		strDescripcionClaseVia = pStrDireccionTradicional.substring(0, pStrDireccionTradicional.indexOf(strNumeroViaTradicional)).trim();//arrStrSeccionesDireccionTradicional[0];
		
		this.cargarClaseViaIngresada(strDescripcionClaseVia,
				 					 false);
		
		this.cargarNumeroViaTradicional(strNumeroViaTradicional);
		this.cargarNumeroInterseccionTradicional(strNumeroInterseccionTradicional);
		this.cargarNumeroLugarTradicional(strNumeroLugarTradicional);
	}
	
	private void cargarNumeroViaTradicional(String pStrNumeroViaTradicional)throws Exception{
		
		this.castFrmDireccion().getTxtNumeroVia().setText(pStrNumeroViaTradicional);
	}
	
	private void cargarNumeroInterseccionTradicional(String pStrNumeroInterseccionTradicional)throws Exception{
		
		this.castFrmDireccion().getTxtNumeroInterseccion().setText(pStrNumeroInterseccionTradicional);
	}
	
	private void cargarNumeroLugarTradicional(String pStrNumeroLugarTradicional)throws Exception{
		
		this.castFrmDireccion().getTxtNumeroLugar().setText(pStrNumeroLugarTradicional);
	}
	
	private void procesarDireccionIngresadaAbierta(String pStrEntradaDireccion)throws Exception{
		
		String arrStrSeccionesDireccionAbierta[];
		String strDescripcionClaseVia;
		String strDescripcionAbierta;
			
		arrStrSeccionesDireccionAbierta = pStrEntradaDireccion.split(":");
		
		strDescripcionClaseVia = arrStrSeccionesDireccionAbierta[0];
		strDescripcionAbierta = arrStrSeccionesDireccionAbierta[1].trim();
					
		this.cargarDireccionIngresadaAbierta(strDescripcionClaseVia, 
											 strDescripcionAbierta);
	}
	
	private void cargarDireccionIngresadaAbierta(String pStrDescripcionClaseVia,
												 String pStrDescripcionAbierta)throws Exception{
		
		this.cargarClaseViaIngresada(pStrDescripcionClaseVia,
									 true);
		
		this.cargarDescripcionAbiertaIngresada(pStrDescripcionAbierta);
	}
	
	private void cargarClaseViaIngresada(String pStrDescripcionClaseVia,
										 boolean pBooDireccionAbierta)throws Exception{
		DatoEntidad objDatClaseVia;
		
		objDatClaseVia = this.validarDireccionCargadaClaseVia(pStrDescripcionClaseVia,
															  pBooDireccionAbierta);
		
		this.castFrmDireccion().getCmbClasesVia().setSelectedItem(objDatClaseVia);
		this.validarComboClaseVia(this.castFrmDireccion().getCmbClasesVia());
	}
	
	private void cargarDescripcionAbiertaIngresada(String pStrDescripcionAbierta)throws Exception{
		
		this.castFrmDireccion().getTxtEspecificacionAbierta().setText(pStrDescripcionAbierta);
	}
	
	private DatoEntidad validarDireccionCargadaClaseVia(String pStrDscripcionClaseVia,
														boolean pBooDireccionAbierta)throws Exception{
		DatoEntidad objDatClaseVia;
		String strIdEntidadDireccion;
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstClaseVia();
		objDatClaseVia = XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).buscarDatoXValor(pStrDscripcionClaseVia);
		
		if(objDatClaseVia==null){
			
			throw EnumMensajes.CLASE_VIA_DIRECCION_NO_ENCONTRADA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																			pStrDscripcionClaseVia);
		}else{
			
			if(pBooDireccionAbierta){
				
				if(!objDatClaseVia.getTipoDato().equals(EnumParametrosApp.TIP_DAT_DIRECCION_CLASE_VIA_ESPECIFICACION_ABIERTA.getValorPropiedad())){
					
					throw EnumMensajes.CLASE_VIA_INCONSISTENTE_ABIERTA_ESPECIFICA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																							 pStrDscripcionClaseVia);
				}
				
			}else{
				
				if(objDatClaseVia.getTipoDato().equals(EnumParametrosApp.TIP_DAT_DIRECCION_CLASE_VIA_ESPECIFICACION_ABIERTA.getValorPropiedad())){
					
					throw EnumMensajes.CLASE_VIA_INCONSISTENTE_ESPECIFICA_ABIERTA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA, 
																							 pStrDscripcionClaseVia);
				}
			}
		}
		
		return objDatClaseVia;
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
		
		if(pComponent.equals(this.castFrmDireccion().getCmbClasesVia())){
			
			this.validarComboClaseVia((JComboBox)pComponent);
			
		}else if(pComponent.equals(this.castFrmDireccion().getCmbCaracteristicasLugar())){
			
			this.validarComboCaracteristicasLugar((JComboBox)pComponent);
			
		}else{
			
			super.accionarEjecucion(pComponent,pEvtEjecucion);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo accionarIngresoLiberado
  	 * 			Metodo utilizado para centralizar y desacoplar las 
  	 * 			acciones producidas cuando se libera un ingreso por
  	 * 			teclado (keyReleased)
  	 * @param pComponent 
  	 * 		  Componente grafico por el cual se produce el evento
  	 * @param pEvtKeyReleased
  	 * 			Evento del componente gráfico.
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void accionarIngresoLiberado(Component pComponent,
										KeyEvent pEvtKeyReleased)throws Exception{
		
		if(pComponent.equals(this.castFrmDireccion().getTxtNombreBarrio())){
			
			this.validarCajaTextoNombreBarrio((JTextComponent)pComponent);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo confirmar
  	 * 		   Metodo que ejecuta las acciones referentes al boton de 
  	 * 		   operacion representativo para confirmar
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void confirmar() throws Exception{
		
		//UtilComponentesGUI.getInstance().validarCamposObligatorios(super.getFrmForma(), true, true);
		
		String strDireccionConfigurada;
		
		strDireccionConfigurada = this.obtenerDireccionConfigurada();
		
		if(!strDireccionConfigurada.isEmpty()){
			this.strDireccionConfigurada = strDireccionConfigurada;
		}
		
		super.regresarFormaPadre();
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo cargarFormulario (Metodo)
  	 * 		   Metodo encargado de realizar el cargue de la informacion 
  	 * 		   inicial sobre el formulario
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void cargarFormulario() throws Exception{
		
		String strIdEntidadDireccion;
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstClaseVia();
		
		//cargar combo clases guia
		this.castFrmDireccion().getCmbClasesVia().getPropiedades().cargarCombo(XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).getHmDatos().values().toArray(),
												 							   true,
												 							   EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstSectoresUbicacion();//EnumParametrosApp.ENT_DIRECCION_SECTORES_UBICACION.getValorPropiedad();
		
		//cargar combo sectores ubicacion
		this.castFrmDireccion().getCmbZonasUbicacion().getPropiedades().cargarCombo(XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).getHmDatos().values().toArray(),
												 								   	true,
												 								   	EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstCaracteristicasLugar();//EnumParametrosApp.ENT_DIRECCION_CARACTERISTICAS_LUGAR.getValorPropiedad();
		
		//cargar combo caracteristicas lugar
		this.castFrmDireccion().getCmbCaracteristicasLugar().getPropiedades().cargarCombo(XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).getHmDatos().values().toArray(),
												 										  true,
												 										  EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		strIdEntidadDireccion = this.getObjDtoConfigDireccion().getStrEntLstEstratosBarrio();//EnumParametrosApp.ENT_DIRECCION_ESTRATOS_BARRIO.getValorPropiedad();
		
		//cargar combo caracteristicas lugar
		this.castFrmDireccion().getCmbEstratosBarrio().getPropiedades().cargarCombo(XmlDirecciones.getInstancia().obtenerEntidad(strIdEntidadDireccion).getHmDatos().values().toArray(),
												 								    true,
												 								    EnumEtiquetas.LBL_NO_SELECCIONADO);
		
		this.validarComboClaseVia(this.castFrmDireccion().getCmbClasesVia());
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo configuracionIngresoCajasTexto (Metodo)
  	 * 		   metodo donde se ejecuta el proceso de configuracion del 
  	 * 		   control de formato de ingreso sobre las cajas de texto, 
  	 * 		   a traves de expresiones regulares
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void configuracionIngresoCajasTexto()throws Exception{
		
		String strControlFormatoIngreso;
		String strControlFormatoFinal;
		
		strControlFormatoIngreso = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoEspecificacionAbierta().getValor();
		strControlFormatoFinal = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmFinalEspecificacionAbierta().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ESPECIFICACION_ABIERTA_FINAL.getValor();
		this.castFrmDireccion().getTxtEspecificacionAbierta().getPropiedades().setControlFormatoIngreso(strControlFormatoIngreso);
		this.castFrmDireccion().getTxtEspecificacionAbierta().getPropiedades().setControlFormatoFinal(strControlFormatoFinal);
		
		strControlFormatoIngreso = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNumeroVia().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_VIA.getValor();
		this.castFrmDireccion().getTxtNumeroVia().getPropiedades().setControlFormatoIngreso(strControlFormatoIngreso);
		this.castFrmDireccion().getTxtNumeroVia().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strControlFormatoIngreso = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNumeroInterseccion().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_INTERSECCION.getValor();
		this.castFrmDireccion().getTxtNumeroInterseccion().getPropiedades().setControlFormatoIngreso(strControlFormatoIngreso);
		this.castFrmDireccion().getTxtNumeroInterseccion().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strControlFormatoIngreso = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNumeroLugar().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_TRADICIONAL_NUMERO_LUGAR.getValor();
		this.castFrmDireccion().getTxtNumeroLugar().getPropiedades().setControlFormatoIngreso(strControlFormatoIngreso);
		
		strControlFormatoIngreso = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoEspecificacionLugar().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_ESPECIFICACION_LUGAR.getValor();
		this.castFrmDireccion().getTxtEspecificacionLugar().getPropiedades().setControlFormatoIngreso(strControlFormatoIngreso);
		this.castFrmDireccion().getTxtEspecificacionLugar().getPropiedades().setActivaMayusculaMinuscula(true);
		
		strControlFormatoIngreso = this.objDtoConfigDireccion.getEnmExpRegCtrlFrmIngresoNombreBarrio().getValor();//EnumExpresionesRegulares.EXP_REG_FORMATO_DIR_NOMBRE_BARRIO.getValor();
		this.castFrmDireccion().getTxtNombreBarrio().getPropiedades().setControlFormatoIngreso(strControlFormatoIngreso);
		this.castFrmDireccion().getTxtNombreBarrio().getPropiedades().setActivaMayusculaMinuscula(true);
		
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarComboClaseVia
  	 * 		   Metodo encargado de activar las implementaciones asociadas
  	 * 		   al combo de clase via cuando se acciona
  	 * @param pJComboBox
  	 * 		  componente de lista de valores (combo), que identifica al
  	 * 		  listado de clases de via, sobre el cual se activaran acciones
  	 * 		  respectivas
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarComboClaseVia(JComboBox pJComboBox)throws Exception{
		
		DatoEntidad objDatClaseVia;
		
		if(pJComboBox.getSelectedItem() instanceof DatoEntidad){
			
			objDatClaseVia = (DatoEntidad)pJComboBox.getSelectedItem();
			
			if(objDatClaseVia.getTipoDato().equals(EnumParametrosApp.TIP_DAT_DIRECCION_CLASE_VIA_ESPECIFICACION_ABIERTA.getValorPropiedad())){
				
				UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.castFrmDireccion().getPnlContenido(), 
						  														  false, //pBooHabilitar
						  														  false,//pBooObviarOpuesto
						  														  true,//pActivaRestablecerValores
						  														  this.castFrmDireccion().getCmbClasesVia(),
						  														  this.castFrmDireccion().getTxtEspecificacionAbierta());
				
			}else{//cualquier otro item cuya configuracion en su tipo de dato (XML direcciones), sea diferente de {ESPECIFICACION_ABIERTA}
				
				UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.castFrmDireccion().getPnlContenido(), 
						  														  true, 
						  														  false,
						  														  true,
						  														  this.castFrmDireccion().getTxtEspecificacionAbierta(),
						  														  this.getObjDtoConfigDireccion().isBooHabilitarUbicacion()?null:this.castFrmDireccion().getPnlUbicacion(),
						  														  this.getObjDtoConfigDireccion().isBooHabilitarLugar()?null:this.castFrmDireccion().getPnlLugar()
						  														  );
				
				this.validarComboCaracteristicasLugar(this.castFrmDireccion().getCmbCaracteristicasLugar());
				this.validarCajaTextoNombreBarrio(this.castFrmDireccion().getTxtNombreBarrio());
			}
		}else{
			UtilComponentesGUI.getInstance().habilitarComponentesContenedorMasivo(this.castFrmDireccion().getPnlContenido(), 
					  														  false, 
					  														  false,
					  														  true,
					  														  this.castFrmDireccion().getCmbClasesVia());
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarComboCaracteristicasLugar
  	 * 		   Metodo encargado de activar las implementaciones asociadas
  	 * 		   al combo de clase via cuando se acciona
  	 * @param pJComboBox
  	 * 		  componente de lista de valores (combo), que identifica al
  	 * 		  listado de caracteristicas de via, sobre el cual se 
  	 * 		  activaran acciones respectivas
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarComboCaracteristicasLugar(JComboBox pJComboBox)throws Exception{
		
		if(pJComboBox.getSelectedItem() instanceof DatoEntidad){
			
			this.castFrmDireccion().getTxtEspecificacionLugar().setEnabled(true);
			
		}else{
			
			this.castFrmDireccion().getTxtEspecificacionLugar().setEnabled(false);
			this.castFrmDireccion().getTxtEspecificacionLugar().setText("");
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarCajaTextoNombreBarrio
  	 * 		   Metodo encargado de activar las implementaciones asociadas
  	 * 		   cuando el contenido de la caja de texto referente al nombre 
  	 * 		   del barrio cumple con alguna descripcion valida para 
  	 * 		   proceder a activar la lista de valores (combo), que contiene 
  	 * 		   la especificacion de los estratos
  	 * @param pJTextComponent
  	 * 		  caja de texto sobre la cual se efectuara la validacion
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void validarCajaTextoNombreBarrio(JTextComponent pJTextComponent)throws Exception{
		
		String strNombreBarrio;
		
		strNombreBarrio = pJTextComponent.getText().trim();
		
		if(strNombreBarrio.isEmpty()){
			this.castFrmDireccion().getCmbEstratosBarrio().setEnabled(false);
			this.castFrmDireccion().getCmbEstratosBarrio().setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
		}else{
			this.castFrmDireccion().getCmbEstratosBarrio().setEnabled(true);
		}
	}
	
	private String obtenerDireccionConfigurada()throws Exception{
		
		DatoEntidad objDatClaseVia;
		String strDireccion = null;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDireccion().getCmbClasesVia(), 
																this.castFrmDireccion().getLblClasesVia().getTextoOriginal(), 
																true, 
																true);
			
		objDatClaseVia = (DatoEntidad)this.castFrmDireccion().getCmbClasesVia().getSelectedItem();
		
		if(objDatClaseVia.getTipoDato().equals(EnumParametrosApp.TIP_DAT_DIRECCION_CLASE_VIA_ESPECIFICACION_ABIERTA.getValorPropiedad())){
			
			strDireccion = this.obtenerDireccionEspecificacionAbierta(objDatClaseVia);
		}else{
			strDireccion = this.obtenerDireccionEspecificacion(objDatClaseVia);
		}
		
		return strDireccion;
	}
	
	private String obtenerDireccionEspecificacionAbierta(DatoEntidad pObjDatClaseVia)throws Exception{
		
		String strDireccion;
		String strEspecificacionAbierta;
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDireccion().getTxtEspecificacionAbierta(), 
																this.castFrmDireccion().getLblEspecificacionAbierta().getTextoOriginal(), 
																true, 
																true);
		
		this.castFrmDireccion().getTxtEspecificacionAbierta().getPropiedades().validaFormatoFinal(true,
				  																				  this.castFrmDireccion().getLblEspecificacionAbierta().getTextoOriginal());
		
		strEspecificacionAbierta = this.castFrmDireccion().getTxtEspecificacionAbierta().getText().trim();
		strDireccion = pObjDatClaseVia.getValor()+": "+strEspecificacionAbierta;
		
		return strDireccion;
	}
	
	private String obtenerDireccionEspecificacion(DatoEntidad pObjDatClaseVia)throws Exception{
		
		String strDireccion;
		String strNumeroViaTradicional;
		String strNumeroInterseccionTradicional;
		String strNumeroLugarTradicional;
		
		strNumeroViaTradicional = this.castFrmDireccion().getTxtNumeroVia().getText().trim();
		strNumeroInterseccionTradicional = this.castFrmDireccion().getTxtNumeroInterseccion().getText().trim();
		strNumeroLugarTradicional = this.castFrmDireccion().getTxtNumeroLugar().getText().trim();
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDireccion().getTxtNumeroVia(), 
																	EnumEtiquetas.TTL_DIR_PNL_DIRECCION_TRADICIONAL.toString(), 
																    true, 
																    true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDireccion().getTxtNumeroInterseccion(), 
																	EnumEtiquetas.TTL_DIR_PNL_DIRECCION_TRADICIONAL.toString(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmDireccion().getTxtNumeroLugar(), 
																	EnumEtiquetas.TTL_DIR_PNL_DIRECCION_TRADICIONAL.toString(), 
																	true, 
																	true);
		
		strDireccion = pObjDatClaseVia.getValor()+" "+
							strNumeroViaTradicional+" "+
							this.castFrmDireccion().getLblSeparadorInterseccionVia().getTextoOriginal()+" "+
							strNumeroInterseccionTradicional+" "+
							this.castFrmDireccion().getLblSeparadorLugarInterseccion().getTextoOriginal()+" "+
							strNumeroLugarTradicional;
		
		strDireccion += this.obtenerConfiguracionUbicacion();
		strDireccion += this.obtenerConfiguracionLugar();
		strDireccion += this.obtenerConfiguracionBarrio();
		strDireccion = (strDireccion).trim()+".";
		
		return strDireccion;
	}
	
	private String obtenerConfiguracionUbicacion()throws Exception{
		
		DatoEntidad objDatZonaUbicacion;
		String strConfiguracionUbicacion = "";
		
		if(this.castFrmDireccion().getCmbZonasUbicacion().getSelectedItem() instanceof DatoEntidad){
			
			objDatZonaUbicacion = (DatoEntidad)this.castFrmDireccion().getCmbZonasUbicacion().getSelectedItem();
			
			strConfiguracionUbicacion=". "+this.castFrmDireccion().getLblZonasUbicacion().getTextoOriginal()+": "+objDatZonaUbicacion.getValor();
		}
		
		return strConfiguracionUbicacion;
	}
	
	private String obtenerConfiguracionLugar()throws Exception{
		
		DatoEntidad objDatCaracteristicaLugar;
		String strConfiguracionLugar = "";
		String strCaracteristicaLugar;
		String strEspecificacionLugar;
		
		if(this.castFrmDireccion().getCmbCaracteristicasLugar().getSelectedItem() instanceof DatoEntidad){
			
			objDatCaracteristicaLugar = (DatoEntidad)this.castFrmDireccion().getCmbCaracteristicasLugar().getSelectedItem();
			
			strCaracteristicaLugar=objDatCaracteristicaLugar.getValor();
			
			strEspecificacionLugar = this.castFrmDireccion().getTxtEspecificacionLugar().getText().trim();
			
			if(!strEspecificacionLugar.isEmpty()){
				strEspecificacionLugar = ": "+strEspecificacionLugar;
			}
			
			strConfiguracionLugar = ". "+strCaracteristicaLugar+strEspecificacionLugar;
		}
		
		return strConfiguracionLugar;
	}
	
	private String obtenerConfiguracionBarrio()throws Exception{
		
		DatoEntidad objDatEstratoBarrio;
		String strConfiguracionBarrio="";
		String strNombreBarrio;
		String strEstratoBarrio="";
		
		strNombreBarrio = this.castFrmDireccion().getTxtNombreBarrio().getText().trim();
		
		if(!strNombreBarrio.isEmpty()){
			
			strNombreBarrio = this.castFrmDireccion().getLblNombreBarrio().getTextoOriginal()+": "+strNombreBarrio;
			
			if(this.castFrmDireccion().getCmbEstratosBarrio().getSelectedItem() instanceof DatoEntidad){
				
				objDatEstratoBarrio = (DatoEntidad)this.castFrmDireccion().getCmbEstratosBarrio().getSelectedItem();
				strEstratoBarrio = ". "+this.castFrmDireccion().getLblEstratosBarrio().getTextoOriginal()+": "+objDatEstratoBarrio.getValor();
			}
			
			strConfiguracionBarrio = ". "+(strNombreBarrio+strEstratoBarrio).trim();
			
		}
		
		return strConfiguracionBarrio;
	}
	
	public FormaDireccion castFrmDireccion()throws Exception{
		return (FormaDireccion)super.getFrmForma();
	}

	public String getStrDireccionConfigurada() {
		return strDireccionConfigurada;
	}

	public void setStrDireccionConfigurada(String strDireccionConfigurada) {
		this.strDireccionConfigurada = strDireccionConfigurada;
	}

	/**
	 * @method	getObjDtoConfigDireccion
	 * 		  	Metodo get del atributo objDtoConfigDireccion
	 * @return	ConfigDireccionDTO
	 *		  	Valor del atributo objDtoConfigDireccion devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public ConfigDireccionDTO getObjDtoConfigDireccion() {
		
		if	(	this.objDtoConfigDireccion	==	null	)
		{
			this.objDtoConfigDireccion = new ConfigDireccionDTO();
		}
		
		return objDtoConfigDireccion;
	}

	/**
	 * @method	setObjDtoConfigDireccion
	 * 		  	Metodo set del atributo objDtoConfigDireccion
	 * @param	pObjDtoConfigDireccion
	 * 			Valor que tomara el atributo objDtoConfigDireccion
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setObjDtoConfigDireccion(ConfigDireccionDTO pObjDtoConfigDireccion) {
		this.objDtoConfigDireccion = pObjDtoConfigDireccion;
	}

	
	
}
