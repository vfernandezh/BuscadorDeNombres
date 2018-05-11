package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class UI extends JFrame {
	
	protected JTextField nombre;
	protected JTextField direccion;
	protected JButton botonAlta;
	protected JPanel panelAlta;
	protected JComboBox<String> comboBox;
	protected JTextField textoDireccion;

	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panelAlta = new JPanel();
		tabbedPane.addTab("Alta", null, panelAlta, null);
		panelAlta.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBorder(new EmptyBorder(15, 0, 10, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		panelAlta.add(lblNombre, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panelAlta.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 70, 0, 70));
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		nombre = new JTextField();
		panel_3.add(nombre, BorderLayout.NORTH);
		nombre.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDireccion = new JLabel("Direccion:");
		panel_2.add(lblDireccion, BorderLayout.NORTH);
		lblDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDireccion.setBorder(new EmptyBorder(15, 0, 10, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 70, 0, 70));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		direccion = new JTextField();
		panel_5.add(direccion, BorderLayout.NORTH);
		direccion.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(20, 0, 0, 0));
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		botonAlta = new JButton("Dar de Alta");
		panel_6.add(botonAlta);
		
		JPanel panelBusqueda = new JPanel();
		tabbedPane.addTab("Busqueda", null, panelBusqueda, null);
		panelBusqueda.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Selecciona nombre:");
		lblNewLabel.setBorder(new EmptyBorder(5, 0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelBusqueda.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 40, 0));
		panelBusqueda.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new EmptyBorder(5, 30, 0, 30));
		panel.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		comboBox = new JComboBox<String>();
		panel_7.add(comboBox, BorderLayout.CENTER);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(0, 30, 0, 30));
		panel.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		textoDireccion = new JTextField();
		textoDireccion.setEditable(false);
		panel_9.add(textoDireccion, BorderLayout.CENTER);
		textoDireccion.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_9.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblDireccion_1 = new JLabel("Direccion:");
		panel_8.add(lblDireccion_1);
		
		
	}

	public JTextField getNombre() {
		return nombre;
	}

	public JTextField getDireccion() {
		return direccion;
	}

	public JButton getBotonAlta() {
		return botonAlta;
	}

	public JPanel getPanelAlta() {
		return panelAlta;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public JTextField getTextoDireccion() {
		return textoDireccion;
	}

}
