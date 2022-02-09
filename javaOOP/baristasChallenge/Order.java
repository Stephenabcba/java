import java.util.ArrayList;

public class Order {
    // MEMBER VARIABLES
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    // CONSTRUCTOR
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }


    // ORDER METHODS
    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double orderTotal = 0.0;
        for (Item item: this.items) {
            orderTotal += item.getPrice();
        }
        return orderTotal;
    }

    public void display() {
        System.out.printf("Customer Name: %s\n",this.name);
        for (Item item: this.items) {
            System.out.printf("%s - $%.2f\n",item.getName(),item.getPrice());
        }
        System.out.printf("Total: $%.2f\n",this.getOrderTotal());
    }

    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }

    public boolean isReady() {
        return this.ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}