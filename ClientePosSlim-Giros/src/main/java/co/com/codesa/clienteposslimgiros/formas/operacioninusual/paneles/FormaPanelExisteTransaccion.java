package co.com.codesa.clienteposslimgiros.formas.operacioninusual.paneles;

import javax.swing.BorderFactory;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaPanelDocumento;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaPanelTransaccionExistente;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.BotonUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.GrillaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionDesplazableUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaPanelExisteTransaccion extends FormaPanelGenerico {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2269453746879593087L;

	private EtiquetaUtil lblCliUsuario;

	private CajaTextoUtil txtCliUsuario;

	private EtiquetaUtil lblNumOperacion;

	private CajaTextoUtil txtNumOperacion;

	private EtiquetaUtil lblProducto;

	private CajaComboUtil cmbProducto;

	private EtiquetaUtil lblCorresponsal;

	private CajaComboUtil cmbCorresponsal;

	private EtiquetaUtil lblTipoVinculo;

	private CajaComboUtil cmbTipoVinculo;
	
	private BotonUtil btnAgregar;
	
	private BotonUtil btnEliminar;
	
	private GrillaUtil grillaExisteTransaccion;
	
	private SeccionDesplazableUtil scrollGrillaExisteTransaccion;
	
	private EventoFormaPanelTransaccionExistente evtFrmTransaccion;
	
	public FormaPanelExisteTransaccion(FormaGenerica pFrmPadre,
			EnumDimensionesComponentes pEnmDimension,
			String pStrNombreComponente) throws Exception {

		super(pFrmPadre,
				pEnmDimension,
				pStrNombreComponente,
				BorderFactory.createEmptyBorder(),
				null,
				null);

		this.evtFrmTransaccion = new EventoFormaPanelTransaccionExistente(this, 
				pFrmPadre);
		this.setEvaControlEventos(this.evtFrmTransaccion);

		super.iniciar();

	}

	@Override
	protected void inicializarSeccion() throws Exception {
		// TODO Auto-generated method stub
		this.add(this.iniciarPropLblClienteUsuario());
		this.add(this.iniciarPropTxtClienteUsuario());
		
		this.add(this.iniciarPropLblNoOperacion());
		this.add(this.iniciarPropTxtNumOperacion());
	}
	
	
	
	public EtiquetaUtil iniciarPropLblClienteUsuario() throws Exception{

		if(this.lblCliUsuario == null){

			this.lblCliUsuario = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_DOC_CLI_USUARIO, 
					"lblCliUsuario", 
					EnumEtiquetas.LBL_OII_EXISTE_TRANS_DOC_CLIENTE, 
					true, 
					null, 
					true);
		}

		return this.lblCliUsuario;
	}


	public CajaTextoUtil iniciarPropTxtClienteUsuario() throws Exception{

		if(this.txtCliUsuario == null){

			this.txtCliUsuario = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_DOC_CLI_USUARIO, 
				      "txtCliUsuario", 
				      "", 
				      true, 
				      true, 
				      true, 
				      this.evtFrmTransaccion, 
				      null);
		}

		return this.txtCliUsuario;
	}
	
	
	
	public EtiquetaUtil iniciarPropLblNoOperacion() throws Exception{

		if(this.lblNumOperacion == null){

			this.lblNumOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_NO_OPERACION, 
					"lblNumOperacion", 
					EnumEtiquetas.LBL_OII_EXISTE_TRANS_NO_OPERACION, 
					true, 
					null, 
					true);
		}

		return this.lblNumOperacion;
	}


	public CajaTextoUtil iniciarPropTxtNumOperacion() throws Exception{

		if(this.txtNumOperacion == null){

			this.txtNumOperacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_NO_OPERACION, 
				      "txtNumOperacion", 
				      "", 
				      true, 
				      true, 
				      true, 
				      this.evtFrmTransaccion, 
				      null);
		}

		return this.txtNumOperacion;
	}
	
	
	public EtiquetaUtil iniciarPropLblProducto() throws Exception{

		if(this.lblProducto == null){

			this.lblProducto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_PRODUCTO, 
					"lblProducto", 
					EnumEtiquetas.LBL_OII_PRODUCTO, 
					true, 
					null, 
					true);
		}

		return this.lblProducto;
	}
	
	
	public CajaComboUtil iniciarPropCmbProducto() throws Exception{

		if(this.cmbProducto == null){

			this.cmbProducto = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_MONEDA,
					"cmbProducto",
					true,
					true,
					this.evtFrmTransaccion,
					null);
		}

		return this.cmbProducto;
	}
	
	
	public EtiquetaUtil iniciarPropLblCorresponsal() throws Exception{

		if(this.lblProducto == null){

			this.lblProducto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_PRODUCTO, 
					"lblProducto", 
					EnumEtiquetas.LBL_OII_PRODUCTO, 
					true, 
					null, 
					true);
		}

		return this.lblProducto;
	}
	
	
	public CajaComboUtil iniciarPropCmbCorresponsal() throws Exception{

		if(this.cmbProducto == null){

			this.cmbProducto = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_MONEDA,
					"cmbProducto",
					true,
					true,
					this.evtFrmTransaccion,
					null);
		}

		return this.cmbProducto;
	}
	
	
	public EtiquetaUtil iniciarPropLblTipoVinculo() throws Exception{

		if(this.lblProducto == null){

			this.lblProducto = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_PRODUCTO, 
					"lblProducto", 
					EnumEtiquetas.LBL_OII_PRODUCTO, 
					true, 
					null, 
					true);
		}

		return this.lblProducto;
	}
	
	
	public CajaComboUtil iniciarPropCmbTipoVinculo() throws Exception{

		if(this.cmbProducto == null){

			this.cmbProducto = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_MONEDA,
					"cmbProducto",
					true,
					true,
					this.evtFrmTransaccion,
					null);
		}

		return this.cmbProducto;
	}
	
	
	public BotonUtil iniciarPropBtnAgregar() throws Exception{
		if (this.btnAgregar == null) {
			this.btnAgregar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_EGP_COTIZAR_GIRO, 
																	  	  "btnAgregar", 
																	  	  null, 
																	  	  true, 
																	  	  true, 
																	  	  this.evtFrmTransaccion,  
																	  	  EnumImagenes.OP_COTIZAR.ajustarIcono(EnumDimensionesComponentes.BTN_EGP_COTIZAR_GIRO));
			this.btnAgregar.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnAgregar;
	}
	
	public BotonUtil iniciarPropBtnEliminar() throws Exception{
		if (this.btnEliminar == null) {
			this.btnEliminar = UtilComponentesGUI.getInstance().crearBoton(EnumDimensionesComponentes.BTN_EGP_COTIZAR_GIRO, 
																	  	  "btnEliminar", 
																	  	  null, 
																	  	  true, 
																	  	  true, 
																	      this.evtFrmTransaccion,  
																	  	  EnumImagenes.OP_COTIZAR.ajustarIcono(EnumDimensionesComponentes.BTN_EGP_COTIZAR_GIRO));
			this.btnEliminar.setBorder(BorderFactory.createEmptyBorder());
		}

		return this.btnEliminar;
	}
	
	
