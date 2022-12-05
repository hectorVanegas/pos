package co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.ConfigOfrecerClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.dto.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.TipoClaveSeguridadDTO;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDimensionesComponentes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.eventos.serviciosAdicionales.claveSeguridad.tiposClaveSeguridad.EventoFormaPanelTipoClaveSeguridadManual;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.CajaClaveUtil;
import co.com.codesa.clienteposslimgiros.formas.componentesGUI.EtiquetaUtil;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCajaTextoProtegida;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelGenerico;
import co.com.codesa.clienteposslimgiros.formas.serviciosAdicionales.claveSeguridad.FormaOfrecerClaveSeguridad;
import co.com.codesa.clienteposslimgiros.interfaces.serviciosAdicionales.claveSeguridad.IFormasTiposClaveSeguridad;
import co.com.codesa.clienteposslimgiros.utilidades.componentesGUI.UtilComponentesGUI;

/** 
 * ********************************************************************
 * @class  FormaPanelTipoClaveSeguridadManual
 *		   Clase forma, que representa una seccion particular que 
 *		   contiene los componentes graficos necesarios para realizar
 *		   un proceso de servicio de clave de seguridad manual		   
 * @author roberth.martinez
 * @date   22/3/2016
 * @copyright Copyright 1998-2015 Codesa, Todos los derechos reservados
 * *********************************************************************
 */
public class FormaPanelTipoClaveSeguridadManual extends FormaPanelGenerico implements IFormasTiposClaveSeguridad {

	/**
	 * @variable serialVersionUID
	 * 			 Variable serialVersionUID
	 */
	private static final long serialVersionUID = 8045507890900879934L;
	
	/**
	 * @variable evtFrmPnlClaveSeguridadManual
	 * 			 Referencia a la clase que controla los eventos de esta forma
	 */
	private EventoFormaPanelTipoClaveSeguridadManual evtFrmPnlClaveSeguridadManual;
	
	/**
	 * @variable pfiIngresarClave
	 * 			 Forma panel de caja de texto protegida para ingresar clave
	 */
	private FormaPanelCajaTextoProtegida pfiIngresarClave;
	
	/**
	 * @variable pfiConfirmarClave
	 * 			 Forma panel de caja de texto protegida para confirmar clave
	 */
	private FormaPanelCajaTextoProtegida pfiConfirmarClave;
	
	/**
	 * @variable 	lblClaveAleatoriaGeneradaAutomaticamente
	 * 			 	Etiqueta que se coloca como nota aclaratoria del tipo de
	 * 				clave de seguridad manual, donde socializa que este tipo
	 * 				de clave se generara de manera aleatoria y automaticamente
	 */
	//private EtiquetaUtil lblClaveAleatoriaGeneradaAutomaticamente;
	
	/**
	 * @variable lblIngrese
	 * 			 Etiqueta que solicita la operacion requerida para continuar
	 * 			 con el proceso
	 */
	private EtiquetaUtil lblIngrese;
	
	/**
	 * @variable lblClaveDebe
	 * 			 Etiqueta que estipula las caracteristicas con las que debe 
	 * 			 cumplir la clave ingresada
	 */
	private EtiquetaUtil lblClaveDebe;
	
	/**
	 * @variable lblIngresarClave
	 * 			 Etiqueta que identifica el campo para ingresar la clave
	 */
	private EtiquetaUtil lblIngresarClave;
	
	/**
	 * @variable lblConfirmarClave
	 * 			 Etiqueta que identifica el campo para confirmar la clave
	 */
	private EtiquetaUtil lblConfirmarClave;
	
	/** 
	 * ********************************************************************
	 * @method FormaPanelTipoClaveSeguridadManual
	 * 		   Constructor que ejecuta la inicializacion de valores y 
	 * 		   ejecucion de comportamientos inicales requeridos para
	 *         el despliegue de la forma  
	 * @param  pFrmGnrVentana
	 * 		   Forma principal desde donde se controla todo el proceso para
	 * 		   asginar el tipo de clave de seguridad
	 * @throws Exception
	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
	 * @author roberth.martinez
	 * @date   23/3/2016
	 * *********************************************************************
	 */
	public FormaPanelTipoClaveSeguridadManual(FormaOfrecerClaveSeguridad pFrmGnrVentana) throws Exception {
		
		super(pFrmGnrVentana,
			  EnumDimensionesComponentes.PNL_PNL_CSM_TIPO_CLAVE_MANUAL, 
			  "pnlClaveSeguridadManual", 
			  BorderFactory.createEmptyBorder(), 
			  null,
			  null);
		
		this.setEvtFrmPnlClaveSeguridadManual(new EventoFormaPanelTipoClaveSeguridadManual(this));
		
		super.iniciar();
	}

