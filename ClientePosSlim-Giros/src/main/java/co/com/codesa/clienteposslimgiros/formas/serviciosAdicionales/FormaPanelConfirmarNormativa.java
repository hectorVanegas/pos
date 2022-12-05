package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;

import co.com.codesa.clienteposslim.logger.Logger;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadAutomaticaDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.EventoFormaPanelConfirmarNormativa;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

public class FormaPanelConfirmarNormativa extends FormaGenerica {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8626212306461319993L;

	/**
	 * @variable txtIngresaCelular
	 * 			 Campo de texto para ingresar el celular
	 */
	private CajaTextoUtil txtIngresaCelular;
	
	/**
	 * @variable txtConfirmaCelular
	 * 			 Campo de texto para confirmar el celular
	 */
	private CajaTextoUtil txtIngresaTelefono;
	
	/**
	 * @variable lblIngresaCelular
	 * 			 Etiqueta que identifica el campo para ingresar el celular
	 */
	private EtiquetaUtil lblIngresaCelular;
	
	/**
	 * @variable lblConfirmaCelular
	 * 			 Etiqueta que identifica el campo para confirmar el celular
	 */
	private EtiquetaUtil lblIngresaTelefono;	
	
	/**
	 * @variable lblTituloForma
	 * 			 Etiqueta que establece el titulo de la forma
	 */
	private EtiquetaUtil lblTituloForma;
	
	/**
	 * @variable	enmEtiTitulo
	 * 				Constante de enumeracion que representa la etiqueta describe
	 * 				la seccion que contiene el formulario a diligenciar
	 */
	private EnumEtiquetas enmEtiTitulo;
	
	/**
	 * ********************************************************************
	 * @method	FormaPanelSMSGiro
	 * 		  	Constructor que ejecuta la inicializacion de valores y 
	 * 		   	ejecucion de comportamientos inicales requeridos para
	 *         	el despliegue de la seccion 
	 * @param 	pFrmGnrVentana
	 * 			Forma principal desde donde el cajero se encuentra ejecutando 
	 * 			las operaciones
	 * @param	pStrTelefonoCelular
	 * 			Telefono celular propuesto actualmente
	 * @param	pEnmDimension
	 * 			Constante que especifica la dimension que la seccion tendra
	 * 			sobre la ventana que la esta adicionando
	 * @param	pEnmEtiTitulo
	 * 			Constante de enumeracion que representa la etiqueta describe
	 * 			la seccion que contiene el formulario a diligenciar
	 * @throws 	Exception
	 * 			Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   	presentada
	 * @author	hector.cuenca
	 * @date	6/04/2018
	 * *********************************************************************
	 */
	
