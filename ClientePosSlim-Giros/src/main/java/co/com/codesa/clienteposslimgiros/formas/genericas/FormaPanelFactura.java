package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelFactura;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ****************************************************************.
 * @autor: CesarO.Rendon
 * @fecha: 06/03/2015
 * @descripcion: Clase de forma generica para direccion el constructor recibe
 * el evento foco para poder hacer devolucion de foco.
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaPanelFactura extends SeccionUtil{

	private static final long serialVersionUID = 1L;

	private EtiquetaUtil lblDocumento;
	private EtiquetaUtil lblNumero;
	private CajaTextoUtil txtDocumento;
	private CajaTextoUtil txtProducto;
	private CajaTextoUtil txtNumero;
	
	private FormaGenerica formaPadre;
	private EventoFormaPanelFactura evaFrmPnlFactura;
	
	public FormaPanelFactura(FormaGenerica pFormaPadre,
							 EnumDimensionesComponentes pRecPanel,
							 String pStrNombreComponente) throws Exception{

		super	(	pRecPanel,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);

		this.formaPadre = pFormaPadre;
		this.evaFrmPnlFactura = new EventoFormaPanelFactura(this);

		super.setBooAplicarTransparenciaFondo(true);
		
		this.inicializarForma(pRecPanel,
							  pStrNombreComponente);
	}

	private void inicializarForma(EnumDimensionesComponentes pRecPanel,
								  String pStrNombreComponente)throws Exception{
		
		this.setLayout(null);
		this.setName(pStrNombreComponente);
		this.setBounds(pRecPanel.getRectangulo());

		this.iniciarDimensiones(pRecPanel.getRectangulo());
		this.add(this.iniciarPropLblDocumento());
		this.add(this.iniciarPropTxtProducto());
		this.add(this.iniciarPropTxtDocumento());
		this.add(this.iniciarPropLblNumero());
		this.add(this.iniciarPropTxtNumero());
	}
	
	public void iniciarDimensiones(Rectangle pRecPanel)throws Exception{
		int intAnchoMaximo;
		int intDiferenciaLibre;
		int intAnchoDisponible;
		
		intAnchoMaximo = EnumDimensionesComponentes.TXT_PNL_FACT_NUMERO.getRectangulo().x + EnumDimensionesComponentes.TXT_PNL_FACT_NUMERO.getRectangulo().width;
		intDiferenciaLibre = (pRecPanel.width - intAnchoMaximo)-5;
		intAnchoDisponible = intDiferenciaLibre/3;
		
		EnumDimensionesComponentes.TXT_PNL_FACT_PRODUCTO.getRectangulo().width += intAnchoDisponible;
		
		EnumDimensionesComponentes.TXT_PNL_FACT_DOCUMENTO.getRectangulo().x += intAnchoDisponible;
		EnumDimensionesComponentes.TXT_PNL_FACT_DOCUMENTO.getRectangulo().width += intAnchoDisponible;
		
		EnumDimensionesComponentes.LBL_PNL_FACT_NUMERO.getRectangulo().x += intAnchoDisponible*2;
		EnumDimensionesComponentes.TXT_PNL_FACT_NUMERO.getRectangulo().x += intAnchoDisponible*2;
		EnumDimensionesComponentes.TXT_PNL_FACT_NUMERO.getRectangulo().width += intAnchoDisponible;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtNumero
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtNumero
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtNumero()throws Exception{
		
		if(this.txtNumero==null){
			
			this.txtNumero = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_FACT_NUMERO, 
																		 	 "txtNumero", 
																		 	 null, 
																		 	 true, 
																		 	 false, 
																		 	 true, 
																		 	 null,
																		 	 null);
			this.txtNumero.setToolTipText(EnumEtiquetas.TLT_PNL_FACT_NUMERO);
		}
		
		return this.txtNumero;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtProducto
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtProducto
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtProducto()throws Exception{
		
		if(this.txtProducto==null){
			
			this.txtProducto = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_FACT_PRODUCTO, 
																		       "txtProducto", 
																		       null, 
																		       true, 
																		       false, 
																		       true, 
																		       null,
																		       null);
			
			this.txtProducto.setToolTipText(EnumEtiquetas.TLT_PNL_FACT_PRODUCTO);
		}
		
		return this.txtProducto;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtDocumento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtDocumento
  	 * @return CajaTextoUtil
  	 * 		   caja de texto gestionada
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtDocumento()throws Exception{
		
		if(this.txtDocumento==null){
			
			this.txtDocumento = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_PNL_FACT_DOCUMENTO, 
																			    "txtDocumento", 
																			    null, 
																			    true, 
																			    false, 
																			    true, 
																			    null,
																			    null);
			this.txtDocumento.setToolTipText(EnumEtiquetas.TLT_PNL_FACT_DOCUMENTO);
		}
		
		return this.txtDocumento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblDocumento
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblDocumento
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblDocumento()throws Exception{

		if(this.lblDocumento == null){

			this.lblDocumento = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_FACT_DOCUMENTO,
																		    "lblDocumento",
																		    EnumEtiquetas.LBL_PNL_FACT_DOCUMENTO,
																		    true,
																		    null, 
																		    true);	
		}
		
		return this.lblDocumento;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblNumero
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblNumero
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblNumero()throws Exception{

		if(this.lblNumero == null){

			this.lblNumero = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_FACT_NUMERO,
																	     "lblNumero",
																	     EnumEtiquetas.LBL_PNL_FACT_NUMERO,
																	     true,
																	     null, 
																	     true);	
		}
		
		return this.lblNumero;
	}
	
	public FormaGenerica getFormaPadre() {
		return formaPadre;
	}

	public void setFormaPadre(FormaGenerica formaPadre) {
		this.formaPadre = formaPadre;
	}

	public EtiquetaUtil getLblDocumento() {
		return lblDocumento;
	}

	public void setLblDocumento(EtiquetaUtil lblDocumento) {
		this.lblDocumento = lblDocumento;
	}

	public EtiquetaUtil getLblNumero() {
		return lblNumero;
	}

	public void setLblNumero(EtiquetaUtil lblNumero) {
		this.lblNumero = lblNumero;
	}

	public CajaTextoUtil getTxtDocumento() {
		return txtDocumento;
	}

	public void setTxtDocumento(CajaTextoUtil txtDocumento) {
		this.txtDocumento = txtDocumento;
	}

	public CajaTextoUtil getTxtProducto() {
		return txtProducto;
	}

	public void setTxtProducto(CajaTextoUtil txtProducto) {
		this.txtProducto = txtProducto;
	}

	public CajaTextoUtil getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(CajaTextoUtil txtNumero) {
		this.txtNumero = txtNumero;
	}

	public EventoFormaPanelFactura getEvaFrmPnlFactura() {
		return evaFrmPnlFactura;
	}

	public void setEvaFrmPnlFactura(EventoFormaPanelFactura evaFrmPnlFactura) {
		this.evaFrmPnlFactura = evaFrmPnlFactura;
	}

	public void limpiarForma(){
		if(txtDocumento!=null)
			txtDocumento.setText(null);

		if(txtProducto!=null)
			txtProducto.setText(null);

		if(txtNumero!=null)
			txtNumero.setText(null);
	}

	public static void main(String[] args) {
		
		try{
			
			//TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 900, 500);
			
			FormaPanelFactura forma;
			
			forma = new FormaPanelFactura(null,
					EnumDimensionesComponentes.PNL_PG_ENCABEZADO_FACTURA,
					"forma");
			
			forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}