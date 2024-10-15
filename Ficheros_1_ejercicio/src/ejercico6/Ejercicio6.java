package ejercico6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio6 {
	
	public final static String RUTA_DATOS = System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"src" +
			System.getProperty("file.separator") +
			"datos" + 
			System.getProperty("file.separator"); 

	private final static String DATOSFILEOUT = "FicheroAleatorioObjetos.dat";

	public static void EscribirObjeto() {
		Scanner teclado = new Scanner (System.in);
		try {
	
			Persona persona = new Persona();
			ObjectOutputStream datos;

			File file = new File(RUTA_DATOS+DATOSFILEOUT);
			
			if (!file.exists()) {
				datos = new ObjectOutputStream(new FileOutputStream(file));
			}
			else {
				datos = new MyObjectOutputStream(new FileOutputStream(file, true));
			}
			
			System.out.println("DATOS DEL USUARIO \nIntroduce el nombre:");
	        persona.setNombre(new StringBuilder(teclado.nextLine()));
	        System.out.println("Introduce el primer apellido:");
	        persona.setApellido1(new StringBuilder(teclado.nextLine()));
	        System.out.println("Introduce el segundo apellido:");
	        persona.setApellido2(new StringBuilder(teclado.nextLine()));
	        
	        System.out.println("Fecha de nacimiento (dd/MM/yyyy):");
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date fecha;
			try {
				fecha = formatter.parse(teclado.nextLine());
				persona.setNacimiento(fecha);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        
	        datos.writeObject(persona);
			datos.close();
			
		}catch (FileNotFoundException fnf) {
			System.out.println("No se encuentra el fichero");}
		 catch (IOException io) {
			 System.out.println("Error de entrada/salida");}
	}
	
	public static void LeerObjeto() {
		try {
			Persona persona;
			
			ObjectInputStream datos = new ObjectInputStream(new FileInputStream(new File(RUTA_DATOS+DATOSFILEOUT)));
			
			try {
				while (true) {
					persona = (Persona) datos.readObject();
					System.out.println(persona);				
				}
			}catch (EOFException eofe) { 
				
			}catch (ClassNotFoundException cnfe) { 
				System.out.println("Clase no encontrada");
			}
			datos.close();
		}catch (FileNotFoundException fnf) { 
			System.out.println("No se encuentra el fichero");
		}catch (IOException io) {
			System.out.println("Error de entrada/salida");
		}
	}
	
	public static void main(String[] args) {
		EscribirObjeto();
		System.out.println("\n------------------------------------------------------------------------\n");
		LeerObjeto();
	}

}