public SeccionDesplazableUtil iniciarPropScrollGrillaExisteTransaccion() throws Exception{
		
		if(this.scrollGrillaExisteTransaccion == null){
			
			this.scrollGrillaExisteTransaccion = UtilComponentesGUI.getInstance().crearScroll("scrollGrillaExisteTransaccion", 
																					   EnumDimensionesComponentes.GRI_OII_GRID_SENALES_ALERTA, 
																					   null);
			
			this.scrollGrillaExisteTransaccion.setViewportView(this.iniciarPropGrillaExisteTransaccion());
		}
		
		return this.scrollGrillaExisteTransaccion;
	}
	
	public GrillaUtil iniciarPropGrillaExisteTransaccion() throws Exception{
		
		if(this.grillaExisteTransaccion == null){
			
			this.grillaExisteTransaccion = UtilComponentesGUI.getInstance().crearGrilla("grillaExisteTransaccion", 
																				 new EnumEtiquetas []{EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_CODIGO,
																								      EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_SENAL,
																								      EnumEtiquetas.TTL_OII_GRILLA_SENAL_ALERTA_COMENTARIO
																									 }, 
																				 null,//invisibles
																				 new boolean[] {false,
																								false,
																								false},//editable por columna 
																				 new int[]{40,
																						   80,
																						   80,
																						   80,
																						   80,
																						   100,
																						   100},//Dimensiones 
																				 null);//evento
		}
		
		return this.grillaExisteTransaccion;
	}
	
	
}
