
package co.com.codesa.clienteposslimgiros.eventos.generico;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import co.com.codesa.clienteposslimgiros.dto.direccion.ConfigDireccionDTO;
import co.com.codesa.clienteposslimgiros.dto.territorio.ConfigTerritorioDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.peticionMultiservicio.EnumPeticionesMultiservicio;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelTerritorio;
import co.com.codesa.clienteposslimgiros.utilidades.xml.XmlTerritorio;
import co.com.codesa.clienteposslimgiros.vista.logica.AgenciaVistaLogica;
import co.com.codesa.clienteposslimgiros.vista.logica.Internacional.territorio.TerritorioInternacionalVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Agencia;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.TerritorioInternacional;


public class EventoFormaPanelTerritorio extends EventoAbstracto {

	private FormaPanelTerritorio frmPnlTerritorio;
	private Territorio departamentoBase;
	private Territorio paisSeleccionado;
	private Territorio departamentoSeleccionado;
	private Territorio municipioSeleccionado;
	private Territorio municipioAgencias;
	private String valorGiro;
	
	/**
	 * @variable	objDtoConfigTerritorio
	 * 				Objeto DTO encargado de almacenar toda la configuracion 
	 *				relacionada con el componente generico para determinar un 
	 *				territorio
	 */
	private ConfigTerritorioDTO objDtoConfigTerritorio;
	
	public EventoFormaPanelTerritorio	(	FormaPanelTerritorio pFrmPnlTerritorio,
											Territorio pObjTerDepartamentoBase,
											ConfigTerritorioDTO pObjDtoConfigTerritorio
									  	) 
		throws Exception
	{
		this.frmPnlTerritorio = pFrmPnlTerritorio;
		this.departamentoBase = pObjTerDepartamentoBase;
		this.valorGiro="0";
		this.setObjDtoConfigTerritorio(pObjDtoConfigTerritorio);
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		
		Territorio paisColombia;
		
		if(this.validarComboZona()){
			
			this.crearModeloCombo(this.frmPnlTerritorio.getCmbZona(),
								  XmlTerritorio.getInstance().getTmZona().values().toArray(),
								  null);
			
		}
		
		paisColombia = XmlTerritorio.getInstance().obtenerPais(EnumParametrosApp.CODIGO_DANE_COLOMBIA.getValorPropiedad());
		
		if(this.validarComboPais()){
			
			this.crearModeloCombo(this.frmPnlTerritorio.getCmbPais(),
								  this.getObjDtoConfigTerritorio().getTmPais().values().toArray(),
								  paisColombia);
			
		}else if (this.validarComboDepartamento()){
			
			this.crearModeloCombo(this.frmPnlTerritorio.getCmbDepartamento(),
								  paisColombia.getTerritoriosHijos().values().toArray(),
								  null);
			
		}else if(this.validarComboMunicipio()){
			
			if(this.departamentoBase!=null){
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbMunicipio(),
									  this.departamentoBase.getTerritoriosHijos().values().toArray(),
									  null);
			}else{
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbMunicipio(),
						  			  null,
						  			  null);
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		Component componente;
		
		try{
		
			componente = (Component)actionEvent.getSource();
			
			if(componente instanceof JComboBox){
				
				this.cargarCombosTerritorio((JComboBox)componente);
			}
				
		}catch(Exception e){
			super.controlExcepcion(e);
		}
		
	}
	
	@Override
	public void focusGained(FocusEvent focusEvent) {
		
		Component componente;
		JComboBox comboAgencia;
		
		try{
		
			componente = (Component)focusEvent.getSource();
			
			if(componente instanceof JComboBox){
				
				comboAgencia = (JComboBox)componente;
				
				if(comboAgencia.equals(this.frmPnlTerritorio.getCmbAgencia())){
					this.cargarComboAgencia(comboAgencia);
				}
			
			}
				
		}catch(Exception e){
			super.controlExcepcion(e);
		}
		
	}
	
	private void crearModeloCombo(JComboBox combo,
								  Object[] items,
								  Object seleccionar)throws Exception{

		DefaultComboBoxModel modelCombo;

		if(combo!=null){

			if	(		items!=null 
					&& 	items.length!=0
				)
			{
				Arrays.sort(items, new Comparator<Object>(){
					@Override
				    public int compare(Object emp1, Object emp2) {
				        return emp1.toString().compareTo(emp2.toString());
				    }
				});
				
				modelCombo = new DefaultComboBoxModel(items);
				modelCombo.insertElementAt(EnumEtiquetas.LBL_NO_SELECCIONADO, 0);

			}else{
				modelCombo = new DefaultComboBoxModel(new Object[]{EnumEtiquetas.LBL_NO_SELECCIONADO});
			}

			combo.setModel(modelCombo);

			if(seleccionar!=null){
				combo.setSelectedItem(seleccionar);
			}else{
				combo.setSelectedItem(combo.getSelectedItem());
			}

		}

	}
	
