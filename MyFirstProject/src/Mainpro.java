import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.List;

class GroceryManagementSystem {
    private static final String FILENAME = "grocery.txt";
    private Map<String, Map<String, List<String>>> groceryItems;
    public Map<String, Map<String, List<String>>> getGroceryItems() {
        return groceryItems;
    }
    
    

    public GroceryManagementSystem() {
        groceryItems = new HashMap<>();
        loadGroceryItems();
    }

    

    public void addGroceryItem(String category, String item, double price, String quantity, String unit) {
        Map<String, List<String>> itemsMap = groceryItems.getOrDefault(category, new HashMap<>());
        List<String> itemDetails = new ArrayList<>();
        itemDetails.add(Double.toString(price)); // convert double to string before adding to list
        itemDetails.add(quantity);
        itemDetails.add(unit);
        itemsMap.put(item, itemDetails);
        groceryItems.put(category, itemsMap);
        saveGroceryItems();
    }

    

    public void deleteGroceryItem(String category, String item) {
        Map<String, List<String>> itemsMap = groceryItems.get(category);
        if (itemsMap != null) {
            itemsMap.remove(item);
            groceryItems.put(category, itemsMap);
            saveGroceryItems();
        }
    }

    public void displayGroceryItems() {
        for (Map.Entry<String, Map<String, List<String>>> categoryEntry : groceryItems.entrySet()) {
            System.out.println(categoryEntry.getKey() + ": ");
            Map<String, List<String>> itemsMap = categoryEntry.getValue();
            for (Map.Entry<String, List<String>> itemEntry : itemsMap.entrySet()) {
                String item = itemEntry.getKey();
                List<String> itemDetails = itemEntry.getValue();
                System.out.println("- " + item + ": Price=" + itemDetails.get(0) + ", Quantity=" + itemDetails.get(1) + ", Unit=" + itemDetails.get(2));
            }
            System.out.println();
        }
    }

    public void buyGroceryItem(String category, String item, int quantity) {
        Map<String, List<String>> itemsMap = groceryItems.get(category);
        if (itemsMap != null) {
            List<String> itemDetails = itemsMap.get(item);
            if (itemDetails != null) {
                double price = Double.parseDouble(itemDetails.get(0));
                int currentQuantity = Integer.parseInt(itemDetails.get(1));
                if (currentQuantity >= quantity) {
                    currentQuantity -= quantity;
                    itemDetails.set(1, String.valueOf(currentQuantity));
                    itemsMap.put(item, itemDetails);
                    groceryItems.put(category, itemsMap);
                    saveGroceryItems();
                    double totalCost = price * quantity;
                    System.out.println("Your Price For " + quantity + " " + item + "s is Rs. " + totalCost);
                } else {
                    System.out.println("Sorry, only " + currentQuantity + " " + item + "(s) available");
                }
            } else {
                System.out.println("Item " + item + " not found in " + category);
            }
        } else {
            System.out.println("Category " + category + " not found");
        }
    }
    
    

    private void loadGroceryItems() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {  // Check that the array has at least two elements
                    String category = parts[0];
                    String[] itemArray = parts[1].split(",");
                    Map<String, List<String>> itemsMap = new HashMap<>();
                    for (String itemDetailsString : itemArray) {
                        String[] itemDetailsArray = itemDetailsString.split("-");
                        if (itemDetailsArray.length >= 4) {  // Check that the array has at least four elements
                            String item = itemDetailsArray[0];
                            String price = itemDetailsArray[1];
                            String quantity = itemDetailsArray[2];
                            String unit = itemDetailsArray[3];
                            List<String> itemDetails = new ArrayList<>();
                            itemDetails.add(price);
                            itemDetails.add(quantity);
                            itemDetails.add(unit);
                            itemsMap.put(item, itemDetails);
                        }
                    }
                    groceryItems.put(category, itemsMap);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading grocery items: " + e.getMessage());
        }
    }

     
    

    private void saveGroceryItems() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Map.Entry<String, Map<String, List<String>>> categoryEntry : groceryItems.entrySet()) {
                String category = categoryEntry.getKey();
                Map<String, List<String>> itemsMap = categoryEntry.getValue();
                StringBuilder itemString = new StringBuilder();
                for (Map.Entry<String, List<String>> itemEntry : itemsMap.entrySet()) {
                    String itemName = itemEntry.getKey();
                    List<String> itemDetails = itemEntry.getValue();
                    String itemStringDetails = itemName + "-" + itemDetails.get(0) + "-" + itemDetails.get(1) + "-" + itemDetails.get(2);
                    itemString.append(itemStringDetails).append(",");
                }
                if (itemString.length() > 0) {
                    itemString.deleteCharAt(itemString.length() - 1);
                }
                bw.write(category + ":" + itemString.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving grocery items to file: " + e.getMessage());
        }
    }
}  


   

    

