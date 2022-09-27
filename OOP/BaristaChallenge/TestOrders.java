import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        //Menu Items
        Item item1 = new Item("Capuccino", 3.75);
        Item item2 = new Item("Mocha", 4.50);
        Item item3 = new Item("Latte", 3.75);
        Item item4 = new Item("Drip Coffee", 2.75);
        
        //Create 2 orders for guests with no name

        Order order1 = new Order();
        Order order2 = new Order();

        //Create 3 orders with overloaded Constructor to give a name for each order
        Order order3 = new Order("Alex");
        Order order4 = new Order("Kat");
        Order order5 = new Order("Tyler");

        //Add 2 items to each of the orders using addItem Method

        order1.addItem(item1);
        order1.addItem(item4);

        order2.addItem(item3);
        order2.addItem(item2);

        order3.addItem(item3);
        order3.addItem(item3);

        order4.addItem(item4);
        order4.addItem(item3);

        order5.addItem(item1);
        order5.addItem(item2);

        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        //testing order status by changing ready status to true

        // order1.setReady(true);
        System.out.println(order1.getStatusMessage());
        //Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
        System.out.println(order1.getOrderTotal());

        order3.addItem(item1);
        order3.addItem(item4);
        order3.addItem(item2);
        order3.display();

    }
}