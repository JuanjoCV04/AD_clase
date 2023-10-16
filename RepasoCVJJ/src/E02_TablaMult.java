import java.util.Scanner;

public class E02_TablaMult {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce un numero del 1-30000:");
		 int num = teclado.nextInt();
		 if (num <= 0 || num > 30000) {
			 System.err.println("Numero fuera de rango");
			 
		 }else {
			 for (int i = 1; i <= 10; i++) {
					System.out.println( num+" X "+ i +"= "+num * i);
				} 
		 }
		
	}

}
