package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelCajaTextoProtegida;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaClaveUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaVerificadaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaPanelCajaTextoProtegida extends SeccionUtil{

	private static final long serialVersionUID = -7734858279144273094L;
	
	private CajaClaveUtil pfiCajaClave;
	private CajaVerificadaUtil chkMostrarContenidoProtegido;
	
	private FormaGenerica frmGnrVentana;
	private EventoFormaPanelCajaTextoProtegida evaFrmPnlCajaTextoProtegida;
	
	public FormaPanelCajaTextoProtegida(FormaGenerica pFrmGnrVentanaPadre,
							   EnumDimensionesComponentes pEnmDimension,
			  				   String pStrNombreComponente,
			  				   EnumEtiquetas pEnmEtiNombreCampo,
			  				   String ...pArrStrParametros) throws Exception {
		
		super	(	pEnmDimension,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);
		
		this.inicializarAspectos(pFrmGnrVentanaPadre,
								 pEnmDimension,
								 pEnmEtiNombreCampo,
								 pArrStrParametros);
	}
	
	private void inicializarAspectos(FormaGenerica pFrmGnrVentana,
									 EnumDimensionesComponentes pEnmDimension,
									 EnumEtiquetas pEnmEtiNombreCampo,
					  				 String ...pArrStrParametros)throws Exception{
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.frmGnrVentana = pFrmGnrVentana;
		this.evaFrmPnlCajaTextoProtegida = new EventoFormaPanelCajaTextoProtegida(this);
		
		this.add(this.iniciarPropChkMostrarContenidoProtegido(pEnmDimension));
		
		this.add(this.iniciarPropPfiCajaClave	(	pEnmDimension,
		 		  									pEnmEtiNombreCampo,
		 		  									pArrStrParametros
		 		  								));
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPfiCajaClave
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiCajaClave
  	 * @return CajaClaveUtil
  	 * 		   caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaClaveUtil iniciarPropPfiCajaClave(EnumDimensionesComponentes pEnmDimension,
												 EnumEtiquetas pEnmEtiNombreCampo,
												 String ...pArrStrParametros)throws Exception {
		Rectangle recDimensionPfiCajaProtegida;
		Rectangle recDimension;
		
		if(this.pfiCajaClave==null){
			
			recDimension = pEnmDimension.getRectangulo();
			recDimensionPfiCajaProtegida = EnumDimensionesComponentes.PFI_PCC_CAJA_PROTEGIDA.getRectangulo();
			
			recDimensionPfiCajaProtegida.setBounds(new Rectangle(recDimensionPfiCajaProtegida.getBounds().x,
																 recDimensionPfiCajaProtegida.getBounds().y,
																 recDimension.width-recDimensionPfiCajaProtegida.getBounds().x-(recDimension.width-this.getChkMostrarContenidoProtegido().getBounds().x)-5,//-10-30
																 recDimension.height));
			
			this.pfiCajaClave = UtilComponentesGUI.getInstance().crearPasswordField(EnumDimensionesComponentes.PFI_PCC_CAJA_PROTEGIDA, 
																				 	"pfiCajaClave", 
																				 	null, 
																				 	true, 
																				 	true, 
																				 	true, 
																				 	this.evaFrmPnlCajaTextoProtegida,
																				 	pEnmEtiNombreCampo,
																				 	pArrStrParametros);
		}
		
		return this.pfiCajaClave;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropChkMostrarContenidoProtegido
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   chkMostrarContenidoProtegido
  	 * @return CajaVerificadaUtil
  	 * 		   Caja de seleccion gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaVerificadaUtil iniciarPropChkMostrarContenidoProtegido(EnumDimensionesComponentes pEnmDimension) throws Exception{
		
		Rectangle recDimensionChkMostrarContenidoProtegido;
		Rectangle recDimension;
		
		if (this.chkMostrarContenidoProtegido == null) {
			
			recDimension = pEnmDimension.getRectangulo();
			
			recDimensionChkMostrarContenidoProtegido = EnumDimensionesComponentes.CHK_PCC_MOSTRAR_CONTENIDO_PROTEGIDO.getRectangulo();
			
			recDimensionChkMostrarContenidoProtegido.setBounds(new Rectangle(recDimension.width-5-recDimensionChkMostrarContenidoProtegido.width,//recDimensionCajaProtegida.x+recDimensionCajaProtegida.width+5,
					 							 		   					 0,
					 							 		   					 recDimensionChkMostrarContenidoProtegido.width,
					 							 		   					 recDimensionChkMostrarContenidoProtegido.height));
			
			this.chkMostrarContenidoProtegido = UtilComponentesGUI.getInstance().crearCheckBox(EnumDimensionesComponentes.CHK_PCC_MOSTRAR_CONTENIDO_PROTEGIDO, 
																		   		   		   	   "chkMostrarContenidoProtegido", 
																		   		   		   	   null, 
																		   		   		   	   false,
																		   		   		   	   true, 
																		   		   		   	   true, 
																		   		   		   	   false, 
																		   		   		   	   this.evaFrmPnlCajaTextoProtegida,
																		   		   		   	   SwingConstants.TRAILING,
																		   		   		   	   true);	
			
			this.chkMostrarContenidoProtegido.setToolTipText(EnumEtiquetas.LBL_VER_CONSTRASENA);
			this.chkMostrarContenidoProtegido.setFocusable(false);
		}

		return this.chkMostrarContenidoProtegido;
	}
	
	public void limpiar	()
			throws Exception
	{
		this.getPfiCajaClave ().setText ( "" );
		this.chkMostrarContenidoProtegido.setSelected ( false );
	}

	public CajaClaveUtil getPfiCajaClave() {
		return pfiCajaClave;
	}

	public void setPfiCajaClave(CajaClaveUtil pfiCajaClave) {
		this.pfiCajaClave = pfiCajaClave;
	}

	public CajaVerificadaUtil getChkMostrarContenidoProtegido() {
		return chkMostrarContenidoProtegido;
	}

	public void setChkMostrarContenidoProtegido(
			CajaVerificadaUtil chkMostrarContenidoProtegido) {
		this.chkMostrarContenidoProtegido = chkMostrarContenidoProtegido;
	}
	
	public FormaGenerica getFrmGnrVentana() {
		return frmGnrVentana;
	}

	public void setFrmGnrVentana(FormaGenerica frmGnrVentana) {
		this.frmGnrVentana = frmGnrVentana;
	}

	public static void main(String args[]){
		
		try {
			
			//TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelCajaTextoProtegida forma;
			
			forma = new FormaPanelCajaTextoProtegida(null,
											EnumDimensionesComponentes.PNL_PG_TERC_TERCERO_DESTINO,
											"forma",
											EnumEtiquetas.LBL_CMB_CNTRSN_CONFIRMA_CONTRASENA);
			
			forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
