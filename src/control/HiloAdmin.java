package control;

import commands.*;
import interfaz.InterfazZombieKiller;
import mundo.Arma;
import mundo.Boss;
import mundo.SurvivorCamp;
import mundo.Zombie;

public class HiloAdmin {
    private String ruta;
    private Arma weapon;
    private Zombie nodoCercano;
    private Boss jefe;
    private InterfazZombieKiller principal;
    private SurvivorCamp campo;

    private Thread command;
    private HiloSonido backgroundSound;

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void setWeapon(Arma weapon) {
        this.weapon = weapon;
    }

    public void setNodoCercano(Zombie nodoCercano) {
        this.nodoCercano = nodoCercano;
    }

    public void setJefe(Boss jefe) {
        this.jefe = jefe;
    }

    public void setPrincipal(InterfazZombieKiller principal) {
        this.principal = principal;
    }

    public void setCampo(SurvivorCamp campo) {
        this.campo = campo;
    }

    public void setCommand(String commandId) {
        switch (commandId) {
            case "arma":
                command = new HiloArma(principal, weapon);
                break;
            case "boss":
                command = new HiloBoss(principal, jefe, campo);
                break;
            case "enemigo":
                command = new HiloEnemigo(principal, nodoCercano, campo);
                break;
            case "generadorZombies":
                command = new HiloGeneradorDeZombies(principal, campo);
                break;
            case "sonido":
                command = new HiloSonido(ruta);
                break;
        }
    }

    public Thread getBackgroundSound() { return backgroundSound; }

    public void setBackgroundSound(String sound) { backgroundSound = new HiloSonido(sound); }

    public void execute() { command.start(); }

    public void executeBackgroundSound() { backgroundSound.start(); }

    public void stopBackgroundSound() { backgroundSound.detenerSonido(); }
}
