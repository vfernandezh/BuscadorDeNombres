package control.acciones;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import control.ParaUI;
import modelo.Persona;

public class ActionDeserializar implements ItemListener{
private ParaUI paraUI;
	

	public ActionDeserializar(ParaUI paraUI) {
		this.paraUI = paraUI;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		this.paraUI.visualizarDireccion((Persona)this.paraUI.deserializar(((JComboBox) e.getSource()).getSelectedIndex()));
	}
	
}
