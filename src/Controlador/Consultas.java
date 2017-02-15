package Controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Barco;
import models.Estancia;
import models.Inventario;
import models.Mercancia;
import models.SessionFactoryUtil;



public class Consultas {
	
	//Instanciar session para conectar con la base de datos
	public static SessionFactory sesion;
	public static Session session;
	public static Iterator iter;
	
	//Formato para dato to string
	static DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	
	public static void init(){
		//Inicializar session
		sesion = SessionFactoryUtil.getSessionFactory();
		session = sesion.openSession();
		session.beginTransaction();
	}
	
	
	//Consultar el tamaño del barco
	public static int getBarcoSize(int muelle){
		
		init();
		int size=0;
		try{
		iter = session.createQuery("from "+Estancia.class.getName()+" where id_muelle = "+muelle).iterate();
		Barco b = null;
		Estancia e = null;
		while(iter.hasNext()){
			
			e = (Estancia) iter.next();
				
		}
		b = e.getBarco();
		
		
		if(b.getSize().equals("pequeño") || b.getSize().equals("Pequeño")){
			size = 1;
		}
		if(b.getSize().equals("mediano") || b.getSize().equals("Mediano")){
			size = 2;
		}
		if(b.getSize().equals("grande") || b.getSize().equals("Grande")){
			size = 3;
		}
		}
		catch(Exception e){
			
		}
		
		return size;
		
	}
	
	//Comprobar si el muelle tiene un barco o no
	public static boolean getBarcoOcupado(int muelle){
		
		init();
		boolean ocupado=false;

		iter = session.createQuery("from "+models.Muelle.class.getName()+" where id_muelle = "+muelle).iterate();
		models.Muelle m = null;
		while(iter.hasNext()){
			
			m = (models.Muelle) iter.next();
				
		}
		
		ocupado = m.getOcupado();
		
		return ocupado;
		
	}
	
	//Consultar barco para tomar los datos
	public static Barco getDatosBarco(int muelle){
		
		init();
		
		Barco barco = new Barco();
		
		iter = session.createQuery("from "+Estancia.class.getName()+" where id_muelle = "+muelle).iterate();
		
		Estancia e = null;
		while(iter.hasNext()){
			
			e = (Estancia) iter.next();
				
		}
		barco = e.getBarco();
		
		return barco;
	}
	
	//Consultar fecha de entrada del barco del muelle introducido
	public static String getFechaEntrada(int muelle){
		
		init();
		
		String fecha = "";
		Date date = null;
		
		iter = session.createQuery("from "+Estancia.class.getName()+" where id_muelle = "+muelle).iterate();
		Estancia e = null;
		while(iter.hasNext()){
			
			e = (Estancia) iter.next();
				
		}
		date = e.getFechaEntrada();
		fecha = df.format(date);
		
		return fecha;
		
	}
	
	//Consultar los valores de las mercancias de un barco
	public static ArrayList<Integer> getMercanciaValue(int id_barco){
		
		init();
		
		ArrayList<Integer> mercancias = new ArrayList<Integer>();
		
		for (int i=0;i<4;i++){
		try{
			iter = session.createQuery("from "+Inventario.class.getName()+" where id_barco = "+id_barco+" and id_mercancia = "+(i+1)).iterate();
			Inventario in = null;
			while(iter.hasNext()){
				
				in = (Inventario) iter.next();
					
			}
			mercancias.add(in.getCantidad());
		}
		catch(Exception e){
			mercancias.add(0);
		}
		
		}
		return mercancias;
	}
	
