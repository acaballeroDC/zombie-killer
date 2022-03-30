package control;

public class HiloAdmin {
    private Thread command;

    public void setCommand(Thread command) {
        this.command = command;
    }

    public void execute() {
        command.start();
    }
}
