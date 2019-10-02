
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribeLineas {

	public static void main(String[] args) throws IOException {
		// Creamos el fichero
		File fichero = new File("..\\UF1_Pt2\\src\\escribeLineas.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
		System.out.println("Fichero escribeLineas creado.");
		bw.close();
		// Escribimos en el fichero hasta 10 lineas
		System.out.println("Introduce texto, pulsa INTRO para saltar de linea (hasta 10)");
		Scanner lector = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(fichero);
		int contador = 0;
		while (contador != 10) {
			String texto;
			texto = lector.nextLine();
			pw.println(texto);
			contador++;
		}
		lector.close();
		pw.close();
		System.out.println("10 lineas de texto introducidas.");
	}
}
