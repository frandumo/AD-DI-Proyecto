package Vista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Imagen {
	
	//Metodo para mostrar la imagen del logo de la aplicación en un JLabel
	public static void setImagenMenu(JLabel label){
		label.setIcon(new ImageIcon(InterfazPuerto.class.getResource("/Vista/LogoBarco.png")));
	}
	
	//Mostrar la imagen correspondiente en un JLabel segun el tamaño del barco o si no hay barco simplemente agua
	public static void setImagenBarco(JLabel label, int i){
		
		if (i==0){
			label.setIcon(new ImageIcon(InterfazPuerto.class.getResource("/Vista/water_waves_ocean_ripple_high_quality_animated_gif.gif")));
		}
		if (i==1){
			label.setIcon(new ImageIcon(InterfazPuerto.class.getResource("/Vista/icono2.jpg")));
		}
		if (i==2){
			label.setIcon(new ImageIcon(InterfazPuerto.class.getResource("/Vista/ship-icon.png")));
		}
		if (i==3){
			label.setIcon(new ImageIcon(InterfazPuerto.class.getResource("/Vista/507217454.jpg")));
		}
		
		
		
	}

}
