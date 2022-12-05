package co.com.codesa.clienteposslimgiros.formas.sesion;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.sesion.EventoFormaAutenticacion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaClaveUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCajaTextoProtegida;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslim.logger.Logger;


/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 09-mar-2015
 * @clase FormaAutenticacion  
 * 		  Clase que genera la forma (GUI) para autenticacion al modulo 
 * 		  de giros (SuperGiros)
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaAutenticacion extends FormaGenerica{

	private static final long serialVersionUID = -1053695296887806591L;
	
	/**
	 * @variable lblUsuario 
	 * 		     label para etiquetar el campo de ingreso de usuario
	 **/
	private EtiquetaUtil lblUsuario;
	
	/**
	 * @variable lblContrasena 
	 * 			 label para etiquetar el campo de ingreso de contrasena
	 **/
	private EtiquetaUtil lblContrasena;
	
	/**
	 * @variable lblEtiquetaProgreso
	 * 		 	 label para etiquetar a manera descriptiva el progreso 
	 * 			 de la operacion de autenticacion
	 **/
	private EtiquetaUtil lblEtiquetaProgreso;
	
	/**
	 * @variable lblPorcentajeBarraProgreso 
	 * 			 label para etiquetar el porcentaje de progreso que se 
	 * 			 lleva a cabo para terminar la autenticacion
	 **/
	private EtiquetaUtil lblPorcentajeBarraProgreso;
	
	/**
	 * @variable lblImagen
	 * 			 label para adicionar una imagen representativa del 
	 * 			 modulo de giros
	 **/
	private EtiquetaUtil lblImagen;
	
	/**
	 * @variable txtUsuario
	 * 			 caja de texto para el ingreso de usuario
	 **/
	private CajaTextoUtil txtUsuario;
	
	/**
	 * @variable pfiContrasena
	 * 			 caja de texto protegida para el ingreso de la contrasena
	 **/
	private FormaPanelCajaTextoProtegida pfiContrasena;
	
	/**
	 * @variable btnIngresar
	 * 			 boton para solicitar el ingreso
	 **/
	private BotonUtil btnIngresar;
	
	/**
	 * @variable btnSalir
	 * 			 boton para solicitar la salida
	 **/
	private BotonUtil btnSalir;
	
	/**
	 * @variable pgbBarraProgreso
	 * 			 barra de progreso para observar comportamiento de la 
	 * 			 peticion de autenticacion 
	 **/
	private JProgressBar pgbBarraProgreso;

	/**
  	 * ****************************************************************.
  	 * @metodo FormaAutenticacion
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmVentana
  	 * 		  ventana sobre la cual se posicionara la forma de 
  	 * 		  autenticacion
  	 * @param pBooVisible
  	 * 		  bandera para visualizar o no la forma de autenticacion, 
  	 * 		  importante para realizar el inicio de sesion interno 
  	 * 		  (transparente y automaticamente)
  	 * @param pStrUsuario
  	 * 		  tipo de credencial para el proceso de autenticacion enviado 
  	 * 		  automaticamente desde InformacionSesionGiros 
  	 * @param pStrContrasena
  	 * 		  tipo de credencial para el proceso de autenticacion enviado 
  	 * 		  automaticamente desde InformacionSesionGiros
  	 * @param pBooDesplegarProducto
  	 * 		  Bandera que permite identificar si el proceso de autenticacion
  	 * 		  se ejecuta para exponer el producto de giros o se realiza por
  	 * 		  otros intereses, que no ameritan el despligue del producto de
  	 * 		  giros 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaAutenticacion(JFrame pFrmVentana, 
					  		  boolean pBooVisible,
					  		  String pStrUsuario,
					  		  String pStrContrasena,
					  		  boolean pBooDesplegarProducto) throws Exception{
		super(pFrmVentana,
			  false);
		
		super.setEventoForma(new EventoFormaAutenticacion(this,
														  pBooDesplegarProducto));
		
		this.inicializarForma(pStrUsuario,
							  pStrContrasena);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma 
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la forma
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * 		  [0]: bandera modal para finalizar la inicializacion de la 
  	 * 			   forma en aspectos modales. Estrategia para permitir
  	 * 			   ejecutar el inicio de valores posteriores a la 
  	 * 			   construccion de la forma
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_AUT_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_AUT_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_AUT_VENTANA.getAlto());
		
		super.setBooVisible(false);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) throws Exception {
		return null;
	}
	
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AUT_CUERPO,
																"pnlCuerpo",
														 	 	BorderFactory.createEmptyBorder(),
														 	 	null,
														 	 	null);
		pnlCuerpo.add(this.iniciarPropLblUsuario());
		pnlCuerpo.add(this.iniciarPropTxtUsuario());
		pnlCuerpo.add(this.iniciarPropLblContrasena());
		pnlCuerpo.add(this.iniciarPropPfiContrasena());
		pnlCuerpo.add(this.iniciarPropBtnIngresar());
		pnlCuerpo.add(this.iniciarPropBtnSalir());
		pnlCuerpo.add(this.iniciarPropPgbBarraProgreso());
		pnlCuerpo.add(this.iniciarPropLblPorcentajeBarraProgreso());
		pnlCuerpo.add(this.iniciarPropLblEtiquetaProgreso());
		pnlCuerpo.add(this.iniciarPropLblImagen());
		
		return pnlCuerpo;
	}
	
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		return null;
		/*
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AUT_PIE_PAGINA,
																   "pnlPiePagina",
	 															   BorderFactory.createEmptyBorder(),
	 															   null,
	 															   null);
		
		pnlPiePagina.add(InformacionSessionGiros.getInstance().iniciarPropLblVersion(EnumDimensionesComponentes.LBL_AUT_VERSION));
		
		return pnlPiePagina;
		*/
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtUsuario
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtUsuario
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtUsuario()throws Exception {
		
		if(this.txtUsuario==null){
			
			this.txtUsuario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_AUT_USUARIO, 
																	 	  	  "txtUsuario", 
																	 	  	  "", 
																	 	  	  true, 
																	 	  	  true, 
																	 	  	  true,
																	 	  	  super.getEventoForma(),
																	 	  	  null);
		}
		
		return this.txtUsuario;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPfiContrasena
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiContrasena
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiContrasena()throws Exception {
		
		if(this.pfiContrasena==null){
			
			this.pfiContrasena = new FormaPanelCajaTextoProtegida(this,
					  											  EnumDimensionesComponentes.PFI_AUT_CONTRASENA,
					  											  "pfiContrasena",
					  											  EnumEtiquetas.LBL_AUT_CONTRASENA);
		}
		
		return this.pfiContrasena;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnIngresar
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnIngresar
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnIngresar() throws Exception{
		
		if(this.btnIngresar==null){
			
			this.btnIngresar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AUT_INGRESAR,
																	   	   "btnIngresar",
																	   	   EnumEtiquetas.BTN_AUT_INGRESAR,
																	   	   true,
																	   	   true,
																	   	   super.getEventoForma(),
																	   	   null);
		}
		
		return btnIngresar;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnSalir
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnSalir
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnSalir() throws Exception{
		
		if(this.btnSalir==null){
			
			this.btnSalir = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AUT_SALIR,
																		"btnSalir",
																		EnumEtiquetas.BTN_AUT_SALIR,
																		true,
																		true,
																		super.getEventoForma(),
																		null);
		}
		
		return btnSalir;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPgbBarraProgreso
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pgbBarraProgreso
  	 * @return JProgressBar
  	 * 		   barra de progreso gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JProgressBar iniciarPropPgbBarraProgreso() throws Exception{
		
		if(this.pgbBarraProgreso==null){
			
			this.pgbBarraProgreso = UtilComponentesGUI.getInstance().crearProgressBar(EnumDimensionesComponentes.PGB_AUT_BARRA_PROGRESO, 
																				  	  "pgbBarraProgreso", 
																				  	  0, 
																				  	  0, 
																				  	  100, 
																				  	  false);
		}
		
		return this.pgbBarraProgreso;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblEtiquetaProgreso
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblEtiquetaProgreso
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblEtiquetaProgreso() throws Exception{
		
		if(this.lblEtiquetaProgreso==null){
			
			this.lblEtiquetaProgreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AUT_ETIQUETA_PROGRESO, 
																			   	   "lblEtiquetaProgreso", 
																			   	   null,
																			   	   false,
																			   	   null,
																			   	   true);
			
			this.lblEtiquetaProgreso.setForeground(Color.blue);
			this.lblEtiquetaProgreso.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return lblEtiquetaProgreso;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblPorcentajeBarraProgreso
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblPorcentajeBarraProgreso
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblPorcentajeBarraProgreso() throws Exception{
		
		if(this.lblPorcentajeBarraProgreso==null){
			
			this.lblPorcentajeBarraProgreso = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AUT_PORCENTAJE_BARRA_PROGRESO, 
																					  	  "lblPorcentajeBarraProgreso", 
																					  	  null,
																					  	  false,
																					  	  null,
																					  	  true);
			
			this.lblPorcentajeBarraProgreso.setForeground(Color.blue);
			this.lblPorcentajeBarraProgreso.setHorizontalAlignment(EtiquetaUtil.CENTER);
		}
		
		return lblPorcentajeBarraProgreso;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblUsuario
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblUsuario
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblUsuario()throws Exception {
		
		if(this.lblUsuario==null){
			
			this.lblUsuario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AUT_USUARIO, 
																	  	  "lblUsuario", 
																	  	  EnumEtiquetas.LBL_AUT_USUARIO,
																	  	  true,
																	  	  null,
																	  	  true);
		}
		
		return lblUsuario;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblContrasena
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblContrasena
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblContrasena() throws Exception{
		
		if(this.lblContrasena==null){
			
			this.lblContrasena = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AUT_CONTRASENA, 
																	  	 	 "lblContrasena", 
																	  	 	 EnumEtiquetas.LBL_AUT_CONTRASENA,
																	  	 	 true,
																	  	 	 null,
																	  	 	 true);
		}
		
		return this.lblContrasena;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblImagen
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblImagen
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblImagen() throws Exception{
		
		if(this.lblImagen==null){
			
			this.lblImagen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AUT_IMAGEN, 
																	 	 "lblImagen", 
																	 	 null,
																	 	 false,
																	 	 EnumImagenes.APP_LOGO_SUPERGIROS.obtenerIcono(),
																	 	 true);
			
			this.lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblImagen;
	}

	public EtiquetaUtil getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(EtiquetaUtil lblUsuario) {
		this.lblUsuario = lblUsuario;
	}

	public EtiquetaUtil getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(EtiquetaUtil lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public EtiquetaUtil getLblEtiquetaProgreso() {
		return lblEtiquetaProgreso;
	}

	public void setLblEtiquetaProgreso(EtiquetaUtil lblEtiquetaProgreso) {
		this.lblEtiquetaProgreso = lblEtiquetaProgreso;
	}

	public EtiquetaUtil getLblPorcentajeBarraProgreso() {
		return lblPorcentajeBarraProgreso;
	}

	public void setLblPorcentajeBarraProgreso(EtiquetaUtil lblPorcentajeBarraProgreso) {
		this.lblPorcentajeBarraProgreso = lblPorcentajeBarraProgreso;
	}

	public EtiquetaUtil getLblImagen() {
		return lblImagen;
	}

	public void setLblImagen(EtiquetaUtil lblImagen) {
		this.lblImagen = lblImagen;
	}

	public CajaTextoUtil getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(CajaTextoUtil txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public CajaClaveUtil getPfiContrasena() {
		return pfiContrasena.getPfiCajaClave();
	}

	public void setPfiContrasena(FormaPanelCajaTextoProtegida pfiContrasena) {
		this.pfiContrasena = pfiContrasena;
	}

	public BotonUtil getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(BotonUtil btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public BotonUtil getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(BotonUtil btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JProgressBar getPgbBarraProgreso() {
		return pgbBarraProgreso;
	}

	public void setPgbBarraProgreso(JProgressBar pgbBarraProgreso) {
		this.pgbBarraProgreso = pgbBarraProgreso;
	}

	public static void main(String[] args) {
		
		try{
	        
			/*TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaAutenticacion.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);*/

			new FormaAutenticacion(null,
								   true,
								   null,
								   null,
								   true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
		
	}
		
}
