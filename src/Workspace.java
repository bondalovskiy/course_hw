import java.io.Serializable;

class Workspace implements Serializable {
    int id;
    String name;
    double price;
    boolean isAvailable;

    public Workspace(int id, String type, double price, boolean isAvailable) {
        this.id = id;
        this.name = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Available: " + isAvailable;
    }
}