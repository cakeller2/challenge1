package challenge1;

public class Item {
    
    String itemName;
    String category;
    String name;
    String email;
    double price;

    public Item(String itemName, String category, String name, String email, double price){

        this.itemName = itemName;
        this.category = category;
        this.name = name;
        this.email = email;
        this.price = price;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public double getPrice() {
        return this.price;
    }
}
