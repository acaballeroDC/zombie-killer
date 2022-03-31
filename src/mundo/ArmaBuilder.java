package mundo;

public  class ArmaBuilder implements IArmaBuilder {
	protected Arma arma;
	
	public ArmaBuilder(String tipoArma) {
		switch (tipoArma) {
		case "Cuchillo": {
			this.arma= new Cuchillo();
		
		}
		case "Granada": {
			this.arma= new Granada();
			
		}
		case "ArmaFuego": {
			
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoArma);
		}
	}
	
	
	public Arma GetArma() {
		return this.arma;
	}
	
	public  void setTiempoCarga(short tiempoCarga) {
		arma.setTiempoCarga(tiempoCarga);
	}
	public  void setDanio(byte setDanio) {
		arma.setDanio(setDanio);
	}
	public  void setEstado(String estado) {
		arma.setEstado(estado);
	}

}
