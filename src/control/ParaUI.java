package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import control.acciones.ActionDarAlta;
import control.acciones.ActionDeserializar;
import modelo.Persona;
import vista.UI;

public class ParaUI extends UI {
	
	public ArrayList<Persona> personas;

	public ParaUI() {
		this.personas = new ArrayList<>();
		getBotonAlta().addActionListener(new ActionDarAlta(this));
		getComboBox().addActionListener(new ActionDeserializar(this));

	}

	public void agregarCliente() {
		if (!comprobarCampos())
			personas.add(new Persona(getNombre().getText(), getDireccion().getText()));
		añadirPersonaAlCombo();
		serializarPersona();

	}

	private void serializarPersona() {

		ObjectOutputStream escribirFichero;
		try {
			escribirFichero = new ObjectOutputStream(new FileOutputStream("AlmacenDeClientes.dat"));
			escribirFichero.writeObject(this.personas);
			escribirFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deserializarPersona() {
		try {
			ObjectInputStream recuperarFichero = new ObjectInputStream(new FileInputStream("AlmacenDeClientes.dat"));
			ArrayList<Persona> personasRecuperadas = (ArrayList<Persona>) recuperarFichero.readObject();
			this.personas = personasRecuperadas;
			recuperarFichero.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int obtenerDireccion(String nombre) {
		int posicion = 0;
		for (int i = 0; i < personas.size(); i++) {
			if (personas.get(i).getNombre() == nombre) {
				posicion = i;
			}
		}
		return posicion;
	}

	public void visualizarDireccion() {
		textoDireccion.setText(personas.get(obtenerDireccion(getComboBox().getSelectedItem().toString())).getDireccion());
	}

	private void añadirPersonaAlCombo() {
		comboBox.addItem(nombre.getText());
	}

	private boolean comprobarCampos() {
		return !getDireccion().getText().isEmpty() && !getNombre().getText().isEmpty();
	}

}
