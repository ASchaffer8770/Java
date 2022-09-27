import java.util.ArrayList;

public class TestOrders {

    public static void main(String[] args){
        //Items on the menu
        Item item1 = new Item();
        item1.name = "Mocha";
        item1.price = 4.25;

        Item item2 = new Item();
        item2.name = "Latte";
        item2.price = 5.75;

        Item item3 = new Item();
        item3.name = "Drip Coffee";
        item3.price = 2.00;

        Item item4 = new Item();
        item4.name = "Capuccino";
        item4.price = 3.75;

        //Order Variables
        Order order1 = new Order();
        order1.name = "Cindhuri";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        // System.out.println(item1 + order2);

        //Orders

        //add item1 to order2 and increment order total
        order2.items.add(item1);
        order2.total += item1.price;

        //order3 updated and added a capuccino, update total
        order3.items.add(item4);
        order3.total += item4.price;

        //order4 added Latte, update total
        order4.items.add(item2);
        order4.total += item2.price;

        //Cindhuri's order is ready, update status
        order1.ready = true;

        //Sam ordered 2 lattes, update total
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        //Jimmys order is ready, update status
        order2.ready = true;
    }

}