	public FormaPanelConfirmarNormativa (FormaGenerica pFrmGnrVentana,
			String pStrTelefonoCelular,
			String pStrTelefonoFijo,
			Tercero tercero) throws Exception{
		super(pFrmGnrVentana, true);
		

		super.setEventoForma(new EventoFormaPanelConfirmarNormativa(	this,
																	pStrTelefonoCelular,
																	pStrTelefonoFijo,
																	tercero
																));
		this.inicializarForma();
	}
	
	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_NORMATIVA);
		super.setAnchoForma(EnumDimensionesComponentes.PNL_PNL_SMS_SECCION.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.PNL_PNL_SMS_SECCION.getAlto()+EnumDimensionesComponentes.PNL_FRM_GNR_BARRA_HERRAMIENTAS.getAlto()+1);
		
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}
	
	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_PNL_SMS_SECCION,
																"pnlCuerpo",
		  													 	null,
		  													 	null,
		  													 	null);
		
		
		
		pnlCuerpo.add(this.iniciarPropLblIngresaCelular());
		pnlCuerpo.add(this.iniciarPropTxtIngresaCelular());
		pnlCuerpo.add(this.iniciarPropLblIngresaTelefono());
		pnlCuerpo.add(this.iniciarPropTxtIngregaTelefono());
		
		return pnlCuerpo;
	}
	


	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtIngresaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtIngresaCelular
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIngresaCelular()
		throws Exception
	{	
		if	(	this.txtIngresaCelular == null	) 
		{
			this.txtIngresaCelular = UtilComponentesGUI.getInstance().crearTextField(	EnumDimensionesComponentes.TXT_PNL_SMS_INGRESAR_CELULAR, 
																						"txtIngresaCelular", 
																					    "",
																					    true, 
																					    true, 
																					    true, 
																					    super.getEventoForma(),
																					    null
																					);
		}
		
		return this.txtIngresaCelular;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropTxtConfirmaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   txtConfirmaCelular
	 * @return CajaTextoUtil 
	 * 		   Caja de texto gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public CajaTextoUtil iniciarPropTxtIngregaTelefono()
		throws Exception
	{	
		if	(	this.txtIngresaTelefono == null	) 
		{
			this.txtIngresaTelefono = UtilComponentesGUI.getInstance().crearTextField(	EnumDimensionesComponentes.TXT_PNL_SMS_CONFIRMAR_CELULAR, 
																					 	"txtIngresaTelefono",
																					 	"",
																					 	true, 
																					 	true, 
																					 	true, 
																					 	super.getEventoForma(),
																					 	null
																					 );
		}
		
		return this.txtIngresaTelefono;
	}
	
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblIngresaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngresaCelular
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngresaCelular() 
		throws Exception
	{	
		if	(	this.lblIngresaCelular == null	) 
		{	
			this.lblIngresaCelular = UtilComponentesGUI.getInstance().crearLabel(	EnumDimensionesComponentes.LBL_PNL_SMS_INGRESAR_CELULAR, 
					   																"lblIngresaCelular", 
					   																EnumEtiquetas.LBL_MNT_TERC_CELULAR,
					   																true,
					   																null,
					   																true
					   															);
		}
		
		return this.lblIngresaCelular;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblConfirmaCelular 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblConfirmaCelular
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */	
	public EtiquetaUtil iniciarPropLblIngresaTelefono() 
		throws Exception
	{	
		if	(	this.lblIngresaTelefono == null	) 
		{	
			this.lblIngresaTelefono = UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_PNL_SMS_CONFIRMAR_CELULAR, 
					 																	"lblConfirmaCelular", 
					 															  		EnumEtiquetas.LBL_MNT_TERC_TELEFONO,
					 															  		true,
					 															  		null,
					 															  		true
					 																);
		}
		
		return this.lblIngresaTelefono;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLbltituloForma 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTituloForma
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author stiven.garcia
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLbltituloForma() 
		throws Exception
	{	
		if	(	this.lblTituloForma == null	) 
		{	
			
			this.lblTituloForma = UtilComponentesGUI.getInstance().crearLabel(	EnumDimensionesComponentes.LBL_PNL_NORMATIVA_TITULO_FORMA, 
				   																"lblTituloForma", 
				   																enmEtiTitulo,
				   																false,
				   																null,
				   																true
					   															);
		}
		
		return this.lblTituloForma;
	}

	public CajaTextoUtil getTxtIngresaCelular() {
		return txtIngresaCelular;
	}

	public void setTxtIngresaCelular(CajaTextoUtil txtIngresaCelular) {
		this.txtIngresaCelular = txtIngresaCelular;
	}

	public CajaTextoUtil getTxtIngresaTelefono() {
		return txtIngresaTelefono;
	}

	public void setTxtIngresaTelefono(CajaTextoUtil txtIngresaTelefono) {
		this.txtIngresaTelefono = txtIngresaTelefono;
	}

	public EtiquetaUtil getLblIngresaCelular() {
		return lblIngresaCelular;
	}

	public void setLblIngresaCelular(EtiquetaUtil lblIngresaCelular) {
		this.lblIngresaCelular = lblIngresaCelular;
	}

	public EtiquetaUtil getLblIngresaTelefono() {
		return lblIngresaTelefono;
	}

	public void setLblIngresaTelefono(EtiquetaUtil lblIngresaTelefono) {
		this.lblIngresaTelefono = lblIngresaTelefono;
	}

	public EtiquetaUtil getLblTituloForma() {
		return lblTituloForma;
	}

	public void setLblTituloForma(EtiquetaUtil lblTituloForma) {
		this.lblTituloForma = lblTituloForma;
	}

	public EnumEtiquetas getEnmEtiTitulo() {
		return enmEtiTitulo;
	}

	public void setEnmEtiTitulo(EnumEtiquetas enmEtiTitulo) {
		this.enmEtiTitulo = enmEtiTitulo;
	}
	
	
	public static void main(String[] args) {
		try {
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,false, EnumDesplegarFormaConEventos.NO);
			@SuppressWarnings("unused")
			TipoClaveSeguridadAutomaticaDTO tipoTokenValidaAutomaticolDTO = new TipoClaveSeguridadAutomaticaDTO(null, null);
			//FacturaGiro objFacturaGiro = new FacturaGiro();
			
			new FormaPanelConfirmarNormativa(
							null,
							"3125254785",
							"5568741",
							null);
			
			
		} catch (Exception e) {
			Logger.getInstance().error(e.getMessage());
		}
	}
	
}
