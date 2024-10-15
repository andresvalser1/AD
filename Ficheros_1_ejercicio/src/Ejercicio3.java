import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio3 {
	
	public final static String RUTA_DATOS = System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"src" +
			System.getProperty("file.separator") +
			"datos" + 
			System.getProperty("file.separator"); 
	private final static String DATOSFILE = "3_Ejercicio.csv";
	public static void main(String[] args) {
		
		try {
			
			BufferedReader bR = new BufferedReader(new FileReader(RUTA_DATOS + DATOSFILE));
			String linea; 
			while((linea = bR.readLine()) != null)
				{
				
					System.out.println(linea);
				
				}
			bR.close();
			
			PrintWriter pW = new PrintWriter(new FileWriter(RUTA_DATOS + DATOSFILE, true));
			System.out.println("Introduce el nombre, apellidos, grupo y curso del alumno(separado por ;) ");
			
			Scanner teclado = new Scanner(System.in);
			
			String info = teclado.nextLine();
			pW.println("" + info + "");
			//pW.println("Andrés;vallejo;DAM;2");

			pW.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: El fichero no existe");
			e.printStackTrace();
			
		} catch (IOException e) {
			System.out.println("ERROR: El fichero de lectura");
			e.printStackTrace();
		}
		
	}

}
