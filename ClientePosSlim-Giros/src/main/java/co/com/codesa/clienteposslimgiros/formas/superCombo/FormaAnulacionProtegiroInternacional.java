package co.com.codesa.clienteposslimgiros.formas.superCombo;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.superCombo.EventoFormaAnulacionProtegiroInternacional;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.pago.FormaConsultaGiroInternacional;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


/** 
 * ********************************************************************
 * @class	FormaAnulacionProtegiroInternacional
 *		 	Clase para realizar la anulacion protegiro internacional 
 * @author	roberth.martinez
 * @date  	30/04/2018
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaAnulacionProtegiroInternacional extends FormaGenerica{

	/**
	 * @variable serialVersionUID
	 * 			 variable serial
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @variable	pnlInfoRemensa
	 * 				panel datos de la anulacion
	 */
	private SeccionUtil pnlInfoRemensa;
	
	/**
	 * @variable	lblReferenciaSeguro
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label de referencia del seguro
	 */
	private EtiquetaUtil lblReferenciaSeguro;
	
	/**
	 * @variable	lblvlrDelGiro
	 * 				etiqueta para indicar el componente grafico sobre la forma que 
	 * 			 	indica label valor del giro
	 */
	private EtiquetaUtil lblvlrDelGiro;
	
	/**
	 * @variable	txtReferenciaSeguro
	 * 				campo de texto sobre la forma para diligenciar el tipo 
	 * 				de referencia del seguro
	 */
	private CajaTextoUtil txtReferenciaSeguro;
	
	/**
	 * @variable	txtvlrDelGiro
	 * 				campo de texto sobre la forma para diligenciar el valor del giro
	 */
	private CajaTextoUtil txtvlrDelGiro;

	/**
	 * ********************************************************************
	 * @method	FormaAnulacionProtegiroInternacional
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
  	 * 		   	ejecucion de comportamientos inicales requeridos para el 
  	 * 		   	despliegue de la forma FormaAnulacionProtegiroInternacional
	 * @param 	pFrmPadre
	 * 			ventana de la cual extiende esta forma
	 * @param 	pBooModal
	 * 			bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  	la ventana de la cual extiende
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	public FormaAnulacionProtegiroInternacional(JFrame pFrmPadre, 
								 	   			boolean pBooModal) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaAnulacionProtegiroInternacional(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_ASGI_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_ASGI_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_ASGI_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNSALIR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_ASGI_ENCABEZADO,
																	"pnlEncabezado",
		  														 	BorderFactory.createEmptyBorder(),
		  														 	null,
		  														 	null);
		
		pnlEncabezado.add(this.iniciarPropPnlInfoRemensa());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		return null;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/** 
	 * ********************************************************************
	 * @method	iniciarPropPnlInfoRemensa
	 * 		  	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	pnlInfoRemensa
	 * @return	SeccionUtil
	 * 			seccion de cuerpo gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 * *********************************************************************
	 */
	public SeccionUtil iniciarPropPnlInfoRemensa() throws Exception{
		
		if(this.pnlInfoRemensa==null){
			
			this.pnlInfoRemensa = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_ASGI_INFO_REMESA,
																			  "pnlInfoRemensa",
																  		  	  null,
																  		  	  EnumEtiquetas.TTL_ASGI_PNL_INFO_REMESA,
																  		  	  null);
			
			this.pnlInfoRemensa.add(iniciarPropLblReferenciaSeguro());
			this.pnlInfoRemensa.add(iniciarPropTxtReferenciaSeguro());
			this.pnlInfoRemensa.add(iniciarPropLblvlrDelGiro());
			this.pnlInfoRemensa.add(iniciarPropTxtvlrDelGiro());
			
		}
		
		return this.pnlInfoRemensa;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblReferenciaSeguro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblReferenciaSeguro
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	30/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblReferenciaSeguro() throws Exception{
		
		this.lblReferenciaSeguro = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ASGI_REFERENCIA_SEGURO, 
				   												   	   		   "lblReferenciaSeguro", 
				   												   	   		   EnumEtiquetas.LBL_ASGI_REFERENCIA_SEGURO,
				   												   	   		   false,
				   												   	   		   null,
				   												   	   		   true);
		
		return this.lblReferenciaSeguro;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtReferenciaSeguro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtReferenciaSeguro
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	22/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtReferenciaSeguro()throws Exception{
		
		this.txtReferenciaSeguro = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_ASGI_REFERENCIA_SEGURO, 
																				   "txtReferenciaSeguro", 
																				   "",
																				   true, 
																				   true, 
																				   true, 
																				   super.getEventoForma(),
																				   EnumEtiquetas.LBL_ASGI_REFERENCIA_SEGURO);
		return this.txtReferenciaSeguro;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropLblvlrDelGiro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	lblvlrDelGiro
	 * @return	EtiquetaUtil
	 * 			Etiqueta gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	30/04/2018
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblvlrDelGiro() throws Exception{
		
		this.lblvlrDelGiro = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_ASGI_VALOR_GIRO, 
																		 "lblvlrDelGiro", 
																		 EnumEtiquetas.LBL_ASGI_VALOR_GIRO,
																		 false,
																		 null,
																		 true);
		
		return this.lblvlrDelGiro;
	}
	
	/** 
	 * ********************************************************************
	 * @method 	iniciarPropTxtvlrDelGiro
	 * 		   	Metodo estandar para autogestionar el valor del atributo 
  	 * 		   	txtvlrDelGiro
	 * @return	CajaTextoUtil
	 * 			Caja de texto gestionada
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada 
	 * @author 	roberth.martinez
	 * @date   	30/04/2018
	 * *********************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtvlrDelGiro()throws Exception{
		
		this.txtvlrDelGiro = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_ASGI_VALOR_GIRO, 
																			 "txtvlrDelGiro", 
																			 "",
																			 true, 
																			 true, 
																			 true, 
																			 super.getEventoForma(),
																			 EnumEtiquetas.LBL_ASGI_VALOR_GIRO);
		this.txtvlrDelGiro.setHorizontalAlignment(SwingConstants.TRAILING);
		return this.txtvlrDelGiro;
	}

	/**
	 * @method	getPnlInfoRemensa
	 * 		  	Metodo get del atributo pnlInfoRemensa
	 * @return	SeccionUtil
	 *		  	Valor del atributo pnlInfoRemensa devuelto
	 * @author	roberth.martinez
	 * @date  	30/04/2018
	 */
	public SeccionUtil getPnlInfoRemensa() {
		return this.pnlInfoRemensa;
	}

	/**
	 * @method	setPnlInfoRemensa
	 * 		  	Metodo set del atributo pnlInfoRemensa
	 * @param	pPnlInfoRemensa
	 * 			Valor que tomara el atributo pnlInfoRemensa
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 */
	public void setPnlInfoRemensa(SeccionUtil pPnlInfoRemensa) {
		this.pnlInfoRemensa = pPnlInfoRemensa;
	}

	/**
	 * @method	getLblReferenciaSeguro
	 * 		  	Metodo get del atributo lblReferenciaSeguro
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblReferenciaSeguro devuelto
	 * @author	roberth.martinez
	 * @date  	30/04/2018
	 */
	public EtiquetaUtil getLblReferenciaSeguro() {
		return this.lblReferenciaSeguro;
	}

	/**
	 * @method	setLblReferenciaSeguro
	 * 		  	Metodo set del atributo lblReferenciaSeguro
	 * @param	pLblReferenciaSeguro
	 * 			Valor que tomara el atributo lblReferenciaSeguro
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 */
	public void setLblReferenciaSeguro(EtiquetaUtil pLblReferenciaSeguro) {
		this.lblReferenciaSeguro = pLblReferenciaSeguro;
	}

	/**
	 * @method	getLblvlrDelGiro
	 * 		  	Metodo get del atributo lblvlrDelGiro
	 * @return	EtiquetaUtil
	 *		  	Valor del atributo lblvlrDelGiro devuelto
	 * @author	roberth.martinez
	 * @date  	30/04/2018
	 */
	public EtiquetaUtil getLblvlrDelGiro() {
		return this.lblvlrDelGiro;
	}

	/**
	 * @method	setLblvlrDelGiro
	 * 		  	Metodo set del atributo lblvlrDelGiro
	 * @param	pLblvlrDelGiro
	 * 			Valor que tomara el atributo lblvlrDelGiro
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 */
	public void setLblvlrDelGiro(EtiquetaUtil pLblvlrDelGiro) {
		this.lblvlrDelGiro = pLblvlrDelGiro;
	}

	/**
	 * @method	getTxtReferenciaSeguro
	 * 		  	Metodo get del atributo txtReferenciaSeguro
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtReferenciaSeguro devuelto
	 * @author	roberth.martinez
	 * @date  	30/04/2018
	 */
	public CajaTextoUtil getTxtReferenciaSeguro() {
		return this.txtReferenciaSeguro;
	}

	/**
	 * @method	setTxtReferenciaSeguro
	 * 		  	Metodo set del atributo txtReferenciaSeguro
	 * @param	pTxtReferenciaSeguro
	 * 			Valor que tomara el atributo txtReferenciaSeguro
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 */
	public void setTxtReferenciaSeguro(CajaTextoUtil pTxtReferenciaSeguro) {
		this.txtReferenciaSeguro = pTxtReferenciaSeguro;
	}

	/**
	 * @method	getTxtvlrDelGiro
	 * 		  	Metodo get del atributo txtvlrDelGiro
	 * @return	CajaTextoUtil
	 *		  	Valor del atributo txtvlrDelGiro devuelto
	 * @author	roberth.martinez
	 * @date  	30/04/2018
	 */
	public CajaTextoUtil getTxtvlrDelGiro() {
		return this.txtvlrDelGiro;
	}

	/**
	 * @method	setTxtvlrDelGiro
	 * 		  	Metodo set del atributo txtvlrDelGiro
	 * @param	pTxtvlrDelGiro
	 * 			Valor que tomara el atributo txtvlrDelGiro
	 * @author	roberth.martinez
	 * @date	30/04/2018
	 */
	public void setTxtvlrDelGiro(CajaTextoUtil pTxtvlrDelGiro) {
		this.txtvlrDelGiro = pTxtvlrDelGiro;
	}

	/** 
	 * ********************************************************************
	 * @method	main
	 * 		  	main
	 * @param 	args
	 * 			args
	 * @author	roberth.martinez
	 * @date	22/04/2018
	 * *********************************************************************
	 */
	public static void main(String[] args) {
		
		JFrame jframe = null;
		
		try{
	        
			jframe = TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaConsultaGiroInternacional.class,
																		    true, 
																		    EnumDesplegarFormaConEventos.SI);
			
			
			new FormaAnulacionProtegiroInternacional(jframe, 
									  				 true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
