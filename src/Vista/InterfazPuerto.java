package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import Controlador.Consultas;
import Controlador.Muelle;

public class InterfazPuerto extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Muelle muelle1 = new Muelle(1);
	private Muelle muelle2 = new Muelle(2);
	private Muelle muelle3 = new Muelle(3);
	private Muelle muelle4 = new Muelle(4);
	private Muelle muelle5 = new Muelle(5);
	private Muelle muelle6 = new Muelle(6);
	private Muelle muelle7 = new Muelle(7);
	private Muelle muelle8 = new Muelle(8);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPuerto frame = new InterfazPuerto();
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
	public InterfazPuerto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(1,2));
		setContentPane(contentPane);
		
		JPanel panel_center = new JPanel();
		panel_center.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(1, 0, 0, 0));
		
		//IZQ
		
		JPanel panel_iz = new JPanel();
		panel_iz.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_center.add(panel_iz);
		panel_iz.setLayout(new GridLayout(4,2));
		
		
		//Muelle 1
		
		//Creamos el panel
		JPanel panel_imagen_1 = new JPanel();
		//Le damos un borde para separarlo de otros paneles
		panel_imagen_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		//Lo añadimos al panel que lo incluirá
		panel_iz.add(panel_imagen_1);
		//Consultamos el tamaño del barco
		int size1 = Consultas.getBarcoSize(1);
		//Consultamos si está ocupado o vacio
		if(Consultas.getBarcoOcupado(1)){
			muelle1.setOcupado(1);
		}
		//Creamos el label que contendrá la imagen
		JLabel label_imagen_1 = new JLabel();
		//Le damos una imagen al panel en funcion del tamaño
		Imagen.setImagenBarco(label_imagen_1,size1);
		//Lo añademos al panel que lo incluirá
		panel_imagen_1.add(label_imagen_1);
		
		//Creamos el panel de botones y lo configuramos
		JPanel panel_boton_1 = new JPanel();
		panel_boton_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_iz.add(panel_boton_1);
		
		//Creamos el boton información y lo configuramos para que ejecute una accion al ser pulsado
		JButton btnNewButton = new JButton("Información");
		panel_boton_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("ButtonInfo1");
		
		//Creamos el boton gestionar y lo configuramos para que ejecute una accion al ser pulsado
		JButton btnGestionar = new JButton("Gestionar");
		panel_boton_1.add(btnGestionar);
		btnGestionar.addActionListener(this);
		btnGestionar.setActionCommand("ButtonGestionar1");
		
		//Creamos el boton descargar y lo configuramos para que ejecute una accion al ser pulsado
		JButton btnDescargar = new JButton("Descargar");
		panel_boton_1.add(btnDescargar);
		btnDescargar.addActionListener(this);
		btnDescargar.setActionCommand("ButtonDescargar1");
		
		
		//Muelle 2
		
		JPanel panel_imagen_2 = new JPanel();
		panel_imagen_2.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_iz.add(panel_imagen_2);
		JLabel label_imagen_2 = new JLabel();
		int size2 = Consultas.getBarcoSize(2);
		if(Consultas.getBarcoOcupado(2)){
			muelle2.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_2,size2);
		panel_imagen_2.add(label_imagen_2);
		
		JPanel panel_boton_2 = new JPanel();
		panel_boton_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_iz.add(panel_boton_2);
		
		JButton btnNewButton_1 = new JButton("Información");
		panel_boton_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setActionCommand("ButtonInfo2");
		
		JButton btnGestionar_1 = new JButton("Gestionar");
		panel_boton_2.add(btnGestionar_1);
		btnGestionar_1.addActionListener(this);
		btnGestionar_1.setActionCommand("ButtonGestionar2");
		
		JButton btnDescargar_1 = new JButton("Descargar");
		panel_boton_2.add(btnDescargar_1);
		btnDescargar_1.addActionListener(this);
		btnDescargar_1.setActionCommand("ButtonDescargar2");
		
		
		//Muelle 3
		
		JPanel panel_imagen_3 = new JPanel();
		panel_imagen_3.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_iz.add(panel_imagen_3);
		JLabel label_imagen_3 = new JLabel();
		int size3 = Consultas.getBarcoSize(3);
		if(Consultas.getBarcoOcupado(3)){
			muelle3.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_3,size3);
		panel_imagen_3.add(label_imagen_3);
		
		JPanel panel_boton_3 = new JPanel();
		panel_boton_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_iz.add(panel_boton_3);
		
		JButton btnNewButton_2 = new JButton("Información");
		panel_boton_3.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setActionCommand("ButtonInfo3");
		
		JButton btnGestionar_2 = new JButton("Gestionar");
		panel_boton_3.add(btnGestionar_2);
		btnGestionar_2.addActionListener(this);
		btnGestionar_2.setActionCommand("ButtonGestionar3");
		
		JButton btnDescargar_2 = new JButton("Descargar");
		panel_boton_3.add(btnDescargar_2);
		btnDescargar_2.addActionListener(this);
		btnDescargar_2.setActionCommand("ButtonDescargar3");
		
		
		//Muelle 4
		
		JPanel panel_imagen_4 = new JPanel();
		panel_imagen_4.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_iz.add(panel_imagen_4);
		JLabel label_imagen_4 = new JLabel();
		int size4 = Consultas.getBarcoSize(4);
		if(Consultas.getBarcoOcupado(4)){
			muelle4.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_4,size4);
		panel_imagen_4.add(label_imagen_4);
		
		JPanel panel_boton_4 = new JPanel();
		panel_iz.add(panel_boton_4);
		
		JButton btnNewButton_3 = new JButton("Información");
		panel_boton_4.add(btnNewButton_3);
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setActionCommand("ButtonInfo4");
		
		JButton btnGestionar_3 = new JButton("Gestionar");
		panel_boton_4.add(btnGestionar_3);
		btnGestionar_3.addActionListener(this);
		btnGestionar_3.setActionCommand("ButtonGestionar4");
		
		JButton btnDescargar_3 = new JButton("Descargar");
		panel_boton_4.add(btnDescargar_3);
		btnDescargar_3.addActionListener(this);
		btnDescargar_3.setActionCommand("ButtonDescargar4");
		
		
		//DER
		
		JPanel panel_der = new JPanel();
		panel_der.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_center.add(panel_der);
		panel_der.setLayout(new GridLayout(4,2));
		
		
		//Muelle 5
		
		JPanel panel_imagen_5 = new JPanel();
		panel_imagen_5.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_imagen_5);
		JLabel label_imagen_5 = new JLabel();
		int size5 = Consultas.getBarcoSize(5);
		if(Consultas.getBarcoOcupado(5)){
			muelle5.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_5,size5);
		panel_imagen_5.add(label_imagen_5);
		
		JPanel panel_boton_5 = new JPanel();
		panel_boton_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_boton_5);
		
		JButton btnNewButton_4 = new JButton("Información");
		panel_boton_5.add(btnNewButton_4);
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setActionCommand("ButtonInfo5");
		
		JButton btnGestionar_4 = new JButton("Gestionar");
		panel_boton_5.add(btnGestionar_4);
		btnGestionar_4.addActionListener(this);
		btnGestionar_4.setActionCommand("ButtonGestionar5");
		
		JButton btnDescargar_4 = new JButton("Descargar");
		panel_boton_5.add(btnDescargar_4);
		btnDescargar_4.addActionListener(this);
		btnDescargar_4.setActionCommand("ButtonDescargar5");
		
		
		//Muelle 6
		
		JPanel panel_imagen_6 = new JPanel();
		panel_imagen_6.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_imagen_6);
		JLabel label_imagen_6 = new JLabel();
		int size6 = Consultas.getBarcoSize(6);
		if(Consultas.getBarcoOcupado(6)){
			muelle6.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_6,size6);
		panel_imagen_6.add(label_imagen_6);
		
		JPanel panel_boton_6 = new JPanel();
		panel_boton_6.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_boton_6);
		
		JButton btnNewButton_5 = new JButton("Información");
		panel_boton_6.add(btnNewButton_5);
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setActionCommand("ButtonInfo6");
		
		JButton btnGestionar_5 = new JButton("Gestionar");
		panel_boton_6.add(btnGestionar_5);
		btnGestionar_5.addActionListener(this);
		btnGestionar_5.setActionCommand("ButtonGestionar6");
		
		JButton btnDescargar_5 = new JButton("Descargar");
		panel_boton_6.add(btnDescargar_5);
		btnDescargar_5.addActionListener(this);
		btnDescargar_5.setActionCommand("ButtonDescargar6");
		
		
		//Muelle 7
		
		JPanel panel_imagen_7 = new JPanel();
		panel_imagen_7.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_imagen_7);
		JLabel label_imagen_7 = new JLabel();
		int size7 = Consultas.getBarcoSize(7);
		if(Consultas.getBarcoOcupado(7)){
			muelle7.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_7,size7);
		panel_imagen_7.add(label_imagen_7);
		
		JPanel panel_boton_7 = new JPanel();
		panel_boton_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_boton_7);
		
		JButton btnNewButton_6 = new JButton("Información");
		panel_boton_7.add(btnNewButton_6);
		btnNewButton_6.addActionListener(this);
		btnNewButton_6.setActionCommand("ButtonInfo7");
		
		JButton btnGestionar_6 = new JButton("Gestionar");
		panel_boton_7.add(btnGestionar_6);
		btnGestionar_6.addActionListener(this);
		btnGestionar_6.setActionCommand("ButtonGestionar7");
		
		JButton btnDescargar_6 = new JButton("Descargar");
		panel_boton_7.add(btnDescargar_6);
		btnDescargar_6.addActionListener(this);
		btnDescargar_6.setActionCommand("ButtonDescargar7");
		
		
		//Muelle 8
		
		JPanel panel_imagen_8 = new JPanel();
		panel_imagen_8.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		panel_der.add(panel_imagen_8);
		JLabel label_imagen_8 = new JLabel();
		int size8 = Consultas.getBarcoSize(8);
		if(Consultas.getBarcoOcupado(8)){
			muelle8.setOcupado(1);
		}
		Imagen.setImagenBarco(label_imagen_8,size8);
		panel_imagen_8.add(label_imagen_8);
		
		JPanel panel_boton_8 = new JPanel();
		panel_der.add(panel_boton_8);
		
		JButton btnNewButton_7 = new JButton("Información");
		panel_boton_8.add(btnNewButton_7);
		btnNewButton_7.addActionListener(this);
		btnNewButton_7.setActionCommand("ButtonInfo8");
		
		JButton btnGestionar_7 = new JButton("Gestionar");
		panel_boton_8.add(btnGestionar_7);
		btnGestionar_7.addActionListener(this);
		btnGestionar_7.setActionCommand("ButtonGestionar8");
		
		JButton btnDescargar_7 = new JButton("Descargar");
		panel_boton_8.add(btnDescargar_7);
		btnDescargar_7.addActionListener(this);
		btnDescargar_7.setActionCommand("ButtonDescargar8");
		
		//Head
		
		JPanel panel_head = new JPanel();
		contentPane.add(panel_head, BorderLayout.NORTH);
		
		JLabel lblMenuPuerto = new JLabel("Menu Puerto");
		panel_head.add(lblMenuPuerto);
		
		
		//Panel foot con 3 botones
		JPanel panel_foot = new JPanel();
		contentPane.add(panel_foot, BorderLayout.SOUTH);
		panel_foot.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCerrar = new JButton("Cerrar");
		panel_foot.add(btnCerrar);
		btnCerrar.addActionListener(this);
		btnCerrar.setActionCommand("ButtonCerrar");
		
		JButton btnNuevo = new JButton("Nuevo");
		panel_foot.add(btnNuevo);
		btnNuevo.addActionListener(this);
		btnNuevo.setActionCommand("ButtonNuevo");
		
		JButton btnReporte = new JButton("Reporte");
		panel_foot.add(btnReporte);
		btnReporte.addActionListener(this);
		btnReporte.setActionCommand("ButtonReporte");
	}
	
	public void actionPerformed(ActionEvent e){
		
		//Lanza la interfaz información si el muelle está ocupado
		if(e.getActionCommand().equals("ButtonInfo1")){
			if(muelle1.getOcupado()==1){
			InformacionBarco info = new InformacionBarco(muelle1);
			info.setVisible(true);
			}
		}
		//Lanza la interfaz gestion si el muelle está ocupado
		if(e.getActionCommand().equals("ButtonGestionar1")){
			if(muelle1.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle1);
			gestion.setVisible(true);
			}
		}
		//Lanzar la opcion de borrar/descargar el inventario
		if(e.getActionCommand().equals("ButtonDescargar1")){
			if(muelle1.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(1);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo2")){
			if(muelle2.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle2);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar2")){
			if(muelle2.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle2);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar2")){
			if(muelle2.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(2);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo3")){
			if(muelle3.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle3);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar3")){
			if(muelle3.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle3);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar3")){
			if(muelle3.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(3);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo4")){
			if(muelle4.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle4);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar4")){
			if(muelle4.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle4);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar4")){
			if(muelle4.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(4);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo5")){
			if(muelle5.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle5);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar5")){
			if(muelle5.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle5);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar5")){
			if(muelle5.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(5);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo6")){
			if(muelle6.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle6);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar6")){
			if(muelle6.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle6);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar6")){
			if(muelle6.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(6);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo7")){
			if(muelle7.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle7);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar7")){
			if(muelle7.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle7);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar7")){
			if(muelle7.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(7);
				} else {
				  //Do Nothing
				}
			}
		}
		
		if(e.getActionCommand().equals("ButtonInfo8")){
			if(muelle8.getOcupado()==1){
				InformacionBarco info = new InformacionBarco(muelle8);
				info.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonGestionar8")){
			if(muelle8.getOcupado()==1){
			GestionBarco gestion = new GestionBarco(muelle8);
			gestion.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("ButtonDescargar8")){
			if(muelle8.getOcupado()==1){
				int opcion = JOptionPane.showConfirmDialog(null, "Está seguro de querer descargar este carguero?\n Se vaciará todo el inventario.", "Aviso", JOptionPane.YES_NO_OPTION);
				if (opcion == 0) {
				   Consultas.deleteInventario(8);
				} else {
				  //Do Nothing
				}
			}
		}
		
		
		//Cerramos la aplicación
		if(e.getActionCommand().equals("ButtonCerrar")){
				System.exit(0);
		}
		//Lanzamos la interfaz de insercion de barcos
		if(e.getActionCommand().equals("ButtonNuevo")){

			InsertarBarco ib = new InsertarBarco();
			ib.setVisible(true);
		}
		//Abrimos la interfaz de mostrar reportes
		if(e.getActionCommand().equals("ButtonReporte")){
			InterfazReporte rep = new InterfazReporte();
			rep.setVisible(true);
		}
		
	
	
	}

}
