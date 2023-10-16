package E04_Motor;

public class main {

	public static void main(String[] args) {

		Motor m = new Motor(10,200,300000,0);
		
		m.println();
		m.rodar(3000);
		m.rodar(400000);
		m.print();
		
	}

}
