package Controlador;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.SessionFactoryUtil;



public class MenuPuerto {
	
	public static SessionFactory sesion;
	public static Session session;
	public static Iterator iter;
	
	/*public static String nombreE="", 
			nombreD="", 
			nombreCiclista="",
			salida="",
			llegada="";
			*/
	
	/*public static Equipo equipo;
	
	public static Ciclista ciclista;
	
	public static Etapa etapa1;
	*/
	
	public static void main (String [] args){
		
		sesion = SessionFactoryUtil.getSessionFactory();
		session = sesion.openSession();
		session.beginTransaction();
		
		
	}


}
