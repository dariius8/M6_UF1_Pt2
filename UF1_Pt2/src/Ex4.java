
import java.io.File;
import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// Comenta una de las rutas (fichero o directorio) para comprobar
		// Fichero
		File elemento = new File("..\\UF1_Pt2\\src\\Ex4.java");
		// Directorio
		// File elemento = new File("..\\UF1_Pt2\\src");
		Scanner lector = null;
		// Si es un fichero lo leemos y si es un directorio mostramos un texto
		if (!elemento.isFile() && elemento.isDirectory())
			System.out.println("'" + elemento + "' no es un fichero, es un directorio.");
		else {
			try {
				// Leemos el contenido del fichero
				System.out.println("... Leemos el contenido del fichero ...");
				lector = new Scanner(elemento);
				// Leemos linea a linea el fichero
				while (lector.hasNextLine()) {
					// Guardamos la linea en un String
					String linea = lector.nextLine();
					// Imprimimos la linea
					System.out.println(linea);
				}
			} catch (Exception ex) {
				System.out.println("Mensaje: " + ex.getMessage());
			} finally {
				// Cerramos el fichero tanto si la lectura ha sido correcta o no
				try {
					if (lector != null)
						lector.close();
				} catch (Exception ex2) {
					System.out.println("Mensaje 2: " + ex2.getMessage());
				}
			}
		}
	}
}
