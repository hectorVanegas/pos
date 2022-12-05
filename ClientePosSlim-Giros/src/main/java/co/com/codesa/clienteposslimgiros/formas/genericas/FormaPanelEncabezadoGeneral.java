package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import co.com.codesa.clienteposslimgiros.dto.PosicionDimensiones;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Caja;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Empresa;


public class FormaPanelEncabezadoGeneral extends SeccionUtil{

	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblEmpresa;
	private EtiquetaUtil lblAgencia;
	private EtiquetaUtil lblCaja;
	
	private CajaTextoUtil txtCodigoEmpresa;
	private CajaTextoUtil txtCodigoAgencia;
	private CajaTextoUtil txtCodigoCaja;
	
	private CajaTextoUtil txtNombreEmpresa;
	private CajaTextoUtil txtNombreAgencia;
	private CajaTextoUtil txtDescripcionCaja;
	
	private Empresa empresa;
	private Agencia agencia;
	private Caja caja;
	private List<PosicionDimensiones> listadoDimensiones;
	
	
	public FormaPanelEncabezadoGeneral(Empresa pEmpresa,
									  Agencia pAgencia,
									  Caja pCaja,
									  EnumDimensionesComponentes pRectangle,
									  String pStrNombreComponente) throws Exception{
		
		super	(	pRectangle,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.empresa = pEmpresa;
		this.agencia = pAgencia;
		this.caja = pCaja;
		
		this.inicializarForma();
		
	}
	
	private void inicializarForma()throws Exception{
		
		PosicionDimensiones posicionDimensiones;

		this.configurarPosicionDimensiones();
		
		if(this.empresa!=null){
			
			posicionDimensiones = this.obtenerPosicionDimensiones();
			this.add(this.iniciarPropLblEmpresa(posicionDimensiones.getPosiciones()[0]));
			this.add(this.iniciarPropTxtCodigoEmpresa(posicionDimensiones.getPosiciones()[1]));
			this.add(this.iniciarPropTxtNombreEmpresa(this.calcularRectanguloDescripcion(posicionDimensiones)));
			
		}
		
		if(this.agencia!=null){
			posicionDimensiones = this.obtenerPosicionDimensiones();
			this.add(this.iniciarPropLblAgencia(posicionDimensiones.getPosiciones()[0]));
			this.add(this.iniciarPropTxtCodigoAgencia(posicionDimensiones.getPosiciones()[1]));
			this.add(this.iniciarPropTxtNombreAgencia(this.calcularRectanguloDescripcion(posicionDimensiones)));
			
		}
		
		if(this.caja!=null){
			
			posicionDimensiones = this.obtenerPosicionDimensiones();
			this.add(this.iniciarPropLblCaja(posicionDimensiones.getPosiciones()[0]));
			this.add(this.iniciarPropTxtCodigoCaja(posicionDimensiones.getPosiciones()[1]));
			this.add(this.iniciarPropTxtDescripcionCaja(this.calcularRectanguloDescripcion(posicionDimensiones)));
			
		}
		
	}
	
	private EnumDimensionesComponentes calcularRectanguloDescripcion(PosicionDimensiones posicionDimensiones)throws Exception{
		
		int anchoRectangulo;
		
		anchoRectangulo = this.getWidth() - posicionDimensiones.getPosiciones()[2].getX()-5;
		
		posicionDimensiones.getPosiciones()[2].getRectangulo().setBounds(new Rectangle(posicionDimensiones.getPosiciones()[2].getX(),
				 																	   posicionDimensiones.getPosiciones()[2].getY(),
				 																	   anchoRectangulo,
				 																	   posicionDimensiones.getPosiciones()[2].getAlto()));
		
		return posicionDimensiones.getPosiciones()[2];
		
	}
	
	public EtiquetaUtil iniciarPropLblEmpresa(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblEmpresa==null){
			
			this.lblEmpresa = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																		  "lblEmpresa",
																		  EnumEtiquetas.LBL_PNL_ENC_EMPRESA,
																		  true,
																		  null,
																		  true);
		}
		
