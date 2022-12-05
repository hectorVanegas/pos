package co.com.codesa.clienteposslimgiros.pruebas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.com.codesa.clienteposslim.general.InformacionSession;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.enumeraciones.EnumEtiquetas;
import co.com.codesa.clienteposslimgiros.formas.genericas.FormaGenerica;


public class FormaTest extends FormaGenerica{

	
	private static final long serialVersionUID = 1L;

	public FormaTest(JFrame pFrmPadre,
					 boolean pBooModal) throws Exception{
		
		super(pFrmPadre,
			  pBooModal);
		
		super.setEventoForma(new EventoFormaTest(this));
		
		this.inicializarForma();
	}

	@Override
	public void inicializarForma(Object ...pArrObjParametrosForma) throws Exception{
		
		super.setTituloForma(EnumEtiquetas.LBL_CAJERO);
		super.setAnchoForma(600);
		super.setAltoForma(400);
		super.adicionarAcciones(EnumBotonesEncabezado.BTNGUARDAR,EnumBotonesEncabezado.BTNCONSULTAR,
						  		EnumBotonesEncabezado.BTNIMPRIMIR,EnumBotonesEncabezado.BTNSALIR,EnumBotonesEncabezado.BTNVOLVER,
						  		EnumBotonesEncabezado.BTNOPERACION_INUSUAL);
		super.iniciar();

	}

	@Override
	public JPanel inicializarEncabezado(Object ...pArrObjParametrosEncabezado) {
		
		JPanel pnlFormaTest=  new JPanel();
		pnlFormaTest.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		pnlFormaTest.setLayout(null);	
		
		JLabel lblTexto= new JLabel("Texto del Encabezado");
		lblTexto.setBounds(0, 5, 200, 50);
		
		InformacionSession.getInstance().setIpSocket("10.11.3.41");
		InformacionSession.getInstance().setPuertoSocket("9009");
				
		pnlFormaTest.add(lblTexto);
		
		return pnlFormaTest;
		
	}

	@Override
	public JPanel inicializarCuerpo(Object ...pArrObjParametrosCuerpo) {
		return null;

	}

	@Override
	public JPanel inicializarPiePagina(Object ...pArrObjParametrosPiePagina) {
		return null;

	}


	public static void main(String[] args) {
		try{
			new FormaTest(null,true);
		}catch(Exception e){
			
		}
	}

}
