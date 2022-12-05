package co.com.codesa.clienteposslimgiros.formas.genericas;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.com.codesa.clienteposslimgiros.dto.PosicionDimensiones;
import co.com.codesa.clienteposslimgiros.dto.territorio.ConfigTerritorioDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.gui.EnumColores;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.eventos.generico.EventoFormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.SeccionUtil;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;


public class FormaPanelTerritorio extends SeccionUtil{

	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblTituloCombos;
	private EtiquetaUtil lblTituloEtiquetas;
	
	private EtiquetaUtil lblPais;
	private CajaComboUtil cmbPais;
	
	private EtiquetaUtil lblDepartamento;
	private CajaComboUtil cmbDepartamento;
	
	private EtiquetaUtil lblMunicipio;
	private CajaComboUtil cmbMunicipio;
	
	private EtiquetaUtil lblZona;
	private CajaComboUtil cmbZona;
	
	private EtiquetaUtil lblAgencia;
	private CajaComboUtil cmbAgencia;	
	
	private EventoAbstracto eventosForma;
	
	private List<PosicionDimensiones> listadoDimensiones;
	
	public FormaPanelTerritorio(String pStrNombreComponente,
			boolean pTituloCabecera, //si es nulo no lo muestra
			boolean pTituloCombo,
			String pNombresCombo[],
			int pSeccion,//seccion desde la cual se ejecutara el analisis (pais[0],depto[1],municipio[2],zona[3])
			boolean pAPartir,//true: arriba/bajo false: bajo/arriba
			boolean pActivaAgencia,
			EnumDimensionesComponentes pEnmDimensionPanel,
			Territorio pDepartamentoBase) throws Exception
	{
		this(	pStrNombreComponente,
				pTituloCabecera, //si es nulo no lo muestra
				pTituloCombo,
				pNombresCombo,
				pSeccion,//seccion desde la cual se ejecutara el analisis (pais[0],depto[1],municipio[2],zona[3])
				pAPartir,//true: arriba/bajo false: bajo/arriba
				pActivaAgencia,
				pEnmDimensionPanel,
				pDepartamentoBase,
				null);
	}
	
	public FormaPanelTerritorio(String pStrNombreComponente,
								boolean pTituloCabecera, //si es nulo no lo muestra
								boolean pTituloCombo,
								String pNombresCombo[],
								int pSeccion,//seccion desde la cual se ejecutara el analisis (pais[0],depto[1],municipio[2],zona[3])
								boolean pAPartir,//true: arriba/bajo false: bajo/arriba
								boolean pActivaAgencia,
								EnumDimensionesComponentes pEnmDimensionPanel,
								Territorio pDepartamentoBase,
								ConfigTerritorioDTO pObjDtoConfigTerritorio) throws Exception{
		
		super	(	pEnmDimensionPanel,
					pStrNombreComponente,
					BorderFactory.createEmptyBorder(),
					null,
					null
				);
		
		this.inicializarForma(pTituloCabecera,
							  pTituloCombo,
							  pNombresCombo,
							  pSeccion,
							  pAPartir,
							  pActivaAgencia,
							  pDepartamentoBase,
							  pObjDtoConfigTerritorio);
		
		this.iniciarValores();
		
	}	
	
	private void iniciarValores()throws Exception{
		this.castEventosForma().iniciarValores();
	}

