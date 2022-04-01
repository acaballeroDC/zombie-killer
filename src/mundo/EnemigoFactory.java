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

	public static Enemigo createEnemigo(String tipo, int posX, int posY, int direccionX, int direccionY, String estadoActual, byte frameActual, byte salud, int ronda) {
		Enemigo enemigo;
		if(tipo=="Rastrero") {
			enemigo = new Rastrero();
		}
		else if(tipo=="Boss"){
			enemigo = new Boss();
		}
		else{
			enemigo = new Caminante(posX, posY, direccionX,  direccionY,  estadoActual,  frameActual,  salud,  ronda);
		}
			
		return enemigo;
	}

	public static Enemigo createEnemigo(String tipo, int posX, int posY, String estadoActual, byte frameActual, byte salud, int ronda) {
		Enemigo enemigo;
		if(tipo=="Rastrero") {
			enemigo = new Rastrero( posX,  posY,  estadoActual,  frameActual,  salud,  ronda);
		}
		else if(tipo=="Boss"){
			enemigo = new Boss();
		}
		else{
			enemigo = new Caminante();
		}
			
		return enemigo;
	}

}
