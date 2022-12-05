package co.com.codesa.clienteposslimgiros.formas.operacioninusual.paneles;

import javax.swing.BorderFactory;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaPanelDocumento;
import co.com.codesa.clienteposslimgiros.eventos.operacioninusual.EventoFormaPanelProductoTransaccion;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

public class FormaPanelProductoTransaccion extends FormaPanelGenerico {


	private EtiquetaUtil lblProducto;

	private CajaComboUtil cmbProducto;

	private EtiquetaUtil lblCorresponsal;

	private CajaComboUtil cmbCorresponsal;

	private EtiquetaUtil lblNoOperacion;

	private CajaTextoUtil txtNoOperacion;

	private EtiquetaUtil lblValorOperacion;

	private CajaTextoUtil txtValorOperacion;

	private EtiquetaUtil lblMoneda;

	private CajaComboUtil cmbMoneda;


	private EventoFormaPanelProductoTransaccion evtFrmProdTransaccion;

	public FormaPanelProductoTransaccion(FormaGenerica pFrmPadre,
			EnumDimensionesComponentes pEnmDimension,
			String pStrNombreComponente) throws Exception {

		super(pFrmPadre,
				pEnmDimension,
				pStrNombreComponente,
				BorderFactory.createEmptyBorder(),
				null,
				null);

		this.evtFrmProdTransaccion = new EventoFormaPanelProductoTransaccion(this, 
				pFrmPadre);
		this.setEvaControlEventos(this.evtFrmProdTransaccion);

		super.iniciar();

	}

	@Override
	protected void inicializarSeccion() throws Exception {
		// TODO Auto-generated method stub
     
		this.add(this.iniciarPropLblProducto());
		this.add(this.iniciarPropCmbProducto());
		this.add(this.iniciarPropLblCorresponsal());
		this.add(this.iniciarPropCmbCorresponsal());
		this.add(this.iniciarPropLblNoOperacion());
		this.add(this.iniciarPropTxtNoOperacion());
		this.add(this.iniciarPropLblValorOperacion());
		this.add(this.iniciarPropTxtValorOperacion());
		this.add(this.iniciarPropLblMoneda());
		this.add(this.iniciarPropCmbMoneda());
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

			this.cmbProducto = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_PRODUCTO,
					"cmbProducto",
					true,
					true,
					this.evtFrmProdTransaccion,
					null);
		}

		return this.cmbProducto;
	}


	public EtiquetaUtil iniciarPropLblCorresponsal() throws Exception{

		if(this.lblCorresponsal == null){

			this.lblCorresponsal = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_CORRESPONSAL, 
					"lblCorresponsal", 
					EnumEtiquetas.LBL_OII_CORRESPONSAL, 
					true, 
					null, 
					true);
		}

		return this.lblCorresponsal;
	}


	public CajaComboUtil iniciarPropCmbCorresponsal() throws Exception{

		if(this.cmbCorresponsal == null){

			this.cmbCorresponsal = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_CORRESPONSAL,
					"cmbCorresponsal",
					true,
					true,
					this.evtFrmProdTransaccion,
					null);
		}

		return this.cmbCorresponsal;
	}
	
	
	
	public EtiquetaUtil iniciarPropLblNoOperacion() throws Exception{

		if(this.lblNoOperacion == null){

			this.lblNoOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_NOOPERACION, 
					"lblNoOperacion", 
					EnumEtiquetas.LBL_OII_NO_DE_OPERACION, 
					true, 
					null, 
					true);
		}

		return this.lblNoOperacion;
	}


	public CajaTextoUtil iniciarPropTxtNoOperacion() throws Exception{
		
		if(this.txtNoOperacion == null){
			
			this.txtNoOperacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_NOOPERACION, 
																				      "txtNoOperacion", 
																				      "", 
																				      true, 
																				      true, 
																				      true, 
																				      this.evtFrmProdTransaccion, 
																				      null);
		}
		
		return this.txtNoOperacion;
	}
	
	
	
	
	public EtiquetaUtil iniciarPropLblValorOperacion() throws Exception{

		if(this.lblValorOperacion == null){

			this.lblValorOperacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_VALOROPERACION, 
					"lblValorOperacion", 
					EnumEtiquetas.LBL_OII_VALOR_OPERACION, 
					true, 
					null, 
					true);
		}

		return this.lblValorOperacion;
	}


	public CajaTextoUtil iniciarPropTxtValorOperacion() throws Exception{
		
		if(this.txtValorOperacion == null){
			
			this.txtValorOperacion = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_OII_PNL_VALOROPERACION, 
																				      "txtValorOperacion", 
																				      "", 
																				      true, 
																				      true, 
																				      true, 
																				      this.evtFrmProdTransaccion, 
																				      null);
		}
		
		return this.txtValorOperacion;
	}
	
	
	
	public EtiquetaUtil iniciarPropLblMoneda() throws Exception{

		if(this.lblMoneda == null){

			this.lblMoneda = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OII_PNL_MONEDA, 
					"lblMoneda", 
					EnumEtiquetas.LBL_OII_MONEDA, 
					true, 
					null, 
					true);
		}

		return this.lblMoneda;
	}


	public CajaComboUtil iniciarPropCmbMoneda() throws Exception{

		if(this.cmbMoneda == null){

			this.cmbMoneda = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OII_PNL_MONEDA,
					"cmbMoneda",
					true,
					true,
					this.evtFrmProdTransaccion,
					null);
		}

		return this.cmbMoneda;
	}
	


}