	@Override
	protected void inicializarSeccion()throws Exception{
		
		//this.add(this.iniciarPropLblClaveAleatoriaGeneradaAutomaticamente());
		
		this.add(this.iniciarPropLblIngrese());
		this.add(this.iniciarPropLblClaveDebe());
		this.add(this.iniciarPropLblIngresarClave());
		this.add(this.iniciarPropPfiIngresarClave());
		this.add(this.iniciarPropLblConfirmarClave());
		this.add(this.iniciarPropPfiConfirmarClave());
	}

	@Override
	public void configurar(FormaOfrecerClaveSeguridad pFrmGnrOfrecerClaveSeguridad,
						   ConfigOfrecerClaveSeguridadDTO pConfigOfrecerClaveSeguridadDTO,
			   			   TipoClaveSeguridadDTO pTipoClaveSeguridadDTO)throws Exception{
		
		this.getEvtFrmPnlClaveSeguridadManual().configurar(pFrmGnrOfrecerClaveSeguridad,
														   pConfigOfrecerClaveSeguridadDTO,
												   		   pTipoClaveSeguridadDTO);
	}
	
	@Override
	public void ejecutar() throws Exception {

		this.getEvtFrmPnlClaveSeguridadManual().ejecutar();
	}
	
	@Override
	public void limpiar() throws Exception {
		
		this.getEvtFrmPnlClaveSeguridadManual().limpiar();
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblClaveAleatoriaGeneradaAutomaticamente 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblClaveAleatoriaGeneradaAutomaticamente
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
//	public EtiquetaUtil iniciarPropLblClaveAleatoriaGeneradaAutomaticamente() throws Exception{
//		
//		if (this.lblClaveAleatoriaGeneradaAutomaticamente == null) {
//			
//			this.lblClaveAleatoriaGeneradaAutomaticamente = UtilComponentesGUI.getInstance().crearLabel	(	EnumDimensionesComponentes.LBL_PNL_CSM_NOTA, 
//																		  									"lblClaveAleatoriaGeneradaAutomaticamente", 
//																		  									EnumEtiquetas.LBL_PNL_CSM_NOTA,
//																		  									false,
//																		  									null,
//																		  									true
//																		  								);
//			this.lblClaveAleatoriaGeneradaAutomaticamente.setHorizontalAlignment(SwingConstants.CENTER);
//			this.lblClaveAleatoriaGeneradaAutomaticamente.setFont(this.lblClaveAleatoriaGeneradaAutomaticamente.getFont().deriveFont(Font.ITALIC));
//		}
//
//		return this.lblClaveAleatoriaGeneradaAutomaticamente;
//	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblIngrese 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngrese
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngrese() throws Exception{
		
		if (this.lblIngrese == null) {
			
			this.lblIngrese = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSM_INGRESE, 
																		  "lblIngrese", 
																		  EnumEtiquetas.LBL_PNL_CSM_INGRESE,
																		  false,
																		  null,
																		  true);
			this.lblIngrese.setHorizontalAlignment(SwingConstants.CENTER);
		}

		return this.lblIngrese;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblClaveDebe 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblClaveDebe
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblClaveDebe() throws Exception{
		
		if (this.lblClaveDebe == null) {
			
			this.lblClaveDebe = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSM_CLAVE_DEBE, 
					   														"lblClaveDebe", 
					   														EnumEtiquetas.LBL_PNL_CSM_CLAVE_DEBE,
					   														false,
					   														null,
					   														true);
			this.lblClaveDebe.setHorizontalAlignment(SwingConstants.CENTER);
		}

		return this.lblClaveDebe;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblIngresarClave 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblIngresarClave
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblIngresarClave() throws Exception{
		
		if (this.lblIngresarClave == null) {
			
			this.lblIngresarClave = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSM_INGRESAR_CLAVE, 
					   															"lblIngresarClave", 
					   															EnumEtiquetas.LBL_PNL_CSM_INGRESAR_CLAVE,
					   															true,
					   															null,
					   															true);
		}

		return this.lblIngresarClave;
	}
	
