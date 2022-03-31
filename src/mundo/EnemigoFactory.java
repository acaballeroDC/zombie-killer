package mundo;

public final class EnemigoFactory{

	
	
	private EnemigoFactory() {}
	
	public static Enemigo createEnemigo(String tipo) {
		Enemigo enemigo;

		if(tipo=="Rastrero") {
			enemigo = new Rastrero();
		}
		else if(tipo=="Boss"){
			enemigo = new Boss();
		}
		else{
			enemigo = new Caminante();
		}
			
		return enemigo;
	}
	
	public static Enemigo createEnemigo(String tipo, byte salud) {
		Enemigo enemigo;
		if(tipo=="Rastrero") {
			enemigo = new Rastrero();
		}
		else if(tipo=="Boss"){
			enemigo = new Boss(salud);
		}
		else{
			enemigo = new Caminante();
		}
			
		return enemigo;
	}
	
	public static Enemigo createEnemigo(String tipo, short level, Zombie zombie) {
		Enemigo enemigo;
		if(tipo=="Rastrero") {
			enemigo = new Rastrero(level, zombie);
		}
		else if(tipo=="Boss"){
			enemigo = new Boss();
		}
		else{
			enemigo = new Caminante(level, zombie);
		}
			
		return enemigo;
	}

}
