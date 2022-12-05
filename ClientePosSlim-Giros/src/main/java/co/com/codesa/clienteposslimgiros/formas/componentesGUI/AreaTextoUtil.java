package co.com.codesa.clienteposslimgiros.formas.componentesGUI;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import co.com.codesa.clienteposslim.vista.JScrollPaneRound;
import co.com.codesa.clienteposslim.vista.JTextAreaRound;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.componentesGUI.EventoCompTextoUtil;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUITexto;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponentesObligatorios;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.PropiedadesTexto;
import co.com.codesa.clienteposslimgiros.interfaces.componentesGUI.ComponenteGUI;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 10-abr-2015 
 * @clase AreaTextoUtil
 * 		  Clase encargada de emular el comportamiento de un JTextField
 * 		  adicionando una serie de aspectos y/o utilidades de interes
 * @copyright Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class AreaTextoUtil extends JTextAreaRound implements ComponenteGUI, ComponentesObligatorios, ComponenteGUITexto {
	
	private static final long serialVersionUID = -1284688714974852986L;
	
	private ObligatoriedadUtil lblObligatorio;
	
	private PropiedadesTexto propiedades;
	
	/**
  	 * ****************************************************************.
  	 * @metodo 	CajaTextoUtil
  	 * 		   	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de sus acciones
  	 * @param 	pEnmDimension
	 * 			Constante de enumeracion que especifica la dimension a la 
	 * 			cual estara sometida el componente grafico en cuestion
  	 * @param 	pEnmEtiNombreCampo
  	 * 		  	Etiqueta que identifica el nombre del componente dentro de 
  	 * 		  	la funcionalidad en cuestion 
  	 * @param 	pArrStrParametros
  	 * 		  	Listado de parametros que alimentan la etiqueta que 	
  	 * 		  	identifica el nombre del componente
  	 * @throws 	Exception 
  	 * 		   	Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
  	 * @autor 	Hector Q-en-K
  	 * ****************************************************************
  	 */
	public AreaTextoUtil(	EnumDimensionesComponentes pEnmDimension,
							EnumEtiquetas pEnmEtiNombreCampo,
						 	String ...pArrStrParametros) throws Exception{
		
		super();
		
		this.inicializarAspectos(	pEnmDimension,
									EnumColores.GNRL_CONTORNO,
									pEnmEtiNombreCampo,
									pArrStrParametros
								);
	}
	
	private void inicializarAspectos(	EnumDimensionesComponentes pEnmDimension,
										EnumColores pEnmColContorno,
										EnumEtiquetas pEnmEtiNombreCampo,
										String ...pArrStrParametros
									)	throws	Exception
	{	
		super.setColorContorno(pEnmColContorno.getColColor());
		
		EventoCompTextoUtil evaCmpTextoUtil = new EventoCompTextoUtil(this);
		
		this.addKeyListener(evaCmpTextoUtil);
		this.addMouseListener(evaCmpTextoUtil);
		this.addFocusListener(evaCmpTextoUtil);
		
		this.lblObligatorio = new ObligatoriedadUtil(pEnmEtiNombreCampo,
													 pArrStrParametros);
		
		this.propiedades = evaCmpTextoUtil;
		
		UtilidadesGiros.getInstance().setTransferHandlerComponet(this);
	}

	@Override
	public void setVisible(boolean pBooVisible) {
		
		super.setVisible(pBooVisible);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
														  this.lblObligatorio);
	}
	
	@Override
	public void setEnabled(boolean pBooEnabled) {
		
		/*
		super.setEnabled(pBooEnabled);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
				  										  this.lblObligatorio);
		*/
		
		this.setEditable(pBooEnabled);
		this.setFocusable(pBooEnabled);
	}
	
	@Override
	public void setEditable(boolean pBooEditable) {
		
		super.setEditable(pBooEditable);
		this.setFocusable(pBooEditable);
		
		UtilComponentesGUI.getInstance().activaObligatoriedad(this, 
				  										  this.lblObligatorio);
	}
	
	@Override
	public void setText(String pStrTexto) {
		
		super.setText(pStrTexto);
		super.setCaretPosition(0);
	}
	
	@Override
	public void setValorContenido(Object pObjeto)throws Exception{
	
		this.setText(pObjeto.toString());
	}
	
	@Override
	public ObligatoriedadUtil getLblObligatorio() {
		return lblObligatorio;
	}

	@Override
	public void setLblObligatorio(ObligatoriedadUtil lblObligatorio) {
		this.lblObligatorio = lblObligatorio;
	}

	@Override
	public PropiedadesTexto getPropiedades() {
		return propiedades;
	}
	
	@Deprecated
	@Override
	public void setToolTipText(String text) {
		super.setToolTipText(text);
	}
	
	public JScrollPane getScpContenedorRound(	EnumDimensionesComponentes	pObjRecDimension	) 
	{
		JScrollPane	scpContenedor;
		
		if	(	pObjRecDimension == null	)
		{
			scpContenedor	=	super.getScpContenedor();
			
		}	else	{
			
			scpContenedor	=	super.getScpContenedor	(	pObjRecDimension.getRectangulo()	);
		}
		
		this.setBorder(BorderFactory.createEmptyBorder());
		
		return scpContenedor;
	}
	
	@Override
	public void setToolTipText(EnumEtiquetas pEnmEtiquetas,
							   String ...pArrStrParametros){
		
		UtilidadesGiros.getInstance().setToolTipText(this, 
				 									 pEnmEtiquetas, 
				 									 pArrStrParametros);
	}
	
	@Override
	protected	void	crearContenedor() {
		
		JScrollPaneRound	scpComponente;
		
		try{
			
			scpComponente	=	new SeccionDesplazableUtil	(	null,//pEnmDimension, 
																"scp"+this.getName(),//pStrNombreComponente, 
																null,//pBorde, 
																null,//pIntJustificacionTitulo, 
																null//pEnmTitulo, 
																//pArrStrParametrosTitulo
															);
			super.setScpContenedor(scpComponente);
			
		}catch(Exception e){
			
			super.crearContenedor();
		}
	}
}
