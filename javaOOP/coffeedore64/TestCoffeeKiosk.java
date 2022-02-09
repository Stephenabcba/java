public class TestCoffeeKiosk {
    public static void main(String[] args) {
        CoffeeKiosk ck = new CoffeeKiosk();
        ck.addMenuItem("mocha", 2.5);
        ck.addMenuItem("latte", 2.0);
        ck.addMenuItem("drip coffee", 1.5);
        ck.addMenuItem("capuccino", 3.5);
        ck.newOrder();
    }
}