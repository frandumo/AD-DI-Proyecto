package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Consultas;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class InterfazReporte extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	JLabel labelReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazReporte frame = new InterfazReporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazReporte() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Panel head con botones y un textField
		//En el textField se pone el id del que se requiere un reporte y te muestra los datos de la estancia o inventario seleccionados por id_barco
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnEstancia = new JButton("Estancia");
		panel.add(btnEstancia);
		btnEstancia.addActionListener(this);
		btnEstancia.setActionCommand("ButtonEstancia");
		
		JButton btnInventario = new JButton("Inventario");
		panel.add(btnInventario);
		btnInventario.addActionListener(this);
		btnInventario.setActionCommand("ButtonInventario");
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		
		//En el label reporte se mostraran los datos
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		labelReporte = new JLabel("Reporte");
		panel_1.add(labelReporte);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Consultar estancias by id barco
		int id = Integer.parseInt(textField.getText().toString());
		String s = "";
		if(e.getActionCommand().equals("ButtonEstancia")){
			s=Consultas.getEstanciaById(id);
			labelReporte.setText(s);
		}
		//Consultar iinventario by id barco
		if(e.getActionCommand().equals("ButtonInventario")){
			s=Consultas.getInventarioById(id);
			labelReporte.setText(s);
		}
	}

}
