package co.com.codesa.clienteposslimgiros.formas.lector2D;

import java.awt.Event;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import co.com.codesa.clienteposslim.controladorimagenes.ControladorImagen;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosSistema;
import co.com.codesa.clienteposslimgiros.evento.lector2D.EventoFormaLector2D;
import co.com.codesa.clienteposslimgiros.eventos.biometria.EventoFormaEnrolarTercero;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.utilidades.parametrosSistema.UtilParametrosSistema;
import co.com.codesa.clienteposslimgiros.vista.logica.ControlConsultaPasiVistaLogica;
import co.com.codesa.codesawrapper.modelo.dominio.ParametroSistema;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/**
 * 
 * ********************************************************************
 * 
 * @class formaLector2D 
 * 		  Forma encargada de visualizar la pantalla 
 *        del lector 2D
 * @author jefferson Ruiz
 * @date 06/09/2019
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 *            
 * *********************************************************************
 */
public class FormaLector2D extends FormaGenerica {

	private JTextArea txaMensaje;
	private JLabel lblImagen;
	private JTextArea txaLector2D;
	private JTextArea txaMensajeALerta;

	/**
	 * 
	 */
	private static final long serialVersionUID = 212891767291004131L;
	
	public FormaLector2D(FormaGenerica pFrmPadre, 
						boolean pBooModal,
						Tercero pobjTercero) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaLector2D(this,
													pobjTercero));
		this.inicializarForma();
		
	}

	
	

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma)
			throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_LECTOR_2D);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_LECTOR_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_LECTOR_VENTANA.getAlto());
		
		//super.adicionarAcciones(EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
		
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma)
			throws Exception {
		
		JPanel pnlEncabezado = null;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_LECTOR_PANEL_ENCABEZADO, 
																	"pnlEncabezado", 
																	null, 
																	null, 
																	null);
		pnlEncabezado.add(this.inicarPropAreaTextoLector2D());
		pnlEncabezado.add(this.iniciarPropAreaTextoMensajeLector2D());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)
			throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_LECTOR_PANEL_CUERPO, 
																"pnlCuerpo", 
																null, 
																null, 
																null);
		pnlCuerpo.add(this.iniciarPropLAbleImagen());
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma)
			throws Exception {
		
		JPanel pnlPiePagina;

		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel	(	EnumDimensionesComponentes.PNL_LECTOR_PANEL_PIE_PAGINA,
																		"pnlPiePagina",
																		BorderFactory.createEtchedBorder(),
																		null,
																		null
																	);
		
		pnlPiePagina.add(this.iniciarPropAreaTextoMensajeAlerta());
				
		return pnlPiePagina;
		
	}
	
	private JTextArea inicarPropAreaTextoLector2D() throws Exception{
	
		if (txaLector2D == null) {
			
			txaLector2D = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_LECTOR_DATO,
																		"areaTexto", 
																		"", 
																		true, 
																		true, 
																		true, 
																		super.getEventoForma(),
																		EnumEtiquetas.LBL_LECTOR_LECTURA);
			this.txaLector2D.requestFocus(true);
			
			this.txaLector2D.setForeground(javax.swing.UIManager.getDefaults()
					.getColor("Panel.background"));
			this.txaLector2D.setBackground(javax.swing.UIManager.getDefaults()
					.getColor("Panel.background"));
			this.txaLector2D.setCaretColor(javax.swing.UIManager.getDefaults()
					.getColor("Panel.background"));
			this.txaLector2D.setHighlighter(null);
			
			InputMap objMap = this.txaLector2D.getInputMap(this.txaLector2D.WHEN_FOCUSED);
			objMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
			
		}
		
		return this.txaLector2D;
		
	}
	
	private JTextArea iniciarPropAreaTextoMensajeAlerta() throws Exception {
		
		if (this.txaMensajeALerta == null) {
			
			this.txaMensajeALerta = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_LECTOR_MENSAJE_ALERTA, 
																			"areaTexto", 
																			"", 
																			false, 
																			false, 
																			true, 
																			null, 
																			EnumEtiquetas.LBL_LECTOR_LECTURA);

			this.txaMensajeALerta.setBorder(javax.swing.BorderFactory
										.createLineBorder(javax.swing.UIManager.getDefaults().getColor(
										"Panel.background")));
			
								
		}
		
		return this.txaMensajeALerta;
	}
	
	private JLabel iniciarPropLAbleImagen() throws Exception{
		
		if (this.lblImagen == null) {
			
			ImageIcon objImagen = new ImageIcon(getClass().getResource("/co/com/codesa/clienteposslimgiros/dto/imagen/ReversoDocumento.png"));			
			
			this.lblImagen = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_LECTOR_IMAGEN, 
																		"labelImagen", 
																		EnumEtiquetas.LBL_LECTOR_IMAGEN,
																		true, 
																		objImagen, 
																		true);
			this.lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
			this.lblImagen.setBorder(BorderFactory.createTitledBorder(null, 
					 												  "Guia", 
					 												  TitledBorder.LEFT, 
					 												  TitledBorder.TOP, 
					 												  new java.awt.Font("Tahoma", 1, 14)));
			
		}
		
		return this.lblImagen;
	}
	
	private JTextArea iniciarPropAreaTextoMensajeLector2D() throws Exception {
		
		ParametroSistema psPASI;
		
		if (this.txaMensaje == null) {
			
			this.txaMensaje = UtilComponentesGUI.getInstance().crearTextArea(EnumDimensionesComponentes.TXA_LECTOR_MENSAJE, 
																			"areaTexto", 
																			ControlConsultaPasiVistaLogica.getInstance().getVainetld(), 
																			false, 
																			false, 
																			true, 
																			null, 
																			EnumEtiquetas.LBL_LECTOR_LECTURA);

					this.txaMensaje.setBorder(javax.swing.BorderFactory
											.createLineBorder(javax.swing.UIManager.getDefaults().getColor(
													"Panel.background")));
								
		}
		
		return this.txaMensaje;
	}
	
	public JTextArea getTxaLector2D(){
		return this.txaLector2D;
	}
	
	public JTextArea getTxaMensajeALerta() {
		return this.txaMensajeALerta;
	}
	

}
