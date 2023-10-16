package E04_Motor;

public class Motor {

	int cubicajeCC;
	int potenciaCV;
	int limiteKm = 300000;
	int rodaduraKm = 0;

	public Motor(int cubicajeCC, int potenciaCV, int limiteKm, int rodaduraKm) {
		this.cubicajeCC = cubicajeCC;
		this.potenciaCV = potenciaCV;
		this.limiteKm = limiteKm;
		this.rodaduraKm = rodaduraKm;
	}

	public Motor() {
	}

	public void rodar(int km) {
		this.rodaduraKm += km;
		if (this.rodaduraKm > this.limiteKm) {
			System.out.println("oh oh Problema con el motor");
		}else {
			System.out.println("Sin problemas en el motor");

		}
	}

	public void print() {
		System.out.println("Cubicaje: " + this.cubicajeCC+ " Potencia: " + this.potenciaCV+ " Limite km: "+this.limiteKm+ " Rodadura: " +this.rodaduraKm);
	}
	
	public void println() {
		System.out.println("Cubicaje: " + this.cubicajeCC+ " Potencia: " + this.potenciaCV+ " Limite km: "+this.limiteKm+ " Rodadura: " +this.rodaduraKm+"\n");
	}
	
}