	public void cargarComboAgencia(JComboBox combo)throws Exception{
		
		List<Agencia> listaAgencias;
		
		if(this.municipioSeleccionado!=null && 
				!this.municipioSeleccionado.equals(this.municipioAgencias)){
			
			this.municipioAgencias = this.municipioSeleccionado;
			
			listaAgencias = AgenciaVistaLogica.getInstance().consultarAgenciasPorTerritorio(super.getObjUsuario(),
																							this.municipioSeleccionado,
																			 				this.valorGiro,
																			 				true);
			this.crearModeloCombo(combo,
								  listaAgencias.toArray(),
								  null);
		}
	}
	
	private void cargarCombosTerritorio(JComboBox comboSeleccionado)throws Exception{
		
		Object[] items = null;
		Territorio territorioSeleccionado;
		
		if(comboSeleccionado.getSelectedItem() instanceof Territorio){
			
			territorioSeleccionado = (Territorio)comboSeleccionado.getSelectedItem();
			
			if(comboSeleccionado.equals(this.frmPnlTerritorio.getCmbPais())
					&& !territorioSeleccionado.equals(this.paisSeleccionado)){
				
				if(territorioSeleccionado.getTerritoriosHijos()!=null){
				
					items = territorioSeleccionado.getTerritoriosHijos().values().toArray();
				}	else if	(	territorioSeleccionado instanceof TerritorioInternacional	)
				{
					items = TerritorioInternacionalVistaLogica.getInstancia().consultaDepartamentosXPaisInternacional	(	super.getObjUsuario(), 
																															EnumPeticionesMultiservicio.GIN_CONSULTAR_DEPARTAMENTOS.getObjServicioPeticion(), 
																															(TerritorioInternacional)territorioSeleccionado
																														).values().toArray();
				}
				
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbDepartamento(),
									  items,
			  			  			  null);
				
				this.paisSeleccionado = territorioSeleccionado;
				
			}else if(comboSeleccionado.equals(this.frmPnlTerritorio.getCmbDepartamento())
						&& !territorioSeleccionado.equals(this.departamentoSeleccionado)){
				
				if(territorioSeleccionado.getTerritoriosHijos()!=null){
				
					items = territorioSeleccionado.getTerritoriosHijos().values().toArray();
				}	else if	(	territorioSeleccionado instanceof TerritorioInternacional	)
				{
					items = TerritorioInternacionalVistaLogica.getInstancia().consultaMunicipiosXDepartamentoInternacional	(	super.getObjUsuario(), 
																																EnumPeticionesMultiservicio.GIN_CONSULTAR_CIUDADES.getObjServicioPeticion(), 
																																(TerritorioInternacional)territorioSeleccionado
																															).values().toArray();
				}
				
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbMunicipio(),
									  items,
			  			  			  null);
				
				this.departamentoSeleccionado = territorioSeleccionado;
				
			}else if(comboSeleccionado.equals(this.frmPnlTerritorio.getCmbMunicipio())
						&& !territorioSeleccionado.equals(this.municipioSeleccionado)){
				
				if(this.municipioAgencias!=null){
					
					this.crearModeloCombo(this.frmPnlTerritorio.getCmbAgencia(),
							  			  null,
							  			  null);
					
					this.municipioAgencias = null;
				}
				
				this.municipioSeleccionado = territorioSeleccionado;
			}
			
		}else{
			
			if(comboSeleccionado.equals(this.frmPnlTerritorio.getCmbPais())){
				
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbDepartamento(),
									  null,
									  null);
				
				this.paisSeleccionado=null;
				
			}else if(comboSeleccionado.equals(this.frmPnlTerritorio.getCmbDepartamento())){
				
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbMunicipio(),
									  null,
						  			  null);
				
				this.departamentoSeleccionado=null;
				
			}else if(comboSeleccionado.equals(this.frmPnlTerritorio.getCmbMunicipio())
						&& this.municipioAgencias!=null){
				
				this.crearModeloCombo(this.frmPnlTerritorio.getCmbAgencia(),
	  					 					 null,
	  					 					 null);

				this.municipioSeleccionado = null;
				this.municipioAgencias = null;
				
			}
			
		}
		
	}

	private void asignarPais(Territorio territorio)throws Exception{
		
		if(this.frmPnlTerritorio.getCmbPais()!=null && 
				this.frmPnlTerritorio.getCmbPais().isVisible()){
			
			this.frmPnlTerritorio.getCmbPais().setSelectedItem(territorio);
			
		}
		
	}
	
	private void asignarDepartamento(Territorio territorio)throws Exception{
		
		if(this.frmPnlTerritorio.getCmbDepartamento()!=null && 
				this.frmPnlTerritorio.getCmbDepartamento().isVisible()){
			
			this.asignarPais(territorio.getTerritorioPadre());
			
			this.frmPnlTerritorio.getCmbDepartamento().setSelectedItem(territorio);
			
		}
		
	}
	
	private void asignarMunicipio(Territorio territorio)throws Exception{
		
		if(this.frmPnlTerritorio.getCmbMunicipio()!=null && 
				this.frmPnlTerritorio.getCmbMunicipio().isVisible()){
			
			this.asignarPais(territorio.getTerritorioPadre().getTerritorioPadre());
			
			this.asignarDepartamento(territorio.getTerritorioPadre());
			
			this.frmPnlTerritorio.getCmbMunicipio().setSelectedItem(territorio);
			
		}
		
	}
	
	private void asignarZona(Territorio territorio)throws Exception{
		
		if(this.frmPnlTerritorio.getCmbZona()!=null && 
				this.frmPnlTerritorio.getCmbZona().isVisible()){
			
			this.frmPnlTerritorio.getCmbZona().setSelectedItem(territorio);
			
		}
		
	}
	
	public void definirTerritorioBase(Territorio territorio)throws Exception{
		
		int tipoTerritorio;
		
		if(territorio!=null){
			
			tipoTerritorio = territorio.getType();
			
			if(tipoTerritorio == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_PAIS.getValorEntero()){
				this.asignarPais(territorio);
			}else if(tipoTerritorio == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_DEPARTAMENTO.getValorEntero()){
				this.asignarDepartamento(territorio);
			}else if(tipoTerritorio == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero()){
				this.asignarMunicipio(territorio);
			}else if(tipoTerritorio == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_ZONA.getValorEntero()){
				this.asignarZona(territorio);
			}
			
		}
	}
	
	public void definirTerritorioBase(int pCategoria,
									  String pCodigoTerritorio)throws Exception{
		
		Territorio territorio;
		
		if(pCodigoTerritorio!=null && 
				!pCodigoTerritorio.trim().isEmpty()){
		
			if(pCategoria == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_PAIS.getValorEntero()){
				territorio = XmlTerritorio.getInstance().obtenerPais(pCodigoTerritorio);
			}else if(pCategoria == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_DEPARTAMENTO.getValorEntero()){
				territorio = XmlTerritorio.getInstance().obtenerDepartamento(pCodigoTerritorio);
			}else if(pCategoria == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero()){
				territorio = XmlTerritorio.getInstance().obtenerMunicipio(pCodigoTerritorio);
			}else if(pCategoria == EnumParametrosApp.CODIGO_TIPO_TERRITORIO_ZONA.getValorEntero()){
				territorio = XmlTerritorio.getInstance().obtenerZona(pCodigoTerritorio);
			}else{
				territorio = null;
			}
			this.definirTerritorioBase(territorio);
			
		}
	}
	
	public Territorio obtenerTerritorioCombo(String pNombreComponente)throws Exception{
		
		Territorio territorio;
		
		if(this.validarComboPais() && pNombreComponente.equals(this.frmPnlTerritorio.getCmbPais().getName())){
			territorio = this.obtenerTerritorioCombo(this.frmPnlTerritorio.getCmbPais());
		}else if(this.validarComboDepartamento() && pNombreComponente.equals(this.frmPnlTerritorio.getCmbDepartamento().getName())){
			territorio = this.obtenerTerritorioCombo(this.frmPnlTerritorio.getCmbDepartamento());
		}else if(this.validarComboMunicipio() && pNombreComponente.equals(this.frmPnlTerritorio.getCmbMunicipio().getName())){
			territorio = this.obtenerTerritorioCombo(this.frmPnlTerritorio.getCmbMunicipio());
		}else if(this.validarComboZona() && pNombreComponente.equals(this.frmPnlTerritorio.getCmbZona().getName())){
			territorio = this.obtenerTerritorioCombo(this.frmPnlTerritorio.getCmbZona());
		}else{
			territorio = null;
		}
		
		return territorio;
		
	}
	
	private Territorio obtenerTerritorioCombo(JComboBox combo)throws Exception{
		
		Territorio territorio = null;
		
		if(combo!=null &&
				combo.isVisible() &&
				combo.getSelectedItem() instanceof Territorio){
			
			territorio = (Territorio)combo.getSelectedItem();
			
		}
		
		return territorio;
			
	}
	
	public Agencia obtenerAgenciaCombo(JComboBox combo)throws Exception{
		
		Agencia agencia = null;
		
		if(combo!=null &&
				combo.isVisible() &&
				combo.getSelectedItem() instanceof Agencia){
			
			agencia = (Agencia)combo.getSelectedItem();
			
		}
		
		return agencia;
			
	}
	
	public void reestablecerFormaTerritorios()throws Exception{
		
		this.definirTerritorioBase(EnumParametrosApp.CODIGO_TIPO_TERRITORIO_MUNICIPIO.getValorEntero(),
								   EnumParametrosApp.CODIGO_DANE_MUNICIPIO_X_DEFECTO.getValorPropiedad());
		
		if(validarComboAgencia()){
			this.crearModeloCombo(this.frmPnlTerritorio.getCmbAgencia(),
								  null,
								  null);
		}
	}
	
	public boolean validarComboPais()throws Exception{
		return this.frmPnlTerritorio.getCmbPais()!=null && 
					this.frmPnlTerritorio.getCmbPais().isVisible(); 
	}
	
	public boolean validarComboDepartamento()throws Exception{
		return this.frmPnlTerritorio.getCmbDepartamento()!=null && 
					this.frmPnlTerritorio.getCmbDepartamento().isVisible(); 
	}
	
	public boolean validarComboMunicipio()throws Exception{
		return this.frmPnlTerritorio.getCmbMunicipio()!=null && 
					this.frmPnlTerritorio.getCmbMunicipio().isVisible(); 
	}
	
	public boolean validarComboZona()throws Exception{
		return this.frmPnlTerritorio.getCmbZona()!=null && 
					this.frmPnlTerritorio.getCmbZona().isVisible(); 
	}
	
	public boolean validarComboAgencia()throws Exception{
		return this.frmPnlTerritorio.getCmbAgencia()!=null && 
					this.frmPnlTerritorio.getCmbAgencia().isVisible(); 
	}
	
	public FormaPanelTerritorio getForma() {
		return frmPnlTerritorio;
	}

	public void setForma(FormaPanelTerritorio forma) {
		this.frmPnlTerritorio = forma;
	}

	public Territorio getDepartamentoBase() {
		return departamentoBase;
	}

	public void setDepartamentoBase(Territorio departamentoBase) {
		this.departamentoBase = departamentoBase;
	}

	public Territorio getPaisSeleccionado() {
		return paisSeleccionado;
	}

	public void setPaisSeleccionado(Territorio paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}

	public Territorio getDepartamentoSeleccionado() {
		return departamentoSeleccionado;
	}

	public void setDepartamentoSeleccionado(Territorio departamentoSeleccionado) {
		this.departamentoSeleccionado = departamentoSeleccionado;
	}

	public Territorio getMunicipioSeleccionado() {
		return municipioSeleccionado;
	}

	public void setMunicipioSeleccionado(Territorio municipioSeleccionado) {
		this.municipioSeleccionado = municipioSeleccionado;
	}

	public Territorio getMunicipioAgencias() {
		return municipioAgencias;
	}

	public void setMunicipioAgencias(Territorio municipioAgencias) {
		this.municipioAgencias = municipioAgencias;
	}

	public String getValorGiro() {
		return valorGiro;
	}

	public void setValorGiro(String valorGiro) {
		this.valorGiro = valorGiro;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @method	getObjDtoConfigTerritorio
	 * 		  	Metodo get del atributo objDtoConfigTerritorio
	 * @return	ConfigTerritorioDTO
	 *		  	Valor del atributo objDtoConfigTerritorio devuelto
	 * @author	hector.cuenca
	 * @date  	21/03/2018
	 */
	public ConfigTerritorioDTO getObjDtoConfigTerritorio() {
		
		if	(	this.objDtoConfigTerritorio	==	null	)
		{
			this.objDtoConfigTerritorio = new ConfigTerritorioDTO();
		}
		
		return objDtoConfigTerritorio;
	}

	/**
	 * @method	setObjDtoConfigTerritorio
	 * 		  	Metodo set del atributo objDtoConfigTerritorio
	 * @param	pObjDtoConfigTerritorio
	 * 			Valor que tomara el atributo objDtoConfigTerritorio
	 * @author	hector.cuenca
	 * @date	21/03/2018
	 */
	public void setObjDtoConfigTerritorio(ConfigTerritorioDTO pObjDtoConfigTerritorio) {
		this.objDtoConfigTerritorio = pObjDtoConfigTerritorio;
	}
	
}
