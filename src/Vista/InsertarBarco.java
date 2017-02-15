package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Consultas;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InsertarBarco extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	
	int muelle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertarBarco frame = new InsertarBarco();
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
	public InsertarBarco() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Panel Principal
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		
		//Panel label texto
		
		JLabel lblSeleccionaPuerto = new JLabel("Selecciona Puerto:");
		panel_1.add(lblSeleccionaPuerto);
		
		//Panel botones
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		ArrayList<Integer> muellesDisponibles = new ArrayList<Integer>();
		muellesDisponibles=Consultas.getMuellesDisponibles();
		
		//Solo se mostrarán aquellos botones que referencien a un muelle vacio al que se le puede añadir un barco
		if(muellesDisponibles.contains(1)){
		button1 = new JButton("1");
		panel_2.add(button1);
		button1.addActionListener(this);
		button1.setActionCommand("Button1");
		}
		if(muellesDisponibles.contains(2)){
			button2 = new JButton("2");
			panel_2.add(button2);
			button2.addActionListener(this);
			button2.setActionCommand("Button2");
			}
		if(muellesDisponibles.contains(3)){
			button3 = new JButton("3");
			panel_2.add(button3);
			button3.addActionListener(this);
			button3.setActionCommand("Button3");
			}
		if(muellesDisponibles.contains(4)){
			button4 = new JButton("4");
			panel_2.add(button4);
			button4.addActionListener(this);
			button4.setActionCommand("Button4");
			}
		if(muellesDisponibles.contains(5)){
			button5 = new JButton("5");
			panel_2.add(button5);
			button5.addActionListener(this);
			button5.setActionCommand("Button5");
			}
		if(muellesDisponibles.contains(6)){
			button6 = new JButton("6");
			panel_2.add(button6);
			button6.addActionListener(this);
			button6.setActionCommand("Button6");
			}
		if(muellesDisponibles.contains(7)){
			button7 = new JButton("7");
			panel_2.add(button7);
			button7.addActionListener(this);
			button7.setActionCommand("Button7");
			}
		if(muellesDisponibles.contains(8)){
			button8 = new JButton("8");
			panel_2.add(button8);
			button8.addActionListener(this);
			button8.setActionCommand("Button8");
			}
		
		
		//Panel
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		//Label
		JLabel lblNombre = new JLabel("Nombre:");
		panel_3.add(lblNombre);
		
		//Texto
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o:");
		panel_5.add(lblTamao);
		
		Panel panel_6 = new Panel();
		panel.add(panel_6);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		Panel panel_7 = new Panel();
		panel.add(panel_7);
		
		JLabel lblTipo = new JLabel("Tipo:");
		panel_7.add(lblTipo);
		
		Panel panel_8 = new Panel();
		panel.add(panel_8);
		
		textField_2 = new JTextField();
		panel_8.add(textField_2);
		textField_2.setColumns(10);
		
		Panel panel_9 = new Panel();
		panel.add(panel_9);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		panel_9.add(lblCapacidad);
		
		Panel panel_10 = new Panel();
		panel.add(panel_10);
		
		textField_3 = new JTextField();
		panel_10.add(textField_3);
		textField_3.setColumns(10);
		
		
		//Panel foot con botones
		Panel panel_11 = new Panel();
		contentPane.add(panel_11, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_11.add(btnAceptar);
		btnAceptar.addActionListener(this);
		btnAceptar.setActionCommand("ButtonAceptar");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_11.add(btnCancelar);
		btnCancelar.addActionListener(this);
		btnCancelar.setActionCommand("ButtonCancelar");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("Button1")){muelle=1;}
		if(e.getActionCommand().equals("Button2")){muelle=2;}
		if(e.getActionCommand().equals("Button3")){muelle=3;}
		if(e.getActionCommand().equals("Button4")){muelle=4;}
		if(e.getActionCommand().equals("Button5")){muelle=5;}
		if(e.getActionCommand().equals("Button6")){muelle=6;}
		if(e.getActionCommand().equals("Button7")){muelle=7;}
		if(e.getActionCommand().equals("Button8")){muelle=8;}
		
		if(e.getActionCommand().equals("ButtonAceptar")){
			
			Consultas.insertarBarco(muelle, textField.getText().toString(), textField_1.getText().toString(), textField_2.getText().toString(), Integer.parseInt(textField_3.getText().toString()));
		
			this.setVisible(false);
			
			
		}
		
		if(e.getActionCommand().equals("ButtonCancelar")){
			this.setVisible(false);
		}
		
		
		
	}

}