	//Actualizar mercancias
	public static void modificarInventario(ArrayList<Integer> mercancias, int id_barco){
		
		init();
		
		
		int peso = 0;
		//4 tipos de mercancias, 4 posibles consultas
		for (int i=0;i<4;i++){
			
			//Si la mercancia es null es que no ha habido ningun cambio en la cantidad y por ende no ha habido modificacion de inventario
			if(mercancias.get(i)!=null){
			
				session.beginTransaction();
				//Instanciamos el inventario inicial
				Inventario inventario = null;
				
				//Si ya existe damos a ese inventaro, buscamos el id del inventario existente
				try{
				iter = session.createQuery("from "+Inventario.class.getName()+" where id_barco = "+id_barco+" and id_mercancia = "+(i+1)).iterate();
				Inventario in = null;
				while(iter.hasNext()){
					
					in = (Inventario) iter.next();
						
				}
				
				inventario = (Inventario) session.get(Inventario.class, in.getIdInventario());
				

				//Si no existe dicho inventario dara un error exception y por ello inicializaremos un nuevo inventario
				}catch(Exception e){
				inventario = new Inventario();
				}
			
				//Le ponemos un barco
			Barco barco = (Barco) session.get(Barco.class, id_barco);
			inventario.setBarco(barco);
			
			//Le ponemos una mercancia
			Mercancia mercancia = (Mercancia) session.get(Mercancia.class, (i+1));
			inventario.setMercancia(mercancia);	
			
			
			
			//Le ponemos una cantidad
				inventario.setCantidad(mercancias.get(i));
				
				
				//Le ponemos un peso
				if(i==0){peso = mercancias.get(i)*100;}
				if(i==1){peso = mercancias.get(i)*150;}
				if(i==2){peso = mercancias.get(i)*250;}
				if(i==3){peso = mercancias.get(i)*320;}
				
				inventario.setPeso(peso);
				
				
				//Y guardamos el nuevo inventario, sea creado o modificado
				session.persist(inventario);
				
				session.getTransaction().commit();
				
				
			}
		
		}
	}
	
	//Consultar que muelles están disponibles
	public static ArrayList<Integer> getMuellesDisponibles(){
		
		init();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		iter = session.createQuery("from "+models.Muelle.class.getName()+" where ocupado = 0").iterate();
		models.Muelle m;
		while(iter.hasNext()){
			
			m = (models.Muelle) iter.next();
			
			list.add(m.getIdMuelle());
				
		}
		
		return list;
	}
	
	//Coger los datos del barco e insertarlo en la base de datos
	public static void insertarBarco(int muelle, String nombre, String size, String tipo, int capacidad){
		
		init();
		
		session.beginTransaction();
		
		models.Muelle m = (models.Muelle) session.get(models.Muelle.class, muelle);
		
		m.setOcupado(true);
		session.persist(m);
		
		Barco barco = new Barco();
		
		barco.setNombre(nombre);
		barco.setSize(size);
		barco.setTipo(tipo);
		barco.setTonelaje(capacidad);
		
		
		session.persist(barco);
		
		Estancia estancia = new Estancia();
		
		estancia.setBarco(barco);
		estancia.setMuelle(m);
		Date fechaEntrada = new Date();
		estancia.setFechaEntrada(fechaEntrada);
		estancia.setFechaSalida(null);
		
		session.persist(estancia);
		
		session.getTransaction().commit();
	}
	
	//Consultar el inventario de un barco por su id
	public static String getInventarioById(int id){
		
		init();
		
		String s = "<html>";
		
		iter = session.createQuery("from "+Inventario.class.getName()+" where id_barco = "+id).iterate();
		Inventario i = null;
		while(iter.hasNext()){
			
			i = (Inventario) iter.next();
			
			s=s+"<br>"+i.getBarco().getNombre()+"  "+i.getMercancia().getNombre()+"  "+i.getCantidad()+"  "+i.getPeso();
				
		}
		s=s+"<html>";
		return s;
	}
	
	//Consultar la estancia de un barco por su id
	public static String getEstanciaById(int id){
		
		init();
		
		String s = "<html>";
		String fechaSalida = "";
		
		iter = session.createQuery("from "+Estancia.class.getName()+" where id_barco = "+id).iterate();
		Estancia e = null;
		while(iter.hasNext()){
			
			e = (Estancia) iter.next();
			
			if(e.getFechaSalida()==null){
				fechaSalida = "Atracado";
			}
			else{ fechaSalida = df.format(e.getFechaSalida());}

			s=s+"<br>"+e.getBarco().getNombre()+"  Muelle "+e.getMuelle().getIdMuelle()+"  "+df.format(e.getFechaEntrada())+"  "+fechaSalida;
			
			
		}
		
		s=s+"<html>";
		return s;
	}
	
	
	public static void deleteInventario(int id_muelle){
		
		init();
		
		session.beginTransaction();
		
		iter = session.createQuery("from "+Estancia.class.getName()+" where id_muelle = "+id_muelle).iterate();
		
		Estancia e = null;
		
		while(iter.hasNext()){
			
			e = (Estancia) iter.next();
		
		}
		
		iter = session.createQuery("from "+Inventario.class.getName()+" where id_barco = "+e.getBarco().getIdBarco()).iterate();
		
		Inventario in = null;
		
		while(iter.hasNext()){
			
			
			
			in = (Inventario) iter.next();
			
			session.delete(in);
		
		}
		
		
		
		session.getTransaction().commit();
		
	}


}
