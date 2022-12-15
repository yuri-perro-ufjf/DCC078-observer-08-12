import java.util.Observable;

public class Furnace extends Observable {
    private String itemType;
    private Integer itemQuantity;

    public Furnace(String itemType, Integer itemQuantity) {
        this.itemType = itemType;
        this.itemQuantity = itemQuantity;
    }

    public void finishItems() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Furnace finish item {" +
                "Item type=" + itemType +
                ", Item quantity=" + itemQuantity +
                '}';
    }
}
