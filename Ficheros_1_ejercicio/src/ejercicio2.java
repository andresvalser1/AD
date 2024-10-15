

import java.io.File;
import java.util.Scanner;

public class ejercicio2 {
	
	public static void main(String[] args) {
		
		System.out.println("Introduce el nombre de un fichero o un directorio: ");
		
		Scanner teclado = new Scanner(System.in);
		
		String nom = teclado.nextLine();
		
		File f = new File(nom);
		
		if (f.exists()) {
			
			System.out.println("El fichero o directorio existe.\n");
			System.out.println((f.isFile()?"Fich\t":"Dir\t"));
			infofichero(f);
			
			if (f.isDirectory()) {
					
					File[] hijos = f.listFiles();
					
					for (File file : hijos) {
						
						System.out.println("\t" + file.getName() + "\t" + (file.isDirectory() ? " F" : " D"));
						infofichero(file);
						
					}
					
				}
				
			}
		else {
			
			System.out.println("El fichero o directorio no existe.");
			
		}
		
	}

	private static void infofichero(File f) {

		System.out.println("\t" + (f.isFile() ? f.length() + "\n\t" + (f.canRead()? "R" : ".") + (f.canExecute()? "E":".") + (f.canWrite()?"W":"."):".") + "\n");
		
	}

}
