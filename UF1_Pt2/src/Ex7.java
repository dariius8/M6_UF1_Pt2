
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex7 {

	public static void main(String[] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		System.out.println("Escribe la ruta del fichero a copiar:");
		// ..\\UF1_Pt2\\src\\ficheroEx7.txt
		String ruta = lector.nextLine();
		File fichero = new File(ruta);
		// Comprobamos que existe el fichero en esa ruta
		if (fichero.exists()) {
			System.out.println("Escribe la ruta del fichero copia:");
			String destino = lector.nextLine();
			// Si existe la ruta creamos un fichero nuevo donde copiaremos todo
			File ficheroCopiado = new File(destino);
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroCopiado));
			PrintWriter pw = new PrintWriter(ficheroCopiado);
			try {
				lector = new Scanner(fichero);
				// Leemos linea a linea el fichero
				while (lector.hasNextLine()) {
					// Guardamos la linea en un String
					// Vamos escribiendo en el fichero copiado
					String linea = lector.nextLine();
					pw.println(linea);
				}
				bw.close();
				pw.close();
				System.out.println("Fichero copiado en '" + destino + "'.");
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
		} else
			System.out.println("La ruta es incorrecta!");
	}
}
