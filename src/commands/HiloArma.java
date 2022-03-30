package commands;

import interfaz.InterfazZombieKiller;
import mundo.Arma;
import mundo.ArmaDeFuego;
import mundo.Remington;

public class HiloArma extends Thread {
	private Arma weapon;
	private InterfazZombieKiller principal;

	public HiloArma(InterfazZombieKiller inter, Arma weapon) {
		this.weapon = weapon;
		principal = inter;
	}

	@Override
	public void run() {
		try {
			if (weapon instanceof ArmaDeFuego) {
				ArmaDeFuego deFuego = (ArmaDeFuego) weapon;
				if (deFuego.isEnsangrentada()) {
					sleep(100);
					principal.terminarEfectoDeSangre();
				}
				if (weapon.getEstado().equals(ArmaDeFuego.RECARGANDO)) {
					// Descanso mientras suena el disparo
					sleep(200);
					if (weapon instanceof Remington && deFuego.getMunicion() > 0)
						principal.reproducir("recarga_escopeta");
				} else
					principal.reproducir(Arma.CARGANDO + weapon.getClass().getSimpleName());
			}
			sleep(weapon.calcularDescanso());
			weapon.setEstado(Arma.LISTA);
			principal.cambiarPuntero();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}