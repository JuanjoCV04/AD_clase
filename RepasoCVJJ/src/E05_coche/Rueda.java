package E05_coche;

public class Rueda extends Motor {

	int diametroPulgadas;
	int anchuraNominal;
	int ratioAspectoPC;
	boolean pinchada = false;
	boolean cambiar = false;
	int limiteKm = 60000;
	int rodadura = 0;
		
	
	public Rueda(int diametroPulgadas, int anchuraNominal, int ratioAspectoPC, boolean pinchada, boolean cambiar,
			int limiteKm, int rodadura) {
		super();
		this.diametroPulgadas = diametroPulgadas;
		this.anchuraNominal = anchuraNominal;
		this.ratioAspectoPC = ratioAspectoPC;
		this.pinchada = pinchada;
		this.cambiar = cambiar;
		this.limiteKm = limiteKm;
		this.rodadura = rodadura;
	}

	
	public Rueda() {
		
	}

	public  boolean pinchar() {
		return this.pinchada = true;
	}
	
	public  boolean reparar() {
		return this.pinchada = false;
	}
	public void rodar(int km) {
		if(this.limiteKm > km && pinchada == false) {
			this.cambiar = true;
			this.rodadura += km;
			System.out.println("Coche en movimiento");
		}else if(pinchada) {
		 System.out.println("El coche no se puede mover, RUEDA PINCHADA");
		}
	}
	
	public void print() {
		System.out.println("Diametro en Pulgadas: " + diametroPulgadas + 
				", Kilometraje del coche: "+ rodadura+
				", Limite de km: " +limiteKm+
				", Anchura nominal: " + anchuraNominal+ 
				", Ratio aspecto PC: " +ratioAspectoPC); 
	}
	
	public void println() {
		System.out.println("Diametro en Pulgadas: " + diametroPulgadas + 
				", Kilometraje del coche: "+ rodadura+
				", Limite de km: " +limiteKm+
				", Anchura nominal: " + anchuraNominal+ 
				", Ratio aspecto PC: " +ratioAspectoPC+"\n"); 
	}
	
}
