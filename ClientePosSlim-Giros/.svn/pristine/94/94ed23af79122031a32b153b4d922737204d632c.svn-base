/*
 * Andres Cardenas.
 * Copyright  1998-2015 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.formas.principal;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import co.com.codesa.clienteposslim.AccordianPanel;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.principal.EventoFormaInicioGiro;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.GeneralGirosVistaLogica;

/**
 * ****************************************************************.
 * @autor: Andres Cardenas
 * @fecha: 05-mar-2015
 * @descripcion: Clase encaraga de pintar la forma de inicio de giros
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaInicioGiros extends JPanel {

	private static final long serialVersionUID = 1L;
	private EventoAbstracto eventoForma;
	private JFrame frmPrincipal;
	public static EtiquetaUtil lblComunicador;
	private static EtiquetaUtil lblVersionGiros;
	
	public FormaInicioGiros(JFrame pFrmPrincipal)throws Exception{
		
		super();
		this.inicializarComponentes(pFrmPrincipal);
	}
	
	public FormaInicioGiros(AccordianPanel pAcdPnlAccordian)throws Exception{

        this(pAcdPnlAccordian.getPrincipal());
    }
	
	/**
	 * ****************************************************************.
	 * @param pFrmPrincipal corresponde a la instancia del AccordionPanel
	 * al que pertenece este accordion
	 * @metodo: inicializarComponentes
	 * @descripcion: metodo que carga todos los elementos de la forma
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	public void inicializarComponentes(JFrame pFrmPrincipal){
		this.frmPrincipal=pFrmPrincipal;
		this.setLayout(null);
		this.eventoForma = new EventoFormaInicioGiro(this);
		this.inicializarEncabezado();
		this.add(this.inicializarCuerpo());
		this.add(this.inicializarPiePagina());
	}
	
	/**
	 * ****************************************************************.
	 * @metodo: inicializarEncabezado
	 * @descripcion: metodo que carga todos los elementos del encabezado
	 * de la forma.
	 * @autor: Andres Cardenas
	 * ****************************************************************
	 */
	public void inicializarEncabezado(){
		
		JMenuBar menuGeneral = GeneralGirosVistaLogica.getInstance().generarMenuBar(eventoForma);
		menuGeneral.setBounds(0, 0, 900, 20);
		this.add(menuGeneral);
		menuGeneral.setVisible(false);
		InformacionSessionGiros.getInstance().setMnbMenuCompleto(menuGeneral);
	}
	
	public SeccionUtil inicializarCuerpo(){
		
		SeccionUtil pnlCuerpo = null;
		
		try{
		
			pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_INI_CUERPO,
																	"pnlCuerpo",
				 	  												BorderFactory.createEmptyBorder(),
				 	  												null,
				 	  												null);
			FormaInicioGiros.lblVersionGiros = InformacionSessionGiros
					.getInstance().iniciarPropLblVersionProductoGiros(EnumDimensionesComponentes.LBL_FIG_VERSION_GIRO);
			
			pnlCuerpo.setImgImagen(EnumImagenes.APP_LOGO_SUPERGIROS.getImgImagen().getImage(),
								   this.frmPrincipal/*.getPrincipal()*/,
								   EnumDimensionesComponentes.IMG_INI_PRESENTACION.getRectangulo());
			
			pnlCuerpo.add(FormaInicioGiros.lblVersionGiros);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pnlCuerpo;
	}
	
	public SeccionUtil inicializarPiePagina(){
		
		SeccionUtil pnlPiePagina = null;
		
		try{
		
			pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_INI_PIE_PAGINA,
																	   "pnlPiePagina",
				  													   BorderFactory.createEmptyBorder(),
				  													   null,
				  													   null);
			pnlPiePagina.setBooAplicarTransparenciaFondo(true);
			FormaInicioGiros.lblComunicador = InformacionSessionGiros.getInstance().iniciarPropLblVersion(EnumDimensionesComponentes.LBL_INI_VERSION);
			pnlPiePagina.add(FormaInicioGiros.lblComunicador);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return pnlPiePagina;
	}
	
	public static void adicionarComunicado(String pStrComunicadoNuevo, 
								    	   Boolean pBooIzquierdaDerechaRestaurar){
		
		String strComunicadoActual;
		
		if(FormaInicioGiros.lblComunicador != null){
			
			if(pBooIzquierdaDerechaRestaurar == null){//Nuevo
				
				FormaInicioGiros.lblComunicador.setText(pStrComunicadoNuevo);
				
			}else{ 
				
				strComunicadoActual = FormaInicioGiros.lblComunicador.getTextoOriginal().trim();
				
				if(pBooIzquierdaDerechaRestaurar){//Izquierda
					
					FormaInicioGiros.lblComunicador.setText(pStrComunicadoNuevo+" | "+strComunicadoActual);
					
				}else{//Derecha
					
					FormaInicioGiros.lblComunicador.setText(strComunicadoActual+" | "+pStrComunicadoNuevo);
				}
			}
		}
	}

	/**
	 * @method getFrmPrincipal
	 * 		   Metodo get del atributo frmPrincipal
	 * @return JFrame
	 *		   Valor del atributo frmPrincipal devuelto
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public JFrame getFrmPrincipal() {
		return this.frmPrincipal;
	}

	/**
	 * @method setFrmPrincipal
	 * 		   Metodo set del atributo frmPrincipal
	 * @param  pFrmPrincipal
	 *		   Valor que tomara el atributo frmPrincipal
	 * @author hector.cuenca
	 * @date   28/11/2016
	 */
	public void setFrmPrincipal(JFrame pFrmPrincipal) {
		this.frmPrincipal = pFrmPrincipal;
	}

	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			del componente
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	hector.cuenca
	 * @date   	23/11/2016
	 * *********************************************************************
	 */
	public static void main(String args[])
	{
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(null,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			jframe.setVisible(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
		}
	}
}
