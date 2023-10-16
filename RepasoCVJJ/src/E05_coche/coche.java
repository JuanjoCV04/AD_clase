package E05_coche;

public class coche extends Motor {

	int rueda1 = 0;
	int rueda2 = 0;
	int rueda3 = 0;
	int rueda4 = 0;

	public coche(int cubicajeCC, int potenciaCV, int limiteKm, int rodaduraKm, int rueda1, int rueda2, int rueda3,
			int rueda4) {
		super(cubicajeCC, potenciaCV, limiteKm, rodaduraKm);
		this.rueda1 = rueda1;
		this.rueda2 = rueda2;
		this.rueda3 = rueda3;
		this.rueda4 = rueda4;
	}

	public void rodar(int km) {
		rodar(km);
		this.rueda1 += km;
		this.rueda2 += km;
		this.rueda3 += km;
		this.rueda4 += km;

		if(this.rueda1 >  limiteKm || this.rueda2 >  limiteKm || this.rueda3 >  limiteKm|| this.rueda4 >  limiteKm) {
			System.out.println("Hay alguna rueda pinchada");
		}
		
		 
		
		
	}
}
