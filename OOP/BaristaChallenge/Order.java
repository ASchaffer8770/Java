import java.util.ArrayList;

public class Order {

    //field
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(){
        this.name = "Guest";
        this.ready = false;
    }

    public Order(String name) {
        this.name= name;
        this.ready = false;
    }

    public String getName(){
        return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready == true) {
            return "Your order is now ready!";
        } else {
            return "Thank you for your patience, your order will be out shortly.";
        }
    }

    public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items) {
            total += i.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.printf("Customer Name: %s  ", this.name);
        for(Item i: this.items) {
            System.out.println(i.getName() + " -$" + i.getPrice());
        }
        System.out.println("Total: $" + this.getOrderTotal());
    }

}