public class Mainpro {
    public static void main(String[] args) {
        GroceryManagementSystem system = new GroceryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("<<<<<<<<<<<<<<<<<---------------------------------------------------------->>>>>>>>>>>>>>>>>>>");
            System.out.println("                   Welcome to the Grocery Store Management System                             ");
            System.out.println("<<<<<<<<<<<<<<<<<---------------------------------------------------------->>>>>>>>>>>>>>>>>>>");
            System.out.println("1. Display Grocery Items");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("4. Buy Items");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 1:
                    system.displayGroceryItems();
                    break;
                case 2:
                    System.out.println("Enter category (fruits, vegetables, or masalas):");
                    String category = scanner.nextLine();
                    System.out.println("Enter item:"); 
                    String item = scanner.nextLine();
                    System.out.println("Enter price:");
                    double price = Double.parseDouble(scanner.nextLine()); // Use double for price
                    System.out.println("Enter quantity:");
                    String quantity = scanner.nextLine();
                    System.out.println("Enter unit:( In Kg or g )");
                    String unit = scanner.nextLine();
                    system.addGroceryItem(category, item, price, quantity, unit);
                    System.out.println("Item added successfully!");
                    break;
                case 3:
                    System.out.println("Enter category (fruits, vegetables, or masalas):");
                    String categoryToDelete = scanner.nextLine();
                    System.out.println("Enter item:");
                    String itemToDelete = scanner.nextLine();
                    system.deleteGroceryItem(categoryToDelete, itemToDelete);
                    System.out.println("Item removed successfully!");
                    break;
                    case 4:
                    boolean buyMore = true; // initialize buyMore variable
                    int totalBill = 0; // initialize totalBill variable
                    while (buyMore) {
                        System.out.println("Enter category (fruits, vegetables, or masalas):");
                        String categoryToBuy = scanner.nextLine();
                        System.out.println("Enter item:");
                        String itemToBuy = scanner.nextLine();
                        System.out.println("Enter quantity:");
                        int quantityToBuy = Integer.parseInt(scanner.nextLine());
                        int totalPrice = 0; // declare and initialize totalPrice variable
                        system.buyGroceryItem(categoryToBuy, itemToBuy, quantityToBuy);
                        if (quantityToBuy == -1) {
                            System.out.println("Sorry, this item is not available.");
                        } else {
                            // calculate total price
                            Map<String, List<String>> itemsMap = system.getGroceryItems().get(categoryToBuy);
                            List<String> itemDetails = itemsMap.get(itemToBuy);
                            double priceToBuy = Double.parseDouble(itemDetails.get(0));
                            totalPrice = (int) (quantityToBuy * priceToBuy);
                            System.out.printf("Successfully Bought %d %s(s) for Rs. %d\n", quantityToBuy, itemToBuy, totalPrice);
                            System.out.println();
                            totalBill += totalPrice; // add the item's price to the total bill
                        }
                        // ask if the user wants to buy more items
                        System.out.println("Do you want to buy more items? (y/n)");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("n")) {
                            buyMore = false; // set buyMore to false to exit the loop
                        }
                    }
                    // ask if the user wants to see the bill
                    System.out.println("Do you want to see the bill? (y/n)");
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("y")) {
                        // ask for customer details
                        System.out.println("Enter your name:");
                        String name = scanner.nextLine();
                        while (name.matches(".\\d.")) {
                            System.out.println("Invalid input. Please enter a valid name:");
                            name = scanner.nextLine();
                        }
                        
                        System.out.println("Enter your address:");
                        String address = scanner.nextLine();
                        while (address.matches(".\\d.")) {
                            System.out.println("Invalid input. Please enter a valid address:");
                            address = scanner.nextLine();
                        }
                        
                        System.out.println("Enter your phone number:");
                        String phoneNumber = scanner.nextLine();
                        while (phoneNumber.matches(".[a-zA-Z]+.")) {
                            System.out.println("Invalid input. Please enter a valid phone number:");
                            phoneNumber = scanner.nextLine();
                        }
                        // print the bill
                        System.out.println("--------------------------------------------------------");
                        System.out.println("                       Grocery Bill                      ");
                        System.out.println("--------------------------------------------------------");
                        System.out.println("Customer Name: " + name);
                        System.out.println("Customer Address: " + address);
                        System.out.println("Customer Phone Number: " + phoneNumber);
                        System.out.println();                                                           
                        System.out.println("--------------------------------------------------------");
                        System.out.printf("Total Bill: Rs. %d\n", totalBill);
                        System.out.println("--------------------------------------------------------");
                        System.out.println();
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("#########################################################################################");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("<<<<<<<<<<,,,,,,,,,,,,,,,,,,,  THANK YOU for Shopping  ,,,,,,,,,,,,,,,,,,,,,,,,,>>>>>>>>>");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("#########################################################################################");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    break;
                case 5:
                    
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("<<<<<<<<<<,,,,,,,,,,,  THANK YOU for Visiting To Our Grocery Shop  ,,,,,,,,,,,,,>>>>>>>>>");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry!Invalid command");
                    System.out.println();
                    System.out.println("Enter Number between the give choices! ");
                    break;
            }
        }
    }
}
