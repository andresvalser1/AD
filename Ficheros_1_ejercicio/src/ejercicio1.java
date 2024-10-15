

import java.io.File;
import java.util.Iterator;

public class ejercicio1 {
	
	public static void main(String[] args) {
		
		File dirActual = new  File(System.getProperty("user.dir"));
		File[] hijos = dirActual.listFiles();
		System.out.println("Nombre del directorio de trabajo actual: " + dirActual.getName() + " tiene " + hijos.length + " Ficheros o directorios contenidos \n\t Contenido: ");
		
			
			for (File file : hijos) {
				
				System.out.println("\t" + file.getName() + "\t" + (file.isDirectory() ? " F" : " D"));
			}
			
		
	}

}
