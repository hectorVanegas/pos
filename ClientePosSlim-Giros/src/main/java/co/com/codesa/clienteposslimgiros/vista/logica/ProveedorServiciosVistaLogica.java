/*
 * Cesar Rendon. 
 * Copyright  1998-2012 Codesa, Todos los derechos reservados.         
 */
package co.com.codesa.clienteposslimgiros.vista.logica;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import co.com.codesa.clienteposslim.general.IProveedorServiciosVistaLogica;
import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslim.vista.logica.OtrosServiciosVistaLogica;
import co.com.codesa.clienteposslim.vista.logica.UtilidadesVistaLogica;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumParametrosApp;
import co.com.codesa.clienteposslimgiros.enumeraciones.proveedorServicioProducto.EnumTiposServicios;
import co.com.codesa.clienteposslimgiros.utilidades.InformacionSessionGiros;
import co.com.codesa.clienteposslimgiros.utilidades.integracion.slimGiros.UtilIntegracionSlimGiros;
import co.com.codesa.clienteposslimgiros.utilidades.UtilidadesGiros;
import co.com.codesa.codesawrapper.modelo.dominio.Proveedor;
import co.com.codesa.codesawrapper.modelo.dominio.ProveedorServicioProducto;
import co.com.codesa.codesawrapper.modelo.dominio.TipoServicio;
import co.com.codesa.codesawrapper.modelo.interfaces.IRespuestaTrama;

public class ProveedorServiciosVistaLogica implements IProveedorServiciosVistaLogica{


