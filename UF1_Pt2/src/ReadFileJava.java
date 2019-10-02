
import java.io.File;
import java.util.Scanner;

public class ReadFileJava {

	public static void main(String[] args) {

		// Fichero que queremos leer
		File fichero = new File("..\\UF1_Pt2\\src\\ReadFileJava.java");
		Scanner lector = null;
		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			lector = new Scanner(fichero);
			while (lector.hasNextLine()) {
				String linea = lector.next();
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
