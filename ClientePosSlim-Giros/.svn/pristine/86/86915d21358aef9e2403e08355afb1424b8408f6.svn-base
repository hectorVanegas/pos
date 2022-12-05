package co.com.codesa.clienteposslimgiros.formas.ayuda;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumAyudas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumOperacionesAyuda;
import co.com.codesa.clienteposslimgiros.eventos.ayuda.EventoFormaAyuda;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 08-ene-2016
 * @Clase FormaAyuda 
 * 		  Clase que genera la forma (GUI) para el despliegue de
 *        ayudas
 * @copyright: Copyright 1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaAyuda extends FormaGenerica{
	
	private static final long serialVersionUID = 1L;

	/**
	 * @variable scpPresentacion 
	 * 			 Seccion desplazable sobre la cual se presentan las ayudas 
	 * 			 referentes a una operacion 
	 **/
	private JScrollPane scpPresentacion;
	
	/**
	 * @variable scpOperaciones 
	 * 			 Seccion desplazable sobre la cual se colocan a disposicion
	 * 			 las operaciones referentes a una funcionalidad 
	 **/
	private JScrollPane scpOperaciones;
	
	/**
	 * @variable pnlOperaciones 
	 * 			 Seccion que almacena la disposicion de las operaciones 
	 * 			 referentes a una funcionalidad  
	 **/
	private SeccionUtil pnlOperaciones;
	
	/**
	 * @variable pnlAyudaVacia 
	 * 			 Seccion que representa una ayuda sin diligenciar (vacia o 
	 * 			 nula)  
	 **/
	private SeccionUtil pnlAyudaVacia;
	
	/**
	 * @variable lstOperaciones 
	 * 			 Lista de las operaciones referentes a una funcionalidad
	 **/
	private JList lstOperaciones;
	
	/**
	 * @variable btnAtras 
	 * 			 Boton para retroceder sobre las ayudas presentadas
	 **/
	private BotonUtil btnAtras;
	
	/**
	 * @variable btnAdelante 
	 * 			 Boton para avanzar sobre las ayudas presentadas
	 **/
	private BotonUtil btnAdelante;
	
	/**
	 * @variable lblMensajeAyudaVacia 
	 * 			 Etiqueta que representa el mensaje indicando que la ayuda
	 * 			 a mostrar no fue recibida correctamente
	 **/
	private EtiquetaUtil lblMensajeAyudaVacia;
	
	/**
	 * @variable lblImagenAdvertencia 
	 * 			 Etiqueta que contiene la imagen de advertencia, para ser 
	 * 			 adicionada cuando se detecta una ayuda recibida de manera 
	 * 			 irregular
	 **/
	private EtiquetaUtil lblImagenAdvertencia;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaAyuda
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pStrNombreFuncionalidad
  	 * 		  Nombre de la funcionalidad que despliega el modulo de ayudas
  	 * @param pEnmAyuda
  	 * 		  Constante de enumeracion de ayuda, que contiene toda la 
  	 * 		  parametrizacion y administracion necesaria para el despliegue
  	 * 		  de las ayudas relacionadas con la funcionalidad
  	 * @param pEnmOperacionSeleccionada
  	 * 		  Constante de enumeracion que simboliza la operacion por 
  	 * 		  defecto de interes, que debe aparecer seleccionada
  	 * @param pIntIdSeccionXDefecto
  	 * 		  Identificador de la seccion de ayuda referente a la operacion
  	 * 		  seleccionada, que debera aparecer al cargar la funcionalidad 
  	 * 		  de ayudas
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaAyuda(FormaGenerica pFrmPadre,
					  boolean pBooModal,
					  String pStrNombreFuncionalidad,
					  EnumAyudas pEnmAyuda,
					  EnumOperacionesAyuda pEnmOperacionSeleccionada,
					  Integer pIntIdSeccionXDefecto) throws Exception {
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaAyuda(this,
												  pEnmAyuda,
												  pEnmOperacionSeleccionada,
												  pIntIdSeccionXDefecto));
		
		this.inicializarForma(pStrNombreFuncionalidad);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaAyuda
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pStrNombreFuncionalidad
  	 * 		  Nombre de la funcionalidad que despliega el modulo de ayudas
  	 * @param pEnmAyuda
  	 * 		  Constante de enumeracion de ayuda, que contiene toda la 
  	 * 		  parametrizacion y administracion necesaria para el despliegue
  	 * 		  de las ayudas relacionadas con la funcionalidad
  	 * @param pEnmOperacionSeleccionada
  	 * 		  Constante de enumeracion que simboliza la operacion por 
  	 * 		  defecto de interes, que debe aparecer seleccionada
  	 * @param pIntIdSeccionXDefecto
  	 * 		  Identificador de la seccion de ayuda referente a la operacion
  	 * 		  seleccionada, que debera aparecer al cargar la funcionalidad 
  	 * 		  de ayudas
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaAyuda(JFrame pFrmPadre,
					  boolean pBooModal,
					  String pStrNombreFuncionalidad,
					  EnumAyudas pEnmAyuda,
					  EnumOperacionesAyuda pEnmOperacionSeleccionada,
					  Integer pIntIdSeccionXDefecto) throws Exception {
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaAyuda(this,
												  pEnmAyuda,
												  pEnmOperacionSeleccionada,
												  pIntIdSeccionXDefecto));
		
		this.inicializarForma(pStrNombreFuncionalidad);
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_AYU_VENTANA,
							 (String)pArrObjParametrosForma[0]);
		
		super.setAnchoForma(EnumDimensionesComponentes.GUI_AYU_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_AYU_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlEncabezado = null;
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_CUERPO,
																"pnlCuerpo",
	  		  	  												null,
	  		  	  												null,
	  		  	  												null);
		pnlCuerpo.add(this.iniciarPropPnlOperaciones());
		pnlCuerpo.add(this.iniciarPropScpPresentacion());
		pnlCuerpo.add(this.iniciarPropBtnAtras());
		pnlCuerpo.add(this.iniciarPropBtnAdelante());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		return null;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpPresentacion
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpPresentacion
  	 * @return JScrollPane 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpPresentacion() throws Exception{
		
		if(this.scpPresentacion==null){
			
			this.scpPresentacion = UtilComponentesGUI.getInstance().crearScroll("scpPresentacion", 
																				EnumDimensionesComponentes.SCP_AYU_PRESENTACION,
																				BorderFactory.createEmptyBorder());
		}
		
		return this.scpPresentacion;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropScpOperaciones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   scpOperaciones
  	 * @return JScrollPane 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JScrollPane iniciarPropScpOperaciones() throws Exception{
		
		if(this.scpOperaciones==null){
			
			this.scpOperaciones = UtilComponentesGUI.getInstance().crearScroll("scpOperaciones", 
																			   EnumDimensionesComponentes.SCP_AYU_OPERACIONES,
																			   BorderFactory.createEmptyBorder());
			
			this.scpOperaciones.setViewportView(this.iniciarPropLstOperaciones());
		}
		
		return this.scpOperaciones;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlOperaciones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlOperaciones
  	 * @return SeccionUtil 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public SeccionUtil iniciarPropPnlOperaciones() throws Exception{
		
		if(this.pnlOperaciones==null){
			
			this.pnlOperaciones = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_OPERACIONES,
																			  "pnlOperaciones",
																  		  	  null,
																  		  	  EnumEtiquetas.TTL_AYU_PNL_OPERACIONES,
																  		  	  null);
			this.pnlOperaciones.add(this.iniciarPropScpOperaciones());
		}
		
		return this.pnlOperaciones;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlAyudaVacia
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlAyudaVacia
  	 * @return SeccionUtil 
  	 * 		   seccion de cuerpo gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public SeccionUtil iniciarPropPnlAyudaVacia() throws Exception{
		
		if(this.pnlAyudaVacia==null){
			
			this.pnlAyudaVacia = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_AYU_AYUDA_VACIA,
																			 "pnlAyudaVacia",
																  		  	 BorderFactory.createEmptyBorder(),
																  		  	 null,
																  		  	 null);
			this.pnlAyudaVacia.add(this.iniciarPropLblMensajeAyudaVacia());
			this.pnlAyudaVacia.add(this.iniciarPropLblImagenAdvertencia());
		}
		
		return this.pnlAyudaVacia;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLstOperaciones
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lstOperaciones
  	 * @return JList 
  	 * 		   Lista gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JList iniciarPropLstOperaciones() throws Exception{
		
		if(this.lstOperaciones==null){
			
			this.lstOperaciones = UtilComponentesGUI.getInstance().crearList("lstOperaciones", 
																	  	  	 true, 
																	  	  	 true, 
																	  	  	 ListSelectionModel.SINGLE_SELECTION, 
																	  	  	 super.getEventoForma());
		}
		
		return this.lstOperaciones;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnAtras
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnAtras
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnAtras() throws Exception{
		
		if(this.btnAtras==null){
			
			this.btnAtras = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AYU_ATRAS,
																	  	"btnAtras",
																	  	EnumEtiquetas.BTN_AYU_ATRAS,
																	  	true,
																	  	true,
																	  	super.getEventoForma(),
																	  	null);
		}
		
		return this.btnAtras;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropBtnAdelante
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   btnAdelante
  	 * @return BotonUtil
  	 * 		   boton de accion gestionado 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public BotonUtil iniciarPropBtnAdelante() throws Exception{
		
		if(this.btnAdelante==null){
			
			this.btnAdelante = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_AYU_ADELANTE,
																	  	   "btnAdelante",
																	  	   EnumEtiquetas.BTN_AYU_ADELANTE,
																	  	   true,
																	  	   true,
																	  	   super.getEventoForma(),
																	  	   null);
		}
		
		return this.btnAdelante;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblMensajeAyudaVacia 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblMensajeAyudaVacia
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblMensajeAyudaVacia() throws Exception {

		if (this.lblMensajeAyudaVacia == null) {

			this.lblMensajeAyudaVacia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_MENSAJE_AYUDA_VACIA, 
																					"lblMensajeAyudaVacia",
																					EnumEtiquetas.LBL_AYU_MENSAJE_AYUDA_VACIA,
																					false,
																					null, 
																					true);
			
			this.lblMensajeAyudaVacia.setFont(this.lblMensajeAyudaVacia.getFont().deriveFont(Font.BOLD,30));
			this.lblMensajeAyudaVacia.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblMensajeAyudaVacia;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo iniciarPropLblImagenAdvertencia 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblImagenAdvertencia
	 * @return EtiquetaUtil 
	 * 		   etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblImagenAdvertencia() throws Exception {

		if (this.lblImagenAdvertencia == null) {

			this.lblImagenAdvertencia = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_AYU_IMAGEN_ADVERTENCIA, 
																					"lblImagenAdvertencia",
																					null,
																					false,
																					EnumImagenes.ALE_ADVERTENCIA.obtenerIcono(),
																					true);
		}
		
		return this.lblImagenAdvertencia;
	}
	
	public JScrollPane getScpPresentacion() {
		return scpPresentacion;
	}

	public void setScpPresentacion(JScrollPane scpPresentacion) {
		this.scpPresentacion = scpPresentacion;
	}

	public JScrollPane getScpOperaciones() {
		return scpOperaciones;
	}

	public void setScpOperaciones(JScrollPane scpOperaciones) {
		this.scpOperaciones = scpOperaciones;
	}

	public SeccionUtil getPnlOperaciones() {
		return pnlOperaciones;
	}

	public void setPnlOperaciones(SeccionUtil pnlOperaciones) {
		this.pnlOperaciones = pnlOperaciones;
	}

	public JList getLstOperaciones() {
		return lstOperaciones;
	}

	public void setLstOperaciones(JList lstOperaciones) {
		this.lstOperaciones = lstOperaciones;
	}

	public BotonUtil getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(BotonUtil btnAtras) {
		this.btnAtras = btnAtras;
	}

	public BotonUtil getBtnAdelante() {
		return btnAdelante;
	}

	public void setBtnAdelante(BotonUtil btnAdelante) {
		this.btnAdelante = btnAdelante;
	}

	public SeccionUtil getPnlAyudaVacia() {
		return pnlAyudaVacia;
	}

	public void setPnlAyudaVacia(SeccionUtil pnlAyudaVacia) {
		this.pnlAyudaVacia = pnlAyudaVacia;
	}

	public static void main(String[] args) {
		
		FormaGenerica jframe = null;
		
		try{
	        
			//EnumOperacionesAyuda.SUPER_COMBO.filtrarSeccionesXId(0,1,2);
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaAyuda.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			new FormaAyuda(jframe,
						   true,
						   "Facturacion documentos",
						   EnumAyudas.SUPER_COMBO,
						   EnumOperacionesAyuda.SUPER_COMBO,
						   null);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
		}
	}
	
}
