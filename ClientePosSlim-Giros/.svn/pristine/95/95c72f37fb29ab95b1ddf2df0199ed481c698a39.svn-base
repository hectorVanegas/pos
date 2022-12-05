package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.awt.Color;
import java.awt.Component;
import java.awt.FocusTraversalPolicy;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.enumeraciones.TeclasEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.foco.ControlFocosForma;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Usuario;

/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 07-mar-2015
 * @descripcion:Clase plantilla que permite crear todas las formas
 * de giros. se manejaran como Dialogos
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public  abstract class FormaGenerica extends JDialog{
	
	private static final long serialVersionUID = 7577402710981921510L;
	
	/**
	* @variable pnlCuerpoPlantilla 
	* 			corresponde al cuerpo de la plantilla general
	**/
	private JPanel pnlCuerpoPlantilla;
	
	/**
	* @variable pnlBarraHerramientas 
	* 			corresponde panel que contendra las opciones alojadas 
	* 			en la parte superior como barra de herramientas
	**/
	private JPanel pnlBarraHerramientas;
	
	/**
	* @variable pnlContenido 
	* 			corresponde al panel implementado por el Ing.Software 
	* 			que debera tener la estructura encabezado,cuerpo y pie 
	* 			de pagina.Este sera adicionado al cuerpo de la plantilla
	* 			general.
	**/
	private JPanel pnlContenido;
	
	/**
	* @variable pnlContenidoEncabezado 
	* 			seccion de encabezado diligenciada especificamente para la 
	* 			forma sobre el metodo inicializarEncabezado
	**/
	private JPanel pnlContenidoEncabezado;
	
	/**
	* @variable pnlContenidoCuerpo 
	* 			seccion de cuerpo diligenciada especificamente para la 
	* 			forma sobre el metodo inicializarCuerpo 
	**/
	private JPanel pnlContenidoCuerpo;
	
	/**
	* @variable pnlContenidoPiePagina 
	* 			seccion de pie de pagina diligenciada especificamente para la 
	* 			forma sobre el metodo inicializarPiePagina 
	**/
	private JPanel pnlContenidoPiePagina;
	
	private ControlFocosForma objControlFocosFormaPersonalizado;
	
	private FocusTraversalPolicy objControlFocosFormaOriginal;
	
	/**
	* @variable booModal 
	* 			bandera que permite identificar si la forma a construir 
	* 			debe ser modal de la forma padre o no (true,false)
	**/
	private boolean booModal;
	
	/**
	* @variable booConstruir 
	* 			bandera que permite identificar si la forma debe ser 
	* 			construida para despliegue o no, importante para 
	* 			funcionalidades que no poseen forma, sino que ejecutan
	* 			de inmediato una operacion, sin embargo no es sano 
	* 			saltarse la arquitectura para estos casos espaciales
	* 			por el contrario se adapta la arquitectura para soportar
	* 			estas situaciones
	**/
	private boolean booConstruir;
	
	private boolean booVisible;
	
	private boolean booDesaparecerVentanaPadre;
	
	/**
	* @variable eventoForma 
	* 			Corresponde a la clase que maneja los eventos de las formas. 
	* 			Esta debe ser modificada desde la forma que este implementando 
	* 			el Ing.Software
	**/
	private EventoAbstracto eventoForma;
	
	/**
	* @variable tituloForma 
	* 			Corresponde al titulo de la forma a implementar
	**/
	private EnumEtiquetas enmEtiTituloForma;
	
	/**
	* @variable anchoForma 
	* 			Corresponde al ancho que tendra la forma, el cual tendra un 
	* 			valor por defecto configurado sobre un parametro de aplicacion, 
	* 			pero que puede ser modificada por el Ing.software segun las 
	* 			necesidades.
	**/
	private int anchoForma;
	
	/**
	* @variable altoForma 
	* 			Corresponde al alto que tendra la forma, el cual tendra un 
	* 			valor por defecto configurado sobre un parametro de aplicacion, 
	* 			pero que puede ser modificada por el Ing.software segun las 
	* 			necesidades.
	**/
	private int altoForma;
	
	private Integer intAltoBarraHerramientas;
	
	/**
	* @variable arrEnmAcciones 
	* 			arreglo que contendra las acciones que se adicionaran al encabezado 
	* 			de la plantilla general.
	**/
	private EnumBotonesEncabezado[] arrEnmAcciones;
	
	private EnumBotonesEncabezado enmBotEncAccionSolicitada;
	
	private List<BotonUtil> lstBotonesMenu;
	
	/**
	 * @variable lstFormaGenerica
	 * 			 listado que almacenara las pantallas que van emergiendo en la app
	 */
	public static List<FormaGenerica> lstFormasGenericas;
	
	/**
	* @variable frmPadre 
	* 			forma padre de la cual se invoca el despliegue de esta forma
	**/
	private Window frmPadre;
	
	private boolean booAnularEventosXFocusLost;
	
	static{
		lstFormasGenericas = new ArrayList<FormaGenerica>();
	}
	
	
	/**
	* @variable strVersion 
	* 			muestra la version actual del producto giro
	**/
	public static String strVersion = "";
	
	public FormaGenerica(JFrame pFrmPadre, 
						 boolean pBooModal)throws Exception{
		
		super(pFrmPadre,
			  false);
		
		this.inicializarAtributos(pFrmPadre,
								  pBooModal,
								  true);
	}
	
	public FormaGenerica(JFrame pFrmPadre, 
			 			 boolean pBooModal,
			 			 boolean pBooConstruir)throws Exception{

		super(pFrmPadre,
			  false);

		this.inicializarAtributos(pFrmPadre,
					  			  pBooModal,
					  			  pBooConstruir);
	}
	
	public FormaGenerica(JDialog pFrmPadre, 
					 	 boolean pBooModal)throws Exception{
		
		super(pFrmPadre,
			  false);
		
		this.inicializarAtributos(pFrmPadre,
							      pBooModal,
							      true);
	}

	public FormaGenerica(JDialog pFrmPadre, 
			 			 boolean pBooModal,
			 			 boolean pBooConstruir)throws Exception{

		super(pFrmPadre,
			  false);	

		this.inicializarAtributos(pFrmPadre,
		  			  			  pBooModal,
		  			  			  pBooConstruir);
	}
	
	private void inicializarAtributos(Window pFrmPadre,
									  boolean pBooModal,
									  boolean pBooConstruir)throws Exception{
		this.booModal = pBooModal;
		this.booConstruir = pBooConstruir;
		this.frmPadre = pFrmPadre;
		
		this.altoForma = EnumDimensionesComponentes.GUI_FRM_GNR_FORMA.getAlto();
		this.anchoForma = EnumDimensionesComponentes.GUI_FRM_GNR_FORMA.getAncho();
		this.booVisible = true;
		this.setName(this.getClass().getSimpleName());
		this.objControlFocosFormaOriginal = this.getFocusTraversalPolicy();
	}
	
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciar
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param pArrObjParametrosForma 
  	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		  de la forma
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void iniciar(Object ...pArrObjParametrosForma) throws Exception{
		
		if(this.booConstruir){
			this.iniciarForma();
			this.inicializarContenido(pArrObjParametrosForma);
			this.pack();
		}
		
		this.iniciarValores(pArrObjParametrosForma);
		
		if(this.booDesaparecerVentanaPadre){
			
			if(this.frmPadre != null){
				
				this.frmPadre.setVisible(false);	
			}
		}
		
		if(this.booConstruir){
			this.setModal(this.booModal);
			this.setVisible(this.booVisible);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarValoresAnterior
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
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		boolean booDesplegarControlEventos;
		
		booDesplegarControlEventos = false;
		
		if(this.eventoForma != null){
		
			if(this.getClass().equals(TestPruebasInternas.CLASS_FORMA_GENERICA)){
				
				if(!EnumDesplegarFormaConEventos.NO.equals(TestPruebasInternas.DESPLEGAR_FORMA_CON_EVENTOS)){
			
					booDesplegarControlEventos = true;
				}
				
			}else{
				
				booDesplegarControlEventos = true;
			}
		}
		
		if(booDesplegarControlEventos){
		
			this.eventoForma.iniciarValores(pArrObjParametrosForma);
			this.eventoForma.setBooFinalizoExitosoValores(true);
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo adicionarAcciones
	 * 		   metodo que permite adicionar a la plantilla general las 
	 * 		   acciones que tendra la forma, Ej. Guardar, Consultar, 
	 * 		   Salir, etc.
	 * 		   Es importante mencionar que las acciones seran adicionadas 
	 * 		   en el orden de llegada del argumento variable.
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	public void adicionarAcciones(EnumBotonesEncabezado ... pAccionesEncabezado) throws Exception{
		
		if(pAccionesEncabezado!=null && 
				pAccionesEncabezado.length>0){
			this.arrEnmAcciones=pAccionesEncabezado;
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: iniciarForma
	 * @descripcion: metodo que debera ser invocado desde la forma
	 * implementada por el Ing.Software, el cual permitira mostrar
	 * la forma.
	 * @throws Exception: Controla, recupera y escala, cualquier tipo de 
  	 * 		   excepcion presentada
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	private void iniciarForma() throws Exception{
		
		//this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setSize(this.anchoForma, 
					 this.altoForma);
		//this.inicializaEncabezado();
		this.inicializaCuerpoPlantilla();
		
		this.setLocationRelativeTo(this.getParent());//centra con respecto al formulario del cual fue invocada la forma
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlBarraHerramientas
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlBarraHerramientas
  	 * @return JPanel 
  	 * 		   seccion principal de contenido gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private JPanel iniciarPropPnlBarraHerramientas() throws Exception{
		
		if	(		this.pnlBarraHerramientas	==	null
				&&	this.arrEnmAcciones!=null
			)
		{
			this.pnlBarraHerramientas = new JPanel();
			this.pnlBarraHerramientas.setBackground(Color.WHITE);
			
			this.pnlBarraHerramientas.setSize(this.anchoForma,
								  EnumDimensionesComponentes.PNL_FRM_GNR_BARRA_HERRAMIENTAS.getAlto());
			
			this.pnlBarraHerramientas.setLayout(null);
			this.pnlBarraHerramientas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			this.adicionarAcciones(this.pnlBarraHerramientas);
			//this.add(this.pnlBarraHerramientas);
			this.pnlCuerpoPlantilla.add(pnlBarraHerramientas);
		}
		
		return this.pnlBarraHerramientas;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo adicionarAcciones
	 * 		   metodo que permite adicionar a la plantilla general los 
	 * 		   botones al encabezado de la misma, teniendo en cuenta el 
	 * 		   miembro de clase llamado arrEnmAcciones.
	 * @param pPanelEncabezado
	 * 		  seccion sobre la cual se adjuntaran los botones
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	private void adicionarAcciones(JPanel pPanelEncabezado) throws Exception{

		BotonUtil btnAccion=null;
		int intmargen=5;
		int intPosicionX=intmargen;
		
		if(this.arrEnmAcciones!=null && 
				this.arrEnmAcciones.length>0){

			this.lstBotonesMenu = new ArrayList<BotonUtil>();
			
			for(EnumBotonesEncabezado enmBotonEncabezado : this.arrEnmAcciones){
				
				EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES.getRectangulo().setBounds(new Rectangle(intPosicionX,
						  																				EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES.getY(),
						  																				EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES.getAncho(),
						  																				EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES.getAlto()));
				
				btnAccion = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES, 
																		enmBotonEncabezado.getCodigo(), 
																		null, 
																		true, 
																		true, 
																		this.eventoForma, 
																		enmBotonEncabezado.getEnmImagen().ajustarIcono(EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES));
				
				btnAccion.setBorder(BorderFactory.createEmptyBorder());
				
				btnAccion.addActionListener(this.detectarAccionSeleccionada());
				btnAccion.addKeyListener(this.accionarPorTeclado());
				btnAccion.setToolTipText(enmBotonEncabezado.getEnmEtiToolTip());
				btnAccion.setArch(30);
				btnAccion.setArcw(30);
				pPanelEncabezado.add(btnAccion);
				this.lstBotonesMenu.add(btnAccion);
				intPosicionX+=EnumDimensionesComponentes.BTN_FRM_GNR_ACCIONES.getAncho()+intmargen;
			}
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo detectarAccionSeleccionada
	 * 		   metodo que fabrica un evento de ActionListener, que se
	 * 		   encarga de detectar la opcion a nivel de barra de herramientas
	 * 		   o 'accion' que ha señalado el cajero, esto con el fin de
	 * 		   lograr reconocer en caso que la ventana haya sido cerrada
	 * 		   cual opcion fue la tomada por el cajero y asi mismo condicionar
	 * 		   el flujo del sistema
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Hector Q-en-K
	 * ****************************************************************
	 */
	private ActionListener detectarAccionSeleccionada()throws Exception{
		
		return (new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent pEvtActionPerformed){
			
				Component componente;
				
				try {
					
					componente = (Component)pEvtActionPerformed.getSource();
					accionarEjecucion(componente);
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
	}
	
	private KeyListener accionarPorTeclado()throws Exception{
		
		return (new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent pEvtKeyTyped) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent pEvtKeyReleased) {
				
				Component componente;
				
				try {
					
					componente = (Component)pEvtKeyReleased.getSource();
					
					if(pEvtKeyReleased.getKeyCode() == TeclasEnum.ENTER.getCodigoTecla()){
						
						accionarEjecucion(componente);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent pEvtKeyPressed) {
				// TODO Auto-generated method stub
				
			}
		});
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
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void accionarEjecucion(Component pComponent)throws Exception{
		
		if(pComponent.getName().equals(EnumBotonesEncabezado.BTNGUARDAR.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTNGUARDAR;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNSALIR.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTNSALIR;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNCONSULTAR.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTNCONSULTAR;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNIMPRIMIR.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTNIMPRIMIR;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNVOLVER.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTNVOLVER;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTNOPERACION_INUSUAL.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTNOPERACION_INUSUAL;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTN_ANULAR.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTN_ANULAR;
		}else if(pComponent.getName().equals(EnumBotonesEncabezado.BTN_AYUDA.getCodigo())){
			this.enmBotEncAccionSolicitada = EnumBotonesEncabezado.BTN_AYUDA;
		}
	}
	
	/**
	 * ****************************************************************.
	 * @metodo inicializaCuerpoPlantilla
	 * 		   metodo que permite adicionar el contenido de la forma 
	 * 		   implementada por el Ing.Software al cuerpo de la plantilla 
	 * 		   general. Ademas de pintar el cuerpo de la plantilla general.
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	private void inicializaCuerpoPlantilla() throws Exception{
		
		try{
		
		EnumDimensionesComponentes.PNL_FRM_GNR_CUERPO_PLANTILLA.getRectangulo().setBounds(new Rectangle(0, 
																								  		0,//this.getIntAltoBarraHerramientas()+5, 
																									 	this.anchoForma,//-2, 
																									 	this.altoForma+1//-(this.getIntAltoBarraHerramientas()+35))
																									 	)
																						  );
		
		this.pnlCuerpoPlantilla = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_FRM_GNR_CUERPO_PLANTILLA, 
																			  "pnlCuerpoPlantilla",
																			  BorderFactory.createEmptyBorder(),//BorderFactory.createLineBorder(Color.BLACK, 1), 
																			  null,
																			  null);
		//if(this.pnlContenido!=null){
			
			/*this.pnlContenido.setBounds(1, 
										1, 
										this.anchoForma-5,
										this.altoForma-(this.getIntAltoBarraHerramientas()+37));*/
		
		
			this.iniciarPropPnlBarraHerramientas();
			this.pnlCuerpoPlantilla.add(this.iniciarPropPnlContenido());
		//}
		
		this.add(this.pnlCuerpoPlantilla);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarContenido
  	 * 		   Metodo dedicado a gestionar el contenido principal de la 
  	 * 		   forma, ejecutando la inicializacion del encabezado, cuerpo 
  	 * 		   y pie de pagina de la misma (secciones superior, media e 
  	 * 		   inferior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void inicializarContenido(Object ...pArrObjParametrosForma)throws Exception{
		
		this.cargarContenidoEncabezado(this.inicializarEncabezado(pArrObjParametrosForma));
		this.cargarContenidoCuerpo(this.inicializarCuerpo(pArrObjParametrosForma));
		this.cargarContenidoPiePagina(this.inicializarPiePagina(pArrObjParametrosForma));
	}
	
	private void cargarContenidoEncabezado(JPanel pPnlContenidoEncabezado)throws Exception{
	
		if(pPnlContenidoEncabezado!=null){
			this.pnlContenidoEncabezado = pPnlContenidoEncabezado;
			this.iniciarPropPnlContenido().add(this.pnlContenidoEncabezado);
		}
	}
	
	private void cargarContenidoCuerpo(JPanel pPnlContenidoCuerpo)throws Exception{
		
		if(pPnlContenidoCuerpo!=null){
			this.pnlContenidoCuerpo = pPnlContenidoCuerpo;
			this.iniciarPropPnlContenido().add(this.pnlContenidoCuerpo);
		}
	}
	
	private void cargarContenidoPiePagina(JPanel pPnlContenidoPiePagina)throws Exception{
		
		if(pPnlContenidoPiePagina!=null){
			this.pnlContenidoPiePagina = pPnlContenidoPiePagina;
			this.iniciarPropPnlContenido().add(this.pnlContenidoPiePagina);
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlContenido
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlContenido
  	 * @return JPanel 
  	 * 		   seccion principal de contenido gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public JPanel iniciarPropPnlContenido()throws Exception{
		
		if(this.pnlContenido==null){
			
			EnumDimensionesComponentes.PNL_FRM_GNR_CONTENIDO.getRectangulo().setBounds(new Rectangle(0, 
																									 this.getIntAltoBarraHerramientas()+1, 
																									 this.anchoForma,
																									 this.altoForma-(this.getIntAltoBarraHerramientas())
																									 )
			);
			
			this.pnlContenido = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_FRM_GNR_CONTENIDO,
																			"pnlContenido",
																		 	BorderFactory.createEmptyBorder(),
																		 	null,
																		 	null);
		}
		
		return this.pnlContenido;
	}
	
	/**
	 * ****************************************************************.
	 * @metodo inicializarForma
	 * 		   firma que obliga a los Ing.Software tener un comportamiento
	 * 		   para iniciar la forma, teniendo en cuenta la estructura 
	 * 		   IniciarForma, Encabezado, Cuerpo y pie de pagina.
	 * @param pArrObjParametrosForma
	 * 		  lista de posibles parametros a incluir sobre la inicializacion 
	 * 		  de la forma
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	public abstract void inicializarForma(Object ...pArrObjParametrosForma) throws Exception;
	
	/**
	 * ****************************************************************.
	 * @metodo inicializarEncabezado
	 * 		   firma que obliga a los Ing.Software tener un comportamiento
	 * 		   para iniciar el encabezado de la forma, teniendo en cuenta 
	 * 		   la estructura IniciarForma, Encabezado, Cuerpo y pie de 
	 * 		   pagina.
	 * @param pArrObjParametrosForma 
	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	public abstract JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception;
	
	/**
	 * ****************************************************************.
	 * @metodo inicializarCuerpo
	 * 		   firma que obliga a los Ing.Software tener un comportamiento
	 * 		   para iniciar el cuerpo de la forma, teniendo en cuenta la 
	 * 		   estructura IniciarForma, Encabezado, Cuerpo y pie de pagina.
	 * @param pArrObjParametrosForma: 
	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	public abstract JPanel  inicializarCuerpo(Object ...pArrObjParametrosForma) throws Exception;
	
	/**
	 * ****************************************************************.
	 * @metodo inicializarPiePagina
	 * 		   firma que obliga a los Ing.Software tener un comportamiento
	 * 		   para inicializarPiePagina de la forma, teniendo en cuenta 
	 * 		   la estructura IniciarForma, Encabezado, Cuerpo y pie de 
	 * 		   pagina.
	 * @param pArrObjParametrosForma: 
	 * 		  lista de parametros de forma, para un posible uso por parte
  	 * 		  del despliegue inicial de valores
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada
	 * @autor Andres Cardenas
	 * ****************************************************************
	 */
	public abstract JPanel inicializarPiePagina(Object ...pArrObjParametrosForma) throws Exception;

	
	@Deprecated
	@Override
	public void setTitle(String pStrTitulo) {
		
		super.setTitle(pStrTitulo);
	}
	
	@Override
	public void setVisible(boolean pBooVisible) {
		
		if (pBooVisible) {
			FormaGenerica.lstFormasGenericas.add(this);
		}else{
			if (FormaGenerica.lstFormasGenericas.contains(this)) {
				FormaGenerica.lstFormasGenericas.remove(this);
			}
		}
		
		super.setVisible(pBooVisible);
		
		/**
		 * Se anula la opcion centralizada para realizar pack(), sobre las formas
		 * en este metodo, debido a que tuvo repercuciones graficas en el proceso 
		 * de autenticacion cuando la caja se encuentra cerrada y propone abrirla.
		 * 
		 * Para actvarlo se debe validar lo sucedido en este caso, depronto no
		 * sea el metodo mas indicado para adjuntar este comportamiento o se pueda
		 * deber a la ausencia de layout en las formas
		 */ 
		/*if(pBooVisible){
			
			this.pack();
		}*/
	}
	
	@Override
	public void dispose() {
		
		if (FormaGenerica.lstFormasGenericas.contains(this)) {
			FormaGenerica.lstFormasGenericas.remove(this);
		}
		
		super.dispose();
	}
	
	@Override
	public void setSize(int pIntAncho, 
						int pIntAlto) {
		
		this.validarRecomendacionesXResolucion(pIntAncho,
											   pIntAlto);
		
		super.setSize(pIntAncho,
					  pIntAlto);
	}
	
	private void validarRecomendacionesXResolucion(int pIntAncho, 
												   int pIntAlto){
		
		int intAnchoMaximoFormasRecomendadoXResolucion = 0;
		int intAltoMaximoFormasRecomendadoXResolucion = 0;
		
		if(FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.DESARROLLO)){
		
			try{
				
				intAnchoMaximoFormasRecomendadoXResolucion = EnumParametrosApp.ANCHO_MAXIMO_FORMAS_RECOMENDADO_X_RESOLUCION.getValorEntero();
				intAltoMaximoFormasRecomendadoXResolucion = EnumParametrosApp.ALTO_MAXIMO_FORMAS_RECOMENDADO_X_RESOLUCION.getValorEntero();
				
			}catch(Exception e){
				
				if(intAnchoMaximoFormasRecomendadoXResolucion==0){
					intAnchoMaximoFormasRecomendadoXResolucion = 800;
				}
				
				if(intAltoMaximoFormasRecomendadoXResolucion==0){
					intAltoMaximoFormasRecomendadoXResolucion = 670;
				}
			}
			
			if(pIntAncho>intAnchoMaximoFormasRecomendadoXResolucion
					||pIntAlto>intAltoMaximoFormasRecomendadoXResolucion){
				
				try{
					
					EnumMensajes.RESOLUCION_FORMA_SUPERA_MAXIMO_RECOMENDADO.desplegarMensaje(this.frmPadre,
																						EnumClasesMensaje.ADVERTENCIA,
																						this.getTitle(),
																						String.valueOf(pIntAncho),
																						String.valueOf(pIntAlto),
																						String.valueOf(intAnchoMaximoFormasRecomendadoXResolucion),
																						String.valueOf(intAltoMaximoFormasRecomendadoXResolucion));
				}catch(Exception e){}
			}
		}
	}
	
	public ControlFocosForma activarControlFocosFormaPersonalizado()throws Exception{
		
		if(this.objControlFocosFormaPersonalizado == null){
			
			this.objControlFocosFormaPersonalizado = new ControlFocosForma();
			
			if(this.lstBotonesMenu != null
					&& !this.lstBotonesMenu.isEmpty()){
			
				this.objControlFocosFormaPersonalizado.getLstComponentes().addAll(this.lstBotonesMenu);
			}
		}
		
		this.setFocusTraversalPolicy(this.objControlFocosFormaPersonalizado);
		
		return this.objControlFocosFormaPersonalizado;
	}
	
	public FocusTraversalPolicy restaurarControlFocosFormaOriginal()throws Exception{
		
		this.setFocusTraversalPolicy(this.objControlFocosFormaOriginal);
		
		return this.objControlFocosFormaOriginal;
	}
	
	public EventoAbstracto getEventoForma() {
		return eventoForma;
	}

	public void setEventoForma(EventoAbstracto eventoForma) {
		
		this.eventoForma = eventoForma;
		
		this.addWindowListener(eventoForma);
	}
	
	public void setTituloForma(EnumEtiquetas pEnmTituloVentana,
							   String ...pArrStrParametros){
		
		this.enmEtiTituloForma = pEnmTituloVentana;
		
		super.setTitle(this.enmEtiTituloForma.getValor(false, 
													   pArrStrParametros) + strVersion);
	}
	
	public int getAnchoForma() {
		return anchoForma;
	}

	public void setAnchoForma(int anchoForma) {
		this.anchoForma = anchoForma;
	}

	public int getAltoForma() {
		return altoForma;
	}

	public void setAltoForma(int altoForma) {
		this.altoForma = altoForma;
	}

	public JPanel getPnlCuerpoPlantilla() {
		return pnlCuerpoPlantilla;
	}

	public void setPnlCuerpoPlantilla(JPanel pnlCuerpoPlantilla) {
		this.pnlCuerpoPlantilla = pnlCuerpoPlantilla;
	}

	public JPanel getPnlContenido() {
		return pnlContenido;
	}

	public void setPnlContenido(JPanel pnlContenido) {
		this.pnlContenido = pnlContenido;
	}

	public JPanel getPnlContenidoCuerpo() {
		return pnlContenidoCuerpo;
	}

	public void setPnlContenidoCuerpo(JPanel pnlContenidoCuerpo) {
		this.pnlContenidoCuerpo = pnlContenidoCuerpo;
	}

	public JPanel getPnlContenidoEncabezado() {
		return pnlContenidoEncabezado;
	}

	public void setPnlContenidoEncabezado(JPanel pnlContenidoEncabezado) {
		this.pnlContenidoEncabezado = pnlContenidoEncabezado;
	}

	public JPanel getPnlContenidoPiePagina() {
		return pnlContenidoPiePagina;
	}

	public void setPnlContenidoPiePagina(JPanel pnlContenidoPiePagina) {
		this.pnlContenidoPiePagina = pnlContenidoPiePagina;
	}

	public Window getFrmPadre() {
		return frmPadre;
	}

	public void setFrmPadre(Window frmPadre) {
		this.frmPadre = frmPadre;
	}

	public EnumBotonesEncabezado getEnmBotEncAccionSolicitada() {
		return enmBotEncAccionSolicitada;
	}

	public void setEnmBotEncAccionSolicitada(
			EnumBotonesEncabezado enmBotEncAccionSolicitada) {
		this.enmBotEncAccionSolicitada = enmBotEncAccionSolicitada;
	}

	public boolean isBooDesaparecerVentanaPadre() {
		return booDesaparecerVentanaPadre;
	}

	public void setBooDesaparecerVentanaPadre(boolean booDesaparecerVentanaPadre) {
		this.booDesaparecerVentanaPadre = booDesaparecerVentanaPadre;
	}

	public boolean isBooVisible() {
		return booVisible;
	}

	public void setBooVisible(boolean booVisible) {
		this.booVisible = booVisible;
	}

	public Integer getIntAltoBarraHerramientas() throws Exception{
		
		if(this.intAltoBarraHerramientas == null){
			
			if(this.iniciarPropPnlBarraHerramientas()!=null){
				
				this.intAltoBarraHerramientas = this.pnlBarraHerramientas.getHeight();
				
			}else{
				
				this.intAltoBarraHerramientas = 0;
			}
		}
		
		return intAltoBarraHerramientas;
	}

	public void setIntAltoBarraHerramientas(Integer intAltoBarraHerramientas) {
		this.intAltoBarraHerramientas = intAltoBarraHerramientas;
	}

	/**
	 * @method getPnlBarraHerramientas
	 * 		   Metodo get del atributo pnlBarraHerramientas
	 * @return JPanel
	 *		   Valor del atributo pnlBarraHerramientas devuelto
	 * @author hector.cuenca
	 * @date   13/06/2017
	 */
	public JPanel getPnlBarraHerramientas() {
		return this.pnlBarraHerramientas;
	}

	/**
	 * @method setPnlBarraHerramientas
	 * 		   Metodo set del atributo pnlBarraHerramientas
	 * @param  pPnlBarraHerramientas
	 *		   Valor que tomara el atributo pnlBarraHerramientas
	 * @author hector.cuenca
	 * @date   13/06/2017
	 */
	public void setPnlBarraHerramientas(JPanel pPnlBarraHerramientas) {
		this.pnlBarraHerramientas = pPnlBarraHerramientas;
	}

	public Usuario getObjUsuario() {
		
		return InformacionSessionGiros.getInstance().getObjUsuario();
	}	

	public void setObjUsuario(Usuario objUsuario) {
		
		InformacionSessionGiros.getInstance().setObjUsuario(objUsuario);
		
	}
	
	/**
	 * @return the booAnularEventosXFocusLost
	 */
	public boolean isBooAnularEventosXFocusLost() {
		return booAnularEventosXFocusLost;
	}

	/**
	 * @param booAnularEventosXFocusLost the booAnularEventosXFocusLost to set
	 */
	public void setBooAnularEventosXFocusLost(boolean booAnularEventosXFocusLost) {
		this.booAnularEventosXFocusLost = booAnularEventosXFocusLost;
	}

}
