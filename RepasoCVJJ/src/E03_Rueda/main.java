package E03_Rueda;

public class main {

	public static void main(String[] args) {

		Rueda r = new Rueda(15,5,8,false,false,30000,6000);
	
		r.println();
		
		r.pinchar();
		
		r.rodar(0);
		
		r.reparar();
		
		r.rodar(1000);
		
		r.print();
	}

}
