package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import Controlador.Consultas;
import Controlador.Muelle;
import models.Barco;

import java.awt.Color;

public class GestionBarco extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	int maximoMercancias = 0;
	int totalMercancias = 0;
	
	Muelle muelle;
	Barco barco;
	
	ArrayList<Integer> mercancias;
	
	
	JLabel label;
	JLabel lblNombre;
	JLabel lblTipo;
	JLabel lblTamano;
	JLabel lblCapacidad;
	JLabel lblEnPuertoDesde;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionBarco frame = new GestionBarco(new Muelle());
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
	public GestionBarco(Muelle muelle) {
		//Se lanza la interfaz con un muelle que nos permitirá saber consultar los datos del barco que contiene
		this.muelle = muelle;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Panel head que contiene otros 2 paneles
		JPanel panel_head = new JPanel();
		contentPane.add(panel_head, BorderLayout.NORTH);
		panel_head.setLayout(new GridLayout(1,2));
		
		//Panel que contendrá la imagen representativa del barco
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_head.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		//Label que contendrá la imagen
		JLabel label_icon = new JLabel();
		int size = Consultas.getBarcoSize(muelle.getMuelle());
		Imagen.setImagenBarco(label_icon,size);
		panel_1.add(label_icon);
		
		//Panel que contendrá la informacion del barco
		JPanel panel_2 = new JPanel();
		barco = Consultas.getDatosBarco(muelle.getMuelle());//Consultamos el barco, para posteriormente cojer sus datos
		panel_2.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_head.add(panel_2);
		panel_2.setLayout(new GridLayout(5,2));
		
		//Información del barco
		lblNombre = new JLabel("Nombre: "+barco.getNombre());
		panel_2.add(lblNombre);
		
		lblTipo = new JLabel("Tipo: "+barco.getTipo());
		panel_2.add(lblTipo);
		
		lblTamano = new JLabel("Tama\u00F1o: "+barco.getSize());
		panel_2.add(lblTamano);
		
		lblCapacidad = new JLabel("Capacidad: "+barco.getTonelaje());
		panel_2.add(lblCapacidad);
		
		String fecha_entrada = Consultas.getFechaEntrada(muelle.getMuelle());
		lblEnPuertoDesde = new JLabel("En Puerto Desde: "+fecha_entrada);
		panel_2.add(lblEnPuertoDesde);
		
		//Panel central
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8, BorderLayout.NORTH);
		
		//Label gestion
		JLabel lblGestin = new JLabel("GESTI\u00D3N");
		panel_8.add(lblGestin);
		lblGestin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_center = new JPanel();
		panel.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(0, 1, 0, 0));
		
		//Consultamos las mercancias del barco
		mercancias = new ArrayList<Integer>();
		mercancias = Consultas.getMercanciaValue(barco.getIdBarco());
		
		//Ponemos el los textField la cantidad de cada mercancia que contiene el barco atracado en este muelle
		JPanel panel_3 = new JPanel();
		panel_center.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Alimento:");
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField(""+mercancias.get(0));
		panel_3.add(textField_1);
		textField_1.setColumns(4);
		
		JPanel panel_4 = new JPanel();
		panel_center.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("  Madera:");
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField(""+mercancias.get(1));
		panel_4.add(textField_2);
		textField_2.setColumns(4);
		
		JPanel panel_5 = new JPanel();
		panel_center.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("    Hierro:");
		panel_5.add(lblNewLabel_3);
		
		textField_3 = new JTextField(""+mercancias.get(2));
		panel_5.add(textField_3);
		textField_3.setColumns(4);
		
		JPanel panel_6 = new JPanel();
		panel_center.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("    Piedra:");
		panel_6.add(lblNewLabel);
		
		textField_4 = new JTextField(""+mercancias.get(3));
		panel_6.add(textField_4);
		textField_4.setColumns(4);
		
		//Total y maximo
		totalMercancias = (int) (mercancias.get(0)+mercancias.get(1)+mercancias.get(2)+mercancias.get(3));
		maximoMercancias = (int) (barco.getTonelaje());
		
		JPanel panel_7 = new JPanel();
		panel_center.add(panel_7);
		
		JLabel lblTotal = new JLabel("Total:");
		panel_7.add(lblTotal);
		
		label = new JLabel(""+totalMercancias);
		panel_7.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("Maximo: "+barco.getTonelaje());
		panel_7.add(lblNewLabel_4);
		
		//Panel que contendrá los botones
		JPanel panel_south = new JPanel();
		panel.add(panel_south, BorderLayout.SOUTH);
		
		JButton btnComprobar = new JButton("Comprobar");
		panel_south.add(btnComprobar);
		btnComprobar.addActionListener(this);
		btnComprobar.setActionCommand("ButtonComprobar");
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_south.add(btnAceptar);
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand("ButtonAceptar");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_south.add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("ButtonCancelar");
		
		JPanel panel_foot = new JPanel();
		contentPane.add(panel_foot, BorderLayout.SOUTH);
		
		
	}
	
	public void actionPerformed(ActionEvent e){
				
		//Comprueba si la cantidad deseada a introducir en el barco no excede la capacidad máxima del barco
		if(e.getActionCommand().equals("ButtonComprobar")){
				totalMercancias = (int) (Integer.parseInt(textField_1.getText().toString())+
				Integer.parseInt(textField_2.getText().toString())+
				Integer.parseInt(textField_3.getText().toString())+
				Integer.parseInt(textField_4.getText().toString()));
			label.setText(""+totalMercancias);

		}
		//Si la cantidad es aceptable, se puede aceptar la operación y se guardarán los cambios
		if(e.getActionCommand().equals("ButtonAceptar")){
			if(totalMercancias<=maximoMercancias){
				ArrayList<Integer> newMercancias = new ArrayList<Integer>();

					if(Integer.parseInt(textField_1.getText().toString())==mercancias.get(0)){newMercancias.add(null);}
					else{newMercancias.add(Integer.parseInt(textField_1.getText().toString()));}
					
					if(Integer.parseInt(textField_2.getText().toString())==mercancias.get(1)){newMercancias.add(null);}
					else{newMercancias.add(Integer.parseInt(textField_2.getText().toString()));}
					
					if(Integer.parseInt(textField_3.getText().toString())==mercancias.get(2)){newMercancias.add(null);}
					else{newMercancias.add(Integer.parseInt(textField_3.getText().toString()));}
					
					if(Integer.parseInt(textField_4.getText().toString())==mercancias.get(3)){newMercancias.add(null);}
					else{newMercancias.add(Integer.parseInt(textField_4.getText().toString()));}
					
				
				
				Consultas.modificarInventario(newMercancias, barco.getIdBarco());
				this.setVisible(false);
			}		
		}
		//"Cerramos" la interfaz
		if(e.getActionCommand().equals("ButtonCancelar")){
			this.setVisible(false);
		}
	}

}
