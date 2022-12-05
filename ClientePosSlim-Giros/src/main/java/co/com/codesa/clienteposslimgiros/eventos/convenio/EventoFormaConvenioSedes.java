package co.com.codesa.clienteposslimgiros.eventos.convenio;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.Iterator;
import java.util.List;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.convenio.FormaConvenioSedes;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.clienteposslimgiros.vista.logica.TerceroVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Sede;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Territorio;


/**
 * ****************************************************************.
 * @autor: Roberth Martinez Vargas
 * @fecha: 08-abr-2015
 * @descripcion: Clase que representa los eventos de forma Convenio sedes
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class EventoFormaConvenioSedes extends EventoAbstracto{
	
	private List<Sede> lstSedes;
	private Iterator<Sede> iterSede;
	private Object[] fila;
	private int filaSelec;
	private int colSelec;
	private String objSeleccionado;
	
	private Sede sede;
	private Sede sedeSeleccionada;
	private Territorio municipio;
	private Territorio zona;
	
	public EventoFormaConvenioSedes(FormaGenerica pForma) {
		
		super(pForma);
	}

	@Override
	public void iniciarValores(Object ...pArrObjParametrosForma)throws Exception{
		this.llenarInformacionFormulario();
	}
	
	@Override
	public void accionarVentanaDesplegada(WindowEvent pEvtWindowOpened) throws Exception {
		
		this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().getCmbDepartamento().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().getCmbMunicipio().getLblObligatorio().aplicarObligatoriedad(true);
		this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().getCmbZona().getLblObligatorio().aplicarObligatoriedad(true);
	}
	
	@Override
	public void accionarDobleClick(Component pObjComponent,
								   MouseEvent pEvtMouseClicked) throws Exception {
		
		if(pObjComponent.equals(this.castFrmConveniosSedes().getTblSedes())){
			
			this.filaSelec = this.castFrmConveniosSedes().getTblSedes().getSelectedRow();
			this.colSelec = this.castFrmConveniosSedes().getTblSedes().getSelectedColumn();
				
			this.objSeleccionado = this.castFrmConveniosSedes().getTblSedes().getValueAt(this.filaSelec, this.colSelec).toString();
			
			this.verInfoColumna();
		}
	}
	
	@Override
	public void consultar() throws Exception{
		
		this.limpiarDatosTabla();
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().getCmbDepartamento(), 
																	EnumEtiquetas.LBL_PNL_TERR_DEPARTAMENTO.toString(), 
																	true, 
																	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().getCmbMunicipio(), 
															    	EnumEtiquetas.LBL_PNL_TERR_MUNICIPIO.toString(), 
															    	true, 
															    	true);
		
		UtilComponentesGUI.getInstance().validarObligatoriedadCampo(this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().getCmbZona(), 
																	EnumEtiquetas.LBL_PNL_TERR_ZONA.toString(), 
																	true, 
																	true);
		
		
		this.municipio = this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().castEventosForma().obtenerTerritorioCombo("cmbMunicipioSede");
		this.zona = this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().castEventosForma().obtenerTerritorioCombo("cmbZonaSede");
		
		this.lstSedes = TerceroVistaLogica.getInstance().consultarSedesConvenio(super.getObjUsuario(),
																				this.municipio, 
																				this.zona, 
																				this.castFrmConveniosSedes().getConvenio());
		this.adicionarFilas();
	}
	
	@Override
	public void confirmar() throws Exception{
		
		if(!this.castFrmConveniosSedes().getTblSedes().getSelectionModel().isSelectionEmpty()){
			
			this.filaSelec = this.castFrmConveniosSedes().getTblSedes().getSelectedRow();
			this.sedeSeleccionada = null;
			this.sedeSeleccionada = this.lstSedes.get(this.filaSelec);
			super.regresarFormaPadre();
			
		}else{
			
			throw EnumMensajes.DEBE_SELECCIONAR_REGISTRO.generarExcepcion(EnumClasesMensaje.ERROR);
		}
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo llenarInformacionFormulario
     * 		   metodo utilizado para inicializar los datos de la forma 
     * 		   envio giro postal
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void llenarInformacionFormulario()throws Exception{
		
		this.castFrmConveniosSedes().getPnlTerritorioUbicacionSede().castEventosForma().definirTerritorioBase(super.getObjUsuario().getAgencia().getTerritorio());
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo adicionarFilas
     * 		   metodo utilizado para adicionar los datos consultados de
     * 		   las sedes en la tabla 
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void adicionarFilas() throws Exception{
		
		this.iterSede = this.lstSedes.iterator();

		this.sede = null;
		
		while (this.iterSede.hasNext()) {

			this.sede = this.iterSede.next();

			this.fila = new Object[] { this.sede.getCodigo(),
									   this.sede.getNombre(),
									   this.sede.getDireccion(),
									   this.sede.getTelefono(),
									   this.sede.getStrCodigoExterno(),
									   this.sede.getTerceroCrc().toStringXDocumento(),
									   this.sede.getTerceroResponsable().toStringXDocumento(),
									   this.sede.getPrecio()};
						
			this.castFrmConveniosSedes().getTblSedes().getPropiedades().adicionarFilaGrilla(fila);
		}
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo limpiarDatosTabla
     *         Limpia la informacion de la tabla de la ventana
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void limpiarDatosTabla()throws Exception{
		
		this.castFrmConveniosSedes().getTblSedes().getPropiedades().limpiarGrilla();
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo verInfoColumna
     * 		   metodo para mostrar la informacion de las columnas 
     * @autor  Roberth Martinez Vargas
     * ****************************************************************
     */
	private void verInfoColumna() throws Exception{
		
		if (this.objSeleccionado != null){
			
			EnumMensajes.desplegarMensajePersonalizado(super.getFrmForma(), 
													   EnumClasesMensaje.INFORMACION, 
													   null, 
													   this.objSeleccionado);
		}			
	}

	/**
  	 * ****************************************************************.
  	 * @metodo castFrmConveniosSedes
  	 * 		   Metodo estandar para formatear el tipo de dato general a 
  	 * 		   un tipo especifico ("Casteo"), del atributo frmPadre
  	 * @return FormaConvenioSedes
  	 * 		   valor especifico recuperado
  	 * @throws Exception 
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor Hector Q-en-K
  	 * ****************************************************************
  	 */
	public FormaConvenioSedes castFrmConveniosSedes()throws Exception{
		return (FormaConvenioSedes)super.getFrmForma();
	}
	
	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Sede getSedeSeleccionada() {
		return sedeSeleccionada;
	}

	public void setSedeSeleccionada(Sede sedeSeleccionada) {
		this.sedeSeleccionada = sedeSeleccionada;
	}
	
}
