/**
 * 
 */
package co.com.codesa.clienteposslimgiros.formas.facturacion;


import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.pago.EventoFormaGicoAutomatico;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;


/**
 * ****************************************************************.
 * @autor david.marquez
 * @fecha 24-nov-2020 
 * @Clase FormaGicoAutomatico
 * 		  Clase que genera la forma (GUI) para gestionar la 
 * 		  seleccion del usuario para remitente o beneficiario
 * ****************************************************************
 */
public class FormaGicoAutomatico  extends FormaGenerica{

private static final long serialVersionUID = 1L;
	
	/**
	 * @variable cmbSolicitudGico
	 * 			 Combo para la seleccion si es remitente o beneficiario
	 **/
	private CajaComboUtil cmbSolicitudGico;
	
	/**
	 * @variable lblSeleccionGicoAutomatico
	 * 			 etiqueta para indicar la seleccion de giro automatico 
	 **/
	private EtiquetaUtil lblSeleccionGicoAutomatico;
	
		
	public String strSeleccionUsuario;
	
	/**
  	 * ****************************************************************.
  	 * @metodo FormaGicoAutomatico
  	 * 		   Constructor que ejecuta la inicializacion de valores y 
  	 * 		   ejecucion de comportamientos inicales requeridos para el 
  	 * 		   despliegue de la forma
  	 * @param  pFrmPadre 
  	 * 		   ventana de la cual extiende esta forma
  	 * @param  pBooModal 
  	 * 		   bandera que permite efectuar la forma de manera modal sobre 
  	 * 		   la ventana de la cual extiende
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	public FormaGicoAutomatico(FormaGenerica pFrmPadre,
						  			 boolean pBooModal) throws Exception{
		super(pFrmPadre,				
			  pBooModal);
		
		
		super.setEventoForma(new EventoFormaGicoAutomatico(this));
		
		this.inicializarForma();
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarForma
  	 * 		   Metodo propuesto por la forma generica, para inicializar 
  	 * 		   todos los aspectos de la forma
  	 * @param  pArrObjParametrosForma 
  	 * 		   lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		   de la forma
  	 * 		   [x]: descripcion del valor enviado en la posicion [x]
  	 * 		   [0]: direccion previamente diligenciada
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.TLT_GICO_AUTOMATICO);
		super.setAnchoForma(EnumDimensionesComponentes.GUI_GICO_AUTOMATICO_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.GUI_GICO_AUTOMATICO_VENTANA.getAlto());
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_LIMPIAR,
						  		EnumBotonesEncabezado.BTNVOLVER
						  		);
		
		super.iniciar(pArrObjParametrosForma);
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarEncabezado
  	 * 		   Metodo dedicado a inicializar y gestionar el encabezado 
  	 * 		   de la forma (seccion superior)
  	 * @param  pArrObjParametrosForma
  	 * 		   lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		   de la seccion del encabezado
  	 * 		   [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
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
  	 * @param  pArrObjParametrosCuerpo
  	 * 		   lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		   de la seccion del cuerpo
  	 * 		   [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) throws Exception{
		return null;
	}

	/**
  	 * ****************************************************************.
  	 * @metodo inicializarPiePagina
  	 * 		   Metodo dedicado a inicializar y gestionar el pie de pagina 
  	 * 		   de la forma (seccion inferior)
  	 * @param  pArrObjParametrosPiePagina
  	 * 		   lista de posibles parametros a incluir sobre la inicializacion 
  	 * 		   de la seccion de pie de pagina
  	 * 		   [x]: descripcion del valor enviado en la posicion [x]
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) throws Exception{
		
		JPanel pnlPiePagina;
		
		pnlPiePagina = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_GICO_AUTOMATICO_CUERPO_DIMENSIONES,
																   "pnlPiePagina",
																   null,
																   null,
																   null);

		pnlPiePagina.add(this.iniciarPropLblSeleccionGicoAutomatico());
		pnlPiePagina.add(this.iniciarPropcmbSolicitudGico());
		
		return pnlPiePagina;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropLblSeleccionGicoAutomatico (Metodo)
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   lblGrillaConceptos
  	 * @return EtiquetaUtil 
  	 * 		   etiqueta gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	public EtiquetaUtil iniciarPropLblSeleccionGicoAutomatico() throws Exception{
		
		if (this.lblSeleccionGicoAutomatico == null) {
			
			this.lblSeleccionGicoAutomatico = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_GICO_AUTOMATICO, 
																		  	  	  "lblSeleccionGicoAutomatico", 
																		  	  	  EnumEtiquetas.LBL_GICO_AUTOMATICO,
																		  	  	  true,
																		  	  	  null,
																		  	  	  true);
		}

		return this.lblSeleccionGicoAutomatico;
	}
	
	/**
  	 * ****************************************************************.
  	 * @metodo iniciarPropcmbSolicitudGico
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   cmbSolicitudGico
  	 * @return CajaComboUtil 
  	 * 		   lista de valores gestionada 
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada 
  	 * @autor  david.marquez
  	 * ****************************************************************
  	 */
	public CajaComboUtil iniciarPropcmbSolicitudGico()throws Exception{

		if(this.cmbSolicitudGico==null){
			this.cmbSolicitudGico = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_GICO_AUTOMATICO,
																			 		   	   "cmbSolicitudGico",
																			 		   	   true,
																			 		   	   true, 
																			 		   	   super.getEventoForma(),
																			 		   	   EnumEtiquetas.LBL_GICO_AUTOMATICO);
		}
		
		return this.cmbSolicitudGico;
	}
	
	public EventoFormaGicoAutomatico castEvtFrmGicoAutomatico()throws Exception{
		return (EventoFormaGicoAutomatico)super.getEventoForma();
	}

	public CajaComboUtil getcmbSolicitudGico() {
		return cmbSolicitudGico;
	}

	public void setcmbSolicitudGico(CajaComboUtil cmbSolicitudGico) {
		this.cmbSolicitudGico = cmbSolicitudGico;
	}	

	public static void main(String[] args) {
		try {
			//InformacionSessionGiros.getInstance().getObjUsuario().getEmpresa().setId("1");
		
			new FormaGicoAutomatico(null,
										  true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

