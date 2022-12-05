package co.com.codesa.clienteposslimgiros.formas.superCombo;

import java.awt.Font;

import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImagenes;
import co.com.codesa.clienteposslimgiros.eventos.superCombo.EventoFormaSuperComboDestino;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaTextoUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas;
import co.com.codesa.clienteposslimgiros.pruebas.TestPruebasInternas.EnumDesplegarFormaConEventos;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Factura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Tercero;

/**
 * ****************************************************************.
 * @autor: CarlosMora[Codesa]
 * @fecha: 05-junio-2019
 * @descripcion: Clase para consultar realizar la oferta de 
 * 				 SuperCombo en el Envio de giro postal
 * @copyright: Copyright  1998-2012 Codesa, Todos los derechos reservados.
 * ****************************************************************
 */
public class FormaSuperComboDestino extends FormaGenerica{
	


	private static final long serialVersionUID = 1L;
	
	private EtiquetaUtil lblDatosSMS;
	private EtiquetaUtil lblTelefonoRemitente;
	private EtiquetaUtil lblTelefonoDestino;
	private EtiquetaUtil lblDeseaIncluir;
	private EtiquetaUtil lblImgSuperCombo;
	private EtiquetaUtil lblBeneficios;
	private EtiquetaUtil lblNotificacion;
	private EtiquetaUtil lblValorSuperCombo;
	private EtiquetaUtil lblVlrSuperCombo;
	private CajaTextoUtil txtTelefonoRemitente;
	private CajaTextoUtil txtTelefonoDestino;