	/**
	 * ****************************************************************.
	 * @method iniciarPropLblConfirmarClave 
	 * 		   Metodo estandar para autogestionar el valor del atributo 
	 * 		   lblConfirmarClave
	 * @return EtiquetaUtil 
	 * 		   Etiqueta gestionada
	 * @throws Exception
	 *         Controla, recupera y escala, cualquier tipo de excepcion
	 *         presentada
	 * @author roberth.martinez
	 * @date   4/3/2016
	 * ****************************************************************
	 */
	public EtiquetaUtil iniciarPropLblConfirmarClave() throws Exception{
		
		if (this.lblConfirmarClave == null) {
			
			this.lblConfirmarClave = UtilComponentesGUI.getInstance().crearLabel(EnumDimensionesComponentes.LBL_PNL_CSM_CONFIRMAR_CLAVE, 
					    														 "lblConfirmarClave", 
					    														 EnumEtiquetas.LBL_PNL_CSM_CONFIRMAR_CLAVE,
					    														 true,
					    														 null,
					    														 true);
		}

		return this.lblConfirmarClave;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropPfiIngresarClave
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiIngresarClave
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   Caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @author roberth.martinez
  	 * @date   8/3/2016
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiIngresarClave()throws Exception {
		
		if(this.pfiIngresarClave==null){
			
			this.pfiIngresarClave = new FormaPanelCajaTextoProtegida(super.getFrmGnrPadre(),
						 											 EnumDimensionesComponentes.PFI_PNL_CSM_INGRESAR_CLAVE,
						 											 "pfiIngresarClave",
						 											 EnumEtiquetas.LBL_PNL_CSM_INGRESAR_CLAVE);
		}
		
		return this.pfiIngresarClave;
	}
	
	/**
  	 * ****************************************************************.
  	 * @method iniciarPropPfiConfirmarClave
  	 * 		   Metodo estandar para autogestionar el valor del atributo 
  	 * 		   pfiConfirmarClave
  	 * @return FormaPanelCajaTextoProtegida
  	 * 		   Caja protegida de texto gestionada 
  	 * @throws Exception
  	 * 		   Controla, recupera y escala, cualquier tipo de excepcion 
  	 * 		   presentada
  	 * @autor  roberth.martinez
	 * @date   8/3/2016
  	 * ****************************************************************
  	 */
	public FormaPanelCajaTextoProtegida iniciarPropPfiConfirmarClave()throws Exception {
		
		if(this.pfiConfirmarClave==null){
			
			this.pfiConfirmarClave = new FormaPanelCajaTextoProtegida(super.getFrmGnrPadre(),
																	  EnumDimensionesComponentes.PFI_PNL_CSM_CONFIRMAR_CLAVE,
																	  "pfiConfirmarClave",
																	  EnumEtiquetas.LBL_PNL_CSM_CONFIRMAR_CLAVE);
			
		}
		
		return this.pfiConfirmarClave;
	}

	/**
	 * @method getLblIngrese
	 * 		   Metodo get del atributo lblIngrese
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblIngrese devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public EtiquetaUtil getLblIngrese() {
		return this.lblIngrese;
	}

	/**
	 * @method setLblIngrese
	 * 		   Metodo set del atributo lblIngrese
	 * @param  pLblIngrese
	 *		   Valor que tomara el atributo lblIngrese
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setLblIngrese(EtiquetaUtil pLblIngrese) {
		this.lblIngrese = pLblIngrese;
	}

	/**
	 * @method getLblClaveDebe
	 * 		   Metodo get del atributo lblClaveDebe
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblClaveDebe devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public EtiquetaUtil getLblClaveDebe() {
		return this.lblClaveDebe;
	}

	/**
	 * @method setLblClaveDebe
	 * 		   Metodo set del atributo lblClaveDebe
	 * @param  pLblClaveDebe
	 *		   Valor que tomara el atributo lblClaveDebe
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setLblClaveDebe(EtiquetaUtil pLblClaveDebe) {
		this.lblClaveDebe = pLblClaveDebe;
	}

	/**
	 * @method getLblIngresarClave
	 * 		   Metodo get del atributo lblIngresarClave
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblIngresarClave devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public EtiquetaUtil getLblIngresarClave() {
		return this.lblIngresarClave;
	}

	/**
	 * @method setLblIngresarClave
	 * 		   Metodo set del atributo lblIngresarClave
	 * @param  pLblIngresarClave
	 *		   Valor que tomara el atributo lblIngresarClave
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setLblIngresarClave(EtiquetaUtil pLblIngresarClave) {
		this.lblIngresarClave = pLblIngresarClave;
	}

	/**
	 * @method getLblConfirmarClave
	 * 		   Metodo get del atributo lblConfirmarClave
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblConfirmarClave devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public EtiquetaUtil getLblConfirmarClave() {
		return this.lblConfirmarClave;
	}

	/**
	 * @method setLblConfirmarClave
	 * 		   Metodo set del atributo lblConfirmarClave
	 * @param  pLblConfirmarClave
	 *		   Valor que tomara el atributo lblConfirmarClave
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setLblConfirmarClave(EtiquetaUtil pLblConfirmarClave) {
		this.lblConfirmarClave = pLblConfirmarClave;
	}

	/**
	 * @method getPfiIngresarClave
	 * 		   Metodo get del atributo pfiIngresarClave
	 * @return CajaClaveUtil
	 *		   Valor del atributo pfiIngresarClave devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public CajaClaveUtil getPfiIngresarClave() {
		return this.pfiIngresarClave.getPfiCajaClave();
	}
	
	/**
	 * @method getPnlTxtPrtIngresarClave
	 * 		   Metodo get del atributo pfiIngresarClave
	 * @return FormaPanelCajaTextoProtegida
	 *		   Valor del atributo pfiIngresarClave devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public FormaPanelCajaTextoProtegida getPnlTxtPrtIngresarClave() {
		return this.pfiIngresarClave;
	}

	/**
	 * @method setPfiIngresarClave
	 * 		   Metodo set del atributo pfiIngresarClave
	 * @param  pPfiIngresarClave
	 *		   Valor que tomara el atributo pfiIngresarClave
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setPfiIngresarClave(FormaPanelCajaTextoProtegida pPfiIngresarClave) {
		this.pfiIngresarClave = pPfiIngresarClave;
	}

	/**
	 * @method getPfiConfirmarClave
	 * 		   Metodo get del atributo pfiConfirmarClave
	 * @return CajaClaveUtil
	 *		   Valor del atributo pfiConfirmarClave devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public CajaClaveUtil getPfiConfirmarClave() {
		return this.pfiConfirmarClave.getPfiCajaClave();
	}

	/**
	 * @method getPnlTxtPrtConfirmarClave
	 * 		   Metodo get del atributo pfiConfirmarClave
	 * @return FormaPanelCajaTextoProtegida
	 *		   Valor del atributo pfiConfirmarClave devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public FormaPanelCajaTextoProtegida getPnlTxtPrtConfirmarClave() {
		return this.pfiConfirmarClave;
	}
	
	/**
	 * @method setPfiConfirmarClave
	 * 		   Metodo set del atributo pfiConfirmarClave
	 * @param  pPfiConfirmarClave
	 *		   Valor que tomara el atributo pfiConfirmarClave
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setPfiConfirmarClave(FormaPanelCajaTextoProtegida pPfiConfirmarClave) {
		this.pfiConfirmarClave = pPfiConfirmarClave;
	}

	/**
	 * @method getLblClaveAleatoriaGeneradaAutomaticamente
	 * 		   Metodo get del atributo lblClaveAleatoriaGeneradaAutomaticamente
	 * @return EtiquetaUtil
	 *		   Valor del atributo lblClaveAleatoriaGeneradaAutomaticamente devuelto
	 * @author hector.cuenca
	 * @date   7/03/2017
	 */
//	public EtiquetaUtil getLblClaveAleatoriaGeneradaAutomaticamente() {
//		return lblClaveAleatoriaGeneradaAutomaticamente;
//	}

	/**
	 * @method setLblClaveAleatoriaGeneradaAutomaticamente
	 * 		   Metodo set del atributo lblClaveAleatoriaGeneradaAutomaticamente
	 * @param  pLblClaveAleatoriaGeneradaAutomaticamente
	 *		   Valor que tomara el atributo lblClaveAleatoriaGeneradaAutomaticamente
	 * @author hector.cuenca
	 * @date   7/03/2017
	 */
//	public void setLblClaveAleatoriaGeneradaAutomaticamente(
//			EtiquetaUtil pLblClaveAleatoriaGeneradaAutomaticamente) {
//		this.lblClaveAleatoriaGeneradaAutomaticamente = pLblClaveAleatoriaGeneradaAutomaticamente;
//	}

	/**
	 * @method getEvtFrmPnlClaveSeguridadManual
	 * 		   Metodo get del atributo evtFrmPnlClaveSeguridadManual
	 * @return EventoFormaPanelTipoClaveSeguridadManual
	 *		   Valor del atributo evtFrmPnlClaveSeguridadManual devuelto
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public EventoFormaPanelTipoClaveSeguridadManual getEvtFrmPnlClaveSeguridadManual() {
		return this.evtFrmPnlClaveSeguridadManual;
	}

	/**
	 * @method setEvtFrmPnlClaveSeguridadManual
	 * 		   Metodo set del atributo evtFrmPnlClaveSeguridadManual
	 * @param  pEvtFrmPnlTokenValidaManual
	 *		   Valor que tomara el atributo evtFrmPnlClaveSeguridadManual
	 * @author roberth.martinez
	 * @date   23/3/2016
	 */
	public void setEvtFrmPnlClaveSeguridadManual(
			EventoFormaPanelTipoClaveSeguridadManual pEvtFrmPnlTokenValidaManual) {
		
		this.evtFrmPnlClaveSeguridadManual = pEvtFrmPnlTokenValidaManual;
		super.setEvaControlEventos(this.evtFrmPnlClaveSeguridadManual);
	}
}