		return this.lblEmpresa;
		
	}
	
	public EtiquetaUtil iniciarPropLblAgencia(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblAgencia==null){
			
			this.lblAgencia = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																		  "lblAgencia", 
																		  EnumEtiquetas.LBL_PNL_ENC_AGENCIA,
																		  true,
																		  null,
																		  true);
		}
		
		return this.lblAgencia;
		
	}
	
	public EtiquetaUtil iniciarPropLblCaja(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblCaja==null){
			
			this.lblCaja = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																	   "lblCaja", 
																	   EnumEtiquetas.LBL_PNL_ENC_CAJA,
																	   true,
																	   null,
																	   true);
		}
		
		return this.lblCaja;
		
	}
	
	public CajaTextoUtil iniciarPropTxtCodigoEmpresa(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtCodigoEmpresa==null){
			
			this.txtCodigoEmpresa = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																					"txtCodigoEmpresa", 
																					this.empresa.getCodigo(), 
																					true, 
																					false, 
																					true, 
																					null,
																					null);
			
			this.txtCodigoEmpresa.setToolTipText(EnumEtiquetas.TLT_PNL_ENC_EMPRESA_COD);
		}
		
		return this.txtCodigoEmpresa;
		
	}
	
	public CajaTextoUtil iniciarPropTxtCodigoAgencia(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtCodigoAgencia==null){
			
			this.txtCodigoAgencia = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																					"txtCodigoAgencia", 
																					this.agencia.getCodigo(), 
																					true, 
																					false, 
																					true, 
																					null,
																					null);
			
			this.txtCodigoAgencia.setToolTipText(EnumEtiquetas.TLT_PNL_ENC_AGENCIA_COD);
		}
		
		return this.txtCodigoAgencia;
		
	}
	
	public CajaTextoUtil iniciarPropTxtCodigoCaja(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtCodigoCaja==null){
			
			this.txtCodigoCaja = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																				 "txtCodigoCaja", 
																				 this.caja.getCodigo(), 
																				 true, 
																				 false, 
																				 true, 
																				 null,
																				 null);
			
			this.txtCodigoCaja.setToolTipText(EnumEtiquetas.TLT_PNL_ENC_CAJA_COD);
		}
		
		return this.txtCodigoCaja;
		
	}
	
	public CajaTextoUtil iniciarPropTxtNombreEmpresa(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtNombreEmpresa==null){
			
			this.txtNombreEmpresa = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																					"txtNombreEmpresa", 
																					this.empresa.getNombre(), 
																					true, 
																					false, 
																					true, 
																					null,
																					null);
			
			this.txtNombreEmpresa.setToolTipText(EnumEtiquetas.TLT_PNL_ENC_EMPRESA_DESC);
		}
		
		return this.txtNombreEmpresa;
		
	}
	
	public CajaTextoUtil iniciarPropTxtNombreAgencia(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtNombreAgencia==null){
			
			this.txtNombreAgencia = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																					"txtNombreAgencia", 
																					this.agencia.getNombre(), 
																					true, 
																					false, 
																					true, 
																					null,
																					null);
			
			this.txtNombreAgencia.setToolTipText(EnumEtiquetas.TLT_PNL_ENC_AGENCIA_DESC);
		}
		
		return this.txtNombreAgencia;
		
	}
	
	public CajaTextoUtil iniciarPropTxtDescripcionCaja(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.txtDescripcionCaja==null){
			
			this.txtDescripcionCaja = UtilComponentesGUI.getInstance().crearTextField(pEnmDimension, 
																					  "txtDescripcionCaja", 
																					  this.caja.getDescripcion(), 
																					  true, 
																					  false, 
																					  true, 
																					  null,
																					  null);
			
			this.txtDescripcionCaja.setToolTipText(EnumEtiquetas.TLT_PNL_ENC_CAJA_DESC);
		}
		
		return this.txtDescripcionCaja;
		
	}
	
	private void configurarPosicionDimensiones()throws Exception{
		
		listadoDimensiones = new ArrayList<PosicionDimensiones>();
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_ENC_SECCION_XY_11,
				  														 EnumDimensionesComponentes.PNL_ENC_SECCION_XY_12,
				  														 EnumDimensionesComponentes.PNL_ENC_SECCION_XY_13});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_ENC_SECCION_XY_21,
				  														 EnumDimensionesComponentes.PNL_ENC_SECCION_XY_22,
				  														 EnumDimensionesComponentes.PNL_ENC_SECCION_XY_23});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_ENC_SECCION_XY_31,
				  														 EnumDimensionesComponentes.PNL_ENC_SECCION_XY_32,
				  														 EnumDimensionesComponentes.PNL_ENC_SECCION_XY_33});		
	}
	
	private void agregarPosicionDimensiones(EnumDimensionesComponentes dimensiones[])throws Exception{
		
		this.listadoDimensiones.add(new PosicionDimensiones(dimensiones));
		
	}
	
	private PosicionDimensiones obtenerPosicionDimensiones()throws Exception{
		
		PosicionDimensiones posicionDimensiones;

		posicionDimensiones = listadoDimensiones.get(0);
		listadoDimensiones.remove(posicionDimensiones);
		
		return posicionDimensiones;
		
	}

	public EtiquetaUtil getLblEmpresa() {
		return lblEmpresa;
	}

	public void setLblEmpresa(EtiquetaUtil lblEmpresa) {
		this.lblEmpresa = lblEmpresa;
	}

	public EtiquetaUtil getLblAgencia() {
		return lblAgencia;
	}

	public void setLblAgencia(EtiquetaUtil lblAgencia) {
		this.lblAgencia = lblAgencia;
	}

	public EtiquetaUtil getLblCaja() {
		return lblCaja;
	}

	public void setLblCaja(EtiquetaUtil lblCaja) {
		this.lblCaja = lblCaja;
	}

	public CajaTextoUtil getTxtCodigoAgencia() {
		return txtCodigoAgencia;
	}

	public void setTxtCodigoAgencia(CajaTextoUtil txtCodigoAgencia) {
		this.txtCodigoAgencia = txtCodigoAgencia;
	}

	public CajaTextoUtil getTxtCodigoCaja() {
		return txtCodigoCaja;
	}

	public void setTxtCodigoCaja(CajaTextoUtil txtCodigoCaja) {
		this.txtCodigoCaja = txtCodigoCaja;
	}

	public CajaTextoUtil getTxtCodigoEmpresa() {
		return txtCodigoEmpresa;
	}

	public void setTxtCodigoEmpresa(CajaTextoUtil txtCodigoEmpresa) {
		this.txtCodigoEmpresa = txtCodigoEmpresa;
	}

	public CajaTextoUtil getTxtNombreEmpresa() {
		return txtNombreEmpresa;
	}

	public void setTxtNombreEmpresa(CajaTextoUtil txtNombreEmpresa) {
		this.txtNombreEmpresa = txtNombreEmpresa;
	}

	public CajaTextoUtil getTxtNombreAgencia() {
		return txtNombreAgencia;
	}

	public void setTxtNombreAgencia(CajaTextoUtil txtNombreAgencia) {
		this.txtNombreAgencia = txtNombreAgencia;
	}

	public CajaTextoUtil getTxtDescripcionCaja() {
		return txtDescripcionCaja;
	}

	public void setTxtDescripcionCaja(CajaTextoUtil txtDescripcionCaja) {
		this.txtDescripcionCaja = txtDescripcionCaja;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}	
	
}