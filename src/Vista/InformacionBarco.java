package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;

import Controlador.Consultas;
import Controlador.Muelle;
import models.Barco;

import java.awt.Color;
import javax.swing.JLabel;

public class InformacionBarco extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	Muelle muelle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformacionBarco frame = new InformacionBarco(new Muelle());
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
	public InformacionBarco(){}
	
	public InformacionBarco(Muelle muelle) {
		//Se lanza la interfaz con un muelle que nos permitirá saber consultar los datos del barco que contiene
		this.muelle = muelle;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Panel head que contiene otros 2 paneles
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2));
		
		//Panel que contendrá la imagen representativa del barco
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		//Label que contendrá la imagen
		JLabel label = new JLabel();
		int size = Consultas.getBarcoSize(muelle.getMuelle());
		Imagen.setImagenBarco(label,size);
		panel_1.add(label);
		
		//Panel que contendrá la informacion del barco
		JPanel panel_2 = new JPanel();
		Barco barco = Consultas.getDatosBarco(muelle.getMuelle());//Consultamos el barco, para posteriormente cojer sus datos
		panel_2.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(5, 2));
		
		//Información del barco
		JLabel lblNombre = new JLabel("Nombre: "+barco.getNombre());
		panel_2.add(lblNombre);
		
		JLabel lblTipo = new JLabel("Tipo: "+barco.getTipo());
		panel_2.add(lblTipo);
		
		JLabel lblTamano = new JLabel("Tama\u00F1o: "+barco.getSize());
		panel_2.add(lblTamano);
		
		JLabel lblCapacidad = new JLabel("Capacidad: "+barco.getTonelaje());
		panel_2.add(lblCapacidad);
		
		String fecha_entrada = Consultas.getFechaEntrada(muelle.getMuelle());
		JLabel lblEnPuertoDesde = new JLabel("En Puerto Desde: "+fecha_entrada);
		panel_2.add(lblEnPuertoDesde);
		
		
		//Panel que contendrá los botones
		JPanel panel_foot = new JPanel();
		contentPane.add(panel_foot, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		panel_foot.add(btnVolver);
		btnVolver.addActionListener(this);
		btnVolver.setActionCommand("ButtonVolver");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ButtonVolver")){
			this.setVisible(false);
		}
		
	}

}