	/**
	 * ****************************************************************.
	 * 
	 * @param pIdAcordion
	 * @param pnlContenido, para este caso es FormaLoterias
	 * @metodo: ejecutarProveedorServiciosVistaLogica
	 * @descripcion: metodo que consulta el proveedor, servicios y productos
	 * de pines y los sube a InformacionSession para que se pueda usar
	 * en la venta del producto.
	 * @autor: Andres Cardenas
	 *  ****************************************************************
	 */
	public void ejecutarProveedorServiciosVistaLogica(){
		
		OtrosServiciosVistaLogica otrosServiciosVistaLogica = new OtrosServiciosVistaLogica();
		IRespuestaTrama respuestaProveedorGiros;
		UtilidadesVistaLogica utilidadesVistaLogica=new UtilidadesVistaLogica();

		List<ProveedorServicioProducto> lProveedoresServiciosProductosGiros=new ArrayList<ProveedorServicioProducto>();
		List<ProveedorServicioProducto>	lstProveedoresServiciosProductos;
		List<Proveedor> lProvedoresGiros ;
		
		InformacionSession.getInstance().setlProveedorServicioProductoGiros(lProveedoresServiciosProductosGiros);

		for(EnumTiposServicios enmTipoServicio : EnumTiposServicios.values()){
			
			try{
				respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(enmTipoServicio.getStrClaveNueva());
				
				if	(		respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") 
						&& 	respuestaProveedorGiros.getValorAtributo("mensajeError")==null
					){
					
					lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
					
					if(enmTipoServicio.isBooConsideraEquivalenciaTercero()){
						
						lstProveedoresServiciosProductos	=	 utilidadesVistaLogica.obtenerProveedorServicioProductosEqui(	lProvedoresGiros,
																																enmTipoServicio.getStrClaveNueva(),
																																null
																															);
						
					}else{
					
						lstProveedoresServiciosProductos	=	 utilidadesVistaLogica.obtenerProveedorServicioProductos	(	lProvedoresGiros,
																																enmTipoServicio.getStrClaveNueva(),
																																null
																															);
					}
					
					lProveedoresServiciosProductosGiros.addAll	(	lstProveedoresServiciosProductos	);
					InformacionSessionGiros.getInstance().getHmLstProveedorServicioProductoGiros().put(enmTipoServicio.getStrClave(), lstProveedoresServiciosProductos);
				}
			}catch(Exception e){
				UtilidadesGiros.getInstance ().controlExcepcion ( e, null, false );
			}
		}
		
		/*
		//SE OBTIENE EL SERVICIO DE ENVIO DE GIROS
		respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(EnumParametrosApp.REQUIERECLAVE_ENVIOGIRO.getValorPropiedad());			
		if(respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") && respuestaProveedorGiros.getValorAtributo("mensajeError")==null){
			lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
			lProveedoresServiciosProductosGiros= utilidadesVistaLogica.obtenerProveedorServicioProductos(lProvedoresGiros,EnumParametrosApp.REQUIERECLAVE_ENVIOGIRO.getValorPropiedad(),null);
		}

		//SE OBTIENE EL SERVICIO DE PAGO DE GIROS
		respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(EnumParametrosApp.REQUIERECLAVE_PAGOGIRO.getValorPropiedad());				
		if(respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") && respuestaProveedorGiros.getValorAtributo("mensajeError")==null){
			lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
			lProveedoresServiciosProductosGiros.addAll( utilidadesVistaLogica.obtenerProveedorServicioProductos(lProvedoresGiros,EnumParametrosApp.REQUIERECLAVE_PAGOGIRO.getValorPropiedad(),null));					
		}	
		
		//SE OBTIENE EL SERVICIO DE PAGO DE GIROS
		respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(EnumParametrosApp.REQUIERECLAVE_PAGO_EXTERNO.getValorPropiedad());				
		if(respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") && respuestaProveedorGiros.getValorAtributo("mensajeError")==null){
			lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
			lProveedoresServiciosProductosGiros.addAll( utilidadesVistaLogica.obtenerProveedorServicioProductos(lProvedoresGiros,EnumParametrosApp.REQUIERECLAVE_PAGO_EXTERNO.getValorPropiedad(),null));					
		}	
		
		//SE OBTIENE EL SERVICIO DE ENVIO CONVENIO DE GIROS
		respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(EnumParametrosApp.REQUIERECLAVE_CONVGIRO.getValorPropiedad());				
		if(respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") && respuestaProveedorGiros.getValorAtributo("mensajeError")==null){
			lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
			lProveedoresServiciosProductosGiros.addAll( utilidadesVistaLogica.obtenerProveedorServicioProductosEqui(lProvedoresGiros,EnumParametrosApp.REQUIERECLAVE_CONVGIRO.getValorPropiedad(),null));					
		}				
		
		//SE OBTIENE EL SERVICIO DE PAGO CONVENIO DE GIROS
		respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(EnumParametrosApp.REQUIERECLAVE_PAGOCONV.getValorPropiedad());				
		if(respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") && respuestaProveedorGiros.getValorAtributo("mensajeError")==null){
			lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
			lProveedoresServiciosProductosGiros.addAll( utilidadesVistaLogica.obtenerProveedorServicioProductosEqui(lProvedoresGiros,EnumParametrosApp.REQUIERECLAVE_PAGOCONV.getValorPropiedad(),null));					
		}
		
		//SE OBTIENE EL SERVICIO DE SEGURO
		respuestaProveedorGiros = otrosServiciosVistaLogica.cargarProveedoresServicio(EnumParametrosApp.REQUIERECLAVE_SEGURO.getValorPropiedad());				
		if(respuestaProveedorGiros.getValorAtributo("respuesta").equals("0") && respuestaProveedorGiros.getValorAtributo("mensajeError")==null){
			lProvedoresGiros = respuestaProveedorGiros.getListaObjetos("listProveedores");
			lProveedoresServiciosProductosGiros.addAll( utilidadesVistaLogica.obtenerProveedorServicioProductos(lProvedoresGiros,EnumParametrosApp.REQUIERECLAVE_SEGURO.getValorPropiedad(),null));					
		}
		*/
	}
	
	@Override
	public void cargaInicial(TipoServicio tipoServicio, String arg0, JPanel arg1) throws Exception{
		boolean booInicioGirosExitoso;
		
		booInicioGirosExitoso = UtilIntegracionSlimGiros.getInstance().inicioGiros	(	tipoServicio.getTipo(), 
																						InformacionSession.getInstance().getPrincipalFrame()
																					);
		if	(	!booInicioGirosExitoso	)
		{
			throw EnumMensajes.ERROR_GENERAL.generarExcepcion(EnumClasesMensaje.ERROR);
		}
		
		//this.ejecutarProveedorServiciosVistaLogica();
	}
}