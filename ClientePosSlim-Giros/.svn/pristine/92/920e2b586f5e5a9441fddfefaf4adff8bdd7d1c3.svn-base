package co.com.codesa.clienteposslimgiros.formas.biometria;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.biometria.EventoFormaSolicitarHuellas;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/** 
 * ********************************************************************
 * @class	FormaSolicitarHuellas
 *		 	Forma para solicitar las huellas a un tercero en procesos 
 *			de enrolamiento y/o verificacion biometrica
 * @author	hector.cuenca
 * @date  	20/09/2017
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaSolicitarHuellas extends FormaGenerica{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -6008766807282397749L;
	
	/**
	 * @variable	chkPulgarDerecho
	 * 				[TODO - DOC]: Descripcion de la variable, su intencion, proposito
	 *				objetivo
	 */
	private JToggleButton chkPulgarDerecho;
	
	/**
	 * ********************************************************************
	 * @method	FormaSolicitarHuellas
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma
	 * @param 	pFrmPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	20/09/2017
	 * *********************************************************************
	 */
	public FormaSolicitarHuellas(	JFrame pFrmPadre,
	                             	boolean pBooModal
	                            ) 
	                            		throws Exception 
	{	
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaSolicitarHuellas(this));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TTL_SHT_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_SHT_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_SHT_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNIMPRIMIR,
						  		EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception{
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SHT_ENCABEZADO,
																	"pnlEncabezado",
		  														 	BorderFactory.createEtchedBorder(),
		  														 	null,
		  														 	null);
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		
		SeccionUtil pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SHT_CUERPO,
																"pnlCuerpo",
	  													 		BorderFactory.createEtchedBorder(),
	  													 		null,
	  													 		null);
		
		/**
		 * pnlCuerpo.setImgImagen(EnumImagenes.APP_LOGO_SUPERGIROS.getImgImagen().getImage(),
								   this.frmPrincipal,
								   EnumDimensionesComponentes.IMG_INI_PRESENTACION.getRectangulo());
		 */
		
		pnlCuerpo.setImgImagen	(	EnumImagenes.APP_BIO_MANOS.getImgImagen().getImage(),
		                      	 	this,
		                      	 	EnumDimensionesComponentes.IMG_SHT_MANOS.getRectangulo()
		                      	);
		
		/*pnlCuerpo.setImgImagen	(	EnumImagenes.APP_BIO_MANO_DERECHA.getImgImagen().getImage(),
		                      	 	this,
		                      	 	EnumDimensionesComponentes.IMG_SHT_MANO_IZQUIERDA.getRectangulo()
		                      	);*/
		
		JToggleButton boton = new JToggleButton(EnumImagenes.APP_BIO_HUELLA.ajustarIcono ( new Dimension(30,50) ));
		//boton.setDisabledIcon ( EnumImagenes.APP_BIO_HUELLA_CAPTURADA.ajustarIcono ( new Dimension(30,50) ) );
		//boton.setDisabledSelectedIcon ( EnumImagenes.APP_BIO_HUELLA_CAPTURADA.ajustarIcono ( new Dimension(30,50) ) );
		
		boton.setBounds ( new Rectangle(185,14,30,50) );
		boton.setOpaque ( false );
		boton.setContentAreaFilled ( false );
		boton.setBorder ( BorderFactory.createEmptyBorder () );
		boton.addItemListener ( new ItemListener() {
			@Override
			public void itemStateChanged (ItemEvent pE)
			{
				JToggleButton tglHuella=(JToggleButton)pE.getSource ();
				if (tglHuella.isSelected()) {
					tglHuella.setIcon ( EnumImagenes.APP_BIO_HUELLA_CAPTURADA.ajustarIcono ( new Dimension(30,50) ) );
				  } else {
					 tglHuella.setIcon ( EnumImagenes.APP_BIO_HUELLA.ajustarIcono ( new Dimension(30,50) ) );
				  }
			}
		} );
		
		JToggleButton boton2 = new JToggleButton(EnumImagenes.APP_BIO_HUELLA.ajustarIcono ( new Dimension(30,50) ));
		//boton.setDisabledIcon ( EnumImagenes.APP_BIO_HUELLA_CAPTURADA.ajustarIcono ( new Dimension(30,50) ) );
		//boton.setDisabledSelectedIcon ( EnumImagenes.APP_BIO_HUELLA_CAPTURADA.ajustarIcono ( new Dimension(30,50) ) );
		
		boton2.setBounds ( new Rectangle(586,14,30,50) );
		boton2.setOpaque ( false );
		boton2.setContentAreaFilled ( false );
		boton2.setBorder ( BorderFactory.createEmptyBorder () );
		boton2.addItemListener ( new ItemListener() {
			@Override
			public void itemStateChanged (ItemEvent pE)
			{
				JToggleButton tglHuella=(JToggleButton)pE.getSource ();
				if (tglHuella.isSelected()) {
					tglHuella.setIcon ( EnumImagenes.APP_BIO_HUELLA_CAPTURADA.ajustarIcono ( new Dimension(30,50) ) );
				  } else {
					 tglHuella.setIcon ( EnumImagenes.APP_BIO_HUELLA.ajustarIcono ( new Dimension(30,50) ) );
				  }
			}
		} );
		
		pnlCuerpo.add(boton);
		pnlCuerpo.add(boton2);
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		/*JPanel pnlPiePagina = null;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanelSinTitulo(pnlPiePagina, 
					 													EnumDimensionesComponentes.PNL_SHT_PIE_PAGINA.getRectangulo(),
					 													BorderFactory.createEtchedBorder());
		pnlPiePagina.add(this.iniciarPropPnlSeccionResultado());
		
		return pnlPiePagina;*/
		return null;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	main
	 * 		   	Metodo principal (main), para realizar una prueba de unidad
	 * 			de la forma
	 * @param 	args
	 * 			Cadena de argumentos demandada por el metodo principal (main)
	 * @author 	hector.cuenca
	 * @date   	23/11/2016
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaSolicitarHuellas.class,
																			true, 
																			EnumDesplegarFormaConEventos.SI);
			new FormaSolicitarHuellas(jframe,
			                          true
								 	 );
			
		} catch (Exception e) {
			
			e.printStackTrace();
			Logger.getInstance().error(e.getMessage());
			
		}
	}
	
}
