import java.util.Iterator;
import java.util.Scanner;
//Pide 5 números, los muestra, muestra la suma y los muestra en orden inverso
public class Ejercicio07 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int datos[] = new int [5];
		
		for (int i = 0; i < datos.length; i++) {
			System.out.println("Escribe un numero: ");
			datos[i] = teclado.nextInt();
		}
		
		int suma = 0;
		System.out.println("Sumando datos...");

		for (int i = 0; i < datos.length; i++) {
			suma += datos[i];
			System.out.println(suma + "");
		}
		
	}
}
