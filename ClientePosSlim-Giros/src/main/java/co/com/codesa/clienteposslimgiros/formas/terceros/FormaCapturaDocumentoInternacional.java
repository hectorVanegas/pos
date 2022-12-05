package co.com.codesa.clienteposslimgiros.formas.terceros;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.terceros.EventoFormaCapturaDocumentosInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerceroInternacional;

/**
 * 
 * ********************************************************************
 * @class	FormaCapturaDocumentoInternacional
 *		 	Forma encargada de gestionar la captura de documento
 *			anverso y reverso del documento de identificacion del 
 *			usuario en las remesas internacionales
 * @author	stiven.garcia
 * @date  	26/03/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaCapturaDocumentoInternacional extends FormaGenerica{
	
	/**
	 * @variable cmbTipoImagenDocumento
	 * 			 componente de combo sobre la forma que  contiene el listado 
	 * 		     de tipos de imagen de documento a capturar
	 **/
	private CajaComboUtil cmbTipoImagenDocumento;
	
	/**
	 * @variable btnCapturaImg
	 * 			 componente boton sobre la forma para manejar la funcionalida de capturar imagen
	 **/
	private BotonUtil btnCapturaImg;
	
	/**
	 * @variable	lblInformacionCaptura
	 * 				etiqueta para indicar que debe presionar la imagen
	 * 				de la camara para tomar las fotos del documento.
	 */
	private EtiquetaUtil lblInformacionCaptura;
	
	private TerceroInternacional objTerceroInternacional;
	
	private String strIdTransaccion;
	
	private boolean booIsCapturaAnverso;
	
	private boolean booIsCapturaReverso;
	
	
	/**
	 * 
	 * ********************************************************************
	 * @method	FormaCapturaDocumentoInternacional
	 * 		  	[TODO - DOC]: Descripcion del metodo constructor, importante 
	 *		  	mencionar la intencion de una sobrecarga, el despliegue de 
	 *		  	comportamientos de interes y otros
	 * @param pFrmPadre
	 * 			Forma padre que invoca el procesamiento de captura de imagenes
	 * @param pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
	 * @throws Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	stiven.garcia
	 * @date	26/03/2018
	 * *********************************************************************
	 */
	public FormaCapturaDocumentoInternacional(	FormaGenerica pFrmPadre, 
												boolean pBooModal, 
												TerceroInternacional objTerceroInternacional,
												String strIdTransaccion
											 ) throws Exception {
		super(pFrmPadre, pBooModal);
		super.setEventoForma(new EventoFormaCapturaDocumentosInternacional(this));
		this.setObjTerceroInternacional(objTerceroInternacional);
		this.setStrIdTransaccion(strIdTransaccion);
		this.inicializarForma();
	}

	/**
	 * @variable	serialVersionUID
	 * 				[TODO - DOC]: Descripcion de la variable, su intencion, proposito
	 *				objetivo
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {

		super.setTituloForma(EnumEtiquetas.TTL_CDI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_CDI_VENTANA.getAncho());//AJUSTAR DIMENSION
		super.setAltoForma(EnumDimensionesComponentes.GUI_CDI_VENTANA.getAlto());//AJUSTAR DIMENSION
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
						  		EnumBotonesEncabezado.BTNVOLVER
						  		);
		
		super.iniciar(pArrObjParametrosForma);
		
	}
	
	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_CDI_CUERPO,//AJUSTAR DIMENSION
																"pnlCuerpo",
	  													 	 	null,
	  													 	 	null,
	  													 	 	null);
		pnlCuerpo.add(this.iniciarPropLblInformacionCaptura());
		pnlCuerpo.add(this.iniciarPropCmbTipoImagenDocumento());
		pnlCuerpo.add(this.iniciarPropBtnCapturaImg());
		
		return pnlCuerpo;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblNombreConyuge
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblNombreConyuge
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	10/05/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblInformacionCaptura() throws Exception{
		
		this.lblInformacionCaptura = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.TTL_CDI_INFORMACION_CAPTURA, 
				   												   	   		"lblInformacionCaptura", 
				   												   	   		EnumEtiquetas.TTL_FOTOS_INFORMACION_CAPTURA,
				   												   	   		false,
				   												   	   		null,
				   												   	   		true);
		
		return this.lblInformacionCaptura;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropCmbTipoImagenDocumento
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	cmbTipoImagenDocumento
	 * @return	CajaComboUtil
	 * 			Lista de valores gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	stiven.garcia
	 * @date   	26/03/2018
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoImagenDocumento() throws Exception{
		
		if (this.cmbTipoImagenDocumento == null) {
			
			this.cmbTipoImagenDocumento = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_CDI_CAPTURA_IMAGEN, 
																		  	  "cmbTipoImagenDocumento", 
																		  	  true, 
																		  	  true, 
																		  	  super.getEventoForma(),
																		  	  null
																		  	  );
		}
		
		return cmbTipoImagenDocumento;
	}
	
	/**
     * ****************************************************************
     * @method iniciarPropBtnCapturaImg
     * 		   metodo utilizado para inicializar el componente BotonUtil 
     * 		   para validar la huella
     * @return BotonUtil
     *         componente BotonUtil
     * @throws Exception
     * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
     * @author roberth.martinez
     * @date   07/08/2018
     * ****************************************************************
     */	
	public BotonUtil iniciarPropBtnCapturaImg() throws Exception{
		if (this.btnCapturaImg == null) {
			this.btnCapturaImg = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_CDI_CAPTURA_IMAGEN, 
																	      "btnCapturaImg", 
																	      null, //EnumEtiquetas.BTN_VMS_CAPTURAR_IMG, 
																	      true, 
																	      true, 
																	      super.getEventoForma(),  
																	      EnumImagenes.APP_POS_CAPTURA_IMG.ajustarIcono(new Dimension(70, 50)));
			
			
			this.btnCapturaImg.setBorder(BorderFactory.createEmptyBorder());
			this.btnCapturaImg.setBooAplicarSinFondo(false);
		}

		return this.btnCapturaImg;
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public CajaComboUtil getCmbTipoImagenDocumento() {
		return this.cmbTipoImagenDocumento;
	}

	public void setCmbTipoImagenDocumento(CajaComboUtil pCmbTipoImagenDocumento) {
		this.cmbTipoImagenDocumento = pCmbTipoImagenDocumento;
	}

	public BotonUtil getBtnCapturaImg() {
		return this.btnCapturaImg;
	}

	public void setBtnCapturaImg(BotonUtil pBtnCapturaImg) {
		this.btnCapturaImg = pBtnCapturaImg;
	}	
	
	public TerceroInternacional getObjTerceroInternacional() {
		return objTerceroInternacional;
	}

	public void setObjTerceroInternacional(TerceroInternacional objTerceroInternacional) {
		this.objTerceroInternacional = objTerceroInternacional;
	}

	public String getStrIdTransaccion() {
		return strIdTransaccion;
	}

	public void setStrIdTransaccion(String strIdTransaccion) {
		this.strIdTransaccion = strIdTransaccion;
	}

	public boolean isBooIsCapturaAnverso() {
		return booIsCapturaAnverso;
	}

	public void setBooIsCapturaAnverso(boolean booIsCapturaAnverso) {
		this.booIsCapturaAnverso = booIsCapturaAnverso;
	}

	public boolean isBooIsCapturaReverso() {
		return booIsCapturaReverso;
	}

	public void setBooIsCapturaReverso(boolean booIsCapturaReverso) {
		this.booIsCapturaReverso = booIsCapturaReverso;
	}
	
	public EtiquetaUtil getLblInformacionCaptura() {
		return lblInformacionCaptura;
	}

	public void setLblInformacionCaptura(EtiquetaUtil lblInformacionCaptura) {
		this.lblInformacionCaptura = lblInformacionCaptura;
	}

	public static void main(String args[]) {
		
		try{
		    
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaCapturaDocumentoInternacional.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			
			String idTransaccion = "1234";
			TerceroInternacional tercero = new TerceroInternacional();
			tercero.setIdentificacion("123456");
			new FormaCapturaDocumentoInternacional(null,true,tercero,idTransaccion);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
		
	}

}
