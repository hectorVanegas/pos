package co.com.codesa.clienteposslimgiros.formas.terceros;


import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.terceros.EventoFormaPropiedadesPeps;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelPropiedadesPeps;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.DatoEntidad;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroPeps;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

/**
 * 
 * ********************************************************************
 * @class	FormaPropiedadesPeps
 *		 	Forma encargada de visualizar las preguntas para los terceros PEPS
 * @author	stiven.garcia
 * @date  	26/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPropiedadesPeps extends FormaGenerica {
	
	/**
	 * @variable: pnlPropiedadesPeps
	 *            Panel encargado de pintar la grilla de propiedades peps
	 */
	private FormaPanelPropiedadesPeps pnlPropiedadesPeps;
	
	/**
	 * @variable: txtPreguntaPeps
	 *            Texto con pregunta que se realiza al tercero cliente
	 */
	private AreaTextoUtil txtPreguntaPeps;
	
	/**
	 * @variable: objTerceroPeps
	 *            Objeto TerceroPeps correspondiente a la funcionalidad PEPS
	 */
	private TerceroPeps objTerceroPeps;
	
	/**
	 * @variable: objUsuario
	 *            Objeto Usuario cajero que efectua la peticion
	 */
	private Usuario objUsuario;
	
	/**
	 * @variable: btnAceptar
	 */
	private BotonUtil btnAceptar;
	
	/**
	 * @variable: btnCancelar
	 */
	private BotonUtil btnCancelar;
	
	/**
	 * 
	 */
	private boolean booRealizoProcesoTerceroPeps;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * 
	 * ********************************************************************
	 * @method	FormaPropiedadesPeps
	 * 		  	Constructor de la forma Propiedades PEPS
	 * @param pFrmPadre
	 * 			Forma principal que invoca el llamado de la forma
	 * @param pBooModal
	 * 			Variable modal
	 * @param pObjUsuario
	 * 			Usuario cajero que realiza la peticion
	 * @param pObjTercero
	 * 			Tercero al cual se le realiza el proceso de PEPS
	 * @param pBooProcesarPeticion
	 * 			Bandera que indica si se debe enviarse la trama de registrar Peps o no. 
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public FormaPropiedadesPeps(FormaGenerica pFrmPadre,
					 			boolean pBooModal,
					 			Usuario pObjUsuario,
					 			Tercero pObjTercero,
					 			boolean pBooProcesarPeticion) throws Exception {
			
		super(pFrmPadre, pBooModal);

		super.setEventoForma(new EventoFormaPropiedadesPeps(this,
															pObjTercero,
															pBooProcesarPeticion));
		this.iniciarTituloForma(pObjTercero);
		
		super.setTituloForma(EnumEtiquetas.TTL_PPS_FORMA_PROPIEDADES_PEPS);		
		
		this.setObjUsuario(pObjUsuario);
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setAnchoForma(EnumDimensionesComponentes.GUI_PPS_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_PPS_VENTANA.getAlto());
				
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
						  		EnumBotonesEncabezado.BTNVOLVER
						  		);
		
		super.iniciar(pArrObjParametrosForma);

	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarPropPnlPropiedadesPeps
	 * 		  	Inicia el panel que contiene la grilla de propiedades PEPS
	 * @return
	 * 			Panel con grilla de propiedades peps consultada en base de datos
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private FormaPanelPropiedadesPeps iniciarPropPnlPropiedadesPeps() throws Exception{
		
		return getPnlPropiedadesPeps();
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarPropAreaTextoPreguntaPeps
	 * 		  	Metodo encargado de incializar el area de texto que contiene 
	 * 			la pregunta a realizar al Tercero presente en una de las transacciones
	 * 			core del sistema
	 * @return
	 * 			AreaTexto con la pregunta formulada tomada desde una etiqueta del sistema
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private AreaTextoUtil iniciarPropAreaTextoPreguntaPeps() throws Exception {
		
		if( txtPreguntaPeps == null ) {
			
			txtPreguntaPeps =  UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.LBL_PPS_PREGUNTA_PEPS,
																			  "areaTextoPregunta", 
																			  EnumEtiquetas.LBL_PPS_PREGUNTA_PEPS.getValor(false), 
																			  false, 
																			  false, 
																			  true,																  
																			  null,
																			  EnumEtiquetas.LBL_PPS_PREGUNTA_PEPS);
		}
		
		return txtPreguntaPeps;
		
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	iniciarTituloForma
	 * 		  	Metodo encargado de establecer el titulo de la forma
	 * @param pObjTercero
	 * 			Objeto tercero al cual se le realiza el proceso PEPS
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	private void iniciarTituloForma( Tercero pObjTercero ) throws Exception {
		
		EnumEtiquetas.TTL_PPS_FORMA_PROPIEDADES_PEPS.setProcesado(false);

		String strNombres   = "";
		String strApellido1 = "";
		String strApellido2 = "";
		
		if( pObjTercero.getNombres() != null) {
			strNombres = pObjTercero.getNombres().toUpperCase();
		}
		
		if( pObjTercero.getApellido1() != null ){
			strApellido1 = pObjTercero.getApellido1().toUpperCase();
		}
		
		if( pObjTercero.getApellido2() != null ) {
			strApellido2 = pObjTercero.getApellido2().toUpperCase();
		}		
		
		String strTitulo = EnumEtiquetas.TTL_PPS_FORMA_PROPIEDADES_PEPS.toString() + " - " + 
						   pObjTercero.getDescripcion() 						   + " " +
						   pObjTercero.getIdentificacion() 						   + " " + 
						   strNombres 											   + " " +  
						   strApellido1 										   + " " + 
						   strApellido2;
				
		EnumEtiquetas.TTL_PPS_FORMA_PROPIEDADES_PEPS.setValor( strTitulo );
	}
	

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.JPN_PPS_VENTANA,
																"pnlCuerpo",
																null,
																null,
																null);
		pnlCuerpo.add(this.iniciarPropPnlPropiedadesPeps());
		pnlCuerpo.add(this.iniciarPropAreaTextoPreguntaPeps());
		pnlCuerpo.add(this.getBtnAceptar());
		pnlCuerpo.add(this.getBtnCancelar());
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}	
	
	/**
	 * 
	 * ********************************************************************
	 * @method	getPnlPropiedadesPeps
	 * 		  	Metodo get del panel propiedadesPeps
	 * @return
	 * 			PanelPropiedadesPeps
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public FormaPanelPropiedadesPeps getPnlPropiedadesPeps() throws Exception{
		
		if(pnlPropiedadesPeps == null) {
			
			pnlPropiedadesPeps = new FormaPanelPropiedadesPeps(this,
															   EnumDimensionesComponentes.JPN_PPS_PEPS_PANEL_CUERPO, 
															   "pnlPropiedadesPeps"
															   );
			
		}
		
		return pnlPropiedadesPeps;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	getBtnAceptar
	 * 		  	[TODO - DOC]: Descripcion del metodo, cual es su uso, la 
	 * 		  	necesidad y su aporte y como se integra con la funcionalidad
	 * @return  Objeto BotonUtil 
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	30/07/2018
	 * *********************************************************************
	 */
	public BotonUtil getBtnAceptar() throws Exception {
		if ( btnAceptar == null ) {
			
			btnAceptar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PPS_ACEPTAR,
																	 "bnt_pps_aceptar", 
																	 EnumEtiquetas.BTN_PPS_ACEPTAR, 
																	 true, 
																	 true, 
																	 super.getEventoForma(), 
																	 null
																	 );
		}
		
		return btnAceptar;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	getBtnCancelar
	 * 		  	Metodo get del boton cancelar
	 * @return
	 * 			Bonton Util Cancelar
	 * @throws Exception
	 *			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
	 * @author	stiven.garcia
	 * @date	30/07/2018
	 * *********************************************************************
	 */
	public BotonUtil getBtnCancelar() throws Exception {
		if ( btnCancelar == null ) {
			
			btnCancelar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_PPS_CANCELAR,
																	 "bnt_pps_cancelar", 
																	 EnumEtiquetas.BTN_PPS_CANCELAR, 
																	 true, 
																	 true, 
																	 super.getEventoForma(), 
																	 null
																	 );
		}
		
		return btnCancelar;
	}
	
	/**
	 * 
	 * ********************************************************************
	 * @method	setPnlPropiedadesPeps
	 * 		  	metodo set del atributo pnlPropiedadesPeps
	 * @param pnlPropiedadesPeps
	 * 			Panel con las preguntas correspondientes a PEPS
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public void setPnlPropiedadesPeps(FormaPanelPropiedadesPeps pnlPropiedadesPeps) {
		this.pnlPropiedadesPeps = pnlPropiedadesPeps;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	getTxtPreguntaPeps
	 * 		  	Metodo get del componente areaTexto
	 * @return
	 * 			componente areaTexto con la pregunta formulada
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public AreaTextoUtil getTxtPreguntaPeps() {
		return txtPreguntaPeps;
	}

	/**
	 * 
	 * ********************************************************************
	 * @method	setTxtPreguntaPeps
	 * 		  	Metodo set del componente areaTextoUtil
	 * @param txtPreguntaPeps
	 * 			componente areaTexto pregunta peps
	 * @author	stiven.garcia
	 * @date	26/04/2018
	 * *********************************************************************
	 */
	public void setTxtPreguntaPeps(AreaTextoUtil txtPreguntaPeps) {
		this.txtPreguntaPeps = txtPreguntaPeps;
	}	

	public Usuario getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(Usuario objUsuario) {
		this.objUsuario = objUsuario;
	}

	public TerceroPeps getObjTerceroPeps() {
		
		if ( this.objTerceroPeps == null ) {
			this.objTerceroPeps = new TerceroPeps();					
		}
		
		return objTerceroPeps;
	}

	public void setObjTerceroPeps(TerceroPeps objTerceroPeps) {
		this.objTerceroPeps = objTerceroPeps;
	}	

	public boolean isBooRealizoProcesoTerceroPeps() {
		return this.booRealizoProcesoTerceroPeps;
	}

	public void setBooRealizoProcesoTerceroPeps(
			boolean pBooRealizoProcesoTerceroPeps) {
		this.booRealizoProcesoTerceroPeps = pBooRealizoProcesoTerceroPeps;
	}

	public static void main(String[] args) {
		
		DatoEntidad objDatEntTipoIdentificacion;
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null, true, EnumDesplegarFormaConEventos.SI);
			
			InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().setId("1");
			
			objDatEntTipoIdentificacion = new DatoEntidad("3");
			
			Tercero tercero = new Tercero(objDatEntTipoIdentificacion,"45");

			new FormaPropiedadesPeps(null, true, InformacionSessionGiros.getInstance().getObjUsuario(),tercero,false);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
