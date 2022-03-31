package mundo;

public  class ArmaBuilder implements IArmaBuilder {
	protected Arma arma;
	
	
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