	public FormaSuperComboDestino(FormaGenerica pFrmPadre, 
								 boolean pBooModal,
								 String pStrValSuperCombo,
								 Factura pFactura) throws Exception {
		
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaSuperComboDestino(this,
															 pStrValSuperCombo,
															 pFactura));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		super.setTituloForma(EnumEtiquetas.TTL_SCO_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_SCD_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_SCD_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTN_ANULAR);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SCO_PANEL_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropLblDeseaIncluir());
		//pnlEncabezado.add(this.iniciarPropLblDatosSMS());
		//pnlEncabezado.add(this.iniciarPropLblTelefonoRemitente());
		//pnlEncabezado.add(this.iniciarPropLblTelefonoDestino());
		this.iniciarPropTxtTelefonoRemitente();
		this.iniciarPropTxtTelefonoDestino();
		//pnlEncabezado.add(this.iniciarPropTxtTelefonoRemitente());
		//pnlEncabezado.add(this.iniciarPropTxtTelefonoDestino());
		
		pnlEncabezado.add(this.iniciarPropLblValorSuperCombo());
		pnlEncabezado.add(this.iniciarPropLblVlrSuperCombo());
		
		return pnlEncabezado;
	}

	//@Override
	/*public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_SCO_PANEL_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	null,
		  													 	null);
		//pnlCuerpo.add(this.iniciarPropLblDeseaIncluir());
		//pnlCuerpo.add(this.iniciarPropLblImgSuperCombo());
		//pnlCuerpo.add(this.iniciarPropLblBeneficios());
		//pnlCuerpo.add(this.iniciarPropLblNotificacion());
		//pnlCuerpo.add(this.iniciarPropLblValorSuperCombo());
		//pnlCuerpo.add(this.iniciarPropLblVlrSuperCombo());
		
		
		return pnlCuerpo;
	}
*/
	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblDatosSMS
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de datos de mensaje de texto
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblDatosSMS() throws Exception{
		
		this.lblDatosSMS = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCO_DATOS_SMS, 
				   												   	   "lblDatosSMS", 
				   												   	   EnumEtiquetas.LBL_SCO_DATOS_SMS,
				   												   	   false,
				   												   	   null,
				   												   	   true);
		
		this.lblDatosSMS.setFont(this.lblDatosSMS.getFont().deriveFont(Font.BOLD,13));
		
		return this.lblDatosSMS;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblTelefonoRemitente
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de telefono remitente
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblTelefonoRemitente() throws Exception{
		
		this.lblTelefonoRemitente = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCO_TELEFONO_REMITENTE, 
																				"lblTelefonoRemitente", 
																				EnumEtiquetas.LBL_SCO_TELEFONO_REMITENTE,
																				false,
																				null,
																				true);
		
		return this.lblTelefonoRemitente;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblTelefonoDestino
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de telefono destino
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblTelefonoDestino() throws Exception{
		
		this.lblTelefonoDestino = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCO_TELEFONO_DESTINO, 
																		  	  "lblTelefonoDestino", 
																		  	  EnumEtiquetas.LBL_SCO_TELEFONO_DESTINO,
																		  	  false,
																		  	  null,
																		  	  true);
		
		return this.lblTelefonoDestino;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropTxtTelefonoRemitente
     * 		   metodo utilizado para inicializar el componente text 
     * 		   para el telefono remitente
     * @return CajaTextoUtil componente CajaTextoUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtTelefonoRemitente()throws Exception{
		
		this.txtTelefonoRemitente = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SCO_TELEFONO_REMITENTE, 
																					"txtTelefonoRemitente", 
																					"",
																					true, 
																					true, 
																					true, 
																					super.getEventoForma(),
																					null);
		return this.txtTelefonoRemitente;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropTxtTelefonoDestino
     * 		   metodo utilizado para inicializar el componente text 
     * 		   para el telefono destino
     * @return CajaTextoUtil componente CajaTextoUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */
	public CajaTextoUtil iniciarPropTxtTelefonoDestino()throws Exception{
		
		this.txtTelefonoDestino = UtilComponentesGUI.getInstance().crearTextField(EnumDimensionesComponentes.TXT_SCO_TELEFONO_DESTINO, 
				  															  	  "txtTelefonoDestino", 
				  															  	  "",
				  															  	  true, 
				  															  	  true, 
				  															  	  true, 
				  															  	  super.getEventoForma(),
				  															  	  null);
		return this.txtTelefonoDestino;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblDeseaIncluir
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de desea incluir
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblDeseaIncluir() throws Exception{
		
		this.lblDeseaIncluir = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCD_DESEA_INCLUIR, 
																	   	   "lblDeseaIncluir", 
																	   	   EnumEtiquetas.LBL_SCO_DESEA_INCLUIR,
																	   	   false,
																	   	   null,
																	   	   true);
		
		this.lblDeseaIncluir.setFont(this.lblDeseaIncluir.getFont().deriveFont(Font.BOLD,13));
		
		return this.lblDeseaIncluir;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblImgSuperCombo
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   imagen TMU
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblImgSuperCombo() throws Exception{
		
		if (this.lblImgSuperCombo == null) {
			this.lblImgSuperCombo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCO_IMG_SUPERCOMBO_LOGO, 
																	 			"lblImgSuperCombo", 
																	 			null,
																	 			false,
																	 			EnumImagenes.APP_SPC_LOGO.obtenerIcono(),
																	 			true);
		}
		return this.lblImgSuperCombo;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblBeneficios
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de Beneficios
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblBeneficios() throws Exception{
		
		this.lblBeneficios = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCO_BENEFICIOS, 
																	 	 "lblBeneficios", 
																	 	 EnumEtiquetas.LBL_SCO_BENEFICIOS,
																	 	 false,
																	 	 null,
																	 	 true);
		
		this.lblBeneficios.setFont(this.lblBeneficios.getFont().deriveFont(Font.BOLD,13));
		
		return this.lblBeneficios;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblNotificacion
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de Notificacion
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblNotificacion() throws Exception{
		
		this.lblNotificacion = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCO_NOTIFICACION, 
																	   	   "lblNotificacion", 
																	   	   EnumEtiquetas.LBL_SCO_NOTIFICACION,
																	   	   false,
																	   	   null,
																	   	   true);
		
		this.lblNotificacion.setFont(this.lblNotificacion.getFont().deriveFont(Font.BOLD,12));
		
		return this.lblNotificacion;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblValorSuperCombo
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de Valor SuperCombo
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblValorSuperCombo() throws Exception{
		
		this.lblValorSuperCombo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCD_VALOR_SUPERCOMBO, 
																	   	  	  "lblValorSuperCombo", 
																	   	  	  EnumEtiquetas.LBL_SCO_VALOR_SUPERCOMBO,
																	   	  	  false,
																	   	  	  null,
																	   	  	  true);
		
		this.lblValorSuperCombo.setFont(this.lblValorSuperCombo.getFont().deriveFont(Font.BOLD,14));
		
		return this.lblValorSuperCombo;
	}
	
	/**
     * ****************************************************************
     * @throws Exception
     * @metodo iniciarPropLblVlrSuperCombo
     * 		   metodo utilizado para inicializar el componente EtiquetaUtil 
     * 		   de Valor SuperCombo
     * @return EtiquetaUtil componente EtiquetaUtil
     * @autor  CarlosMora[Codesa]
     * ****************************************************************
     */	
	public EtiquetaUtil iniciarPropLblVlrSuperCombo() throws Exception{
		
		this.lblVlrSuperCombo = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_SCD_VLR_SUPERCOMBO, 
																	   		"lblVlrSuperCombo", 
																	   		null,
																	   		false,
																	   		null,
																	   		true);
		
		this.lblVlrSuperCombo.setFont(this.lblVlrSuperCombo.getFont().deriveFont(Font.BOLD,14));
		
		return this.lblVlrSuperCombo;
	}

	public EtiquetaUtil getLblVlrSuperCombo() {
		return lblVlrSuperCombo;
	}

	public void setLblVlrSuperCombo(EtiquetaUtil lblVlrSuperCombo) {
		this.lblVlrSuperCombo = lblVlrSuperCombo;
	}

	public CajaTextoUtil getTxtTelefonoRemitente() {
		return txtTelefonoRemitente;
	}

	public void setTxtTelefonoRemitente(CajaTextoUtil txtTelefonoRemitente) {
		this.txtTelefonoRemitente = txtTelefonoRemitente;
	}

	public CajaTextoUtil getTxtTelefonoDestino() {
		return txtTelefonoDestino;
	}

	public void setTxtTelefonoDestino(CajaTextoUtil txtTelefonoDestino) {
		this.txtTelefonoDestino = txtTelefonoDestino;
	}
	
	public EtiquetaUtil getLblDatosSMS() {
		return lblDatosSMS;
	}

	public void setLblDatosSMS(EtiquetaUtil lblDatosSMS) {
		this.lblDatosSMS = lblDatosSMS;
	}

	public EtiquetaUtil getLblTelefonoRemitente() {
		return lblTelefonoRemitente;
	}

	public void setLblTelefonoRemitente(EtiquetaUtil lblTelefonoRemitente) {
		this.lblTelefonoRemitente = lblTelefonoRemitente;
	}

	public EtiquetaUtil getLblTelefonoDestino() {
		return lblTelefonoDestino;
	}

	public void setLblTelefonoDestino(EtiquetaUtil lblTelefonoDestino) {
		this.lblTelefonoDestino = lblTelefonoDestino;
	}

	public EtiquetaUtil getLblDeseaIncluir() {
		return lblDeseaIncluir;
	}

	public void setLblDeseaIncluir(EtiquetaUtil lblDeseaIncluir) {
		this.lblDeseaIncluir = lblDeseaIncluir;
	}

	public EtiquetaUtil getLblImgSuperCombo() {
		return lblImgSuperCombo;
	}

	public void setLblImgSuperCombo(EtiquetaUtil lblImgSuperCombo) {
		this.lblImgSuperCombo = lblImgSuperCombo;
	}

	public EtiquetaUtil getLblBeneficios() {
		return lblBeneficios;
	}

	public void setLblBeneficios(EtiquetaUtil lblBeneficios) {
		this.lblBeneficios = lblBeneficios;
	}

	public EtiquetaUtil getLblNotificacion() {
		return lblNotificacion;
	}

	public void setLblNotificacion(EtiquetaUtil lblNotificacion) {
		this.lblNotificacion = lblNotificacion;
	}

	public EtiquetaUtil getLblValorSuperCombo() {
		return lblValorSuperCombo;
	}

	public void setLblValorSuperCombo(EtiquetaUtil lblValorSuperCombo) {
		this.lblValorSuperCombo = lblValorSuperCombo;
	}

	public static void main(String[] args) {
		
		try {
			
			TestPruebasInternas.getInstance().iniciarPruebaInterna(FormaSuperComboOrigen.class,
																   true, 
																   EnumDesplegarFormaConEventos.SI);
			
			
			Tercero to = new Tercero();
			to.setTelefono2("3122222608");
			
			Tercero td = new Tercero();
			td.setTelefono2("3166913788");
			
			Factura factura = new Factura();
			
			factura.setTerceroDestino(td);
			factura.setTerceroOrigen(to);
			
			new FormaSuperComboOrigen(null, 
									  true,
									  "1.000",
									  factura);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}
