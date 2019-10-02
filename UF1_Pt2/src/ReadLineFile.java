
import java.io.File;
import java.util.Scanner;

public class ReadLineFile {

	public static void main(String[] args) {

		// Fichero que queremos leer
		File fichero = new File("..\\UF1_Pt2\\src\\ReadLineFile.java");
		Scanner lector = null;
		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			lector = new Scanner(fichero);
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
