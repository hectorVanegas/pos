package co.com.codesa.clienteposslimgiros.eventos.generico;

import java.awt.Component;
import java.awt.event.ItemEvent;

import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelCajaTextoProtegida;

public class EventoFormaPanelCajaTextoProtegida extends EventoAbstracto {

	private FormaPanelCajaTextoProtegida pnlCajaTextoProtegida;
	
	public EventoFormaPanelCajaTextoProtegida(FormaPanelCajaTextoProtegida pPnlCajaTextoProtegida)throws Exception{
		
		super(pPnlCajaTextoProtegida.getFrmGnrVentana());
		this.pnlCajaTextoProtegida = pPnlCajaTextoProtegida;
	}

	@Override
	public void accionarCambioItem(Component pComponent,
								   ItemEvent pEvtItemStateChanged) throws Exception {
		
		if(pComponent.equals(this.getPnlCajaTextoProtegida().getChkMostrarContenidoProtegido())){
			
			this.getPnlCajaTextoProtegida().getPfiCajaClave().setBooMostrarContenidoProtegido(this.getPnlCajaTextoProtegida().getChkMostrarContenidoProtegido().isSelected());
			
		}else{
			super.accionarCambioItem(pComponent,pEvtItemStateChanged);
		}
	}
	
	public FormaPanelCajaTextoProtegida getPnlCajaTextoProtegida() {
		return pnlCajaTextoProtegida;
	}

	public void setPnlCajaTextoProtegida(
			FormaPanelCajaTextoProtegida pnlCajaTextoProtegida) {
		this.pnlCajaTextoProtegida = pnlCajaTextoProtegida;
	}
}
