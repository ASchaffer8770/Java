public class Items {

    //fields
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items;

    //items constructor
    public Items (String name, double total, boolean ready, ArrayList<Item> items) {
        this.name = name;
        this.total = total;
        this.ready = ready;
        this.items = items;
    }
}