	private void inicializarForma(boolean pTituloCabecera,
								  boolean pTituloCombo,
								  String pNombresCombo[],
								  int pSeccion,
								  boolean pAPartir,
								  boolean pActivaAgencia,
								  Territorio pDepartamentoBase,
								  ConfigTerritorioDTO pObjDtoConfigTerritorio)throws Exception{
		
		PosicionDimensiones posicionDimensiones;
		boolean habilitarTerritorios[];
		int contador=0;
		
		super.setBooAplicarTransparenciaFondo(true);
		
		this.eventosForma = new EventoFormaPanelTerritorio(this,
				   										   pDepartamentoBase,
				   										pObjDtoConfigTerritorio); 
		
		this.configurarPosicionDimensiones();
		
		if(pTituloCabecera){
		
			posicionDimensiones = this.obtenerPosicionDimensiones();
			this.add(this.iniciarPropLblTituloEtiquetas(posicionDimensiones.getPosiciones()[0]));
			this.add(this.iniciarPropLblTituloCombos(this.calcularRectanguloCombo(posicionDimensiones,
																				  pTituloCombo)));
		}
		
		habilitarTerritorios = this.habilitarTerritorios(pSeccion, 
														 pAPartir);
		
		if(habilitarTerritorios[0]){
			
			posicionDimensiones = this.obtenerPosicionDimensiones();
			
			if(pTituloCombo){
				this.add(this.iniciarPropLblPais(posicionDimensiones.getPosiciones()[0]));
			}
			
			this.add(this.iniciarPropCmbPais(this.calcularRectanguloCombo(posicionDimensiones,
																				pTituloCombo),
											 pNombresCombo[contador]));
			contador++;
		}
		
		if(habilitarTerritorios[1]){
			
			posicionDimensiones = this.obtenerPosicionDimensiones();
			
			if(pTituloCombo){
				this.add(this.iniciarPropLblDepartamento(posicionDimensiones.getPosiciones()[0]));
			}
			
			this.add(this.iniciarPropCmbDepartamento(this.calcularRectanguloCombo(posicionDimensiones,
																					    pTituloCombo),
													 pNombresCombo[contador]));
			contador++;
		}
		
		if(habilitarTerritorios[2]){
		
			posicionDimensiones = this.obtenerPosicionDimensiones();
			
			if(pTituloCombo){
				this.add(this.iniciarPropLblMunicipio(posicionDimensiones.getPosiciones()[0]));
			}
			
			this.add(this.iniciarPropCmbMunicipio(this.calcularRectanguloCombo(posicionDimensiones,
																					 pTituloCombo),
												  pNombresCombo[contador]));
			contador++;
			
		}
		
		if(habilitarTerritorios[3]){
		
			posicionDimensiones = this.obtenerPosicionDimensiones();
			
			if(pTituloCombo){
				this.add(this.iniciarPropLblZona(posicionDimensiones.getPosiciones()[0]));
			}
			
			this.add(this.iniciarPropCmbZona(this.calcularRectanguloCombo(posicionDimensiones,
																				pTituloCombo),
											 pNombresCombo[contador]));
			contador++;
			
		}
		
		if(pActivaAgencia){
			
			posicionDimensiones = this.obtenerPosicionDimensiones();
			
			if(pTituloCombo){
				this.add(this.iniciarPropLblAgencia(posicionDimensiones.getPosiciones()[0]));
			}
			
			this.add(this.iniciarPropCmbAgencia(this.calcularRectanguloCombo(posicionDimensiones,
																				   pTituloCombo),
											 	pNombresCombo[contador]));
			contador++;
		}
		
	}
	
	private boolean[] habilitarTerritorios(int pSeccion,
			  							   boolean pAPartir)throws Exception{
		
		boolean habilitarTerritorios[];
		int intCantSecciones;
		
		intCantSecciones = Integer.parseInt(EnumParametrosApp.PNL_TERR_CANT_SECCIONES.getValorPropiedad());
		
		habilitarTerritorios = new boolean[intCantSecciones];
		
		if(pAPartir){
			
			for(int i=pSeccion;i<habilitarTerritorios.length;i++){
				habilitarTerritorios[i]=true;
			}
		}else{
			for(int i=pSeccion;i>=0;i--){
				habilitarTerritorios[i]=true;
			}
		}
		
		return habilitarTerritorios;
		
	}
	
	private EnumDimensionesComponentes calcularRectanguloCombo(PosicionDimensiones pPosicionDimensiones,
											  boolean pTituloCombo)throws Exception{
		
		Rectangle objRecDimension;
		int anchoRectangulo;
		int posX;
		
		objRecDimension = pPosicionDimensiones.getPosiciones()[1].getRectangulo();
		
		if(pTituloCombo){
			posX = pPosicionDimensiones.getPosiciones()[1].getX();
		}else{
			posX=pPosicionDimensiones.getPosiciones()[0].getX()+7;
		}
		
		anchoRectangulo = this.getWidth() - posX-5;
		
		objRecDimension.setBounds(new Rectangle(posX,
				 								pPosicionDimensiones.getPosiciones()[1].getY(),
				 								anchoRectangulo,
				 								pPosicionDimensiones.getPosiciones()[1].getAlto()));
		
		return pPosicionDimensiones.getPosiciones()[1];
		
	}

