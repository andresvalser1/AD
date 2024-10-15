import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5Optimizado {
	
	public static final int TAMANIO = 4;
	public static RandomAccessFile RFile;
	private final static String DATOSFILEOUT = "FicheroAleatorio.dat";
	
	public static void main(String[] args) {
		
		escribir();
		menu();
		
	}	
	
	public static int escribir() {
		
		try {
			RandomAccessFile RFile = new RandomAccessFile(new File (Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "rw");
			int i;
			
			for (i = 1; i < 100; i++)
				
				RFile.writeInt(i);
			
			RFile.close();
			
			return i;
			
		} catch (FileNotFoundException e) {
			System.out.println("Error de apertura/creacion fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de escritura");
			e.printStackTrace();
		}
		return 0;
		
	}
	

	public static int leer() {
	
		try {
			
			int i= 0;
			RFile.seek(0);
			RandomAccessFile RFile = new RandomAccessFile(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "r");

			while(RFile.getFilePointer() != RFile.length()) {
				System.out.println( RFile.readInt() + " ");
				i++;
				
			}
			return i;
			
		}catch (FileNotFoundException fnf) {
			System.out.println("No se encuentra el fichero");
		}catch (IOException io) {
			 System.out.println("Error de entrada/salida");
		}
		return 0;
	}
	
	public static void consultar(int lugar) {
		try {
			int i, posicion;
			RandomAccessFile RFile = new RandomAccessFile(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "r");
			
			posicion = (lugar - 1) * TAMANIO; 
			if (posicion >= RFile.length())
				System.out.println("No exite ningún valor en la posición: " + lugar);
			else {
				RFile.seek(posicion);
				System.out.println("Valor en la posición " + lugar + ": " + RFile.readInt());
			}
			RFile.close();
		}catch (FileNotFoundException fnf) {
			System.out.println("No se encuentra el fichero");
		}catch (IOException io) {
			 System.out.println("Error de entrada/salida");
		}
	}
	

	public static void anadirFinal(int valor) {
		try {
			RandomAccessFile RFile = new RandomAccessFile(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "rw");
			
			RFile.seek(RFile.length());	
			RFile.writeInt(valor);
			RFile.close();
		}catch (FileNotFoundException fnf) {
			System.out.println("No se encuentra el fichero");
		}catch (IOException io) {
			 System.out.println("Error de entrada/salida");
		}
	}
	
	public static void modificarValor(int valor, int lugar) {
		try {
			RandomAccessFile RFile = new RandomAccessFile(new File(Ejercicio3.RUTA_DATOS + DATOSFILEOUT), "rw");
			
			long posicion = (lugar - 1) * TAMANIO;
			RFile.seek(posicion);	
			RFile.writeInt(valor);
			RFile.close();
		}catch (FileNotFoundException fnf) {
			System.out.println("No se encuentra el fichero");
		}catch (IOException io) {
			 System.out.println("Error de entrada/salida");
		}
	}
	
	
	public static void menu() {
		 Scanner sn = new Scanner(System.in);
	     boolean salir = false;
	     int opcion, posicion, valor;
	    
	     while (!salir) {
	    	 System.out.println("\n1. Leer fichero ");
	    	 System.out.println("2. Consultar");
	    	 System.out.println("3. Añadir al final");
	    	 System.out.println("4. Modificar valor");
	    	 System.out.println("5. Salir");
	    	 try {
	    		 System.out.println("Escribe una de las opciones");
	    		 opcion = sn.nextInt();
	    		 switch (opcion) {
	    		 case 1:
	    			 System.out.println("LEYENDO CONTENIDO DEL FICHERO\n");
	    			 leer();
	    			 break;
	    		 case 2:
	    			 System.out.println("CONSULTANDO EL FICHERO");
	    			 System.out.print("Indique la posición a consultar (valor numérico entre 1 y 100): ");
	    			 posicion = sn.nextInt();
	    			 consultar(posicion);
	    			 break;
	    		 case 3:
	    			 System.out.println("AÑADIENDO EL ELEMENTO AL FINAL DEL FICHERO");
	    			 System.out.print("Indique el valor numérico a añadir: ");
	    			 valor = sn.nextInt();
	    			 anadirFinal(valor);
	    			 break;
	    		 case 4:
	    			 System.out.println("MODIFICANDO EL VALOR DE LA POSICIÓN");
	    			 System.out.print("Indique la posición a modificar (valor numérico entre 1 y 100): ");
	    			 posicion = sn.nextInt();
	    			 System.out.print("Indique un nuevo valor numérico para la posición: " + posicion);
	    			 valor = sn.nextInt();
	    			 modificarValor(valor, posicion);
	    			 break;
	    		 case 5:
	    			 salir = true;
	    			 break;
	    		 default:
	    			 System.out.println("Solo números entre 1 y 5");
	    		 }
	    	 } catch (InputMismatchException e) {
	    		 System.out.println("Debes insertar un número");
	    		 sn.next();
	    	 }
	     }
	 }
	
}
