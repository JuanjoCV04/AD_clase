
public class RMatriz3 {

	public static void main(String[] args) {

		int numeros[][][] = { { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
				{ { 10, 11, 12 }, { 13, 14, 15 }, { 16, 17, 18 } },
				{ { 19, 20, 21 }, { 22, 23, 24 }, { 25, 26, 27 } } };
		

		For(numeros);	
		System.out.println("\n\n\n--------------");
		Foreach(numeros);

	}
	public static void For(int numeros[][][]) {
		for (int i = 0; i < numeros.length; i++) {
			System.out.println();
			for (int j = 0; j < numeros.length; j++) {
				System.out.println();
				for (int k = 0; k < numeros.length; k++) {
					System.out.print(numeros[i][j][k] + " ");
				}
			}
		}
		
	}
	
	public static void Foreach(int numeros[][][]) {
		for (int[][] is : numeros) {
			System.out.println();
			for (int[] is2 : is) {
				System.out.println();
				for (int is3 : is2) {
					System.out.print(is3 + " ");
				}
			}
		}
	}


}
