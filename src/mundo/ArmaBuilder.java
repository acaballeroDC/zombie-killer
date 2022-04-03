package mundo;

public  class ArmaBuilder implements IArmaBuilder {
	protected Arma arma;
	
	public ArmaBuilder(String tipoArma) {
		switch (tipoArma) {
		case "Cuchillo": {
			this.arma= new Cuchillo();
			break;
		}
		case "Granada": {
			this.arma= new Granada();
			break;
		}
		case "M1911": {
			this.arma= new M1911();
			
			break;
		}
		case "Remington": {
			this.arma= new Remington();
			
			break;
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
