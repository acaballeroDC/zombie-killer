package interfaz;

public interface IInterfazZombieKiller {
	 char getEstadoPartida();
	 void iniciarNuevaPartida();
	 boolean estaCargando();
	 int getPuntajeActual();
	 void cargarJuego();
	 void guardarJuego();
	 void refrescar();
	 void disparar(int posX, int posY);
	 void iniciarGemi2();
	 void generarZombie(int nivel);
	 void leDaAPersonaje();
	 void pausarJuego();
	 void granadaLanzada();
	 void cargarArmaPersonaje();
	 void reproducir(String ruta);
	 void cambiarArma();
	 void cambiarPuntero();
	 void terminarEfectoDeSangre();
	 byte darRondaActual();
	 void subirDeRonda(int nivel);
	 void acuchillar(int x, int y);
	 void generarBoss();
	 void mostrarComoJugar();
	 void mostrarPuntajes();
	 void mostrarCreditos();
	 int darArmaMostrada();
	 int cambiarArmaVisibleDerecha();
	 int cambiarArmaVisibleIzquierda();
	 void juegoTerminado();
	 void victoria();
	 void ordenarPorBajas();
	 void ordenarPorHeadshot();
	 void buscarPorNombre();
	 void ordenarPorScore();
	 
	

}
