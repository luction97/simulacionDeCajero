import java.util.Scanner;
import java.lang.Math;

public class App {

	public static void main(String[] args) {

		/*
		 * Crear una aplicación que valide el ingreso a la plataforma de Online Banking
		 * a través de una clave Token.
		 * 
		 */

		/*
		 * Se debe tener en cuenta lo siguiente:
		 * 
		 * ● Todo el código debe estar en el método principal (main). 
		 * 
		 * ● La variable Usuario a validar deberá ser el literal administrador. 
		 * 
		 * ● La variable Contraseña a validar deberá ser el literal administrador.1234.
		 * 
		 * ● Para generar el número aleatorio, utilizar la librería java.lang.Math
		 * 
		 * ● La Clave Token debe ser un número aleatorio de 6 dígitos.
		 * 
		 * ● El cliente debe ingresar los campos Usuario, Contraseña y Clave Token
		 * (todos obligatorios).
		 * 
		 * ● El campo Usuario no distingue minúsculas o mayúsculas.
		 * 
		 * ● El campo Contraseña es sensible a las minúsculas y mayúsculas.
		 * 
		 * ● El cliente solo posee 3 intentos de logueo. Si alcanza los 3 intentos
		 * fallidos de forma consecutiva, la aplicación deberá informar al usuario que
		 * debe dirigirse a la sucursal del banco más cercana para poder desbloquear sus
		 * credenciales.
		 * 
		 * ● Por cada intento fallido, la aplicación debe preguntar al cliente si desea
		 * continuar colocando las credenciales de manera correcta.
		 * 
		 * ● Si el cliente coloca las credenciales de forma correcta, deberá informar
		 * que ha ingresado correctamente al Online Banking.
		 * 
		 * usar: datos de entrada (Manejo de la Consola), Variables, Operadores
		 * Relacionales y Lógicos, Condicionales, Ciclos, Métodos de la clase String y
		 * Métodos de la librería Math.
		 * 
		 * 
		 * ------- LISTO -------
		 * 
		 * 
		 * 1. Por cada intento fallido, debe crear una nueva Clave Token.♦
		 * 
		 * 2. Realizar un método para que retorne cada Clave Token. ♦
		 * 
		 * 3. La Clave Token no deberá repetirse, por lo que se debe validar si ya ha
		 * sido suministrada anteriormente en la misma ejecución de la aplicación.
		 * 
		 * 4. Crear un método que valide los datos ingresados por el cliente y retorne
		 * si los datos son correctos o no.
		 * 
		 * 
		 * 5. Crear un método que contenga los ciclos de pregunta de las credenciales
		 * que no posea retorno alguno.
		 * 
		 * 
		 */

		Scanner teclado = new Scanner(System.in);

		String usuario = "administrador";
		String contrasena = "administrador.1234";
		int claveToken = 0;
		int falloSesion = 0;
		int cantidadToken = 0;
		System.out.println("Bienvenido a Online Banking, ingrese las credenciales solicitadas:");
		System.out.println("");
		System.out.println("");
		int[] tokenTotalGen = new int[3];
		int i = 0;
		String rta = "s";
		boolean correcto;

		do {
			// Se generará un nuevo token por cada intento fallido, al reiniciar el bucle
			System.out.println("Generando token automaticamente...");

			for (int e = 0; e <= tokenTotalGen.length; i++) {

				for (int j = 0; j <= tokenTotalGen.length; j++) {
					if (tokenTotalGen[e] != 0) {
						// Comprueba que no se repitan
						if (tokenTotalGen[e] != tokenTotalGen[j]) {
							claveToken = generarTokenRandom(claveToken);
							break;
						}
					}
				}
			}

			for (int t = cantidadToken; t <= cantidadToken; t++) {
				tokenTotalGen[t] = claveToken;
			}

			cantidadToken++;

			System.out.println("");
			System.out.println("Token generado:" + claveToken);
			System.out.println("");

			System.out.println("INGRESE USUARIO");
			String usuarioIngresado = teclado.next();

			System.out.println("INGRESE CONTRASEÑA");
			String contrasenaIngresada = teclado.next();

			System.out.println("INGRESE CLAVE TOKEN");
			int tokenIngresado = teclado.nextInt();

			System.out.println("-Usted ingresó-");
			System.out.println("");
			System.out.println("Usuario: " + usuarioIngresado);
			System.out.println("Contraseña: " + contrasenaIngresada);
			System.out.println("Token: " + tokenIngresado);
			System.out.println("");
			System.out.println("---------------");

			if (correcto = (usuarioIngresado.equalsIgnoreCase(usuario) && contrasenaIngresada.equals(contrasena)
					&& tokenIngresado == claveToken)) {

				System.out.println("- Credenciales correctas, Bienvenido a su Online Banking. -");
				break;
			} else {

				System.out.println("CREDENCIALES INCORRECTAS [!]");
				System.out.println("");
				System.out.println("¿Desea volver a intentar? S/N");
				rta = teclado.next();
			}

			i++;
		} while (i < 3 && !rta.equalsIgnoreCase("n"));

		if (i == 3) {
			System.out.println("Usuario bloqueado, por favor dirijase a la sucursal más cercana.");
		} else if (rta.equalsIgnoreCase("n")) {

			System.out.println("Gracias por utilizar Online Banking");
		}

		teclado.close();

	}

	public static int generarTokenRandom(int claveToken) {
		claveToken = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
		return claveToken;
	}
}
