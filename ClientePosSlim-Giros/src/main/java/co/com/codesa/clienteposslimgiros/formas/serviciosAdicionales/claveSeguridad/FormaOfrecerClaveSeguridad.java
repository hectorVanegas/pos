package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad;

import javax.swing.JPanel;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.EventoFormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaComboUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/**
 * ********************************************************************
 * @class  FormaOfrecerClaveSeguridad
 *		   Clase que genera la forma (GUI) para el proceso de ofrecer el 
 *		   servicio de token de validacion, este formulario sera la forma
 *		   principal que administrara e integrara los diferentes tipos de 
 *		   token de validacion detectados como disponibles y ofrecera el
 *		   contenedor necesario para incluir los formularios particulares
 *		   demandados por cada tipo de token
 * @author roberth.martinez
 * @date   3/03/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaOfrecerClaveSeguridad extends FormaGenerica{

	
	/**
	 * @variable serialVersionUID
	 * 			 Serial de identificacion de clase
	 */
	private static final long serialVersionUID = 72995424968910486L;
	
	/**
	 * @variable lblDeseaIncluir
	 * 			 Etiqueta que anuncia y ofrece el servicio de token de validacion
	 */
	private EtiquetaUtil lblDeseaIncluir;
	
	/**
	 * @variable lblTipoClaveSeguridad
	 * 			 Etiqueta que identifica el tipo de clave de seguridad seleccionado
	 */
	private EtiquetaUtil lblTipoClaveSeguridad;
	
	/**
	 * @variable cmbTipoClaveSeguridad
	 * 			 Listado de tipos de clave de seguridad detectados como disponibles
	 **/
	private CajaComboUtil cmbTipoClaveSeguridad;

	/**
	 * ********************************************************************
	 * @method FormaOfrecerClaveSeguridad
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la forma 
	 * @param  pFrmPadre
	 * 		   Ventana de la cual extiende esta forma
	 * @param  pBooModal
	 * 		   Bandera que permite efectuar la forma de manera modal sobre 
	 *         la ventana de la cual extiende
	 * @param  pObjCfgOfrecerClaveSeguridad
	 * 		   Objeto DTO que contiene toda la configuracion relacionada con 
	 * 		   el proceso de ofrecer el servicio de clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author hector.cuenca
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public FormaOfrecerClaveSeguridad(FormaGenerica pFrmPadre, 
								 	   boolean pBooModal,
								 	   ConfigOfrecerClaveSeguridadDTO pObjCfgOfrecerClaveSeguridad) throws Exception {
		super(pFrmPadre, 
			  pBooModal);
		
		super.setEventoForma(new EventoFormaOfrecerClaveSeguridad(this,
				  												  pObjCfgOfrecerClaveSeguridad));
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_OCS_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_OCS_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_OCS_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_OCS_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropLblDeseaIncluir());
		pnlEncabezado.add(this.iniciarPropLblTipoClaveSeguridad());
		pnlEncabezado.add(this.iniciarPropCmbTipoClaveSeguridad());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlCuerpo;
		
		pnlCuerpo = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_OCS_CUERPO,
																"pnlCuerpo",
		  													 	null,
		  													 	null,
		  													 	null);
		
		return pnlCuerpo;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropLblDeseaIncluir
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblDeseaIncluir
	 * @return EtiquetaUtil
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblDeseaIncluir() throws Exception{
		
		if (this.lblDeseaIncluir == null) {
			
			this.lblDeseaIncluir = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OCS_DESEA_INCLUIR, 
																	   	   	   "lblDeseaIncluir", 
																	   	   	   EnumEtiquetas.LBL_OCS_DESEA_INCLUIR,
																	   	   	   false,
																	   	   	   null,
																	   	   	   true);
		}

		return this.lblDeseaIncluir;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropLblTipoClaveSeguridad
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblTipoClaveSeguridad
	 * @return EtiquetaUtil
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblTipoClaveSeguridad() throws Exception{
		
		if (this.lblTipoClaveSeguridad == null) {
			
			this.lblTipoClaveSeguridad = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_OCS_TIPO_CLAVE, 
																	   	   			 "lblTipoClaveSeguridad", 
																	   	   			 EnumEtiquetas.LBL_OCS_TIPO_CLAVE,
																	   	   			 true,
																	   	   			 null,
																	   	   			 true);
		}

		return this.lblTipoClaveSeguridad;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropCmbTipoClaveSeguridad
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   cmbTipoClaveSeguridad
	 * @return CajaComboUtil
	 * 		   Lista de valores gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   3/03/2016
	 * *********************************************************************
	 */
	public CajaComboUtil iniciarPropCmbTipoClaveSeguridad() throws Exception{
		
		if (this.cmbTipoClaveSeguridad == null) {
			
			this.cmbTipoClaveSeguridad = UtilComponentesGUI.getInstance().crearComboBox(EnumDimensionesComponentes.CMB_OCS_TIPO_CLAVE, 
																		  	   			"cmbTipoClaveSeguridad", 
																		  	   			true, 
																		  	   			true, 
																		  	   			super.getEventoForma(),
																		  	   			EnumEtiquetas.LBL_OCS_TIPO_CLAVE);
		}
		
		return cmbTipoClaveSeguridad;
	}

	/**
	 * @method getLblDeseaIncluir
	 * 		   Metodo get del atributo lblDeseaIncluir
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblDeseaIncluir devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public EtiquetaUtil getLblDeseaIncluir() {
		return this.lblDeseaIncluir;
	}

	/**
	 * @method setLblDeseaIncluir
	 * 		   Metodo set del atributo lblDeseaIncluir
	 * @param  pLblDeseaIncluir
	 *		   Valor que tomara el atributo lblDeseaIncluir
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setLblDeseaIncluir(EtiquetaUtil pLblDeseaIncluir) {
		this.lblDeseaIncluir = pLblDeseaIncluir;
	}

	/**
	 * @method getLblTipoClaveSeguridad
	 * 		   Metodo get del atributo lblTipoClaveSeguridad
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblTipoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public EtiquetaUtil getLblTipoClaveSeguridad() {
		return this.lblTipoClaveSeguridad;
	}

	/**
	 * @method setLblTipoClaveSeguridad
	 * 		   Metodo set del atributo lblTipoClaveSeguridad
	 * @param  pLblTipoClaveSeguridad
	 *		   Valor que tomara el atributo lblTipoClaveSeguridad
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setLblTipoClaveSeguridad(EtiquetaUtil pLblTipoClaveSeguridad) {
		this.lblTipoClaveSeguridad = pLblTipoClaveSeguridad;
	}

	/**
	 * @method getCmbTipoClaveSeguridad
	 * 		   Metodo get del atributo cmbTipoClaveSeguridad
	 * @return CajaComboUtil
	 *		   Valor del atributo cmbTipoClaveSeguridad devuelto
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public CajaComboUtil getCmbTipoClaveSeguridad() {
		return this.cmbTipoClaveSeguridad;
	}

	/**
	 * @method setCmbTipoClaveSeguridad
	 * 		   Metodo set del atributo cmbTipoClaveSeguridad
	 * @param  pCmbTipoClaveSeguridad
	 *		   Valor que tomara el atributo cmbTipoClaveSeguridad
	 * @author hector.cuenca
	 * @date   3/03/2016
	 */
	public void setCmbTipoClaveSeguridad(CajaComboUtil pCmbTipoClaveSeguridad) {
		this.cmbTipoClaveSeguridad = pCmbTipoClaveSeguridad;
	}
}
