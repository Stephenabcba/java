import java.util.ArrayList;
public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name,price);
        newItem.setIndex(menu.size());
        this.menu.add(newItem);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.printf("%d %s -- $%.2f\n",item.getIndex(), item.getName(),item.getPrice());
        }
    }

    public void newOrder() {
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // Your code:
        // Create a new order with the given input string
        Order newOrder = new Order(name);
        this.orders.add(newOrder);
        // Show the user the menu, so they can choose items to add.
        this.displayMenu();
        
        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            int itemNumberInt = Integer.parseInt(itemNumber);
            Item item = this.menu.get(itemNumberInt);
            newOrder.addItem(item);
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
        newOrder.display();
        // as the example below. You may use the order's display method.
    }

}