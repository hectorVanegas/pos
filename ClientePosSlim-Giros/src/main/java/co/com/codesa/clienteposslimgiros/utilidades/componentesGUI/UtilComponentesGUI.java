package co.com.codesa.clienteposslimgiros.utilidades.componentesGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import co.com.codesa.clienteposslim.enumeraciones.EstadoAplicacionEnum;
import co.com.codesa.clienteposslim.formas.FormaLogin;
import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslim.vista.IComponenteEstiloSwing;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.AreaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonRadioUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaClaveUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaFechaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaIncrementoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.ObligatoriedadUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.utilidades.html.UtilHtml;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 06-mar-2015
 * @Clase UtilComponentesGUI 
 * 		  Clase utilitaria relacionada con los componentes de interfaz
 * 		  grafica de usuario (GUI)
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class UtilComponentesGUI {

	/**
	 * @variable instancia 
	 * 			 Referencia estatica de la clase utilitaria, clave para incorporar
	 * 			 SINGLETON (patron de dise�o)
	 **/
	private static UtilComponentesGUI instancia;

	/**
  	 * ****************************************************************.
  	 * @metodo UtilComponentesGUI
  	 * 		   Metodo constructor que permite inicializar variables y
  	 * 		   ejecutar comportamientos de interes
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	private UtilComponentesGUI() {}

	/**
  	 * ****************************************************************.
  	 * @metodo getInstance
  	 * 		   Metodo clave para ejecutar el patron singleton sobre la 
  	 * 		   clase, materializando esta por unica vez y manteniendo una 
  	 * 		   sola instancia de esta
  	 * @return UtilComponentesGUI
  	 * 		   Tipo referente a la misma clase
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public static UtilComponentesGUI getInstance() {
		
		if (instancia == null) {
			
			instancia = new UtilComponentesGUI();
		}
		
		return instancia;
	}	
	
	public GrillaUtil crearGrilla(String pStrNombre,
			  				  	  EnumEtiquetas pArrEnmEtiquetas[],
			  				  	  EnumEtiquetas pArrEnmColumnasNoVisibles[],
			  				  	  boolean pArrBooColumnasEditables[],
			  				  	  int pArrIntTamanosColumnasPersonalizados[],
			  				  	  EventoAbstracto pEvento)throws Exception{
		
		GrillaUtil cmpGrilla;
		
		cmpGrilla = new GrillaUtil(pStrNombre,
									pArrEnmEtiquetas,
				 					pArrBooColumnasEditables,
				 					pArrEnmColumnasNoVisibles,
				 					pArrIntTamanosColumnasPersonalizados,
				 					pEvento);
		
		return (GrillaUtil)cmpGrilla;

	}
	
	public CajaComboUtil crearComboBox(EnumDimensionesComponentes pEnmDimension, 
									   String pStrNombre, 
									   boolean pBooHabilitado,
									   boolean pBooVisible, 
									   EventoAbstracto pEvaFuncionalidad,
									   EnumEtiquetas pEnmEtiNombreCampo,
									   String ...pArrStrParametros)throws Exception{

		CajaComboUtil cmpCombo;
		IComponenteEstiloSwing	iComponenteEstiloSwing;
		
		cmpCombo = new CajaComboUtil(pEnmEtiNombreCampo,
									 pArrStrParametros);

		cmpCombo.setFont(InformacionSession.TIPO_LETRA_CAJA_TEXTO);
		cmpCombo.setName(pStrNombre);

		cmpCombo.setEnabled(pBooHabilitado);
		cmpCombo.setVisible(pBooVisible);

		if(pEnmDimension != null){

			cmpCombo.setBounds(pEnmDimension.getRectangulo());
			cmpCombo.getLblObligatorio().setBounds(pEnmDimension.getRectangulo());
			
			if	(	cmpCombo	instanceof	IComponenteEstiloSwing	)	
			{
				iComponenteEstiloSwing	=	(IComponenteEstiloSwing)cmpCombo;
			
				if	(	pEnmDimension.getIntArcoX()	>=	0	)
				{
					iComponenteEstiloSwing.setArcw(pEnmDimension.getIntArcoX());
				}
				
				if	(	pEnmDimension.getIntArcoY()	>=	0	)
				{
					iComponenteEstiloSwing.setArch(pEnmDimension.getIntArcoY());
				}
			}
		}

		if (pEvaFuncionalidad != null){

			cmpCombo.addKeyListener(pEvaFuncionalidad);
			cmpCombo.addItemListener(pEvaFuncionalidad);
			cmpCombo.addActionListener(pEvaFuncionalidad);
			cmpCombo.addFocusListener(pEvaFuncionalidad);
		}

		return cmpCombo;
	}
	
	public CajaVerificadaUtil crearCheckBox(EnumDimensionesComponentes pEnmDimension,
											String pStrNombre,
											EnumEtiquetas pEnmEtiqueta,
											boolean pBooAdicionaDosPuntos,
											boolean pBooHabilitado,
											boolean pBooVisible, 
											boolean pBooSeleccionado, 
											EventoAbstracto pEvaFuncionalidad,
											int pIntPosicionEtiqueta, 
											boolean pBooEtiquetaNegrita) throws Exception{

		CajaVerificadaUtil objCmpCajaVerificada;

		objCmpCajaVerificada = new CajaVerificadaUtil(pEnmDimension,
													  pStrNombre,
													  pEnmEtiqueta,
													  pBooAdicionaDosPuntos,
													  pBooHabilitado,
													  pBooVisible, 
													  pBooSeleccionado, 
													  pEvaFuncionalidad,
													  pIntPosicionEtiqueta, 
													  pBooEtiquetaNegrita);

		return objCmpCajaVerificada;
	}
	
	public BotonRadioUtil crearRadioButton(EnumDimensionesComponentes pEnmDimension,
										   String pStrNombre, 
										   EnumEtiquetas pEnmEtiqueta, 
										   boolean pBooAdicionaDosPuntos,
										   boolean pBooEnable,
										   boolean pBooVisible, 
										   boolean pBooSeleccionado, 
										   Icon pIcon, 
										   EventoAbstracto pEvaFuncionalidad)throws Exception {

		BotonRadioUtil objCmpBotonRadio;

		objCmpBotonRadio = new BotonRadioUtil(pEnmDimension,
											  pStrNombre, 
											  pEnmEtiqueta, 
											  pBooAdicionaDosPuntos,
											  pBooEnable,
											  pBooVisible, 
											  pBooSeleccionado, 
											  pIcon, 
											  pEvaFuncionalidad);

		return objCmpBotonRadio;
	}
	
	public EtiquetaUtil crearLabel(EnumDimensionesComponentes pEnmDimension,
								   String pStrNombre, 
								   EnumEtiquetas pEnmValor,
								   boolean pBooAdicionaDosPuntos,
								   Icon pIcoImagen,
								   boolean pBooVisible,
								   String ...pStrParametros) throws Exception{

		EtiquetaUtil cmpEtiqueta;

		String strValor;
		
		strValor = pEnmValor==null?"":pEnmValor.getValor(pBooAdicionaDosPuntos,
														 pStrParametros);
		
		cmpEtiqueta = new EtiquetaUtil(strValor, SwingConstants.LEFT);

		if(pEnmDimension!=null){

			cmpEtiqueta.setBounds(pEnmDimension.getRectangulo());
		}

		cmpEtiqueta.setFont(InformacionSession.TIPO_LETRA_ETIQUETA_PEQUENA);
		cmpEtiqueta.setName(pStrNombre);

		if(pIcoImagen!=null){

			cmpEtiqueta.setIcon(pIcoImagen);
			
			/*if(pIcoImagen.getDescription().contains(EnumParametrosApp.AUTO_AJUSTAR_IMAGEN.getValorPropiedad())){

				icono = new ImageIcon(pIcoImagen.getImage().getScaledInstance(cmpEtiqueta.getWidth()-5, 
						cmpEtiqueta.getHeight()-5, 
						Image.SCALE_DEFAULT));
			}else{

				icono = pIcoImagen;
			}

			cmpEtiqueta.setIcon(icono);*/
		}
		
		cmpEtiqueta.setVisible(pBooVisible);

		return (EtiquetaUtil)cmpEtiqueta;
	}
	
	public CajaIncrementoUtil crearSpinner(EnumDimensionesComponentes pEnmDimension,
							   	 		   String pStrNombre, 
							   	 		   int pIntValorInicial,
							   	 		   int pIntValorMinimo,
							   	 		   int pIntValorMaximo,
							   	 		   int pIntValorIncremento,
							   	 		   boolean pBooVisible,
							   	 		   boolean pBooHabilita,
							   	 		   EventoAbstracto pEvaFuncionalidad,
							   	 		   EnumEtiquetas pEnmEtiNombreCampo,
							   	 		   String ...pArrStrParametros) throws Exception{	

		CajaIncrementoUtil cmpSpinner;
		SpinnerNumberModel modelo;
		
		cmpSpinner = new CajaIncrementoUtil(pIntValorInicial,
										   pIntValorMinimo,
										   pIntValorMaximo,
										   pIntValorIncremento,
										   pEnmEtiNombreCampo,
										   pArrStrParametros);
		
		cmpSpinner.setName(pStrNombre);

		cmpSpinner.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		cmpSpinner.setFont(InformacionSession.TIPO_LETRA_CAJA_TEXTO);
		
		modelo = new SpinnerNumberModel(pIntValorInicial,
										pIntValorMinimo,
										pIntValorMaximo,
										pIntValorIncremento);
		
		cmpSpinner.setModel(modelo);
		cmpSpinner.setVisible(pBooVisible);
		cmpSpinner.setEnabled(pBooHabilita);
		
		if(pEnmDimension!=null){
			
			cmpSpinner.setBounds(pEnmDimension.getRectangulo());
			((CajaIncrementoUtil)cmpSpinner).getLblObligatorio().setBounds(pEnmDimension.getRectangulo());
		}
		
		return (CajaIncrementoUtil)cmpSpinner;
	}
	
	public CajaTextoUtil crearTextField(EnumDimensionesComponentes pEnmDimension, 
										String pStrNombre, 
										String pStrValor, 
										boolean pBooHabilita,
										boolean pBooEdita, 
										boolean pBooVisible, 
										EventoAbstracto pEvaFuncionalidad,
										EnumEtiquetas pEnmEtiNombreCampo,
										String ...pArrStrParametros) throws Exception{

		CajaTextoUtil pJTextField;
		
		pJTextField	=	new CajaTextoUtil	(	pEnmDimension,
												pEnmEtiNombreCampo,
												pArrStrParametros
											);

		this.crearTextComponent(pJTextField,
								pEnmDimension,
								pStrNombre,
								pStrValor,
								pBooHabilita,
								pBooEdita,
								pBooVisible,
								pEvaFuncionalidad);
		
		return pJTextField;

	}
	
	public CajaClaveUtil crearPasswordField(EnumDimensionesComponentes pEnmDimension, 
											String pStrNombre, 
											String pStrValor, 
											boolean pBooHabilita,
											boolean pBooEdita, 
											boolean pBooVisible, 
											EventoAbstracto pEvaFuncionalidad,
											EnumEtiquetas pEnmEtiNombreCampo,
											String ...pArrStrParametros)throws Exception {

		CajaClaveUtil pJTextPasswordField; 
		
		pJTextPasswordField = new CajaClaveUtil	(	pEnmDimension,
													pEnmEtiNombreCampo,
													pArrStrParametros
												);

		this.crearTextComponent(pJTextPasswordField,
								pEnmDimension,
								pStrNombre,
								pStrValor,
								pBooHabilita,
								pBooEdita,
								pBooVisible,
								pEvaFuncionalidad);

		return pJTextPasswordField;
	}
	
	public void crearTextComponent(JTextComponent pJTextComponent,
									EnumDimensionesComponentes pEnmDimension,
						    		String pStrNombre, 
						    		String pStrValor, 
						    		boolean pBooHabilita,
						    		boolean pBooEdita, 
						    		boolean pBooVisible, 
						    		EventoAbstracto pEvaFuncionalidad)throws Exception{
		
		IComponenteEstiloSwing	iComponenteEstiloSwing;
		
		pJTextComponent.setName(pStrNombre);
		pJTextComponent.setFont(InformacionSession.TIPO_LETRA_CAJA_TEXTO);
		
		if(pEvaFuncionalidad!=null){
			pJTextComponent.addKeyListener(pEvaFuncionalidad);
			pJTextComponent.addFocusListener(pEvaFuncionalidad);
		}

		if(pEnmDimension!=null){
			
			pJTextComponent.setBounds(pEnmDimension.getRectangulo());
			
			if	(	pJTextComponent instanceof ComponentesObligatorios	)	
			{
				((ComponentesObligatorios) pJTextComponent).getLblObligatorio().setBounds(pEnmDimension.getRectangulo());
			}
			
			if	(	pJTextComponent	instanceof	IComponenteEstiloSwing	)	{
				
				iComponenteEstiloSwing	=	(IComponenteEstiloSwing)pJTextComponent;
				
				if	(	pEnmDimension.getIntArcoX()	>=	0	)
				{
					iComponenteEstiloSwing.setArcw(pEnmDimension.getIntArcoX());
				}
				
				if	(	pEnmDimension.getIntArcoY()	>=	0	)
				{
					iComponenteEstiloSwing.setArch(pEnmDimension.getIntArcoY());
				}
			}
		}

		pJTextComponent.setEnabled(pBooHabilita);
		pJTextComponent.setVisible(pBooVisible);
		pJTextComponent.setEditable(pBooEdita);
		pJTextComponent.setText(pStrValor);

		if (!pBooEdita && pBooHabilita) {
			pJTextComponent.setBackground(Color.white);
		}
		
	}
	
	public BotonUtil crearBoton(EnumDimensionesComponentes pEnmDimension,
							    String pStrNombre, 
							    EnumEtiquetas pEnmEtiqueta, 
							    boolean pBooHabilita, 
							    boolean pBooVisible,
							    EventoAbstracto pEvaFuncionalidad, 
							    Icon pIcoImagen) throws Exception{
		
		BotonUtil cmpButton;
		
		cmpButton = new BotonUtil	(	pEnmDimension,
										pStrNombre, 
										pEnmEtiqueta, 
										pBooHabilita, 
										pBooVisible,
										pEvaFuncionalidad, 
										pIcoImagen
									);

		return cmpButton;
	}
	
	public CajaFechaUtil crearCalendar(EnumDimensionesComponentes pEnmDimension,
									   String pStrNombre,
									   Date pDatValor, 
									   boolean pBooHabilitar,
									   EventoAbstracto pEvaFuncionalidad,
									   EnumEtiquetas pEnmEtiNombreCampo,
									   String ...pArrStrParametros)throws Exception {

		CajaFechaUtil cmpDateChooser;
		IComponenteEstiloSwing iComponenteEstiloSwing;
		Dimension objDimImgBtnCalendario;

		cmpDateChooser = new CajaFechaUtil(pEnmEtiNombreCampo,
										   pArrStrParametros);

		this.crearTextComponent((JTextComponent)cmpDateChooser.getDateEditor(), 
								null, 
								pStrNombre, 
								null, 
								true, 
								true, 
								true, 
								pEvaFuncionalidad);
		
		cmpDateChooser.setDate(pDatValor);
		//cmpDateChooser.setFont(InformacionSession.TIPO_LETRA_CAJA_TEXTO);
		//cmpDateChooser.addKeyListener(pEvaFuncionalidad);
		//cmpDateChooser.setName(pStrNombre);
		cmpDateChooser.setEnabled(pBooHabilitar);
		
		if(pEnmDimension!=null){
			
			cmpDateChooser.setBounds(pEnmDimension.getRectangulo());
			cmpDateChooser.getLblObligatorio().setBounds(pEnmDimension.getRectangulo());
			
			if	(	cmpDateChooser	instanceof	IComponenteEstiloSwing	)	
			{
				iComponenteEstiloSwing	=	(IComponenteEstiloSwing)cmpDateChooser;
			
				if	(	pEnmDimension.getIntArcoX()	>=	0	)
				{
					iComponenteEstiloSwing.setArcw(pEnmDimension.getIntArcoX());
				}
				
				if	(	pEnmDimension.getIntArcoY()	>=	0	)
				{
					iComponenteEstiloSwing.setArch(pEnmDimension.getIntArcoY());
				}
			}
			
			objDimImgBtnCalendario	=	new Dimension(pEnmDimension.getAlto()-2, pEnmDimension.getAlto());
			
		}	else	{
			objDimImgBtnCalendario	=	EnumDimensionesComponentes.IMG_BTN_CALENDARIO.getRectangulo().getSize();
		}
		
		cmpDateChooser.getCalendarButton().setIcon(EnumImagenes.APP_BTN_CALENDARIO.ajustarIcono(objDimImgBtnCalendario));
		
		return cmpDateChooser;
	}
	
	public SeccionUtil crearPanel(EnumDimensionesComponentes pEnmDimension,
								  String pStrNombreComponente,
								  Border pBorde,
								  EnumEtiquetas pEnmTitulo,
								  Integer pIntJustificacionTitulo)throws Exception {

		SeccionUtil cmpPanel;
		
		cmpPanel = new SeccionUtil(pEnmDimension,
								   pStrNombreComponente,
								   pBorde,
								   pIntJustificacionTitulo,
								   pEnmTitulo);

		return cmpPanel;
	}
	
	public SeccionDesplazableUtil crearScroll(String pStrNombreComponente,
			   					   EnumDimensionesComponentes pEnmDimension,
			   					   Border pBorde)throws Exception{

		
		SeccionDesplazableUtil cmpScroll;

		cmpScroll = new SeccionDesplazableUtil(pEnmDimension,
											   pStrNombreComponente,
											   pBorde,
											   null,
											   null);
		return cmpScroll;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo habilitarComponentesContenedorMasivo (Metodo)
  	 * 		   Metodo que habilita o deshabilita todos los 
  	 * 		   componente de un contenedor
  	 * @param pJPanel 
  	 * 		  contenedor sobre el cual se realizara la operacion de 
  	 * 		  habilitacion masiva
  	 * @param pBooHabilitar 
  	 * 		  bandera que permite habilitar o deshabilitar los componentes
  	 * 		  graficos del contenedor recibido
  	 * @param pBooObviarOpuesto
  	 * 		  bandera que permite identificar si la intencion sobre los 
  	 * 		  componentes especificados es de obviar o de aplicar el estado
  	 * 		  opuesto de la bandera de habilitar
  	 * @param pActivaRestablecerValores
  	 * 		  bandera que permite activar el proceso de restablecer los valores
  	 * 		  iniciales para los componentes que se vean afectados por la 
  	 * 		  habilitacion negativa (false - bloquear componente) recibida 
  	 * @param pArrComListadoComponentesObviarOpuesto
  	 * 		  listado de componentes que se obviaran o se realizara el estado
  	 * 		  opuesto al enviado en el proceso de habilitacion masivo
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada  
  	 * @autor CesarO.Rendon
  	 * @RVS-Par Hector Q-en-K
  	 * ****************************************************************
  	 */
	public void habilitarComponentesContenedorMasivo(JPanel pJPanel,
									 				 boolean pBooHabilitar,
									 				 boolean pBooObviarOpuesto,
									 				 boolean pActivaRestablecerValores,
									 				 Component ...pArrComListadoComponentesObviarOpuesto) throws Exception{
		boolean booControl;
		boolean booHabilitarModificado = pBooHabilitar;
		
		if(pArrComListadoComponentesObviarOpuesto!=null){
			
			for (Component objComponente : pJPanel.getComponents()) {
				
				booControl=false;
				booHabilitarModificado = pBooHabilitar;
				
				if(objComponente instanceof JLabel){
					continue;
				}
				
				booControl = this.consultarExistenciaComponente(objComponente,
												   			    pArrComListadoComponentesObviarOpuesto);
				
				if(booControl){
					
					if(pBooObviarOpuesto){//obviar
						continue;
					}else{//aplicar opuesto
						booHabilitarModificado=!pBooHabilitar;
					}
				}
				
				this.habilitarComponenteContenedorMasivo(objComponente,
														 pBooHabilitar,
														 booHabilitarModificado,
														 pBooObviarOpuesto,
														 pActivaRestablecerValores,
														 pArrComListadoComponentesObviarOpuesto);
				
			}
			
		}else{
			for (Component objComponente : pJPanel.getComponents()) {
				
				if(objComponente instanceof JLabel){
					continue;
				}
				
				this.habilitarComponenteContenedorMasivo(objComponente,
						 								 pBooHabilitar,
						 								 booHabilitarModificado,
						 								 pBooObviarOpuesto,
						 								 pActivaRestablecerValores,
						 								 pArrComListadoComponentesObviarOpuesto);
			}
		}
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo habilitarComponenteContenedorMasivo (Metodo)
  	 * 		   Metodo que habilita o deshabilita un componente
  	 * @param pObjComponente 
  	 * 		  componente recibido para habilitar o deshabilitar
  	 * @param pBooHabilitar 
  	 * 		  bandera que permite habilitar o deshabilitar el componente
  	 * 		  recibido
  	 * @param pBooHabilitarModificado
  	 * 		  bandera que detecta si la habilitacion debe ser alterada por
  	 * 		  opuesto o no 
  	 * @param pBooObviarOpuesto
  	 * 		  bandera que permite identificar si la intencion sobre los 
  	 * 		  componentes especificados es de obviar o de aplicar el 
  	 * 		  estado opuesto de la bandera de habilitar
  	 * @param pActivaRestablecerValores
  	 * 		  bandera que permite activar el proceso de restablecer los 
  	 * 		  valores iniciales para los componentes que se vean afectados 
  	 * 		  por la habilitacion negativa o positiva recibida (false o 
  	 * 		  true - inhabilitar o deshabilitar componente)
  	 * @param pArrComListadoComponentesObviar
  	 * 		  listado de componentes que se obviaran en el proceso de 
  	 * 		  habilitacion masiva
	 * @throws Exception 
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
	 * 		   presentada  
  	 * @autor CesarO.Rendon
  	 * @RVS-Par: Hector Q-en-K
  	 * ****************************************************************
  	 */
	private void habilitarComponenteContenedorMasivo(Component pObjComponente,
													 boolean pBooHabilitar,
													 boolean pBooHabilitarModificado,
													 boolean pBooObviarOpuesto,
													 boolean pActivaRestablecerValores,
													 Component ...pArrComListadoComponentesObviar)throws Exception{
		if (pObjComponente instanceof JPanel){
			
			this.habilitarComponentesContenedorMasivo((JPanel) pObjComponente, 
													  pBooHabilitarModificado,//pBooHabilitar,
													  pBooObviarOpuesto,
													  pActivaRestablecerValores,
													  pArrComListadoComponentesObviar);
		}
		
		if(pActivaRestablecerValores &&
				!pBooHabilitarModificado){
			if(pObjComponente instanceof JComboBox){
				
				if(((JComboBox) pObjComponente).getItemCount()>0){
					((JComboBox) pObjComponente).setSelectedIndex(0);
				}
				
			}else if(pObjComponente instanceof JList){
				((JList) pObjComponente).setSelectedIndex(0);
			}else if(pObjComponente instanceof JTextComponent){
				((JTextComponent) pObjComponente).setText("");
			}
		}
		
		pObjComponente.setEnabled(pBooHabilitarModificado);
	}
	
	private boolean consultarExistenciaComponente(Component pObjComponente,
												  Component ...pArrComListadoComponentesObviar)throws Exception{
		
		boolean booEncontrado = false;
		
		for(Component objComponenteObviarOpuesto : pArrComListadoComponentesObviar){
			
			if(pObjComponente.equals(objComponenteObviarOpuesto)){
				
				booEncontrado=true;
				break;
			}
		}
		
		return booEncontrado;
	}
	
	public AreaTextoUtil crearTextArea(EnumDimensionesComponentes pEnmDimension, 
									   String pNombre, 
									   String pValor, 
									   boolean pEnable,
									   boolean pEditable, 
									   boolean pVisible, 
									   EventoAbstracto pEvaFuncionalidad,
									   EnumEtiquetas pEnmEtiNombreCampo,
									   String ...pArrStrParametros) throws Exception{

		AreaTextoUtil pJTextArea;
		
		pJTextArea = new AreaTextoUtil	(	pEnmDimension,
											pEnmEtiNombreCampo,
											pArrStrParametros
										);

		this.crearTextComponent(pJTextArea, 
								pEnmDimension, 
								pNombre, 
								pValor, 
								pEnable, 
								pEditable, 
								pVisible, 
								pEvaFuncionalidad);

		pJTextArea.setLineWrap(true);
		pJTextArea.setWrapStyleWord(true);

		/*if(pEnmDimension!=null){
			
			pJTextArea.getLblObligatorio().setBounds(pEnmDimension.getRectangulo());
		}*/

		return pJTextArea;
	}

	public JProgressBar crearProgressBar(EnumDimensionesComponentes pEnmDimension,
										 String pStrNombre,
										 int pIntValor,
										 int pIntValorMinimo,
										 int pIntValorMaximo,
										 boolean pBooVisible)throws Exception{
		
		JProgressBar cmpProgressBar;
		
		cmpProgressBar = new JProgressBar();
		
		if(pEnmDimension!=null){
		
			cmpProgressBar.setBounds(pEnmDimension.getRectangulo());
		}
		
		cmpProgressBar.setValue(pIntValor);
		cmpProgressBar.setMinimum(pIntValorMinimo);
		cmpProgressBar.setMaximum(pIntValorMaximo);
		cmpProgressBar.setVisible(pBooVisible);
		
		return cmpProgressBar; 
	}

	public JList crearList(String pNombre, 
						   boolean enable,
						   boolean visible, 
						   int seleccionModo, 
						   EventoAbstracto pEvaFuncionalidad) {

		JList cmpList;
		
		cmpList = new JList();
		//jList.setBounds(rectangle);
		cmpList.setOpaque(false);
		cmpList.setFont(InformacionSession.TIPO_LETRA_CAJA_TEXTO);
		cmpList.setName(pNombre);
		cmpList.setEnabled(enable);
		cmpList.setVisible(visible);
		cmpList.setSelectionMode(seleccionModo);
		cmpList.addMouseListener(pEvaFuncionalidad);
		cmpList.addKeyListener(pEvaFuncionalidad);

		return cmpList;
	}
	
	public JComponent validarCamposObligatorios(FormaGenerica pFrmFormaGenerica,
												boolean pBooGenerarExcepcion,
												boolean pBooUbicarFoco)throws Exception{
		
		ComponentesObligatorios cmpObligatorio;
		JComponent objCmpDetectadoSinDiligenciar;
		Component objCmpSiguienteComponente;
		Component objCmpComponenteRaiz;
		FocusTraversalPolicy ftpControlFocos;
		String strNombreCampo;
		boolean booCampoObligatorioSinDiligenciar;
		
		objCmpSiguienteComponente = null;
		objCmpDetectadoSinDiligenciar = null;
		ftpControlFocos = pFrmFormaGenerica.getFocusTraversalPolicy();
		
		objCmpComponenteRaiz = (JComponent)ftpControlFocos.getInitialComponent(pFrmFormaGenerica);
		objCmpSiguienteComponente = objCmpComponenteRaiz;
		
		do{
			
			if(objCmpSiguienteComponente instanceof ComponentesObligatorios
					|| objCmpSiguienteComponente instanceof JTextFieldDateEditor){

				if(objCmpSiguienteComponente instanceof ComponentesObligatorios){
					
					cmpObligatorio = (ComponentesObligatorios)objCmpSiguienteComponente;
					
				}else{
					
					cmpObligatorio = (ComponentesObligatorios)((JTextFieldDateEditor)objCmpSiguienteComponente).getParent();
				}

				if(cmpObligatorio.getLblObligatorio().validaObligatoriedad()){

					//detectado componente obligatorio

					if(cmpObligatorio.getLblObligatorio().getEnmEtiNombreCampo() == null){
						
						strNombreCampo = ((JComponent)cmpObligatorio).getName();
						
					}else{
						
						strNombreCampo = cmpObligatorio.getLblObligatorio().obtenerNombreCampo();
					}
					
					booCampoObligatorioSinDiligenciar = this.validarObligatoriedadCampo((JComponent)cmpObligatorio, 
																						strNombreCampo,
																						pBooGenerarExcepcion, 
																						pBooUbicarFoco);
					if(!booCampoObligatorioSinDiligenciar){
						
						objCmpDetectadoSinDiligenciar = (JComponent)cmpObligatorio;
					}
				}
			}
			
			objCmpSiguienteComponente = ftpControlFocos.getComponentAfter(pFrmFormaGenerica, objCmpSiguienteComponente);
			
		}while(!objCmpSiguienteComponente.equals(objCmpComponenteRaiz));
		
		return objCmpDetectadoSinDiligenciar;
	}
	
	public boolean validarObligatoriedadCampo(Component pComponent,
											  String pStrDescripcionCampo,
											  boolean pBooGenerarExcepcion,
											  boolean pBooUbicarFoco)throws Exception{
		JTextComponent objTextComponent;
		JComboBox objComboBox;
		JDateChooser objDateChooser;
		boolean booResultado=true;

		if(pComponent instanceof JTextComponent){

			objTextComponent = (JTextComponent)pComponent;

			if(objTextComponent.getText().trim().isEmpty()){
				booResultado = false;
			}
			
		}else if(pComponent instanceof JComboBox){

			objComboBox = (JComboBox)pComponent;

			if(objComboBox.getSelectedItem().equals(EnumEtiquetas.LBL_NO_SELECCIONADO)){
				booResultado = false;
			}
			
		}else if(pComponent instanceof JDateChooser){

			objDateChooser = (JDateChooser)pComponent;

			if(objDateChooser.getDate()==null){
				booResultado = false;
			}
			
			pComponent = (JTextFieldDateEditor)objDateChooser.getDateEditor();
		}

		if(!booResultado 
				&& pBooUbicarFoco){
			
			pComponent.requestFocus();
		}

		if(pBooGenerarExcepcion 
				&& !booResultado){

			pStrDescripcionCampo = UtilHtml.removerEstructuraHtml(pStrDescripcionCampo);

			throw EnumMensajes.CAMPO_OBLIGATORIO_FORMULARIO.generarExcepcion(EnumClasesMensaje.ERROR, 
																			 pStrDescripcionCampo.replaceAll(":|\\*|(\\s)+$", ""));
		}

		return booResultado;
	}

	public void restablecerComponentes(Component ...pArrJComponent)throws Exception{
		
		CajaIncrementoUtil objCajaIncrementoUtil;
		
		for(Component objComponent : pArrJComponent){
			
			if(objComponent instanceof JTextComponent){
				
				((JTextComponent)objComponent).setText("");
				
			}else if(objComponent instanceof JComboBox){
				
				((JComboBox)objComponent).setSelectedItem(EnumEtiquetas.LBL_NO_SELECCIONADO);
				
			}else if(objComponent instanceof JDateChooser){
				
				((JDateChooser)objComponent).setDate(UtilIntegracionSlimGiros.getInstance().obtenerFechaHoraActualPosSlim());
				
			}else if(objComponent instanceof CajaIncrementoUtil){
				
				objCajaIncrementoUtil = (CajaIncrementoUtil)objComponent;
				
				objCajaIncrementoUtil.setValue(objCajaIncrementoUtil.getValorInicial());
			}
		}
	}
	
	public void activaObligatoriedad(Component pComponente, 
									 ObligatoriedadUtil pLblObligatorio){
		boolean booVisible;
		
		if(pLblObligatorio != null){
			
			booVisible = false;
			
			if(pComponente.isVisible() 
					&& pComponente.isEnabled()){
				
				if(pComponente instanceof JTextComponent 
						&& ((JTextComponent)pComponente).isEditable()
						|| !(pComponente instanceof JTextComponent)){
					
					booVisible = true;
				}
			}
			
			pLblObligatorio.setVisible(booVisible);
		}
	}
	
	public void validaAdicionComponenteContenedor(Component pObjComponente,
												  Container pObjContenedor)throws Exception{
		
		Rectangle recDimensionSeccion;
		Rectangle recDimensionComponenteAdicionado;
		int intTamanoHorizontal;
		int intTamanoVertical;
		
		recDimensionSeccion = pObjContenedor.getBounds();
		recDimensionComponenteAdicionado = pObjComponente.getBounds();
		
		if(FormaLogin.estadoAplicacion.equals(EstadoAplicacionEnum.DESARROLLO)){
		
			intTamanoHorizontal = recDimensionComponenteAdicionado.width;
			intTamanoVertical = recDimensionComponenteAdicionado.height;
			
			if(pObjContenedor.getLayout() == null){
				
				intTamanoHorizontal += recDimensionComponenteAdicionado.x;
				intTamanoVertical += recDimensionComponenteAdicionado.y;
			}
			
			if(intTamanoHorizontal>recDimensionSeccion.width
					|| intTamanoVertical>recDimensionSeccion.height){
				
				EnumMensajes.COMPONENTE_SUPERA_MARCO_DE_CONTENEDOR_DESPLAZABLE.desplegarMensaje(null, 
																								EnumClasesMensaje.ADVERTENCIA,
																								pObjComponente.getName(),
																								pObjContenedor.getName(),
																								String.valueOf(recDimensionSeccion.width),
																								String.valueOf(recDimensionSeccion.height),
																								String.valueOf(recDimensionComponenteAdicionado.width),
																								String.valueOf(recDimensionComponenteAdicionado.height));
			}
		}
	}
}
