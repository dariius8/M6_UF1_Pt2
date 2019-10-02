
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MyFiles {

	public static void main(String[] args) throws IOException {
		// Creamos el directorio
		File directorio = new File("..\\UF1_Pt2\\src\\myFiles");
		directorio.mkdir();
		System.out.println("Directorio myFiles creado.");

		// Creamos el fichero 1
		File fichero1 = new File("..\\UF1_Pt2\\src\\myFiles\\fichero1.txt");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(fichero1));
		System.out.println("Fichero1 creado.");
		bw1.close();

		// Creamos el fichero 2
		File fichero2 = new File("..\\UF1_Pt2\\src\\myFiles\\fichero2.txt");
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(fichero2));
		System.out.println("Fichero2 creado.");
		bw2.close();

		// Creamos el fichero y lo renombramos
		File ficheroRenombrado = new File("..\\UF1_Pt2\\src\\myFiles\\ficheroRenombrado.txt");
		if (fichero2.renameTo(ficheroRenombrado))
			System.out.println("Fichero2 renombrado.");
		else
			System.out.println("No se ha podido renombrar el fichero.");

		// Mostramos el contenido del directorio
		String[] elementos = directorio.list();
		System.out.println("Contenido del directorio: " + Arrays.toString(elementos));

		// Borramos el fichero 1
		if (fichero1.delete())
			System.out.println("Fichero1 borrado.");
		else
			System.out.println("No se ha podido borrar el fichero.");

		// Mostramos el contenido del directorio
		String[] elementos2 = directorio.list();
		System.out.println("Contenido del directorio: " + Arrays.toString(elementos2));
	}
}
