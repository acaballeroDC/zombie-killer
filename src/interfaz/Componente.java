package interfaz;

import javax.swing.JPanel;

public abstract class Componente extends JPanel {
	protected InterfazZombieKiller m;
    // -------------------------------
    public Componente() {
    }
    // -------------------------------
     public InterfazZombieKiller getMediador()
    {
        return this.m;
    }
    // -------------------------------
     public void setMediador( InterfazZombieKiller m )
    {
        this.m = m;
    }
}
