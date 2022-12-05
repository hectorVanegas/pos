package co.com.codesa.clienteposslimgiros.formas.caja;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.caja.EventoFormaDiligenciarMedioPago;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelDatosAdicionales;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.MedioPago;

/**
 * ****************************************************************.
 * @autor Hector Q-en-K
 * @fecha 16-sep-2015
 * @Clase FormaDiligenciarMedioPago 
 * 		  Clase que genera la forma (GUI) para el despliegue de un 
 * 		  formulario que permite diligenciar el medio de pago (edicion
 * 		  o ingreso), que se incluira en el movimiento de caja 
 * @copyright: Copyright  1998-2015 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaDiligenciarMedioPago extends FormaGenerica{
	
	/**
	 * @variable 	serialVersionUID
	 * 			 	Variable serialVersionUID
	 */
	private static final long serialVersionUID = -8536084944987517L;

	/**
	 * @variable pnlDatosAdicionales
	 * 			 Seccion a contener los componentes graficos requeridos para diligeniciar
	 * 			 los posibles datos adicionales asociados a un medio de pago
	 */
	private FormaPanelDatosAdicionales pnlDatosAdicionales;
	
	/**
	 * @variable cmbListaMediosPago 
	 * 			 lista de valores a contener los diferentes medios de pago
	 **/
	private CajaComboUtil cmbListaMediosPago;
	
	/**
	 * @variable txtValorMedioPago
	 * 			 caja de texto para ingresar el valor del medio de pago
	 **/
	private CajaTextoUtil txtValorMedioPago;
	
	/**
	 * @variable lblMedioPago
	 * 			 etiqueta que identifica el componnete grafico para seleccionar el
	 * 			 medio de pago
	 **/
	private EtiquetaUtil lblMedioPago;
	
	/**
	 * @variable lblValorMedioPago
	 * 			 etiqueta que identifica el componnete grafico para diligenciar el
	 * 		     valor
	 **/
	private EtiquetaUtil lblValorMedioPago;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaDiligenciarMedioPago
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param pFrmPadre
  	 * 		  ventana de la cual extiende esta forma
  	 * @param pBooModal 
  	 * 		  bandera que permite efectuar la forma de manera modal sobre 
  	 * 		  la ventana de la cual extiende
  	 * @param pObjMedioPagoParaEditar
  	 * 		  Medio de pago recibido para edicion, en caso de ser nulo,
  	 * 		  se asume que sera un proceso de creacion
  	 * @param pHmMediosPagoIngresados
  	 * 		  Listado de medios de pago que ya fueron cargados sobre 
  	 * 		  la funcionalidad base, excluyendo de este el posible medio
  	 * 		  de pago para edicion; esto lo debe garantizar la 
  	 * 		  funcionalidad base
  	 * @param pDouTotalIngresoXTarjetas
  	 * 		  Valor total ingresado por tarjetas como medio de pago, 
  	 * 		  recuperado y procesado por la funcionalidad base
  	 * @param pDouValorTotalServicio
  	 * 		  Valor total de la operacion que se esta diligenciando
	 * 		  por parte de la funcionalidad base, total a cobrar o total 
	 * 		  a pagar, dependiendo de la operacion
	 * @param pLstMediosPagoHabilitados
	 * 		  Listado de los medios de pago autorizados y habilitados 
	 * 		  segun la funcionalidad base, para realizar la operacion 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaDiligenciarMedioPago(FormaGenerica pFrmPadre, 
							   		 boolean pBooModal,
							   		 MedioPago pObjMedioPagoParaEditar,
							   		 HashMap<String,MedioPago> pHmMediosPagoIngresados,
							   		 double pDouTotalIngresoXTarjetas,
							   		 double pDouValorTotalServicio,
							   		 List<MedioPago> pLstMediosPagoHabilitados) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		//super.setBooDesaparecerVentanaPadre(true);
		
		super.setEventoForma(new EventoFormaDiligenciarMedioPago(this,
																 pObjMedioPagoParaEditar,
																 pHmMediosPagoIngresados,
																 pDouTotalIngresoXTarjetas,
																 pDouValorTotalServicio,
																 pLstMediosPagoHabilitados));
		this.inicializarForma();
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
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
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_DMP_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_DMP_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_DMP_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR, 
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo inicializarEncabezado
  	 * 		   Metodo dedicado a inicializar y gestionar el encabezado 
  	 * 		   de la forma (seccion superior)
  	 * @param pArrObjParametrosForma
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosForma) throws Exception {
		return null;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarCuerpo
  	 * 		   Metodo dedicado a inicializar y gestionar el cuerpo 
  	 * 		   de la forma (seccion central)
  	 * @param pArrObjParametrosCuerpo
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_DMP_CUERPO,
																"pnlCuerpo",
					 											BorderFactory.createEtchedBorder(),
					 											null,
					 											null);
		pnlCuerpo.add(this.iniciarPropLblMedioPago());
		pnlCuerpo.add(this.iniciarPropCmbListaMediosPago());
		pnlCuerpo.add(this.iniciarPropLblValorMedioPago());
		pnlCuerpo.add(this.iniciarPropTxtValorMedioPago());
		pnlCuerpo.add(this.iniciarPropPnlDatosAdicionales());
		
		return pnlCuerpo;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarPiePagina
  	 * 		   Metodo dedicado a inicializar y gestionar el pie de pagina 
  	 * 		   de la forma (seccion inferior)
  	 * @param pArrObjParametrosPiePagina
  	 * 		  lista de posibles parametros a incluir sobre esta etapa
  	 * 		  [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception {
		return null;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblMedioPago
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblMedioPago() throws Exception{
		
		if (this.lblMedioPago == null) {
			
				this.lblMedioPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_DMP_MEDIO_PAGO, 
																			 	"lblMedioPago",
																			 	EnumEtiquetas.LBL_DMP_MEDIO_PAGO,
																			 	true,
																			 	null,
																			 	true);
		}
		
		return this.lblMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblValorMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblValorMedioPago
  	 * @return EtiquetaUtil
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblValorMedioPago() throws Exception{
		
		if (this.lblValorMedioPago == null) {
			
				this.lblValorMedioPago = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_DMP_VALOR_MEDIO_PAGO, 
																			 	 	 "lblValorMedioPago",
																			 	 	 EnumEtiquetas.LBL_DMP_VALOR_MEDIO_PAGO,
																			 	 	 true,
																			 	 	 null,
																			 	 	 true);
		}
		
		return this.lblValorMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropPnlDatosAdicionales
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pnlDatosAdicionales
  	 * @return FormaPanelDatosAdicionales 
  	 * 		   seccion datos adicionales gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaPanelDatosAdicionales iniciarPropPnlDatosAdicionales() throws Exception{
		
		if(this.pnlDatosAdicionales == null){
			
			this.pnlDatosAdicionales = new FormaPanelDatosAdicionales(this, 
																	  EnumDimensionesComponentes.SCP_DMP_GRILLA_DAT_ADI_MEDPAGO, 
																	  null,
																	  "pnlDatosAdicionales");
		}
		
		return this.pnlDatosAdicionales;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropTxtValorMedioPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   txtValorMedioPago
  	 * @return CajaTextoUtil 
  	 * 		   caja de texto gestionada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaTextoUtil iniciarPropTxtValorMedioPago()throws Exception{
		
		if(this.txtValorMedioPago==null){
			
			this.txtValorMedioPago = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_DMP_VALOR_MEDIO_PAGO, 
																		   		 	 "txtValorMedioPago", 
																		   		 	 "",
																		   		 	 true, 
																		   		 	 true, 
																		   		 	 true, 
																		   		 	 super.getEventoForma(),
																		   		 	 EnumEtiquetas.LBL_DMP_VALOR_MEDIO_PAGO);
			this.txtValorMedioPago.setBackground(new Color(164, 164, 255));
			this.txtValorMedioPago.setForeground(new Color(0, 0, 0));
			this.txtValorMedioPago.setFont(this.txtValorMedioPago.getFont().deriveFont(Font.BOLD,13));
			this.txtValorMedioPago.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		
		return this.txtValorMedioPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropCmbListaMediosPago
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbListaMediosPago
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropCmbListaMediosPago()throws Exception{

		if(this.cmbListaMediosPago==null){

			this.cmbListaMediosPago = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_DMP_LISTA_MEDIOS_PAGO,
																		  	   	 	 "cmbListaMediosPago",
																		  	   	 	 true, 
																		  	   	 	 true, 
																		  	   	 	 super.getEventoForma(),
																		  	   	 	 EnumEtiquetas.LBL_DMP_MEDIO_PAGO);
		}
		
		return this.cmbListaMediosPago;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo castEvaFrmDiligenciarMedioPago
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo padre eventoForma
  	 * @return EventoFormaDiligenciarMedioPago
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public EventoFormaDiligenciarMedioPago castEvaFrmDiligenciarMedioPago()throws Exception{
		return (EventoFormaDiligenciarMedioPago)super.getEventoForma();
	}
	
	/**
	 * @method getPnlDatosAdicionales
	 * 		   Metodo get del atributo pnlDatosAdicionales
	 * @return FormaPanelDatosAdicionales
	 *		   Valor del atributo pnlDatosAdicionales devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public FormaPanelDatosAdicionales getPnlDatosAdicionales() {
		return this.pnlDatosAdicionales;
	}

	/**
	 * @method setPnlDatosAdicionales
	 * 		   Metodo set del atributo pnlDatosAdicionales
	 * @param  pPnlDatosAdicionales
	 *		   Valor que tomara el atributo pnlDatosAdicionales
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setPnlDatosAdicionales(
			FormaPanelDatosAdicionales pPnlDatosAdicionales) {
		this.pnlDatosAdicionales = pPnlDatosAdicionales;
	}

	/**
	 * @method getCmbListaMediosPago
	 * 		   Metodo get del atributo cmbListaMediosPago
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbListaMediosPago devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public CajaComboUtil getCmbListaMediosPago() {
		return this.cmbListaMediosPago;
	}

	/**
	 * @method setCmbListaMediosPago
	 * 		   Metodo set del atributo cmbListaMediosPago
	 * @param  pCmbListaMediosPago
	 *		   Valor que tomara el atributo cmbListaMediosPago
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setCmbListaMediosPago(CajaComboUtil pCmbListaMediosPago) {
		this.cmbListaMediosPago = pCmbListaMediosPago;
	}

	/**
	 * @method getTxtValorMedioPago
	 * 		   Metodo get del atributo txtValorMedioPago
	 * @return CajaTextoUtil
	 *		   Valor del atributo txtValorMedioPago devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public CajaTextoUtil getTxtValorMedioPago() {
		return this.txtValorMedioPago;
	}

	/**
	 * @method setTxtValorMedioPago
	 * 		   Metodo set del atributo txtValorMedioPago
	 * @param  pTxtValorMedioPago
	 *		   Valor que tomara el atributo txtValorMedioPago
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setTxtValorMedioPago(CajaTextoUtil pTxtValorMedioPago) {
		this.txtValorMedioPago = pTxtValorMedioPago;
	}

	/**
	 * @method getLblMedioPago
	 * 		   Metodo get del atributo lblMedioPago
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblMedioPago devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public EtiquetaUtil getLblMedioPago() {
		return this.lblMedioPago;
	}

	/**
	 * @method setLblMedioPago
	 * 		   Metodo set del atributo lblMedioPago
	 * @param  pLblMedioPago
	 *		   Valor que tomara el atributo lblMedioPago
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setLblMedioPago(EtiquetaUtil pLblMedioPago) {
		this.lblMedioPago = pLblMedioPago;
	}

	/**
	 * @method getLblValorMedioPago
	 * 		   Metodo get del atributo lblValorMedioPago
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblValorMedioPago devuelto
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public EtiquetaUtil getLblValorMedioPago() {
		return this.lblValorMedioPago;
	}

	/**
	 * @method setLblValorMedioPago
	 * 		   Metodo set del atributo lblValorMedioPago
	 * @param  pLblValorMedioPago
	 *		   Valor que tomara el atributo lblValorMedioPago
	 * @author hector.cuenca
	 * @date   2/12/2016
	 */
	public void setLblValorMedioPago(EtiquetaUtil pLblValorMedioPago) {
		this.lblValorMedioPago = pLblValorMedioPago;
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
		try{
	        
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaDiligenciarMedioPago.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			
			new FormaDiligenciarMedioPago(null,
										  true,  
										  null,
										  null,
										  0,
										  0,
										  null);
			
		} catch (Exception e) {
			
			UtilidadesGiros.getInstance().controlExcepcion(e, 
														   null);
		}
	}
}
