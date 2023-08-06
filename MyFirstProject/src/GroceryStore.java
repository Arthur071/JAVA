import java.util.ArrayList;

public class GroceryStore {
    private ArrayList<GroceryItem> items;
    
    public GroceryStore() {
        items = new ArrayList<>();
    }
    
    public void addItem(GroceryItem item) {
        items.add(item);
    }
    
    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.remove(i);
                break;
            }
        }
    }
    
    public void updatePrice(String name, double price) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.get(i).setPrice(price);
                break;
            }
        }
    }
    
    public void updateQuantity(String name, int quantity) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(name)) {
                items.get(i).setQuantity(quantity);
                break;
            }
        }
    }
    
    public void printInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < items.size(); i++) {
            GroceryItem item = items.get(i);
            System.out.printf("%s (Price: $%.2f, Quantity: %d)\n", item.getName(), item.getPrice(), item.getQuantity());
        }
    }
}
