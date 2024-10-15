import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {
	
	public final static String DATOSFILEIN = "imagen.jpg";
	private final static String DATOSFILEOUT = "imagen_copia.jpg";
	private final static String DATOSFILEOUT2 = "imagen_copia2.jpg";
	
	public static void main(String[] args) {
		
		try {
			
			FileInputStream fIS = new FileInputStream(new File (Ejercicio3.RUTA_DATOS + DATOSFILEIN));
		
			FileOutputStream fOS = new FileOutputStream(new File (Ejercicio3.RUTA_DATOS + DATOSFILEOUT));
			
			FileInputStream fIS2 = new FileInputStream(new File (Ejercicio3.RUTA_DATOS + DATOSFILEIN));
			
			FileOutputStream fOS2 = new FileOutputStream(new File (Ejercicio3.RUTA_DATOS + DATOSFILEOUT2));
			
			
			//op1
			int leido;
			
			while((leido = fIS.read()) != -1) {
				fOS.write(leido);
			}
			
			//op2
			fOS2.write(fIS2.readAllBytes());
			
			fIS.close();
			fOS.close();
			fOS2.close();
			fIS2.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: El fichero no existe");
			e.printStackTrace();
			
		}catch (IOException e) {
			System.out.println("ERROR: El fichero de lectura");
			e.printStackTrace();
		}
	
	}
	
}


