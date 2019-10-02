
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FrasesMatrix {

	public static void main(String[] args) throws IOException {
		// Creamos el fichero
		File fichero = new File("..\\UF1_Pt2\\src\\frasesMatrix.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
		System.out.println("Fichero frasesMatrix creado.");
		bw.close();
		// Escribimos en el fichero
		FileWriter fw = new FileWriter(fichero);
		fw.write("Yo sólo puedo mostrarte la puerta, tú eres quien la tiene que atravesar.");
		fw.close();
	}
}