	private void configurarPosicionDimensiones()throws Exception{
		
		this.listadoDimensiones = new ArrayList<PosicionDimensiones>();
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_TERR_SECCION_XY_01,
					 													 EnumDimensionesComponentes.PNL_TERR_SECCION_XY_02});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_TERR_SECCION_XY_11,
				  														 EnumDimensionesComponentes.PNL_TERR_SECCION_XY_12});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_TERR_SECCION_XY_21,
					 													 EnumDimensionesComponentes.PNL_TERR_SECCION_XY_22});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_TERR_SECCION_XY_31,
				 														 EnumDimensionesComponentes.PNL_TERR_SECCION_XY_32});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_TERR_SECCION_XY_41,
				 														 EnumDimensionesComponentes.PNL_TERR_SECCION_XY_42});
		
		this.agregarPosicionDimensiones(new EnumDimensionesComponentes[]{EnumDimensionesComponentes.PNL_TERR_SECCION_XY_51,
				 														 EnumDimensionesComponentes.PNL_TERR_SECCION_XY_52});
		
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
	
	public EtiquetaUtil iniciarPropLblTituloCombos(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblTituloCombos==null){
			
			this.lblTituloCombos = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																   	 	   	   "lblTituloCombos", 
																   	 	   	   EnumEtiquetas.LBL_PNL_TERR_TTL_COMBOS,
																   	 	   	   false,
																   	 	   	   null, 
																   	 	   	   true);
			this.lblTituloCombos.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblTituloCombos;
		
	}
	
	public EtiquetaUtil iniciarPropLblTituloEtiquetas(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblTituloEtiquetas==null){
			
			this.lblTituloEtiquetas = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																   	 		  	  "lblTituloEtiquetas", 
																   	 		  	  EnumEtiquetas.LBL_PNL_TERR_TTL_ETIQUETAS,
																   	 		  	  false,
																   	 		  	  null,
																   	 		  	  true);
			this.lblTituloEtiquetas.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		return this.lblTituloEtiquetas;
		
	}
	
	public EtiquetaUtil iniciarPropLblPais(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblPais==null){
			
			this.lblPais = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																	   "lblPais", 
																	   EnumEtiquetas.LBL_PNL_TERR_PAIS,
																	   true,
																	   null,
																	   true);
		}
		
		return this.lblPais;
		
	}
	
	public CajaComboUtil iniciarPropCmbPais(EnumDimensionesComponentes pEnmDimension,
									    	String pNombre)throws Exception{
		
		if(this.cmbPais==null){
			
			this.cmbPais = UtilComponentesGUI.getInstance().crearComboBox(pEnmDimension, 
																		  pNombre, 
																		  true, 
																		  true, 
																		  this.eventosForma,
																		  EnumEtiquetas.LBL_PNL_TERR_PAIS);
			//this.nombreCmbPais=pNombre;
		}
		
		return this.cmbPais;
		
	}
	
	public EtiquetaUtil iniciarPropLblDepartamento(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblDepartamento==null){
			
			this.lblDepartamento = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																			   "lblDepartamento", 
																			   EnumEtiquetas.LBL_PNL_TERR_DEPARTAMENTO,
																			   true,
																			   null, 
																			   true);
		}
		
		return this.lblDepartamento;
		
	}
	
	public CajaComboUtil iniciarPropCmbDepartamento(EnumDimensionesComponentes pEnmDimension,
													String pNombre)throws Exception{
		
		if(this.cmbDepartamento==null){
			
			this.cmbDepartamento = UtilComponentesGUI.getInstance().crearComboBox(pEnmDimension, 
																				  pNombre, 
																				  true, 
																				  true, 
																				  this.eventosForma,
																				  EnumEtiquetas.LBL_PNL_TERR_DEPARTAMENTO);
			//this.nombreCmbDepartamento=pNombre;
		}
		
		return this.cmbDepartamento;
		
	}
	
	public EtiquetaUtil iniciarPropLblMunicipio(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblMunicipio==null){
			
			this.lblMunicipio = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																			"lblMunicipio", 
																			EnumEtiquetas.LBL_PNL_TERR_MUNICIPIO,
																			true,
																			null, 
																			true);
		}
		
		return this.lblMunicipio;
		
	}
	
	public CajaComboUtil iniciarPropCmbMunicipio(EnumDimensionesComponentes pEnmDimension,
											 	 String pNombre)throws Exception{
		
		if(this.cmbMunicipio==null){
			
			this.cmbMunicipio = UtilComponentesGUI.getInstance().crearComboBox(pEnmDimension, 
																			   pNombre, 
																			   true, 
																			   true, 
																			   this.eventosForma,
																			   EnumEtiquetas.LBL_PNL_TERR_MUNICIPIO);
			//this.nombreCmbMunicipio=pNombre;
		}
		
		return this.cmbMunicipio;
		
	}
	
	public EtiquetaUtil iniciarPropLblZona(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblZona==null){
			
			this.lblZona = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																	   "lblZona", 
																	   EnumEtiquetas.LBL_PNL_TERR_ZONA,
																	   true,
																	   null, 
																	   true);
		}
		
		return this.lblZona;
		
	}
	
	public CajaComboUtil iniciarPropCmbZona(EnumDimensionesComponentes pEnmDimension,
											String pNombre)throws Exception{
		
		if(this.cmbZona==null){
			
			this.cmbZona = UtilComponentesGUI.getInstance().crearComboBox(pEnmDimension, 
																		  pNombre, 
																		  true, 
																		  true, 
																		  this.eventosForma,
																		  EnumEtiquetas.LBL_PNL_TERR_ZONA);
			//this.nombreCmbZona = pNombre;
		}
		
		return this.cmbZona;
		
	}
	
	public EtiquetaUtil iniciarPropLblAgencia(EnumDimensionesComponentes pEnmDimension)throws Exception{
		
		if(this.lblAgencia==null){
			
			this.lblAgencia = UtilComponentesGUI.getInstance().crearLabel(pEnmDimension,
																		  "lblAgencia", 
																		  EnumEtiquetas.LBL_PNL_TERR_AGENCIA,
																		  true,
																		  null, 
																		  true);
		}
		
		return this.lblAgencia;
		
	}
	
	public CajaComboUtil iniciarPropCmbAgencia(EnumDimensionesComponentes pEnmDimension,
										   String pNombre)throws Exception{

		if(this.cmbAgencia==null){

			this.cmbAgencia = UtilComponentesGUI.getInstance().crearComboBox(pEnmDimension, 
																		 	 pNombre, 
																		 	 true, 
																		 	 true, 
																		 	 this.eventosForma,
																		 	 EnumEtiquetas.LBL_PNL_TERR_AGENCIA);
			//this.nombreCmbAgencia = pNombre;
		}

		return this.cmbAgencia;

	}
	
	public Agencia obtenerAgenciaCombo()throws Exception{
		
		Agencia agencia;
		
		agencia = this.castEventosForma().obtenerAgenciaCombo(this.cmbAgencia);
		
		return agencia;
		
	}
	
	public void habilitarComponenteCompleto(boolean habilitar)throws Exception{
		
		if(this.castEventosForma().validarComboPais()){
			this.cmbPais.setEnabled(habilitar);
		}
		
		if(this.castEventosForma().validarComboDepartamento()){
			this.cmbDepartamento.setEnabled(habilitar);
		}
		
		if(this.castEventosForma().validarComboMunicipio()){
			this.cmbMunicipio.setEnabled(habilitar);
		}
		
		if(this.castEventosForma().validarComboZona()){
			this.cmbZona.setEnabled(habilitar);
		}
		
		if(this.castEventosForma().validarComboAgencia()){
			this.cmbAgencia.setEnabled(habilitar);
		}
		
	}
	
	public void habilitarCombo(String nombreComponente,
							   boolean habilitar)throws Exception{
		
		if(castEventosForma().validarComboPais() && 
				nombreComponente.equals(this.cmbPais.getName())){
			
			this.cmbPais.setEnabled(habilitar);
			
		}else if(castEventosForma().validarComboDepartamento() &&
					nombreComponente.equals(this.cmbDepartamento.getName())){
			
			this.cmbDepartamento.setEnabled(habilitar);
			
		}else if(castEventosForma().validarComboMunicipio() &&
					nombreComponente.equals(this.cmbMunicipio.getName())){
			
			this.cmbMunicipio.setEnabled(habilitar);
			
		}else if(castEventosForma().validarComboZona() &&
					nombreComponente.equals(this.cmbZona.getName())){
			
			this.cmbZona.setEnabled(habilitar);
			
		}else if(castEventosForma().validarComboAgencia() &&
					nombreComponente.equals(this.cmbAgencia.getName())){
			
			this.cmbAgencia.setEnabled(habilitar);
			
		}
		
	}
	
	public EventoFormaPanelTerritorio castEventosForma()throws Exception{
		return (EventoFormaPanelTerritorio)this.eventosForma;
	}

	public EtiquetaUtil getLblTituloCombos() {
		return lblTituloCombos;
	}

	public void setLblTituloCombos(EtiquetaUtil lblTituloCombos) {
		this.lblTituloCombos = lblTituloCombos;
	}

	public EtiquetaUtil getLblTituloEtiquetas() {
		return lblTituloEtiquetas;
	}

	public void setLblTituloEtiquetas(EtiquetaUtil lblTituloEtiquetas) {
		this.lblTituloEtiquetas = lblTituloEtiquetas;
	}

	public EventoAbstracto getEventosForma() {
		return eventosForma;
	}

	public void setEventosForma(EventoAbstracto eventosForma) {
		this.eventosForma = eventosForma;
	}

	public List<PosicionDimensiones> getListadoDimensiones() {
		return listadoDimensiones;
	}

	public void setListadoDimensiones(List<PosicionDimensiones> listadoDimensiones) {
		this.listadoDimensiones = listadoDimensiones;
	}

	public EtiquetaUtil getLblPais() {
		return lblPais;
	}

	public void setLblPais(EtiquetaUtil lblPais) {
		this.lblPais = lblPais;
	}

	public CajaComboUtil getCmbPais() {
		return cmbPais;
	}

	public void setCmbPais(CajaComboUtil cmbPais) {
		this.cmbPais = cmbPais;
	}

	public EtiquetaUtil getLblDepartamento() {
		return lblDepartamento;
	}

	public void setLblDepartamento(EtiquetaUtil lblDepartamento) {
		this.lblDepartamento = lblDepartamento;
	}

	public CajaComboUtil getCmbDepartamento() {
		return cmbDepartamento;
	}

	public void setCmbDepartamento(CajaComboUtil cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}

	public EtiquetaUtil getLblMunicipio() {
		return lblMunicipio;
	}

	public void setLblMunicipio(EtiquetaUtil lblMunicipio) {
		this.lblMunicipio = lblMunicipio;
	}

	public CajaComboUtil getCmbMunicipio() {
		return cmbMunicipio;
	}

	public void setCmbMunicipio(CajaComboUtil cmbMunicipio) {
		this.cmbMunicipio = cmbMunicipio;
	}

	public EtiquetaUtil getLblZona() {
		return lblZona;
	}

	public void setLblZona(EtiquetaUtil lblZona) {
		this.lblZona = lblZona;
	}

	public CajaComboUtil getCmbZona() {
		return cmbZona;
	}

	public void setCmbZona(CajaComboUtil cmbZona) {
		this.cmbZona = cmbZona;
	}
	
	/*public String getNombreCmbPais() {
		return nombreCmbPais;
	}

	public void setNombreCmbPais(String nombreCmbPais) {
		this.nombreCmbPais = nombreCmbPais;
	}

	public String getNombreCmbDepartamento() {
		return nombreCmbDepartamento;
	}

	public void setNombreCmbDepartamento(String nombreCmbDepartamento) {
		this.nombreCmbDepartamento = nombreCmbDepartamento;
	}

	public String getNombreCmbMunicipio() {
		return nombreCmbMunicipio;
	}

	public void setNombreCmbMunicipio(String nombreCmbMunicipio) {
		this.nombreCmbMunicipio = nombreCmbMunicipio;
	}

	public String getNombreCmbZona() {
		return nombreCmbZona;
	}

	public void setNombreCmbZona(String nombreCmbZona) {
		this.nombreCmbZona = nombreCmbZona;
	}
	
	public String getNombreCmbAgencia() {
		return nombreCmbAgencia;
	}

	public void setNombreCmbAgencia(String nombreCmbAgencia) {
		this.nombreCmbAgencia = nombreCmbAgencia;
	}
	
	*/

	public EtiquetaUtil getLblAgencia() {
		return lblAgencia;
	}

	public void setLblAgencia(EtiquetaUtil lblAgencia) {
		this.lblAgencia = lblAgencia;
	}

	public CajaComboUtil getCmbAgencia() {
		return cmbAgencia;
	}

	public void setCmbAgencia(CajaComboUtil cmbAgencia) {
		this.cmbAgencia = cmbAgencia;
	}
	
	public static void main(String args[]){
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(null,true, EnumDesplegarFormaConEventos.NO);
			
			JPanel panelContenido = new JPanel ();
			panelContenido.setLayout(null);
			JDialog dialogo = new JDialog();
			
			dialogo.setBounds(0, 0, 500, 500);
			
			FormaPanelTerritorio forma;
			
			forma = new FormaPanelTerritorio("forma",
											false,//pTitulos
											 false,
											  new String[]{"cmbPais","cmbDepto","cmbMunicipio","cmbAgencia"},
											  1,//pCategoria
											  true,//pAPartir
											  true,
											  EnumDimensionesComponentes.JPN_EGP_PANEL_AGENCIA_ORG,//rectangulo
											  null);//deptoBase
			
			/*((EventoFormaPanelTerritorio)forma.getEventosForma()).definirTerritorioBase(SIMSConstants.MUNICIPIO_CODE,
																						 "76001");*/
			
			forma.setBorder(BorderFactory.createEtchedBorder());
			
			panelContenido.add(forma);
			
			dialogo.add(panelContenido);
			
			dialogo.setVisible(true);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}