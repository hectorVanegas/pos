package co.com.codesa.clienteposslimgiros.eventos.autorizacion;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.TableColumn;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumExpresionesRegulares;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.autorizacion.FormaHistorialAutorizacion;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.SolicitudVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.EstadoAutorizaciones;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.utilidades.UtilidadGiros;


public class EventoFormaHistorialAutorizacion extends EventoAbstracto {
	
	/**
	 * ****************************************************************
	 * @autor: Roberth Martinez Vargas
	 * @fecha: 31-mar-2015
	 * @descripcion: Historial de autorizaciones eventos.
	 * @copyright: Copyright 1998-2015 Codesa, Todos los derechos reservados.
	 * ****************************************************************
	 */

	private String strReferencia;
	
	private List<EstadoAutorizaciones> lstAutorizaciones;
	private EstadoAutorizaciones objAutorizacion;
	private List<String> lstFiltroSolicitud;
	private List<String> lstFiltroEstado;

	public EventoFormaHistorialAutorizacion	(	FormaGenerica pForma	) 
			throws Exception
	{
		super(pForma);
		
		this.lstFiltroSolicitud	=	new ArrayList<String>();
		this.lstFiltroEstado	=	new ArrayList<String>();
	}
	
	public EventoFormaHistorialAutorizacion	(	FormaGenerica pForma,
												String pStrReferencia
											)	
													throws Exception
	{
		this(pForma);
		this.strReferencia	=	pStrReferencia;
	}
	
	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarFiltros();
		this.configuracionCampos();
		this.validaConsultaInmediata();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		/**
		 * Seccion de Obliegatoridad de Campos
		 */
		this.castfrmHistorialAutorizacion().getDtcFecha().getLblObligatorio().aplicarObligatoriedad(true);
		
	}

	@Override
	public void consultar	() 
			throws Exception
	{
		this.limpiar();
		this.validarParametrosConsulta();
		this.realizarConsultaAutorizaciones();
	}
	
	@Override
	public void imprimir() throws Exception {
		
		FacturaGiro objFacturaGiro;
		
		if (this.castfrmHistorialAutorizacion().getTblAutorizaciones().getModel().getRowCount()>0) {
			
			if (this.castfrmHistorialAutorizacion().getTblAutorizaciones().getSelectedRow() >= 0) {
				
				if (this.validarImpresionAnulacion()) {
					
					objFacturaGiro = this.obtenerFacturaGiro();
					
					this.verificarAnulacionEmpresa(objFacturaGiro);
																							
					this.generarImpresion	(	objFacturaGiro,
												EnumImpresiones.ANULACION_GIRO_AUTORIZADA
											);
					
				}else{
					
					throw EnumMensajes.SOLO_SOLICITUD_ANULACION_AUTORIZADA.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
				}
				
			}else{
				throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO_PARA_OPERACION.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
			}
		}else{

			throw EnumMensajes.PRIMERO_DEBE_CONSULTAR.generarExcepcion(EnumClasesMensaje.ADVERTENCIA);
		}
		
	}

	@Override
	public void accionarCambioItem	(	Component pComponent,
								   		ItemEvent pEvtItemStateChanged
								   	) 
								   			throws Exception 
	{
		if	(	pComponent.equals(this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud())	) 
		{
			this.aplicarFiltro	(	EnumEtiquetas.TTL_HAU_GRILLA_SOLICITUD,
									this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud().getSelectedItem().toString()
								);
			
		}	else if	(	pComponent.equals(this.castfrmHistorialAutorizacion().getCmbFiltroEstado())	) 
		{
			this.aplicarFiltro	(	EnumEtiquetas.TTL_HAU_GRILLA_ESTADO,
									this.castfrmHistorialAutorizacion().getCmbFiltroEstado().getSelectedItem().toString()
								);
			
		}	else	{
			
			super.accionarCambioItem	(	pComponent,
											pEvtItemStateChanged
										);
		}
	}
	
	@Override
	public void accionarDobleClick	(	Component pObjComponent,
								   		MouseEvent pEvtMouseClicked
								   	) 
								   			throws Exception 
	{	
		if	(	pObjComponent.equals(this.castfrmHistorialAutorizacion().getTblAutorizaciones())	)
		{
			this.despliegueInfoCelda();
			
		}else{
			
			super.accionarDobleClick(	pObjComponent,
										pEvtMouseClicked
									);
		}
	}
	
	@Override
	public boolean accionarIngresoXCaracter	(	Component pComponent, 
												char pChrIngreso, 
												KeyEvent pEvtKeyTyped
											) 
													throws Exception 
	{
		String strIngreso;
		boolean	booAnularIngreso;
		
		booAnularIngreso	=	super.accionarIngresoXCaracter	(	pComponent, 
				  													pChrIngreso,
				  													pEvtKeyTyped
				  												);
		if	(	!booAnularIngreso	)
		{
			if	(	pComponent.equals(this.castfrmHistorialAutorizacion().getTxtFiltroReferencia())	)
			{
				if	(	!(strIngreso	=	String.valueOf(pChrIngreso)).matches(EnumExpresionesRegulares.EXP_REG_FORMATO_NUMEROS.getValor())	)
				{
					strIngreso	=	"";
				}
				
				this.aplicarFiltro	(	EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA,
										this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().getText()+strIngreso
									);
			}
		}
		
		return booAnularIngreso;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	realizarConsultaAutorizaciones
	 * 		   	Metodo que permite procesar la consulta de autorizaciones
	 * 			segun los parametro de consulta ingresados
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void realizarConsultaAutorizaciones	()
			throws Exception
	{
		this.lstAutorizaciones = SolicitudVistaLogica.getInstance().consultarHistorialAutorizacion	(	super.getObjUsuario(),
	  																									this.castfrmHistorialAutorizacion().getDtcFecha().toString()
																									);

		if	(		lstAutorizaciones	==	null 
				|| 	lstAutorizaciones.isEmpty()
			)
		{
			throw EnumMensajes.NO_HAY_DATOS.generarExcepcion(EnumClasesMensaje.ERROR);
		}

		this.castfrmHistorialAutorizacion().getTblAutorizaciones().getPropiedades().adicionarFilasGrilla(this.obtenerTblAutorizaciones(this.lstAutorizaciones));
		this.cargarFiltros();

		if	(	!this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().getText().trim().isEmpty()	)
		{
			this.aplicarFiltro	(	EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA,
									this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().getText()
								);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	validarParametrosConsulta
	 * 		   	Metodo que permite validar los parametros ingresados para 
	 * 			llevar a cabo la consulta 
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void validarParametrosConsulta	() 
			throws Exception
	{
		Date datFechaActual;
		Date datFechaConsulta;
		
		UtilComponentesGUI.getInstance().validarCamposObligatorios	(	this.getFrmForma(), 
																		true, 
																		true
																	);
		
		datFechaActual 		=	UtilidadGiros.getInstancia().obtenerFechaSinHora(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
		datFechaConsulta	=	this.castfrmHistorialAutorizacion().getDtcFecha().getDate();
		
		if	(	datFechaConsulta.compareTo(datFechaActual)>0	)
		{
			throw EnumMensajes.FECHA_1_MAYOR_FECHA_2.generarExcepcion	(	EnumClasesMensaje.ERROR, 
																			EnumEtiquetas.LBL_HAU_FECHA.toString(),
																			EnumEtiquetas.LBL_FECHA_ACTUAL.toString()
																		);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	validaConsultaInmediata
	 * 		   	Metodo que permnite validar si la funcionalidad debe realizar
	 * 			una consulta inmediata para identificar el estado de una 
	 * 			referencia especifica
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void validaConsultaInmediata	()
			throws Exception
	{
		if	(	this.strReferencia	!=	null	)
		{
			try{
				
				this.realizarConsultaAutorizaciones();
				this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().setText(this.strReferencia);
				
				this.aplicarFiltro	(	EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA,
										this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().getText()
									);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	configuracionCampos
	 * 		   	Metodo que permite ejecutar una configuracion especifica para
	 * 			los campos del formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void configuracionCampos	() 
			throws Exception
	{
		this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().getPropiedades().setControlFormatoIngreso(EnumExpresionesRegulares.EXP_REG_FORMATO_PIN_GIRO.getValor());
	}
	
	/** 
	 * ********************************************************************
	 * @method 	cargarFiltros
	 * 		   	Metodo que permite cargar los filtros de busqueda
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void cargarFiltros	()
			throws Exception
	{
		/*
		List<DatoEntidad> lstSolicitudes;
		
		lstSolicitudes = DatoEntidadVistaLogica.getInstance().consultarConceptosEnDatoEntidad(super.getObjUsuario(),
																							  EnumParametrosApp.TIPO_SOLICITUD_LEVANTAMIENTO_Y_AUTORIZACION.getObjConstante());
		
		this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud().getPropiedades().cargarCombo(lstSolicitudes.toArray(), 
				 								 									    null, 	
				 								 									    null);
		
		this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud().insertItemAt("NO FILTRAR", 0);
		this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud().setSelectedIndex(0);
		*/
		
		
		this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud().getPropiedades().cargarCombo(	this.lstFiltroSolicitud.toArray(), 
				    																				true, 	
				    																				EnumEtiquetas.LBL_NO_SELECCIONADO
				    																			);
		this.castfrmHistorialAutorizacion().getCmbFiltroEstado().getPropiedades().cargarCombo	(	this.lstFiltroEstado.toArray(), 
																									true, 	
																									EnumEtiquetas.LBL_NO_SELECCIONADO
																								);
		//this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().setText("");
		
		if	(	this.lstFiltroSolicitud.isEmpty()	)
		{
			this.habilitarFiltros(false);
			
		}	else	{
			
			this.habilitarFiltros(true);
		}
	}
	
	/** 
	 * ********************************************************************
	 * @method 	habilitarFiltros
	 * 		   	Metodo que permite activar el conjunto de filtros disponibles
	 * @param 	pBooActivaFiltros
	 * 			Bandera que permite identificar si el conjunto de filtros se
	 * 			debe activar o no
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void habilitarFiltros	(	boolean pBooActivaFiltros	)
			throws Exception
	{
		this.castfrmHistorialAutorizacion().getCmbFiltroSolicitud().setEnabled(pBooActivaFiltros);
		this.castfrmHistorialAutorizacion().getCmbFiltroEstado().setEnabled(pBooActivaFiltros);
		this.castfrmHistorialAutorizacion().getTxtFiltroReferencia().setEnabled(pBooActivaFiltros);
	}
	
	/** 
	 * ********************************************************************
	 * @method 	limpiar
	 * 		   	Metodo que permite limpiar el resultado de consulta del 
	 * 			formulario
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	@Override
	public void limpiar	()
			throws Exception
	{
		super.limpiar(true,this.castfrmHistorialAutorizacion().getDtcFecha());
		//this.castfrmHistorialAutorizacion().getTblAutorizaciones().getPropiedades().limpiarGrilla();
		//this.castfrmHistorialAutorizacion().getTblAutorizaciones().getPropiedades().reiniciarFiltros();
		this.lstAutorizaciones	=	null;
		this.lstFiltroEstado.clear();
		this.lstFiltroSolicitud.clear();
		this.cargarFiltros();
	}
	
	/** 
	 * ********************************************************************
	 * @method 	obtenerTblAutorizaciones
	 * 		   	Metodo que permite obtener una matriz equivalente al listado 
	 * 			de autorizaciones consultado previamente
	 * @param 	pLstAutorizaciones
	 * 			Listado de autorizaciones consultado previamente
	 * @return	Object[][]
	 * 			Informacion del listado de autorizaciones en forma de matriz
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private Object[][] obtenerTblAutorizaciones	(	List<EstadoAutorizaciones> pLstAutorizaciones	) 
			throws Exception
	{
		Object[][] objTblAutorizaciones;
		EstadoAutorizaciones objEstadoAutorizacion;
		int intContadorFila;

		objTblAutorizaciones = new Object[pLstAutorizaciones.size()][10];
		intContadorFila = 0;

		for	(	int i=0	;	i<pLstAutorizaciones.size()	;	i++	) 
		{
			objEstadoAutorizacion	=	pLstAutorizaciones.get(i);
			objTblAutorizaciones[intContadorFila][0] = String.valueOf(i);
			objTblAutorizaciones[intContadorFila][1] = objEstadoAutorizacion.getHora();
			objTblAutorizaciones[intContadorFila][2] = objEstadoAutorizacion.getPin();
			objTblAutorizaciones[intContadorFila][3] = objEstadoAutorizacion.getObjDatEntSolicitud();
			objTblAutorizaciones[intContadorFila][4] = objEstadoAutorizacion.getAgenciaOrigen();
			objTblAutorizaciones[intContadorFila][5] = objEstadoAutorizacion.getAgenciaInicial();
			objTblAutorizaciones[intContadorFila][6] = objEstadoAutorizacion.getTerceroInicial();
			objTblAutorizaciones[intContadorFila][7] = objEstadoAutorizacion.getTerceroCambio();
			objTblAutorizaciones[intContadorFila][8] = objEstadoAutorizacion.getDesEstado();
			objTblAutorizaciones[intContadorFila][9] = objEstadoAutorizacion.getNotas();
			
			intContadorFila++;
			
			if	(	!this.lstFiltroSolicitud.contains(objEstadoAutorizacion.getObjDatEntSolicitud().toString())	)
			{
				this.lstFiltroSolicitud.add(objEstadoAutorizacion.getObjDatEntSolicitud().toString());
			}
			
			if	(	!this.lstFiltroEstado.contains(objEstadoAutorizacion.getDesEstado().toString())	)
			{
				this.lstFiltroEstado.add(objEstadoAutorizacion.getDesEstado().toString());
			}
		}

		return objTblAutorizaciones;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	aplicarFiltro
	 * 		   	aplica el filtro sobre los datos de la tabla, con base 
  	 * 			a la columna recibida
	 * @param 	pEnmEtiColumna
	 * 			Constante de enumeracion que representa la etiqueta asociada
	 * 			a la columna de interes a filtrar
	 * @param 	pStrFiltro
	 * 			valor a filtrar
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	hector.cuenca
	 * @date   	5/05/2017
	 * *********************************************************************
	 */
	private void aplicarFiltro	(	EnumEtiquetas pEnmEtiColumna,
									String pStrFiltro	
								)	
										throws Exception 
	{
		TableColumn objColumna;
		boolean booFiltroSimple;
		
		if	(		this.lstAutorizaciones	!=	null 
				&& 	!this.lstAutorizaciones.isEmpty()
			) 
		{
			objColumna	=	this.castfrmHistorialAutorizacion().getTblAutorizaciones().getColumn(pEnmEtiColumna.toString());
			
			if	(		pStrFiltro.equalsIgnoreCase(EnumEtiquetas.LBL_NO_SELECCIONADO.toString())	
					||	pStrFiltro.trim().isEmpty()
				)
			{
				booFiltroSimple	=	false;
				pStrFiltro	=	EnumExpresionesRegulares.EXP_REG_ADMITE_TODO.getValor();
				
			}	else if	(	pEnmEtiColumna.equals(EnumEtiquetas.TTL_HAU_GRILLA_REFERENCIA)	)	
			{
				booFiltroSimple	=	false;
				pStrFiltro	=	EnumExpresionesRegulares.GNR_INICIO.getValor()+pStrFiltro;
				
			}	else if    (		pEnmEtiColumna.equals(EnumEtiquetas.TTL_HAU_GRILLA_SOLICITUD)
								||	pEnmEtiColumna.equals(EnumEtiquetas.TTL_HAU_GRILLA_ESTADO)
							)
			{
				booFiltroSimple    =    false;

				pStrFiltro    = EnumExpresionesRegulares.GNR_INICIO.getValor()	+
								EnumExpresionesRegulares.escaparCaracteresEspeciales(pStrFiltro)	+
								EnumExpresionesRegulares.GNR_FIN.getValor();
			}else	{
				
				booFiltroSimple	=	true;
			}
			
			if	(	booFiltroSimple	)
			{
				this.castfrmHistorialAutorizacion().getTblAutorizaciones().getPropiedades().aplicarFiltroSimple	(	pStrFiltro, 
																													objColumna.getModelIndex()
																												);
			}	else	{
				
				this.castfrmHistorialAutorizacion().getTblAutorizaciones().getPropiedades().aplicarFiltroExpresion	(	pStrFiltro, 
																														objColumna.getModelIndex()
																													);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo validarImpresionAnulacion
  	 * 		   valida si el registro seleccionado es apto para realizar
  	 * 		   la impresion, solo aplica cuando es solicitado para
  	 * 		   anular y se encuentra en estado autorizado
  	 * @return boolean 
  	 * 		   informa si es apto para imprimir
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private boolean validarImpresionAnulacion()throws Exception{
		
		TableColumn objColumnaFila;
		int intFilaSeleccionada;
		int intPosLstAutorizaciones;
		boolean booActivaImpresionAnulacion;
		
		intFilaSeleccionada = this.castfrmHistorialAutorizacion().getTblAutorizaciones().getSelectedRow();
		
		objColumnaFila	=	this.castfrmHistorialAutorizacion().getTblAutorizaciones().getColumn(EnumEtiquetas.TTL_HAU_GRILLA_FILA.toString());
		
		intPosLstAutorizaciones	=	Integer.parseInt(this.castfrmHistorialAutorizacion().getTblAutorizaciones().getValueAt	(	intFilaSeleccionada, 
																																objColumnaFila.getModelIndex()
																															).toString()
													);

		this.objAutorizacion	=	this.lstAutorizaciones.get(intPosLstAutorizaciones);
		
		this.strReferencia = this.objAutorizacion.getPin();
		
		if (this.objAutorizacion.getObjDatEntSolicitud().getId().equals(EnumParametrosApp.COD_DAT_ENT_TP_SOL_ANULACION.getObjConstante()) &&
				this.objAutorizacion.getDesEstado().equals(EnumParametrosApp.DAT_ENT_AUTORIZACION_AUTORIZADO.getValorPropiedad())) {
			
			booActivaImpresionAnulacion = true;
		}else{
			
			booActivaImpresionAnulacion = false;
		}
			
		//booActivaImpresionAnulacion = true;
		
		return booActivaImpresionAnulacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo despliegueInfoCelda
  	 * 		   Metodo utilizado para desplegar el valor interno de cada
  	 * 		   celda visible de tabla
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private void despliegueInfoCelda()throws Exception{
		
		int intColumnaSeleccionada;
		int intFilaSeleccionada;
		Object objValorCelda;
		
		intFilaSeleccionada = this.castfrmHistorialAutorizacion().getTblAutorizaciones().getSelectedRow();
		intColumnaSeleccionada = this.castfrmHistorialAutorizacion().getTblAutorizaciones().getSelectedColumn();
		
		objValorCelda = this.castfrmHistorialAutorizacion().getTblAutorizaciones().getValueAt(intFilaSeleccionada, 
				  																  			  intColumnaSeleccionada);
		this.mostrarInfoOtrasColumnas(objValorCelda);
		
	}

	/**
     * ****************************************************************
     * @metodo mostrarInfoOtrasColumnas
     * 		   metodo para mostrar la informacion recibida en el 
     * 		   parametro, se aplica formato de presentacion
     * @param  pObjValorCelda
     * 		   valor de la celda clickeada sobre la grilla
     * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void mostrarInfoOtrasColumnas(Object pObjValorCelda) throws Exception{
		
		String strValorMostrar = null;
		
		if (pObjValorCelda != null){
			
			if(pObjValorCelda instanceof Number){
				
				strValorMostrar = UtilidadGiros.getInstancia().formatoPresentacionNumero(pObjValorCelda);
				
			}else{
				
				strValorMostrar = pObjValorCelda.toString();
			}
			
			if(strValorMostrar != null && 
					!strValorMostrar.isEmpty()){
			
				EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
														   EnumClasesMensaje.INFORMACION, 
														   null, 
														   "{1}", 
														   strValorMostrar);
			}
		}			
	}
	
	/** 
	 * ********************************************************************
	 * @method 	obtenerFacturaGiro
	 * 		   	Metodo que permite generar y obtener la factura seleccionada
	 * 			para realizar una operacion de interes en particular 
	 * @return	FacturaGiro
	 * 			Objeto factura seleccionado para operar
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	4/05/2017
	 * *********************************************************************
	 */
	private FacturaGiro obtenerFacturaGiro	()	
			throws Exception
	{
		FacturaGiro objFacturaGiro;
		FacturaGiro objFacturaSeguro;
		boolean booValidaZona = false;
		String strValidaEstadoGiro = "2";
		String strTipoGiro = "1";
		String strProducto = "1";
		
		objFacturaGiro	=	GiroVistaLogica.getInstance().consultaGiroPorReferencia	(	super.getObjUsuario(),
																						this.strReferencia,
																						booValidaZona,
																						strValidaEstadoGiro,
																						strTipoGiro,
																						strProducto
																					);
		objFacturaGiro.getObjNota().setStrDescripcion(this.objAutorizacion.getNotas());
		
		if	(objFacturaGiro.isIncluyeSeguro())
		{
			strProducto	=	UtilParametrosSistema.getInstance().consultar(EnumParametrosSistema.COD_PRODUCTO_SEGURO_SMS).getValor();
			objFacturaSeguro	=	GiroVistaLogica.getInstance().consultaGiroPorReferencia	(	super.getObjUsuario(),
																								objFacturaGiro.getFacturaSeguro().getReferenciaControl(),
																								booValidaZona,
																								strValidaEstadoGiro,
																								strTipoGiro,
																								strProducto
																							);
			if	(		objFacturaSeguro.getEstado()	!=	null	
					&&	!objFacturaSeguro.getEstado().getId().equals(EnumParametrosApp.COD_DAT_ENT_ESGI_ANULADO.getValorPropiedad())
				)
			{
				objFacturaGiro.setIncluyeSeguro(false);
				objFacturaGiro.setFacturaSeguro(null);
			}
		}
		
		GiroVistaLogica.getInstance().consultarUltimaActualizacionGiro(super.getObjUsuario(),
				   													   objFacturaGiro);
		
		return objFacturaGiro;
	}
	
	/** 
	 * ********************************************************************
	 * @method	verificarAnulacionEmpresa
	 * 		   	Metodo que permite verificar si la solicitud de anulacion 
	 * 			autorizada para la transaccion seleccionada ya produjo la 
	 * 			anulacion del lado de la empresa y en caso que no realizarla
	 * @param 	pObjFacturaGiro
	 * 			Factura seleccionada que representa una solicitud de anulacion
	 * 			autorizada y que se verificara si ya se produjo la anulacion
	 * 			del movimiento en los sistemas de la empresa
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author 	hector.cuenca
	 * @date   	4/05/2017
	 * *********************************************************************
	 */
	private void verificarAnulacionEmpresa	(	FacturaGiro pObjFacturaGiro	)	
			throws Exception
	{
		GiroVistaLogica.getInstance().realizarAnulacionGiro	(	super.getObjUsuario(), 
																pObjFacturaGiro,
																this.objAutorizacion
															);
	}
	
	/**
  	 * ****************************************************************
  	 * @metodo 	generarImpresion
  	 * 		   	metodo encargado de solicitar la ejecucion de la 
  	 * 		   	impresion de un tipo de solicitud
  	 * @param	pObjFacturaGiro
  	 * 			Objeto factura recopilado para realizar la impresion
  	 * @param  	pEnmImpresion
  	 * 		   	Parametro de sistema que contiene el nombre del formato 
  	 * 		   	de impresion a ejecutar 
  	 * @return 	boolean
  	 * 		   	bandera que permite identificar si el proceso de 
  	 *         	impresion fue llevado a cabo correctamente
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor  	Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	private boolean generarImpresion(	FacturaGiro pObjFacturaGiro,
										EnumImpresiones pEnmImpresion
									)
											throws Exception
	{
	
		boolean booImprimio;
		
		if	(	EnumMensajes.CONFIRMAR_IMPRESION_COMPROBANTE.desplegarMensaje	(	super.getFrmForma(), 
		  	 	                                                             	 	EnumClasesMensaje.CONFIRMACION
		  	 	                                                             	).isOpcion()
			)
		{
			try{
				
				booImprimio = pEnmImpresion.ejecutarImpresion(super.getFrmForma(), 
															  false,
															  pObjFacturaGiro,
															  super.getObjUsuario());
			}catch(Exception e){
				
				super.controlExcepcion(e);
				booImprimio = false;
			}
			
		}	else	{
			
			booImprimio	=	true;
		}
		
		return booImprimio;
	}
	
	/**
  	 * ****************************************************************.
  	 * @throws  Exception
  	 * @metodo  castfrmHistorialAutorizacion
  	 * 			Metodo estandar para formatear el tipo de dato general 
  	 * 			a un tipo especifico ("Casteo"), del atributo 
  	 * 			super.getFrmForma()
  	 * @return  FormaHistorialAutorizacion, valor especifico recuperado
  	 * @autor   Roberth Martinez Vargas
  	 * ****************************************************************
  	 */
	public FormaHistorialAutorizacion castfrmHistorialAutorizacion()throws Exception{
		return (FormaHistorialAutorizacion)super.getFrmForma();
	}

}
