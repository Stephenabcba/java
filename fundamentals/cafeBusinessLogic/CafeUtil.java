import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double orderTotal = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     orderTotal += prices[i];
        // }
        for (double price: prices) {
            orderTotal += price;
        }
        return orderTotal;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(String.format("%d %s",i, menuItems.get(i)));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.print(String.format("Hello, %s! ",userName));
        System.out.println(String.format("There are %d people in front of you.",customers.size()));
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.println(String.format("%d - $%.2f",i,price*i));
        }
    }
}