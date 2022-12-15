import java.util.Observable;
import java.util.Observer;

public class Player implements Observer {
    private String name;
    private String lastNotification;

    public Player(String nome) {
        this.name = nome;
    }

    public String getLastNotification() {
        return this.lastNotification;
    }

    public void createFurnace(Furnace furnace) {
        furnace.addObserver(this);
    }

    public void update(Observable furnace, Object arg1) {
        this.lastNotification = this.name + " Notification: " + furnace.toString();
    }
}
