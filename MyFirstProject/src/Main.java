public class Main {
    public static void main(String[] args) {
        GroceryStore store = new GroceryStore();
        
        store.addItem(new GroceryItem("Apples", 0.50, 100));
        store.addItem(new GroceryItem("Bananas", 0.25, 50));
        store.addItem(new GroceryItem("Oranges", 0.75, 75));
        
        store.printInventory();
        
        store.updatePrice("Oranges", 1.00);
        store.updateQuantity("Bananas", 75);
        
        store.printInventory();
        
        store.removeItem("Apples");
        
        store.printInventory();
    }
}

