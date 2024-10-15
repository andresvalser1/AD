
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio8 {
		
		public static final String SEPARADOR=",";
		public static final String COMILLA="\"$";
		
		
		private final static String DATOSFILE = "ejercicio08.csv";

		public static void main(String[] args) throws IOException {

			BufferedReader br = null;
			
			try {
				
				 br = new BufferedReader(new FileReader(Ejercicio3.RUTA_DATOS+DATOSFILE));
				
				String linea;
				
				while ((linea=br.readLine())!=null) {
					
					String [] datos =  linea.split(SEPARADOR);
					mostrarValores(datos);
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} finally {
				
				if(null!=br) {
					br.close();
				}
				
			}

		}
		
		private static void mostrarValores(String[] fields) {
			
			for (int i=0;i<fields.length;i++){
				System.out.print("\t" + fields[i]);
			}
			
			System.out.println();
			
		}
		
		private static String[] eliminaComillas(String[] fields) {

			String result[] = new String[fields.length];
			
			for (int i=0;i<result.length;i++){
				result[i] = fields[i].trim().replaceAll("^"+COMILLA, "").replaceAll(COMILLA+"$", "");
			}
			
			return result;
			
		}
		
	}

