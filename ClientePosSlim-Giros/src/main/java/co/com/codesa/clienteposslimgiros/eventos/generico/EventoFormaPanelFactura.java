package co.com.codesa.clienteposslimgiros.eventos.generico;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumClasesMensaje;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumDocumentos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumProductos;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumMensajes;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaPanelFactura;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Documento;
import co.com.codesa.codesawrappergiros.modelo.dominio.giros.negocio.Producto;

public class EventoFormaPanelFactura extends EventoAbstracto {

	private Producto objProducto;
	private Documento objDocumento; 
	private String strNumero;
	
	private FormaPanelFactura pnlFactura;
	
	public EventoFormaPanelFactura(FormaPanelFactura pPnlFactura) throws Exception{
	
		super(pPnlFactura.getFormaPadre());
		//super.setFrmForma(pPnlFactura.getFormaPadre());
		this.pnlFactura = pPnlFactura;
	}
	
	public void cargarPanel(EnumProductos pEnmProducto, 
							EnumDocumentos pEnumDocumento,
							String pStrNumero)throws Exception{
		
		if(pEnmProducto.getObjProducto()==null){
			
			throw EnumMensajes.PRODUCTO_NO_DISPONIBLE_AGENCIA.generarExcepcion(EnumClasesMensaje.ERROR, 
					   														   pEnmProducto.name());
		}else{
		
			this.setObjProducto(pEnmProducto.getObjProducto());
		}
		
		if(pEnumDocumento.getObjDocumento()==null){
			
			throw EnumMensajes.DOCUMENTO_NO_DISPONIBLE_AGENCIA.generarExcepcion(EnumClasesMensaje.ERROR, 
					   															pEnmProducto.name());
		}else{
			
			this.setObjDocumento(pEnumDocumento.getObjDocumento());
		}
		
		this.setStrNumero(pStrNumero);
	}
	
	public void cargarPanel(Producto pObjProducto,
							Documento pObjDocumento,
							String pStrNumero)throws Exception{
		
		this.setObjProducto(pObjProducto);
		this.setObjDocumento(pObjDocumento);
		this.setStrNumero(pStrNumero);
	}

	public Producto getObjProducto() {
		return objProducto;
	}

	public void setObjProducto(Producto objProducto) throws Exception{
		
		this.objProducto = objProducto;
		
		if(this.objProducto!=null){
			
			this.getPnlFactura().getTxtProducto().setText(this.objProducto.toString());
			this.getPnlFactura().getTxtProducto().setCaretPosition(0);
			
		}else{
			
			this.getPnlFactura().getTxtProducto().setText("");
		}
	}

	public Documento getObjDocumento() {
		return objDocumento;
	}

	public void setObjDocumento(Documento objDocumento) throws Exception{
		
		this.objDocumento = objDocumento;
		
		if(this.objDocumento!=null){
			
			this.getPnlFactura().getTxtDocumento().setText(this.objDocumento.toString());
			this.getPnlFactura().getTxtDocumento().setCaretPosition(0);
			
		}else{
			
			this.getPnlFactura().getTxtDocumento().setText("");
		}
	}

	public String getStrNumero() {
		return strNumero;
	}

	public void setStrNumero(String strNumero) {
		
		this.strNumero = strNumero;
		this.getPnlFactura().getTxtNumero().setText(strNumero);
	}

	public FormaPanelFactura getPnlFactura() {
		return pnlFactura;
	}

	public void setPnlFactura(FormaPanelFactura pnlFactura) {
		this.pnlFactura = pnlFactura;
	}
}