package co.com.codesa.clienteposslimgiros.pruebas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import co.com.codesa.clienteposslimgiros.enumeraciones.EnumBotonesEncabezado;
import co.com.codesa.clienteposslimgiros.eventos.abstracto.EventoAbstracto;

public class EventoFormaTest extends EventoAbstracto{
	
	public EventoFormaTest(FormaTest pFrmTest){
		super(pFrmTest);
	}
	
	public void iniciarValores(Object ...pArrObjParametrosInicio)throws Exception{
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		try{
		
			Component componente = (Component)evt.getSource();
			if(componente.getName().equals(EnumBotonesEncabezado.BTNGUARDAR.getCodigo())){
				System.out.println("Esta guardando");
			}else if(componente.getName().equals(EnumBotonesEncabezado.BTNCONSULTAR.getCodigo())){
				System.out.println("Esta consultando");
			}else if(componente.getName().equals(EnumBotonesEncabezado.BTNIMPRIMIR.getCodigo())){
				System.out.println("Esta imprimir");
			}else if(componente.getName().equals(EnumBotonesEncabezado.BTNSALIR.getCodigo())){
				this.castFrmTest().dispose();
				System.out.println("Esta saliendo");
			}else if(componente.getName().equals(EnumBotonesEncabezado.BTNVOLVER.getCodigo())){
				System.out.println("Esta volviendo");
			}else if(componente.getName().equals(EnumBotonesEncabezado.BTNOPERACION_INUSUAL.getCodigo())){
				System.out.println("Esta en operacion inusual");
			}
			
		}catch(Exception e){
			super.controlExcepcion(e);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public FormaTest castFrmTest()throws Exception{
		return (FormaTest)super.getFrmForma();
	}
	


}
