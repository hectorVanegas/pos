package co.com.codesa.clienteposslimgiros.utilidades.validaciones;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumImpresiones;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.vista.logica.GiroVistaLogica;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.FacturaGiro;

public class ValidacionesROE {

	private static ValidacionesROE instancia;
	
	
	private ValidacionesROE(){
		
	}
	
	public static ValidacionesROE getInstance(){
		if(instancia==null){
			instancia= new ValidacionesROE();
		}
		return instancia;
	}
	
	
	public void validarROE(EventoAbstracto pEventoAbstracto, 
						   FacturaGiro pFacturaGiro) throws Exception{
		
		Long lonTransaccionesdia;
		
		try{
			
			lonTransaccionesdia = Long.parseLong(GiroVistaLogica.getInstance().transaccionesDia(pEventoAbstracto.getObjUsuario(),
																								pFacturaGiro.getTerceroOrigen()));
			pFacturaGiro.setTransDia(lonTransaccionesdia);
			
			if(lonTransaccionesdia>=pEventoAbstracto.getObjUsuario().getTope()){
				
				EnumImpresiones.ROE.ejecutarImpresion(pEventoAbstracto.getFrmForma(), 
													  false, 
													  pFacturaGiro);
			}
		
		}catch(Exception e){
			pEventoAbstracto.controlExcepcion(e);
		}
	}
}
