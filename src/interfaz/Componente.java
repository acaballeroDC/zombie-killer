package interfaz;

import javax.swing.JPanel;

public abstract class Componente extends JPanel {
	protected IInterfazZombieKiller m;
    // -------------------------------
    public Componente() {
    }
    // -------------------------------
     public IInterfazZombieKiller getMediador()
    {
        return this.m;
    }
    // -------------------------------
     public void setMediador( IInterfazZombieKiller m )
    {
        this.m = m;
    }
}
