package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad;

import javax.swing.JPanel;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.EventoFormaVerificarClaveSeguridad;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaClaveUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCajaTextoProtegida;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

/** 
 * ********************************************************************
 * @class  FormaVerificarClaveSeguridad
 *		   [TODO - DOC]: Descripcion de la clase, su intencion, 
 *		   proposito y objetivo
 * @author roberth.martinez
 * @date   7/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaVerificarClaveSeguridad extends FormaGenerica{
	
	/**
	 * @variable serialVersionUID
	 * 			 variable serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @variable lblIngresarClave
	 * 			 Etiqueta para infromar el ingreso de la clave de seguridad
	 */
	private EtiquetaUtil lblIngresarClave;
	
	/**
	 * @variable lblTipoToken
	 * 			 Etiqueta que identifica el tipo de token seleccionado
	 */
	private EtiquetaUtil lblClaveSeguridad;
	
	/**
	 * @variable pfiIngresarClave
	 * 			 Objeto de FormaPanelCajaTextoProtegida para texto portegido
	 */
	private FormaPanelCajaTextoProtegida pfiIngresarClave;
	/** 
	 * ********************************************************************
	 * @method FormaVerificarClaveSeguridad
	 * 		   Forma para crear la interfaz, para la solicitud de la clave
	 * 		   de validacion que tiene la refrencia control
	 * @param  pFrmPadre
	 * 		   Ventana de la cual extiende esta forma
	 * @param  pBooModal
	 * 		   Bandera que permite efectuar la forma de manera modal sobre 
	 *         la ventana de la cual extiende
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *		   presentada
	 * @author roberth.martinez
	 * @date   7/3/2016
	 * *********************************************************************
	 */
	public FormaVerificarClaveSeguridad(FormaGenerica pFrmPadre, 
										   boolean pBooModal,
										   FacturaGiro pObjFacturaGiro) throws Exception{
		
		super(pFrmPadre, 
			  pBooModal);
			
		super.setEventoForma(new EventoFormaVerificarClaveSeguridad(this, 
																	   pObjFacturaGiro));
		
		this.inicializarForma();
		
	}

	@Override
	public void inicializarForma(Object... pArrObjParametrosForma) throws Exception {
		
		super.setTituloForma(EnumEtiquetas.TTL_VCS_VENTANA);
		super.setAnchoForma(EnumDimensionesComponentes.FRM_VCT_VENTANA.getAncho());
		super.setAltoForma(EnumDimensionesComponentes.FRM_VCT_VENTANA.getAlto());
        
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,
								EnumBotonesEncabezado.BTNVOLVER);
		
		super.iniciar(pArrObjParametrosForma);
	}

	@Override
	public JPanel inicializarEncabezado(Object... pArrObjParametrosForma) throws Exception {
		
		JPanel pnlEncabezado;
		
		pnlEncabezado = UtilComponentesGUI.getInstance().crearPanel(EnumDimensionesComponentes.PNL_VCT_PANEL_ENCABEZADO,
																	"pnlEncabezado",
		  														 	null,
		  														 	null,
		  														 	null);
		pnlEncabezado.add(this.iniciarPropLblIngresarClave());
		pnlEncabezado.add(this.iniciarPropLblClaveSeguridad());
		pnlEncabezado.add(this.iniciarPropPfiIngresarClave());
		
		return pnlEncabezado;
	}

	@Override
	public JPanel inicializarCuerpo(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}

	@Override
	public JPanel inicializarPiePagina(Object... pArrObjParametrosForma) throws Exception {
		return null;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropLblIngresarClave
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngresarClave
	 * @return EtiquetaUtil
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngresarClave() throws Exception{
		
		if (this.lblIngresarClave == null) {
			
			this.lblIngresarClave = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_VCT_INGRESA_CLAVE, 
																	   	   	    "lblIngresarClave", 
																	   	   	    EnumEtiquetas.LBL_VCS_INGRESA_CLAVE,
																	   	   	    false,
																	   	   	    null,
																	   	   	    true);
		}

		return this.lblIngresarClave;
	}
	
	/**
	 * ********************************************************************
	 * @method iniciarPropLblClaveSeguridad
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblClaveSeguridad
	 * @return EtiquetaUtil
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   7/03/2016
	 * *********************************************************************
	 */
	public EtiquetaUtil iniciarPropLblClaveSeguridad() throws Exception{
		
		if (this.lblClaveSeguridad == null) {
			
			this.lblClaveSeguridad = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_VCT_CLAVE_SEGURIDAD, 
																	   	   	     "lblClaveSeguridad", 
																	   	   	     EnumEtiquetas.LBL_VCS_CLAVE_SEGURIDAD,
																	   	   	     true,
																	   	   	     null,
																	   	   	     true);
		}

		return this.lblClaveSeguridad;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropPfiIngresarClave
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiIngresarClave
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @author roberth.martinez
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiIngresarClave()throws Exception {
		
		if(this.pfiIngresarClave==null){
			
			this.pfiIngresarClave = new FormaPanelCajaTextoProtegida(this,
						 											 EnumDimensionesComponentes.PFI_VCT_CLAVE_SEGURIDAD,
						 											 "pfiIngresarClave",
						 											 EnumEtiquetas.LBL_VCS_CLAVE_SEGURIDAD);
		}
		
		return this.pfiIngresarClave;
	}

	/**
	 * @method getLblIngresarClave
	 * 		   Metodo get del atributo lblIngresarClave
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblIngresarClave devuelto
	 * @author roberth.martinez
	 * @date   7/3/2016
	 */
	public EtiquetaUtil getLblIngresarClave() {
		return lblIngresarClave;
	}

	/**
	 * @method setLblIngresarClave
	 * 		   Metodo set del atributo lblIngresarClave
	 * @param  pLblIngresarClave
	 *		   Valor que tomara el atributo lblIngresarClave
	 * @author roberth.martinez
	 * @date   7/3/2016
	 */
	public void setLblIngresarClave(EtiquetaUtil pLblIngresarClave) {
		this.lblIngresarClave = pLblIngresarClave;
	}

	/**
	 * @method getLblClaveSeguridad
	 * 		   Metodo get del atributo lblClaveSeguridad
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblClaveSeguridad devuelto
	 * @author roberth.martinez
	 * @date   7/3/2016
	 */
	public EtiquetaUtil getLblClaveSeguridad() {
		return lblClaveSeguridad;
	}

	/**
	 * @method setLblClaveSeguridad
	 * 		   Metodo set del atributo lblClaveSeguridad
	 * @param  pLblClaveSeguridad
	 *		   Valor que tomara el atributo lblClaveSeguridad
	 * @author roberth.martinez
	 * @date   7/3/2016
	 */
	public void setLblClaveSeguridad(EtiquetaUtil pLblClaveSeguridad) {
		this.lblClaveSeguridad = pLblClaveSeguridad;
	}

	/**
	 * @method getPfiIngresarClave
	 * 		   Metodo get del atributo pfiIngresarClave
	 * @return CajaClaveUtil
	 *		   Valor del atributo pfiIngresarClave devuelto
	 * @author roberth.martinez
	 * @date   8/3/2016
	 */
	public CajaClaveUtil getPfiIngresarClave() {
		return pfiIngresarClave.getPfiCajaClave();
	}

	/**
	 * @method setPfiIngresarClave
	 * 		   Metodo set del atributo pfiIngresarClave
	 * @param  pPfiIngresarClave
	 *		   Valor que tomara el atributo pfiIngresarClave
	 * @author roberth.martinez
	 * @date   8/3/2016
	 */
	public void setPfiIngresarClave(FormaPanelCajaTextoProtegida pPfiIngresarClave) {
		this.pfiIngresarClave = pPfiIngresarClave;
	}
}
