import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio7 {
		
		static String usuario;
		static String password;
		static String servidor;
		static int puerto;
		static Boolean power;
		static LocalDate fecha;
		private static Properties conf = new Properties();
		public static void main(String[] args) {
			creaConfiguracion();
			System.out.println("DOCUMENTO ORIGINAL\n");
			leeConfiguracion();
			modificaConfiguracion();
			System.out.println("DOCUMENTO MODIFICADO\n");
			leeConfiguracion();
		}

		private static void creaConfiguracion() {
			// TODO Auto-generated method stub
			
			conf.setProperty("user", "usuario");
			conf.setProperty("password", "micontrasena");
			conf.setProperty("server", "localhost");
			conf.setProperty("port", "3306");
			conf.setProperty("date", "2022-08-11");
			conf.setProperty("power", "true");
			
			try {
				conf.store(new FileOutputStream(Ejercicio3.RUTA_DATOS + "configuracion.props"), "Fichero de configuracion");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		private static void leeConfiguracion() {
			// TODO Auto-generated method stub
			
			Properties conf = new Properties();
			try {
				conf.load(new FileInputStream(Ejercicio3.RUTA_DATOS + "configuracion.props"));
				conf.list(System.out);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		private static void modificaConfiguracion() {
			// TODO Auto-generated method stub
			
			Scanner teclado = new Scanner(System.in);

			System.out.println("MODIFICANDO CONFIGURACIÓN");
			System.out.println("user: ");
			usuario = teclado.nextLine();
			System.out.println("password: ");
			password = teclado.nextLine();
			System.out.println("server: ");
			servidor = teclado.nextLine();
			System.out.println("port: ");
			puerto = Integer.valueOf(teclado.nextLine());
			System.out.println("nuevo mes para la fecha: ");
			int mes = Integer.valueOf(teclado.nextLine());
		
				try {
					conf.load(new FileInputStream(Ejercicio3.RUTA_DATOS + "configuracion.props"));
					
					conf.setProperty("user", usuario);
					
					conf.setProperty("password", password);
					
					conf.setProperty("server", servidor);

					int portValue = Integer.valueOf(conf.getProperty("port")) + puerto;
					conf.setProperty("port", String.valueOf(portValue));
					
					conf.setProperty("date", String.valueOf(LocalDate.parse(conf.getProperty("date")).withMonth(mes)));
					
					conf.setProperty("power", String.valueOf(!Boolean.valueOf(conf.getProperty("power"))));
					
					conf.store(new FileOutputStream(Ejercicio3.RUTA_DATOS + "configuracion.props"), "Fichero de configuracion");

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}

		
		
	}


