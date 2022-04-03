package mundo;

public class ArmaDirector {
	private ArmaBuilder  armaBuilder;
	
	public void setBuilder(ArmaBuilder armaBuilder) {
		this.armaBuilder=armaBuilder;
	}
	public Arma createArma() {
		return this.armaBuilder.GetArma();
	}
	
}
