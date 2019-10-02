
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex8 {

	// declaramos el map
	static Map<String, Float> videojocs = new TreeMap<String, Float>();

	// main
	public static void main(String[] args) throws IOException {
		menu();
	}

	// metodo con el menu donde llamamos con un switch
	public static void menu() throws IOException {
		int i = 0;
		while (i != 7) {
			Scanner lector = new Scanner(System.in);
			System.out.println("\n-----MENU VIDEOJOCS-----");
			System.out.println("1 - Introduir element");
			System.out.println("2 - Modificar preu element");
			System.out.println("3 - Eliminar element");
			System.out.println("4 - Mostrar tots els elements");
			System.out.println("5 - Insertar contingut del maps en un fitxer");
			System.out.println("6 - Insertar contingut del fitxer en el maps");
			System.out.println("7 - Finalitzar");
			System.out.println("Tria una opcio:");
			if (lector.hasNextInt()) {
				i = lector.nextInt();
				if (i > 0 && i < 8) {
					switch (i) {
					case 1:
						introduirElement();
						break;
					case 2:
						modificarElement();
						break;
					case 3:
						eliminarElement();
						break;
					case 4:
						mostrarElements();
						break;
					case 5:
						mapsFitxer();
						break;
					case 6:
						fitxerMaps();
						break;
					default:
						System.out.println("Adeu!");
						break;
					}
				} else {
					System.out.println("Error! Valor incorrecte.");
				}
			} else {
				System.out.println("Error! Ha de ser numeros.");
			}
		}
	}

	// metodo para introducir un elemento
	public static void introduirElement() {
		String joc, valor;
		Scanner lector = new Scanner(System.in);
		do {
			System.out.println("\nIntrodueix el nom del videojoc:");
			joc = lector.nextLine();
		} while (lletres(joc) == false);
		if (videojocs.containsKey(joc.toLowerCase()) == false && videojocs.containsKey(joc.toUpperCase()) == false) {
			do {
				System.out.println("Introdueix el preu del videojoc:");
				valor = lector.nextLine();
			} while (numeros(valor) == false);
			float preu = Float.parseFloat(valor);
			videojocs.put(joc, preu);
		} else
			System.out.println("El videojoc '" + joc + "' ja existeix.");
	}

	// metodo para modificar el precio de un elemento
	public static void modificarElement() {
		String joc, valor;
		int elements = videojocs.size();
		if (elements != 0) {
			Scanner lector = new Scanner(System.in);
			do {
				System.out.println("\nEscriu el nom del videojoc que vols modificar el preu:");
				joc = lector.nextLine();
			} while (lletres(joc) == false);
			if (videojocs.containsKey(joc) == true) {
				System.out.println("El preu actual del videojoc '" + joc + "' es " + videojocs.get(joc) + " €");
				do {
					System.out.println("Introdueix el nou preu:");
					valor = lector.nextLine();
				} while (numeros(valor) == false);
				float preu = Float.parseFloat(valor);
				videojocs.put(joc, preu);
				System.out.println("Preu del videojoc '" + joc + "' actualitzat!");
			} else {
				System.out.println("No hi ha cap videojoc amb aquest nom!");
			}
		} else {
			System.out.println("No hi ha elements!");
		}
	}

	// metodo para eliminar un elemento pidiendo el nombre
	public static void eliminarElement() {
		String joc, resposta;
		int elements = videojocs.size();
		if (elements != 0) {
			Scanner lector = new Scanner(System.in);
			do {
				System.out.println("\nEscriu el nom del videojoc que vols eliminar:");
				joc = lector.nextLine();
			} while (lletres(joc) == false);
			if (videojocs.containsKey(joc) == true) {
				do {
					System.out.println("Estas segur d'eliminar el videojoc '" + joc + "'?");
					resposta = lector.nextLine();
					if (!resposta.equalsIgnoreCase("si") && !resposta.equalsIgnoreCase("no"))
						System.out.println("Escriu SI o NO.");
				} while (!resposta.equalsIgnoreCase("si") && !resposta.equalsIgnoreCase("no"));
				if (resposta.equalsIgnoreCase("si")) {
					videojocs.remove(joc);
					System.out.println("Videojoc '" + joc + "' eliminat!");
				}
			} else {
				System.out.println("No hi ha cap videojoc amb aquest nom!");
			}
		} else {
			System.out.println("No hi ha elements!");
		}
	}

	// metodo para mostrar todos los elementos ordenados alfabeticamente
	public static void mostrarElements() {
		int elements = videojocs.size();
		if (elements != 0) {
			String clave;
			System.out.println("\nMostrant tots els productes ordenats alfabeticament.");
			Iterator<String> it = videojocs.keySet().iterator();
			while (it.hasNext()) {
				clave = it.next();
				System.out.println(clave + " --> " + videojocs.get(clave) + " €");
			}
		} else {
			System.out.println("No hi ha elements!");
		}
	}

	// metodo boolean para comprobar que solo escribe letras
	public static boolean lletres(String videojoc) {
		if (!videojoc.matches("[a-zA-Z]*") || videojoc == null || videojoc.isEmpty()) {
			System.out.println("Error! Ha de ser lletres i no pot ser null.");
			return false;
		} else
			return true;
	}

	// metodo boolean para comprobar que solo escribe numeros
	public static boolean numeros(String diners) {
		if (diners.matches("[-+]?[0-9]*\\.?[0-9]+"))
			return true;
		else {
			System.out.println("Error! Ha de ser numeros.\n");
			return false;
		}
	}

	// metodo para insertar los datos del maps al fichero
	public static void mapsFitxer() throws IOException {
		int elements = videojocs.size();
		if (elements != 0) {
			// Creamos el fichero
			File fichero = new File("..\\UF1_Pt2\\src\\videojocs.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
			System.out.println("Dades insertades del maps al fitxer.");
			bw.close();
			// Escribimos los datos en el fichero
			String clave;
			Iterator<String> it = videojocs.keySet().iterator();
			PrintWriter pw = new PrintWriter(fichero);
			while (it.hasNext()) {
				clave = it.next();
				pw.println(clave + " --> " + videojocs.get(clave) + " €");
			}
			pw.close();
		} else {
			System.out.println("No hi ha elements!");
		}
	}

	// metodo para insertar los datos del fichero al maps
	public static void fitxerMaps() {
		File fichero = new File("..\\UF1_Pt2\\src\\videojocs.txt");
		if (fichero.exists()) {
			Scanner lector = null;
			try {
				lector = new Scanner(fichero);
				// Leemos linea a linea el fichero
				while (lector.hasNextLine()) {
					String linea = lector.nextLine(); // Guardamos la linea
					// Guardamos la clave
					String[] partes = linea.split(" --> ");
					// Guardamos la clave
					String[] valor = partes[1].split(" €");
					float precio = Float.parseFloat(valor[0]);
					videojocs.put(partes[0], precio);
				}
				System.out.println("Dades insertades del fitxer al maps.");
				String clave;
				System.out.println("\nMostrant tots els productes ordenats alfabeticament.");
				Iterator<String> it = videojocs.keySet().iterator();
				// Mostramos los datos del maps
				while (it.hasNext()) {
					clave = it.next();
					System.out.println(clave + " --> " + videojocs.get(clave) + " €");
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
		} else {
			System.out.println("No existeix el fitxer o esta buit!");
		}
	}
}
